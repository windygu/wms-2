package org.dddml.wms.domain.movementconfirmation.hibernate;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.movementconfirmation.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateMovementConfirmationLineStateEventDao implements MovementConfirmationLineStateEventDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(MovementConfirmationLineStateEvent e)
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
    public Iterable<MovementConfirmationLineStateEvent> findByMovementConfirmationEventId(MovementConfirmationEventId movementConfirmationEventId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractMovementConfirmationLineStateEvent.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("stateEventId.movementConfirmationDocumentNumber", movementConfirmationEventId.getDocumentNumber()))
            .add(Restrictions.eq("stateEventId.movementConfirmationVersion", movementConfirmationEventId.getVersion()))
            ;
        return criteria.add(partIdCondition).list();
    }

}

