using Dddml.Wms.Domain.DocumentType;
using Dddml.Wms.Domain.InventoryItem;
using Dddml.Wms.Domain.MovementConfirmation;
using Dddml.Wms.Domain.Warehouse;
using Dddml.Wms.Specialization;
using Dddml.Wms.Specialization.NHibernate;
using Spring.Transaction.Interceptor;
using System;
using System.Collections.Generic;

namespace Dddml.Wms.Domain.Movement.NHibernate
{
    public partial class MovementApplicationService
    {
        IInventoryItemApplicationService InventoryItemApplicationService
        {
            get { return ApplicationContext.Current["inventoryItemApplicationService"] as IInventoryItemApplicationService; }
        }

        IMovementConfirmationApplicationService MovementConfirmationApplicationService
        {
            get { return ApplicationContext.Current["movementConfirmationApplicationService"] as IMovementConfirmationApplicationService; }
        }

        private IIdGenerator<long, object, object> _seqIdGenerator = new TableIdGenerator();

        public IIdGenerator<long, object, object> SeqIdGenerator
        {
            get { return _seqIdGenerator; }
            set { _seqIdGenerator = value; }
        }

        [Transaction]
        public override void When(MovementCommands.DocumentAction c)
        {
            if (c.Value == DocumentAction.Complete)
            {
                var mov = AssertDocumentStatus(c.DocumentNumber, DocumentStatusIds.Drafted);
                var inventoryItemEntries = CompleteMovementCreateInventoryItemEntries(mov);
                CreateOrUpdateInventoryItems(inventoryItemEntries);
                if (mov.IsInTransit)
                {
                    var movConfirm = CreateMovementConfirmation(mov);
                    MovementConfirmationApplicationService.When(movConfirm);
                }
                base.When(c);
            }
            else if (c.Value == DocumentAction.Confirm)
            {
                throw new NotSupportedException("Need to confirm MovementConfirmation.");
            }
            else if (c.Value == DocumentAction.Reverse)
            {
                var srcMov = AssertDocumentStatus(c.DocumentNumber, DocumentStatusIds.Completed);
                var reversalMovInfo = CreateReversalMovementAndCompleteAndClose(c, srcMov);
                ReverseUpdateSourceMovement(c, reversalMovInfo);
                //base.When(c);
            }
            else
            {
                base.When(c);
            }
        }

        internal void ConfirmUpdateMovement(MovementCommands.DocumentAction c)
        {
            Update(c, ar => ((MovementAggregate)ar).DocumentAction(DocumentAction.Confirm, c.Version, c.CommandId, c.RequesterId));
        }

        private void ReverseUpdateSourceMovement(MovementCommands.DocumentAction c, ICreateMovement reversalMovInfo)
        {
            //源单据前向关联到反转单据：
            var reversalDocumentNumber = reversalMovInfo.DocumentNumber;
            var description = "(" + reversalMovInfo.DocumentNumber + "<-)";//(1000016<-)
            Update(c, ar => ((MovementAggregate)ar).Reverse(reversalDocumentNumber, description, c.Version, c.CommandId, c.RequesterId));
        }

        /// <summary>
        /// 更新库存单元。
        /// </summary>
        /// <param name="inventoryItemEntries"></param>
        private void CreateOrUpdateInventoryItems(IList<ICreateInventoryItemEntry> inventoryItemEntries)
        {
            var invItemApplicationService = this.InventoryItemApplicationService;
            InventoryItemUtils.CreateOrUpdateInventoryItems(invItemApplicationService, inventoryItemEntries);
        }

        private IMovementState AssertDocumentStatus(string docNumber, string docStatus)
        {
            var mov = StateRepository.Get(docNumber, true);
            if (mov == null)
            {
                throw new ArgumentException(String.Format("Error document number: {0}", docNumber));
            }
            else
            {
                if (docStatus != mov.DocumentStatusId)
                {
                    throw new ApplicationException(String.Format("Error document status: {0}", mov.DocumentStatusId));
                }
            }
            return mov;
        }


