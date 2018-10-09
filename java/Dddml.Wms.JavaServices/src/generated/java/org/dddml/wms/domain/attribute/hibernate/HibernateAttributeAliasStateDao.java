package org.dddml.wms.domain.attribute.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.attribute.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateAttributeAliasStateDao implements AttributeAliasStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("Code", "Name", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "AttributeId"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public AttributeAliasState get(AttributeAliasId id, boolean nullAllowed)
    {
        AttributeAliasState.SqlAttributeAliasState state = (AttributeAliasState.SqlAttributeAliasState) getCurrentSession().get(AbstractAttributeAliasState.SimpleAttributeAliasState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractAttributeAliasState.SimpleAttributeAliasState();
            state.setAttributeAliasId(id);
        }
        //if (getReadOnlyProxyGenerator() != null && state != null) {
        //    return (AttributeAliasState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{AttributeAliasState.SqlAttributeAliasState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        //}
        return state;
    }

    @Override
    public void save(AttributeAliasState state)
    {
        AttributeAliasState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (AttributeAliasState) getReadOnlyProxyGenerator().getTarget(state);
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
    public Iterable<AttributeAliasState> findByAttributeId(String attributeId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractAttributeAliasState.SimpleAttributeAliasState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("attributeAliasId.attributeId", attributeId))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(AttributeAliasState state)
    {
        AttributeAliasState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (AttributeAliasState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

