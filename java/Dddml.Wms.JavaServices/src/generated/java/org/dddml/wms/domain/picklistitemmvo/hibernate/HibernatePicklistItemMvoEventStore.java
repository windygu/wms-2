package org.dddml.wms.domain.picklistitemmvo.hibernate;

import java.io.Serializable;
import java.util.*;
import org.dddml.wms.domain.picklistbin.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.picklistitemmvo.*;

public class HibernatePicklistItemMvoEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new PicklistItemMvoEventId((PicklistBinPicklistItemId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedEventType()
    {
        return AbstractPicklistItemMvoEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractPicklistItemMvoEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        PicklistBinPicklistItemId idObj = (PicklistBinPicklistItemId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractPicklistItemMvoEvent.class);
        criteria.add(Restrictions.eq("picklistItemMvoEventId.picklistBinPicklistItemIdPicklistBinId", idObj.getPicklistBinId()));
        criteria.add(Restrictions.eq("picklistItemMvoEventId.picklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdOrderId", idObj.getPicklistItemOrderShipGrpInvId().getOrderId()));
        criteria.add(Restrictions.eq("picklistItemMvoEventId.picklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdOrderItemSeqId", idObj.getPicklistItemOrderShipGrpInvId().getOrderItemSeqId()));
        criteria.add(Restrictions.eq("picklistItemMvoEventId.picklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdShipGroupSeqId", idObj.getPicklistItemOrderShipGrpInvId().getShipGroupSeqId()));
        criteria.add(Restrictions.eq("picklistItemMvoEventId.picklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdProductId", idObj.getPicklistItemOrderShipGrpInvId().getProductId()));
        criteria.add(Restrictions.eq("picklistItemMvoEventId.picklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdLocatorId", idObj.getPicklistItemOrderShipGrpInvId().getLocatorId()));
        criteria.add(Restrictions.eq("picklistItemMvoEventId.picklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdAttributeSetInstanceId", idObj.getPicklistItemOrderShipGrpInvId().getAttributeSetInstanceId()));
        criteria.add(Restrictions.le("picklistItemMvoEventId.picklistBinVersion", version));
        criteria.addOrder(Order.asc("picklistItemMvoEventId.picklistBinVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractPicklistItemMvoEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractPicklistItemMvoEvent) es.get(es.size() - 1)).getPicklistItemMvoEventId().getPicklistBinVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

