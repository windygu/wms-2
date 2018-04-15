package org.dddml.wms.domain.picklistrolemvo.hibernate;

import java.io.Serializable;
import java.util.*;
import org.dddml.wms.domain.picklist.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.picklistrolemvo.*;

public class HibernatePicklistRoleMvoEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new PicklistRoleMvoEventId((PicklistRoleId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedEventType()
    {
        return AbstractPicklistRoleMvoEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractPicklistRoleMvoEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        PicklistRoleId idObj = (PicklistRoleId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractPicklistRoleMvoEvent.class);
        criteria.add(Restrictions.eq("picklistRoleMvoEventId.picklistRoleIdPicklistId", idObj.getPicklistId()));
        criteria.add(Restrictions.eq("picklistRoleMvoEventId.picklistRoleIdPartyRoleIdPartyId", idObj.getPartyRoleId().getPartyId()));
        criteria.add(Restrictions.eq("picklistRoleMvoEventId.picklistRoleIdPartyRoleIdRoleTypeId", idObj.getPartyRoleId().getRoleTypeId()));
        criteria.add(Restrictions.le("picklistRoleMvoEventId.picklistVersion", version));
        criteria.addOrder(Order.asc("picklistRoleMvoEventId.picklistVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractPicklistRoleMvoEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractPicklistRoleMvoEvent) es.get(es.size() - 1)).getPicklistRoleMvoEventId().getPicklistVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

