﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateDocumentTypeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.DocumentType;

namespace Dddml.Wms.Domain.DocumentType
{
    public partial class DocumentTypeAggregate : AggregateBase, IDocumentTypeAggregate
    {

        readonly IDocumentTypeState _state;

        readonly IList<IEvent> _changes = new List<IEvent>();

        public IDocumentTypeState State
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


        public DocumentTypeAggregate(IDocumentTypeState state)
        {
            _state = state;
        }


        public virtual void ThrowOnInvalidStateTransition(ICommand c)
        {
            if (((IDocumentTypeStateProperties)_state).Version == DocumentTypeState.VersionZero)
            {
                if (IsCommandCreate((IDocumentTypeCommand)c))
                {
                    return;
                }
                throw DomainError.Named("premature", "Can't do anything to unexistent aggregate");
            }
            if (_state.Deleted)
            {
                throw DomainError.Named("zombie", "Can't do anything to deleted aggregate.");
            }
            if (IsCommandCreate((IDocumentTypeCommand)c))
                throw DomainError.Named("rebirth", "Can't create aggregate that already exists");
        }

        private static bool IsCommandCreate(IDocumentTypeCommand c)
        {
            return c.Version == DocumentTypeState.VersionZero;
        }

        protected internal virtual void Apply(IEvent e)
        {
            OnApplying(e);
            _state.Mutate(e);
            _changes.Add(e);
        }

        public virtual void Create(ICreateDocumentType c)
        {
            IDocumentTypeStateCreated e = Map(c);
            Apply(e);
        }

        public virtual void MergePatch(IMergePatchDocumentType c)
        {
            IDocumentTypeStateMergePatched e = Map(c);
            Apply(e);
        }

        public virtual void Delete(IDeleteDocumentType c)
        {
            IDocumentTypeStateDeleted e = Map(c);
            Apply(e);
        }


        protected virtual IDocumentTypeStateCreated Map(ICreateDocumentType c)
        {
			var stateEventId = new DocumentTypeStateEventId(c.DocumentTypeId, c.Version);
            IDocumentTypeStateCreated e = NewDocumentTypeStateCreated(stateEventId);
		
            e.Description = c.Description;
            e.ParentDocumentTypeId = c.ParentDocumentTypeId;
            e.Active = c.Active;
            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();
			var version = c.Version;


            return e;
        }

        protected virtual IDocumentTypeStateMergePatched Map(IMergePatchDocumentType c)
        {
			var stateEventId = new DocumentTypeStateEventId(c.DocumentTypeId, c.Version);
            IDocumentTypeStateMergePatched e = NewDocumentTypeStateMergePatched(stateEventId);

            e.Description = c.Description;
            e.ParentDocumentTypeId = c.ParentDocumentTypeId;
            e.Active = c.Active;
            e.IsPropertyDescriptionRemoved = c.IsPropertyDescriptionRemoved;
            e.IsPropertyParentDocumentTypeIdRemoved = c.IsPropertyParentDocumentTypeIdRemoved;
            e.IsPropertyActiveRemoved = c.IsPropertyActiveRemoved;

            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

			var version = c.Version;


            return e;
        }

        protected virtual IDocumentTypeStateDeleted Map(IDeleteDocumentType c)
        {
			var stateEventId = new DocumentTypeStateEventId(c.DocumentTypeId, c.Version);
            IDocumentTypeStateDeleted e = NewDocumentTypeStateDeleted(stateEventId);
			
            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();


            return e;
        }

        private void ThrowOnInconsistentIds(object innerObject, string innerIdName, object innerIdValue, string outerIdName, object outerIdValue)
        {
            if (!Object.Equals(innerIdValue, outerIdValue))
            {
                if (innerIdValue is string && outerIdValue is string && ((string)innerIdValue).Normalize() == ((string)outerIdValue).Normalize())
                {
                    return;
                }
                throw DomainError.Named("inconsistentId", "Outer {0} {1} NOT equals inner {2} {3}", outerIdName, outerIdValue, innerIdName, innerIdValue);
            }
        }

////////////////////////

        protected DocumentTypeStateCreated NewDocumentTypeStateCreated(string commandId, string requesterId)
        {
            var stateEventId = new DocumentTypeStateEventId(_state.DocumentTypeId, ((IDocumentTypeStateProperties)_state).Version);
            var e = NewDocumentTypeStateCreated(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;
        }

        protected DocumentTypeStateMergePatched NewDocumentTypeStateMergePatched(string commandId, string requesterId)
        {
            var stateEventId = new DocumentTypeStateEventId(_state.DocumentTypeId, ((IDocumentTypeStateProperties)_state).Version);
            var e = NewDocumentTypeStateMergePatched(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;
        }


        protected DocumentTypeStateDeleted NewDocumentTypeStateDeleted(string commandId, string requesterId)
        {
            var stateEventId = new DocumentTypeStateEventId(_state.DocumentTypeId, ((IDocumentTypeStateProperties)_state).Version);
            var e = NewDocumentTypeStateDeleted(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;
        }

////////////////////////

		private DocumentTypeStateCreated NewDocumentTypeStateCreated(DocumentTypeStateEventId stateEventId)
		{
			return new DocumentTypeStateCreated(stateEventId);			
		}

        private DocumentTypeStateMergePatched NewDocumentTypeStateMergePatched(DocumentTypeStateEventId stateEventId)
		{
			return new DocumentTypeStateMergePatched(stateEventId);
		}

        private DocumentTypeStateDeleted NewDocumentTypeStateDeleted(DocumentTypeStateEventId stateEventId)
		{
			return new DocumentTypeStateDeleted(stateEventId);
		}
    }

}

