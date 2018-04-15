package org.dddml.wms.domain.shipmentmethodtype.hibernate;

import java.io.Serializable;
import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.shipmentmethodtype.*;

public class HibernateShipmentMethodTypeEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new ShipmentMethodTypeEventId((String) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedEventType()
    {
        return AbstractShipmentMethodTypeEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractShipmentMethodTypeEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        String idObj = (String) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractShipmentMethodTypeEvent.class);
        criteria.add(Restrictions.eq("shipmentMethodTypeEventId.shipmentMethodTypeId", idObj));
        criteria.add(Restrictions.le("shipmentMethodTypeEventId.version", version));
        criteria.addOrder(Order.asc("shipmentMethodTypeEventId.version"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractShipmentMethodTypeEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractShipmentMethodTypeEvent) es.get(es.size() - 1)).getShipmentMethodTypeEventId().getVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

