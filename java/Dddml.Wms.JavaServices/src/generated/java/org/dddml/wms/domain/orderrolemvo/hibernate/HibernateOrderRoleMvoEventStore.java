package org.dddml.wms.domain.orderrolemvo.hibernate;

import java.io.Serializable;
import java.util.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.orderrolemvo.*;

public class HibernateOrderRoleMvoEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new OrderRoleMvoEventId((OrderRoleId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedEventType()
    {
        return AbstractOrderRoleMvoEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractOrderRoleMvoEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        OrderRoleId idObj = (OrderRoleId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractOrderRoleMvoEvent.class);
        criteria.add(Restrictions.eq("orderRoleMvoEventId.orderRoleIdOrderId", idObj.getOrderId()));
        criteria.add(Restrictions.eq("orderRoleMvoEventId.orderRoleIdPartyRoleIdPartyId", idObj.getPartyRoleId().getPartyId()));
        criteria.add(Restrictions.eq("orderRoleMvoEventId.orderRoleIdPartyRoleIdRoleTypeId", idObj.getPartyRoleId().getRoleTypeId()));
        criteria.add(Restrictions.le("orderRoleMvoEventId.orderVersion", version));
        criteria.addOrder(Order.asc("orderRoleMvoEventId.orderVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractOrderRoleMvoEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractOrderRoleMvoEvent) es.get(es.size() - 1)).getOrderRoleMvoEventId().getOrderVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

