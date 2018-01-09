using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Spring.Transaction.Interceptor;
using Dddml.Wms.Domain.InventoryItem;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain.DocumentType;
using Dddml.Wms.Specialization.NHibernate;

namespace Dddml.Wms.Domain.InOut.NHibernate
{
    public partial class InOutApplicationService
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

        [Transaction]
        public override void When(InOutCommands.DocumentAction c)
        {
            if (c.Value == DocumentAction.Complete) 
            {
                var inOut = AssertDocumentStatus(c.DocumentNumber, DocumentStatusIds.Drafted);
                var inventoryItemEntries = CompleteInOutCreateInventoryItemEntries(inOut);
                CreateOrUpdateInventoryItems(inventoryItemEntries);
                base.When(c);
            }
            else if (c.Value == DocumentAction.Reverse)
            {
                var inOut = AssertDocumentStatus(c.DocumentNumber, DocumentStatusIds.Completed);

                var createReversalInOut = CreateReversalInOutAndComplete(c, inOut);
                var srcInOutUpdated = new InOutStateMergePatched()
                {
                    ReversalDocumentNumber = createReversalInOut.DocumentNumber,
                    //源单据前向关联到反转单据:
                    Description = "(" + createReversalInOut.DocumentNumber + "<-)",//(1000016<-)
                };
                // //////////////////
                // todo
                // //////////////////
                base.When(c);
            }
            else
            {
                base.When(c);
            }
        }

        [Transaction]
        public override void When(InOutCommands.Complete c)
        {
            When(NewDocumentAction(DocumentAction.Complete, c));
        }

        [Transaction]
        public override void When(InOutCommands.Close c)
        {
            When(NewDocumentAction(DocumentAction.Close, c));
        }

        [Transaction]
        public override void When(InOutCommands.Void c)
        {
            When(NewDocumentAction(DocumentAction.Void, c));
        }

        [Transaction]
        public override void When(InOutCommands.Reverse c)
        {
            When(NewDocumentAction(DocumentAction.Reverse, c));
        }

   
        #region Private or protected methods.

        private ICreateInOut CreateReversalInOutAndComplete(InOutCommands.DocumentAction c, IInOutState inOut)
        {
            var createReversalInOut = CreateReversalInOut(inOut);
           
            When(createReversalInOut);
            When(new InOutCommands.Complete()
            {
                DocumentNumber = createReversalInOut.DocumentNumber,
                Version = 1,
                CommandId = c.CommandId,
                RequesterId = c.RequesterId,
            });
            When(new InOutCommands.Close()
            {
                DocumentNumber = createReversalInOut.DocumentNumber,
                Version = 2,
                CommandId = c.CommandId,
                RequesterId = c.RequesterId,
            });

            return createReversalInOut;
        }

        protected virtual ICreateInOut CreateReversalInOut(IInOutState inOut)
        {
            var reversalInOut = DoCreateReversalInOut(inOut);
            
            foreach (var d in inOut.InOutLines)
            {
                var r = DoCreateReversalInOutLine(d);
                reversalInOut.InOutLines.Add(r);
            }

            return reversalInOut;
        }

        /// <summary>
        /// 生成反转的单据（但不包括行）。
        /// </summary>
        protected virtual ICreateInOut DoCreateReversalInOut(IInOutState inOut)
        {
            var reversalInOut = new CreateInOut();

            //reversalInOut.Organization = inOut.Organization;//？
            //reversalInOut.Client = inOut.Client;
            //reversalInOut.CreatedBy = reversalInOut.UpdatedBy = Context.User;
            //reversalInOut.CreationTime = reversalInOut.UpdateTime = now;

            //生成新的单号:
            reversalInOut.DocumentNumber = "RIO" + SeqIdGenerator.GetNextId();//DocumentNumberGenerator.GetNewDocumentNumber();
            //设置反转关系:
            reversalInOut.ReversalDocumentNumber = inOut.DocumentNumber;
            //inOut.Reversal = reversalInOut;
            ////源单据前向关联到反转单据:
            //inOut.Description = "(" + reversalInOut.DocumentNumber + "<-)";//(1000016<-)
            //反转单据后向关联到源单据:
            reversalInOut.Description = "{->" + inOut.DocumentNumber + ")";//{->1000015)

            //reversalInOut.IsSOTransaction = inOut.IsSOTransaction;
            //reversalInOut. DocumentStatus
            //reversalInOut.Posted = inOut.Posted;//??
            //reversalInOut.Processing = inOut.Processing;
            //reversalInOut.Processed = inOut.Processed;
            reversalInOut.DocumentTypeId = inOut.DocumentTypeId;
            reversalInOut.OrderId = inOut.OrderId;
            reversalInOut.DateOrdered = inOut.DateOrdered;
            //reversalInOut.IsPrinted 
            reversalInOut.MovementTypeId = inOut.MovementTypeId;
            reversalInOut.MovementDate = inOut.MovementDate;
            reversalInOut.BusinessPartnerId = inOut.BusinessPartnerId;
            reversalInOut.WarehouseId = inOut.WarehouseId;
            //reversalInOut.FreightAmount;
            //reversalInOut.Shipper
            //reversalInOut.ChargeAmount??
            //reversalInOut.DatePrinted;
            //reversalInOut.CreateFrom
            //reversalInOut.GenerateTo
            //reversalInOut.User = inOut.User;
            //reversalInOut.SalesRepresentative
            reversalInOut.NumberOfPackages = inOut.NumberOfPackages;
            //reversalInOut.PickDate
            //reversalInOut.ShipDate
            reversalInOut.TrackingNumber = inOut.TrackingNumber;
            //reversalInOut.DateReceived
            //reversalInOut.IsInTransit
            //reversalInOut.IsApproved;
            //reversalInOut.IsInDispute
            //reversalInOut.Volume = inOut.Volume;
            //reversalInOut.Weight = inOut.Weight;
            //reversalInOut.Rma = inOut.Rma;
            //reversalInOut.IsDropShip = inOut.IsDropShip;
            return reversalInOut;
        }

