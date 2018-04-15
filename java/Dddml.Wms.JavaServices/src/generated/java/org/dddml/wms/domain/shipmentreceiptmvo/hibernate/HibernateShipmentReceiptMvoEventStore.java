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
        return new ShipmentReceiptMvoEventId((ShipmentReceiptId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedEventType()
    {
        return AbstractShipmentReceiptMvoEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractShipmentReceiptMvoEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        ShipmentReceiptId idObj = (ShipmentReceiptId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractShipmentReceiptMvoEvent.class);
        criteria.add(Restrictions.eq("shipmentReceiptMvoEventId.shipmentReceiptIdShipmentId", idObj.getShipmentId()));
        criteria.add(Restrictions.eq("shipmentReceiptMvoEventId.shipmentReceiptIdReceiptSeqId", idObj.getReceiptSeqId()));
        criteria.add(Restrictions.le("shipmentReceiptMvoEventId.shipmentVersion", version));
        criteria.addOrder(Order.asc("shipmentReceiptMvoEventId.shipmentVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractShipmentReceiptMvoEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractShipmentReceiptMvoEvent) es.get(es.size() - 1)).getShipmentReceiptMvoEventId().getShipmentVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

