package org.dddml.wms.domain.inout.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.inout.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateInOutImageEventDao implements InOutImageEventDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(InOutImageEvent e)
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
    public Iterable<InOutImageEvent> findByInOutEventId(InOutEventId inOutEventId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractInOutImageEvent.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("inOutImageEventId.inOutDocumentNumber", inOutEventId.getDocumentNumber()))
            .add(Restrictions.eq("inOutImageEventId.inOutVersion", inOutEventId.getVersion()))
            ;
        return criteria.add(partIdCondition).list();
    }

}

