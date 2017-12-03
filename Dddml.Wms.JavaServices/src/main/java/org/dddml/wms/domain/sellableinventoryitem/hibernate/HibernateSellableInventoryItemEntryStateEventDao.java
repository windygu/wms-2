package org.dddml.wms.domain.sellableinventoryitem.hibernate;

import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.sellableinventoryitem.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateSellableInventoryItemEntryStateEventDao implements SellableInventoryItemEntryStateEventDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(SellableInventoryItemEntryStateEvent e)
    {
        SellableInventoryItemEntryState state = ((AbstractSellableInventoryItemEntryStateEvent.AbstractSellableInventoryItemEntryStateCreated)e).getSellableInventoryItemEntryState();
        getCurrentSession().save(state);
        if (e instanceof Saveable)
        {
            Saveable saveable = (Saveable) e;
            saveable.save();
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<SellableInventoryItemEntryStateEvent> findBySellableInventoryItemStateEventId(SellableInventoryItemStateEventId sellableInventoryItemStateEventId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractSellableInventoryItemEntryState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("sellableInventoryItemEntryId.sellableInventoryItemIdProductId", sellableInventoryItemStateEventId.getSellableInventoryItemId().getProductId()))
            .add(Restrictions.eq("sellableInventoryItemEntryId.sellableInventoryItemIdLocatorId", sellableInventoryItemStateEventId.getSellableInventoryItemId().getLocatorId()))
            .add(Restrictions.eq("sellableInventoryItemEntryId.sellableInventoryItemIdAttributeSetInstanceId", sellableInventoryItemStateEventId.getSellableInventoryItemId().getAttributeSetInstanceId()))
            ;
        return (Iterable<SellableInventoryItemEntryStateEvent>) criteria.add(partIdCondition).list()
                .stream().map(s -> new AbstractSellableInventoryItemEntryStateEvent.SimpleSellableInventoryItemEntryStateCreated((SellableInventoryItemEntryState)s)).collect(java.util.stream.Collectors.toList());
    }

}

