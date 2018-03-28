package org.dddml.wms.domain.ordershipgroupmvo.hibernate;

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
import org.dddml.wms.domain.ordershipgroupmvo.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateOrderShipGroupMvoStateRepository implements OrderShipGroupMvoStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("OrderShipGroupId", "ShipmentMethodTypeId", "SupplierPartyId", "VendorPartyId", "CarrierPartyId", "CarrierRoleTypeId", "FacilityId", "ContactMechId", "TelecomContactMechId", "TrackingNumber", "ShippingInstructions", "MaySplit", "GiftMessage", "IsGift", "ShipAfterDate", "ShipByDate", "EstimatedShipDate", "EstimatedDeliveryDate", "PickwaveId", "OrderItemShipGroupAssociations", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "OrderOrderTypeId", "OrderOrderName", "OrderExternalId", "OrderSalesChannelEnumId", "OrderOrderDate", "OrderPriority", "OrderEntryDate", "OrderPickSheetPrintedDate", "OrderStatusId", "OrderCurrencyUom", "OrderSyncStatusId", "OrderBillingAccountId", "OrderOriginFacilityId", "OrderWebSiteId", "OrderProductStoreId", "OrderTerminalId", "OrderTransactionId", "OrderAutoOrderShoppingListId", "OrderNeedsInventoryIssuance", "OrderIsRushOrder", "OrderInternalCode", "OrderRemainingSubTotal", "OrderGrandTotal", "OrderInvoicePerShipment", "OrderOrderItems", "OrderOrderRoles", "OrderOrderShipGroups", "OrderVersion", "OrderCreatedBy", "OrderCreatedAt", "OrderUpdatedBy", "OrderUpdatedAt", "OrderActive"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public OrderShipGroupMvoState get(OrderShipGroupId id, boolean nullAllowed) {
        OrderShipGroupMvoState state = (OrderShipGroupMvoState)getCurrentSession().get(AbstractOrderShipGroupMvoState.SimpleOrderShipGroupMvoState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractOrderShipGroupMvoState.SimpleOrderShipGroupMvoState();
            state.setOrderShipGroupId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (OrderShipGroupMvoState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{OrderShipGroupMvoState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(OrderShipGroupMvoState state)
    {
        OrderShipGroupMvoState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (OrderShipGroupMvoState) getReadOnlyProxyGenerator().getTarget(state);
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

