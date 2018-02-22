﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePhysicalInventoryDomainNHibernate.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PhysicalInventory;
using Dddml.Wms.Domain.InventoryItem;
using Dddml.Wms.Specialization.NHibernate;
using NHibernate;
using NHibernate.Criterion;
using Spring.Transaction.Interceptor;

namespace Dddml.Wms.Domain.PhysicalInventory.NHibernate
{

	public class NHibernatePhysicalInventoryLineStateEventDao : IPhysicalInventoryLineStateEventDao
	{
		public ISessionFactory SessionFactory { get; set; }

		protected ISession CurrentSession {
			get { return this.SessionFactory.GetCurrentSession (); }
		}

		public NHibernatePhysicalInventoryLineStateEventDao ()
		{
		}

		public void Save(IPhysicalInventoryLineStateEvent stateEvent)
		{
			CurrentSession.Save(stateEvent);
            var saveable = stateEvent as ISaveable;
            if (saveable != null)
            {
                saveable.Save();
            }
        }

        [Transaction(ReadOnly = true)]
        public IEnumerable<IPhysicalInventoryLineStateEvent> FindByPhysicalInventoryStateEventId(PhysicalInventoryStateEventId physicalInventoryStateEventId)
        {
            var criteria = CurrentSession.CreateCriteria<PhysicalInventoryLineStateEventBase>();
            var partIdCondition = Restrictions.Conjunction()
                .Add(Restrictions.Eq("StateEventId.PhysicalInventoryDocumentNumber", physicalInventoryStateEventId.DocumentNumber))
                .Add(Restrictions.Eq("StateEventId.PhysicalInventoryVersion", physicalInventoryStateEventId.Version))
                ;

            return criteria.Add(partIdCondition).List<PhysicalInventoryLineStateEventBase>();
        }

	}
}

