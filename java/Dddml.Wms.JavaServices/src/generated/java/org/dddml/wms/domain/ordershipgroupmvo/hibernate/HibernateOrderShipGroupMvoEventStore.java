package org.dddml.wms.domain.ordershipgroupmvo.hibernate;

import java.io.Serializable;
import java.util.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.ordershipgroupmvo.*;

public class HibernateOrderShipGroupMvoEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new OrderShipGroupMvoEventId((OrderShipGroupId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedStateEventType()
    {
        return AbstractOrderShipGroupMvoStateEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractOrderShipGroupMvoStateEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        OrderShipGroupId idObj = (OrderShipGroupId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractOrderShipGroupMvoStateEvent.class);
        criteria.add(Restrictions.eq("orderShipGroupMvoEventId.orderShipGroupIdOrderId", idObj.getOrderId()));
        criteria.add(Restrictions.eq("orderShipGroupMvoEventId.orderShipGroupIdShipGroupSeqId", idObj.getShipGroupSeqId()));
        criteria.add(Restrictions.le("orderShipGroupMvoEventId.orderVersion", version));
        criteria.addOrder(Order.asc("orderShipGroupMvoEventId.orderVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractOrderShipGroupMvoStateEvent) e).setStateEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractOrderShipGroupMvoStateEvent) es.get(es.size() - 1)).getOrderShipGroupMvoEventId().getOrderVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

