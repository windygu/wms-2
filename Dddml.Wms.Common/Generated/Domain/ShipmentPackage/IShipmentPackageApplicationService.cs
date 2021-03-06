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

	public partial interface IShipmentPackageApplicationService : IApplicationService
	{
		void When(ICreateShipmentPackage c);

		void When(IMergePatchShipmentPackage c);

		void When(IDeleteShipmentPackage c);

 		IShipmentPackageState Get(ShipmentPackageId shipmentPackageId);

        IEnumerable<IShipmentPackageState> GetAll(int firstResult, int maxResults);

        IEnumerable<IShipmentPackageState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        IEnumerable<IShipmentPackageState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        IEnumerable<IShipmentPackageState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue);

        long GetCount(IEnumerable<KeyValuePair<string, object>> filter);

        long GetCount(ICriterion filter);

        IShipmentPackageEvent GetEvent(ShipmentPackageId shipmentPackageId, long version);

        IShipmentPackageState GetHistoryState(ShipmentPackageId shipmentPackageId, long version);

        IShipmentPackageContentState GetShipmentPackageContent(ShipmentPackageId shipmentPackageId, string shipmentItemSeqId);

        IEnumerable<IShipmentPackageContentState> GetShipmentPackageContents(ShipmentPackageId shipmentPackageId);


	}

    public static partial class ShipmentPackageApplicationServiceExtension
    {
        public static IEnumerable<IShipmentPackageState> GetByProperty(this IShipmentPackageApplicationService applicationService,
            System.Linq.Expressions.Expression<Func<IShipmentPackageState, object>> propertySelector, 
            object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return applicationService.GetByProperty(ReflectUtils.GetPropertyName<IShipmentPackageState>(propertySelector), propertyValue, orders, firstResult, maxResults);
        }

        public static IEnumerable<IShipmentPackageState> GetByProperty<TPropertyType>(this IShipmentPackageApplicationService applicationService,
            System.Linq.Expressions.Expression<Func<IShipmentPackageState, TPropertyType>> propertySelector,
            TPropertyType propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return applicationService.GetByProperty(ReflectUtils.GetPropertyName<IShipmentPackageState, TPropertyType>(propertySelector), propertyValue, orders, firstResult, maxResults);
        }
    }

}

