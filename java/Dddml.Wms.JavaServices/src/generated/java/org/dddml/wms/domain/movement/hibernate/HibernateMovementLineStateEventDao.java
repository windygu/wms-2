package org.dddml.wms.domain.movement.hibernate;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.movement.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateMovementLineStateEventDao implements MovementLineStateEventDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(MovementLineStateEvent e)
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
    public Iterable<MovementLineStateEvent> findByMovementStateEventId(MovementStateEventId movementStateEventId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractMovementLineStateEvent.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("stateEventId.movementDocumentNumber", movementStateEventId.getDocumentNumber()))
            .add(Restrictions.eq("stateEventId.movementVersion", movementStateEventId.getVersion()))
            ;
        return criteria.add(partIdCondition).list();
    }

}

