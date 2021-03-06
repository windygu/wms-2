﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainNHibernateAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.User;
using Dddml.Wms.Specialization.NHibernate;
using NHibernate;
using NHibernate.Criterion;
using Spring.Transaction.Interceptor;

namespace Dddml.Wms.Domain.User.NHibernate
{

	public class NHibernateUserPermissionStateDao : IUserPermissionStateDao
	{
		public ISessionFactory SessionFactory { get; set; }

		protected ISession CurrentSession {
			get { return this.SessionFactory.GetCurrentSession (); }
		}

        private static readonly ISet<string> _readOnlyPropertyNames = new SortedSet<string>(new String[] { "PermissionId", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "UserId" });
    
        public IReadOnlyProxyGenerator ReadOnlyProxyGenerator { get; set; }

		public NHibernateUserPermissionStateDao()
		{
		}

        [Transaction(ReadOnly = true)]
        public IUserPermissionState Get(UserPermissionId id, bool nullAllowed)
        {
            IUserPermissionState state = CurrentSession.Get<UserPermissionState>(id);
            if (!nullAllowed && state == null)
            {
                state = new UserPermissionState();
                (state as UserPermissionState).UserPermissionId = id;
            }
            if (ReadOnlyProxyGenerator != null && state != null)
            {
                return ReadOnlyProxyGenerator.CreateProxy<IUserPermissionState>(state, new Type[] {  }, _readOnlyPropertyNames);
            }
            return state;
        }

       
        public void Save(IUserPermissionState state)
        {
            IUserPermissionState s = state;
            if (ReadOnlyProxyGenerator != null)
            {
                s = ReadOnlyProxyGenerator.GetTarget<IUserPermissionState>(state);
            }
            CurrentSession.SaveOrUpdate(s);
            var saveable = s as ISaveable;
            if (saveable != null)
            {
                saveable.Save();
            }
        }


        public void Delete(IUserPermissionState state)
        {
            IUserPermissionState s = state;
            if (ReadOnlyProxyGenerator != null)
            {
                s = ReadOnlyProxyGenerator.GetTarget<IUserPermissionState>(state);
            }
            var saveable = s as ISaveable;
            if (saveable != null)
            {
                saveable.Save();
            }
            CurrentSession.Delete(s);
        }


        [Transaction(ReadOnly = true)]
        public IEnumerable<IUserPermissionState> FindByUserId(string userId)
        {
            var criteria = CurrentSession.CreateCriteria<UserPermissionState>();
            var partIdCondition = Restrictions.Conjunction()
                .Add(Restrictions.Eq("UserPermissionId.UserId", userId))
                ;

            return criteria.Add(partIdCondition).List<UserPermissionState>();
        }

    }

	
}

