﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateRoleTypeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.RoleType;
using Dddml.Support.Criterion;

namespace Dddml.Wms.Domain.RoleType
{
	public partial interface IRoleTypeStateQueryRepository
	{
        IRoleTypeState Get(string id);

        IEnumerable<IRoleTypeState> GetAll(int firstResult, int maxResults);
        
        IEnumerable<IRoleTypeState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        IEnumerable<IRoleTypeState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        IRoleTypeState GetFirst(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null);

        IRoleTypeState GetFirst(KeyValuePair<string, object> keyValue, IList<string> orders = null);

        IEnumerable<IRoleTypeState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        long GetCount(IEnumerable<KeyValuePair<string, object>> filter);

        long GetCount(ICriterion filter);

	}

}
