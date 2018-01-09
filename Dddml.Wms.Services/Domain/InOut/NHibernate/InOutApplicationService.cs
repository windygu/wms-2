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
                var inOut = AssertDocumentStatus(c.DocumentNumber, DocumentStatusIds.Drafted);
                var inventoryItemEntries = ReverseInOutCreateInventoryItemEntries(inOut);
                CreateOrUpdateInventoryItems(inventoryItemEntries);
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

        public static int GetSignumOfMovementType(string movementTypeId)
        {
            string s = movementTypeId.Substring(movementTypeId.Length - 1, 1);
            if (s == "+")
            {
                return 1;
            }
            else if (s == "-")
            {
                return -1;
            }
            else
            {
                throw new ArgumentException();
            }
        }

        #region Private or protected methods.

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


        protected virtual IList<ICreateInventoryItemEntry> ReverseInOutCreateInventoryItemEntries(IInOutState inOut)
        {
            // todo
            throw new NotImplementedException();
        }

        protected virtual IList<ICreateInventoryItemEntry> CompleteInOutCreateInventoryItemEntries(IInOutState inOut)
        {
            int signum = GetSignumOfMovementType(inOut.MovementTypeId);
            var ioLines = inOut.InOutLines;
            var entries = new List<ICreateInventoryItemEntry>();
            foreach (var d in ioLines)
            {
                var e = CreateInventoryItemEntry(inOut, d, signum);
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
                    updateInventoryItem.InventoryItemEntryCommands.Add(e);
                    InventoryItemApplicationService.When(updateInventoryItem);
                }
            }

        }

        protected virtual ICreateInventoryItemEntry CreateInventoryItemEntry(IInOutState inOut, IInOutLineState inOutLine, int signum)
        {
            var entry = new CreateInventoryItemEntry();
            entry.InventoryItemId = new InventoryItemId(inOutLine.ProductId, inOutLine.LocatorId, inOutLine.AttributeSetInstanceId);
            entry.EntrySeqId = SeqIdGenerator.GetNextId();//DateTime.Now.Ticks;
            entry.OnHandQuantity = inOutLine.MovementQuantity * signum;
            entry.Source = new InventoryItemSourceInfo(DocumentTypeIds.InOut, inOut.DocumentNumber, inOutLine.LineNumber);
            return entry;
        }
        
        #endregion

    }
}