        protected virtual IList<ICreateInventoryItemEntry> CompleteMovementCreateInventoryItemEntries(IMovementState movement)
        {
            var invItemEntries = new List<ICreateInventoryItemEntry>();
            foreach (IMovementLineState d in movement.MovementLines)
            {
                ICreateInventoryItemEntry[] trxPair = CompleteMovementCreateInventoryItemEntryPair(movement, d, () => SeqIdGenerator.GetNextId());
                invItemEntries.AddRange(trxPair);
            }

            //////////////////////////////////////////////////
            //排序，出库的事务先执行
            //invItemEntries.Sort(new Comparison<ICreateInventoryItemEntry>((x, y) =>
            //        (x.OnHandQuantity > y.OnHandQuantity) ? 1 :
            //            (x.OnHandQuantity == y.OnHandQuantity ? 0 : -1)));

            return invItemEntries;
        }

        ///// <summary>
        ///// Confirm all movement line quantities.
        ///// </summary>
        //internal IList<ICreateInventoryItemEntry> ConfirmMovementCreateInventoryItemEntries(IMovementState movement)
        //{
        //    Func<IMovementLineState, decimal> getConfirmedQty = d => d.MovementQuantity;
        //    var invItemEntries = ConfirmMovementCreateInventoryItemEntries(movement, getConfirmedQty);
        //    return invItemEntries;
        //}

        private ICreateMovement CreateReversalMovementAndCompleteAndClose(MovementCommands.DocumentAction c, IMovementState movement)
        {
            var createReversalMovement = CreateReversalMovement(movement);

            When(createReversalMovement);
            When(new MovementCommands.DocumentAction
            {
                Value = DocumentAction.Complete,
                DocumentNumber = createReversalMovement.DocumentNumber,
                Version = 1,
                CommandId = c.CommandId,
                RequesterId = c.RequesterId,
            });
            When(new MovementCommands.DocumentAction
            {
                Value = DocumentAction.Close,
                DocumentNumber = createReversalMovement.DocumentNumber,
                Version = 2,
                CommandId = c.CommandId,
                RequesterId = c.RequesterId,
            });

            return createReversalMovement;
        }

        protected virtual ICreateMovement CreateReversalMovement(IMovementState movement)
        {
            var reversalMov = DoCreateReversalMovement(movement);
            
            foreach (var d in movement.MovementLines)
            {
                var r = DoCreateReversalMovementLine(d);
                reversalMov.MovementLines.Add(r);
            }

            return reversalMov;
        }

        /// <summary>
        /// 生成反转的单据（但不包括行）。
        /// </summary>
        protected virtual ICreateMovement DoCreateReversalMovement(IMovementState movement)
        {
            var reversalMov = new CreateMovement();

            //reversalInOut.Organization = inOut.Organization;
            //reversalInOut.Client = inOut.Client;

            //生成新的单号:
            reversalMov.DocumentNumber = "RM" + SeqIdGenerator.GetNextId();//DocumentNumberGenerator.GetNewDocumentNumber();
            //设置反转关系:
            reversalMov.ReversalDocumentNumber = movement.DocumentNumber;
            
            //movement.Reversal = reversalMov;
            //源单据前向关联到反转单据:
            //movement.Description = "(" + reversalMov.DocumentNumber + "<-)";//(1000016<-)

            //反转单据后向关联到源单据:
            reversalMov.Description = "{->" + movement.DocumentNumber + ")";//{->1000015)

            //reversalMov.Posted = movement.Posted;//??
            //reversalMov.Processing = movement.Processing;
            //reversalMov.Processed = movement.Processed;

            reversalMov.DocumentTypeId = movement.DocumentTypeId;
            reversalMov.MovementDate = movement.MovementDate;//???

            reversalMov.ApprovalAmount = movement.ApprovalAmount;
            reversalMov.ChargeAmount = movement.ChargeAmount;
            reversalMov.DateReceived = movement.DateReceived;
            reversalMov.FreightAmount = movement.FreightAmount;
            reversalMov.Active = movement.Active;
            reversalMov.IsInTransit = false;//??
            reversalMov.SalesRepresentativeId = movement.SalesRepresentativeId;
            reversalMov.ShipperId = movement.ShipperId;
            reversalMov.BusinessPartnerId = movement.BusinessPartnerId;
            //reversalMov.User = movement.User;

            reversalMov.WarehouseIdFrom = movement.WarehouseIdFrom;
            reversalMov.WarehouseIdTo = movement.WarehouseIdTo;

            return reversalMov;
        }


