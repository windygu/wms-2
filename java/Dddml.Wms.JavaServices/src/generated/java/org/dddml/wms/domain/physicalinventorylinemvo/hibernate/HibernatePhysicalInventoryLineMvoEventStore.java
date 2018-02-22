package org.dddml.wms.domain.physicalinventorylinemvo.hibernate;

import java.io.Serializable;
import java.util.*;
import org.dddml.wms.domain.physicalinventory.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.physicalinventorylinemvo.*;

public class HibernatePhysicalInventoryLineMvoEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new PhysicalInventoryLineMvoStateEventId((PhysicalInventoryLineId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedStateEventType()
    {
        return AbstractPhysicalInventoryLineMvoStateEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractPhysicalInventoryLineMvoStateEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        PhysicalInventoryLineId idObj = (PhysicalInventoryLineId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractPhysicalInventoryLineMvoStateEvent.class);
        criteria.add(Restrictions.eq("stateEventId.physicalInventoryLineIdPhysicalInventoryDocumentNumber", idObj.getPhysicalInventoryDocumentNumber()));
        criteria.add(Restrictions.eq("stateEventId.physicalInventoryLineIdInventoryItemIdProductId", idObj.getInventoryItemIdProductId()));
        criteria.add(Restrictions.eq("stateEventId.physicalInventoryLineIdInventoryItemIdLocatorId", idObj.getInventoryItemIdLocatorId()));
        criteria.add(Restrictions.eq("stateEventId.physicalInventoryLineIdInventoryItemIdAttributeSetInstanceId", idObj.getInventoryItemIdAttributeSetInstanceId()));
        criteria.add(Restrictions.le("stateEventId.physicalInventoryVersion", version));
        criteria.addOrder(Order.asc("stateEventId.physicalInventoryVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractPhysicalInventoryLineMvoStateEvent) e).setStateEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractPhysicalInventoryLineMvoStateEvent) es.get(es.size() - 1)).getStateEventId().getPhysicalInventoryVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

