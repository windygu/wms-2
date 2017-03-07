package org.dddml.wms.domain.attributeset.hibernate;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.attributeset.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateAttributeSetStateRepository implements AttributeSetStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("AttributeSetId", "Name", "OrganizationId", "Description", "SerialNumberAttributeId", "LotAttributeId", "ReferenceId", "AttributeUses", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public AttributeSetState get(String id, boolean nullAllowed)
    {
        AttributeSetState state = (AttributeSetState)getCurrentSession().get(AbstractAttributeSetState.SimpleAttributeSetState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractAttributeSetState.SimpleAttributeSetState();
            state.setAttributeSetId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (AttributeSetState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{AttributeSetState.class, Saveable.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(AttributeSetState state)
    {
        AttributeSetState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (AttributeSetState) getReadOnlyProxyGenerator().getTarget(state);
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

    //protected static void addNotDeletedRestriction(Criteria criteria) {
    //    criteria.add(org.hibernate.criterion.Restrictions.eq("deleted", false));
    //}

}

