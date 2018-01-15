package org.dddml.wms.domain.party.hibernate;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.party.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernatePartyStateQueryRepository implements PartyStateQueryRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("PartyId", "PartyTypeId", "OrganizationName", "Description", "Type", "IsSummary", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public PartyState get(String id) {

        PartyState state = (PartyState)getCurrentSession().get(AbstractPartyState.SimplePartyState.class, id);
        return state;
    }

    @Transactional(readOnly = true)
    public Iterable<PartyState> getAll(Integer firstResult, Integer maxResults) {
        return getAll(PartyState.class, firstResult, maxResults);
    }
    
    @Transactional(readOnly = true)
    public Iterable<PartyState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return get(PartyState.class, filter, orders, firstResult, maxResults);
    }

    @Transactional(readOnly = true)
    public Iterable<PartyState> get(org.dddml.support.criterion.Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return get(PartyState.class, filter, orders, firstResult, maxResults);
    }

    @Transactional(readOnly = true)
    public PartyState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders) {
        return getFirst(PartyState.class, filter, orders);
    }

    @Transactional(readOnly = true)
    public PartyState getFirst(Map.Entry<String, Object> keyValue, List<String> orders) {
        return getFirst(PartyState.class, keyValue, orders);
    }

    @Transactional(readOnly = true)
    public Iterable<PartyState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getByProperty(PartyState.class, propertyName, propertyValue, orders, firstResult, maxResults);
    }

    @Transactional(readOnly = true)
    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getCount(PartyState.class, filter);
    }

    @Transactional(readOnly = true)
    public long getCount(org.dddml.support.criterion.Criterion filter) {
        return getCount(PartyState.class, filter);
    }
    // //////////////////////////////////////

    @Transactional(readOnly = true)
    public Iterable<PartyState> getAll(Class<? extends PartyState> stateType, Integer firstResult, Integer maxResults)
    {
        Criteria criteria = getCurrentSession().createCriteria(stateType);
        if (firstResult != null) { criteria.setFirstResult(firstResult); }
        if (maxResults != null) { criteria.setMaxResults(maxResults); }
         addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public Iterable<PartyState> get(Class<? extends PartyState> stateType, Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Criteria criteria = getCurrentSession().createCriteria(stateType);

        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
        addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public Iterable<PartyState> get(Class<? extends PartyState> stateType, org.dddml.support.criterion.Criterion filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Criteria criteria = getCurrentSession().createCriteria(stateType);

        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
        addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public PartyState getFirst(Class<? extends PartyState> stateType, Iterable<Map.Entry<String, Object>> filter, List<String> orders)
    {
        List<PartyState> list = (List<PartyState>)get(stateType, filter, orders, 0, 1);
        if (list == null || list.size() <= 0)
        {
            return null;
        }
        return list.get(0);
    }

    @Transactional(readOnly = true)
    public PartyState getFirst(Class<? extends PartyState> stateType, Map.Entry<String, Object> keyValue, List<String> orders)
    {
        List<Map.Entry<String, Object>> filter = new ArrayList<>();
        filter.add(keyValue);
        return getFirst(stateType, filter, orders);
    }

    @Transactional(readOnly = true)
    public Iterable<PartyState> getByProperty(Class<? extends PartyState> stateType, String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Map.Entry<String, Object> keyValue = new java.util.AbstractMap.SimpleEntry<String, Object> (propertyName, propertyValue);
        List<Map.Entry<String, Object>> filter = new ArrayList<Map.Entry<String, Object>>();
        filter.add(keyValue);
        return get(stateType, filter, orders, firstResult, maxResults);
    }

    @Transactional(readOnly = true)
    public long getCount(Class<? extends PartyState> stateType, Iterable<Map.Entry<String, Object>> filter)
    {
        Criteria criteria = getCurrentSession().createCriteria(stateType);
        criteria.setProjection(Projections.rowCount());
        if (filter != null) {
            HibernateUtils.criteriaAddFilter(criteria, filter);
        }
        addNotDeletedRestriction(criteria);
        return (long)criteria.uniqueResult();
    }

    @Transactional(readOnly = true)
    public long getCount(Class<? extends PartyState> stateType, org.dddml.support.criterion.Criterion filter)
    {
        Criteria criteria = getCurrentSession().createCriteria(stateType);
        criteria.setProjection(Projections.rowCount());
        if (filter != null)
        {
            org.hibernate.criterion.Criterion hc = CriterionUtils.toHibernateCriterion(filter);
            criteria.add(hc);
        }
        addNotDeletedRestriction(criteria);
        return (long)criteria.uniqueResult();
    }


    protected static void addNotDeletedRestriction(Criteria criteria) {
        criteria.add(org.hibernate.criterion.Restrictions.eq("deleted", false));
    }

}

