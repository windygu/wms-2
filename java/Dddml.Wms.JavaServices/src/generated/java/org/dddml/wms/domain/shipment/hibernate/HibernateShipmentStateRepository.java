package org.dddml.wms.domain.shipment.hibernate;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.shipment.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateShipmentStateRepository implements ShipmentStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("ShipmentId", "ShipmentTypeId", "StatusId", "PrimaryOrderId", "PrimaryReturnId", "PrimaryShipGroupSeqId", "OnlyOneOrder", "PicklistBinId", "BolNumber", "SealNumber", "VehicleId", "ExternalOrderNumber", "Carrier", "DateShipped", "EstimatedReadyDate", "EstimatedShipDate", "EstimatedShipWorkEffId", "EstimatedArrivalDate", "EstimatedArrivalWorkEffId", "LatestCancelDate", "EstimatedShipCost", "CurrencyUomId", "HandlingInstructions", "OriginFacilityId", "DestinationFacilityId", "OriginContactMechId", "OriginTelecomNumberId", "DestinationContactMechId", "DestinationTelecomNumberId", "PartyIdTo", "PartyIdFrom", "AdditionalShippingCharge", "AddtlShippingChargeDesc", "ShipmentItems", "ShipmentReceipts", "ItemIssuances", "ShipmentImages", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public ShipmentState get(String id, boolean nullAllowed) {
        ShipmentState state = (ShipmentState)getCurrentSession().get(AbstractShipmentState.SimpleShipmentState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractShipmentState.SimpleShipmentState();
            state.setShipmentId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (ShipmentState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{ShipmentState.class, Saveable.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(ShipmentState state)
    {
        ShipmentState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (ShipmentState) getReadOnlyProxyGenerator().getTarget(state);
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
        getCurrentSession().flush();
    }

    //protected static void addNotDeletedRestriction(Criteria criteria) {
    //    criteria.add(org.hibernate.criterion.Restrictions.eq("deleted", false));
    //}

}

