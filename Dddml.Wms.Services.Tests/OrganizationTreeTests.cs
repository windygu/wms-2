using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Party;
using Dddml.Wms.Domain.OrganizationStructure;
using Dddml.Wms.Domain.OrganizationStructureType;
using Dddml.Wms.Specialization;
using Dddml.Wms.Specialization.Spring;
using Dddml.Wms.Support;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace Dddml.Wms.Services.Tests
{
    [TestFixture]
    public class OrganizationTreeTests : TestsBase
    {

        IOrganizationTreeRepository organizationTreeRepository;

        IPartyApplicationService partyApplicationService;

        IOrganizationStructureApplicationService organizationStructureApplicationService;

        IOrganizationStructureTypeApplicationService organizationStructureTypeApplicationService;

        [SetUp]
        public void SetUp()
        {
            base.SetUp();

            organizationTreeRepository = ApplicationContext.Current["organizationTreeRepository"] as IOrganizationTreeRepository;
            partyApplicationService = ApplicationContext.Current["partyApplicationService"] as IPartyApplicationService;
            organizationStructureApplicationService = ApplicationContext.Current["organizationStructureApplicationService"] as IOrganizationStructureApplicationService;
            organizationStructureTypeApplicationService = ApplicationContext.Current["organizationStructureTypeApplicationService"] as IOrganizationStructureTypeApplicationService;

        }

        [Test]
        public void TestAddOrganizations()
        {
            var orgStructureTypeId = Guid.NewGuid().ToString();
            var orgStructureType = new CreateOrganizationStructureType();
            orgStructureType.Id = orgStructureTypeId;
            organizationStructureTypeApplicationService.When(orgStructureType);

            var organization1 = new CreateParty();//CreateOrganization();
            organization1.PartyTypeId = PartyTypeId.Organization;
            organization1.PartyId = Guid.NewGuid().ToString();
            organization1.OrganizationName = "Org_test_1" + organization1.PartyId;
            partyApplicationService.When(organization1);

            var organization2 = new CreateParty();//CreateOrganization();
            organization1.PartyTypeId = PartyTypeId.Organization;
            organization2.PartyId = Guid.NewGuid().ToString();
            organization2.OrganizationName = "Org_test_2" + organization2.PartyId;
            partyApplicationService.When(organization2);

            var orgStructure_0_1 = new CreateOrganizationStructure();
            var orgStructure_0_1_Id = new OrganizationStructureId(orgStructureTypeId, "", organization1.PartyId);
            orgStructure_0_1.Id = orgStructure_0_1_Id;
            organizationStructureApplicationService.When(orgStructure_0_1);

            var orgStructure_1_2 = new CreateOrganizationStructure();
            var orgStructure_1_2_Id = new OrganizationStructureId(orgStructureTypeId, organization1.PartyId, organization2.PartyId);
            orgStructure_1_2.Id = orgStructure_1_2_Id;
            organizationStructureApplicationService.When(orgStructure_1_2);

            var roots = organizationTreeRepository.GetRoots((IEnumerable<KeyValuePair<string, object>>)null, null).ToList();
            Assert.GreaterOrEqual(roots.Count, 1);
            Console.WriteLine(roots[0].Content.PartyId);
            if (roots != null && roots.Count > 0)
            {
                Assert.GreaterOrEqual(roots[0].Children.Count(), 1);
                foreach (var c in roots[0].Children)
                {
                    Console.WriteLine(c.Content.PartyId);
                }
            }

        }


        //private static void PrintAsJObject(object value, string name)
        //{
        //    JObject jObj = JObject.FromObject(value);
        //    Console.WriteLine("==================== Object [name = " + name + "] : ====================");
        //    Console.WriteLine(jObj.ToString());
        //    Console.WriteLine("==================== End Of Object [name = " + name + "] ====================");
        //}
    }


}
