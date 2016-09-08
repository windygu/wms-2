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
	public partial interface ILocatorStateRepository
	{
        ILocatorState Get(string id);

        ILocatorState Get(string id, bool nullAllowed);

        IEnumerable<ILocatorState> GetAll(int firstResult, int maxResults);
        
        void Save(ILocatorState state);
        
        IEnumerable<ILocatorState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        IEnumerable<ILocatorState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        ILocatorState GetFirst(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null);

        ILocatorState GetFirst(KeyValuePair<string, object> keyValue, IList<string> orders = null);

        IEnumerable<ILocatorState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        long GetCount(IEnumerable<KeyValuePair<string, object>> filter);

        long GetCount(ICriterion filter);

	}

}

