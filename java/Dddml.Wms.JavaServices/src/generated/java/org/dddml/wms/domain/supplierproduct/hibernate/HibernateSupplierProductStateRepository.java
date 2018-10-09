package org.dddml.wms.domain.supplierproduct.hibernate;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.supplierproduct.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateSupplierProductStateRepository implements SupplierProductStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("SupplierProductId", "AvailableThruDate", "SupplierPrefOrderId", "SupplierRatingTypeId", "StandardLeadTimeDays", "ManufacturingLeadTimeDays", "DeliveryLeadTimeDays", "QuantityUomId", "LastPrice", "ShippingPrice", "ExternalProductName", "ExternalProductId", "CanDropShip", "Comments", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public SupplierProductState get(SupplierProductId id, boolean nullAllowed) {
        SupplierProductState.SqlSupplierProductState state = (SupplierProductState.SqlSupplierProductState)getCurrentSession().get(AbstractSupplierProductState.SimpleSupplierProductState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractSupplierProductState.SimpleSupplierProductState();
            state.setSupplierProductId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (SupplierProductState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{SupplierProductState.SqlSupplierProductState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(SupplierProductState state)
    {
        SupplierProductState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (SupplierProductState) getReadOnlyProxyGenerator().getTarget(state);
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

