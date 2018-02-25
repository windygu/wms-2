using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Domain.PhysicalInventory
{
    public partial class PhysicalInventoryAggregate : IPhysicalInventoryAggregate
    {
        public virtual void DocumentAction(string value, long version, string commandId, string requesterId)
        {
            var e = NewPhysicalInventoryStateMergePatched(version, commandId, requesterId);
            DoDocumentAction(value, ts => e.DocumentStatusId = ts);
            Apply(e);
        }

        public void CountItem(string locatorId, string productId, string attributeSetInstanceId, decimal countedQuantity, long version, string commandId, string requesterId)
        {
            //todo???
            throw new NotImplementedException();
        }
    }
}
