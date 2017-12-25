﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePhysicalInventoryLineMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PhysicalInventoryLineMvo;
using Dddml.Wms.Domain.PhysicalInventory;
using Dddml.Support.Criterion;

namespace Dddml.Wms.Domain.PhysicalInventoryLineMvo
{
	public partial interface IPhysicalInventoryLineMvoStateQueryRepository
	{
        IPhysicalInventoryLineMvoState Get(PhysicalInventoryLineId id);

        IEnumerable<IPhysicalInventoryLineMvoState> GetAll(int firstResult, int maxResults);
        
        IEnumerable<IPhysicalInventoryLineMvoState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        IEnumerable<IPhysicalInventoryLineMvoState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        IPhysicalInventoryLineMvoState GetFirst(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null);

        IPhysicalInventoryLineMvoState GetFirst(KeyValuePair<string, object> keyValue, IList<string> orders = null);

        IEnumerable<IPhysicalInventoryLineMvoState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        long GetCount(IEnumerable<KeyValuePair<string, object>> filter);

        long GetCount(ICriterion filter);

	}

}

