﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateLocatorDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Locator;

namespace Dddml.Wms.Domain.Locator
{

	public partial class LocatorState : LocatorStateProperties, ILocatorState
	{

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

		public virtual string UpdatedBy { get; set; }

		public virtual DateTime UpdatedAt { get; set; }

		public virtual bool Deleted { get; set; }


		#region IIdentity implementation

		string IGlobalIdentity<string>.GlobalId
		{
			get
			{
				return this.LocatorId;
			}
		}

		#endregion

		#region IActive implementation

		bool IActive.IsActive()
		{
			return this.Active;
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
			get { return this.UpdatedBy; }
			set { this.UpdatedBy = value; }
		}

		DateTime IUpdated<string>.UpdatedAt
		{
			get { return this.UpdatedAt; }
			set { this.UpdatedAt = value; }
		}

		#endregion

		#region IVersioned implementation

		long IAggregateVersioned<long>.AggregateVersion
		{
			get
			{
				return this.Version;
			}
		}


		#endregion

        bool ILocatorState.IsUnsaved
        {
            get { return this.Version == VersionZero; }
        }

		public static long VersionZero
		{
			get
			{
				return (long)0;
			}
		}


        public virtual bool StateReadOnly { get; set; }

        bool IState.ReadOnly
        {
            get { return this.StateReadOnly; }
            set { this.StateReadOnly = value; }
        }
	
        private bool _forReapplying;

        public virtual bool ForReapplying
        {
            get { return _forReapplying; }
            set { _forReapplying = value; } 
        }

        public LocatorState(IEnumerable<IEvent> events) : this(true)
        {
            if (events != null && events.Count() > 0)
            {
                this.LocatorId = ((ILocatorStateEvent)events.First()).LocatorEventId.LocatorId;
                foreach (var e in events)
                {
                    Mutate(e);
                    this.Version += 1;
                }
            }
        }

        public LocatorState() : this(false)
        {
        }

        public LocatorState(bool forReapplying)
        {
            this._forReapplying = forReapplying;
            InitializeProperties();
        }


		public virtual void When(ILocatorStateCreated e)
		{
			ThrowOnWrongEvent(e);
			this.WarehouseId = e.WarehouseId;

			this.ParentLocatorId = e.ParentLocatorId;

			this.LocatorType = e.LocatorType;

			this.PriorityNumber = e.PriorityNumber;

            this.IsDefault = (e.IsDefault != null && e.IsDefault.HasValue) ? e.IsDefault.Value : default(bool);

			this.X = e.X;

			this.Y = e.Y;

			this.Z = e.Z;

			this.Description = e.Description;

			this.LocatorTypeId = e.LocatorTypeId;

            this.Active = (e.Active != null && e.Active.HasValue) ? e.Active.Value : default(bool);

			this.Deleted = false;

			this.CreatedBy = e.CreatedBy;
			this.CreatedAt = e.CreatedAt;


		}


		public virtual void When(ILocatorStateMergePatched e)
		{
			ThrowOnWrongEvent(e);

			if (e.WarehouseId == null)
			{
				if (e.IsPropertyWarehouseIdRemoved)
				{
					this.WarehouseId = default(string);
				}
			}
			else
			{
				this.WarehouseId = e.WarehouseId;
			}

			if (e.ParentLocatorId == null)
			{
				if (e.IsPropertyParentLocatorIdRemoved)
				{
					this.ParentLocatorId = default(string);
				}
			}
			else
			{
				this.ParentLocatorId = e.ParentLocatorId;
			}

			if (e.LocatorType == null)
			{
				if (e.IsPropertyLocatorTypeRemoved)
				{
					this.LocatorType = default(string);
				}
			}
			else
			{
				this.LocatorType = e.LocatorType;
			}

			if (e.PriorityNumber == null)
			{
				if (e.IsPropertyPriorityNumberRemoved)
				{
					this.PriorityNumber = default(string);
				}
			}
			else
			{
				this.PriorityNumber = e.PriorityNumber;
			}

			if (e.IsDefault == null)
			{
				if (e.IsPropertyIsDefaultRemoved)
				{
					this.IsDefault = default(bool);
				}
			}
			else
			{
				this.IsDefault = (e.IsDefault != null && e.IsDefault.HasValue) ? e.IsDefault.Value : default(bool);
			}

			if (e.X == null)
			{
				if (e.IsPropertyXRemoved)
				{
					this.X = default(string);
				}
			}
			else
			{
				this.X = e.X;
			}

			if (e.Y == null)
			{
				if (e.IsPropertyYRemoved)
				{
					this.Y = default(string);
				}
			}
			else
			{
				this.Y = e.Y;
			}

			if (e.Z == null)
			{
				if (e.IsPropertyZRemoved)
				{
					this.Z = default(string);
				}
			}
			else
			{
				this.Z = e.Z;
			}

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

			if (e.LocatorTypeId == null)
			{
				if (e.IsPropertyLocatorTypeIdRemoved)
				{
					this.LocatorTypeId = default(string);
				}
			}
			else
			{
				this.LocatorTypeId = e.LocatorTypeId;
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


		}

		public virtual void When(ILocatorStateDeleted e)
		{
			ThrowOnWrongEvent(e);

			this.Deleted = true;
			this.UpdatedBy = e.CreatedBy;
			this.UpdatedAt = e.CreatedAt;

		}


		public virtual void Mutate(IEvent e)
		{
            StateReadOnly = false;
			((dynamic)this).When((dynamic)e);
            if (!(this.LocatorId.StartsWith(this.WarehouseId)))
            {
                throw DomainError.Named("constraintViolated", "Violated validation logic: {0}", "this.LocatorId.StartsWith(this.WarehouseId)");
            }
		}

        protected void ThrowOnWrongEvent(ILocatorStateEvent stateEvent)
        {
            var id = new System.Text.StringBuilder(); 
            id.Append("[").Append("Locator|");

            var stateEntityId = this.LocatorId; // Aggregate Id
            var eventEntityId = stateEvent.LocatorEventId.LocatorId;
            if (stateEntityId != eventEntityId)
            {
                throw DomainError.Named("mutateWrongEntity", "Entity Id {0} in state but entity id {1} in event", stateEntityId, eventEntityId);
            }
            id.Append(stateEntityId).Append(",");

            id.Append("]");

            var stateVersion = this.Version;
            var eventVersion = stateEvent.LocatorEventId.Version;
            if (stateVersion != eventVersion)
            {
                throw OptimisticConcurrencyException.Create(stateVersion, eventVersion, id.ToString());
            }
        }
    }

}

