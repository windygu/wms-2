﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;

namespace Dddml.Wms.Domain
{

	public partial class PersonState : PersonStateProperties, IPersonState, ISaveable
	{

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

		public virtual string UpdatedBy { get; set; }

		public virtual DateTime UpdatedAt { get; set; }

		public virtual bool Deleted { get; set; }


		#region IIdentity implementation

		PersonalName IGlobalIdentity<PersonalName>.GlobalId
		{
			get
			{
				return this.PersonalName;
			}
		}

		#endregion



		#region IActive implementation

		bool IActive.Active
		{
			get
			{
				return this.Active;
			}
		}

		#endregion

		#region IDeleted implementation

		bool IDeleted.Deleted
		{
			get
			{
				return this.Deleted;
			}
		}

		#endregion

		#region ICreated implementation

		string ICreated<string>.CreatedBy
		{
			get
			{
				return this.CreatedBy;
			}
			set
			{
				this.CreatedBy = value;
			}
		}

		DateTime ICreated<string>.CreatedAt
		{
			get
			{
				return this.CreatedAt;
			}
			set
			{
				this.CreatedAt = value;
			}
		}

		#endregion

		#region IUpdated implementation

		string IUpdated<string>.UpdatedBy
		{
			get
			{
				return this.UpdatedBy;
			}
		}

		DateTime IUpdated<string>.UpdatedAt
		{
			get
			{
				return this.UpdatedAt;
			}
		}

		#endregion

		#region IVersioned implementation

		long IVersioned<long>.Version
		{
			get
			{
				return this.Version;
			}
		}


		#endregion

        bool IPersonState.IsUnsaved
        {
            get { return ((IVersioned<long>)this).Version == VersionZero; }
        }

		public static long VersionZero
		{
			get
			{
				return (long)0;
			}
		}


        private IYearPlanStates _yearPlans;
      
        public virtual IYearPlanStates YearPlans
        {
            get
            {
                return this._yearPlans;
            }
        }

        protected internal virtual void SetYearPlans(IYearPlanStates value)
        {
            this._yearPlans = value;
        }



        private bool _forReapplying;

        public virtual bool ForReapplying
        {
            get { return _forReapplying; }
            set { _forReapplying = value; } 
        }

        public PersonState(IEnumerable<IEvent> events) : this(true)
        {
            if (events != null && events.Count() > 0)
            {
                this.PersonalName = ((IPersonStateEvent)events.First()).StateEventId.PersonalName;
                foreach (var e in events)
                {
                    Mutate(e);
                    this.Version += 1;
                }
            }
        }

        public PersonState() : this(false)
        {
        }

        public PersonState(bool forReapplying)
        {
            this._forReapplying = forReapplying;
            _yearPlans = new YearPlanStates(this);

            InitializeProperties();
        }


		#region Saveable Implements

        public virtual void Save()
        {
            _yearPlans.Save();

        }


		#endregion


		public virtual void When(IPersonStateCreated e)
		{
			ThrowOnWrongEvent(e);
            this.BirthDate = (e.BirthDate != null && e.BirthDate.HasValue) ? e.BirthDate.Value : default(DateTime);

			this.Loves = e.Loves;

			this.EmergencyContact = e.EmergencyContact;

            this.Active = (e.Active != null && e.Active.HasValue) ? e.Active.Value : default(bool);

			this.Deleted = false;

			this.CreatedBy = e.CreatedBy;
			this.CreatedAt = e.CreatedAt;

			foreach (IYearPlanStateCreated innerEvent in e.YearPlanEvents) {
				IYearPlanState innerState = this.YearPlans.Get(innerEvent.GlobalId.Year);
				innerState.Mutate (innerEvent);
			}

		}


		public virtual void When(IPersonStateMergePatched e)
		{
			ThrowOnWrongEvent(e);

			if (e.BirthDate == null)
			{
				if (e.IsPropertyBirthDateRemoved)
				{
					this.BirthDate = default(DateTime);
				}
			}
			else
			{
				this.BirthDate = (e.BirthDate != null && e.BirthDate.HasValue) ? e.BirthDate.Value : default(DateTime);
			}

			if (e.Loves == null)
			{
				if (e.IsPropertyLovesRemoved)
				{
					this.Loves = default(PersonalName);
				}
			}
			else
			{
				this.Loves = e.Loves;
			}

			if (e.EmergencyContact == null)
			{
				if (e.IsPropertyEmergencyContactRemoved)
				{
					this.EmergencyContact = default(Contact);
				}
			}
			else
			{
				this.EmergencyContact = e.EmergencyContact;
			}

			if (e.Active == null)
			{
				if (e.IsPropertyActiveRemoved)
				{
					this.Active = default(bool);
				}
			}
			else
			{
				this.Active = (e.Active != null && e.Active.HasValue) ? e.Active.Value : default(bool);
			}


			this.UpdatedBy = e.CreatedBy;
			this.UpdatedAt = e.CreatedAt;


			foreach (IYearPlanStateEvent innerEvent in e.YearPlanEvents)
            {
                IYearPlanState innerState = this.YearPlans.Get(innerEvent.GlobalId.Year);

                innerState.Mutate(innerEvent);
                var removed = innerEvent as IYearPlanStateRemoved;
                if (removed != null)
                {
                    this.YearPlans.Remove(innerState);
                }
          
            }

		}

		public virtual void When(IPersonStateDeleted e)
		{
			ThrowOnWrongEvent(e);

			this.Deleted = true;
			this.UpdatedBy = e.CreatedBy;
			this.UpdatedAt = e.CreatedAt;

            foreach (var innerState in this.YearPlans)
            {
                this.YearPlans.Remove(innerState);
                
                var innerE = e.NewYearPlanStateRemoved(innerState.Year);
                ((YearPlanStateEventBase)innerE).CreatedAt = e.CreatedAt;
                ((YearPlanStateEventBase)innerE).CreatedBy = e.CreatedBy;
                innerState.When(innerE);
                //e.AddYearPlanEvent(innerE);

            }

		}


		public virtual void Mutate(IEvent e)
		{
			((dynamic)this).When((dynamic)e);
		}

		protected void ThrowOnWrongEvent(IPersonStateEvent stateEvent)
		{
			var stateEntityId = this.PersonalName; // Aggregate Id
			var eventEntityId = stateEvent.StateEventId.PersonalName; // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
			if (stateEntityId != eventEntityId)
			{
				throw DomainError.Named("mutateWrongEntity", "Entity Id {0} in state but entity id {1} in event", stateEntityId, eventEntityId);
			}

			var stateVersion = this.Version;
			var eventVersion = stateEvent.StateEventId.Version;
			if (stateVersion != eventVersion)
			{
				throw DomainError.Named("concurrencyConflict", "Conflict between state version {0} and event version {1}", stateVersion, eventVersion);
			}

		}
	}

}

