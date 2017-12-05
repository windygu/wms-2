using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.Listeners
{
    public class InventoryItemEventListener : IAggregateEventListener<IInventoryItemAggregate, IInventoryItemState>
    {

        public void EventAppended(AggregateEvent<IInventoryItemAggregate, IInventoryItemState> e)
        {
            throw new NotImplementedException();
        }

    }
}
