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

            foreach (var g in extensionFieldGroups)
            {
                for (int i = 0; i < g.FieldCount; i++)
                {
                    var field = new CreateAttributeSetInstanceExtensionField();
                    //field.Index = i.ToString();
                    field.Name = String.Format(g.NameFormat, i);
                    field.Type = g.FieldType;
                    field.Length = g.FieldLength;
                    field.Active = true;
                    field.GroupId = g.Id;//g.Fields.Add(field);

                    attributeSetInstanceExtensionFieldApplicationService.When(field);
                }
            }
        }


    }
}
