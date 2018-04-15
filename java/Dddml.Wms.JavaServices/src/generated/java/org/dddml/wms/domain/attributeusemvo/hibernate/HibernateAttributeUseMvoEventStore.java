package org.dddml.wms.domain.attributeusemvo.hibernate;

import java.io.Serializable;
import java.util.*;
import org.dddml.wms.domain.attributeset.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.attributeusemvo.*;

public class HibernateAttributeUseMvoEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new AttributeUseMvoEventId((AttributeSetAttributeUseId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedEventType()
    {
        return AbstractAttributeUseMvoEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractAttributeUseMvoEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        AttributeSetAttributeUseId idObj = (AttributeSetAttributeUseId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractAttributeUseMvoEvent.class);
        criteria.add(Restrictions.eq("attributeUseMvoEventId.attributeSetAttributeUseIdAttributeSetId", idObj.getAttributeSetId()));
        criteria.add(Restrictions.eq("attributeUseMvoEventId.attributeSetAttributeUseIdAttributeId", idObj.getAttributeId()));
        criteria.add(Restrictions.le("attributeUseMvoEventId.attributeSetVersion", version));
        criteria.addOrder(Order.asc("attributeUseMvoEventId.attributeSetVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractAttributeUseMvoEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractAttributeUseMvoEvent) es.get(es.size() - 1)).getAttributeUseMvoEventId().getAttributeSetVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

