using Dddml.Core.Domain;
using Dddml.Serialization;
using Dddml.T4.ProjectTools;
using Dddml.T4.Extensions;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.CmdLineTools
{
    class Program
    {
        static void Main(string[] args)
        {
            var config = new ProjectConfiguration
            {
                DomainProjectFilePath = @"..\..\..\Dddml.Wms.Common\Dddml.Wms.Common.csproj",

                //RestfulClientDomainProjectFilePath = @"..\..\..\Dddml.Wms.HttpServices.RestfulClient\Dddml.Wms.HttpServices.RestfulClient.csproj",
                RestfulClientDomainProjectEnabled = false,

                JavaDomainProjectFilePath = @"..\..\..\Dddml.Wms.JavaCommon\Dddml.Wms.JavaCommon.csproj",

                //JavaRestfulClientDomainProjectFilePath = @"..\..\..\Dddml.Wms.JavaRestfulClient\Dddml.Wms.JavaRestfulClient.csproj",
                JavaRestfulClientDomainProjectEnabled = false,

                T4GenerateAggregateDomainScriptTemplateIncludeFile = @"..\..\..\LoadBoundedContext.tt",

                //T4GenerateAggregateDomainNHibernateScriptTemplateIncludeFile = @"..\..\..\..\LoadBoundedContext.tt",
                DomainNHibernateEnabled = false,

                T4JavaGenerateAggregateDomainScriptTemplateIncludeFile = @"..\..\LoadBoundedContext.tt",

                //T4JavaGenerateAggregateDomainHibernateScriptTemplateIncludeFile = @"..\..\..\LoadBoundedContext.tt",
                JavaDomainHibernateEnabled = false,

                DomainSubDirectoryPath = @"Generated\Domain",

                JavaDomainSubDirectoryPath = @"src\main\java\org\dddml\wms\domain"


            };

            var generator = new DomainAggregateT4ScriptGenerator(config);
            var aggregates = GetAggaregates();
            generator.CreateAggregatesDirectoriesAndScripts(aggregates);

            Console.WriteLine("Ok!");
            Console.ReadKey();

        }

        private static IList<Aggregate> GetAggaregates()
        {
            var boundedContext = LoadBoundedContext();

            var aggregates = new List<Aggregate>();
            foreach (var agg in boundedContext.Aggregates.Values)
            {
                //string aggName = agg.Name;
                //if (aggName.StartsWith("Account") || aggName.Equals("Entry") || aggName.Equals("PostingRule"))
                //{
                //    continue;
                //}
                aggregates.Add(agg);
            }

            return aggregates;
        }

        private static BoundedContext LoadBoundedContext()
        {
            //string projectFile = TransformationContext.Current.GetPropertyValue("MSBuildProjectFullPath");
            string projectDir = "../..";//System.IO.Path.GetDirectoryName(projectFile);

            var excludedFiles = new List<string>();
            excludedFiles.Add("Audience.yaml");
            excludedFiles.Add("IdentityManagement.yaml");
            excludedFiles.Add("AccessManagement.yaml");

            string filePath1 = System.IO.Path.Combine(projectDir, "../Dddml.Wms.Metadata/AttributeSetInstanceDddml.yaml");
            string filePath2 = System.IO.Path.Combine(projectDir, "../Dddml.Wms.Metadata/AttributeSetInstanceExtensionFieldGroupDddml.yaml");
            var additionalFiles = new List<string>();
            additionalFiles.Add(filePath1);
            additionalFiles.Add(filePath2);

            var dddmlDir = System.IO.Path.Combine(projectDir, "..\\dddml");

            BoundedContext boundedContext = BoundedContextUtils.LoadFromDirectory(dddmlDir, "*.yaml", excludedFiles, additionalFiles);

            boundedContext.Refresh();
            boundedContext.GenerateAllEntityMViewObjectsAndRefresh();

            return boundedContext;
        }
    }

}
