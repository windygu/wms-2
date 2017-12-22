using Dddml.Wms.Domain.DocumentType;
using Dddml.Wms.Domain.MovementConfirmation;
using Dddml.Wms.Specialization;
using NUnit.Framework;
using System;

namespace Dddml.Wms.Services.Tests
{
    [TestFixture]
    public class MovementConfirmationTests : TestsBase
    {
        IMovementConfirmationApplicationService movementConfirmationApplicationService;

        [SetUp]
        public void SetUp()
        {
            base.SetUp();
            movementConfirmationApplicationService  = ApplicationContext.Current["movementConfirmationApplicationService"] as IMovementConfirmationApplicationService;
        }

        [Test]
        public void TestQuantityValidationLogic()
        {
            Assert.Catch<DomainError>(()=>{

                var createMoveConfirm = new CreateMovementConfirmation();

                createMoveConfirm.DocumentNumber = "Test" + DateTime.Now.Ticks;
                createMoveConfirm.Description = "Test";
                createMoveConfirm.CommandId = Guid.NewGuid().ToString();
                createMoveConfirm.DocumentTypeId = DocumentTypeIds.MovementConfirmation;
                var line_1 = createMoveConfirm.NewCreateMovementConfirmationLine();
                line_1.LineNumber = DateTime.Now.Ticks.ToString();
                // ///////////////////////
                line_1.TargetQuantity = 100;
                line_1.DifferenceQuantity = 1;
                line_1.ScrappedQuantity = 3;
                line_1.ConfirmedQuantity = 95;
                // ///////////////////////
                createMoveConfirm.MovementConfirmationLines.Add(line_1);
                movementConfirmationApplicationService.When(createMoveConfirm);

            });
        }
    }
}
