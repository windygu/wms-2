package org.dddml.wms.domain.movement.hibernate;

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
import org.dddml.wms.domain.movement.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateMovementStateRepository implements MovementStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("DocumentNumber", "DocumentStatusId", "MovementDate", "Posted", "Processed", "Processing", "DateReceived", "DocumentTypeId", "IsInTransit", "IsApproved", "ApprovalAmount", "ShipperId", "SalesRepresentativeId", "BusinessPartnerId", "ChargeAmount", "CreateFrom", "FreightAmount", "ReversalDocumentNumber", "WarehouseIdFrom", "WarehouseIdTo", "Description", "MovementLines", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public MovementState get(String id, boolean nullAllowed) {
        MovementState.SqlMovementState state = (MovementState.SqlMovementState)getCurrentSession().get(AbstractMovementState.SimpleMovementState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractMovementState.SimpleMovementState();
            state.setDocumentNumber(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (MovementState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{MovementState.SqlMovementState.class, Saveable.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(MovementState state)
    {
        MovementState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (MovementState) getReadOnlyProxyGenerator().getTarget(state);
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
        getCurrentSession().flush();
    }

    //protected static void addNotDeletedRestriction(Criteria criteria) {
    //    criteria.add(org.hibernate.criterion.Restrictions.eq("deleted", false));
    //}

}

