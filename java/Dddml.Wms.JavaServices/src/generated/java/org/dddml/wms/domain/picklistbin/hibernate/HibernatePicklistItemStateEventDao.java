package org.dddml.wms.domain.picklistbin.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.picklistbin.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernatePicklistItemStateEventDao implements PicklistItemStateEventDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(PicklistItemStateEvent e)
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
    public Iterable<PicklistItemStateEvent> findByPicklistBinEventId(PicklistBinEventId picklistBinEventId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractPicklistItemStateEvent.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("picklistItemEventId.picklistBinId", picklistBinEventId.getPicklistBinId()))
            .add(Restrictions.eq("picklistItemEventId.picklistBinVersion", picklistBinEventId.getVersion()))
            ;
        return criteria.add(partIdCondition).list();
    }

}

