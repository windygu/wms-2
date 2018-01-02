package org.dddml.wms.domain.shipmentreceiptmvo.hibernate;

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
import org.dddml.wms.domain.shipmentreceiptmvo.*;

public class HibernateShipmentReceiptMvoEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new ShipmentReceiptMvoStateEventId((ShipmentReceiptId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedStateEventType()
    {
        return AbstractShipmentReceiptMvoStateEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractShipmentReceiptMvoStateEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        ShipmentReceiptId idObj = (ShipmentReceiptId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractShipmentReceiptMvoStateEvent.class);
        criteria.add(Restrictions.eq("stateEventId.shipmentReceiptIdShipmentId", idObj.getShipmentId()));
        criteria.add(Restrictions.eq("stateEventId.shipmentReceiptIdReceiptSeqId", idObj.getReceiptSeqId()));
        criteria.add(Restrictions.le("stateEventId.shipmentVersion", version));
        criteria.addOrder(Order.asc("stateEventId.shipmentVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractShipmentReceiptMvoStateEvent) e).setStateEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractShipmentReceiptMvoStateEvent) es.get(es.size() - 1)).getStateEventId().getShipmentVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

