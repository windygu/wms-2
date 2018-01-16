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
using Dddml.Wms.Domain.Movement;
using Dddml.Wms.Domain.MovementType;
using Dddml.Wms.Domain.DocumentType;

namespace Dddml.Wms.Services.Tests
{
    [TestFixture]
    public class MovementTests : TestsBase
    {

        IMovementApplicationService movementApplicationService;

        [SetUp]
        public void SetUp()
        {
            base.SetUp();
            
            movementApplicationService = ApplicationContext.Current["movementApplicationService"] as IMovementApplicationService;
        }

        [Test]
        public void TestCreateAndCompleteMovement()
        {
            //for (int i = 0; i < 10; i++)
            //{
            //    ContextualKeyRoutingConnectionProviderNextRandomRoutingKey();
            var documentNumber = TestCreateAndComplateMovement_0();
            //TestReverseMovement(documentNumber);
            //}
        }

        
        //private void TestReverseMovement(string documentNumber)
        //{
        //    var reverse = new MovementCommands.Reverse();
        //    reverse.CommandId = Guid.NewGuid().ToString();
        //    reverse.Version = 2;
        //    reverse.DocumentNumber = documentNumber;
        //    movementApplicationService.When(reverse);
        //}

        private string TestCreateAndComplateMovement_0()
        {
            var documentNumber = Guid.NewGuid().ToString();

            CreateMovement movement = new CreateMovement();
            movement.DocumentNumber = documentNumber;
            movement.CommandId = Guid.NewGuid().ToString();
            //movement.DocumentAction = DocumentAction.Draft;// 不能这样写：movement.DocumentStatus = DocumentStatus.Drafted
            //movement.ChargeAmount = new Money(10000, "CNY");
            //movement.FreightAmount = new Money(400, "CNY");
            //movement.MovementTypeId = DocumentTypeIds.Movement;
            movement.IsInTransit = false;

            var line_1 = movement.NewCreateMovementLine();
            line_1.LineNumber = DateTime.Now.Ticks.ToString();//todo
            line_1.ProductId = "TEST_" + DateTime.Now.Ticks.ToString();
            line_1.LocatorIdFrom = "TEST_From_" + DateTime.Now.Ticks.ToString();
            line_1.LocatorIdTo = "TEST_To_" + DateTime.Now.Ticks.ToString();
            line_1.AttributeSetInstanceId = "EMPTY";
            line_1.MovementQuantity = 123;
            movement.MovementLines.Add(line_1);
            
            movementApplicationService.When(movement);

            var complete = new MovementCommands.DocumentAction();
            complete.Value = DocumentAction.Complete;
            complete.DocumentNumber = documentNumber;
            complete.Version = 1;
            complete.CommandId = Guid.NewGuid().ToString();
            movementApplicationService.When(complete);

            return documentNumber;
         
        }


    }


}
