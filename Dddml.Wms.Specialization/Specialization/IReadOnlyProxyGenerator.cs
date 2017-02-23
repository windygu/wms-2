using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Specialization
{
    public interface IReadOnlyProxyGenerator
    {
        T CreateProxy<T>(IState state, Type[] additionalInterfaces, ISet<string> readOnlyPropertyNames);

        object CreateProxy(Type type, IState state, Type[] additionalInterfaces, ISet<string> readOnlyPropertyNames);

        T GetTarget<T>(IState state);

        object GetTarget(IState state);
    }
}
