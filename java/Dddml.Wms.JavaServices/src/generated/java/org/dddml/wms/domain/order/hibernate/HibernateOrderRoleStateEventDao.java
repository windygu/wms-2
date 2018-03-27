package org.dddml.wms.domain.order.hibernate;

import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.order.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateOrderRoleStateEventDao implements OrderRoleStateEventDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(OrderRoleStateEvent e)
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
    public Iterable<OrderRoleStateEvent> findByOrderEventId(OrderEventId orderEventId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractOrderRoleStateEvent.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("orderRoleEventId.orderId", orderEventId.getOrderId()))
            .add(Restrictions.eq("orderRoleEventId.orderVersion", orderEventId.getVersion()))
            ;
        return criteria.add(partIdCondition).list();
    }

}

