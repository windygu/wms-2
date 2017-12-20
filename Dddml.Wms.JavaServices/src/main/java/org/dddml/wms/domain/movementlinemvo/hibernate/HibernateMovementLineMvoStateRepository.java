package org.dddml.wms.domain.movementlinemvo.hibernate;

import java.util.*;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.movementlinemvo.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateMovementLineMvoStateRepository implements MovementLineMvoStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("MovementLineId", "MovementQuantity", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "MovementDocumentTypeId", "MovementDocumentStatusId", "MovementMovementTypeId", "MovementDescription", "MovementMovementLines", "MovementMovementConfirmationLines", "MovementVersion", "MovementCreatedBy", "MovementCreatedAt", "MovementUpdatedBy", "MovementUpdatedAt", "MovementActive", "MovementDeleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public MovementLineMvoState get(MovementLineId id, boolean nullAllowed) {
        MovementLineMvoState state = (MovementLineMvoState)getCurrentSession().get(AbstractMovementLineMvoState.SimpleMovementLineMvoState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractMovementLineMvoState.SimpleMovementLineMvoState();
            state.setMovementLineId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (MovementLineMvoState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{MovementLineMvoState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(MovementLineMvoState state)
    {
        MovementLineMvoState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (MovementLineMvoState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if(s.getMovementVersion() == null) {
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

