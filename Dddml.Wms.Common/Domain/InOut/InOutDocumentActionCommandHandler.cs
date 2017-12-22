using Dddml.Wms.Specialization;
using Stateless;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Domain.InOut
{
    public class InOutDocumentActionCommandHandler : IPropertyCommandHandler<string, string>
    {
        // //////////////////////////////////
        // 在异步处理模型下不能使用 ThreadStatic 来作为请求处理的上下文。
        //[ThreadStatic]
        //private static string _currentDocumentStatus;
        //private static StateMachine<string, string> _stateMachine;
        //static InOutDocumentActionCommandHandler()
        //{
        //    var tm = BuildStateMachine(() => _currentDocumentStatus, s => _currentDocumentStatus = s);
        //    _stateMachine = tm;
        //}

        private static StateMachine<string, string> BuildStateMachine(Func<String> stateAccessor, Action<String> stateMutator)
        {
            // //////////////////////////////////
            // TODO StateMachine 类库需要一个 StateMachineBuilder，避免重复配置。
            var tm = new StateMachine<string, string>(stateAccessor, stateMutator);

            tm.Configure(DocumentStatusIds.Initial)
                .Permit(DocumentAction.Draft, DocumentStatusIds.Drafted);

            tm.Configure(DocumentStatusIds.Drafted)
                .Permit(DocumentAction.Complete, DocumentStatusIds.Completed)
                .Permit(DocumentAction.Void, DocumentStatusIds.Voided);

            tm.Configure(DocumentStatusIds.Completed)
                .Permit(DocumentAction.Close, DocumentStatusIds.Closed)
                .Permit(DocumentAction.Reverse, DocumentStatusIds.Reversed);
            return tm;
        }

        public void Execute(IPropertyCommand<string, string> command)
        {
            var currentState = command.GetState();
            var trigger = command.Content;

            if (command.OuterCommandType == CommandType.Create)
            {
                if (String.IsNullOrWhiteSpace(currentState))
                { currentState = DocumentStatusIds.Initial; }
                if (trigger == null)
                { trigger = DocumentAction.Draft; }
            }

            var stateMachine = BuildStateMachine(() => currentState, command.SetState);
            stateMachine.Fire(trigger);
        }

    }
}
