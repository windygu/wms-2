package org.dddml.wms.domain.order.hibernate;

import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.order.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateOrderRoleStateDao implements OrderRoleStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("PartyRoleId", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "OrderId"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public OrderRoleState get(OrderRoleId id, boolean nullAllowed)
    {
        OrderRoleState.SqlOrderRoleState state = (OrderRoleState.SqlOrderRoleState) getCurrentSession().get(AbstractOrderRoleState.SimpleOrderRoleState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractOrderRoleState.SimpleOrderRoleState();
            state.setOrderRoleId(id);
        }
        //if (getReadOnlyProxyGenerator() != null && state != null) {
        //    return (OrderRoleState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{OrderRoleState.SqlOrderRoleState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        //}
        return state;
    }

    @Override
    public void save(OrderRoleState state)
    {
        OrderRoleState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (OrderRoleState) getReadOnlyProxyGenerator().getTarget(state);
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
    public Iterable<OrderRoleState> findByOrderId(String orderId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractOrderRoleState.SimpleOrderRoleState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("orderRoleId.orderId", orderId))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(OrderRoleState state)
    {
        OrderRoleState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (OrderRoleState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

