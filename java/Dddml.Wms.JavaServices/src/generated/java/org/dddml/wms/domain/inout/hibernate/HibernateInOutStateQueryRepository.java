package org.dddml.wms.domain.inout.hibernate;

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
import org.dddml.wms.domain.inout.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateInOutStateQueryRepository implements InOutStateQueryRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("DocumentNumber", "DocumentStatusId", "Posted", "Processed", "Processing", "DocumentTypeId", "Description", "OrderId", "DateOrdered", "IsPrinted", "MovementTypeId", "MovementDate", "BusinessPartnerId", "WarehouseId", "POReference", "FreightAmount", "ShipperId", "ChargeAmount", "DatePrinted", "CreatedFrom", "SalesRepresentativeId", "NumberOfPackages", "PickDate", "ShipDate", "TrackingNumber", "DateReceived", "IsInTransit", "IsApproved", "IsInDispute", "RmaDocumentNumber", "ReversalDocumentNumber", "InOutLines", "InOutImages", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public InOutState get(String id) {

        InOutState state = (InOutState)getCurrentSession().get(AbstractInOutState.SimpleInOutState.class, id);
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (InOutState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{InOutState.SqlInOutState.class, Saveable.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    @Transactional(readOnly = true)
    public Iterable<InOutState> getAll(Integer firstResult, Integer maxResults)
    {
        Criteria criteria = getCurrentSession().createCriteria(InOutState.class);
        if (firstResult != null) { criteria.setFirstResult(firstResult); }
        if (maxResults != null) { criteria.setMaxResults(maxResults); }
         addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public Iterable<InOutState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Criteria criteria = getCurrentSession().createCriteria(InOutState.class);

        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
        addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public Iterable<InOutState> get(org.dddml.support.criterion.Criterion filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Criteria criteria = getCurrentSession().createCriteria(InOutState.class);

        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
        addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public InOutState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders)
    {
        List<InOutState> list = (List<InOutState>)get(filter, orders, 0, 1);
        if (list == null || list.size() <= 0)
        {
            return null;
        }
        return list.get(0);
    }

    @Transactional(readOnly = true)
    public InOutState getFirst(Map.Entry<String, Object> keyValue, List<String> orders)
    {
        List<Map.Entry<String, Object>> filter = new ArrayList<>();
        filter.add(keyValue);
        return getFirst(filter, orders);
    }

    @Transactional(readOnly = true)
    public Iterable<InOutState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Map.Entry<String, Object> keyValue = new java.util.AbstractMap.SimpleEntry<String, Object> (propertyName, propertyValue);
        List<Map.Entry<String, Object>> filter = new ArrayList<Map.Entry<String, Object>>();
        filter.add(keyValue);
        return get(filter, orders, firstResult, maxResults);
    }

    @Transactional(readOnly = true)
    public long getCount(Iterable<Map.Entry<String, Object>> filter)
    {
        Criteria criteria = getCurrentSession().createCriteria(InOutState.class);
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
        Criteria criteria = getCurrentSession().createCriteria(InOutState.class);
        criteria.setProjection(Projections.rowCount());
        if (filter != null)
        {
            org.hibernate.criterion.Criterion hc = CriterionUtils.toHibernateCriterion(filter);
            criteria.add(hc);
        }
        addNotDeletedRestriction(criteria);
        return (long)criteria.uniqueResult();
    }

    @Transactional(readOnly = true)
    public InOutImageState getInOutImage(String inOutDocumentNumber, String sequenceId) {
        InOutImageId entityId = new InOutImageId(inOutDocumentNumber, sequenceId);
        return (InOutImageState) getCurrentSession().get(AbstractInOutImageState.SimpleInOutImageState.class, entityId);
    }

    @Transactional(readOnly = true)
    public Iterable<InOutImageState> getInOutImages(String inOutDocumentNumber, org.dddml.support.criterion.Criterion filter, List<String> orders) {
        Criteria criteria = getCurrentSession().createCriteria(AbstractInOutImageState.SimpleInOutImageState.class);
        org.hibernate.criterion.Junction partIdCondition = org.hibernate.criterion.Restrictions.conjunction()
            .add(org.hibernate.criterion.Restrictions.eq("inOutImageId.inOutDocumentNumber", inOutDocumentNumber))
            ;
        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, 0, Integer.MAX_VALUE);
        return criteria.add(partIdCondition).list();
    }

    @Transactional(readOnly = true)
    public InOutLineState getInOutLine(String inOutDocumentNumber, String lineNumber) {
        InOutLineId entityId = new InOutLineId(inOutDocumentNumber, lineNumber);
        return (InOutLineState) getCurrentSession().get(AbstractInOutLineState.SimpleInOutLineState.class, entityId);
    }

    @Transactional(readOnly = true)
    public Iterable<InOutLineState> getInOutLines(String inOutDocumentNumber, org.dddml.support.criterion.Criterion filter, List<String> orders) {
        Criteria criteria = getCurrentSession().createCriteria(AbstractInOutLineState.SimpleInOutLineState.class);
        org.hibernate.criterion.Junction partIdCondition = org.hibernate.criterion.Restrictions.conjunction()
            .add(org.hibernate.criterion.Restrictions.eq("inOutLineId.inOutDocumentNumber", inOutDocumentNumber))
            ;
        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, 0, Integer.MAX_VALUE);
        return criteria.add(partIdCondition).list();
    }

    @Transactional(readOnly = true)
    public InOutLineImageState getInOutLineImage(String inOutDocumentNumber, String inOutLineLineNumber, String sequenceId) {
        InOutLineImageId entityId = new InOutLineImageId(inOutDocumentNumber, inOutLineLineNumber, sequenceId);
        return (InOutLineImageState) getCurrentSession().get(AbstractInOutLineImageState.SimpleInOutLineImageState.class, entityId);
    }

    @Transactional(readOnly = true)
    public Iterable<InOutLineImageState> getInOutLineImages(String inOutDocumentNumber, String inOutLineLineNumber, org.dddml.support.criterion.Criterion filter, List<String> orders) {
        Criteria criteria = getCurrentSession().createCriteria(AbstractInOutLineImageState.SimpleInOutLineImageState.class);
        org.hibernate.criterion.Junction partIdCondition = org.hibernate.criterion.Restrictions.conjunction()
            .add(org.hibernate.criterion.Restrictions.eq("inOutLineImageId.inOutDocumentNumber", inOutDocumentNumber))
            .add(org.hibernate.criterion.Restrictions.eq("inOutLineImageId.inOutLineLineNumber", inOutLineLineNumber))
            ;
        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, 0, Integer.MAX_VALUE);
        return criteria.add(partIdCondition).list();
    }


    protected static void addNotDeletedRestriction(Criteria criteria) {
    }

}

