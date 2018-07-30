package org.dddml.wms.domain.shipment.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.shipment.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateShipmentReceiptImageEventDao implements ShipmentReceiptImageEventDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(ShipmentReceiptImageEvent e)
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
    public Iterable<ShipmentReceiptImageEvent> findByShipmentReceiptEventId(ShipmentReceiptEventId shipmentReceiptEventId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractShipmentReceiptImageEvent.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("shipmentReceiptImageEventId.shipmentId", shipmentReceiptEventId.getShipmentId()))
            .add(Restrictions.eq("shipmentReceiptImageEventId.shipmentReceiptReceiptSeqId", shipmentReceiptEventId.getReceiptSeqId()))
            .add(Restrictions.eq("shipmentReceiptImageEventId.shipmentVersion", shipmentReceiptEventId.getShipmentVersion()))
            ;
        return criteria.add(partIdCondition).list();
    }

}

