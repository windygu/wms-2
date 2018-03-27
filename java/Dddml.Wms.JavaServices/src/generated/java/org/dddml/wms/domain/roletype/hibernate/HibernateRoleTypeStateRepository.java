package org.dddml.wms.domain.roletype.hibernate;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.roletype.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateRoleTypeStateRepository implements RoleTypeStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("RoleTypeId", "ParentTypeId", "HasTable", "Description", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public RoleTypeState get(String id, boolean nullAllowed) {
        RoleTypeState state = (RoleTypeState)getCurrentSession().get(AbstractRoleTypeState.SimpleRoleTypeState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractRoleTypeState.SimpleRoleTypeState();
            state.setRoleTypeId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (RoleTypeState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{RoleTypeState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(RoleTypeState state)
    {
        RoleTypeState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (RoleTypeState) getReadOnlyProxyGenerator().getTarget(state);
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

