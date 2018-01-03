using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Domain.InOut
{
    public partial class InOutAggregate
    {
        public virtual void Complete(string commandId, string requesterId)
        {
            //todo
            throw new NotImplementedException();
        }

        public virtual void Void(string commandId, string requesterId)
        {
            //todo
            throw new NotImplementedException();
        }

        public virtual void Reverse(string commandId, string requesterId)
        {
            //todo
            throw new NotImplementedException();
        }
    }
}
