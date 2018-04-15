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
    protected Class getSupportedEventType()
    {
        return AbstractProductCategoryMemberEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractProductCategoryMemberEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        ProductCategoryMemberId idObj = (ProductCategoryMemberId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractProductCategoryMemberEvent.class);
        criteria.add(Restrictions.eq("productCategoryMemberEventId.productCategoryMemberIdProductCategoryId", idObj.getProductCategoryId()));
        criteria.add(Restrictions.eq("productCategoryMemberEventId.productCategoryMemberIdProductId", idObj.getProductId()));
        criteria.add(Restrictions.le("productCategoryMemberEventId.version", version));
        criteria.addOrder(Order.asc("productCategoryMemberEventId.version"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractProductCategoryMemberEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractProductCategoryMemberEvent) es.get(es.size() - 1)).getProductCategoryMemberEventId().getVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

