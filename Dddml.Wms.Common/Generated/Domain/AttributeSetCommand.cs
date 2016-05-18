﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Domain;

using Dddml.Wms.Specialization;

namespace Dddml.Wms.Domain
{

	public abstract class AttributeSetCommandBase : AttributeSetStateProperties, IAttributeSetCommand
	{

		string IAggregateCommand<string, long>.AggregateId
		{
			get
			{
				return this.AttributeSetId;
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

		public virtual string RequesterId { get; set; }//TODO RequesterId 应该是可以支持自定义名称

		public virtual string CommandId { get; set; }//TODO CommandId 太特殊了！！！应该可以支持自定义名称（即不一定要叫 CommandId）

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

	}

	public class CreateAttributeSet : AttributeSetCommandBase, ICreateAttributeSet
	{
		
		public CreateAttributeSet ()
		{
		}


        private CreateAttributeUseCommands _attributeUses = new CreateAttributeUseCommands();

        public ICreateAttributeUseCommands AttributeUses
        {
            get
            {
                return this._attributeUses;
            }
        }

        public CreateAttributeUse NewCreateAttributeUse()
        {
            var c = new CreateAttributeUse();
            c.AttributeSetId = this.AttributeSetId;

            return c;
        }

        ICreateAttributeUse ICreateAttributeSet.NewCreateAttributeUse()
        {
            return this.NewCreateAttributeUse();
        }



	}


	public class MergePatchAttributeSet :AttributeSetCommandBase, IMergePatchAttributeSet
	{

		public virtual bool IsPropertyNameRemoved { get; set; }

		public virtual bool IsPropertyOrganizationIdRemoved { get; set; }

		public virtual bool IsPropertyDescriptionRemoved { get; set; }

		public virtual bool IsPropertySerialNumberAttributeIdRemoved { get; set; }

		public virtual bool IsPropertyLotAttributeIdRemoved { get; set; }

		public virtual bool IsPropertyReferenceIdRemoved { get; set; }

		public virtual bool IsPropertyActiveRemoved { get; set; }


		public MergePatchAttributeSet ()
		{
		}

        private AttributeUseCommands _attributeUseCommands = new AttributeUseCommands();

        public IAttributeUseCommands AttributeUseCommands
        {
            get
            {
                return this._attributeUseCommands;
            }
        }


        public CreateAttributeUse NewCreateAttributeUse()
        {
            var c = new CreateAttributeUse();
            c.AttributeSetId = this.AttributeSetId;

            return c;
        }

        ICreateAttributeUse IMergePatchAttributeSet.NewCreateAttributeUse()
        {
            return this.NewCreateAttributeUse();
        }

        public MergePatchAttributeUse NewMergePatchAttributeUse()
        {
            var c = new MergePatchAttributeUse();
            c.AttributeSetId = this.AttributeSetId;

            return c;
        }

        IMergePatchAttributeUse IMergePatchAttributeSet.NewMergePatchAttributeUse()
        {
            return this.NewMergePatchAttributeUse();
        }


        public RemoveAttributeUse NewRemoveAttributeUse()
        {
            var c = new RemoveAttributeUse();
            c.AttributeSetId = this.AttributeSetId;

            return c;
        }

        IRemoveAttributeUse IMergePatchAttributeSet.NewRemoveAttributeUse()
        {
            return this.NewRemoveAttributeUse();
        }



	}

	public class DeleteAttributeSet : AttributeSetCommandBase, IDeleteAttributeSet
	{
		public DeleteAttributeSet ()
		{
		}
	}


    public class CreateAttributeUseCommands : ICreateAttributeUseCommands
    {
        private List<ICreateAttributeUse> _innerCommands = new List<ICreateAttributeUse>();

        public void Add(ICreateAttributeUse c)
        {
            _innerCommands.Add(c);
        }

        public void Remove(ICreateAttributeUse c)
        {
            _innerCommands.Remove(c);
        }

        public void Clear()
        {
            _innerCommands.Clear();
        }

        public IEnumerator<ICreateAttributeUse> GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

    }

    public class AttributeUseCommands : IAttributeUseCommands
    {
        private List<IAttributeUseCommand> _innerCommands = new List<IAttributeUseCommand>();

        public void Add(IAttributeUseCommand c)
        {
            _innerCommands.Add(c);
        }

        public void Remove(IAttributeUseCommand c)
        {
            _innerCommands.Remove(c);
        }

        public void Clear()
        {
            _innerCommands.Clear();
        }

        public IEnumerator<IAttributeUseCommand> GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

    }




}

