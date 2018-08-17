package org.dddml.wms.domain.party.hibernate;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.party.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernatePartyStateRepository implements PartyStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("PartyId", "PartyTypeId", "PrimaryRoleTypeId", "ExternalId", "PreferredCurrencyUomId", "Description", "OrganizationName", "IsSummary", "Salutation", "FirstName", "MiddleName", "LastName", "PersonalTitle", "Nickname", "CardId", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public PartyState get(String id, boolean nullAllowed) {
        return get(PartyState.class, id, nullAllowed);
    }

    @Transactional(readOnly = true)
    public PartyState get(Class<? extends PartyState> type, String id, boolean nullAllowed) {
        PartyState state = (PartyState)getCurrentSession().get(AbstractPartyState.SimplePartyState.class, id);
        if (state != null && !type.isAssignableFrom(state.getClass())) {
            throw new ClassCastException(String.format("state is NOT instance of %1$s", type.getName()));
        }
        if (!nullAllowed && state == null) {
            state = newEmptyState(type);
            state.setPartyId(id);
        }
        return state;
    }

    private PartyState newEmptyState(Class<? extends PartyState> type) {
        PartyState state = null;
        Class<? extends AbstractPartyState> clazz = null;
        if (state != null) {
            // do nothing.
        }
        else if (type.equals(PartyState.class)) {
            clazz = AbstractPartyState.SimplePartyState.class;
        }
        else if (type.equals(OrganizationState.class)) {
            clazz = AbstractOrganizationState.SimpleOrganizationState.class;
        }
        else if (type.equals(PersonState.class)) {
            clazz = AbstractPersonState.SimplePersonState.class;
        }
        else {
            throw new IllegalArgumentException("type");
        }
        try {
            state = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalArgumentException("type", e);
        }
        return state;
    }

    public void save(PartyState state)
    {
        PartyState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (PartyState) getReadOnlyProxyGenerator().getTarget(state);
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

