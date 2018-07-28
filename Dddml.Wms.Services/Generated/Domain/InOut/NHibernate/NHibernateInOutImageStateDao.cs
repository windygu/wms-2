﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInOutDomainNHibernate.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InOut;
using Dddml.Wms.Specialization.NHibernate;
using NHibernate;
using NHibernate.Criterion;
using Spring.Transaction.Interceptor;

namespace Dddml.Wms.Domain.InOut.NHibernate
{

	public class NHibernateInOutImageStateDao : IInOutImageStateDao
	{
		public ISessionFactory SessionFactory { get; set; }

		protected ISession CurrentSession {
			get { return this.SessionFactory.GetCurrentSession (); }
		}

        private static readonly ISet<string> _readOnlyPropertyNames = new SortedSet<string>(new String[] { "SequenceId", "Url", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "InOutDocumentNumber" });
    
        public IReadOnlyProxyGenerator ReadOnlyProxyGenerator { get; set; }

		public NHibernateInOutImageStateDao()
		{
		}

        [Transaction(ReadOnly = true)]
        public IInOutImageState Get(InOutImageId id, bool nullAllowed)
        {
            IInOutImageState state = CurrentSession.Get<InOutImageState>(id);
            if (!nullAllowed && state == null)
            {
                state = new InOutImageState();
                (state as InOutImageState).InOutImageId = id;
            }
            if (ReadOnlyProxyGenerator != null && state != null)
            {
                return ReadOnlyProxyGenerator.CreateProxy<IInOutImageState>(state, new Type[] {  }, _readOnlyPropertyNames);
            }
            return state;
        }

       
        public void Save(IInOutImageState state)
        {
            IInOutImageState s = state;
            if (ReadOnlyProxyGenerator != null)
            {
                s = ReadOnlyProxyGenerator.GetTarget<IInOutImageState>(state);
            }
            CurrentSession.SaveOrUpdate(s);
            var saveable = s as ISaveable;
            if (saveable != null)
            {
                saveable.Save();
            }
        }


        public void Delete(IInOutImageState state)
        {
            IInOutImageState s = state;
            if (ReadOnlyProxyGenerator != null)
            {
                s = ReadOnlyProxyGenerator.GetTarget<IInOutImageState>(state);
            }
            var saveable = s as ISaveable;
            if (saveable != null)
            {
                saveable.Save();
            }
            CurrentSession.Delete(s);
        }


        [Transaction(ReadOnly = true)]
        public IEnumerable<IInOutImageState> FindByInOutDocumentNumber(string inOutDocumentNumber)
        {
            var criteria = CurrentSession.CreateCriteria<InOutImageState>();
            var partIdCondition = Restrictions.Conjunction()
                .Add(Restrictions.Eq("InOutImageId.InOutDocumentNumber", inOutDocumentNumber))
                ;

            return criteria.Add(partIdCondition).List<InOutImageState>();
        }

    }

	
}
