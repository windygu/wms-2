package org.dddml.wms.domain.orderitemmvo.hibernate;

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
import org.dddml.wms.domain.orderitemmvo.*;

public class HibernateOrderItemMvoEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new OrderItemMvoEventId((OrderItemId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedEventType()
    {
        return AbstractOrderItemMvoEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractOrderItemMvoEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        OrderItemId idObj = (OrderItemId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractOrderItemMvoEvent.class);
        criteria.add(Restrictions.eq("orderItemMvoEventId.orderItemIdOrderId", idObj.getOrderId()));
        criteria.add(Restrictions.eq("orderItemMvoEventId.orderItemIdOrderItemSeqId", idObj.getOrderItemSeqId()));
        criteria.add(Restrictions.le("orderItemMvoEventId.orderVersion", version));
        criteria.addOrder(Order.asc("orderItemMvoEventId.orderVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractOrderItemMvoEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractOrderItemMvoEvent) es.get(es.size() - 1)).getOrderItemMvoEventId().getOrderVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

