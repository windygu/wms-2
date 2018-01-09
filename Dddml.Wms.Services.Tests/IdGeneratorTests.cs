using Dddml.Wms.Domain;
using Dddml.Wms.Specialization;
using Dddml.Wms.Specialization.Spring;
using Dddml.Wms.Support;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;
using NodaMoney;
using Dddml.Support.NHibernate;
using Dddml.Wms.Domain.InOut;
using Dddml.Wms.Domain.MovementType;
using Dddml.Wms.Specialization.NHibernate;

namespace Dddml.Wms.Services.Tests
{
    [TestFixture]
    public class IdGeneratorTests : TestsBase
    {

        IInOutApplicationService inOutApplicationService;

        [SetUp]
        public void SetUp()
        {
            base.SetUp();
        }

        [Test]
        public void TestGenerateId()
        {
            var tableIdGen = new TableIdGenerator();
            for (int i = 0; i < 10; i++)
            {
                var id_1 = tableIdGen.GetNextId();
                Console.WriteLine(id_1);
            }
        }

    }


}
