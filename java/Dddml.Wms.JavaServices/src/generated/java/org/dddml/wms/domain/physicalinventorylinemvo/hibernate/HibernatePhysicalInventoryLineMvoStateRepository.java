package org.dddml.wms.domain.physicalinventorylinemvo.hibernate;

import java.util.*;
import org.dddml.wms.domain.physicalinventory.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.physicalinventorylinemvo.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernatePhysicalInventoryLineMvoStateRepository implements PhysicalInventoryLineMvoStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("PhysicalInventoryLineId", "BookQuantity", "CountedQuantity", "Processed", "ReversalLineNumber", "Description", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "PhysicalInventoryDocumentStatusId", "PhysicalInventoryWarehouseId", "PhysicalInventoryLocatorIdPattern", "PhysicalInventoryProductIdPattern", "PhysicalInventoryPosted", "PhysicalInventoryProcessed", "PhysicalInventoryProcessing", "PhysicalInventoryDocumentTypeId", "PhysicalInventoryMovementDate", "PhysicalInventoryDescription", "PhysicalInventoryIsApproved", "PhysicalInventoryApprovalAmount", "PhysicalInventoryIsQuantityUpdated", "PhysicalInventoryReversalDocumentNumber", "PhysicalInventoryPhysicalInventoryLines", "PhysicalInventoryVersion", "PhysicalInventoryCreatedBy", "PhysicalInventoryCreatedAt", "PhysicalInventoryUpdatedBy", "PhysicalInventoryUpdatedAt", "PhysicalInventoryActive"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public PhysicalInventoryLineMvoState get(PhysicalInventoryLineId id, boolean nullAllowed) {
        PhysicalInventoryLineMvoState state = (PhysicalInventoryLineMvoState)getCurrentSession().get(AbstractPhysicalInventoryLineMvoState.SimplePhysicalInventoryLineMvoState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractPhysicalInventoryLineMvoState.SimplePhysicalInventoryLineMvoState();
            state.setPhysicalInventoryLineId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (PhysicalInventoryLineMvoState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{PhysicalInventoryLineMvoState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(PhysicalInventoryLineMvoState state)
    {
        PhysicalInventoryLineMvoState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (PhysicalInventoryLineMvoState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if(s.getPhysicalInventoryVersion() == null) {
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

