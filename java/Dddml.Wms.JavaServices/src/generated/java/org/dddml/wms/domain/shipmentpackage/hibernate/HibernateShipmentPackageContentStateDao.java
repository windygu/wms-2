package org.dddml.wms.domain.shipmentpackage.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.shipmentpackage.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateShipmentPackageContentStateDao implements ShipmentPackageContentStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("ShipmentItemSeqId", "Quantity", "SubProductId", "SubProductQuantity", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "ShipmentPackageId"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public ShipmentPackageContentState get(ShipmentPackageContentId id, boolean nullAllowed)
    {
        ShipmentPackageContentState state = (ShipmentPackageContentState) getCurrentSession().get(AbstractShipmentPackageContentState.SimpleShipmentPackageContentState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractShipmentPackageContentState.SimpleShipmentPackageContentState();
            state.setShipmentPackageContentId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (ShipmentPackageContentState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{ShipmentPackageContentState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    @Override
    public void save(ShipmentPackageContentState state)
    {
        ShipmentPackageContentState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (ShipmentPackageContentState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if(s.getVersion() == null) {
            getCurrentSession().save(s);
        }else {
            getCurrentSession().update(s);
        }

        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<ShipmentPackageContentState> findByShipmentPackageId(ShipmentPackageId shipmentPackageId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractShipmentPackageContentState.SimpleShipmentPackageContentState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("shipmentPackageContentId.shipmentPackageIdShipmentId", shipmentPackageId.getShipmentId()))
            .add(Restrictions.eq("shipmentPackageContentId.shipmentPackageIdShipmentPackageSeqId", shipmentPackageId.getShipmentPackageSeqId()))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(ShipmentPackageContentState state)
    {
        ShipmentPackageContentState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (ShipmentPackageContentState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

