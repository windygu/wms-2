package org.dddml.wms.domain.orderitemmvo.hibernate;

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
import org.dddml.wms.domain.orderitemmvo.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateOrderItemMvoStateRepository implements OrderItemMvoStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("OrderItemId", "ProductId", "ExternalProductId", "Quantity", "CancelQuantity", "SelectedAmount", "ExternalId", "OrderItemTypeId", "OrderItemGroupSeqId", "IsItemGroupPrimary", "FromInventoryItemId", "IsPromo", "QuoteId", "QuoteItemSeqId", "ShoppingListId", "ShoppingListItemSeqId", "UnitPrice", "UnitListPrice", "UnitAverageCost", "UnitRecurringPrice", "IsModifiedPrice", "RecurringFreqUomId", "ItemDescription", "Comments", "CorrespondingPoId", "StatusId", "SyncStatusId", "EstimatedShipDate", "EstimatedDeliveryDate", "AutoCancelDate", "DontCancelSetDate", "DontCancelSetBy", "ShipBeforeDate", "ShipAfterDate", "CancelBackOrderDate", "OverrideGlAccountId", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "OrderOrderTypeId", "OrderOrderName", "OrderExternalId", "OrderSalesChannelEnumId", "OrderOrderDate", "OrderPriority", "OrderEntryDate", "OrderPickSheetPrintedDate", "OrderStatusId", "OrderCurrencyUom", "OrderSyncStatusId", "OrderBillingAccountId", "OrderOriginFacilityId", "OrderWebSiteId", "OrderProductStoreId", "OrderTerminalId", "OrderTransactionId", "OrderAutoOrderShoppingListId", "OrderNeedsInventoryIssuance", "OrderIsRushOrder", "OrderInternalCode", "OrderRemainingSubTotal", "OrderGrandTotal", "OrderInvoicePerShipment", "OrderOrderItems", "OrderVersion", "OrderCreatedBy", "OrderCreatedAt", "OrderUpdatedBy", "OrderUpdatedAt", "OrderActive"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public OrderItemMvoState get(OrderItemId id, boolean nullAllowed) {
        OrderItemMvoState state = (OrderItemMvoState)getCurrentSession().get(AbstractOrderItemMvoState.SimpleOrderItemMvoState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractOrderItemMvoState.SimpleOrderItemMvoState();
            state.setOrderItemId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (OrderItemMvoState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{OrderItemMvoState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(OrderItemMvoState state)
    {
        OrderItemMvoState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (OrderItemMvoState) getReadOnlyProxyGenerator().getTarget(state);
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

