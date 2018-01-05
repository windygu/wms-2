﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateMovementConfirmationLineMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.MovementConfirmationLineMvo;
using Dddml.Wms.Domain.MovementConfirmation;

namespace Dddml.Wms.Domain.MovementConfirmationLineMvo
{

	public abstract class MovementConfirmationLineMvoCommandDtoBase : ICommandDto, ICreateMovementConfirmationLineMvo, IMergePatchMovementConfirmationLineMvo, IDeleteMovementConfirmationLineMvo
	{

		MovementConfirmationLineId IAggregateCommand<MovementConfirmationLineId, long>.AggregateId
		{
			get
			{
				return ((ICreateOrMergePatchOrDeleteMovementConfirmationLineMvo)this).MovementConfirmationLineId;
			}
		}


		long IAggregateCommand<MovementConfirmationLineId, long>.AggregateVersion
		{
			get
			{
				return this.MovementConfirmationVersion;
			}
		}

		public virtual long MovementConfirmationVersion { get; set; }

		public virtual string RequesterId { get; set; }

		public virtual string CommandId { get; set; }

        object ICommand.RequesterId
        {
            get { return this.RequesterId; }
            set { this.RequesterId = (string)value; }
        }

        string ICommand.CommandId
        {
            get { return this.CommandId; }
            set { this.CommandId = value; }
        }

		public virtual MovementConfirmationLineIdDto MovementConfirmationLineId { get; set; }

		public virtual string MovementLineNumber { get; set; }

		public virtual decimal? TargetQuantity { get; set; }

		public virtual decimal? ConfirmedQuantity { get; set; }

		public virtual decimal? DifferenceQuantity { get; set; }

		public virtual decimal? ScrappedQuantity { get; set; }

		public virtual string Description { get; set; }

		public virtual bool? Processed { get; set; }

		public virtual long? Version { get; set; }

		public virtual bool? Active { get; set; }

		public virtual string MovementConfirmationDocumentStatusId { get; set; }

		public virtual string MovementConfirmationMovementDocumentNumber { get; set; }

		public virtual bool? MovementConfirmationIsApproved { get; set; }

		public virtual decimal? MovementConfirmationApprovalAmount { get; set; }

		public virtual bool? MovementConfirmationProcessed { get; set; }

		public virtual string MovementConfirmationProcessing { get; set; }

		public virtual string MovementConfirmationDocumentTypeId { get; set; }

		public virtual string MovementConfirmationDescription { get; set; }

		public virtual string MovementConfirmationCreatedBy { get; set; }

		public virtual DateTime? MovementConfirmationCreatedAt { get; set; }

		public virtual string MovementConfirmationUpdatedBy { get; set; }

		public virtual DateTime? MovementConfirmationUpdatedAt { get; set; }

		public virtual bool? MovementConfirmationActive { get; set; }

		public virtual bool? MovementConfirmationDeleted { get; set; }


        MovementConfirmationLineId IMovementConfirmationLineMvoCommand.MovementConfirmationLineId
        {
            get 
            {
                return this.MovementConfirmationLineId.ToMovementConfirmationLineId();
            }
            set 
            {
                this.MovementConfirmationLineId = new MovementConfirmationLineIdDtoWrapper(value);
            }
        }

		public virtual bool? IsPropertyMovementLineNumberRemoved { get; set; }

        bool IMergePatchMovementConfirmationLineMvo.IsPropertyMovementLineNumberRemoved
        {
            get
            {
                var b = this.IsPropertyMovementLineNumberRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyMovementLineNumberRemoved = value;
            }
        }

		public virtual bool? IsPropertyTargetQuantityRemoved { get; set; }

        bool IMergePatchMovementConfirmationLineMvo.IsPropertyTargetQuantityRemoved
        {
            get
            {
                var b = this.IsPropertyTargetQuantityRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyTargetQuantityRemoved = value;
            }
        }

		public virtual bool? IsPropertyConfirmedQuantityRemoved { get; set; }

        bool IMergePatchMovementConfirmationLineMvo.IsPropertyConfirmedQuantityRemoved
        {
            get
            {
                var b = this.IsPropertyConfirmedQuantityRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyConfirmedQuantityRemoved = value;
            }
        }

