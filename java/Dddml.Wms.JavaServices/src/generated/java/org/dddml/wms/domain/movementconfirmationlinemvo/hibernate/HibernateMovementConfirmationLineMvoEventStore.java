package org.dddml.wms.domain.movementconfirmationlinemvo.hibernate;

import java.io.Serializable;
import java.util.*;
import org.dddml.wms.domain.movementconfirmation.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.wms.domain.movementconfirmationlinemvo.*;

public class HibernateMovementConfirmationLineMvoEventStore extends AbstractHibernateEventStore
{
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new MovementConfirmationLineMvoEventId((MovementConfirmationLineId) eventStoreAggregateId.getId(), version);
    }

    @Override
    protected Class getSupportedStateEventType()
    {
        return AbstractMovementConfirmationLineMvoStateEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractMovementConfirmationLineMvoStateEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        MovementConfirmationLineId idObj = (MovementConfirmationLineId) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractMovementConfirmationLineMvoStateEvent.class);
        criteria.add(Restrictions.eq("movementConfirmationLineMvoEventId.movementConfirmationLineIdMovementConfirmationDocumentNumber", idObj.getMovementConfirmationDocumentNumber()));
        criteria.add(Restrictions.eq("movementConfirmationLineMvoEventId.movementConfirmationLineIdLineNumber", idObj.getLineNumber()));
        criteria.add(Restrictions.le("movementConfirmationLineMvoEventId.movementConfirmationVersion", version));
        criteria.addOrder(Order.asc("movementConfirmationLineMvoEventId.movementConfirmationVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractMovementConfirmationLineMvoStateEvent) e).setStateEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractMovementConfirmationLineMvoStateEvent) es.get(es.size() - 1)).getMovementConfirmationLineMvoEventId().getMovementConfirmationVersion());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

