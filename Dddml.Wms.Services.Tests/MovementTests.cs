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
using Dddml.Wms.Domain.MovementConfirmation;

namespace Dddml.Wms.Services.Tests
{
    [TestFixture]
    public class MovementTests : TestsBase
    {

        IMovementApplicationService movementApplicationService;

        IMovementConfirmationApplicationService movementConfirmationApplicationService;

        [SetUp]
        public void SetUp()
        {
            base.SetUp();

            movementApplicationService = ApplicationContext.Current["movementApplicationService"] as IMovementApplicationService;
            movementConfirmationApplicationService = ApplicationContext.Current["movementConfirmationApplicationService"] as IMovementConfirmationApplicationService;
        }

        [Test]
        public void TestCreateAndCompleteMovement()
        {
            //for (int i = 0; i < 10; i++)
            //{
            //    ContextualKeyRoutingConnectionProviderNextRandomRoutingKey();
            
            var documentNumber_0 = TestCreateAndCompleteMovement_0();
            
            var inTransitDocNumber_1 = TestCreateAndCompleteMovement_1();

            var documentNumber_1 = TestCreateAndCompleteAndReverseMovement_1();

            TestCreateAndCompleteAndConfirmMovement_0();
            
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

        private string TestCreateAndCompleteMovement_0()
        {
            var isInTransit = false; 
            var documentNumber = CreateAndCompleteTestMovement(isInTransit);
            return documentNumber;
        }

        private string TestCreateAndCompleteMovement_1()
        {
            var isInTransit = true;
            var documentNumber = CreateAndCompleteTestMovement(isInTransit);
            return documentNumber;
        }

        private string TestCreateAndCompleteAndConfirmMovement_0()
        {
            var isInTransit = true;
            var documentNumber = CreateAndCompleteTestMovement(isInTransit);

            var confirmDocNumber = "MC" + documentNumber;

            var movConfirm = movementConfirmationApplicationService.Get(confirmDocNumber);

            // //////////////////////////////////
            var updateMovConfirm = new MergePatchMovementConfirmation();
            updateMovConfirm.DocumentNumber = confirmDocNumber;
            updateMovConfirm.Version = 1;
            updateMovConfirm.CommandId = Guid.NewGuid().ToString();
            foreach (var line in movConfirm.MovementConfirmationLines)
            {
                var updateLine = updateMovConfirm.NewMergePatchMovementConfirmationLine();
                updateLine.LineNumber = line.LineNumber;
                updateLine.ConfirmedQuantity = line.TargetQuantity;
                updateMovConfirm.MovementConfirmationLineCommands.Add(updateLine);
            }
            movementConfirmationApplicationService.When(updateMovConfirm);

            // //////////////////////////////////
            var actionConfirm = new MovementConfirmationCommands.DocumentAction();
            actionConfirm.Value = DocumentAction.Confirm;
            actionConfirm.DocumentNumber = confirmDocNumber;
            actionConfirm.Version = 2;
            actionConfirm.CommandId = Guid.NewGuid().ToString();
            movementConfirmationApplicationService.When(actionConfirm);

            return actionConfirm.DocumentNumber;
        }

        private string CreateAndCompleteTestMovement(bool isInTransit)
        {

            var documentNumber = Guid.NewGuid().ToString();

            CreateMovement movement = new CreateMovement();
            movement.DocumentNumber = documentNumber;
            movement.CommandId = Guid.NewGuid().ToString();
            movement.WarehouseIdFrom = "1";
            movement.WarehouseIdTo = "2";
            //movement.DocumentAction = DocumentAction.Draft;// 不能这样写：movement.DocumentStatus = DocumentStatus.Drafted
            //movement.ChargeAmount = new Money(10000, "CNY");
            //movement.FreightAmount = new Money(400, "CNY");
            //movement.MovementTypeId = DocumentTypeIds.Movement;
            movement.MovementDate = DateTime.Now;
            
            //////////////////
            movement.IsInTransit = isInTransit;
            //////////////////

            var line_1 = movement.NewCreateMovementLine();
            line_1.LineNumber = DateTime.Now.Ticks.ToString();//todo
            line_1.ProductId = "TEST_" + DateTime.Now.Ticks.ToString();
            line_1.LocatorIdFrom = "1_TEST_F_" + DateTime.Now.Ticks.ToString();
            line_1.LocatorIdTo = "2_TEST_T_" + DateTime.Now.Ticks.ToString();
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

        private string TestCreateAndCompleteAndReverseMovement_1()
        {
            var documentNumber = Guid.NewGuid().ToString();

            CreateMovement movement = new CreateMovement();
            movement.DocumentNumber = documentNumber;
            movement.CommandId = Guid.NewGuid().ToString();
            movement.WarehouseIdFrom = "1";
            movement.WarehouseIdTo = "2";
            movement.MovementDate = DateTime.Now;
            movement.IsInTransit = false;//movement.IsInTransit = true;

            var line_1 = movement.NewCreateMovementLine();
            line_1.LineNumber = DateTime.Now.Ticks.ToString();//todo
            line_1.ProductId = "TEST_" + DateTime.Now.Ticks.ToString();
            line_1.LocatorIdFrom = "1_TEST_F_" + DateTime.Now.Ticks.ToString();
            line_1.LocatorIdTo = "2_TEST_T_" + DateTime.Now.Ticks.ToString();
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
            
            var reverse = new MovementCommands.DocumentAction();
            reverse.Value = DocumentAction.Reverse;
            reverse.DocumentNumber = documentNumber;
            reverse.Version = 2;
            reverse.CommandId = Guid.NewGuid().ToString();
            movementApplicationService.When(reverse);

            return documentNumber;

        }
    }


}
