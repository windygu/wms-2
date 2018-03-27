package org.dddml.wms.domain.facility.hibernate;

import java.io.Serializable;
import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.facility.*;

public class HibernateFacilityEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new FacilityEventId((String) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedStateEventType()
    {
        return AbstractFacilityStateEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractFacilityStateEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        String idObj = (String) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractFacilityStateEvent.class);
        criteria.add(Restrictions.eq("facilityEventId.facilityId", idObj));
        criteria.add(Restrictions.le("facilityEventId.version", version));
        criteria.addOrder(Order.asc("facilityEventId.version"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractFacilityStateEvent) e).setStateEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractFacilityStateEvent) es.get(es.size() - 1)).getFacilityEventId().getVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

