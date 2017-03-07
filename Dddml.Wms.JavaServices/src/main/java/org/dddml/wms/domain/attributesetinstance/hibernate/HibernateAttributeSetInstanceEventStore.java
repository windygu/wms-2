package org.dddml.wms.domain.attributesetinstance.hibernate;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.attributesetinstance.*;

public class HibernateAttributeSetInstanceEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new AttributeSetInstanceStateEventId((String) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedStateEventType()
    {
        return AbstractAttributeSetInstanceStateEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractAttributeSetInstanceStateEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        String idObj = (String) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractAttributeSetInstanceStateEvent.class);
        criteria.add(Restrictions.eq("stateEventId.attributeSetInstanceId", idObj));
        criteria.add(Restrictions.le("stateEventId.version", version));
        criteria.addOrder(Order.asc("stateEventId.version"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractAttributeSetInstanceStateEvent) e).setStateEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractAttributeSetInstanceStateEvent) es.get(es.size() - 1)).getStateEventId().getVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

