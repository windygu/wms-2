package org.dddml.wms.domain.picklist.hibernate;

import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.picklist.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernatePicklistRoleStateDao implements PicklistRoleStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("PartyRoleId", "CreatedByUserLogin", "LastModifiedByUserLogin", "Version", "CreatedAt", "UpdatedAt", "Active", "Deleted", "PicklistId"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public PicklistRoleState get(PicklistRoleId id, boolean nullAllowed)
    {
        PicklistRoleState state = (PicklistRoleState) getCurrentSession().get(AbstractPicklistRoleState.SimplePicklistRoleState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractPicklistRoleState.SimplePicklistRoleState();
            state.setPicklistRoleId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (PicklistRoleState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{PicklistRoleState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    @Override
    public void save(PicklistRoleState state)
    {
        PicklistRoleState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (PicklistRoleState) getReadOnlyProxyGenerator().getTarget(state);
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
    public Iterable<PicklistRoleState> findByPicklistId(String picklistId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractPicklistRoleState.SimplePicklistRoleState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("picklistRoleId.picklistId", picklistId))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(PicklistRoleState state)
    {
        PicklistRoleState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (PicklistRoleState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

