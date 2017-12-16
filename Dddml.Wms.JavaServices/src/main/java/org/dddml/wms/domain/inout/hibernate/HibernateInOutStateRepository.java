package org.dddml.wms.domain.inout.hibernate;

import java.util.*;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.inout.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateInOutStateRepository implements InOutStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("DocumentNumber", "DocumentStatusId", "Posted", "Processing", "Processed", "DocumentTypeId", "Description", "OrderId", "DateOrdered", "IsPrinted", "MovementTypeId", "MovementDate", "BusinessPartnerId", "WarehouseId", "POReference", "ShipperId", "DatePrinted", "SalesRepresentative", "NumberOfPackages", "PickDate", "ShipDate", "TrackingNumber", "DateReceived", "IsInTransit", "IsApproved", "IsInDispute", "RmaNumber", "ReversalNumber", "InOutLines", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public InOutState get(String id, boolean nullAllowed) {
        InOutState state = (InOutState)getCurrentSession().get(AbstractInOutState.SimpleInOutState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractInOutState.SimpleInOutState();
            state.setDocumentNumber(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (InOutState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{InOutState.class, Saveable.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(InOutState state)
    {
        InOutState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (InOutState) getReadOnlyProxyGenerator().getTarget(state);
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

