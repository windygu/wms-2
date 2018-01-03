using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Spring.Transaction.Interceptor;

namespace Dddml.Wms.Domain.InOut.NHibernate
{
    public partial class InOutApplicationService
    {
        [Transaction]
        public override void When(InOutCommands.Complete c)
        {
            //todo
            base.When(c);
        }

        [Transaction]
        public override void When(InOutCommands.Void c)
        {
            //todo
            base.When(c);
        }

        [Transaction]
        public override void When(InOutCommands.Reverse c)
        {
            //todo
            base.When(c);
        }
    }
}
