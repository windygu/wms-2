package org.dddml.wms.domain.shipment.hibernate;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.shipment.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateShipmentStateQueryRepository implements ShipmentStateQueryRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("ShipmentId", "ShipmentTypeId", "StatusId", "PrimaryOrderId", "PrimaryReturnId", "PrimaryShipGroupSeqId", "PicklistBinId", "EstimatedReadyDate", "EstimatedShipDate", "EstimatedShipWorkEffId", "EstimatedArrivalDate", "EstimatedArrivalWorkEffId", "LatestCancelDate", "EstimatedShipCost", "CurrencyUomId", "HandlingInstructions", "OriginFacilityId", "DestinationFacilityId", "OriginContactMechId", "OriginTelecomNumberId", "DestinationContactMechId", "DestinationTelecomNumberId", "PartyIdTo", "PartyIdFrom", "AdditionalShippingCharge", "AddtlShippingChargeDesc", "ShipmentItems", "ShipmentReceipts", "ItemIssuances", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public ShipmentState get(String id) {

        ShipmentState state = (ShipmentState)getCurrentSession().get(AbstractShipmentState.SimpleShipmentState.class, id);
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (ShipmentState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{ShipmentState.class, Saveable.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    @Transactional(readOnly = true)
    public Iterable<ShipmentState> getAll(Integer firstResult, Integer maxResults)
    {
        Criteria criteria = getCurrentSession().createCriteria(ShipmentState.class);
        if (firstResult != null) { criteria.setFirstResult(firstResult); }
        if (maxResults != null) { criteria.setMaxResults(maxResults); }
         addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public Iterable<ShipmentState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Criteria criteria = getCurrentSession().createCriteria(ShipmentState.class);

        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
        addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public Iterable<ShipmentState> get(org.dddml.support.criterion.Criterion filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Criteria criteria = getCurrentSession().createCriteria(ShipmentState.class);

        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
        addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public ShipmentState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders)
    {
        List<ShipmentState> list = (List<ShipmentState>)get(filter, orders, 0, 1);
        if (list == null || list.size() <= 0)
        {
            return null;
        }
        return list.get(0);
    }

    @Transactional(readOnly = true)
    public ShipmentState getFirst(Map.Entry<String, Object> keyValue, List<String> orders)
    {
        List<Map.Entry<String, Object>> filter = new ArrayList<>();
        filter.add(keyValue);
        return getFirst(filter, orders);
    }

    @Transactional(readOnly = true)
    public Iterable<ShipmentState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Map.Entry<String, Object> keyValue = new java.util.AbstractMap.SimpleEntry<String, Object> (propertyName, propertyValue);
        List<Map.Entry<String, Object>> filter = new ArrayList<Map.Entry<String, Object>>();
        filter.add(keyValue);
        return get(filter, orders, firstResult, maxResults);
    }

    @Transactional(readOnly = true)
    public long getCount(Iterable<Map.Entry<String, Object>> filter)
    {
        Criteria criteria = getCurrentSession().createCriteria(ShipmentState.class);
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
        Criteria criteria = getCurrentSession().createCriteria(ShipmentState.class);
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
    public ShipmentItemState getShipmentItem(String shipmentId, String shipmentItemSeqId)
    {
        ShipmentItemId entityId = new ShipmentItemId(shipmentId, shipmentItemSeqId);
        return (ShipmentItemState) getCurrentSession().get(AbstractShipmentItemState.SimpleShipmentItemState.class, entityId);
    }

    @Transactional(readOnly = true)
    public ShipmentReceiptState getShipmentReceipt(String shipmentId, String receiptSeqId)
    {
        ShipmentReceiptId entityId = new ShipmentReceiptId(shipmentId, receiptSeqId);
        return (ShipmentReceiptState) getCurrentSession().get(AbstractShipmentReceiptState.SimpleShipmentReceiptState.class, entityId);
    }

    @Transactional(readOnly = true)
    public ItemIssuanceState getItemIssuance(String shipmentId, String itemIssuanceSeqId)
    {
        ShipmentItemIssuanceId entityId = new ShipmentItemIssuanceId(shipmentId, itemIssuanceSeqId);
        return (ItemIssuanceState) getCurrentSession().get(AbstractItemIssuanceState.SimpleItemIssuanceState.class, entityId);
    }


    protected static void addNotDeletedRestriction(Criteria criteria) {
    }

}

