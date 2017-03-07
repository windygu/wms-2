package org.dddml.wms.domain.attributesetinstanceextensionfieldmvo.hibernate;

import java.io.Serializable;
import java.util.*;
import org.dddml.wms.domain.attributesetinstanceextensionfieldgroup.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.attributesetinstanceextensionfieldmvo.*;

public class HibernateAttributeSetInstanceExtensionFieldMvoEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new AttributeSetInstanceExtensionFieldMvoStateEventId((AttributeSetInstanceExtensionFieldId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedStateEventType()
    {
        return AbstractAttributeSetInstanceExtensionFieldMvoStateEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractAttributeSetInstanceExtensionFieldMvoStateEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        AttributeSetInstanceExtensionFieldId idObj = (AttributeSetInstanceExtensionFieldId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractAttributeSetInstanceExtensionFieldMvoStateEvent.class);
        criteria.add(Restrictions.eq("stateEventId.attributeSetInstanceExtensionFieldIdGroupId", idObj.getGroupId()));
        criteria.add(Restrictions.eq("stateEventId.attributeSetInstanceExtensionFieldIdIndex", idObj.getIndex()));
        criteria.add(Restrictions.le("stateEventId.attrSetInstEFGroupVersion", version));
        criteria.addOrder(Order.asc("stateEventId.attrSetInstEFGroupVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractAttributeSetInstanceExtensionFieldMvoStateEvent) e).setStateEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractAttributeSetInstanceExtensionFieldMvoStateEvent) es.get(es.size() - 1)).getStateEventId().getAttrSetInstEFGroupVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

