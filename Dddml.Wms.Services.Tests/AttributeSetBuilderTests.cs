using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Attribute;
using Dddml.Wms.Domain.AttributeSet;
using Dddml.Wms.Specialization;
using Dddml.Wms.Specialization.Spring;
using Dddml.Wms.Support;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;
using System.Linq;

namespace Dddml.Wms.Services.Tests
{
    [TestFixture]
    public class AttributeSetBuilderTests : TestsBase
    {

        IAttributeSetApplicationService attributeSetApplicationService;

        IAttributeApplicationService attributeApplicationService;
        

        [SetUp]
        public void SetUp()
        {
            base.SetUp();

            attributeSetApplicationService = ApplicationContext.Current["attributeSetApplicationService"] as IAttributeSetApplicationService;
            attributeApplicationService = ApplicationContext.Current["attributeApplicationService"] as IAttributeApplicationService;

        }

        private static IDictionary<string, string> _typeMap = new Tuple<string, string>[] {
            new Tuple<string, string>("String", "string"),
            new Tuple<string, string>("bool", "bool?"),
            new Tuple<string, string>("boolean", "bool?"),
            new Tuple<string, string>("Boolean", "bool?"),
            new Tuple<string, string>("DateTime", "DateTime?"),
            new Tuple<string, string>("int", "int?"),
            new Tuple<string, string>("Int32", "int?"),
            new Tuple<string, string>("long", "long?"),
            new Tuple<string, string>("Int64", "long?"),
            new Tuple<string, string>("decimal", "decimal?"),
            new Tuple<string, string>("Decimal", "decimal?"),
            new Tuple<string, string>("byte", "byte?"),
            new Tuple<string, string>("Byte", "byte?"),
            new Tuple<string, string>("char", "char?"),
            new Tuple<string, string>("Char", "char?"),
        }.ToDictionary(p => p.Item1, p => p.Item2);
    
        [Test]
        public void TestGetAllAttributes()
        {
            var allAttrs = attributeApplicationService.GetAll(0, int.MaxValue);
            var format = "new ExtensionFieldMetadata(\"{0}\", \"{1}\", {2}),";
            foreach (var attr in allAttrs)
            {
                System.Console.WriteLine(String.Format(format,
                    attr.AttributeName,
                    _typeMap.ContainsKey(attr.AttributeValueType) ? _typeMap[attr.AttributeValueType] : attr.AttributeValueType, 
                    attr.AttributeValueLength == null ? "null" : attr.AttributeValueLength.Value.ToString()));
            }
        }

        [Test]
        public void TestAttributeSetBuilder()
        {
            var attributeSetBuilder = new AttributeSetBuilder<CreateAttributeSet, CreateAttribute, CreateAttributeValue, CreateAttributeUse>(new IdGenerator());


            IList<CreateAttribute> attrs;
            IList<CreateAttributeValue> attrVals;
            IList<CreateAttributeSet> attrSets;
            IList<CreateAttributeUse> attrUses;

            //try
            //{

            ////////////////////////////////////////////
            TestBuildUsingAnnotations(attributeSetBuilder, out attrs, out attrVals, out attrSets, out attrUses);

            ////////////////////////////////////////////
            TestBuildUsingAnnotationAndEnum(attributeSetBuilder, ref attrs, ref attrVals, ref attrSets, ref attrUses);

            ////////////////////////////////////////////

            TestBuildUsingConsts(attributeSetBuilder, ref attrs, ref attrVals, ref attrSets, ref attrUses);

            ////////////////////////////////////////////
            TestBuildUsingEnum(attributeSetBuilder, ref attrs, ref attrVals, ref attrSets, ref attrUses);

            //}
            //catch (Exception ex)
            //{
            //    System.Console.WriteLine(ex.Message);
            //}
            ////////////////////////////////////////////

            System.Console.WriteLine(attributeSetApplicationService.GetAll(0, int.MaxValue));

        }

        private void TestBuildUsingEnum(AttributeSetBuilder<CreateAttributeSet, CreateAttribute, CreateAttributeValue, CreateAttributeUse> attributeSetBuilder, ref IList<CreateAttribute> attrs, ref IList<CreateAttributeValue> attrVals, ref IList<CreateAttributeSet> attrSets, ref IList<CreateAttributeUse> attrUses)
        {

            attributeSetBuilder.BuildAttributeSetsFromEntityType(typeof(AttributeSetInstanceTestClass4), out attrSets, out attrs, out attrVals, out attrUses);

            Assert.AreEqual(1, attrSets.Count); //System.Console.WriteLine(attrSets);
            Assert.AreEqual(1, attrs.Count); //System.Console.WriteLine(attrs);
            Assert.IsTrue(attrs[0].IsList);
            Assert.AreEqual((typeof(int)).Name, attrs[0].AttributeValueType);
            Assert.AreEqual(7, attrVals.Count); //System.Console.WriteLine(attrVals);

            Save(attrs, attrSets);
        }

        private void TestBuildUsingConsts(AttributeSetBuilder<CreateAttributeSet, CreateAttribute, CreateAttributeValue, CreateAttributeUse> attributeSetBuilder, ref IList<CreateAttribute> attrs, ref IList<CreateAttributeValue> attrVals, ref IList<CreateAttributeSet> attrSets, ref IList<CreateAttributeUse> attrUses)
        {
            attributeSetBuilder.BuildAttributeSetsFromEntityType(typeof(AttributeSetInstanceTestClass3), out attrSets, out attrs, out attrVals, out attrUses);

            Assert.AreEqual(1, attrSets.Count); //System.Console.WriteLine(attrSets);
            Assert.AreEqual(1, attrs.Count); //System.Console.WriteLine(attrs);
            Assert.IsTrue(attrs[0].IsList);
            Assert.AreEqual((typeof(string)).Name, attrs[0].AttributeValueType);
            Assert.AreEqual(3, attrVals.Count); //System.Console.WriteLine(attrVals);
            System.Console.WriteLine(attrUses);

            Save(attrs, attrSets);
        }

