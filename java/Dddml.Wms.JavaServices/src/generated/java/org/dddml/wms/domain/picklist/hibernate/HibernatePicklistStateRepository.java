package org.dddml.wms.domain.picklist.hibernate;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.picklist.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernatePicklistStateRepository implements PicklistStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("PicklistId", "Description", "FacilityId", "ShipmentMethodTypeId", "StatusId", "PicklistDate", "CreatedByUserLogin", "LastModifiedByUserLogin", "PicklistRoles", "Version", "CreatedAt", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public PicklistState get(String id, boolean nullAllowed) {
        PicklistState state = (PicklistState)getCurrentSession().get(AbstractPicklistState.SimplePicklistState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractPicklistState.SimplePicklistState();
            state.setPicklistId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (PicklistState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{PicklistState.class, Saveable.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(PicklistState state)
    {
        PicklistState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (PicklistState) getReadOnlyProxyGenerator().getTarget(state);
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

