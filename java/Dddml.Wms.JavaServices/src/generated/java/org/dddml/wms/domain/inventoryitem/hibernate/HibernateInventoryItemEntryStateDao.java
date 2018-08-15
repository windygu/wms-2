package org.dddml.wms.domain.inventoryitem.hibernate;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateInventoryItemEntryStateDao implements InventoryItemEntryStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("EntrySeqId", "OnHandQuantity", "InTransitQuantity", "ReservedQuantity", "OccupiedQuantity", "VirtualQuantity", "Source", "OccurredAt", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "InventoryItemId"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public InventoryItemEntryState get(InventoryItemEntryId id, boolean nullAllowed)
    {
        InventoryItemEntryState state = (InventoryItemEntryState) getCurrentSession().get(AbstractInventoryItemEntryState.SimpleInventoryItemEntryState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractInventoryItemEntryState.SimpleInventoryItemEntryState();
            state.setInventoryItemEntryId(id);
        }
        //if (getReadOnlyProxyGenerator() != null && state != null) {
        //    return (InventoryItemEntryState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{InventoryItemEntryState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        //}
        return state;
    }

    @Override
    public void save(InventoryItemEntryState state)
    {
        InventoryItemEntryState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (InventoryItemEntryState) getReadOnlyProxyGenerator().getTarget(state);
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
    public Iterable<InventoryItemEntryState> findByInventoryItemId(InventoryItemId inventoryItemId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractInventoryItemEntryState.SimpleInventoryItemEntryState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("inventoryItemEntryId.inventoryItemIdProductId", inventoryItemId.getProductId()))
            .add(Restrictions.eq("inventoryItemEntryId.inventoryItemIdLocatorId", inventoryItemId.getLocatorId()))
            .add(Restrictions.eq("inventoryItemEntryId.inventoryItemIdAttributeSetInstanceId", inventoryItemId.getAttributeSetInstanceId()))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(InventoryItemEntryState state)
    {
        InventoryItemEntryState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (InventoryItemEntryState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

