package org.dddml.wms.domain.inout.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.inout.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateInOutLineImageEventDao implements InOutLineImageEventDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(InOutLineImageEvent e)
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
    public Iterable<InOutLineImageEvent> findByInOutLineEventId(InOutLineEventId inOutLineEventId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractInOutLineImageEvent.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("inOutLineImageEventId.inOutDocumentNumber", inOutLineEventId.getInOutDocumentNumber()))
            .add(Restrictions.eq("inOutLineImageEventId.inOutLineLineNumber", inOutLineEventId.getLineNumber()))
            .add(Restrictions.eq("inOutLineImageEventId.inOutVersion", inOutLineEventId.getInOutVersion()))
            ;
        return criteria.add(partIdCondition).list();
    }

}

