package org.dddml.wms.domain.uomconversion.hibernate;

import java.io.Serializable;
import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.uomconversion.*;

public class HibernateUomConversionEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new UomConversionEventId((UomConversionId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedStateEventType()
    {
        return AbstractUomConversionStateEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractUomConversionStateEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        UomConversionId idObj = (UomConversionId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractUomConversionStateEvent.class);
        criteria.add(Restrictions.eq("uomConversionEventId.uomConversionIdUomId", idObj.getUomId()));
        criteria.add(Restrictions.eq("uomConversionEventId.uomConversionIdUomIdTo", idObj.getUomIdTo()));
        criteria.add(Restrictions.le("uomConversionEventId.version", version));
        criteria.addOrder(Order.asc("uomConversionEventId.version"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractUomConversionStateEvent) e).setStateEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractUomConversionStateEvent) es.get(es.size() - 1)).getUomConversionEventId().getVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

