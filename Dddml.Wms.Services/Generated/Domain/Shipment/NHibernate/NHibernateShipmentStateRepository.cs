﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateShipmentDomainNHibernate.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Shipment;
using Dddml.Wms.Specialization.NHibernate;
using NHibernate;
using NHibernate.Criterion;
using Spring.Transaction.Interceptor;
using Dddml.Support.Criterion;
using NHibernateICriterion = NHibernate.Criterion.ICriterion;
using NHibernateRestrictions = NHibernate.Criterion.Restrictions;
using NHibernateDisjunction = NHibernate.Criterion.Disjunction;

namespace Dddml.Wms.Domain.Shipment.NHibernate
{

	public partial class NHibernateShipmentStateRepository : IShipmentStateRepository
	{
		public ISessionFactory SessionFactory { get; set; }

		protected ISession CurrentSession {
			get { return this.SessionFactory.GetCurrentSession (); }
		}

        private static readonly ISet<string> _readOnlyPropertyNames = new SortedSet<string>(new String[] { "ShipmentId", "ShipmentTypeId", "StatusId", "PrimaryOrderId", "PrimaryReturnId", "PrimaryShipGroupSeqId", "OnlyOneOrder", "PicklistBinId", "BolNumber", "SealNumber", "VehicleId", "ExternalOrderNumber", "Carrier", "DateShipped", "EstimatedReadyDate", "EstimatedShipDate", "EstimatedShipWorkEffId", "EstimatedArrivalDate", "EstimatedArrivalWorkEffId", "LatestCancelDate", "EstimatedShipCost", "CurrencyUomId", "HandlingInstructions", "OriginFacilityId", "DestinationFacilityId", "OriginContactMechId", "OriginTelecomNumberId", "DestinationContactMechId", "DestinationTelecomNumberId", "PartyIdTo", "PartyIdFrom", "AdditionalShippingCharge", "AddtlShippingChargeDesc", "ShipmentItems", "ShipmentReceipts", "ItemIssuances", "ShipmentImages", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted" });
    
        public IReadOnlyProxyGenerator ReadOnlyProxyGenerator { get; set; }

		public NHibernateShipmentStateRepository()
		{
		}

		[Transaction (ReadOnly = true)]
		public IShipmentState Get(string id, bool nullAllowed)
		{
			IShipmentState state = CurrentSession.Get<ShipmentState> (id);
			if (!nullAllowed && state == null) {
				state = new ShipmentState ();
				(state as ShipmentState).ShipmentId = id;
			}
            if (ReadOnlyProxyGenerator != null && state != null)
            {
                return ReadOnlyProxyGenerator.CreateProxy<IShipmentState>(state, new Type[] { typeof(ISaveable) }, _readOnlyPropertyNames);
            }
			return state;
		}

		[Transaction]
		public void Save(IShipmentState state)
		{
            IShipmentState s = state;
            if (ReadOnlyProxyGenerator != null)
            {
                s = ReadOnlyProxyGenerator.GetTarget<IShipmentState>(state);
            }
			CurrentSession.SaveOrUpdate (s);

			var saveable = s as ISaveable;
			if (saveable != null) {
				saveable.Save ();
			}
            CurrentSession.Flush();
		}

        //protected static void AddNotDeletedRestriction(ICriteria criteria)
        //{
        //    criteria.Add(NHibernateRestrictions.Eq("Deleted", false));
        //}

	}
}

