package org.dddml.wms.domain.shipmentitemmvo.hibernate;

import java.util.*;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.shipmentitemmvo.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateShipmentItemMvoStateQueryRepository implements ShipmentItemMvoStateQueryRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("ShipmentItemId", "ProductId", "Quantity", "ShipmentContentDescription", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "ShipmentShipmentTypeId", "ShipmentStatusId", "ShipmentPrimaryOrderId", "ShipmentPrimaryReturnId", "ShipmentPicklistBinId", "ShipmentEstimatedReadyDate", "ShipmentEstimatedShipDate", "ShipmentEstimatedShipWorkEffId", "ShipmentEstimatedArrivalDate", "ShipmentEstimatedArrivalWorkEffId", "ShipmentLatestCancelDate", "ShipmentEstimatedShipCost", "ShipmentCurrencyUomId", "ShipmentHandlingInstructions", "ShipmentOriginFacilityId", "ShipmentDestinationFacilityId", "ShipmentOriginContactMechId", "ShipmentOriginTelecomNumberId", "ShipmentDestinationContactMechId", "ShipmentDestinationTelecomNumberId", "ShipmentPartyIdTo", "ShipmentPartyIdFrom", "ShipmentAdditionalShippingCharge", "ShipmentAddtlShippingChargeDesc", "ShipmentShipmentItems", "ShipmentVersion", "ShipmentCreatedBy", "ShipmentCreatedAt", "ShipmentUpdatedBy", "ShipmentUpdatedAt", "ShipmentActive"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public ShipmentItemMvoState get(ShipmentItemId id) {

        ShipmentItemMvoState state = (ShipmentItemMvoState)getCurrentSession().get(AbstractShipmentItemMvoState.SimpleShipmentItemMvoState.class, id);
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (ShipmentItemMvoState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{ShipmentItemMvoState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    @Transactional(readOnly = true)
    public Iterable<ShipmentItemMvoState> getAll(Integer firstResult, Integer maxResults)
    {
        Criteria criteria = getCurrentSession().createCriteria(ShipmentItemMvoState.class);
        if (firstResult != null) { criteria.setFirstResult(firstResult); }
        if (maxResults != null) { criteria.setMaxResults(maxResults); }
         addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public Iterable<ShipmentItemMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Criteria criteria = getCurrentSession().createCriteria(ShipmentItemMvoState.class);

        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
        addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public Iterable<ShipmentItemMvoState> get(org.dddml.support.criterion.Criterion filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Criteria criteria = getCurrentSession().createCriteria(ShipmentItemMvoState.class);

        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
        addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public ShipmentItemMvoState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders)
    {
        List<ShipmentItemMvoState> list = (List<ShipmentItemMvoState>)get(filter, orders, 0, 1);
        if (list == null || list.size() <= 0)
        {
            return null;
        }
        return list.get(0);
    }

    @Transactional(readOnly = true)
    public ShipmentItemMvoState getFirst(Map.Entry<String, Object> keyValue, List<String> orders)
    {
        List<Map.Entry<String, Object>> filter = new ArrayList<>();
        filter.add(keyValue);
        return getFirst(filter, orders);
    }

    @Transactional(readOnly = true)
    public Iterable<ShipmentItemMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Map.Entry<String, Object> keyValue = new java.util.AbstractMap.SimpleEntry<String, Object> (propertyName, propertyValue);
        List<Map.Entry<String, Object>> filter = new ArrayList<Map.Entry<String, Object>>();
        filter.add(keyValue);
        return get(filter, orders, firstResult, maxResults);
    }

    @Transactional(readOnly = true)
    public long getCount(Iterable<Map.Entry<String, Object>> filter)
    {
        Criteria criteria = getCurrentSession().createCriteria(ShipmentItemMvoState.class);
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
        Criteria criteria = getCurrentSession().createCriteria(ShipmentItemMvoState.class);
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

