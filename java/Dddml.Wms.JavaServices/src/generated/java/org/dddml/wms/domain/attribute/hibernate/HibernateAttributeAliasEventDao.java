package org.dddml.wms.domain.attribute.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.attribute.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateAttributeAliasEventDao implements AttributeAliasEventDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(AttributeAliasEvent e)
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
    public Iterable<AttributeAliasEvent> findByAttributeEventId(AttributeEventId attributeEventId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractAttributeAliasEvent.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("attributeAliasEventId.attributeId", attributeEventId.getAttributeId()))
            .add(Restrictions.eq("attributeAliasEventId.attributeVersion", attributeEventId.getVersion()))
            ;
        return criteria.add(partIdCondition).list();
    }

}

