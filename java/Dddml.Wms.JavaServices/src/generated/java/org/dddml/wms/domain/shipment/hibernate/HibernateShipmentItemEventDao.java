package org.dddml.wms.domain.shipment.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.shipment.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateShipmentItemEventDao implements ShipmentItemEventDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(ShipmentItemEvent e)
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
    public Iterable<ShipmentItemEvent> findByShipmentEventId(ShipmentEventId shipmentEventId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractShipmentItemEvent.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("shipmentItemEventId.shipmentId", shipmentEventId.getShipmentId()))
            .add(Restrictions.eq("shipmentItemEventId.shipmentVersion", shipmentEventId.getVersion()))
            ;
        return criteria.add(partIdCondition).list();
    }

}

