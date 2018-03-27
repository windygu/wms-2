package org.dddml.wms.domain.shipment.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.shipment.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateItemIssuanceStateEventDao implements ItemIssuanceStateEventDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(ItemIssuanceStateEvent e)
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
    public Iterable<ItemIssuanceStateEvent> findByShipmentEventId(ShipmentEventId shipmentEventId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractItemIssuanceStateEvent.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("itemIssuanceEventId.shipmentId", shipmentEventId.getShipmentId()))
            .add(Restrictions.eq("itemIssuanceEventId.shipmentVersion", shipmentEventId.getVersion()))
            ;
        return criteria.add(partIdCondition).list();
    }

}

