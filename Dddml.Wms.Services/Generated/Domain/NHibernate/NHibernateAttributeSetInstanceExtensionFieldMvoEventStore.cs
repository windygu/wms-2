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

	public class NHibernateAttributeSetInstanceExtensionFieldMvoEventStore : NHibernateEventStoreBase
	{
		public override object GetEventId(IEventStoreAggregateId eventStoreAggregateId, long version)
		{
			return new AttributeSetInstanceExtensionFieldMvoStateEventId((AttributeSetInstanceExtensionFieldId)(eventStoreAggregateId as EventStoreAggregateId).Id, (long)version);
		}

		public override Type GetSupportedStateEventType()
		{
			return typeof(AttributeSetInstanceExtensionFieldMvoStateEventBase);
		}

        [Transaction(ReadOnly = true)]
        public override EventStream LoadEventStream(Type eventType, IEventStoreAggregateId eventStoreAggregateId, long version)
        {
            Type supportedEventType = typeof(AttributeSetInstanceExtensionFieldMvoStateEventBase);
            if (!eventType.IsAssignableFrom(supportedEventType))
            {
                throw new NotSupportedException();
            }
            AttributeSetInstanceExtensionFieldId idObj = (AttributeSetInstanceExtensionFieldId)(eventStoreAggregateId as EventStoreAggregateId).Id;
            var criteria = CurrentSession.CreateCriteria<AttributeSetInstanceExtensionFieldMvoStateEventBase>();
            criteria.Add(Restrictions.Eq("StateEventId.AttributeSetInstanceExtensionFieldIdGroupId", idObj.GroupId));
            criteria.Add(Restrictions.Eq("StateEventId.AttributeSetInstanceExtensionFieldIdIndex", idObj.Index));
            criteria.Add(Restrictions.Le("StateEventId.AttrSetInstEFGroupVersion", version));
            criteria.AddOrder(Order.Asc("StateEventId.AttrSetInstEFGroupVersion"));
            var es = criteria.List<IEvent>();
            foreach (AttributeSetInstanceExtensionFieldMvoStateEventBase e in es)
            {
                e.StateEventReadOnly = true;
            }
            return new EventStream()
            {
                SteamVersion = es.Count > 0 ? ((AttributeSetInstanceExtensionFieldMvoStateEventBase)es.Last()).StateEventId.AttrSetInstEFGroupVersion : default(long),
                Events = es
            };
        }

	}

}

