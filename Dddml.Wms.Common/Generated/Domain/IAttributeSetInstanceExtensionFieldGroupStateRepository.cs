﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Domain;


namespace Dddml.Wms.Domain
{
	public interface IAttributeSetInstanceExtensionFieldGroupStateRepository
	{
        IAttributeSetInstanceExtensionFieldGroupState Get(string id);

        IEnumerable<IAttributeSetInstanceExtensionFieldGroupState> GetAll(int firstResult, int maxResults);
        
        void Save(IAttributeSetInstanceExtensionFieldGroupState state);
        
        IEnumerable<IAttributeSetInstanceExtensionFieldGroupState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        IAttributeSetInstanceExtensionFieldGroupState GetFirst(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null);

        IAttributeSetInstanceExtensionFieldGroupState GetFirst(KeyValuePair<string, object> keyValue, IList<string> orders = null);

	}

}

