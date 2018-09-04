package org.dddml.wms.domain.physicalinventory.hibernate;

import org.dddml.wms.domain.inventoryitem.InventoryItemState;
import org.dddml.wms.domain.locator.AbstractLocatorState;
import org.dddml.wms.domain.physicalinventory.InventoryItemQueryService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yangjiefeng on 2018/9/4.
 */
public class HibernateInventoryItemQueryService implements InventoryItemQueryService {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Transactional(readOnly = true)
    @Override
    public List<InventoryItemState> getInventoryItems(String warehouseId, String locatorIdPattern, String productIdPattern) {
        if (warehouseId == null || warehouseId.isEmpty()) {
            throw new IllegalArgumentException("warehosueId is null");
        }
        Criteria criteria = getCurrentSession().createCriteria(InventoryItemState.class);
        DetachedCriteria locatorDC = DetachedCriteria.forClass(AbstractLocatorState.SimpleLocatorState.class)
                .setProjection(Projections.property("locatorId"))
                .add(Restrictions.eq("warehouseId", warehouseId));
        if (locatorIdPattern != null && !locatorIdPattern.isEmpty()) {
            locatorDC.add(Restrictions.like("locatorId", locatorIdPattern));
        }
        criteria.add(Subqueries.propertyIn("inventoryItemId.locatorId", locatorDC));
        if (productIdPattern != null && !productIdPattern.isEmpty()) {
            criteria.add(Restrictions.like("inventoryItemId.productId", productIdPattern));
        }
        //HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
        return criteria.list();
    }

}
