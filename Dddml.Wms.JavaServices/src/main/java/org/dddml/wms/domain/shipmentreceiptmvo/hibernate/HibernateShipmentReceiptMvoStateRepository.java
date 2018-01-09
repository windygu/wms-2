package org.dddml.wms.domain.shipmentreceiptmvo.hibernate;

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
import org.dddml.wms.domain.shipmentreceiptmvo.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateShipmentReceiptMvoStateRepository implements ShipmentReceiptMvoStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("ShipmentReceiptId", "ProductId", "ShipmentItemSeqId", "RejectionReasonId", "DamageStatusId", "DamageReasonId", "ReceivedBy", "DatetimeReceived", "ItemDescription", "AcceptedQuantity", "RejectedQuantity", "DamagedQuantity", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "ShipmentShipmentTypeId", "ShipmentStatusId", "ShipmentPrimaryOrderId", "ShipmentPrimaryReturnId", "ShipmentPicklistBinId", "ShipmentEstimatedReadyDate", "ShipmentEstimatedShipDate", "ShipmentEstimatedShipWorkEffId", "ShipmentEstimatedArrivalDate", "ShipmentEstimatedArrivalWorkEffId", "ShipmentLatestCancelDate", "ShipmentEstimatedShipCost", "ShipmentCurrencyUomId", "ShipmentHandlingInstructions", "ShipmentOriginFacilityId", "ShipmentDestinationFacilityId", "ShipmentOriginContactMechId", "ShipmentOriginTelecomNumberId", "ShipmentDestinationContactMechId", "ShipmentDestinationTelecomNumberId", "ShipmentPartyIdTo", "ShipmentPartyIdFrom", "ShipmentAdditionalShippingCharge", "ShipmentAddtlShippingChargeDesc", "ShipmentShipperId", "ShipmentShipmentItems", "ShipmentShipmentReceipts", "ShipmentVersion", "ShipmentCreatedBy", "ShipmentCreatedAt", "ShipmentUpdatedBy", "ShipmentUpdatedAt", "ShipmentActive"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public ShipmentReceiptMvoState get(ShipmentReceiptId id, boolean nullAllowed) {
        ShipmentReceiptMvoState state = (ShipmentReceiptMvoState)getCurrentSession().get(AbstractShipmentReceiptMvoState.SimpleShipmentReceiptMvoState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractShipmentReceiptMvoState.SimpleShipmentReceiptMvoState();
            state.setShipmentReceiptId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (ShipmentReceiptMvoState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{ShipmentReceiptMvoState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(ShipmentReceiptMvoState state)
    {
        ShipmentReceiptMvoState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (ShipmentReceiptMvoState) getReadOnlyProxyGenerator().getTarget(state);
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

