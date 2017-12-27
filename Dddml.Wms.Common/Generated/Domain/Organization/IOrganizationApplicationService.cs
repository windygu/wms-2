﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateOrganizationDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Organization;
using Dddml.Support.Criterion;

namespace Dddml.Wms.Domain.Organization
{

	public partial interface IOrganizationApplicationService : IApplicationService
	{
		void When(ICreateOrganization c);

		void When(IMergePatchOrganization c);

		void When(IDeleteOrganization c);

 		IOrganizationState Get(string partyId);

        IEnumerable<IOrganizationState> GetAll(int firstResult, int maxResults);

        IEnumerable<IOrganizationState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        IEnumerable<IOrganizationState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        IEnumerable<IOrganizationState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        long GetCount(IEnumerable<KeyValuePair<string, object>> filter);

        long GetCount(ICriterion filter);

        IOrganizationStateEvent GetStateEvent(string partyId, long version);

        IOrganizationState GetHistoryState(string partyId, long version);


	}

    public static partial class OrganizationApplicationServiceExtension
    {
        public static IEnumerable<IOrganizationState> GetByProperty(this IOrganizationApplicationService applicationService,
            System.Linq.Expressions.Expression<Func<IOrganizationState, object>> propertySelector, 
            object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return applicationService.GetByProperty(ReflectUtils.GetPropertyName<IOrganizationState>(propertySelector), propertyValue, orders, firstResult, maxResults);
        }

        public static IEnumerable<IOrganizationState> GetByProperty<TPropertyType>(this IOrganizationApplicationService applicationService,
            System.Linq.Expressions.Expression<Func<IOrganizationState, TPropertyType>> propertySelector,
            TPropertyType propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return applicationService.GetByProperty(ReflectUtils.GetPropertyName<IOrganizationState, TPropertyType>(propertySelector), propertyValue, orders, firstResult, maxResults);
        }
    }

}

