package org.dddml.wms.domain.inventoryprtriggered.hibernate;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateInventoryPRTriggeredStateRepository implements InventoryPRTriggeredStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("InventoryPRTriggeredId", "IsProcessed", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public InventoryPRTriggeredState get(InventoryPRTriggeredId id, boolean nullAllowed) {
        InventoryPRTriggeredState.SqlInventoryPRTriggeredState state = (InventoryPRTriggeredState.SqlInventoryPRTriggeredState)getCurrentSession().get(AbstractInventoryPRTriggeredState.SimpleInventoryPRTriggeredState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractInventoryPRTriggeredState.SimpleInventoryPRTriggeredState();
            state.setInventoryPRTriggeredId(id);
        }
        return state;
    }

    @Transactional
    public void save(InventoryPRTriggeredState state)
    {
        InventoryPRTriggeredState s = state;
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

