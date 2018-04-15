package org.dddml.wms.domain.orderitemshipgrpinvreservation.hibernate;

import java.io.Serializable;
import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.orderitemshipgrpinvreservation.*;

public class HibernateOrderItemShipGrpInvReservationEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new OrderItemShipGrpInvReservationEventId((OrderItemShipGrpInvResId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedEventType()
    {
        return AbstractOrderItemShipGrpInvReservationEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractOrderItemShipGrpInvReservationEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        OrderItemShipGrpInvResId idObj = (OrderItemShipGrpInvResId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractOrderItemShipGrpInvReservationEvent.class);
        criteria.add(Restrictions.eq("orderItemShipGrpInvReservationEventId.orderItemShipGrpInvResIdOrderId", idObj.getOrderId()));
        criteria.add(Restrictions.eq("orderItemShipGrpInvReservationEventId.orderItemShipGrpInvResIdShipGroupSeqId", idObj.getShipGroupSeqId()));
        criteria.add(Restrictions.eq("orderItemShipGrpInvReservationEventId.orderItemShipGrpInvResIdOrderItemSeqId", idObj.getOrderItemSeqId()));
        criteria.add(Restrictions.eq("orderItemShipGrpInvReservationEventId.orderItemShipGrpInvResIdProductId", idObj.getProductId()));
        criteria.add(Restrictions.eq("orderItemShipGrpInvReservationEventId.orderItemShipGrpInvResIdLocatorId", idObj.getLocatorId()));
        criteria.add(Restrictions.eq("orderItemShipGrpInvReservationEventId.orderItemShipGrpInvResIdAttributeSetInstanceId", idObj.getAttributeSetInstanceId()));
        criteria.add(Restrictions.le("orderItemShipGrpInvReservationEventId.version", version));
        criteria.addOrder(Order.asc("orderItemShipGrpInvReservationEventId.version"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractOrderItemShipGrpInvReservationEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractOrderItemShipGrpInvReservationEvent) es.get(es.size() - 1)).getOrderItemShipGrpInvReservationEventId().getVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

