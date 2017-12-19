using Dddml.Wms.Specialization;
using Dddml.Wms.Domain.Metadata;
using Dddml.Ofbiz.Processors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Reflection;


namespace Dddml.Wms.Services.Tests
{
    public class XmlDataLoader
    {
        public void Process(string path)
        {
            var entityDataProcessor = new EntityDataProcessor();
            entityDataProcessor.Process(path, "*Data.xml",
                GetEntityInstanceFactory(),
                (entityName, targetObject, attributeName, attributeValue) =>
                {
                    var pName = AttributeNameToPropertyName(attributeName);
                    var pValue = attributeValue;
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

        private static string AttributeNameToPropertyName(string attributeName)
        {
            // /////////////////////////////////////
            //todo Chaining Property Name
            // /////////////////////////////////////
            return attributeName.Substring(0, 1).ToUpperInvariant() + attributeName.Substring(1);
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
