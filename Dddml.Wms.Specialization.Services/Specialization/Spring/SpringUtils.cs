using System;
using System.Collections.Generic;
using Spring.Aop.Framework;

namespace Dddml.Wms.Specialization.Spring
{
    public static class SpringUtils
    {
        public static T GetAopTarget<T>(object obj)
        {
            if (obj is IAdvised)
            {
                var target = ((IAdvised)obj).TargetSource.GetTarget();
                if (target is T)
                {
                    return (T)target;
                }
            }
            return default(T);
        }
    }
}
