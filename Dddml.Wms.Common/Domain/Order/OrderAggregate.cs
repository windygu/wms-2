using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dddml.Wms.Domain.Order
{
    public partial class OrderAggregate : IOrderAggregate
    {

        public void OrderShipGroupAction(long? shipGroupSeqId, string value, long version, string commandId, string requesterId)
        {
            throw new NotImplementedException();
        }

    }
}
