﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainNHibernateAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Domain;

using Dddml.Wms.Specialization;
using Dddml.Wms.Specialization.NHibernate;
using NHibernate;
using NHibernate.Criterion;
using Spring.Transaction.Interceptor;

namespace Dddml.Wms.Domain.NHibernate
{

	public class NHibernateAttributeSetInstanceExtensionFieldStateDao : IAttributeSetInstanceExtensionFieldStateDao
	{
		public ISessionFactory SessionFactory { get; set; }

		protected ISession CurrentSession {
			get { return this.SessionFactory.GetCurrentSession (); }
		}

		public NHibernateAttributeSetInstanceExtensionFieldStateDao()
		{
		}
 

        [Transaction(ReadOnly = true)]
        public IAttributeSetInstanceExtensionFieldState Get(AttributeSetInstanceExtensionFieldId id)
        {
            IAttributeSetInstanceExtensionFieldState state = CurrentSession.Get<AttributeSetInstanceExtensionFieldState>(id);
            if (state == null)
            {
                state = new AttributeSetInstanceExtensionFieldState();
                (state as AttributeSetInstanceExtensionFieldState).AttributeSetInstanceExtensionFieldId = id;
            }
            return state;
        }

       
        public void Save(IAttributeSetInstanceExtensionFieldState state)
        {
            CurrentSession.SaveOrUpdate(state);
            var saveable = state as ISaveable;
            if (saveable != null)
            {
                saveable.Save();
            }
        }


        public void Delete(IAttributeSetInstanceExtensionFieldState state)
        {
            CurrentSession.Delete(state);
        }


        [Transaction(ReadOnly = true)]
        public IEnumerable<IAttributeSetInstanceExtensionFieldState> FindByGroupId(string groupId)
        {
            var criteria = CurrentSession.CreateCriteria<AttributeSetInstanceExtensionFieldState>();
            var partIdCondition = Restrictions.Conjunction()
                .Add(Restrictions.Eq("AttributeSetInstanceExtensionFieldId.GroupId", groupId))
                ;

            return criteria.Add(partIdCondition).List<AttributeSetInstanceExtensionFieldState>();
        }

    }

	
}

