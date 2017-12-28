using Dddml.Wms.Domain;
using Dddml.Wms.Domain.AttributeSetInstanceExtensionField;
using Dddml.Wms.Domain.AttributeSetInstanceExtensionFieldGroup;
using Dddml.Wms.Specialization;
using Dddml.Wms.Specialization.Spring;
using Dddml.Wms.Support;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dddml.Wms.Services.Tests
{

    [TestFixture]
    public class AttributeSetInstanceExtensionFieldUtilsTests : TestsBase
    {

        IAttributeSetInstanceExtensionFieldGroupApplicationService attributeSetInstanceExtensionFieldGroupApplicationService;

        IAttributeSetInstanceExtensionFieldApplicationService attributeSetInstanceExtensionFieldApplicationService;


        [SetUp]
        public void SetUp()
        {
            base.SetUp();

            attributeSetInstanceExtensionFieldGroupApplicationService
                = ApplicationContext.Current["attributeSetInstanceExtensionFieldGroupApplicationService"] as IAttributeSetInstanceExtensionFieldGroupApplicationService;
            attributeSetInstanceExtensionFieldApplicationService
                = ApplicationContext.Current["attributeSetInstanceExtensionFieldApplicationService"] as IAttributeSetInstanceExtensionFieldApplicationService;
        }

        [Test]
        public void TestCreateAttributeSetInstanceExtensionFieldGroups()
        {
            var extensionFieldGroups = AttributeSetInstanceExtensionFieldUtils.CreateAttributeSetInstanceExtensionFieldGroups();

            foreach (var g in extensionFieldGroups)
            {
                attributeSetInstanceExtensionFieldGroupApplicationService.When(g);
            }

            var extensionFields = AttributeSetInstanceExtensionFieldUtils.CreateAttributeSetInstanceExtensionFields();
            foreach (var f in extensionFields)
            {
                attributeSetInstanceExtensionFieldApplicationService.When(f);
            }
        }


    }
}
