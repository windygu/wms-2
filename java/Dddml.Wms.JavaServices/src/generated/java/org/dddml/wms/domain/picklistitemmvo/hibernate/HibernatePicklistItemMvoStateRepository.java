package org.dddml.wms.domain.picklistitemmvo.hibernate;

import java.util.*;
import org.dddml.wms.domain.picklistbin.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.picklistitemmvo.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernatePicklistItemMvoStateRepository implements PicklistItemMvoStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("PicklistBinPicklistItemId", "ItemStatusId", "Quantity", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "PicklistBinPicklistId", "PicklistBinBinLocationNumber", "PicklistBinPrimaryOrderId", "PicklistBinPrimaryShipGroupSeqId", "PicklistBinPicklistItems", "PicklistBinVersion", "PicklistBinCreatedBy", "PicklistBinCreatedAt", "PicklistBinUpdatedBy", "PicklistBinUpdatedAt", "PicklistBinActive", "PicklistBinDeleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public PicklistItemMvoState get(PicklistBinPicklistItemId id, boolean nullAllowed) {
        PicklistItemMvoState state = (PicklistItemMvoState)getCurrentSession().get(AbstractPicklistItemMvoState.SimplePicklistItemMvoState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractPicklistItemMvoState.SimplePicklistItemMvoState();
            state.setPicklistBinPicklistItemId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (PicklistItemMvoState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{PicklistItemMvoState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(PicklistItemMvoState state)
    {
        PicklistItemMvoState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (PicklistItemMvoState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if(s.getPicklistBinVersion() == null) {
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

