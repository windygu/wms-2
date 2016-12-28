package org.dddml.wms.domain.hibernate;

import java.util.Date;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateAttributeUseStateDao implements AttributeUseStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("AttributeId", "SequenceNumber", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "AttributeSetId"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public AttributeUseState get(AttributeSetAttributeUseId id)
    {
        return get(id, false);
    }

    @Transactional(readOnly = true)
    @Override
    public AttributeUseState get(AttributeSetAttributeUseId id, boolean nullAllowed)
    {
        AttributeUseState state = (AttributeUseState) getCurrentSession().get(AbstractAttributeUseState.SimpleAttributeUseState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractAttributeUseState.SimpleAttributeUseState();
            state.setAttributeSetAttributeUseId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (AttributeUseState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{AttributeUseState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    @Override
    public void save(AttributeUseState state)
    {
        AttributeUseState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (AttributeUseState) getReadOnlyProxyGenerator().getTarget(state);
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
    public Iterable<AttributeUseState> findByAttributeSetId(String attributeSetId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractAttributeUseState.SimpleAttributeUseState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("attributeSetAttributeUseId.attributeSetId", attributeSetId))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(AttributeUseState state)
    {
        AttributeUseState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (AttributeUseState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

