﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateGoodIdentificationTypeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.GoodIdentificationType;
using Dddml.Support.Criterion;

namespace Dddml.Wms.Domain.GoodIdentificationType
{
	public partial interface IGoodIdentificationTypeStateQueryRepository
	{
        IGoodIdentificationTypeState Get(string id);

        IEnumerable<IGoodIdentificationTypeState> GetAll(int firstResult, int maxResults);
        
        IEnumerable<IGoodIdentificationTypeState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        IEnumerable<IGoodIdentificationTypeState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        IGoodIdentificationTypeState GetFirst(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null);

        IGoodIdentificationTypeState GetFirst(KeyValuePair<string, object> keyValue, IList<string> orders = null);

        IEnumerable<IGoodIdentificationTypeState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        long GetCount(IEnumerable<KeyValuePair<string, object>> filter);

        long GetCount(ICriterion filter);

	}

}

