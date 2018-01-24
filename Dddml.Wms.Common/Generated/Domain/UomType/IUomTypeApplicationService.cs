﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateUomTypeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.UomType;
using Dddml.Support.Criterion;

namespace Dddml.Wms.Domain.UomType
{

	public partial interface IUomTypeApplicationService : IApplicationService
	{
		void When(ICreateUomType c);

		void When(IMergePatchUomType c);

		void When(IDeleteUomType c);

 		IUomTypeState Get(string uomTypeId);

        IEnumerable<IUomTypeState> GetAll(int firstResult, int maxResults);

        IEnumerable<IUomTypeState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        IEnumerable<IUomTypeState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        IEnumerable<IUomTypeState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        long GetCount(IEnumerable<KeyValuePair<string, object>> filter);

        long GetCount(ICriterion filter);


	}

    public static partial class UomTypeApplicationServiceExtension
    {
        public static IEnumerable<IUomTypeState> GetByProperty(this IUomTypeApplicationService applicationService,
            System.Linq.Expressions.Expression<Func<IUomTypeState, object>> propertySelector, 
            object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return applicationService.GetByProperty(ReflectUtils.GetPropertyName<IUomTypeState>(propertySelector), propertyValue, orders, firstResult, maxResults);
        }

        public static IEnumerable<IUomTypeState> GetByProperty<TPropertyType>(this IUomTypeApplicationService applicationService,
            System.Linq.Expressions.Expression<Func<IUomTypeState, TPropertyType>> propertySelector,
            TPropertyType propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return applicationService.GetByProperty(ReflectUtils.GetPropertyName<IUomTypeState, TPropertyType>(propertySelector), propertyValue, orders, firstResult, maxResults);
        }
    }

}

