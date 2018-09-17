package org.dddml.wms.domain.order.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.order.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateOrderShipGroupStateDao implements OrderShipGroupStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("ShipGroupSeqId", "ShipmentMethodTypeId", "SupplierPartyId", "VendorPartyId", "CarrierPartyId", "CarrierRoleTypeId", "FacilityId", "ContactMechId", "TelecomContactMechId", "MaySplit", "GiftMessage", "IsGift", "ShipAfterDate", "ShipByDate", "OrderShipGroupStatusId", "OrderItemShipGroupAssociations", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "OrderId"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public OrderShipGroupState get(OrderShipGroupId id, boolean nullAllowed)
    {
        OrderShipGroupState state = (OrderShipGroupState) getCurrentSession().get(AbstractOrderShipGroupState.SimpleOrderShipGroupState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractOrderShipGroupState.SimpleOrderShipGroupState();
            state.setOrderShipGroupId(id);
        }
        //if (getReadOnlyProxyGenerator() != null && state != null) {
        //    return (OrderShipGroupState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{OrderShipGroupState.class, Saveable.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        //}
        return state;
    }

    @Override
    public void save(OrderShipGroupState state)
    {
        OrderShipGroupState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (OrderShipGroupState) getReadOnlyProxyGenerator().getTarget(state);
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
    public Iterable<OrderShipGroupState> findByOrderId(String orderId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractOrderShipGroupState.SimpleOrderShipGroupState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("orderShipGroupId.orderId", orderId))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(OrderShipGroupState state)
    {
        OrderShipGroupState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (OrderShipGroupState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

