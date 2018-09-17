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
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("ShipmentId", "ShipmentTypeId", "StatusId", "PrimaryOrderId", "PrimaryReturnId", "PrimaryShipGroupSeqId", "OnlyOneOrder", "OnlyOneOrderShipGroup", "PicklistBinId", "BolNumber", "SealNumber", "VehicleId", "ExternalOrderNumber", "Carrier", "DateShipped", "IsCreatedFromPackingList", "EstimatedReadyDate", "EstimatedShipDate", "EstimatedShipWorkEffId", "EstimatedArrivalDate", "EstimatedArrivalWorkEffId", "LatestCancelDate", "EstimatedShipCost", "CurrencyUomId", "HandlingInstructions", "OriginFacilityId", "DestinationFacilityId", "OriginContactMechId", "OriginTelecomNumberId", "DestinationContactMechId", "DestinationTelecomNumberId", "PartyIdTo", "PartyIdFrom", "AdditionalShippingCharge", "AddtlShippingChargeDesc", "ShipmentItems", "ShipmentReceipts", "ItemIssuances", "ShipmentImages", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
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
    public ShipmentImageState getShipmentImage(String shipmentId, String sequenceId) {
        ShipmentImageId entityId = new ShipmentImageId(shipmentId, sequenceId);
        return (ShipmentImageState) getCurrentSession().get(AbstractShipmentImageState.SimpleShipmentImageState.class, entityId);
    }

    @Transactional(readOnly = true)
    public Iterable<ShipmentImageState> getShipmentImages(String shipmentId, org.dddml.support.criterion.Criterion filter, List<String> orders) {
        Criteria criteria = getCurrentSession().createCriteria(AbstractShipmentImageState.SimpleShipmentImageState.class);
        org.hibernate.criterion.Junction partIdCondition = org.hibernate.criterion.Restrictions.conjunction()
            .add(org.hibernate.criterion.Restrictions.eq("shipmentImageId.shipmentId", shipmentId))
            ;
        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, 0, Integer.MAX_VALUE);
        return criteria.add(partIdCondition).list();
    }

    @Transactional(readOnly = true)
    public ShipmentItemState getShipmentItem(String shipmentId, String shipmentItemSeqId) {
        ShipmentItemId entityId = new ShipmentItemId(shipmentId, shipmentItemSeqId);
        return (ShipmentItemState) getCurrentSession().get(AbstractShipmentItemState.SimpleShipmentItemState.class, entityId);
    }

    @Transactional(readOnly = true)
    public Iterable<ShipmentItemState> getShipmentItems(String shipmentId, org.dddml.support.criterion.Criterion filter, List<String> orders) {
        Criteria criteria = getCurrentSession().createCriteria(AbstractShipmentItemState.SimpleShipmentItemState.class);
        org.hibernate.criterion.Junction partIdCondition = org.hibernate.criterion.Restrictions.conjunction()
            .add(org.hibernate.criterion.Restrictions.eq("shipmentItemId.shipmentId", shipmentId))
            ;
        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, 0, Integer.MAX_VALUE);
        return criteria.add(partIdCondition).list();
    }

    @Transactional(readOnly = true)
    public ShipmentReceiptState getShipmentReceipt(String shipmentId, String receiptSeqId) {
        ShipmentReceiptId entityId = new ShipmentReceiptId(shipmentId, receiptSeqId);
        return (ShipmentReceiptState) getCurrentSession().get(AbstractShipmentReceiptState.SimpleShipmentReceiptState.class, entityId);
    }

    @Transactional(readOnly = true)
    public Iterable<ShipmentReceiptState> getShipmentReceipts(String shipmentId, org.dddml.support.criterion.Criterion filter, List<String> orders) {
        Criteria criteria = getCurrentSession().createCriteria(AbstractShipmentReceiptState.SimpleShipmentReceiptState.class);
        org.hibernate.criterion.Junction partIdCondition = org.hibernate.criterion.Restrictions.conjunction()
            .add(org.hibernate.criterion.Restrictions.eq("shipmentReceiptId.shipmentId", shipmentId))
            ;
        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, 0, Integer.MAX_VALUE);
        return criteria.add(partIdCondition).list();
    }

    @Transactional(readOnly = true)
    public ShipmentReceiptImageState getShipmentReceiptImage(String shipmentId, String shipmentReceiptReceiptSeqId, String sequenceId) {
        ShipmentReceiptImageId entityId = new ShipmentReceiptImageId(shipmentId, shipmentReceiptReceiptSeqId, sequenceId);
        return (ShipmentReceiptImageState) getCurrentSession().get(AbstractShipmentReceiptImageState.SimpleShipmentReceiptImageState.class, entityId);
    }

    @Transactional(readOnly = true)
    public Iterable<ShipmentReceiptImageState> getShipmentReceiptImages(String shipmentId, String shipmentReceiptReceiptSeqId, org.dddml.support.criterion.Criterion filter, List<String> orders) {
        Criteria criteria = getCurrentSession().createCriteria(AbstractShipmentReceiptImageState.SimpleShipmentReceiptImageState.class);
        org.hibernate.criterion.Junction partIdCondition = org.hibernate.criterion.Restrictions.conjunction()
            .add(org.hibernate.criterion.Restrictions.eq("shipmentReceiptImageId.shipmentId", shipmentId))
            .add(org.hibernate.criterion.Restrictions.eq("shipmentReceiptImageId.shipmentReceiptReceiptSeqId", shipmentReceiptReceiptSeqId))
            ;
        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, 0, Integer.MAX_VALUE);
        return criteria.add(partIdCondition).list();
    }

    @Transactional(readOnly = true)
    public ItemIssuanceState getItemIssuance(String shipmentId, String itemIssuanceSeqId) {
        ShipmentItemIssuanceId entityId = new ShipmentItemIssuanceId(shipmentId, itemIssuanceSeqId);
        return (ItemIssuanceState) getCurrentSession().get(AbstractItemIssuanceState.SimpleItemIssuanceState.class, entityId);
    }

    @Transactional(readOnly = true)
    public Iterable<ItemIssuanceState> getItemIssuances(String shipmentId, org.dddml.support.criterion.Criterion filter, List<String> orders) {
        Criteria criteria = getCurrentSession().createCriteria(AbstractItemIssuanceState.SimpleItemIssuanceState.class);
        org.hibernate.criterion.Junction partIdCondition = org.hibernate.criterion.Restrictions.conjunction()
            .add(org.hibernate.criterion.Restrictions.eq("shipmentItemIssuanceId.shipmentId", shipmentId))
            ;
        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, 0, Integer.MAX_VALUE);
        return criteria.add(partIdCondition).list();
    }


    protected static void addNotDeletedRestriction(Criteria criteria) {
    }

}

