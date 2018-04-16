using System;
using System.Collections.Generic;

namespace Dddml.Wms.Specialization
{
    public interface IEventStore
    {
        EventStream LoadEventStream(IEventStoreAggregateId eventStoreAggregateId);

        void AppendEvents(IEventStoreAggregateId eventStoreAggregateId, long version, ICollection<IEvent> events, Action afterEventsAppended);

        IEvent GetEvent(Type eventType, IEventStoreAggregateId eventStoreAggregateId, long version);

        IEvent GetEvent(IEventStoreAggregateId eventStoreAggregateId, long version);

        EventStream LoadEventStream(Type eventType, IEventStoreAggregateId eventStoreAggregateId, long version);

    }
}

