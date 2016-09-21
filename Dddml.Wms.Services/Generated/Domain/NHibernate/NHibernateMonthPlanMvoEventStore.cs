﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainNHibernateAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Specialization.NHibernate;
using NHibernate;
using NHibernate.Criterion;
using Spring.Transaction.Interceptor;

namespace Dddml.Wms.Domain.NHibernate
{

	public class NHibernateMonthPlanMvoEventStore : NHibernateEventStoreBase
	{
		public override object GetEventId(IEventStoreAggregateId eventStoreAggregateId, long version)
		{
			return new MonthPlanMvoStateEventId((MonthPlanId)(eventStoreAggregateId as EventStoreAggregateId).Id, (long)version);
		}

		public override Type GetSupportedStateEventType()
		{
			return typeof(MonthPlanMvoStateEventBase);
		}

        [Transaction(ReadOnly = true)]
        public override EventStream LoadEventStream(Type eventType, IEventStoreAggregateId eventStoreAggregateId, long version)
        {
            Type supportedEventType = typeof(MonthPlanMvoStateEventBase);
            if (!eventType.IsAssignableFrom(supportedEventType))
            {
                throw new NotSupportedException();
            }
            MonthPlanId idObj = (MonthPlanId)(eventStoreAggregateId as EventStoreAggregateId).Id;
            var criteria = CurrentSession.CreateCriteria<MonthPlanMvoStateEventBase>();
            criteria.Add(Restrictions.Eq("StateEventId.MonthPlanIdPersonalNameFirstName", idObj.PersonalNameFirstName));
            criteria.Add(Restrictions.Eq("StateEventId.MonthPlanIdPersonalNameLastName", idObj.PersonalNameLastName));
            criteria.Add(Restrictions.Eq("StateEventId.MonthPlanIdYear", idObj.Year));
            criteria.Add(Restrictions.Eq("StateEventId.MonthPlanIdMonth", idObj.Month));
            criteria.Add(Restrictions.Le("StateEventId.PersonVersion", version));
            criteria.AddOrder(Order.Asc("StateEventId.PersonVersion"));
            var es = criteria.List<IEvent>();
            foreach (MonthPlanMvoStateEventBase e in es)
            {
                e.StateEventReadOnly = true;
            }
            return new EventStream()
            {
                SteamVersion = es.Count > 0 ? ((MonthPlanMvoStateEventBase)es.Last()).StateEventId.PersonVersion : default(long),
                Events = es
            };
        }

	}

}