		public virtual bool? IsPropertyDifferenceQuantityRemoved { get; set; }

        bool IMergePatchMovementConfirmationLineMvo.IsPropertyDifferenceQuantityRemoved
        {
            get
            {
                var b = this.IsPropertyDifferenceQuantityRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyDifferenceQuantityRemoved = value;
            }
        }

		public virtual bool? IsPropertyScrappedQuantityRemoved { get; set; }

        bool IMergePatchMovementConfirmationLineMvo.IsPropertyScrappedQuantityRemoved
        {
            get
            {
                var b = this.IsPropertyScrappedQuantityRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyScrappedQuantityRemoved = value;
            }
        }

		public virtual bool? IsPropertyDescriptionRemoved { get; set; }

        bool IMergePatchMovementConfirmationLineMvo.IsPropertyDescriptionRemoved
        {
            get
            {
                var b = this.IsPropertyDescriptionRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyDescriptionRemoved = value;
            }
        }

		public virtual bool? IsPropertyProcessedRemoved { get; set; }

        bool IMergePatchMovementConfirmationLineMvo.IsPropertyProcessedRemoved
        {
            get
            {
                var b = this.IsPropertyProcessedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyProcessedRemoved = value;
            }
        }

		public virtual bool? IsPropertyVersionRemoved { get; set; }

        bool IMergePatchMovementConfirmationLineMvo.IsPropertyVersionRemoved
        {
            get
            {
                var b = this.IsPropertyVersionRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyVersionRemoved = value;
            }
        }

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IMergePatchMovementConfirmationLineMvo.IsPropertyActiveRemoved
        {
            get
            {
                var b = this.IsPropertyActiveRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyActiveRemoved = value;
            }
        }

		public virtual bool? IsPropertyMovementConfirmationDocumentStatusIdRemoved { get; set; }

