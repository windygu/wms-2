using System;
using System.Linq.Expressions;

namespace Dddml.Wms.Specialization
{
    public static class ReflectUtils
    {
        public static void CopyPropertyValue(string propertyName, object source, object destination)
        {
            if (source != null)
            {
                var srcProp = source.GetType().GetProperty(propertyName);
                var value = srcProp.GetValue(source);
                SetPropertyValue(propertyName, destination, value);
            }
        }

        public static void SetPropertyValue(string propertyName, object obj, object value)
        {
            SetPropertyValue(propertyName, obj, value, true);
        }

        public static bool TrySetPropertyValue(string propertyName, object obj, object value)
        {
            return SetPropertyValue(propertyName, obj, value, false);
        }

        private static bool SetPropertyValue(string propertyName, object obj, object value, bool throwOnError)
        {
            var dstProp = obj.GetType().GetProperty(propertyName);
            if (dstProp == null)
            {
                if (throwOnError)
                {
                    throw new ArgumentException(String.Format("Property NOT found. propertyName: {0}", propertyName));
                }
                else
                {
                    return false;
                }
            }
            try
            {
                bool b = false;
                if (value != null && value.GetType() != dstProp.PropertyType)
                {
                    if (IsNullableType(dstProp.PropertyType) && value.GetType() != Nullable.GetUnderlyingType(dstProp.PropertyType))
                    {
                        dstProp.SetValue(obj, Convert.ChangeType(value, Nullable.GetUnderlyingType(dstProp.PropertyType)));
                        b = true;
                    }
                    else if (!IsNullableType(dstProp.PropertyType))
                    {
                        dstProp.SetValue(obj, Convert.ChangeType(value, dstProp.PropertyType));
                        b = true;
                    }
                }
                if (!b)
                {
                    dstProp.SetValue(obj, value);
                    b = true;
                }
                return true;
            }
            catch (Exception ex)
            {
                if (throwOnError) { throw ex; }
            }
            return false;
        }

        public static object GetPropertyValue(string propertyName, object obj)
        {
            var dstProp = obj.GetType().GetProperty(propertyName);
            if (dstProp != null)
            {
                return dstProp.GetValue(obj);
            }
            return null;
        }


        public static string GetPropertyName<TDeclaringType>(Expression<Func<TDeclaringType, object>> propertySelector)
        {
            MemberExpression memberExpr = propertySelector.Body as MemberExpression;
            if (memberExpr != null)
            {
                return memberExpr.Member.Name;
            }
            return GetMemberExpression(propertySelector.Body).Member.Name;
        }

        public static string GetPropertyName<TDeclaringType, TPropertyType>(Expression<Func<TDeclaringType, TPropertyType>> propertySelector)
        {
            MemberExpression memberExpr = propertySelector.Body as MemberExpression;
            if (memberExpr != null)
            {
                return memberExpr.Member.Name;
            }
            return GetMemberExpression(propertySelector.Body).Member.Name;
        }

        public static bool IsNullableType(System.Type type)
        {
            if (type.IsGenericType && type.GetGenericTypeDefinition() == typeof(Nullable<>))
            { return true; }
            return false;
        }

        #region Private Methods

        private static MemberExpression GetMemberExpression(Expression expression)
        {
            return GetMemberExpression(expression, true);
        }

        private static MemberExpression GetMemberExpression(Expression expression, bool enforceCheck)
        {
            MemberExpression operand = null;
            if (expression.NodeType == ExpressionType.Convert)
            {
                UnaryExpression expression3 = (UnaryExpression)expression;
                operand = expression3.Operand as MemberExpression;
            }
            else if (expression.NodeType == ExpressionType.MemberAccess)
            {
                operand = expression as MemberExpression;
            }
            if (enforceCheck && (operand == null))
            {
                throw new ArgumentException("Not a member access", "expression");
            }
            return operand;
        }

        #endregion

    }
}

