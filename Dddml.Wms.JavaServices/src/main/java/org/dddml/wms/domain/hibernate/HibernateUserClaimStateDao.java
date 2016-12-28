package org.dddml.wms.domain.hibernate;

import java.util.Date;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateUserClaimStateDao implements UserClaimStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("ClaimId", "ClaimType", "ClaimValue", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "UserId"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public UserClaimState get(UserClaimId id)
    {
        return get(id, false);
    }

    @Transactional(readOnly = true)
    @Override
    public UserClaimState get(UserClaimId id, boolean nullAllowed)
    {
        UserClaimState state = (UserClaimState) getCurrentSession().get(AbstractUserClaimState.SimpleUserClaimState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractUserClaimState.SimpleUserClaimState();
            state.setUserClaimId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (UserClaimState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{UserClaimState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    @Override
    public void save(UserClaimState state)
    {
        UserClaimState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (UserClaimState) getReadOnlyProxyGenerator().getTarget(state);
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
    public Iterable<UserClaimState> findByUserId(String userId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractUserClaimState.SimpleUserClaimState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("userClaimId.userId", userId))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(UserClaimState state)
    {
        UserClaimState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (UserClaimState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

