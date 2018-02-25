using Common.Logging;
using Dddml.Wms.Domain.InventoryItem;
using Dddml.Wms.Specialization;
using Spring.Transaction.Interceptor;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Domain.PhysicalInventory.NHibernate
{
    public partial class PhysicalInventoryApplicationService
    {
        static readonly ILog _log = LogManager.GetLogger<PhysicalInventoryApplicationService>();

        IInventoryItemApplicationService InventoryItemApplicationService
        {
            get { return ApplicationContext.Current["inventoryItemApplicationService"] as IInventoryItemApplicationService; }
        }

            
        [Transaction]
        public override void When(PhysicalInventoryCommands.DocumentAction c)
        {
            if (c.Value == DocumentAction.Complete)
            {
                var PhysicalInventory = AssertDocumentStatus(c.DocumentNumber, DocumentStatusIds.Drafted);
                // todo 
                //var inventoryItemEntries = CompletePhysicalInventoryCreateInventoryItemEntries(PhysicalInventory);
                //CreateOrUpdateInventoryItems(inventoryItemEntries);
                base.When(c);
            }
            else if (c.Value == DocumentAction.Reverse)
            {
                var srcPhysicalInventory = AssertDocumentStatus(c.DocumentNumber, DocumentStatusIds.Completed);
                // todo
                //var reversalPhysicalInventoryInfo = CreateReversalPhysicalInventoryAndCompleteAndClose(c, srcPhysicalInventory);
                //ReverseUpdateSourcePhysicalInventory(c, reversalPhysicalInventoryInfo);
                ////base.When(c);
            }
            else
            {
                base.When(c);
            }
        }

        [Transaction]
        public override void When(ICreatePhysicalInventory c)
        {
            //todo
            base.When(c);
        }
    
        [Transaction]
        public override void When(IMergePatchPhysicalInventory c)
        {
            AssertDocumentStatus(c.DocumentNumber, DocumentStatusIds.Drafted);
            base.When(c);
        }

        [Transaction]
        public override void When(PhysicalInventoryCommands.CountItem c)
        {
            AssertDocumentStatus(c.DocumentNumber, DocumentStatusIds.Drafted);
            base.When(c);
        }

        private IPhysicalInventoryState AssertDocumentStatus(string docNumber, string docStatus)
        {
            var physicalInventory = StateRepository.Get(docNumber, true);
            if (physicalInventory == null)
            {
                throw new ArgumentException(String.Format("Error document number: {0}", docNumber));
            }
            else
            {
                if (docStatus != physicalInventory.DocumentStatusId)
                { throw new ArgumentException(String.Format("Error document status: {0}", physicalInventory.DocumentStatusId)); }
            }
            return physicalInventory;
        }
    }
}
