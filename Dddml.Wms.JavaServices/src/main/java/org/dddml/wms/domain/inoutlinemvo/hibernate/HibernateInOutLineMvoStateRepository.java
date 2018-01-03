package org.dddml.wms.domain.inoutlinemvo.hibernate;

import java.util.*;
import org.dddml.wms.domain.inout.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.inoutlinemvo.*;
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
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("InOutLineId", "LocatorId", "ProductId", "AttributeSetInstanceId", "Description", "QuantityUomId", "MovementQuantity", "PickedQuantity", "IsInvoiced", "Processed", "RmaLineNumber", "ReversalLineNumber", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "InOutDocumentStatusId", "InOutPosted", "InOutProcessed", "InOutProcessing", "InOutDocumentTypeId", "InOutDescription", "InOutOrderId", "InOutDateOrdered", "InOutIsPrinted", "InOutMovementTypeId", "InOutMovementDate", "InOutBusinessPartnerId", "InOutWarehouseId", "InOutPOReference", "InOutFreightAmount", "InOutShipperId", "InOutChargeAmount", "InOutDatePrinted", "InOutCreatedFrom", "InOutSalesRepresentativeId", "InOutNumberOfPackages", "InOutPickDate", "InOutShipDate", "InOutTrackingNumber", "InOutDateReceived", "InOutIsInTransit", "InOutIsApproved", "InOutIsInDispute", "InOutRmaDocumentNumber", "InOutReversalDocumentNumber", "InOutInOutLines", "InOutVersion", "InOutCreatedBy", "InOutCreatedAt", "InOutUpdatedBy", "InOutUpdatedAt", "InOutActive"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public InOutLineMvoState get(InOutLineId id, boolean nullAllowed) {
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

    //protected static void addNotDeletedRestriction(Criteria criteria) {
    //    criteria.add(org.hibernate.criterion.Restrictions.eq("deleted", false));
    //}

}

