﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainNHibernateAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Domain;

using Dddml.Wms.Specialization;
using Dddml.Wms.Specialization.NHibernate;
using NHibernate;
using NHibernate.Criterion;
using Spring.Transaction.Interceptor;

namespace Dddml.Wms.Domain.NHibernate
{

	public class NHibernateAttributeStateRepository : IAttributeStateRepository
	{
		public ISessionFactory SessionFactory { get; set; }

		protected ISession CurrentSession {
			get { return this.SessionFactory.GetCurrentSession (); }
		}

		public NHibernateAttributeStateRepository ()
		{
		}

		[Transaction (ReadOnly = true)]
		public IAttributeState Get (string id)
		{
			IAttributeState state = CurrentSession.Get<AttributeState> (id);
			if (state == null) {
				state = new AttributeState ();
				(state as AttributeState).AttributeId = id;
			}
			return state;
		}

        [Transaction(ReadOnly = true)]
        public IEnumerable<IAttributeState> GetAll(int firstResult, int maxResults)
        {
            var criteria = CurrentSession.CreateCriteria<AttributeState>();
            criteria.SetFirstResult(firstResult);
            criteria.SetMaxResults(maxResults);
            return criteria.List<AttributeState>();
        }

		[Transaction]
		public void Save (IAttributeState state)
		{
			CurrentSession.SaveOrUpdate (state);

			var saveable = state as ISaveable;
			if (saveable != null) {
				saveable.Save ();
			}
		}

        [Transaction(ReadOnly = true)]
        public virtual IEnumerable<IAttributeState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            var criteria = CurrentSession.CreateCriteria<AttributeState>();

            if (filter != null)
            {
                SetCriteriaFilter(criteria, filter);
            }
            if (orders != null)
            {
                SetCriteriaOrders(criteria, orders);
            }

            criteria.SetFirstResult(firstResult);
            criteria.SetMaxResults(maxResults);
            return criteria.List<AttributeState>();
        }

        [Transaction(ReadOnly = true)]
        public virtual IAttributeState GetFirst(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null)
        {
            var list = Get(filter, orders, 0, 1);
            if (list == null)
            {
                return null;
            }
            return list.FirstOrDefault<IAttributeState>();
        }

        [Transaction(ReadOnly = true)]
        public virtual IAttributeState GetFirst(KeyValuePair<string, object> keyValue, IList<string> orders = null)
        {
            return GetFirst(new KeyValuePair<string, object>[] { keyValue }, orders);
        }

        protected void SetCriteriaFilter(ICriteria criteria, IEnumerable<KeyValuePair<string, object>> filter)
        {
            foreach (KeyValuePair<string, object> p in filter)
            {
                SetCriteriaFilterPair(criteria, p);
            }
        }

        protected void SetCriteriaFilterPair(ICriteria criteria, KeyValuePair<string, object> filterPair)
        {
            if (filterPair.Value == null)
            {
                criteria.Add(Expression.IsNull(filterPair.Key));
            }
            else
            {
                criteria.Add(Expression.Eq(filterPair.Key, filterPair.Value));
            }
        }

        protected void SetCriteriaOrders(ICriteria criteria, IList<string> orders)
        {
            foreach (var order in orders)
            {
                bool isDesc = order.StartsWith("-");
                var pName = isDesc ? order.Substring(1) : order;
                criteria.AddOrder(isDesc ? Order.Desc(pName) : Order.Asc(pName));
            }
        }

	}
}

