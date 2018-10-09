package org.dddml.wms.domain.product.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.product.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateGoodIdentificationStateDao implements GoodIdentificationStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("GoodIdentificationTypeId", "IdValue", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "ProductId"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public GoodIdentificationState get(ProductGoodIdentificationId id, boolean nullAllowed)
    {
        GoodIdentificationState.SqlGoodIdentificationState state = (GoodIdentificationState.SqlGoodIdentificationState) getCurrentSession().get(AbstractGoodIdentificationState.SimpleGoodIdentificationState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractGoodIdentificationState.SimpleGoodIdentificationState();
            state.setProductGoodIdentificationId(id);
        }
        //if (getReadOnlyProxyGenerator() != null && state != null) {
        //    return (GoodIdentificationState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{GoodIdentificationState.SqlGoodIdentificationState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        //}
        return state;
    }

    @Override
    public void save(GoodIdentificationState state)
    {
        GoodIdentificationState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (GoodIdentificationState) getReadOnlyProxyGenerator().getTarget(state);
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
    public Iterable<GoodIdentificationState> findByProductId(String productId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractGoodIdentificationState.SimpleGoodIdentificationState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("productGoodIdentificationId.productId", productId))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(GoodIdentificationState state)
    {
        GoodIdentificationState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (GoodIdentificationState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

