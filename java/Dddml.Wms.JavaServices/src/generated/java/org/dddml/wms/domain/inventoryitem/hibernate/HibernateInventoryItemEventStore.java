package org.dddml.wms.domain.inventoryitem.hibernate;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.inventoryitem.*;

public class HibernateInventoryItemEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new InventoryItemEventId((InventoryItemId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedEventType()
    {
        return AbstractInventoryItemEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractInventoryItemEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        InventoryItemId idObj = (InventoryItemId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractInventoryItemEvent.class);
        criteria.add(Restrictions.eq("inventoryItemEventId.inventoryItemIdProductId", idObj.getProductId()));
        criteria.add(Restrictions.eq("inventoryItemEventId.inventoryItemIdLocatorId", idObj.getLocatorId()));
        criteria.add(Restrictions.eq("inventoryItemEventId.inventoryItemIdAttributeSetInstanceId", idObj.getAttributeSetInstanceId()));
        criteria.add(Restrictions.le("inventoryItemEventId.version", version));
        criteria.addOrder(Order.asc("inventoryItemEventId.version"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractInventoryItemEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractInventoryItemEvent) es.get(es.size() - 1)).getInventoryItemEventId().getVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

