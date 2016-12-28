package org.dddml.wms.domain.hibernate;

import java.util.Date;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateUserPermissionStateDao implements UserPermissionStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("PermissionId", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "UserId"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public UserPermissionState get(UserPermissionId id)
    {
        return get(id, false);
    }

    @Transactional(readOnly = true)
    @Override
    public UserPermissionState get(UserPermissionId id, boolean nullAllowed)
    {
        UserPermissionState state = (UserPermissionState) getCurrentSession().get(AbstractUserPermissionState.SimpleUserPermissionState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractUserPermissionState.SimpleUserPermissionState();
            state.setUserPermissionId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (UserPermissionState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{UserPermissionState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    @Override
    public void save(UserPermissionState state)
    {
        UserPermissionState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (UserPermissionState) getReadOnlyProxyGenerator().getTarget(state);
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
    public Iterable<UserPermissionState> findByUserId(String userId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractUserPermissionState.SimpleUserPermissionState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("userPermissionId.userId", userId))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(UserPermissionState state)
    {
        UserPermissionState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (UserPermissionState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

