package org.dddml.wms.domain.movementconfirmation.hibernate;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.movementconfirmation.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateMovementConfirmationLineStateDao implements MovementConfirmationLineStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("LineNumber", "MovementLineNumber", "TargetQuantity", "ConfirmedQuantity", "DifferenceQuantity", "ScrappedQuantity", "Description", "Processed", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "MovementConfirmationDocumentNumber"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public MovementConfirmationLineState get(MovementConfirmationLineId id, boolean nullAllowed)
    {
        MovementConfirmationLineState state = (MovementConfirmationLineState) getCurrentSession().get(AbstractMovementConfirmationLineState.SimpleMovementConfirmationLineState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractMovementConfirmationLineState.SimpleMovementConfirmationLineState();
            state.setMovementConfirmationLineId(id);
        }
        //if (getReadOnlyProxyGenerator() != null && state != null) {
        //    return (MovementConfirmationLineState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{MovementConfirmationLineState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        //}
        return state;
    }

    @Override
    public void save(MovementConfirmationLineState state)
    {
        MovementConfirmationLineState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (MovementConfirmationLineState) getReadOnlyProxyGenerator().getTarget(state);
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
    public Iterable<MovementConfirmationLineState> findByMovementConfirmationDocumentNumber(String movementConfirmationDocumentNumber)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractMovementConfirmationLineState.SimpleMovementConfirmationLineState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("movementConfirmationLineId.movementConfirmationDocumentNumber", movementConfirmationDocumentNumber))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(MovementConfirmationLineState state)
    {
        MovementConfirmationLineState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (MovementConfirmationLineState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

