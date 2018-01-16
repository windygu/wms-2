﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePartyDomainNHibernate.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Party;
using Dddml.Wms.Specialization.NHibernate;
using NHibernate;
using NHibernate.Criterion;
using Spring.Transaction.Interceptor;
using Dddml.Support.Criterion;
using NHibernateICriterion = NHibernate.Criterion.ICriterion;
using NHibernateRestrictions = NHibernate.Criterion.Restrictions;
using NHibernateDisjunction = NHibernate.Criterion.Disjunction;

namespace Dddml.Wms.Domain.Party.NHibernate
{

	public partial class NHibernatePartyStateRepository : IPartyStateRepository
	{
		public ISessionFactory SessionFactory { get; set; }

		protected ISession CurrentSession {
			get { return this.SessionFactory.GetCurrentSession (); }
		}

        private static readonly ISet<string> _readOnlyPropertyNames = new SortedSet<string>(new String[] { "PartyId", "PartyTypeId", "OrganizationName", "Description", "Type", "IsSummary", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted" });
    
        public IReadOnlyProxyGenerator ReadOnlyProxyGenerator { get; set; }

		public NHibernatePartyStateRepository()
		{
		}

        [Transaction (ReadOnly = true)]
		public IPartyState Get(string id, bool nullAllowed)
        {
            return Get(typeof(IPartyState), id, nullAllowed);
        }

		[Transaction (ReadOnly = true)]
        public IPartyState Get(Type type, string id, bool nullAllowed)
		{
			IPartyState state = CurrentSession.Get<PartyState> (id);
            if (state != null && !type.IsAssignableFrom(state.GetType())) 
            {
                throw new InvalidCastException(String.Format("state is NOT instance of {0}", type.Name));
            }
			if (!nullAllowed && state == null) {
                state = NewEmptyState(type);
				(state as PartyState).PartyId = id;
			}
			return state;
		}

        private PartyState NewEmptyState(Type type) 
        {
            PartyState state = null;
            Type clazz = null;
            if (state != null) {
                // do nothing.
            }
            else if (type.Equals(typeof(PartyState))) {
                clazz = typeof(PartyState);
            }
            else if (type.Equals(typeof(OrganizationState))) {
                clazz = typeof(OrganizationState);
            }
            else {
                throw new ArgumentException(String.Format("type: {0}", type.Name));
            }
            state = (PartyState)clazz.GetConstructor(new Type[0]).Invoke(new object[0]);
            return state;
        }

		[Transaction]
		public void Save(IPartyState state)
		{
            IPartyState s = state;
            if (ReadOnlyProxyGenerator != null)
            {
                s = ReadOnlyProxyGenerator.GetTarget<IPartyState>(state);
            }
			CurrentSession.SaveOrUpdate (s);

			var saveable = s as ISaveable;
			if (saveable != null) {
				saveable.Save ();
			}
            CurrentSession.Flush();
		}

        //protected static void AddNotDeletedRestriction(ICriteria criteria)
        //{
        //    criteria.Add(NHibernateRestrictions.Eq("Deleted", false));
        //}

	}
}

