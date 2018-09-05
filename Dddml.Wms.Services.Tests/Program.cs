﻿using Dddml.Wms.Specialization;
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
            //var dotGraphStr = DotGraphTests.GetTestOutputDotGraph();
            //using (System.IO.StreamWriter w = new System.IO.StreamWriter("testDocStateMachine.dot", false, new System.Text.UTF8Encoding(false)))
            //{
            //    w.Write(dotGraphStr);
            //    w.Close();
            //}
            //return;

            var initdb = new InitDatabase();
            initdb.SetUp();

            //
            // 注意把数据文件拷贝到 exe 的 Data 目录下
            //
            //var xmlDataLoader1 = new XmlDataLoader();
            //xmlDataLoader1.Process(".\\Data", "*ShipmentMethodTypeData.xml");
            //Console.ReadKey();
            //return;

            initdb.Hbm2DdlOutput();
            Console.WriteLine("Output hbm2ddl files, ok.");

            initdb.CopyAndFixHbm2DdlCreateSql();
            Console.WriteLine("Copy and fix hbm2ddl creation sql, ok.");

            initdb.CreateDatabaseAndSeed();

            //// ////////////////////////
            //var xmlDataLoader = new XmlDataLoader();
            //xmlDataLoader.Process(".\\Data");
            ////Console.ReadKey();
            ////return;
            //// ////////////////////////

            //// /////////////////////////
            //InitInventoryPostingRules.CreateDefaultInventoryPostingRules();
            //// /////////////////////////

            // ////////////////////////
            // TestMain.DoSomeTests();
            // ////////////////////////
            
            Console.WriteLine("Create database and seed and test, ok.");

            Console.ReadKey();
        }


        //class C1 { public int IF1 { get; set; } public string SF1 { get; set; } }
        //private static void TestReflectUtils() 
        //{
        //    ReflectUtils.GetPropertyName<C1, int>(c => c.IF1);
        //}

    }

}
