package org.dddml.wms.domain.picklistrolemvo.hibernate;

import java.util.*;
import org.dddml.wms.domain.picklist.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.picklistrolemvo.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernatePicklistRoleMvoStateRepository implements PicklistRoleMvoStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("PicklistRoleId", "CreatedByUserLogin", "LastModifiedByUserLogin", "Version", "CreatedAt", "UpdatedAt", "Active", "Deleted", "PicklistDescription", "PicklistFacilityId", "PicklistShipmentMethodTypeId", "PicklistStatusId", "PicklistPicklistDate", "PicklistCreatedByUserLogin", "PicklistLastModifiedByUserLogin", "PicklistPicklistRoles", "PicklistVersion", "PicklistCreatedAt", "PicklistUpdatedAt", "PicklistActive", "PicklistDeleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public PicklistRoleMvoState get(PicklistRoleId id, boolean nullAllowed) {
        PicklistRoleMvoState state = (PicklistRoleMvoState)getCurrentSession().get(AbstractPicklistRoleMvoState.SimplePicklistRoleMvoState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractPicklistRoleMvoState.SimplePicklistRoleMvoState();
            state.setPicklistRoleId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (PicklistRoleMvoState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{PicklistRoleMvoState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(PicklistRoleMvoState state)
    {
        PicklistRoleMvoState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (PicklistRoleMvoState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if(s.getPicklistVersion() == null) {
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

