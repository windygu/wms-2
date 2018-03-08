using Dddml.Wms.Specialization;
using Dddml.Wms.Domain.Metadata;
using Dddml.Ofbiz.Processors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Reflection;
using Dddml.Wms.Support;

namespace Dddml.Wms.Services.Tests
{
    public class XmlDataLoader
    {
        public void Process(string path)
        {
            Process(path, "*Data.xml");
        }

        public void Process(string path, string filter)
        {
            var entityDataProcessor = new EntityDataProcessor();
            entityDataProcessor.Process(path, filter,
                GetEntityInstanceFactory(),
                (entityName, targetObject, attributeName, attributeValue) =>
                {
                    var pName = AttributeNameToPropertyName(entityName, targetObject, attributeName);
                    var pValue = ConvertAttributeValue(targetObject, attributeName, attributeValue);
                    Dynamitey.Dynamic.InvokeSetChain(targetObject, pName, pValue);
                }
                );

            foreach (var kv in entityDataProcessor.ObjectCache)
            {
                var entityName = kv.Key;
                var entityObjects = kv.Value;
                var initServiceFactory = GetEntityInitializationServiceFactory();
                var initService = initServiceFactory(entityName);
                foreach (var c in entityObjects)
                {
                    try
                    {
                        Dynamitey.Dynamic.InvokeMemberAction(initService, "Initialize", new object[] { c });
                    }
                    catch (Exception ex)
                    {
                        System.Console.WriteLine("Error! file: '{0}', message: '{1}'", path, ex.Message);
                    }
                }
            }
        }


        private static object ConvertAttributeValue(object targetObject, string attributeName, object attributeValue)
        {
            var propName = attributeName.Substring(0, 1).ToUpperInvariant() + attributeName.Substring(1);
            var propType = targetObject.GetType().GetProperty(propName);
            if (propType != null)
            {
                var valueType = propType.PropertyType;
                if (NullableUtils.IsNullableType(valueType))
                {
                    valueType = NullableUtils.GetUnderlyingType(valueType);
                }
                return Convert.ChangeType(attributeValue, valueType);
            }
            return attributeValue;
        }

        private static string AttributeNameToPropertyName(string entityName, object targetObject, string attributeName)
        {
            var propName = attributeName.Substring(0, 1).ToUpperInvariant() + attributeName.Substring(1);
            // /////////////////////////////////////
            // Chaining Property Name
            // /////////////////////////////////////
            var propType = targetObject.GetType().GetProperty(propName);
            if (propType == null)
            {
                string stateEventIdPropFormat = "{0}EventId.{1}Id.{2}";
                propName = String.Format(stateEventIdPropFormat, entityName, entityName, propName);
            }
            return propName;
        }

        private static Func<string, object> GetEntityInitializationServiceFactory()
        {
            return (entityName) =>
            {
                var serviceName = entityName + "ApplicationService";
                return ApplicationContext.Current[serviceName];
            };
        }

        private static Func<string, object> GetEntityInstanceFactory()
        {
            return entityName =>
            {
                //if (!_ofbizDataLoader.ObeDictionary.ContainsKey(entityName))
                //{
                //    return null;
                //}
                var assemblyName = BoundedContextMetadata.DomainAssemblyName;
                var objFullName = BoundedContextMetadata.AggregateNamespaces[entityName] + "." + entityName + "StateCreated";
                try
                {
                    return Assembly.Load(assemblyName).CreateInstance(objFullName);
                }
                catch (Exception ex)
                {
                    System.Diagnostics.Debug.WriteLine(ex.Message);
                    return null;
                }
            };
        }
    }
}
