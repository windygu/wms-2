package org.dddml.wms.domain.partyrole.hibernate;

import java.io.Serializable;
import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.partyrole.*;

public class HibernatePartyRoleEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new PartyRoleEventId((PartyRoleId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedStateEventType()
    {
        return AbstractPartyRoleStateEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractPartyRoleStateEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        PartyRoleId idObj = (PartyRoleId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractPartyRoleStateEvent.class);
        criteria.add(Restrictions.eq("partyRoleEventId.partyRoleIdPartyId", idObj.getPartyId()));
        criteria.add(Restrictions.eq("partyRoleEventId.partyRoleIdRoleTypeId", idObj.getRoleTypeId()));
        criteria.add(Restrictions.le("partyRoleEventId.version", version));
        criteria.addOrder(Order.asc("partyRoleEventId.version"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractPartyRoleStateEvent) e).setStateEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractPartyRoleStateEvent) es.get(es.size() - 1)).getPartyRoleEventId().getVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

