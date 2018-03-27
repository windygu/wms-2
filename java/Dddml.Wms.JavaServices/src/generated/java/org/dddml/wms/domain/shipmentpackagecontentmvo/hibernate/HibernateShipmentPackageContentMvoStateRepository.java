package org.dddml.wms.domain.shipmentpackagecontentmvo.hibernate;

import java.util.*;
import org.dddml.wms.domain.shipmentpackage.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.shipmentpackagecontentmvo.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateShipmentPackageContentMvoStateRepository implements ShipmentPackageContentMvoStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("ShipmentPackageContentId", "Quantity", "SubProductId", "SubProductQuantity", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "ShipmentPackageShipmentBoxTypeId", "ShipmentPackageDateCreated", "ShipmentPackageBoxLength", "ShipmentPackageBoxHeight", "ShipmentPackageBoxWidth", "ShipmentPackageDimensionUomId", "ShipmentPackageWeight", "ShipmentPackageWeightUomId", "ShipmentPackageInsuredValue", "ShipmentPackageShipmentPackageContents", "ShipmentPackageVersion", "ShipmentPackageCreatedBy", "ShipmentPackageCreatedAt", "ShipmentPackageUpdatedBy", "ShipmentPackageUpdatedAt", "ShipmentPackageActive", "ShipmentPackageDeleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public ShipmentPackageContentMvoState get(ShipmentPackageContentId id, boolean nullAllowed) {
        ShipmentPackageContentMvoState state = (ShipmentPackageContentMvoState)getCurrentSession().get(AbstractShipmentPackageContentMvoState.SimpleShipmentPackageContentMvoState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractShipmentPackageContentMvoState.SimpleShipmentPackageContentMvoState();
            state.setShipmentPackageContentId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (ShipmentPackageContentMvoState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{ShipmentPackageContentMvoState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(ShipmentPackageContentMvoState state)
    {
        ShipmentPackageContentMvoState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (ShipmentPackageContentMvoState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if(s.getShipmentPackageVersion() == null) {
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

