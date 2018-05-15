package org.dddml.wms.domain.shipment.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.shipment.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateShipmentReceiptStateDao implements ShipmentReceiptStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("ReceiptSeqId", "ProductId", "AttributeSetInstanceId", "LocatorId", "ShipmentItemSeqId", "ShipmentPackageSeqId", "OrderId", "OrderItemSeqId", "ReturnId", "ReturnItemSeqId", "RejectionReasonId", "DamageStatusId", "DamageReasonId", "ReceivedBy", "DatetimeReceived", "ItemDescription", "AcceptedQuantity", "RejectedQuantity", "DamagedQuantity", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "ShipmentId"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public ShipmentReceiptState get(ShipmentReceiptId id, boolean nullAllowed)
    {
        ShipmentReceiptState state = (ShipmentReceiptState) getCurrentSession().get(AbstractShipmentReceiptState.SimpleShipmentReceiptState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractShipmentReceiptState.SimpleShipmentReceiptState();
            state.setShipmentReceiptId(id);
        }
        //if (getReadOnlyProxyGenerator() != null && state != null) {
        //    return (ShipmentReceiptState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{ShipmentReceiptState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        //}
        return state;
    }

    @Override
    public void save(ShipmentReceiptState state)
    {
        ShipmentReceiptState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (ShipmentReceiptState) getReadOnlyProxyGenerator().getTarget(state);
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
    public Iterable<ShipmentReceiptState> findByShipmentId(String shipmentId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractShipmentReceiptState.SimpleShipmentReceiptState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("shipmentReceiptId.shipmentId", shipmentId))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(ShipmentReceiptState state)
    {
        ShipmentReceiptState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (ShipmentReceiptState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

