package org.dddml.wms.domain.inventoryitemrequiremententrymvo.hibernate;

import java.util.*;
import org.dddml.wms.domain.inventoryitemrequirement.*;
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
import org.dddml.wms.domain.inventoryitemrequiremententrymvo.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateInventoryItemRequirementEntryMvoStateRepository implements InventoryItemRequirementEntryMvoStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("InventoryItemRequirementEntryId", "Quantity", "SourceEventId", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "InventoryItemRequirementQuantity", "InventoryItemRequirementEntries", "InventoryItemRequirementVersion", "InventoryItemRequirementCreatedBy", "InventoryItemRequirementCreatedAt", "InventoryItemRequirementUpdatedBy", "InventoryItemRequirementUpdatedAt"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public InventoryItemRequirementEntryMvoState get(InventoryItemRequirementEntryId id, boolean nullAllowed) {
        InventoryItemRequirementEntryMvoState state = (InventoryItemRequirementEntryMvoState)getCurrentSession().get(AbstractInventoryItemRequirementEntryMvoState.SimpleInventoryItemRequirementEntryMvoState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractInventoryItemRequirementEntryMvoState.SimpleInventoryItemRequirementEntryMvoState();
            state.setInventoryItemRequirementEntryId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (InventoryItemRequirementEntryMvoState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{InventoryItemRequirementEntryMvoState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(InventoryItemRequirementEntryMvoState state)
    {
        InventoryItemRequirementEntryMvoState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (InventoryItemRequirementEntryMvoState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if(s.getInventoryItemRequirementVersion() == null) {
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

