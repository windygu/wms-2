package org.dddml.wms.domain.shipmentpackage.hibernate;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.shipmentpackage.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateShipmentPackageStateRepository implements ShipmentPackageStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("ShipmentPackageId", "ShipmentBoxTypeId", "DateCreated", "BoxLength", "BoxHeight", "BoxWidth", "DimensionUomId", "Weight", "WeightUomId", "InsuredValue", "ShipmentPackageContents", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public ShipmentPackageState get(ShipmentPackageId id, boolean nullAllowed) {
        ShipmentPackageState.SqlShipmentPackageState state = (ShipmentPackageState.SqlShipmentPackageState)getCurrentSession().get(AbstractShipmentPackageState.SimpleShipmentPackageState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractShipmentPackageState.SimpleShipmentPackageState();
            state.setShipmentPackageId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (ShipmentPackageState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{ShipmentPackageState.SqlShipmentPackageState.class, Saveable.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(ShipmentPackageState state)
    {
        ShipmentPackageState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (ShipmentPackageState) getReadOnlyProxyGenerator().getTarget(state);
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
        getCurrentSession().flush();
    }

    //protected static void addNotDeletedRestriction(Criteria criteria) {
    //    criteria.add(org.hibernate.criterion.Restrictions.eq("deleted", false));
    //}

}

