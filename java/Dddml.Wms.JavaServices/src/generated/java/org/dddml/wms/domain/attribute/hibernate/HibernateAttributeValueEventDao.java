package org.dddml.wms.domain.attribute.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.attribute.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateAttributeValueEventDao implements AttributeValueEventDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(AttributeValueEvent e)
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
    public Iterable<AttributeValueEvent> findByAttributeEventId(AttributeEventId attributeEventId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractAttributeValueEvent.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("attributeValueEventId.attributeId", attributeEventId.getAttributeId()))
            .add(Restrictions.eq("attributeValueEventId.attributeVersion", attributeEventId.getVersion()))
            ;
        return criteria.add(partIdCondition).list();
    }

}

