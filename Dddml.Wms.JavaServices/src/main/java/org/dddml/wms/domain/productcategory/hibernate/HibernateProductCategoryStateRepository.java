package org.dddml.wms.domain.productcategory.hibernate;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.productcategory.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateProductCategoryStateRepository implements ProductCategoryStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("ProductCategoryId", "ProductCategoryTypeId", "PrimaryParentCategoryId", "CategoryName", "Description", "CategoryImageUrl", "DetailScreen", "ShowInSelect", "ProductCategoryIdToProductCategories", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public ProductCategoryState get(String id, boolean nullAllowed) {
        ProductCategoryState state = (ProductCategoryState)getCurrentSession().get(AbstractProductCategoryState.SimpleProductCategoryState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractProductCategoryState.SimpleProductCategoryState();
            state.setProductCategoryId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (ProductCategoryState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{ProductCategoryState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(ProductCategoryState state)
    {
        ProductCategoryState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (ProductCategoryState) getReadOnlyProxyGenerator().getTarget(state);
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

