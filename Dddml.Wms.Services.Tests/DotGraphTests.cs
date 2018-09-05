using Dddml.Wms.Domain;
using Stateless;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dddml.Wms.Services.Tests
{
    public static class DotGraphTests
    {

        public static String GetTestOutputDotGraph()
        {
            var stateMachine = BuildStateMachine(() => String.Empty, (v) => { });
            return stateMachine.ToDotGraph();
        }

        private static StateMachine<string, string> BuildStateMachine(Func<String> stateAccessor, Action<String> stateMutator)
        {
            var tm = new StateMachine<string, string>(stateAccessor, stateMutator);

            tm.Configure(String.IsNullOrWhiteSpace(DocumentStatusIds.Initial) ? "INITIAL" : DocumentStatusIds.Initial)
                .Permit(DocumentAction.Draft, DocumentStatusIds.Drafted);

            tm.Configure(DocumentStatusIds.Drafted)
                .Permit(DocumentAction.Complete, DocumentStatusIds.Completed)
                .Permit(DocumentAction.Void, DocumentStatusIds.Voided);

            tm.Configure(DocumentStatusIds.Completed)
                .Permit(DocumentAction.Close, DocumentStatusIds.Closed)
                .Permit(DocumentAction.Reverse, DocumentStatusIds.Reversed);
            return tm;
        }
    }
}
