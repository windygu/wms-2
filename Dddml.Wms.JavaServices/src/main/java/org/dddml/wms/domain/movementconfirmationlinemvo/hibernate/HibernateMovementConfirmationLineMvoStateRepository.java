package org.dddml.wms.domain.movementconfirmationlinemvo.hibernate;

import java.util.*;
import org.dddml.wms.domain.movementconfirmation.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.movementconfirmationlinemvo.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateMovementConfirmationLineMvoStateRepository implements MovementConfirmationLineMvoStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("MovementConfirmationLineId", "MovementLineNumber", "TargetQuantity", "ConfirmedQuantity", "DifferenceQuantity", "ScrappedQuantity", "Description", "Processed", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "MovementConfirmationDocumentStatusId", "MovementConfirmationMovementDocumentNumber", "MovementConfirmationIsApproved", "MovementConfirmationApprovalAmount", "MovementConfirmationProcessed", "MovementConfirmationProcessing", "MovementConfirmationDocumentTypeId", "MovementConfirmationDescription", "MovementConfirmationMovementConfirmationLines", "MovementConfirmationVersion", "MovementConfirmationCreatedBy", "MovementConfirmationCreatedAt", "MovementConfirmationUpdatedBy", "MovementConfirmationUpdatedAt", "MovementConfirmationActive", "MovementConfirmationDeleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public MovementConfirmationLineMvoState get(MovementConfirmationLineId id, boolean nullAllowed) {
        MovementConfirmationLineMvoState state = (MovementConfirmationLineMvoState)getCurrentSession().get(AbstractMovementConfirmationLineMvoState.SimpleMovementConfirmationLineMvoState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractMovementConfirmationLineMvoState.SimpleMovementConfirmationLineMvoState();
            state.setMovementConfirmationLineId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (MovementConfirmationLineMvoState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{MovementConfirmationLineMvoState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(MovementConfirmationLineMvoState state)
    {
        MovementConfirmationLineMvoState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (MovementConfirmationLineMvoState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if(s.getMovementConfirmationVersion() == null) {
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

