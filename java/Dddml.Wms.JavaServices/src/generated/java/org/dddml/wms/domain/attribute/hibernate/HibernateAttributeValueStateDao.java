package org.dddml.wms.domain.attribute.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.attribute.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateAttributeValueStateDao implements AttributeValueStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("Value", "AttributeValueName", "Description", "ReferenceId", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "AttributeId"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public AttributeValueState get(AttributeValueId id, boolean nullAllowed)
    {
        AttributeValueState.SqlAttributeValueState state = (AttributeValueState.SqlAttributeValueState) getCurrentSession().get(AbstractAttributeValueState.SimpleAttributeValueState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractAttributeValueState.SimpleAttributeValueState();
            state.setAttributeValueId(id);
        }
        //if (getReadOnlyProxyGenerator() != null && state != null) {
        //    return (AttributeValueState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{AttributeValueState.SqlAttributeValueState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        //}
        return state;
    }

    @Override
    public void save(AttributeValueState state)
    {
        AttributeValueState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (AttributeValueState) getReadOnlyProxyGenerator().getTarget(state);
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
    public Iterable<AttributeValueState> findByAttributeId(String attributeId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractAttributeValueState.SimpleAttributeValueState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("attributeValueId.attributeId", attributeId))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(AttributeValueState state)
    {
        AttributeValueState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (AttributeValueState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

