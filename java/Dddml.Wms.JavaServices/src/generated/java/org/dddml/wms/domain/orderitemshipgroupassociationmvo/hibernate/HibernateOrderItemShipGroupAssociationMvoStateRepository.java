package org.dddml.wms.domain.orderitemshipgroupassociationmvo.hibernate;

import java.util.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.orderitemshipgroupassociationmvo.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateOrderItemShipGroupAssociationMvoStateRepository implements OrderItemShipGroupAssociationMvoStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("OrderItemShipGroupAssociationId", "Quantity", "CancelQuantity", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "OrderShipGroupShipmentMethodTypeId", "OrderShipGroupSupplierPartyId", "OrderShipGroupVendorPartyId", "OrderShipGroupCarrierPartyId", "OrderShipGroupCarrierRoleTypeId", "OrderShipGroupFacilityId", "OrderShipGroupContactMechId", "OrderShipGroupTelecomContactMechId", "OrderShipGroupTrackingNumber", "OrderShipGroupShippingInstructions", "OrderShipGroupMaySplit", "OrderShipGroupGiftMessage", "OrderShipGroupIsGift", "OrderShipGroupShipAfterDate", "OrderShipGroupShipByDate", "OrderShipGroupEstimatedShipDate", "OrderShipGroupEstimatedDeliveryDate", "OrderShipGroupPickwaveId", "OrderShipGroupOrderItemShipGroupAssociations", "OrderShipGroupVersion", "OrderShipGroupCreatedBy", "OrderShipGroupCreatedAt", "OrderShipGroupUpdatedBy", "OrderShipGroupUpdatedAt", "OrderShipGroupActive", "OrderShipGroupDeleted", "OrderOrderTypeId", "OrderOrderName", "OrderExternalId", "OrderSalesChannelEnumId", "OrderOrderDate", "OrderPriority", "OrderEntryDate", "OrderPickSheetPrintedDate", "OrderStatusId", "OrderCurrencyUom", "OrderSyncStatusId", "OrderBillingAccountId", "OrderOriginFacilityId", "OrderWebSiteId", "OrderProductStoreId", "OrderTerminalId", "OrderTransactionId", "OrderAutoOrderShoppingListId", "OrderNeedsInventoryIssuance", "OrderIsRushOrder", "OrderInternalCode", "OrderRemainingSubTotal", "OrderGrandTotal", "OrderInvoicePerShipment", "OrderOrderItems", "OrderOrderRoles", "OrderOrderShipGroups", "OrderVersion", "OrderCreatedBy", "OrderCreatedAt", "OrderUpdatedBy", "OrderUpdatedAt", "OrderActive"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public OrderItemShipGroupAssociationMvoState get(OrderItemShipGroupAssociationId id, boolean nullAllowed) {
        OrderItemShipGroupAssociationMvoState state = (OrderItemShipGroupAssociationMvoState)getCurrentSession().get(AbstractOrderItemShipGroupAssociationMvoState.SimpleOrderItemShipGroupAssociationMvoState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractOrderItemShipGroupAssociationMvoState.SimpleOrderItemShipGroupAssociationMvoState();
            state.setOrderItemShipGroupAssociationId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (OrderItemShipGroupAssociationMvoState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{OrderItemShipGroupAssociationMvoState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(OrderItemShipGroupAssociationMvoState state)
    {
        OrderItemShipGroupAssociationMvoState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (OrderItemShipGroupAssociationMvoState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if(s.getOrderVersion() == null) {
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

