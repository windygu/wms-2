package org.dddml.wms.domain.inoutnotice.hibernate;

import java.io.Serializable;
import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.inoutnotice.*;

public class HibernateInOutNoticeEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new InOutNoticeEventId((String) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedEventType()
    {
        return AbstractInOutNoticeEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractInOutNoticeEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        String idObj = (String) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractInOutNoticeEvent.class);
        criteria.add(Restrictions.eq("inOutNoticeEventId.inOutNoticeId", idObj));
        criteria.add(Restrictions.le("inOutNoticeEventId.version", version));
        criteria.addOrder(Order.asc("inOutNoticeEventId.version"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractInOutNoticeEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractInOutNoticeEvent) es.get(es.size() - 1)).getInOutNoticeEventId().getVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

