package org.dddml.wms.domain.organizationstructure.hibernate;

import java.io.Serializable;
import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.organizationstructure.*;

public class HibernateOrganizationStructureEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new OrganizationStructureEventId((OrganizationStructureId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedStateEventType()
    {
        return AbstractOrganizationStructureStateEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractOrganizationStructureStateEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        OrganizationStructureId idObj = (OrganizationStructureId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractOrganizationStructureStateEvent.class);
        criteria.add(Restrictions.eq("stateEventId.idOrganizationStructureTypeId", idObj.getOrganizationStructureTypeId()));
        criteria.add(Restrictions.eq("stateEventId.idParentId", idObj.getParentId()));
        criteria.add(Restrictions.eq("stateEventId.idSubsidiaryId", idObj.getSubsidiaryId()));
        criteria.add(Restrictions.le("stateEventId.version", version));
        criteria.addOrder(Order.asc("stateEventId.version"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractOrganizationStructureStateEvent) e).setStateEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractOrganizationStructureStateEvent) es.get(es.size() - 1)).getStateEventId().getVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

