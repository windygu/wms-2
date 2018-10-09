package org.dddml.wms.domain.order.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.order.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateOrderItemStateDao implements OrderItemStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("OrderItemSeqId", "ProductId", "ExternalProductId", "Quantity", "CancelQuantity", "SelectedAmount", "ExternalId", "OrderItemTypeId", "OrderItemGroupSeqId", "IsItemGroupPrimary", "FromInventoryItemId", "IsPromo", "QuoteId", "QuoteItemSeqId", "ShoppingListId", "ShoppingListItemSeqId", "UnitPrice", "UnitListPrice", "UnitAverageCost", "UnitRecurringPrice", "IsModifiedPrice", "RecurringFreqUomId", "ItemDescription", "Comments", "CorrespondingPoId", "StatusId", "SyncStatusId", "EstimatedShipDate", "EstimatedDeliveryDate", "AutoCancelDate", "DontCancelSetDate", "DontCancelSetBy", "ShipBeforeDate", "ShipAfterDate", "CancelBackOrderDate", "OverrideGlAccountId", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "OrderId"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public OrderItemState get(OrderItemId id, boolean nullAllowed)
    {
        OrderItemState.SqlOrderItemState state = (OrderItemState.SqlOrderItemState) getCurrentSession().get(AbstractOrderItemState.SimpleOrderItemState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractOrderItemState.SimpleOrderItemState();
            state.setOrderItemId(id);
        }
        //if (getReadOnlyProxyGenerator() != null && state != null) {
        //    return (OrderItemState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{OrderItemState.SqlOrderItemState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        //}
        return state;
    }

    @Override
    public void save(OrderItemState state)
    {
        OrderItemState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (OrderItemState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if(s.getVersion() == null) {
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
    @Override
    public Iterable<OrderItemState> findByOrderId(String orderId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractOrderItemState.SimpleOrderItemState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("orderItemId.orderId", orderId))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(OrderItemState state)
    {
        OrderItemState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (OrderItemState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

