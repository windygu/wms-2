using NHibernate;
using NHibernate.Type;
using System;

namespace Dddml.Wms.Services.Specialization.NHibernate
{
   public class LocalDateTimeInterceptor : EmptyInterceptor
    {
        public override bool OnLoad(object entity, object id, object[] state, string[] propertyNames, global::NHibernate.Type.IType[] types)
        {
            ConvertDatabaseDateTimeToLocal(state, types);
            return true;
        }

        private void ConvertDatabaseDateTimeToLocal(object[] state, IType[] types)
        {
            int index = 0;
            foreach (IType type in types)
            {
                if ((type.ReturnedClass == typeof(DateTime)) && state[index] != null && (((DateTime)state[index]).Kind == DateTimeKind.Unspecified))
                {
                    //Create a new date and assume the value stored in the database is Local
                    DateTime cur = (DateTime)state[index];
                    DateTime result = cur.ToLocalTime();
                    state[index] = result;
                }

                ++index;
            }
        }
}
