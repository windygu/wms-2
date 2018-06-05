package org.dddml.wms.domain.goodidentificationtype.hibernate;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.goodidentificationtype.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateGoodIdentificationTypeStateRepository implements GoodIdentificationTypeStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("GoodIdentificationTypeId", "ParentTypeId", "HasTable", "Description", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public GoodIdentificationTypeState get(String id, boolean nullAllowed) {
        GoodIdentificationTypeState state = (GoodIdentificationTypeState)getCurrentSession().get(AbstractGoodIdentificationTypeState.SimpleGoodIdentificationTypeState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractGoodIdentificationTypeState.SimpleGoodIdentificationTypeState();
            state.setGoodIdentificationTypeId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (GoodIdentificationTypeState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{GoodIdentificationTypeState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(GoodIdentificationTypeState state)
    {
        GoodIdentificationTypeState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (GoodIdentificationTypeState) getReadOnlyProxyGenerator().getTarget(state);
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
        getCurrentSession().flush();
    }

    //protected static void addNotDeletedRestriction(Criteria criteria) {
    //    criteria.add(org.hibernate.criterion.Restrictions.eq("deleted", false));
    //}

}

