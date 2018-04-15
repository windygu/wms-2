package org.dddml.wms.domain.order.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.order.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateOrderShipGroupEventDao implements OrderShipGroupEventDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(OrderShipGroupEvent e)
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
    public Iterable<OrderShipGroupEvent> findByOrderEventId(OrderEventId orderEventId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractOrderShipGroupEvent.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("orderShipGroupEventId.orderId", orderEventId.getOrderId()))
            .add(Restrictions.eq("orderShipGroupEventId.orderVersion", orderEventId.getVersion()))
            ;
        return criteria.add(partIdCondition).list();
    }

}

