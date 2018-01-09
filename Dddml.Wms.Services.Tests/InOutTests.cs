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

namespace Dddml.Wms.Services.Tests
{
    [TestFixture]
    public class InOutTests : TestsBase
    {

        IInOutApplicationService inOutApplicationService;

        [SetUp]
        public void SetUp()
        {
            base.SetUp();
            
            inOutApplicationService = ApplicationContext.Current["inOutApplicationService"] as IInOutApplicationService;
        }

        [Test]
        public void TestCreateAndCompleteInOut()
        {
            //for (int i = 0; i < 10; i++)
            //{
            //    ContextualKeyRoutingConnectionProviderNextRandomRoutingKey();
            var documentNumber = TestCreateAndComplateInOut_0();
            TestReverseInOut(documentNumber);
            //}
        }

        
        private void TestReverseInOut(string documentNumber)
        {
            var reverse = new InOutCommands.Reverse();
            reverse.CommandId = Guid.NewGuid().ToString();
            reverse.Version = 2;
            reverse.DocumentNumber = documentNumber;
            inOutApplicationService.When(reverse);
        }

        private string TestCreateAndComplateInOut_0()
        {
            var documentNumber = Guid.NewGuid().ToString();

            CreateInOut inOut = new CreateInOut();
            inOut.DocumentNumber = documentNumber;
            inOut.CommandId = Guid.NewGuid().ToString();
            //inOut.DocumentAction = DocumentAction.Draft;// 不能这样写：inOut.DocumentStatus = DocumentStatus.Drafted
            //inOut.ChargeAmount = new Money(10000, "CNY");
            //inOut.FreightAmount = new Money(400, "CNY");
            inOut.MovementTypeId = MovementTypeIds.MiscellaneousIn;

            var line_1 = inOut.NewCreateInOutLine();
            line_1.LineNumber = DateTime.Now.Ticks.ToString();//todo
            line_1.ProductId = "TEST_" + DateTime.Now.Ticks.ToString();
            line_1.LocatorId = "TEST_" + DateTime.Now.Ticks.ToString();
            line_1.AttributeSetInstanceId = "EMPTY";
            line_1.MovementQuantity = 123;
            inOut.InOutLines.Add(line_1);
            
            inOutApplicationService.When(inOut);

            var complete = new InOutCommands.Complete();
            complete.DocumentNumber = documentNumber;
            complete.Version = 1;
            complete.CommandId = Guid.NewGuid().ToString();
            inOutApplicationService.When(complete);

            return documentNumber;
            /*
            MergePatchInOut patchInOut = new MergePatchInOut();
            patchInOut.DocumentNumber = documentNumber;
            patchInOut.DocumentAction = DocumentAction.Void;//不能这样写：patchInOut.DocumentStatus = DocumentStatus.Voided
            patchInOut.Version = 1;
            patchInOut.CommandId = Guid.NewGuid().ToString();
            inOutApplicationService.When(patchInOut);
            var inOutResult = inOutApplicationService.Get(inOut.DocumentNumber);
            //Console.WriteLine(inOutResult.DocumentNumber);
            Assert.AreEqual(DocumentStatusIds.Voided, inOutResult.DocumentStatusId);
            //Console.WriteLine(inOutResult.FreightAmount);
            //Assert.AreEqual(inOut.FreightAmount, inOutResult.FreightAmount);
            //Console.WriteLine(inOutResult.ChargeAmount);
            //Assert.AreEqual(inOut.ChargeAmount, inOutResult.ChargeAmount);
            */

        }


    }


}
