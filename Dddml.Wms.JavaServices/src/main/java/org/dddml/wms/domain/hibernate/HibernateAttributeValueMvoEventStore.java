package org.dddml.wms.domain.hibernate;

import java.io.Serializable;
import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.*;

public class HibernateAttributeValueMvoEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new AttributeValueMvoStateEventId((AttributeValueId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedStateEventType()
    {
        return AbstractAttributeValueMvoStateEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractAttributeValueMvoStateEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        AttributeValueId idObj = (AttributeValueId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractAttributeValueMvoStateEvent.class);
        criteria.add(Restrictions.eq("stateEventId.attributeValueIdAttributeId", idObj.getAttributeId()));
        criteria.add(Restrictions.eq("stateEventId.attributeValueIdValue", idObj.getValue()));
        criteria.add(Restrictions.le("stateEventId.attributeVersion", version));
        criteria.addOrder(Order.asc("stateEventId.attributeVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractAttributeValueMvoStateEvent) e).setStateEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractAttributeValueMvoStateEvent) es.get(es.size() - 1)).getStateEventId().getAttributeVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

