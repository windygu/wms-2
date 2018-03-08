package org.dddml.wms.domain.productcategorymember.hibernate;

import java.io.Serializable;
import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.productcategorymember.*;

public class HibernateProductCategoryMemberEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new ProductCategoryMemberEventId((ProductCategoryMemberId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedStateEventType()
    {
        return AbstractProductCategoryMemberStateEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractProductCategoryMemberStateEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        ProductCategoryMemberId idObj = (ProductCategoryMemberId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractProductCategoryMemberStateEvent.class);
        criteria.add(Restrictions.eq("stateEventId.productCategoryMemberIdProductCategoryId", idObj.getProductCategoryId()));
        criteria.add(Restrictions.eq("stateEventId.productCategoryMemberIdProductId", idObj.getProductId()));
        criteria.add(Restrictions.le("stateEventId.version", version));
        criteria.addOrder(Order.asc("stateEventId.version"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractProductCategoryMemberStateEvent) e).setStateEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractProductCategoryMemberStateEvent) es.get(es.size() - 1)).getStateEventId().getVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

