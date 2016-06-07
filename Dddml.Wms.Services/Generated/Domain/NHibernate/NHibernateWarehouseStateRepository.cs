﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainNHibernateAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Specialization.NHibernate;
using NHibernate;
using NHibernate.Criterion;
using Spring.Transaction.Interceptor;
using Dddml.Support.Criterion;
using NHibernateICriterion = NHibernate.Criterion.ICriterion;
using NHibernateRestrictions = NHibernate.Criterion.Restrictions;
using NHibernateDisjunction = NHibernate.Criterion.Disjunction;

namespace Dddml.Wms.Domain.NHibernate
{

	public partial class NHibernateWarehouseStateRepository : IWarehouseStateRepository
	{
		public ISessionFactory SessionFactory { get; set; }

		protected ISession CurrentSession {
			get { return this.SessionFactory.GetCurrentSession (); }
		}

		public NHibernateWarehouseStateRepository ()
		{
		}

		[Transaction (ReadOnly = true)]
		public IWarehouseState Get (string id)
		{
			IWarehouseState state = CurrentSession.Get<WarehouseState> (id);
			if (state == null) {
				state = new WarehouseState ();
				(state as WarehouseState).WarehouseId = id;
			}
			return state;
		}

        [Transaction(ReadOnly = true)]
        public IEnumerable<IWarehouseState> GetAll(int firstResult, int maxResults)
        {
            var criteria = CurrentSession.CreateCriteria<WarehouseState>();
            criteria.SetFirstResult(firstResult);
            criteria.SetMaxResults(maxResults);
            return criteria.List<WarehouseState>();
        }

		[Transaction]
		public void Save (IWarehouseState state)
		{
			CurrentSession.SaveOrUpdate (state);

			var saveable = state as ISaveable;
			if (saveable != null) {
				saveable.Save ();
			}
		}

        [Transaction(ReadOnly = true)]
        public virtual IEnumerable<IWarehouseState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            var criteria = CurrentSession.CreateCriteria<WarehouseState>();

            if (filter != null)
            {
                CriteriaAddFilter(criteria, filter);
            }
            if (orders != null)
            {
                CriteriaAddOrders(criteria, orders);
            }

            criteria.SetFirstResult(firstResult);
            criteria.SetMaxResults(maxResults);
            return criteria.List<WarehouseState>();
        }

        [Transaction(ReadOnly = true)]
        public virtual IEnumerable<IWarehouseState> Get(Dddml.Support.Criterion.ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            var criteria = CurrentSession.CreateCriteria<WarehouseState>();

            if (filter != null)
            {
                NHibernateICriterion hc = CriterionUtils.ToNHibernateCriterion(filter);
                criteria.Add(hc);
            }
            if (orders != null)
            {
                CriteriaAddOrders(criteria, orders);
            }

            criteria.SetFirstResult(firstResult);
            criteria.SetMaxResults(maxResults);
            return criteria.List<WarehouseState>();
        }


        [Transaction(ReadOnly = true)]
        public virtual IWarehouseState GetFirst(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null)
        {
            var list = (IList<WarehouseState>)Get(filter, orders, 0, 1);
            if (list == null || list.Count <= 0)
            {
                return null;
            }
            return list[0];
        }

        [Transaction(ReadOnly = true)]
        public virtual IWarehouseState GetFirst(KeyValuePair<string, object> keyValue, IList<string> orders = null)
        {
            return GetFirst(new KeyValuePair<string, object>[] { keyValue }, orders);
        }

        [Transaction(ReadOnly = true)]
        public virtual long GetCount(IEnumerable<KeyValuePair<string, object>> filter)
        {
            var criteria = CurrentSession.CreateCriteria<WarehouseState>();
            criteria.SetProjection(Projections.RowCountInt64());
            CriteriaAddFilter(criteria, filter);
            return criteria.UniqueResult<long>();
        }

        [Transaction(ReadOnly = true)]
        public virtual long GetCount(Dddml.Support.Criterion.ICriterion filter)
        {
            var criteria = CurrentSession.CreateCriteria<WarehouseState>();
            criteria.SetProjection(Projections.RowCountInt64());
            if (filter != null)
            {
                NHibernateICriterion hc = CriterionUtils.ToNHibernateCriterion(filter);
                criteria.Add(hc);
            }
            return criteria.UniqueResult<long>();
        }

        protected void CriteriaAddFilter(ICriteria criteria, IEnumerable<KeyValuePair<string, object>> filter)
        {
            foreach (KeyValuePair<string, object> p in filter)
            {
                CriteriaAddFilterPair(criteria, p);
            }
        }

        protected void CriteriaAddFilterPair(ICriteria criteria, KeyValuePair<string, object> filterPair)
        {
            if (filterPair.Value == null)
            {
                criteria.Add(NHibernateRestrictions.IsNull(filterPair.Key));
            }
            else
            {
                criteria.Add(NHibernateRestrictions.Eq(filterPair.Key, filterPair.Value));
            }
        }

        protected void CriteriaAddOrders(ICriteria criteria, IList<string> orders)
        {
            foreach (var order in orders)
            {
                bool isDesc = order.StartsWith("-");
                var pName = isDesc ? order.Substring(1) : order;
                criteria.AddOrder(isDesc ? Order.Desc(pName) : Order.Asc(pName));
            }
        }

        protected void DisjunctionAddCriterion(NHibernateDisjunction disjunction, string propertyName, object propertyValue)
        {
            if (propertyValue == null)
            {
                disjunction.Add(NHibernateRestrictions.IsNull(propertyName));
            }
            else
            {
                disjunction.Add(NHibernateRestrictions.Eq(propertyName, propertyValue));
            }
        }

        protected void CriteriaAddCriterion(ICriteria criteria, string propertyName, object propertyValue)
        {
            if (propertyValue == null)
            {
                criteria.Add(NHibernateRestrictions.IsNull(propertyName));
            }
            else
            {
                criteria.Add(NHibernateRestrictions.Eq(propertyName, propertyValue));
            }
        }

        private static void CriteriaAddFilterAndSetFirstResultAndMaxResults(ICriteria criteria, Dddml.Support.Criterion.ICriterion filter, int firstResult, int maxResults)
        {
            if (filter != null)
            {
                NHibernateICriterion hc = CriterionUtils.ToNHibernateCriterion(filter);
                criteria.Add(hc);
            }
            criteria.SetFirstResult(firstResult);
            criteria.SetMaxResults(maxResults);
        }

	}
}

