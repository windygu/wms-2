using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Specialization
{
    public class ValueObjectTextFormatter<T> : ITextFormatter<T> where T : new()
    {
        private static readonly string ForEachFlattenedPropertyMethodName = "ForEachFlattenedProperty";

        private static readonly string SetFlattenedPropertyValuesMethodName = "SetFlattenedPropertyValues";

        private static readonly string FlattenedPropertyTypesFieldName = "FlattenedPropertyTypes";

        private static readonly string FlattenedPropertyTypeDictionaryFieldName = "FlattenedPropertyTypeDictionary";

        private string _fieldSeparator = ",";

        public virtual string FieldSeparator
        {
            get { return _fieldSeparator; }
            set { _fieldSeparator = value; }
        }

        public ValueObjectTextFormatter()
            : this(",")
        {
        }

        public ValueObjectTextFormatter(string fieldSeparator)
        {
            this._fieldSeparator = fieldSeparator;
        }

        public T Parse(string text)
        {
            string[] strValues = text.Split(new string[] { FieldSeparator }, StringSplitOptions.None);
            var obj = new T();
            var fieldTypesFieldInfo = typeof(T).GetField(FlattenedPropertyTypesFieldName, System.Reflection.BindingFlags.Public | System.Reflection.BindingFlags.NonPublic | System.Reflection.BindingFlags.Static);
            Type[] fieldTypes = (Type[])fieldTypesFieldInfo.GetValue(null);
            if (strValues.Length != fieldTypes.Length)
            {
                throw new ArgumentException(String.Format("The fields count in argument \"{0}\" is NOT right.", "text"));
            }
            object[] fieldValues = new object[fieldTypes.Length];
            for (int i = 0; i < fieldTypes.Length; i++)
            {
                var fieldType = fieldTypes[i];
                var strVal = strValues[i].Trim();
                var val = ApplicationContext.Current.TypeConverter.ConvertFromString(fieldType, strVal);
                fieldValues[i] = val;
            }
            var setMethod = typeof(T).GetMethod(SetFlattenedPropertyValuesMethodName, System.Reflection.BindingFlags.Public | System.Reflection.BindingFlags.NonPublic | System.Reflection.BindingFlags.Instance);
            setMethod.Invoke(obj, new object[] { fieldValues });
            return obj;
        }

        public string ToString(T value)
        {
            StringBuilder sb = new StringBuilder();
            var fieldTypeDictFieldInfo = typeof(T).GetField(FlattenedPropertyTypeDictionaryFieldName, System.Reflection.BindingFlags.Public | System.Reflection.BindingFlags.NonPublic | System.Reflection.BindingFlags.Static);
            IDictionary<string, Type> td = (IDictionary<string, Type>)fieldTypeDictFieldInfo.GetValue(null);
            Action<string, object> a = (n, v) =>
            {
                if (!String.IsNullOrWhiteSpace(sb.ToString()))
                {
                    sb.Append(FieldSeparator);
                }
                var type = td[n];
                sb.Append(ApplicationContext.Current.TypeConverter.ConvertToString(type, v));
            };
            var foreachMethod = typeof(T).GetMethod(ForEachFlattenedPropertyMethodName, System.Reflection.BindingFlags.Public | System.Reflection.BindingFlags.NonPublic | System.Reflection.BindingFlags.Instance);
            foreachMethod.Invoke(value, new object[] { a });
            return sb.ToString();
        }
    }
}
