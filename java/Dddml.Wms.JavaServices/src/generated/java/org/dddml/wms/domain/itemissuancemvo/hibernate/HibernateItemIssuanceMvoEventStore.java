package org.dddml.wms.domain.itemissuancemvo.hibernate;

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
import org.dddml.wms.domain.itemissuancemvo.*;

public class HibernateItemIssuanceMvoEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new ItemIssuanceMvoEventId((ShipmentItemIssuanceId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedStateEventType()
    {
        return AbstractItemIssuanceMvoStateEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractItemIssuanceMvoStateEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        ShipmentItemIssuanceId idObj = (ShipmentItemIssuanceId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractItemIssuanceMvoStateEvent.class);
        criteria.add(Restrictions.eq("itemIssuanceMvoEventId.shipmentItemIssuanceIdShipmentId", idObj.getShipmentId()));
        criteria.add(Restrictions.eq("itemIssuanceMvoEventId.shipmentItemIssuanceIdItemIssuanceSeqId", idObj.getItemIssuanceSeqId()));
        criteria.add(Restrictions.le("itemIssuanceMvoEventId.shipmentVersion", version));
        criteria.addOrder(Order.asc("itemIssuanceMvoEventId.shipmentVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractItemIssuanceMvoStateEvent) e).setStateEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractItemIssuanceMvoStateEvent) es.get(es.size() - 1)).getItemIssuanceMvoEventId().getShipmentVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

