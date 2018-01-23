using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Domain.Movement
{
    public partial class MovementAggregate : IMovementAggregate
    {
        public virtual void DocumentAction(string value, long version, string commandId, string requesterId)
        {
            var e = NewMovementStateMergePatched(version, commandId, requesterId);
            DoDocumentAction(value, ts => e.DocumentStatusId = ts);
            Apply(e);
        }

        public virtual void Reverse(string reversalDocumentNumber, string desc, long version, string commandId, string requesterId)
        {
            var e = NewMovementStateMergePatched(version, commandId, requesterId);
            e.ReversalDocumentNumber = reversalDocumentNumber;
            e.Description = desc;
            DoDocumentAction(global::Dddml.Wms.Domain.DocumentAction.Reverse, ts => e.DocumentStatusId = ts);
            Apply(e);
        }

    }
}
