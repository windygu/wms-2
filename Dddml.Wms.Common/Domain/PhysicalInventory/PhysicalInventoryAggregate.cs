using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dddml.Wms.Domain.PhysicalInventory
{
    public partial class PhysicalInventoryAggregate
    {
        public virtual void DocumentAction(string value, long version, string commandId, string requesterId)
        {
            //todo...
        }

    }
}
