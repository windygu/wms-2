package org.dddml.wms.domain.order.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.order.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateOrderShipGroupStateEventDao implements OrderShipGroupStateEventDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(OrderShipGroupStateEvent e)
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
    public Iterable<OrderShipGroupStateEvent> findByOrderEventId(OrderEventId orderEventId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractOrderShipGroupStateEvent.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("orderShipGroupEventId.orderId", orderEventId.getOrderId()))
            .add(Restrictions.eq("orderShipGroupEventId.orderVersion", orderEventId.getVersion()))
            ;
        return criteria.add(partIdCondition).list();
    }

}

