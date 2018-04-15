package org.dddml.wms.domain.attributesetinstanceextensionfieldgroup.hibernate;

import java.io.Serializable;
import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.attributesetinstanceextensionfieldgroup.*;

public class HibernateAttributeSetInstanceExtensionFieldGroupEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new AttributeSetInstanceExtensionFieldGroupEventId((String) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedEventType()
    {
        return AbstractAttributeSetInstanceExtensionFieldGroupEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractAttributeSetInstanceExtensionFieldGroupEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        String idObj = (String) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractAttributeSetInstanceExtensionFieldGroupEvent.class);
        criteria.add(Restrictions.eq("attributeSetInstanceExtensionFieldGroupEventId.id", idObj));
        criteria.add(Restrictions.le("attributeSetInstanceExtensionFieldGroupEventId.version", version));
        criteria.addOrder(Order.asc("attributeSetInstanceExtensionFieldGroupEventId.version"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractAttributeSetInstanceExtensionFieldGroupEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractAttributeSetInstanceExtensionFieldGroupEvent) es.get(es.size() - 1)).getAttributeSetInstanceExtensionFieldGroupEventId().getVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

