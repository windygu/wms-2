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
            //todo
        }

        public virtual void Complete(string commandId, string requesterId)
        {
            var e = NewInOutStateMergePatched(commandId, requesterId);
            var pCommandHandler = this.InOutDocumentActionCommandHandler;
            var pCmdContent = global::Dddml.Wms.Domain.DocumentAction.Complete;//c.DocumentAction;
            var pCmd = new PropertyCommand<string, string> 
            { 
                Content = pCmdContent, 
                GetState = () => this.State.DocumentStatusId, 
                SetState = p => e.DocumentStatusId = p, OuterCommandType = "Complete" 
            };
            pCommandHandler.Execute(pCmd);
            Apply(e);
        }

        public virtual void Close(string commandId, string requesterId)
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
