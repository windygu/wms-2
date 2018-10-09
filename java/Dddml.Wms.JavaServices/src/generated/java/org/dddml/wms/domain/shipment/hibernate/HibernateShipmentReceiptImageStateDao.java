package org.dddml.wms.domain.shipment.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.shipment.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateShipmentReceiptImageStateDao implements ShipmentReceiptImageStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("SequenceId", "Url", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "ShipmentId", "ShipmentReceiptReceiptSeqId"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public ShipmentReceiptImageState get(ShipmentReceiptImageId id, boolean nullAllowed)
    {
        ShipmentReceiptImageState.SqlShipmentReceiptImageState state = (ShipmentReceiptImageState.SqlShipmentReceiptImageState) getCurrentSession().get(AbstractShipmentReceiptImageState.SimpleShipmentReceiptImageState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractShipmentReceiptImageState.SimpleShipmentReceiptImageState();
            state.setShipmentReceiptImageId(id);
        }
        //if (getReadOnlyProxyGenerator() != null && state != null) {
        //    return (ShipmentReceiptImageState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{ShipmentReceiptImageState.SqlShipmentReceiptImageState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        //}
        return state;
    }

    @Override
    public void save(ShipmentReceiptImageState state)
    {
        ShipmentReceiptImageState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (ShipmentReceiptImageState) getReadOnlyProxyGenerator().getTarget(state);
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
    public Iterable<ShipmentReceiptImageState> findByShipmentIdAndShipmentReceiptReceiptSeqId(String shipmentId, String shipmentReceiptReceiptSeqId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractShipmentReceiptImageState.SimpleShipmentReceiptImageState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("shipmentReceiptImageId.shipmentId", shipmentId))
            .add(Restrictions.eq("shipmentReceiptImageId.shipmentReceiptReceiptSeqId", shipmentReceiptReceiptSeqId))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(ShipmentReceiptImageState state)
    {
        ShipmentReceiptImageState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (ShipmentReceiptImageState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

