package org.dddml.wms.domain.attributeusemvo.hibernate;

import java.util.*;
import org.dddml.wms.domain.attributeset.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.attributeusemvo.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateAttributeUseMvoStateRepository implements AttributeUseMvoStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("AttributeSetAttributeUseId", "SequenceNumber", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "AttributeSetAttributeSetName", "AttributeSetOrganizationId", "AttributeSetDescription", "AttributeSetReferenceId", "AttributeSetIsInstanceAttributeSet", "AttributeSetIsMandatory", "AttributeSetAttributeUses", "AttributeSetVersion", "AttributeSetCreatedBy", "AttributeSetCreatedAt", "AttributeSetUpdatedBy", "AttributeSetUpdatedAt", "AttributeSetActive", "AttributeSetDeleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public AttributeUseMvoState get(AttributeSetAttributeUseId id, boolean nullAllowed) {
        AttributeUseMvoState state = (AttributeUseMvoState)getCurrentSession().get(AbstractAttributeUseMvoState.SimpleAttributeUseMvoState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractAttributeUseMvoState.SimpleAttributeUseMvoState();
            state.setAttributeSetAttributeUseId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (AttributeUseMvoState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{AttributeUseMvoState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(AttributeUseMvoState state)
    {
        AttributeUseMvoState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (AttributeUseMvoState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if(s.getAttributeSetVersion() == null) {
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

