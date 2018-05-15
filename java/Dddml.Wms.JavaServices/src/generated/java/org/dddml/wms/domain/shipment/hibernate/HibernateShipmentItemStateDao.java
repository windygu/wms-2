package org.dddml.wms.domain.shipment.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.shipment.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateShipmentItemStateDao implements ShipmentItemStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("ShipmentItemSeqId", "ProductId", "AttributeSetInstanceId", "Quantity", "ShipmentContentDescription", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "ShipmentId"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public ShipmentItemState get(ShipmentItemId id, boolean nullAllowed)
    {
        ShipmentItemState state = (ShipmentItemState) getCurrentSession().get(AbstractShipmentItemState.SimpleShipmentItemState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractShipmentItemState.SimpleShipmentItemState();
            state.setShipmentItemId(id);
        }
        //if (getReadOnlyProxyGenerator() != null && state != null) {
        //    return (ShipmentItemState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{ShipmentItemState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        //}
        return state;
    }

    @Override
    public void save(ShipmentItemState state)
    {
        ShipmentItemState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (ShipmentItemState) getReadOnlyProxyGenerator().getTarget(state);
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
    public Iterable<ShipmentItemState> findByShipmentId(String shipmentId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractShipmentItemState.SimpleShipmentItemState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("shipmentItemId.shipmentId", shipmentId))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(ShipmentItemState state)
    {
        ShipmentItemState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (ShipmentItemState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

