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

    public partial class AttributeSetAggregate : AggregateBase, IAttributeSetAggregate
    {

        readonly IAttributeSetState _state;

        readonly IList<IEvent> _changes = new List<IEvent>();

        public IAttributeSetState State
        {
            get
            {
                return _state;
            }
        }

        public IList<IEvent> Changes
        {
            get
            {
                return _changes;
            }
        }

        #region IIdentity implementation

        string IGlobalIdentity<string>.GlobalId
        {
            get
            {
                return this._state.GlobalId;
            }
        }

        #endregion


        public AttributeSetAggregate(IAttributeSetState state)
        {
            _state = state;
        }


        public virtual void ThrowOnInvalidStateTransition(ICommand c)
        {
            if (_state.Version == AttributeSetState.VersionZero)
            {
                if (IsCommandCreate((IAttributeSetCommand)c))
                {
                    return;
                }
                throw DomainError.Named("premature", "Can't do anything to unexistent aggregate");
            }
            if (_state.Deleted)
            {
                throw DomainError.Named("zombie", "Can't do anything to deleted aggregate.");
            }
            if (IsCommandCreate((IAttributeSetCommand)c))
                throw DomainError.Named("rebirth", "Can't create aggregate that already exists");
        }

        private static bool IsCommandCreate(IAttributeSetCommand c)
        {
            return c.Version == AttributeSetState.VersionZero;
        }

        protected virtual void Apply(IEvent e)
        {
            BeforeApply(e);
            _state.Mutate(e);
            _changes.Add(e);
        }

        public virtual void Create(ICreateAttributeSet c)
        {
            IAttributeSetStateCreated e = Map(c);
            Apply(e);
        }

        public virtual void MergePatch(IMergePatchAttributeSet c)
        {
            IAttributeSetStateMergePatched e = Map(c);
            Apply(e);
        }

        public virtual void Delete(IDeleteAttributeSet c)
        {
            IAttributeSetStateDeleted e = Map(c);
            Apply(e);
        }


        protected virtual IAttributeSetStateCreated Map(ICreateAttributeSet c)
        {
			var stateEventId = new AttributeSetStateEventId(c.AttributeSetId, c.Version);
            IAttributeSetStateCreated e = NewAttributeSetStateCreated(stateEventId);
		
            e.Name = c.Name;

            e.OrganizationId = c.OrganizationId;

            e.Description = c.Description;

            e.SerialNumberAttributeId = c.SerialNumberAttributeId;

            e.LotAttributeId = c.LotAttributeId;

            e.ReferenceId = c.ReferenceId;

            e.Active = c.Active;

            ReflectUtils.CopyPropertyValue("CommandId", c, e);


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = DateTime.Now;
			var version = c.Version;

            foreach (ICreateAttributeUse innerCommand in c.AttributeUses)
            {
                ThrowOnInconsistentCommands(c, innerCommand);

                IAttributeUseStateCreated innerEvent = MapCreate(innerCommand, c, version);
                e.AddAttributeUseEvent(innerEvent);
            }


            return e;
        }

        protected virtual IAttributeSetStateMergePatched Map(IMergePatchAttributeSet c)
        {
			var stateEventId = new AttributeSetStateEventId(c.AttributeSetId, c.Version);
            IAttributeSetStateMergePatched e = NewAttributeSetStateMergePatched(stateEventId);

            e.Name = c.Name;

            e.OrganizationId = c.OrganizationId;

            e.Description = c.Description;

            e.SerialNumberAttributeId = c.SerialNumberAttributeId;

            e.LotAttributeId = c.LotAttributeId;

            e.ReferenceId = c.ReferenceId;

            e.Active = c.Active;

            e.IsPropertyNameRemoved = c.IsPropertyNameRemoved;

            e.IsPropertyOrganizationIdRemoved = c.IsPropertyOrganizationIdRemoved;

            e.IsPropertyDescriptionRemoved = c.IsPropertyDescriptionRemoved;

            e.IsPropertySerialNumberAttributeIdRemoved = c.IsPropertySerialNumberAttributeIdRemoved;

            e.IsPropertyLotAttributeIdRemoved = c.IsPropertyLotAttributeIdRemoved;

            e.IsPropertyReferenceIdRemoved = c.IsPropertyReferenceIdRemoved;

            e.IsPropertyActiveRemoved = c.IsPropertyActiveRemoved;


            ReflectUtils.CopyPropertyValue("CommandId", c, e);


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = DateTime.Now;

			var version = c.Version;

            foreach (IAttributeUseCommand innerCommand in c.AttributeUseCommands)
            {
                ThrowOnInconsistentCommands(c, innerCommand);

                IAttributeUseStateEvent innerEvent = Map(innerCommand, c, version);
                e.AddAttributeUseEvent(innerEvent);
            }


            return e;
        }

        protected virtual IAttributeSetStateDeleted Map(IDeleteAttributeSet c)
        {
			var stateEventId = new AttributeSetStateEventId(c.AttributeSetId, c.Version);
            IAttributeSetStateDeleted e = NewAttributeSetStateDeleted(stateEventId);
			
            ReflectUtils.CopyPropertyValue("CommandId", c, e);


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = DateTime.Now;


            return e;
        }


        protected void ThrowOnInconsistentCommands(IAttributeSetCommand command, IAttributeUseCommand innerCommand)
        {

            var properties =  command as ICreateOrMergePatchOrDeleteAttributeSet;
            var innerProperties = innerCommand as ICreateOrMergePatchOrRemoveAttributeUse;
            if (properties == null || innerProperties == null) { return; }
            var outerAttributeSetIdName = "AttributeSetId";
            var outerAttributeSetIdValue = properties.AttributeSetId;
            var innerAttributeSetIdName = "AttributeSetId";
            var innerAttributeSetIdValue = innerProperties.AttributeSetId;
            SetNullInnerIdOrThrowOnInconsistentIds(innerProperties, innerAttributeSetIdName, innerAttributeSetIdValue, outerAttributeSetIdName, outerAttributeSetIdValue);

        }// END ThrowOnInconsistentCommands /////////////////////


        protected virtual IAttributeUseStateEvent Map(IAttributeUseCommand c, IAttributeSetCommand outerCommand, long version)
        {
            var create = (c.CommandType == CommandType.Create) ? (c as ICreateAttributeUse) : null;
            if(create != null)
            {
                return MapCreate(create, outerCommand, version);
            }

            var merge = (c.CommandType == CommandType.MergePatch) ? (c as IMergePatchAttributeUse) : null;
            if(merge != null)
            {
                return MapMergePatch(merge, outerCommand, version);
            }

            var remove = (c.CommandType == CommandType.Remove) ? (c as IRemoveAttributeUse) : null;
            if (remove != null)
            {
                return MapRemove(remove, outerCommand, version);
            }
            throw new NotSupportedException();
        }


        protected virtual IAttributeUseStateCreated MapCreate(ICreateAttributeUse c, IAttributeSetCommand outerCommand, long version)
        {
            c.RequesterId = outerCommand.RequesterId;
			var stateEventId = new AttributeUseStateEventId(c.AttributeSetId, c.AttributeId, version);
            IAttributeUseStateCreated e = NewAttributeUseStateCreated(stateEventId);

            e.SequenceNumber = c.SequenceNumber;

            e.Active = c.Active;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = DateTime.Now;
            return e;

        }// END Map(ICreate... ////////////////////////////



        protected virtual IAttributeUseStateMergePatched MapMergePatch(IMergePatchAttributeUse c, IAttributeSetCommand outerCommand, long version)
        {
            c.RequesterId = outerCommand.RequesterId;
			var stateEventId = new AttributeUseStateEventId(c.AttributeSetId, c.AttributeId, version);
            IAttributeUseStateMergePatched e = NewAttributeUseStateMergePatched(stateEventId);

            e.SequenceNumber = c.SequenceNumber;

            e.Active = c.Active;

            e.IsPropertySequenceNumberRemoved = c.IsPropertySequenceNumberRemoved;
            e.IsPropertyActiveRemoved = c.IsPropertyActiveRemoved;

            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = DateTime.Now;
            return e;

        }// END Map(IMergePatch... ////////////////////////////


        protected virtual IAttributeUseStateRemoved MapRemove(IRemoveAttributeUse c, IAttributeSetCommand outerCommand, long version)
        {
            c.RequesterId = outerCommand.RequesterId;
			var stateEventId = new AttributeUseStateEventId(c.AttributeSetId, c.AttributeId, version);
            IAttributeUseStateRemoved e = NewAttributeUseStateRemoved(stateEventId);


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = DateTime.Now;

            return e;

        }// END Map(IRemove... ////////////////////////////



        private void SetNullInnerIdOrThrowOnInconsistentIds(object innerObject, string innerIdName, object innerIdValue, string outerIdName, object outerIdValue)
        {
            if (innerIdValue == null)
            {
                ReflectUtils.SetPropertyValue(innerIdName, innerObject, outerIdValue);
            }
            else if (innerIdValue != outerIdValue)
            {
                if (innerIdValue is string && outerIdValue is string && ((string)innerIdValue).Normalize() == ((string)outerIdValue).Normalize())
                {
                    return;
                }
                throw DomainError.Named("inconsistentId", "Outer {0} {1} NOT equals inner {2} {3}", outerIdName, outerIdValue, innerIdName, innerIdValue);
            }
        }

////////////////////////

        protected AttributeSetStateCreated NewAttributeSetStateCreated(string commandId, string requesterId)
        {
            var stateEventId = new AttributeSetStateEventId(this._state.AttributeSetId, this._state.Version);
            var e = NewAttributeSetStateCreated(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = DateTime.Now;

            return e;
        }

        protected AttributeSetStateMergePatched NewAttributeSetStateMergePatched(string commandId, string requesterId)
        {
            var stateEventId = new AttributeSetStateEventId(this._state.AttributeSetId, this._state.Version);
            var e = NewAttributeSetStateMergePatched(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = DateTime.Now;

            return e;
        }


        protected AttributeSetStateDeleted NewAttributeSetStateDeleted(string commandId, string requesterId)
        {
            var stateEventId = new AttributeSetStateEventId(this._state.AttributeSetId, this._state.Version);
            var e = NewAttributeSetStateDeleted(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = DateTime.Now;

            return e;
        }

////////////////////////

		private AttributeSetStateCreated NewAttributeSetStateCreated(AttributeSetStateEventId stateEventId)
		{
			return new AttributeSetStateCreated(stateEventId);			
		}

        private AttributeSetStateMergePatched NewAttributeSetStateMergePatched(AttributeSetStateEventId stateEventId)
		{
			return new AttributeSetStateMergePatched(stateEventId);
		}

        private AttributeSetStateDeleted NewAttributeSetStateDeleted(AttributeSetStateEventId stateEventId)
		{
			return new AttributeSetStateDeleted(stateEventId);
		}


		private AttributeUseStateCreated NewAttributeUseStateCreated(AttributeUseStateEventId stateEventId)
		{
			return new AttributeUseStateCreated(stateEventId);
		}

        private AttributeUseStateMergePatched NewAttributeUseStateMergePatched(AttributeUseStateEventId stateEventId)
		{
			return new AttributeUseStateMergePatched(stateEventId);
		}

        private AttributeUseStateRemoved NewAttributeUseStateRemoved(AttributeUseStateEventId stateEventId)
		{
			return new AttributeUseStateRemoved(stateEventId);
		}


    }

}

