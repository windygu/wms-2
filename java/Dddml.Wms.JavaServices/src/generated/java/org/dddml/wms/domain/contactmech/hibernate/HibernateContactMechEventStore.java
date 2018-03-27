package org.dddml.wms.domain.contactmech.hibernate;

import java.io.Serializable;
import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.contactmech.*;

public class HibernateContactMechEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new ContactMechEventId((String) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedStateEventType()
    {
        return AbstractContactMechStateEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractContactMechStateEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        String idObj = (String) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractContactMechStateEvent.class);
        criteria.add(Restrictions.eq("contactMechEventId.contactMechId", idObj));
        criteria.add(Restrictions.le("contactMechEventId.version", version));
        criteria.addOrder(Order.asc("contactMechEventId.version"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractContactMechStateEvent) e).setStateEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractContactMechStateEvent) es.get(es.size() - 1)).getContactMechEventId().getVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

