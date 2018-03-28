package org.dddml.wms.domain.order.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.order.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateOrderItemShipGroupAssociationStateEventDao implements OrderItemShipGroupAssociationStateEventDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(OrderItemShipGroupAssociationStateEvent e)
    {
        getCurrentSession().save(e);
        if (e instanceof Saveable)
        {
            Saveable saveable = (Saveable) e;
            saveable.save();
        }
    }


    @Transactional(readOnly = true)
    @Override
    public Iterable<OrderItemShipGroupAssociationStateEvent> findByOrderShipGroupEventId(OrderShipGroupEventId orderShipGroupEventId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractOrderItemShipGroupAssociationStateEvent.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("orderItemShipGroupAssociationEventId.orderId", orderShipGroupEventId.getOrderId()))
            .add(Restrictions.eq("orderItemShipGroupAssociationEventId.orderShipGroupShipGroupSeqId", orderShipGroupEventId.getShipGroupSeqId()))
            .add(Restrictions.eq("orderItemShipGroupAssociationEventId.orderVersion", orderShipGroupEventId.getOrderVersion()))
            ;
        return criteria.add(partIdCondition).list();
    }

}

