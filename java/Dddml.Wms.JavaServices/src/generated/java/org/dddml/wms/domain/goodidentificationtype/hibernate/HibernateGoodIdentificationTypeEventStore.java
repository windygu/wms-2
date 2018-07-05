package org.dddml.wms.domain.goodidentificationtype.hibernate;

import java.io.Serializable;
import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.goodidentificationtype.*;

public class HibernateGoodIdentificationTypeEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new GoodIdentificationTypeEventId((String) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedEventType()
    {
        return AbstractGoodIdentificationTypeEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractGoodIdentificationTypeEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        String idObj = (String) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractGoodIdentificationTypeEvent.class);
        criteria.add(Restrictions.eq("goodIdentificationTypeEventId.goodIdentificationTypeId", idObj));
        criteria.add(Restrictions.le("goodIdentificationTypeEventId.version", version));
        criteria.addOrder(Order.asc("goodIdentificationTypeEventId.version"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractGoodIdentificationTypeEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractGoodIdentificationTypeEvent) es.get(es.size() - 1)).getGoodIdentificationTypeEventId().getVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

