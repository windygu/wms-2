package org.dddml.wms.domain.orderheader.hibernate;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.orderheader.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateOrderHeaderStateRepository implements OrderHeaderStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("OrderId", "OrderTypeId", "OrderName", "ExternalId", "SalesChannelEnumId", "OrderDate", "Priority", "EntryDate", "PickSheetPrintedDate", "StatusId", "CurrencyUom", "SyncStatusId", "BillingAccountId", "OriginFacilityId", "WebSiteId", "ProductStoreId", "TerminalId", "TransactionId", "AutoOrderShoppingListId", "NeedsInventoryIssuance", "IsRushOrder", "InternalCode", "RemainingSubTotal", "GrandTotal", "InvoicePerShipment", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public OrderHeaderState get(String id, boolean nullAllowed) {
        OrderHeaderState state = (OrderHeaderState)getCurrentSession().get(AbstractOrderHeaderState.SimpleOrderHeaderState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractOrderHeaderState.SimpleOrderHeaderState();
            state.setOrderId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (OrderHeaderState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{OrderHeaderState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(OrderHeaderState state)
    {
        OrderHeaderState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (OrderHeaderState) getReadOnlyProxyGenerator().getTarget(state);
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

    //protected static void addNotDeletedRestriction(Criteria criteria) {
    //    criteria.add(org.hibernate.criterion.Restrictions.eq("deleted", false));
    //}

}

