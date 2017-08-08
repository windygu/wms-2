package org.dddml.wms.domain.attributesetinstanceextensionfieldmvo.hibernate;

import java.util.*;
import org.dddml.wms.domain.attributesetinstanceextensionfieldgroup.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.attributesetinstanceextensionfieldmvo.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateAttributeSetInstanceExtensionFieldMvoStateRepository implements AttributeSetInstanceExtensionFieldMvoStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("AttributeSetInstanceExtensionFieldId", "Name", "Type", "Length", "Alias", "Description", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "AttrSetInstEFGroupFieldType", "AttrSetInstEFGroupFieldLength", "AttrSetInstEFGroupFieldCount", "AttrSetInstEFGroupNameFormat", "AttrSetInstEFGroupDescription", "AttrSetInstEFGroupFields", "AttrSetInstEFGroupVersion", "AttrSetInstEFGroupCreatedBy", "AttrSetInstEFGroupCreatedAt", "AttrSetInstEFGroupUpdatedBy", "AttrSetInstEFGroupUpdatedAt", "AttrSetInstEFGroupActive", "AttrSetInstEFGroupDeleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public AttributeSetInstanceExtensionFieldMvoState get(AttributeSetInstanceExtensionFieldId id, boolean nullAllowed) {
        AttributeSetInstanceExtensionFieldMvoState state = (AttributeSetInstanceExtensionFieldMvoState)getCurrentSession().get(AbstractAttributeSetInstanceExtensionFieldMvoState.SimpleAttributeSetInstanceExtensionFieldMvoState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractAttributeSetInstanceExtensionFieldMvoState.SimpleAttributeSetInstanceExtensionFieldMvoState();
            state.setAttributeSetInstanceExtensionFieldId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (AttributeSetInstanceExtensionFieldMvoState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{AttributeSetInstanceExtensionFieldMvoState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(AttributeSetInstanceExtensionFieldMvoState state)
    {
        AttributeSetInstanceExtensionFieldMvoState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (AttributeSetInstanceExtensionFieldMvoState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if(s.getAttrSetInstEFGroupVersion() == null) {
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

