package org.dddml.wms.domain.hibernate;

import java.io.Serializable;
import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.*;

public class HibernateAttributeUseMvoEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new AttributeUseMvoStateEventId((AttributeSetAttributeUseId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedStateEventType()
    {
        return AbstractAttributeUseMvoStateEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractAttributeUseMvoStateEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        AttributeSetAttributeUseId idObj = (AttributeSetAttributeUseId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractAttributeUseMvoStateEvent.class);
        criteria.add(Restrictions.eq("stateEventId.attributeSetAttributeUseIdAttributeSetId", idObj.getAttributeSetId()));
        criteria.add(Restrictions.eq("stateEventId.attributeSetAttributeUseIdAttributeId", idObj.getAttributeId()));
        criteria.add(Restrictions.le("stateEventId.attributeSetVersion", version));
        criteria.addOrder(Order.asc("stateEventId.attributeSetVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractAttributeUseMvoStateEvent) e).setStateEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractAttributeUseMvoStateEvent) es.get(es.size() - 1)).getStateEventId().getAttributeSetVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

