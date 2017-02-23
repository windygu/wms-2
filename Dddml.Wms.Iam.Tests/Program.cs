using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dddml.Wms.Iam.Tests
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
            Console.WriteLine("Create database and seed, ok.");

            Console.ReadKey();
        }
    }
}
