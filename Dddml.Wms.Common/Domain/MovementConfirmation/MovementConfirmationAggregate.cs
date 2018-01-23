using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Domain.MovementConfirmation
{
    public partial class MovementConfirmationAggregate : IMovementConfirmationAggregate
    {
        public virtual void DocumentAction(string value, long version, string commandId, string requesterId)
        {
            var e = NewMovementConfirmationStateMergePatched(version, commandId, requesterId);
            DoDocumentAction(value, ts => e.DocumentStatusId = ts);
            Apply(e);
        }

    }
}
