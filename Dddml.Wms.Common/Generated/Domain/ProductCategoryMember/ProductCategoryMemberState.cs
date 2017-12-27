﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateProductCategoryMemberDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.ProductCategoryMember;

namespace Dddml.Wms.Domain.ProductCategoryMember
{

	public partial class ProductCategoryMemberState : ProductCategoryMemberStateProperties, IProductCategoryMemberState
	{

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

		public virtual string UpdatedBy { get; set; }

		public virtual DateTime UpdatedAt { get; set; }


		#region IIdentity implementation

		ProductCategoryMemberId IGlobalIdentity<ProductCategoryMemberId>.GlobalId
		{
			get
			{
				return this.ProductCategoryMemberId;
			}
		}

		#endregion

		#region IActive implementation

		bool IActive.IsActive()
		{
			return this.Active;
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

        bool IProductCategoryMemberState.IsUnsaved
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

        public ProductCategoryMemberState(IEnumerable<IEvent> events) : this(true)
        {
            if (events != null && events.Count() > 0)
            {
                this.ProductCategoryMemberId = ((IProductCategoryMemberStateEvent)events.First()).StateEventId.ProductCategoryMemberId;
                foreach (var e in events)
                {
                    Mutate(e);
                    this.Version += 1;
                }
            }
        }

        public ProductCategoryMemberState() : this(false)
        {
        }

        public ProductCategoryMemberState(bool forReapplying)
        {
            this._forReapplying = forReapplying;
            InitializeProperties();
        }


		public virtual void When(IProductCategoryMemberStateCreated e)
		{
			ThrowOnWrongEvent(e);
			this.ThruDate = e.ThruDate;

			this.Comments = e.Comments;

			this.SequenceNum = e.SequenceNum;

			this.Quantity = e.Quantity;

            this.Active = (e.Active != null && e.Active.HasValue) ? e.Active.Value : default(bool);

			this.CreatedBy = e.CreatedBy;
			this.CreatedAt = e.CreatedAt;


		}


		public virtual void When(IProductCategoryMemberStateMergePatched e)
		{
			ThrowOnWrongEvent(e);

			if (e.ThruDate == null)
			{
				if (e.IsPropertyThruDateRemoved)
				{
					this.ThruDate = default(DateTime?);
				}
			}
			else
			{
				this.ThruDate = e.ThruDate;
			}

			if (e.Comments == null)
			{
				if (e.IsPropertyCommentsRemoved)
				{
					this.Comments = default(string);
				}
			}
			else
			{
				this.Comments = e.Comments;
			}

			if (e.SequenceNum == null)
			{
				if (e.IsPropertySequenceNumRemoved)
				{
					this.SequenceNum = default(long?);
				}
			}
			else
			{
				this.SequenceNum = e.SequenceNum;
			}

			if (e.Quantity == null)
			{
				if (e.IsPropertyQuantityRemoved)
				{
					this.Quantity = default(decimal?);
				}
			}
			else
			{
				this.Quantity = e.Quantity;
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


		public virtual void Mutate(IEvent e)
		{
            StateReadOnly = false;
			((dynamic)this).When((dynamic)e);
		}

        protected void ThrowOnWrongEvent(IProductCategoryMemberStateEvent stateEvent)
        {
            var id = new System.Text.StringBuilder(); 
            id.Append("[").Append("ProductCategoryMember|");

            var stateEntityId = this.ProductCategoryMemberId; // Aggregate Id
            var eventEntityId = stateEvent.StateEventId.ProductCategoryMemberId; // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
            if (stateEntityId != eventEntityId)
            {
                throw DomainError.Named("mutateWrongEntity", "Entity Id {0} in state but entity id {1} in event", stateEntityId, eventEntityId);
            }
            id.Append(stateEntityId).Append(",");

            id.Append("]");

            var stateVersion = this.Version;
            var eventVersion = stateEvent.StateEventId.Version;
            if (stateVersion != eventVersion)
            {
                throw OptimisticConcurrencyException.Create(stateVersion, eventVersion, id.ToString());
            }
        }
    }

}
