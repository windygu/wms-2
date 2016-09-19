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

	public partial class DayPlanMvoState : DayPlanMvoStateProperties, IDayPlanMvoState
	{

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

		public virtual string UpdatedBy { get; set; }

		public virtual DateTime UpdatedAt { get; set; }

		public virtual bool Deleted { get; set; }


		#region IIdentity implementation

		DayPlanId IGlobalIdentity<DayPlanId>.GlobalId
		{
			get
			{
				return this.DayPlanId;
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
				return this.PersonVersion;
			}
		}


		#endregion

        bool IDayPlanMvoState.IsUnsaved
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


        private bool _forReapplying;

        public virtual bool ForReapplying
        {
            get { return _forReapplying; }
            set { _forReapplying = value; } 
        }

        public DayPlanMvoState(IEnumerable<IEvent> events) : this(true)
        {
            if (events != null && events.Count() > 0)
            {
                this.DayPlanId = ((IDayPlanMvoStateEvent)events.First()).StateEventId.DayPlanId;
                foreach (var e in events)
                {
                    Mutate(e);
                    this.PersonVersion += 1;
                }
            }
        }

        public DayPlanMvoState() : this(false)
        {
        }

        public DayPlanMvoState(bool forReapplying)
        {
            this._forReapplying = forReapplying;
            InitializeProperties();
        }


		public virtual void When(IDayPlanMvoStateCreated e)
		{
			ThrowOnWrongEvent(e);
			this.Description = e.Description;

            this.Version = (e.Version != null && e.Version.HasValue) ? e.Version.Value : default(long);

            this.Active = (e.Active != null && e.Active.HasValue) ? e.Active.Value : default(bool);

			this.MonthPlanDescription = e.MonthPlanDescription;

			this.MonthPlanCreatedBy = e.MonthPlanCreatedBy;

			this.MonthPlanUpdatedBy = e.MonthPlanUpdatedBy;

            this.MonthPlanVersion = (e.MonthPlanVersion != null && e.MonthPlanVersion.HasValue) ? e.MonthPlanVersion.Value : default(long);

            this.MonthPlanCreatedAt = (e.MonthPlanCreatedAt != null && e.MonthPlanCreatedAt.HasValue) ? e.MonthPlanCreatedAt.Value : default(DateTime);

            this.MonthPlanUpdatedAt = (e.MonthPlanUpdatedAt != null && e.MonthPlanUpdatedAt.HasValue) ? e.MonthPlanUpdatedAt.Value : default(DateTime);

            this.MonthPlanActive = (e.MonthPlanActive != null && e.MonthPlanActive.HasValue) ? e.MonthPlanActive.Value : default(bool);

            this.MonthPlanDeleted = (e.MonthPlanDeleted != null && e.MonthPlanDeleted.HasValue) ? e.MonthPlanDeleted.Value : default(bool);

			this.YearPlanDescription = e.YearPlanDescription;

			this.YearPlanCreatedBy = e.YearPlanCreatedBy;

			this.YearPlanUpdatedBy = e.YearPlanUpdatedBy;

            this.YearPlanVersion = (e.YearPlanVersion != null && e.YearPlanVersion.HasValue) ? e.YearPlanVersion.Value : default(long);

            this.YearPlanCreatedAt = (e.YearPlanCreatedAt != null && e.YearPlanCreatedAt.HasValue) ? e.YearPlanCreatedAt.Value : default(DateTime);

            this.YearPlanUpdatedAt = (e.YearPlanUpdatedAt != null && e.YearPlanUpdatedAt.HasValue) ? e.YearPlanUpdatedAt.Value : default(DateTime);

            this.YearPlanActive = (e.YearPlanActive != null && e.YearPlanActive.HasValue) ? e.YearPlanActive.Value : default(bool);

            this.YearPlanDeleted = (e.YearPlanDeleted != null && e.YearPlanDeleted.HasValue) ? e.YearPlanDeleted.Value : default(bool);

            this.PersonBirthDate = (e.PersonBirthDate != null && e.PersonBirthDate.HasValue) ? e.PersonBirthDate.Value : default(DateTime);

			this.PersonLoves = e.PersonLoves;

			this.PersonEmergencyContact = e.PersonEmergencyContact;

			this.PersonCreatedBy = e.PersonCreatedBy;

			this.PersonUpdatedBy = e.PersonUpdatedBy;

            this.PersonCreatedAt = (e.PersonCreatedAt != null && e.PersonCreatedAt.HasValue) ? e.PersonCreatedAt.Value : default(DateTime);

            this.PersonUpdatedAt = (e.PersonUpdatedAt != null && e.PersonUpdatedAt.HasValue) ? e.PersonUpdatedAt.Value : default(DateTime);

            this.PersonActive = (e.PersonActive != null && e.PersonActive.HasValue) ? e.PersonActive.Value : default(bool);

            this.PersonDeleted = (e.PersonDeleted != null && e.PersonDeleted.HasValue) ? e.PersonDeleted.Value : default(bool);

			this.Deleted = false;

			this.CreatedBy = e.CreatedBy;
			this.CreatedAt = e.CreatedAt;


		}


		public virtual void When(IDayPlanMvoStateMergePatched e)
		{
			ThrowOnWrongEvent(e);

			if (e.Description == null)
			{
				if (e.IsPropertyDescriptionRemoved)
				{
					this.Description = default(string);
				}
			}
			else
			{
				this.Description = e.Description;
			}

			if (e.Version == null)
			{
				if (e.IsPropertyVersionRemoved)
				{
					this.Version = default(long);
				}
			}
			else
			{
				this.Version = (e.Version != null && e.Version.HasValue) ? e.Version.Value : default(long);
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

			if (e.MonthPlanDescription == null)
			{
				if (e.IsPropertyMonthPlanDescriptionRemoved)
				{
					this.MonthPlanDescription = default(string);
				}
			}
			else
			{
				this.MonthPlanDescription = e.MonthPlanDescription;
			}

			if (e.MonthPlanCreatedBy == null)
			{
				if (e.IsPropertyMonthPlanCreatedByRemoved)
				{
					this.MonthPlanCreatedBy = default(string);
				}
			}
			else
			{
				this.MonthPlanCreatedBy = e.MonthPlanCreatedBy;
			}

			if (e.MonthPlanUpdatedBy == null)
			{
				if (e.IsPropertyMonthPlanUpdatedByRemoved)
				{
					this.MonthPlanUpdatedBy = default(string);
				}
			}
			else
			{
				this.MonthPlanUpdatedBy = e.MonthPlanUpdatedBy;
			}

			if (e.MonthPlanVersion == null)
			{
				if (e.IsPropertyMonthPlanVersionRemoved)
				{
					this.MonthPlanVersion = default(long);
				}
			}
			else
			{
				this.MonthPlanVersion = (e.MonthPlanVersion != null && e.MonthPlanVersion.HasValue) ? e.MonthPlanVersion.Value : default(long);
			}

			if (e.MonthPlanCreatedAt == null)
			{
				if (e.IsPropertyMonthPlanCreatedAtRemoved)
				{
					this.MonthPlanCreatedAt = default(DateTime);
				}
			}
			else
			{
				this.MonthPlanCreatedAt = (e.MonthPlanCreatedAt != null && e.MonthPlanCreatedAt.HasValue) ? e.MonthPlanCreatedAt.Value : default(DateTime);
			}

			if (e.MonthPlanUpdatedAt == null)
			{
				if (e.IsPropertyMonthPlanUpdatedAtRemoved)
				{
					this.MonthPlanUpdatedAt = default(DateTime);
				}
			}
			else
			{
				this.MonthPlanUpdatedAt = (e.MonthPlanUpdatedAt != null && e.MonthPlanUpdatedAt.HasValue) ? e.MonthPlanUpdatedAt.Value : default(DateTime);
			}

			if (e.MonthPlanActive == null)
			{
				if (e.IsPropertyMonthPlanActiveRemoved)
				{
					this.MonthPlanActive = default(bool);
				}
			}
			else
			{
				this.MonthPlanActive = (e.MonthPlanActive != null && e.MonthPlanActive.HasValue) ? e.MonthPlanActive.Value : default(bool);
			}

			if (e.MonthPlanDeleted == null)
			{
				if (e.IsPropertyMonthPlanDeletedRemoved)
				{
					this.MonthPlanDeleted = default(bool);
				}
			}
			else
			{
				this.MonthPlanDeleted = (e.MonthPlanDeleted != null && e.MonthPlanDeleted.HasValue) ? e.MonthPlanDeleted.Value : default(bool);
			}

			if (e.YearPlanDescription == null)
			{
				if (e.IsPropertyYearPlanDescriptionRemoved)
				{
					this.YearPlanDescription = default(string);
				}
			}
			else
			{
				this.YearPlanDescription = e.YearPlanDescription;
			}

			if (e.YearPlanCreatedBy == null)
			{
				if (e.IsPropertyYearPlanCreatedByRemoved)
				{
					this.YearPlanCreatedBy = default(string);
				}
			}
			else
			{
				this.YearPlanCreatedBy = e.YearPlanCreatedBy;
			}

			if (e.YearPlanUpdatedBy == null)
			{
				if (e.IsPropertyYearPlanUpdatedByRemoved)
				{
					this.YearPlanUpdatedBy = default(string);
				}
			}
			else
			{
				this.YearPlanUpdatedBy = e.YearPlanUpdatedBy;
			}

			if (e.YearPlanVersion == null)
			{
				if (e.IsPropertyYearPlanVersionRemoved)
				{
					this.YearPlanVersion = default(long);
				}
			}
			else
			{
				this.YearPlanVersion = (e.YearPlanVersion != null && e.YearPlanVersion.HasValue) ? e.YearPlanVersion.Value : default(long);
			}

			if (e.YearPlanCreatedAt == null)
			{
				if (e.IsPropertyYearPlanCreatedAtRemoved)
				{
					this.YearPlanCreatedAt = default(DateTime);
				}
			}
			else
			{
				this.YearPlanCreatedAt = (e.YearPlanCreatedAt != null && e.YearPlanCreatedAt.HasValue) ? e.YearPlanCreatedAt.Value : default(DateTime);
			}

			if (e.YearPlanUpdatedAt == null)
			{
				if (e.IsPropertyYearPlanUpdatedAtRemoved)
				{
					this.YearPlanUpdatedAt = default(DateTime);
				}
			}
			else
			{
				this.YearPlanUpdatedAt = (e.YearPlanUpdatedAt != null && e.YearPlanUpdatedAt.HasValue) ? e.YearPlanUpdatedAt.Value : default(DateTime);
			}

			if (e.YearPlanActive == null)
			{
				if (e.IsPropertyYearPlanActiveRemoved)
				{
					this.YearPlanActive = default(bool);
				}
			}
			else
			{
				this.YearPlanActive = (e.YearPlanActive != null && e.YearPlanActive.HasValue) ? e.YearPlanActive.Value : default(bool);
			}

			if (e.YearPlanDeleted == null)
			{
				if (e.IsPropertyYearPlanDeletedRemoved)
				{
					this.YearPlanDeleted = default(bool);
				}
			}
			else
			{
				this.YearPlanDeleted = (e.YearPlanDeleted != null && e.YearPlanDeleted.HasValue) ? e.YearPlanDeleted.Value : default(bool);
			}

			if (e.PersonBirthDate == null)
			{
				if (e.IsPropertyPersonBirthDateRemoved)
				{
					this.PersonBirthDate = default(DateTime);
				}
			}
			else
			{
				this.PersonBirthDate = (e.PersonBirthDate != null && e.PersonBirthDate.HasValue) ? e.PersonBirthDate.Value : default(DateTime);
			}

			if (e.PersonLoves == null)
			{
				if (e.IsPropertyPersonLovesRemoved)
				{
					this.PersonLoves = default(PersonalName);
				}
			}
			else
			{
				this.PersonLoves = e.PersonLoves;
			}

			if (e.PersonEmergencyContact == null)
			{
				if (e.IsPropertyPersonEmergencyContactRemoved)
				{
					this.PersonEmergencyContact = default(Contact);
				}
			}
			else
			{
				this.PersonEmergencyContact = e.PersonEmergencyContact;
			}

			if (e.PersonCreatedBy == null)
			{
				if (e.IsPropertyPersonCreatedByRemoved)
				{
					this.PersonCreatedBy = default(string);
				}
			}
			else
			{
				this.PersonCreatedBy = e.PersonCreatedBy;
			}

			if (e.PersonUpdatedBy == null)
			{
				if (e.IsPropertyPersonUpdatedByRemoved)
				{
					this.PersonUpdatedBy = default(string);
				}
			}
			else
			{
				this.PersonUpdatedBy = e.PersonUpdatedBy;
			}

			if (e.PersonCreatedAt == null)
			{
				if (e.IsPropertyPersonCreatedAtRemoved)
				{
					this.PersonCreatedAt = default(DateTime);
				}
			}
			else
			{
				this.PersonCreatedAt = (e.PersonCreatedAt != null && e.PersonCreatedAt.HasValue) ? e.PersonCreatedAt.Value : default(DateTime);
			}

			if (e.PersonUpdatedAt == null)
			{
				if (e.IsPropertyPersonUpdatedAtRemoved)
				{
					this.PersonUpdatedAt = default(DateTime);
				}
			}
			else
			{
				this.PersonUpdatedAt = (e.PersonUpdatedAt != null && e.PersonUpdatedAt.HasValue) ? e.PersonUpdatedAt.Value : default(DateTime);
			}

			if (e.PersonActive == null)
			{
				if (e.IsPropertyPersonActiveRemoved)
				{
					this.PersonActive = default(bool);
				}
			}
			else
			{
				this.PersonActive = (e.PersonActive != null && e.PersonActive.HasValue) ? e.PersonActive.Value : default(bool);
			}

			if (e.PersonDeleted == null)
			{
				if (e.IsPropertyPersonDeletedRemoved)
				{
					this.PersonDeleted = default(bool);
				}
			}
			else
			{
				this.PersonDeleted = (e.PersonDeleted != null && e.PersonDeleted.HasValue) ? e.PersonDeleted.Value : default(bool);
			}


			this.UpdatedBy = e.CreatedBy;
			this.UpdatedAt = e.CreatedAt;


		}

		public virtual void When(IDayPlanMvoStateDeleted e)
		{
			ThrowOnWrongEvent(e);

			this.Deleted = true;
			this.UpdatedBy = e.CreatedBy;
			this.UpdatedAt = e.CreatedAt;

		}


		public virtual void Mutate(IEvent e)
		{
			((dynamic)this).When((dynamic)e);
		}

		protected void ThrowOnWrongEvent(IDayPlanMvoStateEvent stateEvent)
		{
			var stateEntityId = this.DayPlanId; // Aggregate Id
			var eventEntityId = stateEvent.StateEventId.DayPlanId; // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
			if (stateEntityId != eventEntityId)
			{
				throw DomainError.Named("mutateWrongEntity", "Entity Id {0} in state but entity id {1} in event", stateEntityId, eventEntityId);
			}

			var stateVersion = this.PersonVersion;
			var eventVersion = stateEvent.StateEventId.PersonVersion;
			if (stateVersion != eventVersion)
			{
				throw DomainError.Named("concurrencyConflict", "Conflict between state version {0} and event version {1}", stateVersion, eventVersion);
			}

		}
	}

}

