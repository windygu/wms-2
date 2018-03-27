package org.dddml.wms.domain.shipmentpackage.hibernate;

import java.io.Serializable;
import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.shipmentpackage.*;

public class HibernateShipmentPackageEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new ShipmentPackageEventId((ShipmentPackageId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedStateEventType()
    {
        return AbstractShipmentPackageStateEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractShipmentPackageStateEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        ShipmentPackageId idObj = (ShipmentPackageId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractShipmentPackageStateEvent.class);
        criteria.add(Restrictions.eq("shipmentPackageEventId.shipmentPackageIdShipmentId", idObj.getShipmentId()));
        criteria.add(Restrictions.eq("shipmentPackageEventId.shipmentPackageIdShipmentPackageSeqId", idObj.getShipmentPackageSeqId()));
        criteria.add(Restrictions.le("shipmentPackageEventId.version", version));
        criteria.addOrder(Order.asc("shipmentPackageEventId.version"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractShipmentPackageStateEvent) e).setStateEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractShipmentPackageStateEvent) es.get(es.size() - 1)).getShipmentPackageEventId().getVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

