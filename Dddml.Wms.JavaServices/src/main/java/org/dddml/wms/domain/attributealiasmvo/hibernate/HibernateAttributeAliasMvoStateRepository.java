package org.dddml.wms.domain.attributealiasmvo.hibernate;

import java.util.*;
import org.dddml.wms.domain.attribute.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.attributealiasmvo.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateAttributeAliasMvoStateRepository implements AttributeAliasMvoStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("AttributeAliasId", "Name", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "AttributeAttributeName", "AttributeOrganizationId", "AttributeDescription", "AttributeIsMandatory", "AttributeAttributeValueType", "AttributeAttributeValueLength", "AttributeIsList", "AttributeFieldName", "AttributeReferenceId", "AttributeAttributeValues", "AttributeAliases", "AttributeVersion", "AttributeCreatedBy", "AttributeCreatedAt", "AttributeUpdatedBy", "AttributeUpdatedAt", "AttributeActive", "AttributeDeleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public AttributeAliasMvoState get(AttributeAliasId id, boolean nullAllowed) {
        AttributeAliasMvoState state = (AttributeAliasMvoState)getCurrentSession().get(AbstractAttributeAliasMvoState.SimpleAttributeAliasMvoState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractAttributeAliasMvoState.SimpleAttributeAliasMvoState();
            state.setAttributeAliasId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (AttributeAliasMvoState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{AttributeAliasMvoState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(AttributeAliasMvoState state)
    {
        AttributeAliasMvoState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (AttributeAliasMvoState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if(s.getAttributeVersion() == null) {
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

