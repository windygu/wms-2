using NHibernate;
using NHibernate.Impl;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Specialization.NHibernate
{
    public class TableIdGenerator : IIdGenerator<long, object, object>
    {
        private const string _defaultRootEntityName = "Dddml.Wms.Services.Domain.Hello.HelloState";

        private string _rootEntityName = _defaultRootEntityName;

        public string RootEntityName
        {
            get { return _rootEntityName; }
            set { _rootEntityName = value; }
        }

        private ISessionFactory _sessionFactory;

        public ISessionFactory SessionFactory
        {
            get
            {
                if (_sessionFactory == null)
                {
                    _sessionFactory = (ISessionFactory)ApplicationContext.Current["NHibernateSessionFactory"];
                }
                return _sessionFactory;
            }
        }

        public long GenerateId(object command)
        {
            return GetNextId();
        }

        public long GetNextId()
        {
            var idGen = ((SessionFactoryImpl)SessionFactory).GetIdentifierGenerator(RootEntityName);
            SessionImpl session = (SessionImpl)SessionFactory.OpenSession();
            try
            {
                //System.out.println("================ Table Id Generator =================");
                var id = idGen.Generate(session, null);
                return Convert.ToInt64(id);
            }
            finally
            {
                session.Close();
            }
        }

        public bool Equals(object command, object state)
        {
            throw new NotSupportedException();
        }

        public bool IsSurrogateIdEnabled()
        {
            return true;
        }
    }
}
