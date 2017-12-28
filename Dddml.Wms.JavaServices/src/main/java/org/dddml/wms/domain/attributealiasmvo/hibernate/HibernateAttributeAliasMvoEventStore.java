package org.dddml.wms.domain.attributealiasmvo.hibernate;

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
import org.dddml.wms.domain.attributealiasmvo.*;

public class HibernateAttributeAliasMvoEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new AttributeAliasMvoStateEventId((AttributeAliasId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedStateEventType()
    {
        return AbstractAttributeAliasMvoStateEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractAttributeAliasMvoStateEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        AttributeAliasId idObj = (AttributeAliasId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractAttributeAliasMvoStateEvent.class);
        criteria.add(Restrictions.eq("stateEventId.attributeAliasIdAttributeId", idObj.getAttributeId()));
        criteria.add(Restrictions.eq("stateEventId.attributeAliasIdCode", idObj.getCode()));
        criteria.add(Restrictions.le("stateEventId.attributeVersion", version));
        criteria.addOrder(Order.asc("stateEventId.attributeVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractAttributeAliasMvoStateEvent) e).setStateEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractAttributeAliasMvoStateEvent) es.get(es.size() - 1)).getStateEventId().getAttributeVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

