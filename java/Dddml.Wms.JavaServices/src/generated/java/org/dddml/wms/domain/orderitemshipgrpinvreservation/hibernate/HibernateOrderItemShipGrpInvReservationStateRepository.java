package org.dddml.wms.domain.orderitemshipgrpinvreservation.hibernate;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.orderitemshipgrpinvreservation.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateOrderItemShipGrpInvReservationStateRepository implements OrderItemShipGrpInvReservationStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("OrderItemShipGrpInvResId", "ReserveOrderEnumId", "Quantity", "QuantityNotAvailable", "ReservedDatetime", "CreatedDatetime", "PromisedDatetime", "CurrentPromisedDate", "Priority", "SequenceId", "OldPickStartDate", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public OrderItemShipGrpInvReservationState get(OrderItemShipGrpInvResId id, boolean nullAllowed) {
        OrderItemShipGrpInvReservationState state = (OrderItemShipGrpInvReservationState)getCurrentSession().get(AbstractOrderItemShipGrpInvReservationState.SimpleOrderItemShipGrpInvReservationState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractOrderItemShipGrpInvReservationState.SimpleOrderItemShipGrpInvReservationState();
            state.setOrderItemShipGrpInvResId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (OrderItemShipGrpInvReservationState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{OrderItemShipGrpInvReservationState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(OrderItemShipGrpInvReservationState state)
    {
        OrderItemShipGrpInvReservationState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (OrderItemShipGrpInvReservationState) getReadOnlyProxyGenerator().getTarget(state);
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

