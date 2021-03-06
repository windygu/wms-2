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

	public class NHibernateInOutLineImageStateDao : IInOutLineImageStateDao
	{
		public ISessionFactory SessionFactory { get; set; }

		protected ISession CurrentSession {
			get { return this.SessionFactory.GetCurrentSession (); }
		}

        private static readonly ISet<string> _readOnlyPropertyNames = new SortedSet<string>(new String[] { "SequenceId", "Url", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "InOutDocumentNumber", "InOutLineLineNumber" });
    
        public IReadOnlyProxyGenerator ReadOnlyProxyGenerator { get; set; }

		public NHibernateInOutLineImageStateDao()
		{
		}

        [Transaction(ReadOnly = true)]
        public IInOutLineImageState Get(InOutLineImageId id, bool nullAllowed)
        {
            IInOutLineImageState state = CurrentSession.Get<InOutLineImageState>(id);
            if (!nullAllowed && state == null)
            {
                state = new InOutLineImageState();
                (state as InOutLineImageState).InOutLineImageId = id;
            }
            if (ReadOnlyProxyGenerator != null && state != null)
            {
                return ReadOnlyProxyGenerator.CreateProxy<IInOutLineImageState>(state, new Type[] {  }, _readOnlyPropertyNames);
            }
            return state;
        }

       
        public void Save(IInOutLineImageState state)
        {
            IInOutLineImageState s = state;
            if (ReadOnlyProxyGenerator != null)
            {
                s = ReadOnlyProxyGenerator.GetTarget<IInOutLineImageState>(state);
            }
            CurrentSession.SaveOrUpdate(s);
            var saveable = s as ISaveable;
            if (saveable != null)
            {
                saveable.Save();
            }
        }


        public void Delete(IInOutLineImageState state)
        {
            IInOutLineImageState s = state;
            if (ReadOnlyProxyGenerator != null)
            {
                s = ReadOnlyProxyGenerator.GetTarget<IInOutLineImageState>(state);
            }
            var saveable = s as ISaveable;
            if (saveable != null)
            {
                saveable.Save();
            }
            CurrentSession.Delete(s);
        }


        [Transaction(ReadOnly = true)]
        public IEnumerable<IInOutLineImageState> FindByInOutDocumentNumberAndInOutLineLineNumber(string inOutDocumentNumber, string inOutLineLineNumber)
        {
            var criteria = CurrentSession.CreateCriteria<InOutLineImageState>();
            var partIdCondition = Restrictions.Conjunction()
                .Add(Restrictions.Eq("InOutLineImageId.InOutDocumentNumber", inOutDocumentNumber))
                .Add(Restrictions.Eq("InOutLineImageId.InOutLineLineNumber", inOutLineLineNumber))
                ;

            return criteria.Add(partIdCondition).List<InOutLineImageState>();
        }

    }

	
}

