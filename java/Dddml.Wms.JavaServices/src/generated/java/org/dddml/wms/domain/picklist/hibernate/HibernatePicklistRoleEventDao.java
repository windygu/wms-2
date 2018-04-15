package org.dddml.wms.domain.picklist.hibernate;

import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.picklist.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernatePicklistRoleEventDao implements PicklistRoleEventDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(PicklistRoleEvent e)
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
    public Iterable<PicklistRoleEvent> findByPicklistEventId(PicklistEventId picklistEventId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractPicklistRoleEvent.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("picklistRoleEventId.picklistId", picklistEventId.getPicklistId()))
            .add(Restrictions.eq("picklistRoleEventId.picklistVersion", picklistEventId.getVersion()))
            ;
        return criteria.add(partIdCondition).list();
    }

}

