using Dddml.Wms.Specialization;
using Stateless;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Domain
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

            tm.Configure(DocumentStatus.Initial)
                .Permit(DocumentAction.Draft, DocumentStatus.Drafted);

            tm.Configure(DocumentStatus.Drafted)
                .Permit(DocumentAction.Complete, DocumentStatus.Completed)
                .Permit(DocumentAction.Void, DocumentStatus.Voided);

            tm.Configure(DocumentStatus.Completed)
                .Permit(DocumentAction.Close, DocumentStatus.Closed)
                .Permit(DocumentAction.Reverse, DocumentStatus.Reversed);
            return tm;
        }

        public void Execute(IPropertyCommand<string, string> command)
        {
            var currentState = command.GetState();
            var trigger = command.Content;

            if (command.OuterCommandType == CommandType.Create)
            {
                if (String.IsNullOrWhiteSpace(currentState))
                { currentState = DocumentStatus.Initial; }
                if (trigger == null)
                { trigger = DocumentAction.Draft; }
            }

            var stateMachine = BuildStateMachine(() => currentState, command.SetState);
            stateMachine.Fire(trigger);
        }

    }
}
