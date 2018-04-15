package org.dddml.wms.domain.inout.hibernate;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.inout.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateInOutLineEventDao implements InOutLineEventDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(InOutLineEvent e)
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
    public Iterable<InOutLineEvent> findByInOutEventId(InOutEventId inOutEventId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractInOutLineEvent.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("inOutLineEventId.inOutDocumentNumber", inOutEventId.getDocumentNumber()))
            .add(Restrictions.eq("inOutLineEventId.inOutVersion", inOutEventId.getVersion()))
            ;
        return criteria.add(partIdCondition).list();
    }

}

