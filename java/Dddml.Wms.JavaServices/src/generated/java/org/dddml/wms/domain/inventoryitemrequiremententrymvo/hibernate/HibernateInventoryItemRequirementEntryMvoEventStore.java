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
        return new InventoryItemRequirementEntryMvoEventId((InventoryItemRequirementEntryId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedEventType()
    {
        return AbstractInventoryItemRequirementEntryMvoEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractInventoryItemRequirementEntryMvoEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        InventoryItemRequirementEntryId idObj = (InventoryItemRequirementEntryId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractInventoryItemRequirementEntryMvoEvent.class);
        criteria.add(Restrictions.eq("inventoryItemRequirementEntryMvoEventId.inventoryItemRequirementEntryIdInventoryItemRequirementIdProductId", idObj.getInventoryItemRequirementId().getProductId()));
        criteria.add(Restrictions.eq("inventoryItemRequirementEntryMvoEventId.inventoryItemRequirementEntryIdInventoryItemRequirementIdLocatorId", idObj.getInventoryItemRequirementId().getLocatorId()));
        criteria.add(Restrictions.eq("inventoryItemRequirementEntryMvoEventId.inventoryItemRequirementEntryIdInventoryItemRequirementIdAttributeSetInstanceId", idObj.getInventoryItemRequirementId().getAttributeSetInstanceId()));
        criteria.add(Restrictions.eq("inventoryItemRequirementEntryMvoEventId.inventoryItemRequirementEntryIdEntrySeqId", idObj.getEntrySeqId()));
        criteria.add(Restrictions.le("inventoryItemRequirementEntryMvoEventId.inventoryItemRequirementVersion", version));
        criteria.addOrder(Order.asc("inventoryItemRequirementEntryMvoEventId.inventoryItemRequirementVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractInventoryItemRequirementEntryMvoEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractInventoryItemRequirementEntryMvoEvent) es.get(es.size() - 1)).getInventoryItemRequirementEntryMvoEventId().getInventoryItemRequirementVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

