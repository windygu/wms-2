package org.dddml.wms.domain.hibernate;

import java.io.Serializable;
import java.util.Date;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.*;

public class HibernateOrganizationStructureEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new OrganizationStructureStateEventId((OrganizationStructureId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedStateEventType()
    {
        return AbstractOrganizationStructureStateEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        return null;//todo
    }

}

