package org.dddml.wms.domain.shipment.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.shipment.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateShipmentImageStateDao implements ShipmentImageStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("SequenceId", "Url", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "ShipmentId"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public ShipmentImageState get(ShipmentImageId id, boolean nullAllowed)
    {
        ShipmentImageState state = (ShipmentImageState) getCurrentSession().get(AbstractShipmentImageState.SimpleShipmentImageState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractShipmentImageState.SimpleShipmentImageState();
            state.setShipmentImageId(id);
        }
        //if (getReadOnlyProxyGenerator() != null && state != null) {
        //    return (ShipmentImageState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{ShipmentImageState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        //}
        return state;
    }

    @Override
    public void save(ShipmentImageState state)
    {
        ShipmentImageState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (ShipmentImageState) getReadOnlyProxyGenerator().getTarget(state);
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
    public Iterable<ShipmentImageState> findByShipmentId(String shipmentId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractShipmentImageState.SimpleShipmentImageState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("shipmentImageId.shipmentId", shipmentId))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(ShipmentImageState state)
    {
        ShipmentImageState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (ShipmentImageState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

