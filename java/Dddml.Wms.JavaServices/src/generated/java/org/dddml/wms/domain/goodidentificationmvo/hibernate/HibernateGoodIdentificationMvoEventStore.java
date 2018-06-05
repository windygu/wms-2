package org.dddml.wms.domain.goodidentificationmvo.hibernate;

import java.io.Serializable;
import java.util.*;
import org.dddml.wms.domain.product.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.goodidentificationmvo.*;

public class HibernateGoodIdentificationMvoEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new GoodIdentificationMvoEventId((ProductGoodIdentificationId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedEventType()
    {
        return AbstractGoodIdentificationMvoEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractGoodIdentificationMvoEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        ProductGoodIdentificationId idObj = (ProductGoodIdentificationId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractGoodIdentificationMvoEvent.class);
        criteria.add(Restrictions.eq("goodIdentificationMvoEventId.productGoodIdentificationIdProductId", idObj.getProductId()));
        criteria.add(Restrictions.eq("goodIdentificationMvoEventId.productGoodIdentificationIdGoodIdentificationTypeId", idObj.getGoodIdentificationTypeId()));
        criteria.add(Restrictions.le("goodIdentificationMvoEventId.productVersion", version));
        criteria.addOrder(Order.asc("goodIdentificationMvoEventId.productVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractGoodIdentificationMvoEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractGoodIdentificationMvoEvent) es.get(es.size() - 1)).getGoodIdentificationMvoEventId().getProductVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

