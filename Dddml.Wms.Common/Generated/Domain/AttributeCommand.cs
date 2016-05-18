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

	public abstract class AttributeCommandBase : AttributeStateProperties, IAttributeCommand
	{

		string IAggregateCommand<string, long>.AggregateId
		{
			get
			{
				return this.AttributeId;
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

	public class CreateAttribute : AttributeCommandBase, ICreateAttribute
	{
		
		public CreateAttribute ()
		{
		}


        private CreateAttributeValueCommands _attributeValues = new CreateAttributeValueCommands();

        public ICreateAttributeValueCommands AttributeValues
        {
            get
            {
                return this._attributeValues;
            }
        }

        public CreateAttributeValue NewCreateAttributeValue()
        {
            var c = new CreateAttributeValue();
            c.AttributeId = this.AttributeId;

            return c;
        }

        ICreateAttributeValue ICreateAttribute.NewCreateAttributeValue()
        {
            return this.NewCreateAttributeValue();
        }



	}


	public class MergePatchAttribute :AttributeCommandBase, IMergePatchAttribute
	{

		public virtual bool IsPropertyNameRemoved { get; set; }

		public virtual bool IsPropertyOrganizationIdRemoved { get; set; }

		public virtual bool IsPropertyDescriptionRemoved { get; set; }

		public virtual bool IsPropertyIsMandatoryRemoved { get; set; }

		public virtual bool IsPropertyIsInstanceAttributeRemoved { get; set; }

		public virtual bool IsPropertyAttributeValueTypeRemoved { get; set; }

		public virtual bool IsPropertyAttributeValueLengthRemoved { get; set; }

		public virtual bool IsPropertyIsListRemoved { get; set; }

		public virtual bool IsPropertyFieldNameRemoved { get; set; }

		public virtual bool IsPropertyReferenceIdRemoved { get; set; }

		public virtual bool IsPropertyActiveRemoved { get; set; }


		public MergePatchAttribute ()
		{
		}

        private AttributeValueCommands _attributeValueCommands = new AttributeValueCommands();

        public IAttributeValueCommands AttributeValueCommands
        {
            get
            {
                return this._attributeValueCommands;
            }
        }


        public CreateAttributeValue NewCreateAttributeValue()
        {
            var c = new CreateAttributeValue();
            c.AttributeId = this.AttributeId;

            return c;
        }

        ICreateAttributeValue IMergePatchAttribute.NewCreateAttributeValue()
        {
            return this.NewCreateAttributeValue();
        }

        public MergePatchAttributeValue NewMergePatchAttributeValue()
        {
            var c = new MergePatchAttributeValue();
            c.AttributeId = this.AttributeId;

            return c;
        }

        IMergePatchAttributeValue IMergePatchAttribute.NewMergePatchAttributeValue()
        {
            return this.NewMergePatchAttributeValue();
        }


        public RemoveAttributeValue NewRemoveAttributeValue()
        {
            var c = new RemoveAttributeValue();
            c.AttributeId = this.AttributeId;

            return c;
        }

        IRemoveAttributeValue IMergePatchAttribute.NewRemoveAttributeValue()
        {
            return this.NewRemoveAttributeValue();
        }



	}

	public class DeleteAttribute : AttributeCommandBase, IDeleteAttribute
	{
		public DeleteAttribute ()
		{
		}
	}


    public class CreateAttributeValueCommands : ICreateAttributeValueCommands
    {
        private List<ICreateAttributeValue> _innerCommands = new List<ICreateAttributeValue>();

        public void Add(ICreateAttributeValue c)
        {
            _innerCommands.Add(c);
        }

        public void Remove(ICreateAttributeValue c)
        {
            _innerCommands.Remove(c);
        }

        public void Clear()
        {
            _innerCommands.Clear();
        }

        public IEnumerator<ICreateAttributeValue> GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

    }

    public class AttributeValueCommands : IAttributeValueCommands
    {
        private List<IAttributeValueCommand> _innerCommands = new List<IAttributeValueCommand>();

        public void Add(IAttributeValueCommand c)
        {
            _innerCommands.Add(c);
        }

        public void Remove(IAttributeValueCommand c)
        {
            _innerCommands.Remove(c);
        }

        public void Clear()
        {
            _innerCommands.Clear();
        }

        public IEnumerator<IAttributeValueCommand> GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

    }




}

