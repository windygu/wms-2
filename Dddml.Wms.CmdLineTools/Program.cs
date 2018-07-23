using Dddml.Core.Dom;
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
            // ////////////////////////////////////////////////
            //new LineCounter().Count();
            //System.Console.ReadKey();
            //return;

            var aggregates = GetAggaregates();

            UpdateDomainProjects(aggregates);

            UpdateHibernateProjects(aggregates);

            UpdateRestfulClientProjects(aggregates);

            Console.WriteLine("Ok!");
            Console.ReadKey();

        }

        private static void UpdateRestfulClientProjects(IList<Aggregate> aggregates)
        {
            // ///////////////////////////////////////////////////////
            var javaRestDomainProjConfig = new ProjectConfiguration
            {
                DomainProjectEnabled = false,
                RestfulClientDomainProjectEnabled = false,
                DomainProjectNHibernateEnabled = false,

                JavaDomainProjectEnabled = false,
                //JavaDomainMsbProjectFilePath = @"...",
                //JavaDomainProjectDirectoryPath = javaDomainProjDir,
                //JavaDomainProjectName = javaDomainProjName,
                //JavaDomainSubDirectoryPath = @"...",
                //JavaSrcGeneratedJavaSubDirectoryPath = @"src\generated\java",

                // ////////////////////////////////////////////////////////
                BoundedContextJavaPackageName = "org.dddml.wms",
                JavaRestfulClientDomainMsbProjectFilePath = @"..\..\..\java\Dddml.Wms.JavaRestful.Client\Dddml.Wms.JavaRestful.Client.csproj",
                //JavaRestfulClientDomainProjectName = "Dddml.Wms.JavaRestful.Client",
                JavaRestfulClientDomainProjectEnabled = true,
                // ////////////////////////////////////////////////////////

                JavaDomainProjectHibernateEnabled = false,
                //DomainSubDirectoryPath = @"Generated\Domain",
            };

            var javaRestDomainProjectGenerator = new DomainAggregateT4ScriptGenerator(javaRestDomainProjConfig);
            javaRestDomainProjectGenerator.IsMViewObjectDisabled = true;
            javaRestDomainProjectGenerator.CreateAggregatesDirectoriesAndScripts(aggregates);
            javaRestDomainProjectGenerator.CleanAggregatesDirectoriesAndScripts(aggregates);
        }

        private static void UpdateHibernateProjects(IList<Aggregate> aggregates)
        {

            var hibernateProjectConfig = new ProjectConfiguration
            {
                DomainProjectEnabled = false,
                DomainProjectNHibernateEnabled = false,
                RestfulClientDomainProjectEnabled = false,

                JavaDomainProjectEnabled = false,
                JavaRestfulClientDomainProjectEnabled = false,
                JavaDomainProjectHibernateEnabled = false,

                // //////////////////////////////
                NHibernateProjectEnabled = true,
                NHibernateMsbProjectFilePath = @"..\..\..\Dddml.Wms.Services\Dddml.Wms.Services.csproj",
                DomainSubDirectoryPath = @"Generated\Domain",
                //T4GenerateAggregateDomainScriptTemplateIncludeFile = @"..\..\..\LoadBoundedContext.tt",
                T4GenerateAggregateDomainNHibernateScriptTemplateIncludeFile = @"..\..\..\..\LoadBoundedContext.tt",

                // //////////////////////////////
                JavaHibernateProjectEnabled = true,
                JavaHibernateMsbProjectFilePath = @"..\..\..\java\Dddml.Wms.JavaServices\Dddml.Wms.JavaServices.csproj",
                JavaDomainSubDirectoryPath = @"src\generated\java\org\dddml\wms\domain",
                //T4JavaGenerateAggregateDomainScriptTemplateIncludeFile = @"..\..\LoadBoundedContext.tt",
                T4JavaGenerateAggregateDomainHibernateScriptTemplateIncludeFile = @"..\..\..\LoadBoundedContext.tt",

            };

            var hibernateProjectGenerator = new DomainAggregateT4ScriptGenerator(hibernateProjectConfig);
            hibernateProjectGenerator.IsMViewObjectDisabled = true;
            hibernateProjectGenerator.CreateAggregatesDirectoriesAndScripts(aggregates);
            hibernateProjectGenerator.CleanAggregatesDirectoriesAndScripts(aggregates);
        }

        private static void UpdateDomainProjects(IList<Aggregate> aggregates)
        {
            // ////////////////////////////////////////////////
            var domainProjectConfig = new ProjectConfiguration
            {

                //RestfulClientDomainProjectFilePath = @"..\..\..\Dddml.Wms.HttpServices.RestfulClient\Dddml.Wms.HttpServices.RestfulClient.csproj",
                RestfulClientDomainProjectEnabled = false,
                //JavaRestfulClientDomainProjectFilePath = @"..\..\..\java\Dddml.Wms.JavaRestful.Client\Dddml.Wms.JavaRestful.Client.csproj",
                JavaRestfulClientDomainProjectEnabled = false,

                // ///////////////////////////////////////////
                DomainProjectEnabled = true,
                DomainMsbProjectFilePath = @"..\..\..\Dddml.Wms.Common\Dddml.Wms.Common.csproj",
                //T4GenerateAggregateDomainNHibernateScriptTemplateIncludeFile = @"..\..\..\..\LoadBoundedContext.tt",
                DomainProjectNHibernateEnabled = false,
                DomainSubDirectoryPath = @"Generated\Domain",
                T4GenerateAggregateDomainScriptTemplateIncludeFile = @"..\..\..\LoadBoundedContext.tt",

                // ///////////////////////////////////////////
                JavaDomainProjectEnabled = true,
                JavaDomainMsbProjectFilePath = @"..\..\..\java\Dddml.Wms.JavaCommon\Dddml.Wms.JavaCommon.csproj",
                //T4JavaGenerateAggregateDomainHibernateScriptTemplateIncludeFile = @"..\..\..\LoadBoundedContext.tt",
                JavaDomainProjectHibernateEnabled = false,
                JavaDomainSubDirectoryPath = @"src\generated\java\org\dddml\wms\domain",
                T4JavaGenerateAggregateDomainScriptTemplateIncludeFile = @"..\..\LoadBoundedContext.tt",

            };

            var domainProjectGenerator = new DomainAggregateT4ScriptGenerator(domainProjectConfig);
            domainProjectGenerator.IsMViewObjectDisabled = true;
            domainProjectGenerator.CreateAggregatesDirectoriesAndScripts(aggregates);
            domainProjectGenerator.CleanAggregatesDirectoriesAndScripts(aggregates);
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
            //boundedContext.GenerateAllEntityMViewObjectsAndRefresh();

            return boundedContext;
        }
    }

}
