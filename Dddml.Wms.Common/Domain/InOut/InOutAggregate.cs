using Dddml.Wms.Specialization;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Domain.InOut
{
    public partial class InOutAggregate
    {
        public virtual void DocumentAction(string value, string commandId, string requesterId)
        {
            var e = NewInOutStateMergePatched(commandId, requesterId);
            DoDocumentAction(value, ts => e.DocumentStatusId = ts);
            Apply(e);
        }

        public virtual void Complete(string commandId, string requesterId)
        {
            DocumentAction(global::Dddml.Wms.Domain.DocumentAction.Complete, commandId, requesterId);
        }

        public virtual void Close(string commandId, string requesterId)
        {
            DocumentAction(global::Dddml.Wms.Domain.DocumentAction.Close, commandId, requesterId);
        }

        public virtual void Void(string commandId, string requesterId)
        {
            DocumentAction(global::Dddml.Wms.Domain.DocumentAction.Void, commandId, requesterId);
        }

        public virtual void Reverse(string commandId, string requesterId)
        {
            DocumentAction(global::Dddml.Wms.Domain.DocumentAction.Reverse, commandId, requesterId);
        }
    }
}