        protected virtual ICreateMovementLine DoCreateReversalMovementLine(IMovementLineState movementLine)
        {
            var reversalLine = new CreateMovementLine();
            //reversalLine.Organization = Context.Organization;
            //reversalLine.UpdatedBy = Context.User;
            //reversalLine.UpdateTime = now;
            //reversalLine.CreatedBy = Context.User;
            //reversalLine.CreationTime = now;
            //reversalLine.Processed = movementLine.Processed;//???
            reversalLine.ReversalLineNumber = movementLine.LineNumber;//设置反转行
            reversalLine.ProductId = movementLine.ProductId;
            reversalLine.LocatorIdFrom = movementLine.LocatorIdFrom;
            reversalLine.LocatorIdTo = movementLine.LocatorIdTo;
            reversalLine.AttributeSetInstanceId = movementLine.AttributeSetInstanceId;
            //reversalLine.AttributeSetInstanceTo = movementLine.AttributeSetInstanceTo;

            reversalLine.LineNumber = movementLine.LineNumber;

            //数量反转
            reversalLine.MovementQuantity = -movementLine.MovementQuantity;
            //reversalLine.TargetQuantity = -movementLine.TargetQuantity;
            //reversalLine.ConfirmedQuantity = -movementLine.ConfirmedQuantity;
            //reversalLine.ScrappedQuantity = -movementLine.ScrappedQuantity;

            return reversalLine;
        }


        internal static List<ICreateInventoryItemEntry> ConfirmMovementCreateInventoryItemEntries(IMovementState movement, Func<IMovementLineState, decimal> getConfirmedQty, Func<long> nextEntrySeqId)
        {
            var invItemEntries = new List<ICreateInventoryItemEntry>();
            foreach (IMovementLineState d in movement.MovementLines)
            {
                ICreateInventoryItemEntry[] trxPair = ConfirmMovementCreateInventoryItemEntryPair(movement, d, getConfirmedQty(d), nextEntrySeqId);
                invItemEntries.AddRange(trxPair);
            }
            return invItemEntries;
        }

        internal static ICreateInventoryItemEntry[] CompleteMovementCreateInventoryItemEntryPair(IMovementState movement, IMovementLineState movementLine,
            Func<long> nextEntrySeqId)
        {
            ICreateInventoryItemEntry[] trxPair = new ICreateInventoryItemEntry[2];

            var quantity = movementLine.MovementQuantity;
            /////////////////////// From: ////////////////////////////
            int signum = -1;
            trxPair[0] = CreateInventoryItemEntry(movement, movementLine, movementLine.LocatorIdFrom, quantity * signum, 0, nextEntrySeqId);
            
            /////////////////////// To:   ////////////////////////////
            signum = 1;
            if (!movement.IsInTransit)
            {
                trxPair[1] = CreateInventoryItemEntry(movement, movementLine, movementLine.LocatorIdTo, quantity * signum, 1, nextEntrySeqId);
            }
            else
            {
                var locId = WarehouseUtils.GetInTransitLocatorId(movement.WarehouseIdFrom);
                trxPair[1] = CreateInventoryItemEntry(movement, movementLine, locId, quantity * signum, 1, nextEntrySeqId, true);
            }
            
            return trxPair;
        }

