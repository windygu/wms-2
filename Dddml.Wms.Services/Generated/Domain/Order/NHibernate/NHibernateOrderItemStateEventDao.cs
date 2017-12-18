﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateOrderDomainNHibernate.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Order;
using Dddml.Wms.Specialization.NHibernate;
using NHibernate;
using NHibernate.Criterion;
using Spring.Transaction.Interceptor;

namespace Dddml.Wms.Domain.Order.NHibernate
{

	public class NHibernateOrderItemStateEventDao : IOrderItemStateEventDao
	{
		public ISessionFactory SessionFactory { get; set; }

		protected ISession CurrentSession {
			get { return this.SessionFactory.GetCurrentSession (); }
		}

		public NHibernateOrderItemStateEventDao ()
		{
		}

		public void Save(IOrderItemStateEvent stateEvent)
		{
			CurrentSession.Save(stateEvent);
            var saveable = stateEvent as ISaveable;
            if (saveable != null)
            {
                saveable.Save();
            }
        }

        [Transaction(ReadOnly = true)]
        public IEnumerable<IOrderItemStateEvent> FindByOrderStateEventId(OrderStateEventId orderStateEventId)
        {
            var criteria = CurrentSession.CreateCriteria<OrderItemStateEventBase>();
            var partIdCondition = Restrictions.Conjunction()
                .Add(Restrictions.Eq("StateEventId.OrderId", orderStateEventId.OrderId))
                .Add(Restrictions.Eq("StateEventId.OrderVersion", orderStateEventId.Version))
                ;

            return criteria.Add(partIdCondition).List<OrderItemStateEventBase>();
        }

	}
}

