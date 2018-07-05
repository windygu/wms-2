package org.dddml.wms.domain.product.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.product.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateGoodIdentificationEventDao implements GoodIdentificationEventDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(GoodIdentificationEvent e)
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
    public Iterable<GoodIdentificationEvent> findByProductEventId(ProductEventId productEventId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractGoodIdentificationEvent.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("goodIdentificationEventId.productId", productEventId.getProductId()))
            .add(Restrictions.eq("goodIdentificationEventId.productVersion", productEventId.getVersion()))
            ;
        return criteria.add(partIdCondition).list();
    }

}

