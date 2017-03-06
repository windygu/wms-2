package org.dddml.wms.domain.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateAttributeSetInstanceExtensionFieldStateDao implements AttributeSetInstanceExtensionFieldStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("Index", "Name", "Type", "Length", "Alias", "Description", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "GroupId"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public AttributeSetInstanceExtensionFieldState get(AttributeSetInstanceExtensionFieldId id, boolean nullAllowed)
    {
        AttributeSetInstanceExtensionFieldState state = (AttributeSetInstanceExtensionFieldState) getCurrentSession().get(AbstractAttributeSetInstanceExtensionFieldState.SimpleAttributeSetInstanceExtensionFieldState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractAttributeSetInstanceExtensionFieldState.SimpleAttributeSetInstanceExtensionFieldState();
            state.setAttributeSetInstanceExtensionFieldId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (AttributeSetInstanceExtensionFieldState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{AttributeSetInstanceExtensionFieldState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    @Override
    public void save(AttributeSetInstanceExtensionFieldState state)
    {
        AttributeSetInstanceExtensionFieldState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (AttributeSetInstanceExtensionFieldState) getReadOnlyProxyGenerator().getTarget(state);
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
    public Iterable<AttributeSetInstanceExtensionFieldState> findByGroupId(String groupId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractAttributeSetInstanceExtensionFieldState.SimpleAttributeSetInstanceExtensionFieldState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("attributeSetInstanceExtensionFieldId.groupId", groupId))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(AttributeSetInstanceExtensionFieldState state)
    {
        AttributeSetInstanceExtensionFieldState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (AttributeSetInstanceExtensionFieldState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

