package org.dddml.wms.domain.inventoryitemrequirement.hibernate;

import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.inventoryitemrequirement.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateInventoryItemRequirementEntryStateDao implements InventoryItemRequirementEntryStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("EntrySeqId", "Quantity", "SourceEventId", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "InventoryItemRequirementId"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public InventoryItemRequirementEntryState get(InventoryItemRequirementEntryId id, boolean nullAllowed)
    {
        InventoryItemRequirementEntryState.SqlInventoryItemRequirementEntryState state = (InventoryItemRequirementEntryState.SqlInventoryItemRequirementEntryState) getCurrentSession().get(AbstractInventoryItemRequirementEntryState.SimpleInventoryItemRequirementEntryState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractInventoryItemRequirementEntryState.SimpleInventoryItemRequirementEntryState();
            state.setInventoryItemRequirementEntryId(id);
        }
        return state;
    }

    @Override
    public void save(InventoryItemRequirementEntryState state)
    {
        InventoryItemRequirementEntryState s = state;
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
    public Iterable<InventoryItemRequirementEntryState> findByInventoryItemRequirementId(InventoryItemId inventoryItemRequirementId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractInventoryItemRequirementEntryState.SimpleInventoryItemRequirementEntryState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("inventoryItemRequirementEntryId.inventoryItemRequirementIdProductId", inventoryItemRequirementId.getProductId()))
            .add(Restrictions.eq("inventoryItemRequirementEntryId.inventoryItemRequirementIdLocatorId", inventoryItemRequirementId.getLocatorId()))
            .add(Restrictions.eq("inventoryItemRequirementEntryId.inventoryItemRequirementIdAttributeSetInstanceId", inventoryItemRequirementId.getAttributeSetInstanceId()))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(InventoryItemRequirementEntryState state)
    {
        InventoryItemRequirementEntryState s = state;
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

