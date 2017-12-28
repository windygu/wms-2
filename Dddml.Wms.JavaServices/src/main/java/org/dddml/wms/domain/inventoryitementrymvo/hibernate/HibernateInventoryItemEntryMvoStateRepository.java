package org.dddml.wms.domain.inventoryitementrymvo.hibernate;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.inventoryitementrymvo.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateInventoryItemEntryMvoStateRepository implements InventoryItemEntryMvoStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("InventoryItemEntryId", "OnHandQuantity", "InTransitQuantity", "ReservedQuantity", "OccupiedQuantity", "VirtualQuantity", "Source", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "InventoryItemOnHandQuantity", "InventoryItemInTransitQuantity", "InventoryItemReservedQuantity", "InventoryItemOccupiedQuantity", "InventoryItemVirtualQuantity", "InventoryItemEntries", "InventoryItemVersion", "InventoryItemCreatedBy", "InventoryItemCreatedAt", "InventoryItemUpdatedBy", "InventoryItemUpdatedAt"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public InventoryItemEntryMvoState get(InventoryItemEntryId id, boolean nullAllowed) {
        InventoryItemEntryMvoState state = (InventoryItemEntryMvoState)getCurrentSession().get(AbstractInventoryItemEntryMvoState.SimpleInventoryItemEntryMvoState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractInventoryItemEntryMvoState.SimpleInventoryItemEntryMvoState();
            state.setInventoryItemEntryId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (InventoryItemEntryMvoState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{InventoryItemEntryMvoState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(InventoryItemEntryMvoState state)
    {
        InventoryItemEntryMvoState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (InventoryItemEntryMvoState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if(s.getInventoryItemVersion() == null) {
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

    //protected static void addNotDeletedRestriction(Criteria criteria) {
    //    criteria.add(org.hibernate.criterion.Restrictions.eq("deleted", false));
    //}

}

