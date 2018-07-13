﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateMovementConfirmationDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.MovementConfirmation;

namespace Dddml.Wms.Domain.MovementConfirmation
{

	public abstract class MovementConfirmationCommandDtoBase : ICommandDto, ICreateMovementConfirmation, IMergePatchMovementConfirmation, IDeleteMovementConfirmation
	{

		string IAggregateCommand<string, long>.AggregateId
		{
			get
			{
				return ((ICreateOrMergePatchOrDeleteMovementConfirmation)this).DocumentNumber;
			}
		}


		long IAggregateCommand<string, long>.AggregateVersion
		{
			get
			{
				return this.Version != null ? this.Version.Value : default(long);
			}
		}

        long IMovementConfirmationCommand.Version
        {
            get { return this.Version != null ? this.Version.Value : default(long); }
            set { this.Version = value; }
        }

		public virtual long? Version { get; set; }

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

		public virtual string DocumentNumber { get; set; }

		public virtual string MovementDocumentNumber { get; set; }

		public virtual bool? IsApproved { get; set; }

		public virtual decimal? ApprovalAmount { get; set; }

		public virtual bool? Processed { get; set; }

		public virtual string Processing { get; set; }

		public virtual string DocumentTypeId { get; set; }

		public virtual string Description { get; set; }

		public virtual bool? Active { get; set; }

		public virtual bool? IsPropertyMovementDocumentNumberRemoved { get; set; }

        bool IMergePatchMovementConfirmation.IsPropertyMovementDocumentNumberRemoved
        {
            get
            {
                var b = this.IsPropertyMovementDocumentNumberRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyMovementDocumentNumberRemoved = value;
            }
        }

		public virtual bool? IsPropertyIsApprovedRemoved { get; set; }

        bool IMergePatchMovementConfirmation.IsPropertyIsApprovedRemoved
        {
            get
            {
                var b = this.IsPropertyIsApprovedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyIsApprovedRemoved = value;
            }
        }

		public virtual bool? IsPropertyApprovalAmountRemoved { get; set; }

        bool IMergePatchMovementConfirmation.IsPropertyApprovalAmountRemoved
        {
            get
            {
                var b = this.IsPropertyApprovalAmountRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyApprovalAmountRemoved = value;
            }
        }

		public virtual bool? IsPropertyProcessedRemoved { get; set; }

        bool IMergePatchMovementConfirmation.IsPropertyProcessedRemoved
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

		public virtual bool? IsPropertyProcessingRemoved { get; set; }

        bool IMergePatchMovementConfirmation.IsPropertyProcessingRemoved
        {
            get
            {
                var b = this.IsPropertyProcessingRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyProcessingRemoved = value;
            }
        }

		public virtual bool? IsPropertyDocumentTypeIdRemoved { get; set; }

        bool IMergePatchMovementConfirmation.IsPropertyDocumentTypeIdRemoved
        {
            get
            {
                var b = this.IsPropertyDocumentTypeIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyDocumentTypeIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyDescriptionRemoved { get; set; }

        bool IMergePatchMovementConfirmation.IsPropertyDescriptionRemoved
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

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IMergePatchMovementConfirmation.IsPropertyActiveRemoved
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

        ICreateMovementConfirmationLineCommands ICreateMovementConfirmation.MovementConfirmationLines
        {
            get
            {
                return this._movementConfirmationLines;
            }
        }

        IMovementConfirmationLineCommands IMergePatchMovementConfirmation.MovementConfirmationLineCommands
        {
            get
            {
                return this._movementConfirmationLines;
            }
        }

        public virtual CreateMovementConfirmationLineDto NewCreateMovementConfirmationLine()
        {
            var c = new CreateMovementConfirmationLineDto();
            c.MovementConfirmationDocumentNumber = this.DocumentNumber;

            return c;
        }

        ICreateMovementConfirmationLine ICreateMovementConfirmation.NewCreateMovementConfirmationLine()
        {
            return this.NewCreateMovementConfirmationLine();
        }

        ICreateMovementConfirmationLine IMergePatchMovementConfirmation.NewCreateMovementConfirmationLine()
        {
            return this.NewCreateMovementConfirmationLine();
        }

        public virtual MergePatchMovementConfirmationLineDto NewMergePatchMovementConfirmationLine()
        {
            var c = new MergePatchMovementConfirmationLineDto();
            c.MovementConfirmationDocumentNumber = this.DocumentNumber;

            return c;
        }

        IMergePatchMovementConfirmationLine IMergePatchMovementConfirmation.NewMergePatchMovementConfirmationLine()
        {
            return this.NewMergePatchMovementConfirmationLine();
        }

        public virtual RemoveMovementConfirmationLineDto NewRemoveMovementConfirmationLine()
        {
            var c = new RemoveMovementConfirmationLineDto();
            c.MovementConfirmationDocumentNumber = this.DocumentNumber;

            return c;
        }

        IRemoveMovementConfirmationLine IMergePatchMovementConfirmation.NewRemoveMovementConfirmationLine()
        {
            return this.NewRemoveMovementConfirmationLine();
        }

        private CreateOrMergePatchOrRemoveMovementConfirmationLineDtos _movementConfirmationLines = new CreateOrMergePatchOrRemoveMovementConfirmationLineDtos();

        public virtual CreateOrMergePatchOrRemoveMovementConfirmationLineDto[] MovementConfirmationLines
        {
            get
            {
                return _movementConfirmationLines.ToArray();
            }
            set
            {
                _movementConfirmationLines.Clear();
                _movementConfirmationLines.AddRange(value);
            }
        }


        string ICommandDto.CommandType 
        {
            get { return this.GetCommandType(); }
        }

        protected abstract string GetCommandType();

	}


    public class CreateOrMergePatchOrDeleteMovementConfirmationDto : MovementConfirmationCommandDtoBase
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



	public class CreateMovementConfirmationDto : CreateOrMergePatchOrDeleteMovementConfirmationDto
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


	public class MergePatchMovementConfirmationDto : CreateOrMergePatchOrDeleteMovementConfirmationDto
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

	public class DeleteMovementConfirmationDto : CreateOrMergePatchOrDeleteMovementConfirmationDto
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

    public static partial class MovementConfirmationCommandDtos
    {

        public class DocumentActionRequestContent : ICommandDto
        {

            public string CommandType
            {
                get { return "DocumentAction"; }
            }

            public string Value { get; set; }

            public string DocumentNumber { get; set; }

            public long Version { get; set; }

            public string CommandId { get; set; }

            public string RequesterId { get; set; }

            public MovementConfirmationCommands.DocumentAction ToDocumentAction()
            {
                var cmd = new MovementConfirmationCommands.DocumentAction();
                cmd.Value = this.Value;
                cmd.DocumentNumber = this.DocumentNumber;
                cmd.Version = this.Version;
                cmd.CommandId = this.CommandId;
                cmd.RequesterId = this.RequesterId;
                return cmd;
            }

        }

    }

}

