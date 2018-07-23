package org.dddml.wms.domain.inout.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.inout.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateInOutImageStateDao implements InOutImageStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("SequenceId", "Url", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "InOutDocumentNumber"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public InOutImageState get(InOutImageId id, boolean nullAllowed)
    {
        InOutImageState state = (InOutImageState) getCurrentSession().get(AbstractInOutImageState.SimpleInOutImageState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractInOutImageState.SimpleInOutImageState();
            state.setInOutImageId(id);
        }
        //if (getReadOnlyProxyGenerator() != null && state != null) {
        //    return (InOutImageState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{InOutImageState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        //}
        return state;
    }

    @Override
    public void save(InOutImageState state)
    {
        InOutImageState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (InOutImageState) getReadOnlyProxyGenerator().getTarget(state);
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
    public Iterable<InOutImageState> findByInOutDocumentNumber(String inOutDocumentNumber)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractInOutImageState.SimpleInOutImageState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("inOutImageId.inOutDocumentNumber", inOutDocumentNumber))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(InOutImageState state)
    {
        InOutImageState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (InOutImageState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

