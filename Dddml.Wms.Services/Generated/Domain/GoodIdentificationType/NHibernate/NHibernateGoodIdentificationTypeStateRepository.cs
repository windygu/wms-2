﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateGoodIdentificationTypeDomainNHibernate.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.GoodIdentificationType;
using Dddml.Wms.Specialization.NHibernate;
using NHibernate;
using NHibernate.Criterion;
using Spring.Transaction.Interceptor;
using Dddml.Support.Criterion;
using NHibernateICriterion = NHibernate.Criterion.ICriterion;
using NHibernateRestrictions = NHibernate.Criterion.Restrictions;
using NHibernateDisjunction = NHibernate.Criterion.Disjunction;

namespace Dddml.Wms.Domain.GoodIdentificationType.NHibernate
{

	public partial class NHibernateGoodIdentificationTypeStateRepository : IGoodIdentificationTypeStateRepository
	{
		public ISessionFactory SessionFactory { get; set; }

		protected ISession CurrentSession {
			get { return this.SessionFactory.GetCurrentSession (); }
		}

        private static readonly ISet<string> _readOnlyPropertyNames = new SortedSet<string>(new String[] { "GoodIdentificationTypeId", "ParentTypeId", "HasTable", "Description", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted" });
    
        public IReadOnlyProxyGenerator ReadOnlyProxyGenerator { get; set; }

		public NHibernateGoodIdentificationTypeStateRepository()
		{
		}

		[Transaction (ReadOnly = true)]
		public IGoodIdentificationTypeState Get(string id, bool nullAllowed)
		{
			IGoodIdentificationTypeState state = CurrentSession.Get<GoodIdentificationTypeState> (id);
			if (!nullAllowed && state == null) {
				state = new GoodIdentificationTypeState ();
				(state as GoodIdentificationTypeState).GoodIdentificationTypeId = id;
			}
            if (ReadOnlyProxyGenerator != null && state != null)
            {
                return ReadOnlyProxyGenerator.CreateProxy<IGoodIdentificationTypeState>(state, new Type[] {  }, _readOnlyPropertyNames);
            }
			return state;
		}

		[Transaction]
		public void Save(IGoodIdentificationTypeState state)
		{
            IGoodIdentificationTypeState s = state;
            if (ReadOnlyProxyGenerator != null)
            {
                s = ReadOnlyProxyGenerator.GetTarget<IGoodIdentificationTypeState>(state);
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

