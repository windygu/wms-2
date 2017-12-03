﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryPostingRuleDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryPostingRule;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.InventoryPostingRule
{

	public abstract class InventoryPostingRuleCommandDtoBase : ICommandDto, ICreateInventoryPostingRule, IMergePatchInventoryPostingRule, IDeleteInventoryPostingRule
	{

		string IAggregateCommand<string, long>.AggregateId
		{
			get
			{
				return ((ICreateOrMergePatchOrDeleteInventoryPostingRule)this).InventoryPostingRuleId;
			}
		}


		long IAggregateCommand<string, long>.AggregateVersion
		{
			get
			{
				return this.Version;
			}
		}

		public virtual long Version { get; set; }

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

		public virtual string InventoryPostingRuleId { get; set; }


		public virtual InventoryItemIdDto Trigger { get; set; }

        InventoryItemId ICreateOrMergePatchOrDeleteInventoryPostingRule.Trigger
        {
            get 
            {
                return (this.Trigger == null) ? null : this.Trigger.ToInventoryItemId();
            }
            set 
            {
                this.Trigger = (value == null) ? null : new InventoryItemIdDtoWrapper(value);
            }
        }


		public virtual InventoryItemIdDto Output { get; set; }

        InventoryItemId ICreateOrMergePatchOrDeleteInventoryPostingRule.Output
        {
            get 
            {
                return (this.Output == null) ? null : this.Output.ToInventoryItemId();
            }
            set 
            {
                this.Output = (value == null) ? null : new InventoryItemIdDtoWrapper(value);
            }
        }

		public virtual bool? Active { get; set; }

		public virtual bool? IsPropertyTriggerRemoved { get; set; }

        bool IMergePatchInventoryPostingRule.IsPropertyTriggerRemoved
        {
            get
            {
                var b = this.IsPropertyTriggerRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyTriggerRemoved = value;
            }
        }

		public virtual bool? IsPropertyOutputRemoved { get; set; }

        bool IMergePatchInventoryPostingRule.IsPropertyOutputRemoved
        {
            get
            {
                var b = this.IsPropertyOutputRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyOutputRemoved = value;
            }
        }

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IMergePatchInventoryPostingRule.IsPropertyActiveRemoved
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


        string ICommandDto.CommandType 
        {
            get { return this.GetCommandType(); }
        }

        protected abstract string GetCommandType();

	}


    public class CreateOrMergePatchOrDeleteInventoryPostingRuleDto : InventoryPostingRuleCommandDtoBase
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



	public class CreateInventoryPostingRuleDto : CreateOrMergePatchOrDeleteInventoryPostingRuleDto
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


	public class MergePatchInventoryPostingRuleDto : CreateOrMergePatchOrDeleteInventoryPostingRuleDto
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

	public class DeleteInventoryPostingRuleDto : CreateOrMergePatchOrDeleteInventoryPostingRuleDto
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

    public static partial class InventoryPostingRuleCommandDtos
    {

    }

}