        internal static ICreateInventoryItemEntry[] ConfirmMovementCreateInventoryItemEntryPair(IMovementState movement, IMovementLineState movementLine, decimal confirmedQty,
            Func<long> nextEntrySeqId)
        {
            if (!movement.IsInTransit)
            {
                throw new ArgumentException("Movement is NOT In-Transit.");
            }
            ICreateInventoryItemEntry[] trxPair = new ICreateInventoryItemEntry[2];

            /////////////////////// From: ////////////////////////////
            int signum = -1;
            var locIdFrom = WarehouseUtils.GetInTransitLocatorId(movement.WarehouseIdFrom);
            trxPair[0] = CreateInventoryItemEntry(movement, movementLine, locIdFrom, confirmedQty * signum, 2, nextEntrySeqId, true);

            /////////////////////// To:   ////////////////////////////
            signum = 1;
            trxPair[1] = CreateInventoryItemEntry(movement, movementLine, movementLine.LocatorIdTo, confirmedQty * signum, 3, nextEntrySeqId);

            return trxPair;
        }

        internal static ICreateInventoryItemEntry CreateInventoryItemEntry(IMovementState movement, IMovementLineState movementLine, string locatorId, decimal quantity, int lineSubSeqId,
            Func<long> nextEntrySeqId, bool usingInTransitQty = false)
        {
            var entry = new CreateInventoryItemEntry();
            var invItemId = new InventoryItemId(movementLine.ProductId, locatorId, movementLine.AttributeSetInstanceId);
            entry.InventoryItemId = invItemId;
            entry.EntrySeqId = nextEntrySeqId();
            if (!usingInTransitQty)
            {
                entry.OnHandQuantity = quantity;
            }
            else
            {
                entry.InTransitQuantity = quantity;
            }
            entry.Source = new InventoryItemSourceInfo(DocumentTypeIds.Movement, movement.DocumentNumber, movementLine.LineNumber, lineSubSeqId);
            return entry;
        }


        // ////////////////////////////////////

        #region MovementConfirmation

        /// <summary>
        /// 创建 Movement 的确认单。
        /// </summary>
        private ICreateMovementConfirmation CreateMovementConfirmation(IMovementState movement)
        {
            var movConfirm = new CreateMovementConfirmation();
            movConfirm.MovementDocumentNumber = movement.DocumentNumber;
            movConfirm.DocumentNumber = "MC" + movement.DocumentNumber;//SeqIdGenerator.GetNextId(); 
            movConfirm.DocumentTypeId = DocumentTypeIds.MovementConfirmation;
            //movConfirm.CreatedBy = movConfirm.UpdatedBy = Context.User;
            //movConfirm.CreationTime = movConfirm.UpdateTime = now;

            AddMovementConfirmationLines(movement, movConfirm);

            return movConfirm;
        }

        private void AddMovementConfirmationLines(IMovementState movement, ICreateMovementConfirmation movConfirm)
        {
            foreach (var movLine in movement.MovementLines)
            {
                var confirmLine = new CreateMovementConfirmationLine();
                //confirmLine.MovementConfirmationDocumentNumber = movConfirm;
                //confirmLine.CreatedBy = confirmLine.UpdatedBy = Context.User;
                //confirmLine.CreationTime = confirmLine.UpdateTime = now;
                confirmLine.LineNumber = movLine.LineNumber;//SeqIdGenerator.GetNextId().ToString();
                confirmLine.MovementLineNumber = movLine.LineNumber;
                confirmLine.TargetQuantity = movLine.MovementQuantity;
                confirmLine.ConfirmedQuantity = 0L; //??
                movConfirm.MovementConfirmationLines.Add(confirmLine);
            }
        }

        #endregion

    }
}
