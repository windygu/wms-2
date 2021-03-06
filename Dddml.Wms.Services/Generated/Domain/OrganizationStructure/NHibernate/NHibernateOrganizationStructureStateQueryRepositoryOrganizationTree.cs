﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateOrganizationStructureDomainNHibernate.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.OrganizationStructure;
using Dddml.Wms.Specialization.NHibernate;
using NHibernate;
using NHibernate.Criterion;
using Spring.Transaction.Interceptor;

namespace Dddml.Wms.Domain.OrganizationStructure.NHibernate
{

	public partial class NHibernateOrganizationStructureStateQueryRepository
	{
        [Transaction(ReadOnly = true)]
        public virtual IEnumerable<Dddml.Wms.Domain.Party.IOrganizationState> GetOrganizationTreeRootOrganizations(Dddml.Support.Criterion.ICriterion filter, IList<string> orders, int firstResult = 0, int maxResults = int.MaxValue)
        {
            var criteria = CurrentSession.CreateCriteria<Dddml.Wms.Domain.Party.OrganizationState>();

            var dc = DetachedCriteria.For<OrganizationStructureState>().SetProjection(Projections.Property("Id.SubsidiaryId"));
            criteria.Add(Subqueries.PropertyNotIn("PartyId", dc));
            NHibernateUtils.CriteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
            return criteria.List<Dddml.Wms.Domain.Party.OrganizationState>();
        }

        [Transaction(ReadOnly = true)]
        public virtual IEnumerable<IOrganizationStructureState> GetOrganizationTreeChildren(string parentId, Dddml.Support.Criterion.ICriterion filter, IList<string> orders, int firstResult = 0, int maxResults = int.MaxValue)
        {
            var criteria = CurrentSession.CreateCriteria<OrganizationStructureState>();

            NHibernateUtils.CriteriaAddCriterion(criteria, "Id.ParentId", parentId);
            NHibernateUtils.CriteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
            return criteria.List<OrganizationStructureState>();
        }

        [Transaction(ReadOnly = true)]
        public virtual IEnumerable<Dddml.Wms.Domain.Party.IOrganizationState> GetOrganizationTreeRootOrganizations(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders, int firstResult = 0, int maxResults = int.MaxValue)
        {
            var criteria = CurrentSession.CreateCriteria<Dddml.Wms.Domain.Party.OrganizationState>();

            var dc = DetachedCriteria.For<OrganizationStructureState>().SetProjection(Projections.Property("Id.SubsidiaryId"));
            criteria.Add(Subqueries.PropertyNotIn("PartyId", dc));
            NHibernateUtils.CriteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
            return criteria.List<Dddml.Wms.Domain.Party.OrganizationState>();
        }

        [Transaction(ReadOnly = true)]
        public virtual IEnumerable<IOrganizationStructureState> GetOrganizationTreeChildren(string parentId, IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders, int firstResult = 0, int maxResults = int.MaxValue)
        {
            var criteria = CurrentSession.CreateCriteria<OrganizationStructureState>();

            NHibernateUtils.CriteriaAddCriterion(criteria, "Id.ParentId", parentId);
            NHibernateUtils.CriteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
            return criteria.List<OrganizationStructureState>();
        }

        private void CriteriaAddOrganizationTreeRootParentIdCriterion(ICriteria criteria)
        {
            IList<object> rootParentIdValues = new object[] { null };
            if (rootParentIdValues.Count == 1)
            {
                NHibernateUtils.CriteriaAddCriterion(criteria, "Id.ParentId", rootParentIdValues[0]);
            }
            else
            {
                var j = Restrictions.Disjunction();
                foreach (var pIdValue in rootParentIdValues)
                {
                    NHibernateUtils.DisjunctionAddCriterion(j, "Id.ParentId", pIdValue);
                }
                criteria.Add(j);
            }
        }

	}
}

