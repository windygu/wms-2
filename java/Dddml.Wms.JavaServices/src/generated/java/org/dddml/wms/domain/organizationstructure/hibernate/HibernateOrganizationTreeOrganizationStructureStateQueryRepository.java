// <autogenerated>
//   This file was generated by T4 code generator GenerateOrganizationStructureDomainHibernate.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.wms.domain.organizationstructure.hibernate;

import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.organizationstructure.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateOrganizationTreeOrganizationStructureStateQueryRepository extends HibernateOrganizationStructureStateQueryRepository implements OrganizationTreeOrganizationStructureStateQueryRepository
{
    @Transactional(readOnly = true)
    public Iterable<org.dddml.wms.domain.party.OrganizationState> getOrganizationTreeRootOrganizations(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        Criteria criteria = getCurrentSession().createCriteria(org.dddml.wms.domain.party.OrganizationState.class);
        DetachedCriteria dc = DetachedCriteria.forClass(AbstractOrganizationStructureState.class).setProjection(Projections.property("id.subsidiaryId"));
        criteria.add(Subqueries.propertyNotIn("partyId", dc));
        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public Iterable<OrganizationStructureState> getOrganizationTreeChildren(String parentId, Criterion filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Criteria criteria = getCurrentSession().createCriteria(OrganizationStructureState.class);

        HibernateUtils.criteriaAddCriterion(criteria, "id.parentId", parentId);
        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public Iterable<org.dddml.wms.domain.party.OrganizationState> getOrganizationTreeRootOrganizations(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        Criteria criteria = getCurrentSession().createCriteria(org.dddml.wms.domain.party.OrganizationState.class);
        DetachedCriteria dc = DetachedCriteria.forClass(AbstractOrganizationStructureState.class).setProjection(Projections.property("id.subsidiaryId"));
        criteria.add(Subqueries.propertyNotIn("partyId", dc));
        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public Iterable<OrganizationStructureState> getOrganizationTreeChildren(String parentId, Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Criteria criteria = getCurrentSession().createCriteria(OrganizationStructureState.class);

        HibernateUtils.criteriaAddCriterion(criteria, "id.parentId", parentId);
        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
        return criteria.list();
    }

    private void criteriaAddOrganizationTreeRootParentIdCriterion(Criteria criteria)
    {
        Object[] rootParentIdValues = new Object[] { null };
        if (rootParentIdValues.length == 1)
        {
            HibernateUtils.criteriaAddCriterion(criteria, "id.parentId", rootParentIdValues[0]);
        }
        else
        {
            Disjunction j = Restrictions.disjunction();
            for (Object pIdValue : rootParentIdValues)
            {
                HibernateUtils.disjunctionAddCriterion(j, "id.parentId", pIdValue);
            }
            criteria.add(j);
        }
    }
}

