package org.dddml.wms.domain.shipmentpackagecontentmvo.hibernate;

import java.io.Serializable;
import java.util.*;
import org.dddml.wms.domain.shipmentpackage.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.shipmentpackagecontentmvo.*;

public class HibernateShipmentPackageContentMvoEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new ShipmentPackageContentMvoEventId((ShipmentPackageContentId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedEventType()
    {
        return AbstractShipmentPackageContentMvoEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractShipmentPackageContentMvoEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        ShipmentPackageContentId idObj = (ShipmentPackageContentId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractShipmentPackageContentMvoEvent.class);
        criteria.add(Restrictions.eq("shipmentPackageContentMvoEventId.shipmentPackageContentIdShipmentPackageIdShipmentId", idObj.getShipmentPackageId().getShipmentId()));
        criteria.add(Restrictions.eq("shipmentPackageContentMvoEventId.shipmentPackageContentIdShipmentPackageIdShipmentPackageSeqId", idObj.getShipmentPackageId().getShipmentPackageSeqId()));
        criteria.add(Restrictions.eq("shipmentPackageContentMvoEventId.shipmentPackageContentIdShipmentItemSeqId", idObj.getShipmentItemSeqId()));
        criteria.add(Restrictions.le("shipmentPackageContentMvoEventId.shipmentPackageVersion", version));
        criteria.addOrder(Order.asc("shipmentPackageContentMvoEventId.shipmentPackageVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractShipmentPackageContentMvoEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractShipmentPackageContentMvoEvent) es.get(es.size() - 1)).getShipmentPackageContentMvoEventId().getShipmentPackageVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

