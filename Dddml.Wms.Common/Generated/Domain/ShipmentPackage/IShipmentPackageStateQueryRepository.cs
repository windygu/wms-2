﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateShipmentPackageDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.ShipmentPackage;
using Dddml.Support.Criterion;

namespace Dddml.Wms.Domain.ShipmentPackage
{
	public partial interface IShipmentPackageStateQueryRepository
	{
        IShipmentPackageState Get(ShipmentPackageId id);

        IEnumerable<IShipmentPackageState> GetAll(int firstResult, int maxResults);
        
        IEnumerable<IShipmentPackageState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        IEnumerable<IShipmentPackageState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        IShipmentPackageState GetFirst(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null);

        IShipmentPackageState GetFirst(KeyValuePair<string, object> keyValue, IList<string> orders = null);

        IEnumerable<IShipmentPackageState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        long GetCount(IEnumerable<KeyValuePair<string, object>> filter);

        long GetCount(ICriterion filter);

        IShipmentPackageContentState GetShipmentPackageContent(ShipmentPackageId shipmentPackageId, string shipmentItemSeqId);

        IEnumerable<IShipmentPackageContentState> GetShipmentPackageContents(ShipmentPackageId shipmentPackageId);

	}

}

