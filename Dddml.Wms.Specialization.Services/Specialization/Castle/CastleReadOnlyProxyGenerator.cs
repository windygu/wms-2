using Castle.DynamicProxy;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Specialization.Castle
{
    public class CastleReadOnlyProxyGenerator : IReadOnlyProxyGenerator
    {
        private static ProxyGenerator _proxyGenerator = new ProxyGenerator();

        public T CreateProxy<T>(IState state, Type[] additionalInterfaces, ISet<string> readOnlyPropertyNames)
        {
            return (T)CreateProxy(typeof(T), state, additionalInterfaces, readOnlyPropertyNames);
        }

        public object CreateProxy(Type type, IState state, Type[] additionalInterfaces, ISet<string> readOnlyPropertyNames)
        {
            state.ReadOnly = true;
            
            var readOnlyInterceptor = new ReadOnlyInterceptor(readOnlyPropertyNames);
            var p = _proxyGenerator.CreateInterfaceProxyWithTarget(type, additionalInterfaces, state, readOnlyInterceptor);
            return p;
        }

        public T GetTarget<T>(IState state)
        {
            return (T)GetTarget(state);
        }

        public object GetTarget(IState state)
        {
            //state.ReadOnly = false;
            if (state is IProxyTargetAccessor)
            {
                return ((IProxyTargetAccessor)state).DynProxyGetTarget();
            }
            return state;
        }

        private class ReadOnlyInterceptor : IInterceptor
        {
            private ISet<string> _readOnlyPropertyNames;

            public ReadOnlyInterceptor(ISet<string> readOnlyPropertyNames)
            {
                this._readOnlyPropertyNames = readOnlyPropertyNames;
            }

            public void Intercept(IInvocation invocation)
            {
                var memberInfo = invocation.Method;
                if (memberInfo.IsSpecialName && memberInfo.Name.StartsWith("set_"))
                {
                    var pn = memberInfo.Name.Substring(4);
                    if (_readOnlyPropertyNames.Contains(pn))
                    {
                        if (((IState)invocation.InvocationTarget).ReadOnly == true)
                        {
                            throw new NotSupportedException(String.Format("{0}.{1} is readOnly.", memberInfo.DeclaringType.FullName, pn));
                        }
                    }
                }
                invocation.Proceed();
            }
        }

    }
}
