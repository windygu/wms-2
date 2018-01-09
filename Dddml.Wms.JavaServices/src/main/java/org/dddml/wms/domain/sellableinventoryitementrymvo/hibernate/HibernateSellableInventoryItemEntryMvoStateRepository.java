package org.dddml.wms.domain.sellableinventoryitementrymvo.hibernate;

import java.util.*;
import org.dddml.wms.domain.sellableinventoryitem.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.sellableinventoryitementrymvo.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateSellableInventoryItemEntryMvoStateRepository implements SellableInventoryItemEntryMvoStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("SellableInventoryItemEntryId", "SellableQuantity", "SourceEventId", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "SellableInventoryItemSellableQuantity", "SellableInventoryItemEntries", "SellableInventoryItemVersion", "SellableInventoryItemCreatedBy", "SellableInventoryItemCreatedAt", "SellableInventoryItemUpdatedBy", "SellableInventoryItemUpdatedAt"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public SellableInventoryItemEntryMvoState get(SellableInventoryItemEntryId id, boolean nullAllowed) {
        SellableInventoryItemEntryMvoState state = (SellableInventoryItemEntryMvoState)getCurrentSession().get(AbstractSellableInventoryItemEntryMvoState.SimpleSellableInventoryItemEntryMvoState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractSellableInventoryItemEntryMvoState.SimpleSellableInventoryItemEntryMvoState();
            state.setSellableInventoryItemEntryId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (SellableInventoryItemEntryMvoState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{SellableInventoryItemEntryMvoState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(SellableInventoryItemEntryMvoState state)
    {
        SellableInventoryItemEntryMvoState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (SellableInventoryItemEntryMvoState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if(s.getSellableInventoryItemVersion() == null) {
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

