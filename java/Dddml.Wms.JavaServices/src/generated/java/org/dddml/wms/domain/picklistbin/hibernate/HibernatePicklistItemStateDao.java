package org.dddml.wms.domain.picklistbin.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.picklistbin.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernatePicklistItemStateDao implements PicklistItemStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("PicklistItemOrderShipGrpInvId", "ItemStatusId", "Quantity", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "PicklistBinId"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public PicklistItemState get(PicklistBinPicklistItemId id, boolean nullAllowed)
    {
        PicklistItemState state = (PicklistItemState) getCurrentSession().get(AbstractPicklistItemState.SimplePicklistItemState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractPicklistItemState.SimplePicklistItemState();
            state.setPicklistBinPicklistItemId(id);
        }
        //if (getReadOnlyProxyGenerator() != null && state != null) {
        //    return (PicklistItemState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{PicklistItemState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        //}
        return state;
    }

    @Override
    public void save(PicklistItemState state)
    {
        PicklistItemState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (PicklistItemState) getReadOnlyProxyGenerator().getTarget(state);
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
    public Iterable<PicklistItemState> findByPicklistBinId(String picklistBinId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractPicklistItemState.SimplePicklistItemState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("picklistBinPicklistItemId.picklistBinId", picklistBinId))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(PicklistItemState state)
    {
        PicklistItemState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (PicklistItemState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

