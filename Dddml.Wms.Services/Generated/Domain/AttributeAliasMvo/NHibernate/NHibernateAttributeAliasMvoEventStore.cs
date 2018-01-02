﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateAttributeAliasMvoDomainNHibernate.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.AttributeAliasMvo;
using Dddml.Wms.Domain.Attribute;
using Dddml.Wms.Specialization.NHibernate;
using NHibernate;
using NHibernate.Criterion;
using Spring.Transaction.Interceptor;

namespace Dddml.Wms.Domain.AttributeAliasMvo.NHibernate
{

	public class NHibernateAttributeAliasMvoEventStore : NHibernateEventStoreBase
	{
		public override object GetEventId(IEventStoreAggregateId eventStoreAggregateId, long version)
		{
			return new AttributeAliasMvoStateEventId((AttributeAliasId)(eventStoreAggregateId as EventStoreAggregateId).Id, (long)version);
		}

		public override Type GetSupportedStateEventType()
		{
			return typeof(AttributeAliasMvoStateEventBase);
		}

        [Transaction(ReadOnly = true)]
        public override EventStream LoadEventStream(Type eventType, IEventStoreAggregateId eventStoreAggregateId, long version)
        {
            Type supportedEventType = typeof(AttributeAliasMvoStateEventBase);
            if (!eventType.IsAssignableFrom(supportedEventType))
            {
                throw new NotSupportedException();
            }
            AttributeAliasId idObj = (AttributeAliasId)(eventStoreAggregateId as EventStoreAggregateId).Id;
            var criteria = CurrentSession.CreateCriteria<AttributeAliasMvoStateEventBase>();
            criteria.Add(Restrictions.Eq("StateEventId.AttributeAliasIdAttributeId", idObj.AttributeId));
            criteria.Add(Restrictions.Eq("StateEventId.AttributeAliasIdCode", idObj.Code));
            criteria.Add(Restrictions.Le("StateEventId.AttributeVersion", version));
            criteria.AddOrder(global::NHibernate.Criterion.Order.Asc("StateEventId.AttributeVersion"));
            var es = criteria.List<IEvent>();
            foreach (AttributeAliasMvoStateEventBase e in es)
            {
                e.StateEventReadOnly = true;
            }
            return new EventStream()
            {
                SteamVersion = es.Count > 0 ? ((AttributeAliasMvoStateEventBase)es.Last()).StateEventId.AttributeVersion : default(long),
                Events = es
            };
        }

	}

}
