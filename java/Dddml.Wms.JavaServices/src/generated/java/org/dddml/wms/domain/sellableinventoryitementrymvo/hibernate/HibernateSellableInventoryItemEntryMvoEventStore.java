package org.dddml.wms.domain.sellableinventoryitementrymvo.hibernate;

import java.io.Serializable;
import java.util.*;
import org.dddml.wms.domain.sellableinventoryitem.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.sellableinventoryitementrymvo.*;

public class HibernateSellableInventoryItemEntryMvoEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new SellableInventoryItemEntryMvoEventId((SellableInventoryItemEntryId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedStateEventType()
    {
        return AbstractSellableInventoryItemEntryMvoStateEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractSellableInventoryItemEntryMvoStateEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        SellableInventoryItemEntryId idObj = (SellableInventoryItemEntryId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractSellableInventoryItemEntryMvoStateEvent.class);
        criteria.add(Restrictions.eq("stateEventId.sellableInventoryItemEntryIdSellableInventoryItemIdProductId", idObj.getSellableInventoryItemId().getProductId()));
        criteria.add(Restrictions.eq("stateEventId.sellableInventoryItemEntryIdSellableInventoryItemIdLocatorId", idObj.getSellableInventoryItemId().getLocatorId()));
        criteria.add(Restrictions.eq("stateEventId.sellableInventoryItemEntryIdSellableInventoryItemIdAttributeSetInstanceId", idObj.getSellableInventoryItemId().getAttributeSetInstanceId()));
        criteria.add(Restrictions.eq("stateEventId.sellableInventoryItemEntryIdEntrySeqId", idObj.getEntrySeqId()));
        criteria.add(Restrictions.le("stateEventId.sellableInventoryItemVersion", version));
        criteria.addOrder(Order.asc("stateEventId.sellableInventoryItemVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractSellableInventoryItemEntryMvoStateEvent) e).setStateEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractSellableInventoryItemEntryMvoStateEvent) es.get(es.size() - 1)).getStateEventId().getSellableInventoryItemVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

