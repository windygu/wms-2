package org.dddml.wms.domain.inoutnotice.hibernate;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.inoutnotice.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateInOutNoticeStateRepository implements InOutNoticeStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("InOutNoticeId", "WarehouseId", "InOutNoticeType", "TelecomContactMechId", "TrackingNumber", "ContactPartyId", "VehiclePlateNumber", "ShippingInstructions", "EstimatedShipDate", "EstimatedDeliveryDate", "IsScheduleNeeded", "StatusId", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public InOutNoticeState get(String id, boolean nullAllowed) {
        InOutNoticeState state = (InOutNoticeState)getCurrentSession().get(AbstractInOutNoticeState.SimpleInOutNoticeState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractInOutNoticeState.SimpleInOutNoticeState();
            state.setInOutNoticeId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (InOutNoticeState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{InOutNoticeState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(InOutNoticeState state)
    {
        InOutNoticeState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (InOutNoticeState) getReadOnlyProxyGenerator().getTarget(state);
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