        private void TestBuildUsingAnnotationAndEnum(AttributeSetBuilder<CreateAttributeSet, CreateAttribute, CreateAttributeValue, CreateAttributeUse> attributeSetBuilder, ref IList<CreateAttribute> attrs, ref IList<CreateAttributeValue> attrVals, ref IList<CreateAttributeSet> attrSets, ref IList<CreateAttributeUse> attrUses)
        {

            attributeSetBuilder.BuildAttributeSetsFromEntityType(typeof(AttributeSetInstanceTestClass2), out attrSets, out attrs, out attrVals, out attrUses);

            Assert.AreEqual(1, attrSets.Count);//System.Console.WriteLine(attrSets);
            System.Console.WriteLine(attrs);
            Assert.AreEqual(1, attrs.Count);
            Assert.IsTrue(attrs[0].IsList);
            Assert.AreEqual((typeof(int)).Name, attrs[0].AttributeValueType);
            System.Console.WriteLine(attrVals);
            System.Console.WriteLine(attrUses);

            Save(attrs, attrSets);
        }

        private void TestBuildUsingAnnotations(AttributeSetBuilder<CreateAttributeSet, CreateAttribute, CreateAttributeValue, CreateAttributeUse> attributeSetBuilder, out IList<CreateAttribute> attrs, out IList<CreateAttributeValue> attrVals, out IList<CreateAttributeSet> attrSets, out IList<CreateAttributeUse> attrUses)
        {

            attributeSetBuilder.BuildAttributeSetsFromEntityType(typeof(AttributeSetInstanceTestClass1), out attrSets, out attrs, out attrVals, out attrUses);

            Assert.AreEqual(3, attrSets.Count);//System.Console.WriteLine(attrSets);
            System.Console.WriteLine(attrs);
            System.Console.WriteLine(attrVals);
            System.Console.WriteLine(attrUses);

            Save(attrs, attrSets);
        }


        private void Save(IList<CreateAttribute> attrs, IList<CreateAttributeSet> attrSets)
        {
            foreach (var a in attrs)
            {
                a.CommandId = a.AttributeName;//幂等
                attributeApplicationService.When(a);
            }
            foreach (var attrSet in attrSets)
            {
                attrSet.CommandId = attrSet.AttributeSetId;//幂等
                attributeSetApplicationService.When(attrSet);
            }
        }

        // ///////////////////////////////////////////////
        #region Id Generator

        class IdGenerator : AttributeSetBuilder<CreateAttributeSet, CreateAttribute, CreateAttributeValue, CreateAttributeUse>.IdGenerator
        {

            static Regex IdRegex = new Regex("^[_A-Za-z][_A-Za-z0-9]*$");

            public string GenerateAttributeSetId(CreateAttributeSet attributeSet)
            {
                if (IdRegex.IsMatch(attributeSet.AttributeSetName))
                {
                    return attributeSet.AttributeSetName + System.DateTime.Now.Ticks;
                }
                return System.Guid.NewGuid().ToString();
            }

            public string GenerateAttributeId(CreateAttribute attribute)
            {
                return attribute.AttributeName;
                //return attribute.AttributeName + System.DateTime.Now.Ticks;
            }
        }

        #endregion

        // ///////////////////////////////////////////////
        #region WhatDay

        class AttributeSetInstanceTestClass4
        {
            public WhatDay WhatDay { get; set; }
        }

        enum WhatDay
        {
            Monday, 
            Tuesday, 
            Wednesday, 
            Thursday, 
            Friday, 
            Saturday, 
            Sunday 
        }

        #endregion

        // ///////////////////////////////////////////////
        #region Color

        class AttributeSetInstanceTestClass3
        {
            [AttributeValueList(typeof(Color))]
            public string Color { get; set; }
        }

        static class Color
        {
            public const string Red = "R";
            public const string Green = "G";
            public const string Blue = "B";
        }

        #endregion

        // ///////////////////////////////////////////////
        #region ClothingSize

        class AttributeSetInstanceTestClass2
        {
            [AttributeValueList(typeof(ClothingSize))]
            public ClothingSize ClothingSize { get; set; }
        }


        enum ClothingSize : int
        {
            S = -1,
            M = 0,
            L = 1,
            XL = 2,
            XXL = 3,
            XXXL = 4,
            XXXXL = 5,
        }

        #endregion

        // //////////////////////////////////////////////
        #region AttributeSetInstanceTestClass1

        class AttributeSetInstanceTestClass1
        {

            [AttributeGroup("电子料")]
            [AttributeGroup("大宗料")]
            [Dddml.Wms.Support.Attribute(Description = "Date Code")]
            public virtual string DateCode { get; set; }

            [AttributeGroup("电子料")]
            [AttributeGroup("大宗料")]
            [Dddml.Wms.Support.Attribute(Description = "Vendor Code", Aliases = new string[] { "ProviderCode" })]
            public virtual string VendorCode { get; set; }

            [AttributeGroup("电子料")]
            [Dddml.Wms.Support.Attribute(Description = "MC")]
            public virtual string MC { get; set; }

            [AttributeGroup("电子料")]
            [Dddml.Wms.Support.Attribute(Description = "MSD")]
            public virtual string MSD { get; set; }

            public virtual System.DateTime GuaranteeDate { get; set; }

        }

        #endregion

    }


    

}
