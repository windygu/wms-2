package org.dddml.wms.domain.hibernate;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.joda.money.Money;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateInOutLineMvoStateRepository implements InOutLineMvoStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("InOutLineId", "LineNumber", "Description", "LocatorId", "Product", "UomId", "MovementQuantity", "ConfirmedQuantity", "ScrappedQuantity", "TargetQuantity", "PickedQuantity", "IsInvoiced", "AttributeSetInstanceId", "IsDescription", "Processed", "QuantityEntered", "RmaLineNumber", "ReversalLineNumber", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "InOutIsSOTransaction", "InOutDocumentStatus", "InOutPosted", "InOutProcessing", "InOutProcessed", "InOutDocumentType", "InOutDescription", "InOutOrderNumber", "InOutDateOrdered", "InOutIsPrinted", "InOutMovementType", "InOutMovementDate", "InOutBusinessPartnerId", "InOutWarehouseId", "InOutPOReference", "InOutFreightAmount", "InOutShipperId", "InOutChargeAmount", "InOutDatePrinted", "InOutSalesRepresentative", "InOutNumberOfPackages", "InOutPickDate", "InOutShipDate", "InOutTrackingNumber", "InOutDateReceived", "InOutIsInTransit", "InOutIsApproved", "InOutIsInDispute", "InOutVolume", "InOutWeight", "InOutRmaNumber", "InOutReversalNumber", "InOutIsDropShip", "InOutDropShipBusinessPartnerId", "InOutInOutLines", "InOutVersion", "InOutCreatedBy", "InOutCreatedAt", "InOutUpdatedBy", "InOutUpdatedAt", "InOutActive", "InOutDeleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public InOutLineMvoState get(InOutLineId id)
    {
        return get(id, false);
    }

    @Transactional(readOnly = true)
    public InOutLineMvoState get(InOutLineId id, boolean nullAllowed)
    {
        InOutLineMvoState state = (InOutLineMvoState)getCurrentSession().get(AbstractInOutLineMvoState.SimpleInOutLineMvoState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractInOutLineMvoState.SimpleInOutLineMvoState();
            state.setInOutLineId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (InOutLineMvoState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{InOutLineMvoState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    @Transactional(readOnly = true)
    public Iterable<InOutLineMvoState> getAll(Integer firstResult, Integer maxResults)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractInOutLineMvoState.SimpleInOutLineMvoState.class);
        if (firstResult != null) { criteria.setFirstResult(firstResult); }
        if (maxResults != null) { criteria.setMaxResults(maxResults); }
         addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    public void save(InOutLineMvoState state)
    {
        InOutLineMvoState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (InOutLineMvoState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if(s.getInOutVersion() == null) {
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
    public Iterable<InOutLineMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Criteria criteria = getCurrentSession().createCriteria(InOutLineMvoState.class);

        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
        addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public Iterable<InOutLineMvoState> get(org.dddml.support.criterion.Criterion filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Criteria criteria = getCurrentSession().createCriteria(InOutLineMvoState.class);

        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
        addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public InOutLineMvoState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders)
    {
        List<InOutLineMvoState> list = (List<InOutLineMvoState>)get(filter, orders, 0, 1);
        if (list == null || list.size() <= 0)
        {
            return null;
        }
        return list.get(0);
    }

    @Transactional(readOnly = true)
    public InOutLineMvoState getFirst(Map.Entry<String, Object> keyValue, List<String> orders)
    {
        List<Map.Entry<String, Object>> filter = new ArrayList<>();
        filter.add(keyValue);
        return getFirst(filter, orders);
    }

    @Transactional(readOnly = true)
    public Iterable<InOutLineMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Map.Entry<String, Object> keyValue = new java.util.AbstractMap.SimpleEntry<String, Object> (propertyName, propertyValue);
        List<Map.Entry<String, Object>> filter = new ArrayList<Map.Entry<String, Object>>();
        filter.add(keyValue);
        return get(filter, orders, firstResult, maxResults);
    }

    @Transactional(readOnly = true)
    public long getCount(Iterable<Map.Entry<String, Object>> filter)
    {
        Criteria criteria = getCurrentSession().createCriteria(InOutLineMvoState.class);
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
        Criteria criteria = getCurrentSession().createCriteria(InOutLineMvoState.class);
        criteria.setProjection(Projections.rowCount());
        if (filter != null)
        {
            org.hibernate.criterion.Criterion hc = CriterionUtils.toHibernateCriterion(filter);
            criteria.add(hc);
        }
        addNotDeletedRestriction(criteria);
        return (long)criteria.uniqueResult();
    }


    protected static void addNotDeletedRestriction(Criteria criteria)
    {
        criteria.add(org.hibernate.criterion.Restrictions.eq("deleted", false));
    }

}

