using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Spring.Transaction.Interceptor;
using Dddml.Wms.Domain.InventoryItem;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain.DocumentType;

namespace Dddml.Wms.Domain.InOut.NHibernate
{
    public partial class InOutApplicationService
    {
        IInventoryItemApplicationService InventoryItemApplicationService
        {
            get { return ApplicationContext.Current["inventoryItemApplicationService"] as IInventoryItemApplicationService; } 
        }

        [Transaction]
        public override void When(InOutCommands.Complete c)
        {
            var inOut = StateRepository.Get(c.DocumentNumber, true);
            if (inOut == null)
            {
                throw new ArgumentException();
            }
            else
            {
                //todo check status.
            }

            var inventoryItemEntries = CompleteInOutCreateInventoryItemEntries(inOut);
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
            
            base.When(c);
        }

        [Transaction]
        public override void When(InOutCommands.Close c)
        {
            //todo
            base.When(c);
        }
    
        [Transaction]
        public override void When(InOutCommands.Void c)
        {
            //todo
            base.When(c);
        }

        [Transaction]
        public override void When(InOutCommands.Reverse c)
        {
            //todo
            base.When(c);
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


        protected virtual ICreateInventoryItemEntry CreateInventoryItemEntry(IInOutState inOut, IInOutLineState inOutLine, int signum)
        {
            var entry = new CreateInventoryItemEntry();
            entry.InventoryItemId = new InventoryItemId(inOutLine.ProductId, inOutLine.LocatorId, inOutLine.AttributeSetInstanceId);
            entry.EntrySeqId = DateTime.Now.Ticks; //todo
            entry.OnHandQuantity = inOutLine.MovementQuantity * signum;
            entry.Source = new InventoryItemSourceInfo(DocumentTypeIds.InOut, inOut.DocumentNumber, inOutLine.LineNumber);
            return entry;
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
    }
}
