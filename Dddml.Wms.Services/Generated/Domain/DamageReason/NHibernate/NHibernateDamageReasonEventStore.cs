﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateDamageReasonDomainNHibernate.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.DamageReason;
using Dddml.Wms.Specialization.NHibernate;
using NHibernate;
using NHibernate.Criterion;
using Spring.Transaction.Interceptor;

namespace Dddml.Wms.Domain.DamageReason.NHibernate
{

	public class NHibernateDamageReasonEventStore : NHibernateEventStoreBase
	{
		public override object GetEventId(IEventStoreAggregateId eventStoreAggregateId, long version)
		{
			return new DamageReasonEventId((string)(eventStoreAggregateId as EventStoreAggregateId).Id, (long)version);
		}

		public override Type GetSupportedEventType()
		{
			return typeof(DamageReasonEventBase);
		}

        [Transaction(ReadOnly = true)]
        public override EventStream LoadEventStream(Type eventType, IEventStoreAggregateId eventStoreAggregateId, long version)
        {
            Type supportedEventType = typeof(DamageReasonEventBase);
            if (!eventType.IsAssignableFrom(supportedEventType))
            {
                throw new NotSupportedException();
            }
            string idObj = (string)(eventStoreAggregateId as EventStoreAggregateId).Id;
            var criteria = CurrentSession.CreateCriteria<DamageReasonEventBase>();
            criteria.Add(Restrictions.Eq("DamageReasonEventId.DamageReasonId", idObj));
            criteria.Add(Restrictions.Le("DamageReasonEventId.Version", version));
            criteria.AddOrder(global::NHibernate.Criterion.Order.Asc("DamageReasonEventId.Version"));
            var es = criteria.List<IEvent>();
            foreach (DamageReasonEventBase e in es)
            {
                e.EventReadOnly = true;
            }
            return new EventStream()
            {
                SteamVersion = es.Count > 0 ? ((DamageReasonEventBase)es.Last()).DamageReasonEventId.Version : default(long),
                Events = es
            };
        }

	}

}

