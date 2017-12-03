﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryPRTriggeredDomainNHibernate.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryPRTriggered;
using Dddml.Wms.Domain.InventoryItem;
using Dddml.Wms.Specialization.NHibernate;
using NHibernate;
using NHibernate.Criterion;
using Spring.Transaction.Interceptor;
using Dddml.Support.Criterion;
using NHibernateICriterion = NHibernate.Criterion.ICriterion;
using NHibernateRestrictions = NHibernate.Criterion.Restrictions;
using NHibernateDisjunction = NHibernate.Criterion.Disjunction;

namespace Dddml.Wms.Domain.InventoryPRTriggered.NHibernate
{

	public partial class NHibernateInventoryPRTriggeredStateRepository : IInventoryPRTriggeredStateRepository
	{
		public ISessionFactory SessionFactory { get; set; }

		protected ISession CurrentSession {
			get { return this.SessionFactory.GetCurrentSession (); }
		}

        private static readonly ISet<string> _readOnlyPropertyNames = new SortedSet<string>(new String[] { "InventoryPRTriggeredId", "IsProcessed", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted" });
    
        public IReadOnlyProxyGenerator ReadOnlyProxyGenerator { get; set; }

		public NHibernateInventoryPRTriggeredStateRepository()
		{
		}

		[Transaction (ReadOnly = true)]
		public IInventoryPRTriggeredState Get(InventoryPRTriggeredId id, bool nullAllowed)
		{
			IInventoryPRTriggeredState state = CurrentSession.Get<InventoryPRTriggeredState> (id);
			if (!nullAllowed && state == null) {
				state = new InventoryPRTriggeredState ();
				(state as InventoryPRTriggeredState).InventoryPRTriggeredId = id;
			}
			return state;
		}

		[Transaction]
		public void Save(IInventoryPRTriggeredState state)
		{
            IInventoryPRTriggeredState s = state;
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

