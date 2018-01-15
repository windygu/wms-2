using Dddml.Wms.Domain.DocumentType;
using Dddml.Wms.Domain.InventoryItem;
using Dddml.Wms.Domain.Warehouse;
using Dddml.Wms.Specialization;
using Dddml.Wms.Specialization.NHibernate;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Domain.Movement.NHibernate
{
    public partial class MovementApplicationService
    {
        IInventoryItemApplicationService InventoryItemApplicationService
        {
            get { return ApplicationContext.Current["inventoryItemApplicationService"] as IInventoryItemApplicationService; }
        }

        private IIdGenerator<long, object, object> _seqIdGenerator = new TableIdGenerator();

        public IIdGenerator<long, object, object> SeqIdGenerator
        {
            get { return _seqIdGenerator; }
            set { _seqIdGenerator = value; }
        }

        public override void When(MovementCommands.DocumentAction c)
        {
            if (c.Value == DocumentAction.Complete)
            {
                var mov = AssertDocumentStatus(c.DocumentNumber, DocumentStatusIds.Drafted);
                var inventoryItemEntries = CompleteMovementCreateInventoryItemEntries(mov);
                CreateOrUpdateInventoryItems(inventoryItemEntries);
                base.When(c);
            }
            else if (c.Value == DocumentAction.Reverse)
            {
                // todo
                //var srcInOut = AssertDocumentStatus(c.DocumentNumber, DocumentStatusIds.Completed);
                //var reversalInOutInfo = CreateReversalInOutAndCompleteAndClose(c, srcInOut);
                //ReverseUpdateSourceInOut(c, reversalInOutInfo);
                ////base.When(c);
            }
            else
            {
                base.When(c);
            }
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
                throw new ArgumentException();
            }
            else
            {
                if (docStatus != mov.DocumentStatusId)
                { throw new ArgumentException(String.Format("Error document status: {0}", mov.DocumentStatusId)); }
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
            //排序，使得出库的事务先执行
            //////////////////////////////////////////////////
            //invItemEntries.Sort(new Comparison<ICreateInventoryItemEntry>((x, y) =>
            //        (x.OnHandQuantity > y.OnHandQuantity) ? 1 :
            //            (x.OnHandQuantity == y.OnHandQuantity ? 0 : -1)));

            return invItemEntries;
        }


        internal static ICreateInventoryItemEntry[] CompleteMovementCreateInventoryItemEntryPair(IMovementState movement, IMovementLineState movementLine,
            Func<long> nextEntrySeqId)
        {
            ICreateInventoryItemEntry[] trxPair = new ICreateInventoryItemEntry[2];

            /////////////////////// From: ////////////////////////////
            int signum = -1;
            trxPair[0] = CreateInventoryItemEntry(movement, movementLine, movementLine.LocatorIdFrom, signum, 0, nextEntrySeqId);
            
            /////////////////////// To:   ////////////////////////////
            signum = 1;
            if (!movement.IsInTransit)
            {
                trxPair[1] = CreateInventoryItemEntry(movement, movementLine, movementLine.LocatorIdTo, signum, 1, nextEntrySeqId);
            }
            else
            {
                var locId = WarehouseUtils.GetInTransitLocatorId(movement.WarehouseIdFrom);
                trxPair[1] = CreateInventoryItemEntry(movement, movementLine, locId, signum, 1, nextEntrySeqId, true);
            }
            
            return trxPair;
        }

        internal static ICreateInventoryItemEntry CreateInventoryItemEntry(IMovementState movement, IMovementLineState movementLine, string locatorId, int signum, int lineSeqId,
            Func<long> nextEntrySeqId, bool usingInTransitQty = false)
        {
            var entry = new CreateInventoryItemEntry();
            var invItemId = new InventoryItemId(movementLine.ProductId, locatorId, movementLine.AttributeSetInstanceId);
            entry.InventoryItemId = invItemId;
            entry.EntrySeqId = nextEntrySeqId();
            if (!usingInTransitQty)
            {
                entry.OnHandQuantity = movementLine.MovementQuantity * signum;
            }
            else
            {
                entry.InTransitQuantity = movementLine.MovementQuantity * signum;
            }
            entry.Source = new InventoryItemSourceInfo(DocumentTypeIds.Movement, movement.DocumentNumber, movementLine.LineNumber, lineSeqId);
            return entry;
        }

    }
}
