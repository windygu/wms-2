package org.dddml.wms.domain.attributesetinstance.hibernate;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.attributesetinstance.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateAttributeSetInstanceStateRepository implements AttributeSetInstanceStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("AttributeSetInstanceId", "AttributeSetId", "OrganizationId", "ReferenceId", "SerialNumber", "LotId", "StatusIds", "ImageUrl", "Description", "Hash", "WidthInch", "DiameterInch", "WeightLbs", "WeightKg", "AirDryWeightLbs", "AirDryWeightKg", "AirDryMetricTon", "RollCnt", "AirDryPct", "_F_B_0_", "_F_I_0_", "_F_L_0_", "_F_DT_0_", "_F_N_0_", "_F_C5_0_", "_F_C10_0_", "_F_C20_0_", "_F_C50_0_", "_F_C100_0_", "_F_C200_0_", "_F_C500_0_", "_F_C1000_0_", "_F_B_1_", "_F_I_1_", "_F_L_1_", "_F_DT_1_", "_F_N_1_", "_F_C5_1_", "_F_C10_1_", "_F_C20_1_", "_F_C50_1_", "_F_C100_1_", "_F_C200_1_", "_F_B_2_", "_F_I_2_", "_F_L_2_", "_F_DT_2_", "_F_N_2_", "_F_C5_2_", "_F_C10_2_", "_F_C20_2_", "_F_C50_2_", "_F_B_3_", "_F_I_3_", "_F_L_3_", "_F_DT_3_", "_F_N_3_", "_F_C5_3_", "_F_C10_3_", "_F_C20_3_", "_F_C50_3_", "_F_B_4_", "_F_I_4_", "_F_L_4_", "_F_DT_4_", "_F_N_4_", "_F_C5_4_", "_F_C10_4_", "_F_C20_4_", "_F_C50_4_", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public AttributeSetInstanceState get(String id, boolean nullAllowed) {
        AttributeSetInstanceState.SqlAttributeSetInstanceState state = (AttributeSetInstanceState.SqlAttributeSetInstanceState)getCurrentSession().get(AbstractAttributeSetInstanceState.SimpleAttributeSetInstanceState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractAttributeSetInstanceState.SimpleAttributeSetInstanceState();
            state.setAttributeSetInstanceId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (AttributeSetInstanceState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{AttributeSetInstanceState.SqlAttributeSetInstanceState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(AttributeSetInstanceState state)
    {
        AttributeSetInstanceState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (AttributeSetInstanceState) getReadOnlyProxyGenerator().getTarget(state);
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
        getCurrentSession().flush();
    }

    //protected static void addNotDeletedRestriction(Criteria criteria) {
    //    criteria.add(org.hibernate.criterion.Restrictions.eq("deleted", false));
    //}

}

