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
	public partial interface IUomTypeStateQueryRepository
	{
        IUomTypeState Get(string id);

        IEnumerable<IUomTypeState> GetAll(int firstResult, int maxResults);
        
        IEnumerable<IUomTypeState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        IEnumerable<IUomTypeState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        IUomTypeState GetFirst(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null);

        IUomTypeState GetFirst(KeyValuePair<string, object> keyValue, IList<string> orders = null);

        IEnumerable<IUomTypeState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        long GetCount(IEnumerable<KeyValuePair<string, object>> filter);

        long GetCount(ICriterion filter);

	}

}

