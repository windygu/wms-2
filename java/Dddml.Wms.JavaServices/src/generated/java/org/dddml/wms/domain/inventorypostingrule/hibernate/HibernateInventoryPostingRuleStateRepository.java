package org.dddml.wms.domain.inventorypostingrule.hibernate;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.inventorypostingrule.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateInventoryPostingRuleStateRepository implements InventoryPostingRuleStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("InventoryPostingRuleId", "TriggerInventoryItemId", "OutputInventoryItemId", "TriggerAccountName", "OutputAccountName", "IsOutputNegated", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public InventoryPostingRuleState get(String id, boolean nullAllowed) {
        InventoryPostingRuleState.SqlInventoryPostingRuleState state = (InventoryPostingRuleState.SqlInventoryPostingRuleState)getCurrentSession().get(AbstractInventoryPostingRuleState.SimpleInventoryPostingRuleState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractInventoryPostingRuleState.SimpleInventoryPostingRuleState();
            state.setInventoryPostingRuleId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (InventoryPostingRuleState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{InventoryPostingRuleState.SqlInventoryPostingRuleState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(InventoryPostingRuleState state)
    {
        InventoryPostingRuleState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (InventoryPostingRuleState) getReadOnlyProxyGenerator().getTarget(state);
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

