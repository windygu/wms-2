﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Support.Criterion;

namespace Dddml.Wms.Domain
{

	public partial interface IDayPlanMvoApplicationService : IApplicationService
	{
		void When(ICreateDayPlanMvo c);

		void When(IMergePatchDayPlanMvo c);

		void When(IDeleteDayPlanMvo c);

 		IDayPlanMvoState Get(DayPlanId dayPlanId);

        IEnumerable<IDayPlanMvoState> GetAll(int firstResult, int maxResults);

        IEnumerable<IDayPlanMvoState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        IEnumerable<IDayPlanMvoState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        IEnumerable<IDayPlanMvoState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        long GetCount(IEnumerable<KeyValuePair<string, object>> filter);

        long GetCount(ICriterion filter);

        IDayPlanMvoStateEvent GetStateEvent(DayPlanId dayPlanId, long version);


	}

}
