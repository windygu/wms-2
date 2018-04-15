package org.dddml.wms.domain.shipmentpackage.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.shipmentpackage.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateShipmentPackageContentEventDao implements ShipmentPackageContentEventDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(ShipmentPackageContentEvent e)
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
    public Iterable<ShipmentPackageContentEvent> findByShipmentPackageEventId(ShipmentPackageEventId shipmentPackageEventId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractShipmentPackageContentEvent.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("shipmentPackageContentEventId.shipmentPackageIdShipmentId", shipmentPackageEventId.getShipmentPackageId().getShipmentId()))
            .add(Restrictions.eq("shipmentPackageContentEventId.shipmentPackageIdShipmentPackageSeqId", shipmentPackageEventId.getShipmentPackageId().getShipmentPackageSeqId()))
            .add(Restrictions.eq("shipmentPackageContentEventId.shipmentPackageVersion", shipmentPackageEventId.getVersion()))
            ;
        return criteria.add(partIdCondition).list();
    }

}

