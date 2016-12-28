package org.dddml.wms.domain.hibernate;

import java.util.Date;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateUserLoginStateDao implements UserLoginStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("LoginKey", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "UserId"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public UserLoginState get(UserLoginId id)
    {
        return get(id, false);
    }

    @Transactional(readOnly = true)
    @Override
    public UserLoginState get(UserLoginId id, boolean nullAllowed)
    {
        UserLoginState state = (UserLoginState) getCurrentSession().get(AbstractUserLoginState.SimpleUserLoginState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractUserLoginState.SimpleUserLoginState();
            state.setUserLoginId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (UserLoginState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{UserLoginState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    @Override
    public void save(UserLoginState state)
    {
        UserLoginState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (UserLoginState) getReadOnlyProxyGenerator().getTarget(state);
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
    public Iterable<UserLoginState> findByUserId(String userId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractUserLoginState.SimpleUserLoginState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("userLoginId.userId", userId))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(UserLoginState state)
    {
        UserLoginState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (UserLoginState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

