package org.dddml.wms.domain.itemissuancemvo.hibernate;

import java.util.*;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.itemissuancemvo.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateItemIssuanceMvoStateRepository implements ItemIssuanceMvoStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("ShipmentItemIssuanceId", "OrderId", "OrderItemSeqId", "ShipGroupSeqId", "ProductId", "LocatorId", "AttributeSetInstanceId", "ShipmentItemSeqId", "FixedAssetId", "MaintHistSeqId", "IssuedDateTime", "IssuedByUserLoginId", "Quantity", "CancelQuantity", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "ShipmentShipmentTypeId", "ShipmentStatusId", "ShipmentPrimaryOrderId", "ShipmentPrimaryReturnId", "ShipmentPrimaryShipGroupSeqId", "ShipmentPicklistBinId", "ShipmentEstimatedReadyDate", "ShipmentEstimatedShipDate", "ShipmentEstimatedShipWorkEffId", "ShipmentEstimatedArrivalDate", "ShipmentEstimatedArrivalWorkEffId", "ShipmentLatestCancelDate", "ShipmentEstimatedShipCost", "ShipmentCurrencyUomId", "ShipmentHandlingInstructions", "ShipmentOriginFacilityId", "ShipmentDestinationFacilityId", "ShipmentOriginContactMechId", "ShipmentOriginTelecomNumberId", "ShipmentDestinationContactMechId", "ShipmentDestinationTelecomNumberId", "ShipmentPartyIdTo", "ShipmentPartyIdFrom", "ShipmentAdditionalShippingCharge", "ShipmentAddtlShippingChargeDesc", "ShipmentShipmentItems", "ShipmentShipmentReceipts", "ShipmentItemIssuances", "ShipmentVersion", "ShipmentCreatedBy", "ShipmentCreatedAt", "ShipmentUpdatedBy", "ShipmentUpdatedAt", "ShipmentActive"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public ItemIssuanceMvoState get(ShipmentItemIssuanceId id, boolean nullAllowed) {
        ItemIssuanceMvoState state = (ItemIssuanceMvoState)getCurrentSession().get(AbstractItemIssuanceMvoState.SimpleItemIssuanceMvoState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractItemIssuanceMvoState.SimpleItemIssuanceMvoState();
            state.setShipmentItemIssuanceId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (ItemIssuanceMvoState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{ItemIssuanceMvoState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(ItemIssuanceMvoState state)
    {
        ItemIssuanceMvoState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (ItemIssuanceMvoState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if(s.getShipmentVersion() == null) {
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

