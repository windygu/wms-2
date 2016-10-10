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

public class HibernateUserClaimMvoEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new UserClaimMvoStateEventId((UserClaimId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedStateEventType()
    {
        return AbstractUserClaimMvoStateEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractUserClaimMvoStateEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        UserClaimId idObj = (UserClaimId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractUserClaimMvoStateEvent.class);
        criteria.add(Restrictions.eq("stateEventId.userClaimIdUserId", idObj.getUserId()));
        criteria.add(Restrictions.eq("stateEventId.userClaimIdClaimId", idObj.getClaimId()));
        criteria.add(Restrictions.le("stateEventId.userVersion", version));
        criteria.addOrder(Order.asc("stateEventId.userVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractUserClaimMvoStateEvent) e).setStateEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractUserClaimMvoStateEvent) es.get(es.size() - 1)).getStateEventId().getUserVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

