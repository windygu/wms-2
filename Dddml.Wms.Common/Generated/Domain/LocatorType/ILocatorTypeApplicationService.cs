﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateLocatorTypeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.LocatorType;
using Dddml.Support.Criterion;

namespace Dddml.Wms.Domain.LocatorType
{

	public partial interface ILocatorTypeApplicationService : IApplicationService
	{
		void When(ICreateLocatorType c);

		void When(IMergePatchLocatorType c);

		void When(IDeleteLocatorType c);

 		ILocatorTypeState Get(string locatorTypeId);

        IEnumerable<ILocatorTypeState> GetAll(int firstResult, int maxResults);

        IEnumerable<ILocatorTypeState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        IEnumerable<ILocatorTypeState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        IEnumerable<ILocatorTypeState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        long GetCount(IEnumerable<KeyValuePair<string, object>> filter);

        long GetCount(ICriterion filter);

        ILocatorTypeStateEvent GetStateEvent(string locatorTypeId, long version);

        ILocatorTypeState GetHistoryState(string locatorTypeId, long version);


	}

    public static partial class LocatorTypeApplicationServiceExtension
    {
        public static IEnumerable<ILocatorTypeState> GetByProperty(this ILocatorTypeApplicationService applicationService,
            System.Linq.Expressions.Expression<Func<ILocatorTypeState, object>> propertySelector, 
            object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return applicationService.GetByProperty(ReflectUtils.GetPropertyName<ILocatorTypeState>(propertySelector), propertyValue, orders, firstResult, maxResults);
        }

        public static IEnumerable<ILocatorTypeState> GetByProperty<TPropertyType>(this ILocatorTypeApplicationService applicationService,
            System.Linq.Expressions.Expression<Func<ILocatorTypeState, TPropertyType>> propertySelector,
            TPropertyType propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return applicationService.GetByProperty(ReflectUtils.GetPropertyName<ILocatorTypeState, TPropertyType>(propertySelector), propertyValue, orders, firstResult, maxResults);
        }
    }

}

