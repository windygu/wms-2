package org.dddml.wms.domain.inventorypostingrule.hibernate;

import java.io.Serializable;
import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.inventorypostingrule.*;

public class HibernateInventoryPostingRuleEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new InventoryPostingRuleEventId((String) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedEventType()
    {
        return AbstractInventoryPostingRuleEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractInventoryPostingRuleEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        String idObj = (String) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractInventoryPostingRuleEvent.class);
        criteria.add(Restrictions.eq("inventoryPostingRuleEventId.inventoryPostingRuleId", idObj));
        criteria.add(Restrictions.le("inventoryPostingRuleEventId.version", version));
        criteria.addOrder(Order.asc("inventoryPostingRuleEventId.version"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractInventoryPostingRuleEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractInventoryPostingRuleEvent) es.get(es.size() - 1)).getInventoryPostingRuleEventId().getVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

