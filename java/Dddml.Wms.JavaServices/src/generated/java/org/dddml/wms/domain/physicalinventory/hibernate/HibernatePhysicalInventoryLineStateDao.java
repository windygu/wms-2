package org.dddml.wms.domain.physicalinventory.hibernate;

import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.physicalinventory.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernatePhysicalInventoryLineStateDao implements PhysicalInventoryLineStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("InventoryItemId", "BookQuantity", "CountedQuantity", "Processed", "LineNumber", "ReversalLineNumber", "Description", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "PhysicalInventoryDocumentNumber"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public PhysicalInventoryLineState get(PhysicalInventoryLineId id, boolean nullAllowed)
    {
        PhysicalInventoryLineState state = (PhysicalInventoryLineState) getCurrentSession().get(AbstractPhysicalInventoryLineState.SimplePhysicalInventoryLineState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractPhysicalInventoryLineState.SimplePhysicalInventoryLineState();
            state.setPhysicalInventoryLineId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (PhysicalInventoryLineState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{PhysicalInventoryLineState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    @Override
    public void save(PhysicalInventoryLineState state)
    {
        PhysicalInventoryLineState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (PhysicalInventoryLineState) getReadOnlyProxyGenerator().getTarget(state);
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
    public Iterable<PhysicalInventoryLineState> findByPhysicalInventoryDocumentNumber(String physicalInventoryDocumentNumber)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractPhysicalInventoryLineState.SimplePhysicalInventoryLineState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("physicalInventoryLineId.physicalInventoryDocumentNumber", physicalInventoryDocumentNumber))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(PhysicalInventoryLineState state)
    {
        PhysicalInventoryLineState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (PhysicalInventoryLineState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

