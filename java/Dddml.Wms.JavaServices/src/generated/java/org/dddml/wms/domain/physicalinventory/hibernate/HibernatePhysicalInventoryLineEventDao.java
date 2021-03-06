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

public class HibernatePhysicalInventoryLineEventDao implements PhysicalInventoryLineEventDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(PhysicalInventoryLineEvent e)
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
    public Iterable<PhysicalInventoryLineEvent> findByPhysicalInventoryEventId(PhysicalInventoryEventId physicalInventoryEventId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractPhysicalInventoryLineEvent.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("physicalInventoryLineEventId.physicalInventoryDocumentNumber", physicalInventoryEventId.getDocumentNumber()))
            .add(Restrictions.eq("physicalInventoryLineEventId.physicalInventoryVersion", physicalInventoryEventId.getVersion()))
            ;
        return criteria.add(partIdCondition).list();
    }

}

