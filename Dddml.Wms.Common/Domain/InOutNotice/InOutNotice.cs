using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dddml.Wms.Domain.InOutNotice
{
    public partial class InOutNoticeAggregate : IInOutNoticeAggregate
    {

        public void InOutNoticeAction(string value, long version, string commandId, string requesterId)
        {
            throw new NotImplementedException();
        }
    }
}
