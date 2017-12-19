using Dddml.Wms.Specialization;
using Dddml.Wms.Specialization.Spring;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Dddml.Wms.Domain;
using NUnit.Framework;
using Dddml.Wms.Support;
using System.Security.Cryptography;

namespace Dddml.Wms.Services.Tests
{
    
    class Program
    {
        static void Main(string[] args)
        {

            var initdb = new InitDatabase();
            initdb.SetUp();

            initdb.Hbm2DdlOutput();
            Console.WriteLine("Output hbm2ddl files, ok.");

            initdb.CopyAndFixHbm2DdlCreateSql();
            Console.WriteLine("Copy and fix hbm2ddl creation sql, ok.");

            initdb.CreateDatabaseAndSeed();

            // //////////////////////
            //var xmlDataLoader = new XmlDataLoader();
            //xmlDataLoader.Process(".\\");
            //Console.ReadKey();
            //return;
            // ////////////////////

            // ////////////////////////
            TestMain.DoSomeTests();
            // ////////////////////////
            
            Console.WriteLine("Create database and seed and test, ok.");

            Console.ReadKey();
        }
    }

}
