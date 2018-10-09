package org.dddml.wms.domain.facility.hibernate;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.facility.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateFacilityStateRepository implements FacilityStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("FacilityId", "FacilityTypeId", "ParentFacilityId", "OwnerPartyId", "DefaultInventoryItemTypeId", "FacilityName", "PrimaryFacilityGroupId", "OldSquareFootage", "FacilitySize", "FacilitySizeUomId", "ProductStoreId", "DefaultDaysToShip", "OpenedDate", "ClosedDate", "Description", "DefaultDimensionUomId", "DefaultWeightUomId", "GeoPointId", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public FacilityState get(String id, boolean nullAllowed) {
        FacilityState.SqlFacilityState state = (FacilityState.SqlFacilityState)getCurrentSession().get(AbstractFacilityState.SimpleFacilityState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractFacilityState.SimpleFacilityState();
            state.setFacilityId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (FacilityState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{FacilityState.SqlFacilityState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(FacilityState state)
    {
        FacilityState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (FacilityState) getReadOnlyProxyGenerator().getTarget(state);
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

