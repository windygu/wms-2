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

namespace Dddml.Wms.Domain.Shipment.NHibernate
{

	public class NHibernateShipmentItemStateEventDao : IShipmentItemStateEventDao
	{
		public ISessionFactory SessionFactory { get; set; }

		protected ISession CurrentSession {
			get { return this.SessionFactory.GetCurrentSession (); }
		}

		public NHibernateShipmentItemStateEventDao ()
		{
		}

		public void Save(IShipmentItemStateEvent stateEvent)
		{
			CurrentSession.Save(stateEvent);
            var saveable = stateEvent as ISaveable;
            if (saveable != null)
            {
                saveable.Save();
            }
        }

        [Transaction(ReadOnly = true)]
        public IEnumerable<IShipmentItemStateEvent> FindByShipmentStateEventId(ShipmentStateEventId shipmentStateEventId)
        {
            var criteria = CurrentSession.CreateCriteria<ShipmentItemStateEventBase>();
            var partIdCondition = Restrictions.Conjunction()
                .Add(Restrictions.Eq("StateEventId.ShipmentId", shipmentStateEventId.ShipmentId))
                .Add(Restrictions.Eq("StateEventId.ShipmentVersion", shipmentStateEventId.Version))
                ;

            return criteria.Add(partIdCondition).List<ShipmentItemStateEventBase>();
        }

	}
}

