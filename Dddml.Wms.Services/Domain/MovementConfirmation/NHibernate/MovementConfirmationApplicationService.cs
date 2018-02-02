using Dddml.Wms.Domain.InventoryItem;
using Dddml.Wms.Domain.Movement;
using Dddml.Wms.Domain.Movement.NHibernate;
using Dddml.Wms.Specialization;
using Dddml.Wms.Specialization.NHibernate;
using Dddml.Wms.Specialization.Spring;
using Spring.Transaction.Interceptor;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Dddml.Wms.Domain.MovementConfirmation.NHibernate
{
    public partial class MovementConfirmationApplicationService
    {
        IInventoryItemApplicationService InventoryItemApplicationService
        {
            get { return ApplicationContext.Current["inventoryItemApplicationService"] as IInventoryItemApplicationService; }
        }

        MovementApplicationService MovementApplicationService
        {
            get
            {
                var movService = ApplicationContext.Current["movementApplicationService"] as IMovementApplicationService;
                if (movService is MovementApplicationService)
                {
                    return (MovementApplicationService)movService;
                }
                var aopTarget = SpringUtils.GetAopTarget<MovementApplicationService>(movService);
                return aopTarget;
            }
        }

        private IIdGenerator<long, object, object> _seqIdGenerator = new TableIdGenerator();

        public IIdGenerator<long, object, object> SeqIdGenerator
        {
            get { return _seqIdGenerator; }
            set { _seqIdGenerator = value; }
        }

        [Transaction]
        public override void When(MovementConfirmationCommands.DocumentAction c)
        {
            if (c.Value == DocumentAction.Confirm)
            {
                var movConfirm = AssertDocumentStatus(c.DocumentNumber, DocumentStatusIds.InProgress);
                var movDocNumber = movConfirm.MovementDocumentNumber;
                var mov = AssertMovementDocumentStatusInProgress(movDocNumber);

                var quantitiesDict = GetQuantitiesDictionary(movConfirm);
                AssertAllLinesConfirmed(mov, quantitiesDict);

                var inventoryItemEntries = ConfirmMovementCreateInventoryItemEntries(mov, quantitiesDict);
                CreateOrUpdateInventoryItems(inventoryItemEntries);

                ConfirmUpdateMovement(c, mov);

                base.When(c);
            }
            else
            {
                base.When(c);
            }
        }

        private IMovementState AssertMovementDocumentStatusInProgress(string movDocNumber)
        {
            var mov = MovementApplicationService.Get(movDocNumber);
            if (mov == null)
            {
                throw new NullReferenceException(String.Format("Movement document number: {0}", movDocNumber));
            }
            if (mov.DocumentStatusId != DocumentStatusIds.InProgress)
            {
                throw new ApplicationException(String.Format("Error document status: {0}", mov.DocumentStatusId));
            }
            return mov;
        }

        private static IDictionary<string, Tuple<decimal, decimal, decimal>> GetQuantitiesDictionary(IMovementConfirmationState movConfirm)
        {
            var quantitiesDict = movConfirm.MovementConfirmationLines.ToDictionary(
                d => d.MovementLineNumber,
                d => new Tuple<decimal, decimal, decimal>(d.TargetQuantity, d.ConfirmedQuantity, d.ScrappedQuantity));

            foreach (var e in quantitiesDict)
            {
                var b = e.Value.Item1 == e.Value.Item2 + e.Value.Item3;
                if (!b)
                {
                    throw new ApplicationException(String.Format("Error movement confirmation line quantities. Movement line No.: {0}", e.Key));
                }
            }
            return quantitiesDict;
        }

        private static void AssertAllLinesConfirmed(IMovementState mov, IDictionary<string, Tuple<decimal, decimal, decimal>> quantitiesDict)
        {
            var movLineNotConfirmed = mov.MovementLines.Where(line => !quantitiesDict.ContainsKey(line.LineNumber)).FirstOrDefault();
            if (null != movLineNotConfirmed)
            {
                throw new NullReferenceException(String.Format("Movement line NOT found confirmation. Line No.: {0}", movLineNotConfirmed.LineNumber));
            }
        }

        private void ConfirmUpdateMovement(MovementConfirmationCommands.DocumentAction c, IMovementState mov)
        {
            MovementApplicationService.ConfirmUpdateMovement(new MovementCommands.DocumentAction()
            {
                DocumentNumber = mov.DocumentNumber,
                Version = mov.Version,
                CommandId = c.CommandId,
                RequesterId = c.RequesterId,
            });
        }

        private List<ICreateInventoryItemEntry> ConfirmMovementCreateInventoryItemEntries(IMovementState mov, IDictionary<string, Tuple<decimal, decimal, decimal>> quantitiesDict)
        {
            var inventoryItemEntries = global::Dddml.Wms.Domain.Movement.NHibernate.MovementApplicationService
                .ConfirmMovementCreateInventoryItemEntries(mov, line => quantitiesDict[line.LineNumber].Item2, // confirmedQuantity
                    () => SeqIdGenerator.GetNextId());
            return inventoryItemEntries;
        }

        private IMovementConfirmationState AssertDocumentStatus(string docNumber, string docStatus)
        {
            var movConfirm = StateRepository.Get(docNumber, true);
            if (movConfirm == null)
            {
                throw new ArgumentException(String.Format("Error document number: {0}", docNumber));
            }
            else
            {
                if (docStatus != movConfirm.DocumentStatusId)
                {
                    throw new ApplicationException(String.Format("Error document status: {0}", movConfirm.DocumentStatusId));
                }
            }
            return movConfirm;
        }

        /// <summary>
        /// 更新库存单元。
        /// </summary>
        /// <param name="inventoryItemEntries"></param>
        private void CreateOrUpdateInventoryItems(IList<ICreateInventoryItemEntry> inventoryItemEntries)
        {
            var invItemApplicationService = this.InventoryItemApplicationService;
            InventoryItemUtils.CreateOrUpdateInventoryItems(invItemApplicationService, inventoryItemEntries);
        }

    }
}
