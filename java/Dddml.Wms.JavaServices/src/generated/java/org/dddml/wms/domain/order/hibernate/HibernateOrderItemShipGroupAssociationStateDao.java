package org.dddml.wms.domain.order.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.order.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateOrderItemShipGroupAssociationStateDao implements OrderItemShipGroupAssociationStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("OrderItemSeqId", "Quantity", "CancelQuantity", "NumberOfPackages", "NumberOfContainers", "NumberOfPakagesPerContainer", "OrderItemShipGroupAssociationKey", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "OrderId", "OrderShipGroupShipGroupSeqId"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public OrderItemShipGroupAssociationState get(OrderItemShipGroupAssociationId id, boolean nullAllowed)
    {
        OrderItemShipGroupAssociationState.SqlOrderItemShipGroupAssociationState state = (OrderItemShipGroupAssociationState.SqlOrderItemShipGroupAssociationState) getCurrentSession().get(AbstractOrderItemShipGroupAssociationState.SimpleOrderItemShipGroupAssociationState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractOrderItemShipGroupAssociationState.SimpleOrderItemShipGroupAssociationState();
            state.setOrderItemShipGroupAssociationId(id);
        }
        //if (getReadOnlyProxyGenerator() != null && state != null) {
        //    return (OrderItemShipGroupAssociationState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{OrderItemShipGroupAssociationState.SqlOrderItemShipGroupAssociationState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        //}
        return state;
    }

    @Override
    public void save(OrderItemShipGroupAssociationState state)
    {
        OrderItemShipGroupAssociationState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (OrderItemShipGroupAssociationState) getReadOnlyProxyGenerator().getTarget(state);
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
    public Iterable<OrderItemShipGroupAssociationState> findByOrderIdAndOrderShipGroupShipGroupSeqId(String orderId, String orderShipGroupShipGroupSeqId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractOrderItemShipGroupAssociationState.SimpleOrderItemShipGroupAssociationState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("orderItemShipGroupAssociationId.orderId", orderId))
            .add(Restrictions.eq("orderItemShipGroupAssociationId.orderShipGroupShipGroupSeqId", orderShipGroupShipGroupSeqId))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(OrderItemShipGroupAssociationState state)
    {
        OrderItemShipGroupAssociationState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (OrderItemShipGroupAssociationState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

