package org.dddml.wms.domain.movementconfirmation.hibernate;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.movementconfirmation.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateMovementConfirmationLineEventDao implements MovementConfirmationLineEventDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(MovementConfirmationLineEvent e)
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
    public Iterable<MovementConfirmationLineEvent> findByMovementConfirmationEventId(MovementConfirmationEventId movementConfirmationEventId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractMovementConfirmationLineEvent.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("movementConfirmationLineEventId.movementConfirmationDocumentNumber", movementConfirmationEventId.getDocumentNumber()))
            .add(Restrictions.eq("movementConfirmationLineEventId.movementConfirmationVersion", movementConfirmationEventId.getVersion()))
            ;
        return criteria.add(partIdCondition).list();
    }

}

