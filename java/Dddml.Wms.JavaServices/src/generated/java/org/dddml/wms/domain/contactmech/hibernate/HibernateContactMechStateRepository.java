package org.dddml.wms.domain.contactmech.hibernate;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.contactmech.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateContactMechStateRepository implements ContactMechStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("ContactMechId", "ContactMechTypeId", "InfoString", "ToName", "AttnName", "Address1", "Address2", "Directions", "City", "PostalCode", "PostalCodeExt", "CountryGeoId", "StateProvinceGeoId", "CountyGeoId", "PostalCodeGeoId", "GeoPointId", "CountryCode", "AreaCode", "ContactNumber", "AskForName", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public ContactMechState get(String id, boolean nullAllowed) {
        ContactMechState.SqlContactMechState state = (ContactMechState.SqlContactMechState)getCurrentSession().get(AbstractContactMechState.SimpleContactMechState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractContactMechState.SimpleContactMechState();
            state.setContactMechId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (ContactMechState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{ContactMechState.SqlContactMechState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(ContactMechState state)
    {
        ContactMechState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (ContactMechState) getReadOnlyProxyGenerator().getTarget(state);
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

