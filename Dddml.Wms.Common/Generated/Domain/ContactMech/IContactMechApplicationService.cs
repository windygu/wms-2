﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateContactMechDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.ContactMech;
using Dddml.Support.Criterion;

namespace Dddml.Wms.Domain.ContactMech
{

	public partial interface IContactMechApplicationService : IApplicationService
	{
		void When(ICreateContactMech c);

		void When(IMergePatchContactMech c);

		void When(IDeleteContactMech c);

 		IContactMechState Get(string contactMechId);

        IEnumerable<IContactMechState> GetAll(int firstResult, int maxResults);

        IEnumerable<IContactMechState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        IEnumerable<IContactMechState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        IEnumerable<IContactMechState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        long GetCount(IEnumerable<KeyValuePair<string, object>> filter);

        long GetCount(ICriterion filter);

        IContactMechEvent GetEvent(string contactMechId, long version);

        IContactMechState GetHistoryState(string contactMechId, long version);


	}

    public static partial class ContactMechApplicationServiceExtension
    {
        public static IEnumerable<IContactMechState> GetByProperty(this IContactMechApplicationService applicationService,
            System.Linq.Expressions.Expression<Func<IContactMechState, object>> propertySelector, 
            object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return applicationService.GetByProperty(ReflectUtils.GetPropertyName<IContactMechState>(propertySelector), propertyValue, orders, firstResult, maxResults);
        }

        public static IEnumerable<IContactMechState> GetByProperty<TPropertyType>(this IContactMechApplicationService applicationService,
            System.Linq.Expressions.Expression<Func<IContactMechState, TPropertyType>> propertySelector,
            TPropertyType propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return applicationService.GetByProperty(ReflectUtils.GetPropertyName<IContactMechState, TPropertyType>(propertySelector), propertyValue, orders, firstResult, maxResults);
        }
    }

}

