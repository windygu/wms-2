﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInOutNoticeDomainNHibernate.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InOutNotice;
using Dddml.Wms.Specialization.NHibernate;
using NHibernate;
using NHibernate.Criterion;
using Spring.Transaction.Interceptor;
using Dddml.Support.Criterion;
using NHibernateICriterion = NHibernate.Criterion.ICriterion;
using NHibernateRestrictions = NHibernate.Criterion.Restrictions;
using NHibernateDisjunction = NHibernate.Criterion.Disjunction;

namespace Dddml.Wms.Domain.InOutNotice.NHibernate
{

	public partial class NHibernateInOutNoticeStateRepository : IInOutNoticeStateRepository
	{
		public ISessionFactory SessionFactory { get; set; }

		protected ISession CurrentSession {
			get { return this.SessionFactory.GetCurrentSession (); }
		}

        private static readonly ISet<string> _readOnlyPropertyNames = new SortedSet<string>(new String[] { "InOutNoticeId", "WarehouseId", "InOutNoticeType", "TelecomContactMechId", "TrackingNumber", "ContactPartyId", "VehiclePlateNumber", "ShippingInstructions", "EstimatedShipDate", "EstimatedDeliveryDate", "StatusId", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted" });
    
        public IReadOnlyProxyGenerator ReadOnlyProxyGenerator { get; set; }

		public NHibernateInOutNoticeStateRepository()
		{
		}

		[Transaction (ReadOnly = true)]
		public IInOutNoticeState Get(string id, bool nullAllowed)
		{
			IInOutNoticeState state = CurrentSession.Get<InOutNoticeState> (id);
			if (!nullAllowed && state == null) {
				state = new InOutNoticeState ();
				(state as InOutNoticeState).InOutNoticeId = id;
			}
            if (ReadOnlyProxyGenerator != null && state != null)
            {
                return ReadOnlyProxyGenerator.CreateProxy<IInOutNoticeState>(state, new Type[] {  }, _readOnlyPropertyNames);
            }
			return state;
		}

		[Transaction]
		public void Save(IInOutNoticeState state)
		{
            IInOutNoticeState s = state;
            if (ReadOnlyProxyGenerator != null)
            {
                s = ReadOnlyProxyGenerator.GetTarget<IInOutNoticeState>(state);
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

