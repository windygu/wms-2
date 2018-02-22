package org.dddml.wms.domain.physicalinventory.hibernate;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.physicalinventory.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernatePhysicalInventoryStateRepository implements PhysicalInventoryStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("DocumentNumber", "DocumentStatusId", "WarehouseId", "LocatorIdPattern", "ProductIdPattern", "Posted", "Processed", "Processing", "DocumentTypeId", "MovementDate", "Description", "IsApproved", "ApprovalAmount", "IsQuantityUpdated", "ReversalDocumentNumber", "PhysicalInventoryLines", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public PhysicalInventoryState get(String id, boolean nullAllowed) {
        PhysicalInventoryState state = (PhysicalInventoryState)getCurrentSession().get(AbstractPhysicalInventoryState.SimplePhysicalInventoryState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractPhysicalInventoryState.SimplePhysicalInventoryState();
            state.setDocumentNumber(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (PhysicalInventoryState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{PhysicalInventoryState.class, Saveable.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(PhysicalInventoryState state)
    {
        PhysicalInventoryState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (PhysicalInventoryState) getReadOnlyProxyGenerator().getTarget(state);
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

