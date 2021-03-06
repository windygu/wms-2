﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePicklistBinDomainNHibernate.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PicklistBin;
using Dddml.Wms.Specialization.NHibernate;
using NHibernate;
using NHibernate.Criterion;
using Spring.Transaction.Interceptor;
using Dddml.Support.Criterion;
using NHibernateICriterion = NHibernate.Criterion.ICriterion;
using NHibernateRestrictions = NHibernate.Criterion.Restrictions;
using NHibernateDisjunction = NHibernate.Criterion.Disjunction;

namespace Dddml.Wms.Domain.PicklistBin.NHibernate
{

	public partial class NHibernatePicklistBinStateQueryRepository : IPicklistBinStateQueryRepository
	{
		public ISessionFactory SessionFactory { get; set; }

		protected ISession CurrentSession {
			get { return this.SessionFactory.GetCurrentSession (); }
		}

        private static readonly ISet<string> _readOnlyPropertyNames = new SortedSet<string>(new String[] { "PicklistBinId", "PicklistId", "BinLocationNumber", "PrimaryOrderId", "PrimaryShipGroupSeqId", "PicklistItems", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted" });
    
        public IReadOnlyProxyGenerator ReadOnlyProxyGenerator { get; set; }

		public NHibernatePicklistBinStateQueryRepository ()
		{
		}

		[Transaction (ReadOnly = true)]
		public IPicklistBinState Get(string id)
		{
			IPicklistBinState state = CurrentSession.Get<PicklistBinState>(id);
            if (ReadOnlyProxyGenerator != null && state != null)
            {
                return ReadOnlyProxyGenerator.CreateProxy<IPicklistBinState>(state, new Type[] { typeof(ISaveable) }, _readOnlyPropertyNames);
            }
			return state;
		}

        [Transaction(ReadOnly = true)]
        public IEnumerable<IPicklistBinState> GetAll(int firstResult, int maxResults)
        {
            var criteria = CurrentSession.CreateCriteria<PicklistBinState>();
            criteria.SetFirstResult(firstResult);
            criteria.SetMaxResults(maxResults);
            AddNotDeletedRestriction(criteria);
            return criteria.List<PicklistBinState>();
        }

        [Transaction(ReadOnly = true)]
        public virtual IEnumerable<IPicklistBinState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            var criteria = CurrentSession.CreateCriteria<PicklistBinState>();

            NHibernateUtils.CriteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
            AddNotDeletedRestriction(criteria);
            return criteria.List<PicklistBinState>();
        }

        [Transaction(ReadOnly = true)]
        public virtual IEnumerable<IPicklistBinState> Get(Dddml.Support.Criterion.ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            var criteria = CurrentSession.CreateCriteria<PicklistBinState>();

            NHibernateUtils.CriteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
            AddNotDeletedRestriction(criteria);
            return criteria.List<PicklistBinState>();
        }


        [Transaction(ReadOnly = true)]
        public virtual IPicklistBinState GetFirst(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null)
        {
            var list = (IList<PicklistBinState>)Get(filter, orders, 0, 1);
            if (list == null || list.Count <= 0)
            {
                return null;
            }
            return list[0];
        }

        [Transaction(ReadOnly = true)]
        public virtual IPicklistBinState GetFirst(KeyValuePair<string, object> keyValue, IList<string> orders = null)
        {
            return GetFirst(new KeyValuePair<string, object>[] { keyValue }, orders);
        }

        [Transaction(ReadOnly = true)]
        public virtual IEnumerable<IPicklistBinState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            var filter = new KeyValuePair<string, object>[] { new KeyValuePair<string, object>(propertyName, propertyValue) };
            return Get(filter, orders, firstResult, maxResults);
        }

        [Transaction(ReadOnly = true)]
        public virtual long GetCount(IEnumerable<KeyValuePair<string, object>> filter)
        {
            var criteria = CurrentSession.CreateCriteria<PicklistBinState>();
            criteria.SetProjection(Projections.RowCountInt64());
            NHibernateUtils.CriteriaAddFilter(criteria, filter);
            AddNotDeletedRestriction(criteria);
            return criteria.UniqueResult<long>();
        }

        [Transaction(ReadOnly = true)]
        public virtual long GetCount(Dddml.Support.Criterion.ICriterion filter)
        {
            var criteria = CurrentSession.CreateCriteria<PicklistBinState>();
            criteria.SetProjection(Projections.RowCountInt64());
            if (filter != null)
            {
                NHibernateICriterion hc = CriterionUtils.ToNHibernateCriterion(filter);
                criteria.Add(hc);
            }
            AddNotDeletedRestriction(criteria);
            return criteria.UniqueResult<long>();
        }

        [Transaction(ReadOnly = true)]
        public virtual IPicklistItemState GetPicklistItem(string picklistBinId, PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId)
        {
            var entityId = new PicklistBinPicklistItemId(picklistBinId, picklistItemOrderShipGrpInvId);
            return CurrentSession.Get<PicklistItemState>(entityId);
        }

        [Transaction(ReadOnly = true)]
        public IEnumerable<IPicklistItemState> GetPicklistItems(string picklistBinId)
        {
            var criteria = CurrentSession.CreateCriteria<PicklistItemState>();
            var partIdCondition = global::NHibernate.Criterion.Restrictions.Conjunction()
                .Add(global::NHibernate.Criterion.Restrictions.Eq("PicklistBinPicklistItemId.PicklistBinId", picklistBinId))
                ;

            return criteria.Add(partIdCondition).List<PicklistItemState>();
        }


        protected static void AddNotDeletedRestriction(ICriteria criteria)
        {
            criteria.Add(NHibernateRestrictions.Eq("Deleted", false));
        }

	}
}

