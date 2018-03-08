package org.dddml.wms.domain.inventoryitem.hibernate;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateInventoryItemEntryStateEventDao implements InventoryItemEntryStateEventDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(InventoryItemEntryStateEvent e)
    {
        InventoryItemEntryState state = ((AbstractInventoryItemEntryStateEvent.AbstractInventoryItemEntryStateCreated)e).getInventoryItemEntryState();
        getCurrentSession().save(state);
        if (e instanceof Saveable)
        {
            Saveable saveable = (Saveable) e;
            saveable.save();
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<InventoryItemEntryStateEvent> findByInventoryItemEventId(InventoryItemEventId inventoryItemEventId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractInventoryItemEntryState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("inventoryItemEntryId.inventoryItemIdProductId", inventoryItemEventId.getInventoryItemId().getProductId()))
            .add(Restrictions.eq("inventoryItemEntryId.inventoryItemIdLocatorId", inventoryItemEventId.getInventoryItemId().getLocatorId()))
            .add(Restrictions.eq("inventoryItemEntryId.inventoryItemIdAttributeSetInstanceId", inventoryItemEventId.getInventoryItemId().getAttributeSetInstanceId()))
            ;
        return (Iterable<InventoryItemEntryStateEvent>) criteria.add(partIdCondition).list()
                .stream().map(s -> new AbstractInventoryItemEntryStateEvent.SimpleInventoryItemEntryStateCreated((InventoryItemEntryState)s)).collect(java.util.stream.Collectors.toList());
    }

}

