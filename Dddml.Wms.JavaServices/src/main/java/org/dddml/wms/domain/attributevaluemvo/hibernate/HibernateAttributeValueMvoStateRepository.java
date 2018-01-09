package org.dddml.wms.domain.attributevaluemvo.hibernate;

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
import org.dddml.wms.domain.attributevaluemvo.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateAttributeValueMvoStateRepository implements AttributeValueMvoStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("AttributeValueId", "AttributeValueName", "Description", "ReferenceId", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "AttributeAttributeName", "AttributeOrganizationId", "AttributeDescription", "AttributeIsMandatory", "AttributeAttributeValueType", "AttributeAttributeValueLength", "AttributeIsList", "AttributeFieldName", "AttributeReferenceId", "AttributeAttributeValues", "AttributeAliases", "AttributeVersion", "AttributeCreatedBy", "AttributeCreatedAt", "AttributeUpdatedBy", "AttributeUpdatedAt", "AttributeActive", "AttributeDeleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public AttributeValueMvoState get(AttributeValueId id, boolean nullAllowed) {
        AttributeValueMvoState state = (AttributeValueMvoState)getCurrentSession().get(AbstractAttributeValueMvoState.SimpleAttributeValueMvoState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractAttributeValueMvoState.SimpleAttributeValueMvoState();
            state.setAttributeValueId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (AttributeValueMvoState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{AttributeValueMvoState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(AttributeValueMvoState state)
    {
        AttributeValueMvoState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (AttributeValueMvoState) getReadOnlyProxyGenerator().getTarget(state);
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
        getCurrentSession().flush();
    }

    //protected static void addNotDeletedRestriction(Criteria criteria) {
    //    criteria.add(org.hibernate.criterion.Restrictions.eq("deleted", false));
    //}

}

