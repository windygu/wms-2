package org.dddml.wms.domain.inventoryitem.hibernate;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateInventoryItemStateRepository implements InventoryItemStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("InventoryItemId", "OnHandQuantity", "InTransitQuantity", "ReservedQuantity", "OccupiedQuantity", "VirtualQuantity", "Entries", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public InventoryItemState get(InventoryItemId id, boolean nullAllowed) {
        InventoryItemState state = (InventoryItemState)getCurrentSession().get(AbstractInventoryItemState.SimpleInventoryItemState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractInventoryItemState.SimpleInventoryItemState();
            state.setInventoryItemId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (InventoryItemState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{InventoryItemState.class, Saveable.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(InventoryItemState state)
    {
        InventoryItemState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (InventoryItemState) getReadOnlyProxyGenerator().getTarget(state);
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

    //protected static void addNotDeletedRestriction(Criteria criteria) {
    //    criteria.add(org.hibernate.criterion.Restrictions.eq("deleted", false));
    //}

}

