package org.dddml.wms.domain.movement.hibernate;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.movement.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateMovementLineStateDao implements MovementLineStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("LineNumber", "MovementQuantity", "ProductId", "LocatorIdFrom", "LocatorIdTo", "AttributeSetInstanceId", "Processed", "ReversalLineNumber", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "MovementDocumentNumber"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public MovementLineState get(MovementLineId id, boolean nullAllowed)
    {
        MovementLineState state = (MovementLineState) getCurrentSession().get(AbstractMovementLineState.SimpleMovementLineState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractMovementLineState.SimpleMovementLineState();
            state.setMovementLineId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (MovementLineState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{MovementLineState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    @Override
    public void save(MovementLineState state)
    {
        MovementLineState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (MovementLineState) getReadOnlyProxyGenerator().getTarget(state);
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

    @Transactional(readOnly = true)
    @Override
    public Iterable<MovementLineState> findByMovementDocumentNumber(String movementDocumentNumber)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractMovementLineState.SimpleMovementLineState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("movementLineId.movementDocumentNumber", movementDocumentNumber))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(MovementLineState state)
    {
        MovementLineState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (MovementLineState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

