package org.dddml.wms.domain.physicalinventory.hibernate;

import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.physicalinventory.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernatePhysicalInventoryLineStateEventDao implements PhysicalInventoryLineStateEventDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(PhysicalInventoryLineStateEvent e)
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
    public Iterable<PhysicalInventoryLineStateEvent> findByPhysicalInventoryStateEventId(PhysicalInventoryStateEventId physicalInventoryStateEventId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractPhysicalInventoryLineStateEvent.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("stateEventId.physicalInventoryDocumentNumber", physicalInventoryStateEventId.getDocumentNumber()))
            .add(Restrictions.eq("stateEventId.physicalInventoryVersion", physicalInventoryStateEventId.getVersion()))
            ;
        return criteria.add(partIdCondition).list();
    }

}

