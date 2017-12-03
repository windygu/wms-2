package org.dddml.wms.domain.sellableinventoryitem.hibernate;

import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.sellableinventoryitem.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateSellableInventoryItemEntryStateDao implements SellableInventoryItemEntryStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("EntrySeqId", "QuantitySellable", "SourceEventId", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "SellableInventoryItemId"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public SellableInventoryItemEntryState get(SellableInventoryItemEntryId id, boolean nullAllowed)
    {
        SellableInventoryItemEntryState state = (SellableInventoryItemEntryState) getCurrentSession().get(AbstractSellableInventoryItemEntryState.SimpleSellableInventoryItemEntryState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractSellableInventoryItemEntryState.SimpleSellableInventoryItemEntryState();
            state.setSellableInventoryItemEntryId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (SellableInventoryItemEntryState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{SellableInventoryItemEntryState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    @Override
    public void save(SellableInventoryItemEntryState state)
    {
        SellableInventoryItemEntryState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (SellableInventoryItemEntryState) getReadOnlyProxyGenerator().getTarget(state);
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
    public Iterable<SellableInventoryItemEntryState> findBySellableInventoryItemId(InventoryItemId sellableInventoryItemId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractSellableInventoryItemEntryState.SimpleSellableInventoryItemEntryState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("sellableInventoryItemEntryId.sellableInventoryItemIdProductId", sellableInventoryItemId.getProductId()))
            .add(Restrictions.eq("sellableInventoryItemEntryId.sellableInventoryItemIdLocatorId", sellableInventoryItemId.getLocatorId()))
            .add(Restrictions.eq("sellableInventoryItemEntryId.sellableInventoryItemIdAttributeSetInstanceId", sellableInventoryItemId.getAttributeSetInstanceId()))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(SellableInventoryItemEntryState state)
    {
        SellableInventoryItemEntryState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (SellableInventoryItemEntryState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

