using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dddml.Wms.Specialization
{
    public class NullReadOnlyProxyGenerator : IReadOnlyProxyGenerator
    {
        public T CreateProxy<T>(IState state, Type[] additionalInterfaces, ISet<string> readOnlyPropertyNames)
        {
            return (T)state;
        }

        public object CreateProxy(Type type, IState state, Type[] additionalInterfaces, ISet<string> readOnlyPropertyNames)
        {
            return state;
        }

        public T GetTarget<T>(IState state)
        {
            return (T)state;
        }

        public object GetTarget(IState state)
        {
            return state;
        }
    }
}
