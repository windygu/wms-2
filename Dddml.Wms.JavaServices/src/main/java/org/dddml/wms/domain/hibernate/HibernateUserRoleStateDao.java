package org.dddml.wms.domain.hibernate;

import java.util.Date;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateUserRoleStateDao implements UserRoleStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("RoleId", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "UserId"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public UserRoleState get(UserRoleId id)
    {
        return get(id, false);
    }

    @Transactional(readOnly = true)
    @Override
    public UserRoleState get(UserRoleId id, boolean nullAllowed)
    {
        UserRoleState state = (UserRoleState) getCurrentSession().get(AbstractUserRoleState.SimpleUserRoleState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractUserRoleState.SimpleUserRoleState();
            state.setUserRoleId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (UserRoleState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{UserRoleState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    @Override
    public void save(UserRoleState state)
    {
        UserRoleState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (UserRoleState) getReadOnlyProxyGenerator().getTarget(state);
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
    public Iterable<UserRoleState> findByUserId(String userId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractUserRoleState.SimpleUserRoleState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("userRoleId.userId", userId))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(UserRoleState state)
    {
        UserRoleState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (UserRoleState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

