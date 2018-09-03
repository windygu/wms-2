using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Dddml.Wms.Specialization
{
    public class WebApiControllerTypeConverter : Dddml.Support.Criterion.ITypeConverter
    {
        public T ConvertFromString<T>(string text)
        {
            return (T)ApplicationContext.Current.TypeConverter.ConvertFromString(typeof(T), text);
        }

        public object ConvertFromString(Type type, string text)
        {
            return ApplicationContext.Current.TypeConverter.ConvertFromString(type, text);
        }

        public string ConvertToString<T>(T value)
        {
            return ApplicationContext.Current.TypeConverter.ConvertToString(typeof(T), value);
        }

        public string ConvertToString(object value)
        {
            return ApplicationContext.Current.TypeConverter.ConvertToString(value.GetType(), value);
        }

        public string[] ConvertToStringArray(object[] values)
        {
            throw new NotSupportedException();
        }
    }

}