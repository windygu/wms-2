package org.dddml.wms.domain.organizationstructuretype.hibernate;

import java.io.Serializable;
import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.organizationstructuretype.*;

public class HibernateOrganizationStructureTypeEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new OrganizationStructureTypeEventId((String) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedEventType()
    {
        return AbstractOrganizationStructureTypeEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractOrganizationStructureTypeEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        String idObj = (String) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractOrganizationStructureTypeEvent.class);
        criteria.add(Restrictions.eq("organizationStructureTypeEventId.id", idObj));
        criteria.add(Restrictions.le("organizationStructureTypeEventId.version", version));
        criteria.addOrder(Order.asc("organizationStructureTypeEventId.version"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractOrganizationStructureTypeEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractOrganizationStructureTypeEvent) es.get(es.size() - 1)).getOrganizationStructureTypeEventId().getVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