        bool IMergePatchMovementConfirmationLineMvo.IsPropertyMovementConfirmationDocumentStatusIdRemoved
        {
            get
            {
                var b = this.IsPropertyMovementConfirmationDocumentStatusIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyMovementConfirmationDocumentStatusIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyMovementConfirmationMovementDocumentNumberRemoved { get; set; }

        bool IMergePatchMovementConfirmationLineMvo.IsPropertyMovementConfirmationMovementDocumentNumberRemoved
        {
            get
            {
                var b = this.IsPropertyMovementConfirmationMovementDocumentNumberRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyMovementConfirmationMovementDocumentNumberRemoved = value;
            }
        }

		public virtual bool? IsPropertyMovementConfirmationIsApprovedRemoved { get; set; }

        bool IMergePatchMovementConfirmationLineMvo.IsPropertyMovementConfirmationIsApprovedRemoved
        {
            get
            {
                var b = this.IsPropertyMovementConfirmationIsApprovedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyMovementConfirmationIsApprovedRemoved = value;
            }
        }

		public virtual bool? IsPropertyMovementConfirmationApprovalAmountRemoved { get; set; }

        bool IMergePatchMovementConfirmationLineMvo.IsPropertyMovementConfirmationApprovalAmountRemoved
        {
            get
            {
                var b = this.IsPropertyMovementConfirmationApprovalAmountRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyMovementConfirmationApprovalAmountRemoved = value;
            }
        }

		public virtual bool? IsPropertyMovementConfirmationProcessedRemoved { get; set; }

        bool IMergePatchMovementConfirmationLineMvo.IsPropertyMovementConfirmationProcessedRemoved
        {
            get
            {
                var b = this.IsPropertyMovementConfirmationProcessedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyMovementConfirmationProcessedRemoved = value;
            }
        }

		public virtual bool? IsPropertyMovementConfirmationProcessingRemoved { get; set; }

        bool IMergePatchMovementConfirmationLineMvo.IsPropertyMovementConfirmationProcessingRemoved
        {
            get
            {
                var b = this.IsPropertyMovementConfirmationProcessingRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyMovementConfirmationProcessingRemoved = value;
            }
        }

		public virtual bool? IsPropertyMovementConfirmationDocumentTypeIdRemoved { get; set; }

        bool IMergePatchMovementConfirmationLineMvo.IsPropertyMovementConfirmationDocumentTypeIdRemoved
        {
            get
            {
                var b = this.IsPropertyMovementConfirmationDocumentTypeIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyMovementConfirmationDocumentTypeIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyMovementConfirmationDescriptionRemoved { get; set; }

        bool IMergePatchMovementConfirmationLineMvo.IsPropertyMovementConfirmationDescriptionRemoved
        {
            get
            {
                var b = this.IsPropertyMovementConfirmationDescriptionRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyMovementConfirmationDescriptionRemoved = value;
            }
        }

		public virtual bool? IsPropertyMovementConfirmationCreatedByRemoved { get; set; }

        bool IMergePatchMovementConfirmationLineMvo.IsPropertyMovementConfirmationCreatedByRemoved
        {
            get
            {
                var b = this.IsPropertyMovementConfirmationCreatedByRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyMovementConfirmationCreatedByRemoved = value;
            }
        }

		public virtual bool? IsPropertyMovementConfirmationCreatedAtRemoved { get; set; }

        bool IMergePatchMovementConfirmationLineMvo.IsPropertyMovementConfirmationCreatedAtRemoved
        {
            get
            {
                var b = this.IsPropertyMovementConfirmationCreatedAtRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyMovementConfirmationCreatedAtRemoved = value;
            }
        }

		public virtual bool? IsPropertyMovementConfirmationUpdatedByRemoved { get; set; }

        bool IMergePatchMovementConfirmationLineMvo.IsPropertyMovementConfirmationUpdatedByRemoved
        {
            get
            {
                var b = this.IsPropertyMovementConfirmationUpdatedByRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyMovementConfirmationUpdatedByRemoved = value;
            }
        }

		public virtual bool? IsPropertyMovementConfirmationUpdatedAtRemoved { get; set; }

        bool IMergePatchMovementConfirmationLineMvo.IsPropertyMovementConfirmationUpdatedAtRemoved
        {
            get
            {
                var b = this.IsPropertyMovementConfirmationUpdatedAtRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyMovementConfirmationUpdatedAtRemoved = value;
            }
        }

		public virtual bool? IsPropertyMovementConfirmationActiveRemoved { get; set; }

        bool IMergePatchMovementConfirmationLineMvo.IsPropertyMovementConfirmationActiveRemoved
        {
            get
            {
                var b = this.IsPropertyMovementConfirmationActiveRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyMovementConfirmationActiveRemoved = value;
            }
        }

		public virtual bool? IsPropertyMovementConfirmationDeletedRemoved { get; set; }

        bool IMergePatchMovementConfirmationLineMvo.IsPropertyMovementConfirmationDeletedRemoved
        {
            get
            {
                var b = this.IsPropertyMovementConfirmationDeletedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyMovementConfirmationDeletedRemoved = value;
            }
        }


        string ICommandDto.CommandType 
        {
            get { return this.GetCommandType(); }
        }

        protected abstract string GetCommandType();

	}


    public class CreateOrMergePatchOrDeleteMovementConfirmationLineMvoDto : MovementConfirmationLineMvoCommandDtoBase
    {
        private string _commandType;

        public virtual string CommandType
        {
            get { return _commandType; }
            set { _commandType = value; }
        }

        protected override string GetCommandType()
        {
            return this._commandType;
        }

    }



	public class CreateMovementConfirmationLineMvoDto : CreateOrMergePatchOrDeleteMovementConfirmationLineMvoDto
	{

        public override string CommandType
        {
            get { return this.GetCommandType(); }
            set { 
				// do nothing
            }
        }

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Create;
        }

	}


	public class MergePatchMovementConfirmationLineMvoDto : CreateOrMergePatchOrDeleteMovementConfirmationLineMvoDto
	{

        public override string CommandType
        {
            get { return this.GetCommandType(); }
            set { 
				// do nothing
            }
        }

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.MergePatch;
        }

	}

	public class DeleteMovementConfirmationLineMvoDto : CreateOrMergePatchOrDeleteMovementConfirmationLineMvoDto
	{
        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Delete;
        }


        public override string CommandType
        {
            get { return this.GetCommandType(); }
            set { 
				// do nothing
            }
        }

	}

    public static partial class MovementConfirmationLineMvoCommandDtos
    {

    }

}

