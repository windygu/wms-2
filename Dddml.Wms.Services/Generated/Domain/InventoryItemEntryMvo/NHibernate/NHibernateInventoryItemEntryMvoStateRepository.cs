﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryItemEntryMvoDomainNHibernate.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryItemEntryMvo;
using Dddml.Wms.Domain.InventoryItem;
using Dddml.Wms.Specialization.NHibernate;
using NHibernate;
using NHibernate.Criterion;
using Spring.Transaction.Interceptor;
using Dddml.Support.Criterion;
using NHibernateICriterion = NHibernate.Criterion.ICriterion;
using NHibernateRestrictions = NHibernate.Criterion.Restrictions;
using NHibernateDisjunction = NHibernate.Criterion.Disjunction;

namespace Dddml.Wms.Domain.InventoryItemEntryMvo.NHibernate
{

	public partial class NHibernateInventoryItemEntryMvoStateRepository : IInventoryItemEntryMvoStateRepository
	{
		public ISessionFactory SessionFactory { get; set; }

		protected ISession CurrentSession {
			get { return this.SessionFactory.GetCurrentSession (); }
		}

        private static readonly ISet<string> _readOnlyPropertyNames = new SortedSet<string>(new String[] { "InventoryItemEntryId", "QuantityOnHand", "QuantityInTransit", "QuantityReserved", "QuantityOccupied", "QuantityVirtual", "Source", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "InventoryItemQuantityOnHand", "InventoryItemQuantityInTransit", "InventoryItemQuantityReserved", "InventoryItemQuantityOccupied", "InventoryItemQuantityVirtual", "InventoryItemEntries", "InventoryItemVersion", "InventoryItemCreatedBy", "InventoryItemCreatedAt", "InventoryItemUpdatedBy", "InventoryItemUpdatedAt" });
    
        public IReadOnlyProxyGenerator ReadOnlyProxyGenerator { get; set; }

		public NHibernateInventoryItemEntryMvoStateRepository()
		{
		}

		[Transaction (ReadOnly = true)]
		public IInventoryItemEntryMvoState Get(InventoryItemEntryId id, bool nullAllowed)
		{
			IInventoryItemEntryMvoState state = CurrentSession.Get<InventoryItemEntryMvoState> (id);
			if (!nullAllowed && state == null) {
				state = new InventoryItemEntryMvoState ();
				(state as InventoryItemEntryMvoState).InventoryItemEntryId = id;
			}
            if (ReadOnlyProxyGenerator != null && state != null)
            {
                return ReadOnlyProxyGenerator.CreateProxy<IInventoryItemEntryMvoState>(state, new Type[] {  }, _readOnlyPropertyNames);
            }
			return state;
		}

		[Transaction]
		public void Save(IInventoryItemEntryMvoState state)
		{
            IInventoryItemEntryMvoState s = state;
            if (ReadOnlyProxyGenerator != null)
            {
                s = ReadOnlyProxyGenerator.GetTarget<IInventoryItemEntryMvoState>(state);
            }
			CurrentSession.SaveOrUpdate (s);

			var saveable = s as ISaveable;
			if (saveable != null) {
				saveable.Save ();
			}
		}

        //protected static void AddNotDeletedRestriction(ICriteria criteria)
        //{
        //    criteria.Add(NHibernateRestrictions.Eq("Deleted", false));
        //}

	}
}

