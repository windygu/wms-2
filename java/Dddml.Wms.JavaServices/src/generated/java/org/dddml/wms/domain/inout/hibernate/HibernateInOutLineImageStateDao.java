package org.dddml.wms.domain.inout.hibernate;

import java.util.Date;
import org.dddml.wms.domain.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.wms.domain.inout.*;
import org.dddml.wms.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateInOutLineImageStateDao implements InOutLineImageStateDao
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("SequenceId", "Url", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "InOutDocumentNumber", "InOutLineLineNumber"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    @Override
    public InOutLineImageState get(InOutLineImageId id, boolean nullAllowed)
    {
        InOutLineImageState state = (InOutLineImageState) getCurrentSession().get(AbstractInOutLineImageState.SimpleInOutLineImageState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractInOutLineImageState.SimpleInOutLineImageState();
            state.setInOutLineImageId(id);
        }
        //if (getReadOnlyProxyGenerator() != null && state != null) {
        //    return (InOutLineImageState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{InOutLineImageState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        //}
        return state;
    }

    @Override
    public void save(InOutLineImageState state)
    {
        InOutLineImageState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (InOutLineImageState) getReadOnlyProxyGenerator().getTarget(state);
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
    public Iterable<InOutLineImageState> findByInOutDocumentNumberAndInOutLineLineNumber(String inOutDocumentNumber, String inOutLineLineNumber)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractInOutLineImageState.SimpleInOutLineImageState.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("inOutLineImageId.inOutDocumentNumber", inOutDocumentNumber))
            .add(Restrictions.eq("inOutLineImageId.inOutLineLineNumber", inOutLineLineNumber))
            ;
        return criteria.add(partIdCondition).list();
    }

    @Override
    public void delete(InOutLineImageState state)
    {
        InOutLineImageState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (InOutLineImageState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().delete(s);
    }

}

