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
    protected Class getSupportedStateEventType()
    {
        return AbstractOrderShipmentStateEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractOrderShipmentStateEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        OrderShipmentId idObj = (OrderShipmentId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractOrderShipmentStateEvent.class);
        criteria.add(Restrictions.eq("stateEventId.orderShipmentIdOrderId", idObj.getOrderId()));
        criteria.add(Restrictions.eq("stateEventId.orderShipmentIdOrderItemSeqId", idObj.getOrderItemSeqId()));
        criteria.add(Restrictions.eq("stateEventId.orderShipmentIdShipmentId", idObj.getShipmentId()));
        criteria.add(Restrictions.eq("stateEventId.orderShipmentIdShipmentItemSeqId", idObj.getShipmentItemSeqId()));
        criteria.add(Restrictions.le("stateEventId.version", version));
        criteria.addOrder(Order.asc("stateEventId.version"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractOrderShipmentStateEvent) e).setStateEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractOrderShipmentStateEvent) es.get(es.size() - 1)).getStateEventId().getVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

