package org.dddml.wms.domain.movementconfirmation.hibernate;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.movementconfirmation.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateMovementConfirmationStateRepository implements MovementConfirmationStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("DocumentNumber", "DocumentStatusId", "MovementDocumentNumber", "IsApproved", "ApprovalAmount", "Processed", "Processing", "DocumentTypeId", "Description", "MovementConfirmationLines", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public MovementConfirmationState get(String id, boolean nullAllowed) {
        MovementConfirmationState state = (MovementConfirmationState)getCurrentSession().get(AbstractMovementConfirmationState.SimpleMovementConfirmationState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractMovementConfirmationState.SimpleMovementConfirmationState();
            state.setDocumentNumber(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (MovementConfirmationState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{MovementConfirmationState.class, Saveable.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(MovementConfirmationState state)
    {
        MovementConfirmationState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (MovementConfirmationState) getReadOnlyProxyGenerator().getTarget(state);
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

    //protected static void addNotDeletedRestriction(Criteria criteria) {
    //    criteria.add(org.hibernate.criterion.Restrictions.eq("deleted", false));
    //}

}

