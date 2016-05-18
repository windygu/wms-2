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

	public partial class AttributeStateDto : StateDtoBase, IAttributeState
	{

        internal static IList<string> _collectionFieldNames = new string[] { "AttributeValues" };

        protected override bool IsCollectionField(string fieldName)
        {
            return CollectionUtils.CollectionContainsIgnoringCase(_collectionFieldNames, fieldName);
        }

		private AttributeState _state;

        public AttributeStateDto()
        {
            this._state = new AttributeState();
        }

		public AttributeStateDto(AttributeState state)
		{
            this._state = state;
		}

		internal AttributeState ToAttributeState()
		{
			return this._state;
		}

		public virtual string AttributeId
		{
            get
            {
                if ((this as IStateDto).ReturnedFieldsContains("AttributeId"))
                {
                    return _state.AttributeId;
                }
                return null;
            }
            set
            {
                _state.AttributeId = value;
            }
        }

        string IAttributeStateProperties.AttributeId
        {
            get 
            {
                return (this._state as IAttributeStateProperties).AttributeId;
            }
            set 
            {
                this._state.AttributeId = value;
            }
        }

		public virtual string Name
		{
            get
            {
                if ((this as IStateDto).ReturnedFieldsContains("Name"))
                {
                    return _state.Name;
                }
                return null;
            }
            set
            {
                _state.Name = value;
            }
        }

        string IAttributeStateProperties.Name
        {
            get 
            {
                return (this._state as IAttributeStateProperties).Name;
            }
            set 
            {
                this._state.Name = value;
            }
        }

		public virtual string OrganizationId
		{
            get
            {
                if ((this as IStateDto).ReturnedFieldsContains("OrganizationId"))
                {
                    return _state.OrganizationId;
                }
                return null;
            }
            set
            {
                _state.OrganizationId = value;
            }
        }

        string IAttributeStateProperties.OrganizationId
        {
            get 
            {
                return (this._state as IAttributeStateProperties).OrganizationId;
            }
            set 
            {
                this._state.OrganizationId = value;
            }
        }

		public virtual string Description
		{
            get
            {
                if ((this as IStateDto).ReturnedFieldsContains("Description"))
                {
                    return _state.Description;
                }
                return null;
            }
            set
            {
                _state.Description = value;
            }
        }

        string IAttributeStateProperties.Description
        {
            get 
            {
                return (this._state as IAttributeStateProperties).Description;
            }
            set 
            {
                this._state.Description = value;
            }
        }

		public virtual bool? IsMandatory
        {
            get
            {
                if ((this as IStateDto).ReturnedFieldsContains("IsMandatory"))
                {
                    return _state.IsMandatory;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.IsMandatory = value.Value;
                }
            }
        }

        bool IAttributeStateProperties.IsMandatory
        {
            get 
            {
                return (this._state as IAttributeStateProperties).IsMandatory;
            }
            set 
            {
                this._state.IsMandatory = value;
            }
        }

		public virtual bool? IsInstanceAttribute
        {
            get
            {
                if ((this as IStateDto).ReturnedFieldsContains("IsInstanceAttribute"))
                {
                    return _state.IsInstanceAttribute;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.IsInstanceAttribute = value.Value;
                }
            }
        }

        bool IAttributeStateProperties.IsInstanceAttribute
        {
            get 
            {
                return (this._state as IAttributeStateProperties).IsInstanceAttribute;
            }
            set 
            {
                this._state.IsInstanceAttribute = value;
            }
        }

		public virtual string AttributeValueType
		{
            get
            {
                if ((this as IStateDto).ReturnedFieldsContains("AttributeValueType"))
                {
                    return _state.AttributeValueType;
                }
                return null;
            }
            set
            {
                _state.AttributeValueType = value;
            }
        }

        string IAttributeStateProperties.AttributeValueType
        {
            get 
            {
                return (this._state as IAttributeStateProperties).AttributeValueType;
            }
            set 
            {
                this._state.AttributeValueType = value;
            }
        }

		public virtual int? AttributeValueLength
		{
            get
            {
                if ((this as IStateDto).ReturnedFieldsContains("AttributeValueLength"))
                {
                    return _state.AttributeValueLength;
                }
                return null;
            }
            set
            {
                _state.AttributeValueLength = value;
            }
        }

        int? IAttributeStateProperties.AttributeValueLength
        {
            get 
            {
                return (this._state as IAttributeStateProperties).AttributeValueLength;
            }
            set 
            {
                this._state.AttributeValueLength = value;
            }
        }

		public virtual bool? IsList
        {
            get
            {
                if ((this as IStateDto).ReturnedFieldsContains("IsList"))
                {
                    return _state.IsList;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.IsList = value.Value;
                }
            }
        }

        bool IAttributeStateProperties.IsList
        {
            get 
            {
                return (this._state as IAttributeStateProperties).IsList;
            }
            set 
            {
                this._state.IsList = value;
            }
        }

		public virtual string FieldName
		{
            get
            {
                if ((this as IStateDto).ReturnedFieldsContains("FieldName"))
                {
                    return _state.FieldName;
                }
                return null;
            }
            set
            {
                _state.FieldName = value;
            }
        }

        string IAttributeStateProperties.FieldName
        {
            get 
            {
                return (this._state as IAttributeStateProperties).FieldName;
            }
            set 
            {
                this._state.FieldName = value;
            }
        }

		public virtual string ReferenceId
		{
            get
            {
                if ((this as IStateDto).ReturnedFieldsContains("ReferenceId"))
                {
                    return _state.ReferenceId;
                }
                return null;
            }
            set
            {
                _state.ReferenceId = value;
            }
        }

        string IAttributeStateProperties.ReferenceId
        {
            get 
            {
                return (this._state as IAttributeStateProperties).ReferenceId;
            }
            set 
            {
                this._state.ReferenceId = value;
            }
        }

		public virtual bool? Active
        {
            get
            {
                if ((this as IStateDto).ReturnedFieldsContains("Active"))
                {
                    return _state.Active;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.Active = value.Value;
                }
            }
        }

        bool IAttributeStateProperties.Active
        {
            get 
            {
                return (this._state as IAttributeStateProperties).Active;
            }
            set 
            {
                this._state.Active = value;
            }
        }

		public virtual long? Version
        {
            get
            {
                if ((this as IStateDto).ReturnedFieldsContains("Version"))
                {
                    return _state.Version;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.Version = value.Value;
                }
            }
        }
		public virtual string CreatedBy
		{
            get
            {
                if ((this as IStateDto).ReturnedFieldsContains("CreatedBy"))
                {
                    return _state.CreatedBy;
                }
                return null;
            }
            set
            {
                _state.CreatedBy = value;
            }
        }
		public virtual DateTime? CreatedAt
        {
            get
            {
                if ((this as IStateDto).ReturnedFieldsContains("CreatedAt"))
                {
                    return _state.CreatedAt;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.CreatedAt = value.Value;
                }
            }
        }
		public virtual string UpdatedBy
		{
            get
            {
                if ((this as IStateDto).ReturnedFieldsContains("UpdatedBy"))
                {
                    return _state.UpdatedBy;
                }
                return null;
            }
            set
            {
                _state.UpdatedBy = value;
            }
        }
		public virtual DateTime? UpdatedAt
        {
            get
            {
                if ((this as IStateDto).ReturnedFieldsContains("UpdatedAt"))
                {
                    return _state.UpdatedAt;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.UpdatedAt = value.Value;
                }
            }
        }

		#region IIdentity implementation

		string IGlobalIdentity<string>.GlobalId
		{
			get { return (_state as IAttributeState).GlobalId; }
		}

		#endregion


		#region IActive implementation

		bool IActive.Active
		{
            get { return (_state as IActive).Active; }
		}

		#endregion

		#region IDeleted implementation

		bool IDeleted.Deleted
		{
            get { return (_state as IDeleted).Deleted; }
		}

		#endregion

		#region ICreated implementation

		string ICreated<string>.CreatedBy
		{
            get { return (_state as IAttributeState).CreatedBy; }
		}

		DateTime ICreated<string>.CreatedAt
		{
            get { return (_state as IAttributeState).CreatedAt; }
		}

		#endregion

		#region IUpdated implementation

		string IUpdated<string>.UpdatedBy
		{
            get { return (_state as IAttributeState).UpdatedBy; }
		}

		DateTime IUpdated<string>.UpdatedAt
		{
            get { return (_state as IAttributeState).UpdatedAt; }
		}

		#endregion

		#region IVersioned implementation

		long IVersioned<long>.Version
		{
            get { return (_state as IAttributeState).Version; }
		}


		#endregion




        public virtual AttributeValueStateDto[] AttributeValues
        {
            get 
            {
                if (!(this as IStateDto).ReturnedFieldsContains("AttributeValues"))
                {
                    return null;
                }
                var dtos = new List<AttributeValueStateDto>();
                if (this._state.AttributeValues != null)
                {
                    foreach (var s in this._state.AttributeValues)
                    {
                        var dto = new AttributeValueStateDto((AttributeValueState)s);
                        var returnFS = CollectionUtils.DictionaryGetValueIgnoringCase(ReturnedFields, "AttributeValues");
                        if (!String.IsNullOrWhiteSpace(returnFS))
                        {
                            (dto as IStateDto).ReturnedFieldsString = returnFS;
                        }
                        else
                        {
                            (dto as IStateDto).AllFieldsReturned = this.AllFieldsReturned;
                        }
                        dtos.Add(dto);
                    }
                }
                return dtos.ToArray();
            }
            set 
            {
                var states = new List<AttributeValueState>();
                foreach (var s in value)
                {
                    states.Add(s.ToAttributeValueState());
                }
                this._state.SetAttributeValues(new DtoAttributeValueStates(this._state, states));
            }
        }

        IAttributeValueStates IAttributeState.AttributeValues
        {
            get { return _state.AttributeValues; }
        }


		void IAttributeState.When(IAttributeStateCreated e)
		{
            throw new NotSupportedException();
		}


		void IAttributeState.When(IAttributeStateMergePatched e)
		{
            throw new NotSupportedException();
		}

		void IAttributeState.When(IAttributeStateDeleted e)
		{
            throw new NotSupportedException();
		}


		void IAttributeState.Mutate(IEvent e)
		{
            throw new NotSupportedException();
		}

        // //////////////////////////////////////////////////////////////


        public class DtoAttributeValueStates : IAttributeValueStates
        {

            private IAttributeState _outerState;

            private IEnumerable<IAttributeValueState> _innerStates;

            public DtoAttributeValueStates(IAttributeState outerState, IEnumerable<IAttributeValueState> innerStates)
            {
                this._outerState = outerState;
                if (innerStates == null)
                {
                    this._innerStates = new IAttributeValueState[] { };
                }
                else
                {
                    this._innerStates = innerStates;
                }
            }

            public IEnumerator<IAttributeValueState> GetEnumerator()
            {
                return _innerStates.GetEnumerator();
            }

            System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
            {
                return _innerStates.GetEnumerator();
            }

            public IAttributeValueState Get(string value)
            {
                throw new NotSupportedException();
            }

            public void Remove(IAttributeValueState state)
            {
                throw new NotSupportedException();
            }

            public void Save()
            {
                throw new NotSupportedException();
            }
        }

	}

    partial class AttributeStateDtoCollection : StateDtoCollectionBase<AttributeStateDto>
    {

        protected override bool IsCollectionField(string fieldName)
        {
            return CollectionUtils.CollectionContainsIgnoringCase(AttributeStateDto._collectionFieldNames, fieldName);
        }

    }

}

