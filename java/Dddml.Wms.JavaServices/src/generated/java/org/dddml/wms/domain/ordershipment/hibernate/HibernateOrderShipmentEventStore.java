package org.dddml.wms.domain.ordershipment.hibernate;

import java.io.Serializable;
import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.ordershipment.*;

public class HibernateOrderShipmentEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new OrderShipmentEventId((OrderShipmentId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedEventType()
    {
        return AbstractOrderShipmentEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractOrderShipmentEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        OrderShipmentId idObj = (OrderShipmentId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractOrderShipmentEvent.class);
        criteria.add(Restrictions.eq("orderShipmentEventId.orderShipmentIdOrderId", idObj.getOrderId()));
        criteria.add(Restrictions.eq("orderShipmentEventId.orderShipmentIdOrderItemSeqId", idObj.getOrderItemSeqId()));
        criteria.add(Restrictions.eq("orderShipmentEventId.orderShipmentIdShipGroupSeqId", idObj.getShipGroupSeqId()));
        criteria.add(Restrictions.eq("orderShipmentEventId.orderShipmentIdShipmentId", idObj.getShipmentId()));
        criteria.add(Restrictions.eq("orderShipmentEventId.orderShipmentIdShipmentItemSeqId", idObj.getShipmentItemSeqId()));
        criteria.add(Restrictions.le("orderShipmentEventId.version", version));
        criteria.addOrder(Order.asc("orderShipmentEventId.version"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractOrderShipmentEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractOrderShipmentEvent) es.get(es.size() - 1)).getOrderShipmentEventId().getVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

