package org.dddml.wms.domain.shipmentitemmvo.hibernate;

import java.io.Serializable;
import java.util.*;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.shipmentitemmvo.*;

public class HibernateShipmentItemMvoEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new ShipmentItemMvoEventId((ShipmentItemId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedStateEventType()
    {
        return AbstractShipmentItemMvoStateEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractShipmentItemMvoStateEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        ShipmentItemId idObj = (ShipmentItemId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractShipmentItemMvoStateEvent.class);
        criteria.add(Restrictions.eq("stateEventId.shipmentItemIdShipmentId", idObj.getShipmentId()));
        criteria.add(Restrictions.eq("stateEventId.shipmentItemIdShipmentItemSeqId", idObj.getShipmentItemSeqId()));
        criteria.add(Restrictions.le("stateEventId.shipmentVersion", version));
        criteria.addOrder(Order.asc("stateEventId.shipmentVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractShipmentItemMvoStateEvent) e).setStateEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractShipmentItemMvoStateEvent) es.get(es.size() - 1)).getStateEventId().getShipmentVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

