package org.dddml.wms.domain.inventoryitemrequiremententrymvo.hibernate;

import java.io.Serializable;
import java.util.*;
import org.dddml.wms.domain.inventoryitemrequirement.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.inventoryitemrequiremententrymvo.*;

public class HibernateInventoryItemRequirementEntryMvoEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new InventoryItemRequirementEntryMvoStateEventId((InventoryItemRequirementEntryId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedStateEventType()
    {
        return AbstractInventoryItemRequirementEntryMvoStateEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractInventoryItemRequirementEntryMvoStateEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        InventoryItemRequirementEntryId idObj = (InventoryItemRequirementEntryId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractInventoryItemRequirementEntryMvoStateEvent.class);
        criteria.add(Restrictions.eq("stateEventId.inventoryItemRequirementEntryIdInventoryItemRequirementIdProductId", idObj.getInventoryItemRequirementIdProductId()));
        criteria.add(Restrictions.eq("stateEventId.inventoryItemRequirementEntryIdInventoryItemRequirementIdLocatorId", idObj.getInventoryItemRequirementIdLocatorId()));
        criteria.add(Restrictions.eq("stateEventId.inventoryItemRequirementEntryIdInventoryItemRequirementIdAttributeSetInstanceId", idObj.getInventoryItemRequirementIdAttributeSetInstanceId()));
        criteria.add(Restrictions.eq("stateEventId.inventoryItemRequirementEntryIdEntrySeqId", idObj.getEntrySeqId()));
        criteria.add(Restrictions.le("stateEventId.inventoryItemRequirementVersion", version));
        criteria.addOrder(Order.asc("stateEventId.inventoryItemRequirementVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractInventoryItemRequirementEntryMvoStateEvent) e).setStateEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractInventoryItemRequirementEntryMvoStateEvent) es.get(es.size() - 1)).getStateEventId().getInventoryItemRequirementVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

