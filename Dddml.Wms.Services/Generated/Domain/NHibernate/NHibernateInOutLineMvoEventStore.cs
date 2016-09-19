﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainNHibernateAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using NodaMoney;
using Dddml.Wms.Specialization.NHibernate;
using NHibernate;
using NHibernate.Criterion;
using Spring.Transaction.Interceptor;

namespace Dddml.Wms.Domain.NHibernate
{

	public class NHibernateInOutLineMvoEventStore : NHibernateEventStoreBase
	{
		public override object GetEventId(IEventStoreAggregateId eventStoreAggregateId, long version)
		{
			return new InOutLineMvoStateEventId((InOutLineId)(eventStoreAggregateId as EventStoreAggregateId).Id, (long)version);
		}

		public override Type GetSupportedStateEventType()
		{
			return typeof(InOutLineMvoStateEventBase);
		}

        [Transaction(ReadOnly = true)]
        public override EventStream LoadEventStream(Type eventType, IEventStoreAggregateId eventStoreAggregateId, long version)
        {
            Type supportedEventType = typeof(InOutLineMvoStateEventBase);
            if (!eventType.IsAssignableFrom(supportedEventType))
            {
                throw new NotSupportedException();
            }
            InOutLineId idObj = (InOutLineId)(eventStoreAggregateId as EventStoreAggregateId).Id;
            var criteria = CurrentSession.CreateCriteria<InOutLineMvoStateEventBase>();
            criteria.Add(Restrictions.Eq("StateEventId.InOutLineIdInOutDocumentNumber", idObj.InOutDocumentNumber));
            criteria.Add(Restrictions.Eq("StateEventId.InOutLineIdSkuIdProductId", idObj.SkuIdProductId));
            criteria.Add(Restrictions.Eq("StateEventId.InOutLineIdSkuIdAttributeSetInstanceId", idObj.SkuIdAttributeSetInstanceId));
            criteria.Add(Restrictions.Le("StateEventId.InOutVersion", version));
            criteria.AddOrder(Order.Asc("StateEventId.InOutVersion"));
            var es = criteria.List<IEvent>();
            foreach (InOutLineMvoStateEventBase e in es)
            {
                e.StateEventReadOnly = true;
            }
            return new EventStream()
            {
                SteamVersion = ((InOutLineMvoStateEventBase)es.Last()).StateEventId.InOutVersion,
                Events = es
            };
        }

	}

}

