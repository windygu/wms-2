package org.dddml.wms.domain.orderitemshipgroupassociationmvo.hibernate;

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
import org.dddml.wms.domain.orderitemshipgroupassociationmvo.*;

public class HibernateOrderItemShipGroupAssociationMvoEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new OrderItemShipGroupAssociationMvoEventId((OrderItemShipGroupAssociationId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedEventType()
    {
        return AbstractOrderItemShipGroupAssociationMvoEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractOrderItemShipGroupAssociationMvoEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        OrderItemShipGroupAssociationId idObj = (OrderItemShipGroupAssociationId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractOrderItemShipGroupAssociationMvoEvent.class);
        criteria.add(Restrictions.eq("orderItemShipGroupAssociationMvoEventId.orderItemShipGroupAssociationIdOrderId", idObj.getOrderId()));
        criteria.add(Restrictions.eq("orderItemShipGroupAssociationMvoEventId.orderItemShipGroupAssociationIdOrderShipGroupShipGroupSeqId", idObj.getOrderShipGroupShipGroupSeqId()));
        criteria.add(Restrictions.eq("orderItemShipGroupAssociationMvoEventId.orderItemShipGroupAssociationIdOrderItemSeqId", idObj.getOrderItemSeqId()));
        criteria.add(Restrictions.le("orderItemShipGroupAssociationMvoEventId.orderVersion", version));
        criteria.addOrder(Order.asc("orderItemShipGroupAssociationMvoEventId.orderVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractOrderItemShipGroupAssociationMvoEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractOrderItemShipGroupAssociationMvoEvent) es.get(es.size() - 1)).getOrderItemShipGroupAssociationMvoEventId().getOrderVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

