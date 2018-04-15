package org.dddml.wms.domain.physicalinventory.hibernate;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.physicalinventory.*;

public class HibernatePhysicalInventoryEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new PhysicalInventoryEventId((String) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedEventType()
    {
        return AbstractPhysicalInventoryEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractPhysicalInventoryEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        String idObj = (String) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractPhysicalInventoryEvent.class);
        criteria.add(Restrictions.eq("physicalInventoryEventId.documentNumber", idObj));
        criteria.add(Restrictions.le("physicalInventoryEventId.version", version));
        criteria.addOrder(Order.asc("physicalInventoryEventId.version"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractPhysicalInventoryEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractPhysicalInventoryEvent) es.get(es.size() - 1)).getPhysicalInventoryEventId().getVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

