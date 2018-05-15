package org.dddml.wms.domain.shipment.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.shipment.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateItemIssuanceStateDao implements ItemIssuanceStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("ItemIssuanceSeqId", "OrderId", "OrderItemSeqId", "ShipGroupSeqId", "ProductId", "LocatorId", "AttributeSetInstanceId", "ShipmentItemSeqId", "FixedAssetId", "MaintHistSeqId", "IssuedDateTime", "IssuedByUserLoginId", "Quantity", "CancelQuantity", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "ShipmentId"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public ItemIssuanceState get(ShipmentItemIssuanceId id, boolean nullAllowed)
    {
        ItemIssuanceState state = (ItemIssuanceState) getCurrentSession().get(AbstractItemIssuanceState.SimpleItemIssuanceState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractItemIssuanceState.SimpleItemIssuanceState();
            state.setShipmentItemIssuanceId(id);
        }
        //if (getReadOnlyProxyGenerator() != null && state != null) {
        //    return (ItemIssuanceState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{ItemIssuanceState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        //}
        return state;
    }

    @Override
    public void save(ItemIssuanceState state)
    {
        ItemIssuanceState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (ItemIssuanceState) getReadOnlyProxyGenerator().getTarget(state);
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
    public Iterable<ItemIssuanceState> findByShipmentId(String shipmentId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractItemIssuanceState.SimpleItemIssuanceState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("shipmentItemIssuanceId.shipmentId", shipmentId))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(ItemIssuanceState state)
    {
        ItemIssuanceState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (ItemIssuanceState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

