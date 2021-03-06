package org.dddml.wms.domain.attributeset.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.attributeset.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateAttributeUseEventDao implements AttributeUseEventDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(AttributeUseEvent e)
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
    public Iterable<AttributeUseEvent> findByAttributeSetEventId(AttributeSetEventId attributeSetEventId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractAttributeUseEvent.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("attributeUseEventId.attributeSetId", attributeSetEventId.getAttributeSetId()))
            .add(Restrictions.eq("attributeUseEventId.attributeSetVersion", attributeSetEventId.getVersion()))
            ;
        return criteria.add(partIdCondition).list();
    }

}

