package org.dddml.wms.domain.hibernate;

import java.io.Serializable;
import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.*;

public class HibernateUserRoleMvoEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new UserRoleMvoStateEventId((UserRoleId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedStateEventType()
    {
        return AbstractUserRoleMvoStateEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractUserRoleMvoStateEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        UserRoleId idObj = (UserRoleId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractUserRoleMvoStateEvent.class);
        criteria.add(Restrictions.eq("stateEventId.userRoleIdUserId", idObj.getUserId()));
        criteria.add(Restrictions.eq("stateEventId.userRoleIdRoleId", idObj.getRoleId()));
        criteria.add(Restrictions.le("stateEventId.userVersion", version));
        criteria.addOrder(Order.asc("stateEventId.userVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractUserRoleMvoStateEvent) e).setStateEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractUserRoleMvoStateEvent) es.get(es.size() - 1)).getStateEventId().getUserVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

