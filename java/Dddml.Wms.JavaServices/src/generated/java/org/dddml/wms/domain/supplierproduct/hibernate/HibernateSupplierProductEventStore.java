package org.dddml.wms.domain.supplierproduct.hibernate;

import java.io.Serializable;
import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.supplierproduct.*;

public class HibernateSupplierProductEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new SupplierProductEventId((SupplierProductId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedStateEventType()
    {
        return AbstractSupplierProductStateEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractSupplierProductStateEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        SupplierProductId idObj = (SupplierProductId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractSupplierProductStateEvent.class);
        criteria.add(Restrictions.eq("stateEventId.supplierProductIdProductId", idObj.getProductId()));
        criteria.add(Restrictions.eq("stateEventId.supplierProductIdPartyId", idObj.getPartyId()));
        criteria.add(Restrictions.eq("stateEventId.supplierProductIdCurrencyUomId", idObj.getCurrencyUomId()));
        criteria.add(Restrictions.eq("stateEventId.supplierProductIdMinimumOrderQuantity", idObj.getMinimumOrderQuantity()));
        criteria.add(Restrictions.le("stateEventId.version", version));
        criteria.addOrder(Order.asc("stateEventId.version"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractSupplierProductStateEvent) e).setStateEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractSupplierProductStateEvent) es.get(es.size() - 1)).getStateEventId().getVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