        /// <summary>
        /// 生成反转的行。
        /// </summary>
        protected virtual ICreateInOutLine DoCreateReversalInOutLine(IInOutLineState inOutLine)
        {
            var reversalLine = new CreateInOutLine();
            reversalLine.ReversalLineNumber = inOutLine.LineNumber;//设置反转行
            //reversalLine.Organization = Context.Organization;//？
            //reversalLine.UpdatedBy = Context.User;
            //reversalLine.UpdateTime = now;
            //reversalLine.CreatedBy = Context.User;
            //reversalLine.CreationTime = now;
            reversalLine.ProductId = inOutLine.ProductId;
            reversalLine.LocatorId = inOutLine.LocatorId;
            reversalLine.AttributeSetInstanceId = inOutLine.AttributeSetInstanceId;

            //reversalLine.IsDescription = inOutLine.IsDescription;
            reversalLine.IsInvoiced = inOutLine.IsInvoiced;
            reversalLine.LineNumber = inOutLine.LineNumber;
            //reversalLine.RmaLine = inOutLine.RmaLine;
            reversalLine.Processed = inOutLine.Processed;
            //reversalLine.RmaLine = inOutLine.RmaLine;
            reversalLine.QuantityUomId = inOutLine.QuantityUomId;

            //数量全部反转？
            reversalLine.MovementQuantity = -inOutLine.MovementQuantity;
            //reversalLine.QuantityEntered = -inOutLine.QuantityEntered;
            //reversalLine.ScrappedQuantity = -inOutLine.ScrappedQuantity;
            reversalLine.PickedQuantity = -inOutLine.PickedQuantity;
            //reversalLine.TargetQuantity = -inOutLine.TargetQuantity;

            return reversalLine;
        }

        private static InOutCommands.DocumentAction NewDocumentAction(string value, IInOutCommand c)
        {
            return new InOutCommands.DocumentAction()
            {
                Value = value,
                DocumentNumber = c.DocumentNumber,
                Version = c.Version,
                CommandId = c.CommandId,
                RequesterId = Convert.ToString(c.RequesterId),
            };
        }
    
        private IInOutState AssertDocumentStatus(string docNumber, string docStatus)
        {
            var inOut = StateRepository.Get(docNumber, true);
            if (inOut == null)
            {
                throw new ArgumentException();
            }
            else
            {
                if (docStatus != inOut.DocumentStatusId)
                { throw new ArgumentException(String.Format("Error document status: {0}", inOut.DocumentStatusId)); }
            }
            return inOut;
        }

        protected virtual IList<ICreateInventoryItemEntry> CompleteInOutCreateInventoryItemEntries(IInOutState inOut)
        {
            //int signum = GetSignumOfMovementType(inOut.MovementTypeId);
            var ioLines = inOut.InOutLines;
            var entries = new List<ICreateInventoryItemEntry>();
            foreach (var d in ioLines)
            {
                var e = CreateInventoryItemEntry(inOut, d);// signum);
                entries.Add(e);
            }
            return entries;
        }


        /// <summary>
        /// 更新库存单元。
        /// </summary>
        /// <param name="inventoryItemEntries"></param>
        private void CreateOrUpdateInventoryItems(IList<ICreateInventoryItemEntry> inventoryItemEntries)
        {
            foreach (var e in inventoryItemEntries)
            {
                var iitem = InventoryItemApplicationService.Get(e.InventoryItemId);
                if (iitem == null)
                {
                    var createInventoryItem = new CreateInventoryItem();
                    createInventoryItem.InventoryItemId = e.InventoryItemId;
                    createInventoryItem.Entries.Add(e);
                    InventoryItemApplicationService.When(createInventoryItem);
                }
                else
                {
                    var updateInventoryItem = new MergePatchInventoryItem();
                    updateInventoryItem.InventoryItemId = e.InventoryItemId;
                    updateInventoryItem.Version = iitem.Version; // /////////////////
                    updateInventoryItem.InventoryItemEntryCommands.Add(e);
                    InventoryItemApplicationService.When(updateInventoryItem);
                }
            }

        }

        protected virtual ICreateInventoryItemEntry CreateInventoryItemEntry(IInOutState inOut, IInOutLineState inOutLine)//, int signum)
        {
            var entry = new CreateInventoryItemEntry();
            entry.InventoryItemId = new InventoryItemId(inOutLine.ProductId, inOutLine.LocatorId, inOutLine.AttributeSetInstanceId);
            entry.EntrySeqId = SeqIdGenerator.GetNextId();//DateTime.Now.Ticks;
            entry.OnHandQuantity = inOutLine.MovementQuantity;// *signum;
            entry.Source = new InventoryItemSourceInfo(DocumentTypeIds.InOut, inOut.DocumentNumber, inOutLine.LineNumber);
            return entry;
        }

        //public static int GetSignumOfMovementType(string movementTypeId)
        //{
        //    string s = movementTypeId.Substring(movementTypeId.Length - 1, 1);
        //    if (s == "+")
        //    {
        //        return 1;
        //    }
        //    else if (s == "-")
        //    {
        //        return -1;
        //    }
        //    else
        //    {
        //        throw new ArgumentException();
        //    }
        //}

        #endregion

    }
}
