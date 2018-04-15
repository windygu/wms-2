package org.dddml.wms.domain.attributevaluemvo.hibernate;

import java.io.Serializable;
import java.util.*;
import org.dddml.wms.domain.attribute.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.attributevaluemvo.*;

public class HibernateAttributeValueMvoEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new AttributeValueMvoEventId((AttributeValueId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedEventType()
    {
        return AbstractAttributeValueMvoEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractAttributeValueMvoEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        AttributeValueId idObj = (AttributeValueId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractAttributeValueMvoEvent.class);
        criteria.add(Restrictions.eq("attributeValueMvoEventId.attributeValueIdAttributeId", idObj.getAttributeId()));
        criteria.add(Restrictions.eq("attributeValueMvoEventId.attributeValueIdValue", idObj.getValue()));
        criteria.add(Restrictions.le("attributeValueMvoEventId.attributeVersion", version));
        criteria.addOrder(Order.asc("attributeValueMvoEventId.attributeVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractAttributeValueMvoEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractAttributeValueMvoEvent) es.get(es.size() - 1)).getAttributeValueMvoEventId().getAttributeVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

