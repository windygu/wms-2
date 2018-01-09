using Dddml.Wms.Specialization;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Domain.InOut
{
    /// <summary>
    /// InOut Aggregate.
    /// </summary>
    public partial class InOutAggregate
    {
        // //////////////////////////////////////////////
        // Aggregate 只负责更新聚合内的状态。
        // //////////////////////////////////////////////

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
