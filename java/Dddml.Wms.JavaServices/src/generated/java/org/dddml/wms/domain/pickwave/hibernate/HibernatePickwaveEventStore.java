package org.dddml.wms.domain.pickwave.hibernate;

import java.io.Serializable;
import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.pickwave.*;

public class HibernatePickwaveEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new PickwaveEventId((Long) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedEventType()
    {
        return AbstractPickwaveEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractPickwaveEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        Long idObj = (Long) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractPickwaveEvent.class);
        criteria.add(Restrictions.eq("pickwaveEventId.pickwaveId", idObj));
        criteria.add(Restrictions.le("pickwaveEventId.version", version));
        criteria.addOrder(Order.asc("pickwaveEventId.version"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractPickwaveEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractPickwaveEvent) es.get(es.size() - 1)).getPickwaveEventId().getVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

