package org.dddml.wms.domain.attributesetinstance.hibernate;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.attributesetinstance.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateAttributeSetInstanceStateQueryRepository implements AttributeSetInstanceStateQueryRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("AttributeSetInstanceId", "AttributeSetId", "OrganizationId", "ReferenceId", "SerialNumber", "LotId", "StatusId", "ImageUrl", "Description", "Hash", "WidthInch", "DiameterInch", "WeightLbs", "WeightKg", "AirDryWeightLbs", "AirDryWeightKg", "AirDryMetricTon", "PackageCount", "AirDryPct", "_F_B_0_", "_F_I_0_", "_F_L_0_", "_F_DT_0_", "_F_N_0_", "_F_C5_0_", "_F_C10_0_", "_F_C20_0_", "_F_C50_0_", "_F_C100_0_", "_F_C200_0_", "_F_C500_0_", "_F_C1000_0_", "_F_B_1_", "_F_I_1_", "_F_L_1_", "_F_DT_1_", "_F_N_1_", "_F_C5_1_", "_F_C10_1_", "_F_C20_1_", "_F_C50_1_", "_F_C100_1_", "_F_C200_1_", "_F_B_2_", "_F_I_2_", "_F_L_2_", "_F_DT_2_", "_F_N_2_", "_F_C5_2_", "_F_C10_2_", "_F_C20_2_", "_F_C50_2_", "_F_B_3_", "_F_I_3_", "_F_L_3_", "_F_DT_3_", "_F_N_3_", "_F_C5_3_", "_F_C10_3_", "_F_C20_3_", "_F_C50_3_", "_F_B_4_", "_F_I_4_", "_F_L_4_", "_F_DT_4_", "_F_N_4_", "_F_C5_4_", "_F_C10_4_", "_F_C20_4_", "_F_C50_4_", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public AttributeSetInstanceState get(String id) {

        AttributeSetInstanceState state = (AttributeSetInstanceState)getCurrentSession().get(AbstractAttributeSetInstanceState.SimpleAttributeSetInstanceState.class, id);
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (AttributeSetInstanceState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{AttributeSetInstanceState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    @Transactional(readOnly = true)
    public Iterable<AttributeSetInstanceState> getAll(Integer firstResult, Integer maxResults)
    {
        Criteria criteria = getCurrentSession().createCriteria(AttributeSetInstanceState.class);
        if (firstResult != null) { criteria.setFirstResult(firstResult); }
        if (maxResults != null) { criteria.setMaxResults(maxResults); }
         addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public Iterable<AttributeSetInstanceState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Criteria criteria = getCurrentSession().createCriteria(AttributeSetInstanceState.class);

        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
        addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public Iterable<AttributeSetInstanceState> get(org.dddml.support.criterion.Criterion filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Criteria criteria = getCurrentSession().createCriteria(AttributeSetInstanceState.class);

        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
        addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public AttributeSetInstanceState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders)
    {
        List<AttributeSetInstanceState> list = (List<AttributeSetInstanceState>)get(filter, orders, 0, 1);
        if (list == null || list.size() <= 0)
        {
            return null;
        }
        return list.get(0);
    }

    @Transactional(readOnly = true)
    public AttributeSetInstanceState getFirst(Map.Entry<String, Object> keyValue, List<String> orders)
    {
        List<Map.Entry<String, Object>> filter = new ArrayList<>();
        filter.add(keyValue);
        return getFirst(filter, orders);
    }

    @Transactional(readOnly = true)
    public Iterable<AttributeSetInstanceState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Map.Entry<String, Object> keyValue = new java.util.AbstractMap.SimpleEntry<String, Object> (propertyName, propertyValue);
        List<Map.Entry<String, Object>> filter = new ArrayList<Map.Entry<String, Object>>();
        filter.add(keyValue);
        return get(filter, orders, firstResult, maxResults);
    }

    @Transactional(readOnly = true)
    public long getCount(Iterable<Map.Entry<String, Object>> filter)
    {
        Criteria criteria = getCurrentSession().createCriteria(AttributeSetInstanceState.class);
        criteria.setProjection(Projections.rowCount());
        if (filter != null) {
            HibernateUtils.criteriaAddFilter(criteria, filter);
        }
        addNotDeletedRestriction(criteria);
        return (long)criteria.uniqueResult();
    }

    @Transactional(readOnly = true)
    public long getCount(org.dddml.support.criterion.Criterion filter)
    {
        Criteria criteria = getCurrentSession().createCriteria(AttributeSetInstanceState.class);
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
    }

}

