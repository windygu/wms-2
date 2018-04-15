package org.dddml.wms.domain.inventoryitementrymvo.hibernate;

import java.io.Serializable;
import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.inventoryitementrymvo.*;

public class HibernateInventoryItemEntryMvoEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new InventoryItemEntryMvoEventId((InventoryItemEntryId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedEventType()
    {
        return AbstractInventoryItemEntryMvoEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractInventoryItemEntryMvoEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        InventoryItemEntryId idObj = (InventoryItemEntryId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractInventoryItemEntryMvoEvent.class);
        criteria.add(Restrictions.eq("inventoryItemEntryMvoEventId.inventoryItemEntryIdInventoryItemIdProductId", idObj.getInventoryItemId().getProductId()));
        criteria.add(Restrictions.eq("inventoryItemEntryMvoEventId.inventoryItemEntryIdInventoryItemIdLocatorId", idObj.getInventoryItemId().getLocatorId()));
        criteria.add(Restrictions.eq("inventoryItemEntryMvoEventId.inventoryItemEntryIdInventoryItemIdAttributeSetInstanceId", idObj.getInventoryItemId().getAttributeSetInstanceId()));
        criteria.add(Restrictions.eq("inventoryItemEntryMvoEventId.inventoryItemEntryIdEntrySeqId", idObj.getEntrySeqId()));
        criteria.add(Restrictions.le("inventoryItemEntryMvoEventId.inventoryItemVersion", version));
        criteria.addOrder(Order.asc("inventoryItemEntryMvoEventId.inventoryItemVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractInventoryItemEntryMvoEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractInventoryItemEntryMvoEvent) es.get(es.size() - 1)).getInventoryItemEntryMvoEventId().getInventoryItemVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

