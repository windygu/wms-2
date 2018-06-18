using Dddml.Wms.Domain.Attribute;
using Dddml.Wms.Domain.AttributeSet;
using Dddml.Wms.Specialization;
using Dddml.Wms.Support;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

namespace Dddml.Wms.Services.Tests
{
    public class InitAttributeSets // : TestsBase
    {
        //[NUnit.Framework.SetUp]
        //public void SetUp()
        //{
        //    base.SetUp();
        //}
        //[NUnit.Framework.Test]
        //public void Test1()
        //{
        //    CreateDefaultAttributeSets();
        //}

        static IAttributeApplicationService attributeApplicationService;

        static IAttributeSetApplicationService attributeSetApplicationService;

        public static void CreateDefaultAttributeSets()
        {
            attributeApplicationService = ApplicationContext.Current["attributeApplicationService"] as IAttributeApplicationService;
            attributeSetApplicationService = ApplicationContext.Current["attributeSetApplicationService"] as IAttributeSetApplicationService;

            var attributeSetBuilder = new AttributeSetBuilder<CreateAttributeSet, CreateAttribute, CreateAttributeValue, CreateAttributeUse>(new IdGenerator());

            IList<CreateAttribute> attrs;
            IList<CreateAttributeValue> attrVals;
            IList<CreateAttributeSet> attrSets;
            IList<CreateAttributeUse> attrUses;

            attributeSetBuilder.BuildAttributeSetsFromEntityType(typeof(FluffPulpAttrSetInstance), out attrSets, out attrs, out attrVals, out attrUses);

            Save(attrs, attrSets);
        }


        private static void Save(IList<CreateAttribute> attrs, IList<CreateAttributeSet> attrSets)
        {
            foreach (var a in attrs)
            {
                if (String.IsNullOrWhiteSpace(a.FieldName))
                {
                    a.FieldName = a.AttributeId; //这些属性都存在同名的字段（列）
                }
                a.CommandId = a.AttributeName; // 幂等命令
                attributeApplicationService.When(a);
            }
            foreach (var attrSet in attrSets)
            {
                attrSet.CommandId = attrSet.AttributeSetId; // 幂等命令
                attributeSetApplicationService.When(attrSet);
            }
        }

        /// <summary>
        /// 绒毛浆属性集实例。
        /// </summary>
        public class FluffPulpAttrSetInstance
        {
            
            /// <summary>
            /// 序列号（卷号）。
            /// </summary>
            public string SerialNumber { get; set; }

            public decimal? WidthInch { get; set; }

            public decimal? DiameterInch { get; set; }

            public decimal? WeightLbs { get; set; }

            [IsMandatory(true)]
            public decimal? WeightKg { get; set; }

            public decimal? AirDryWeightLbs { get; set; }

            public decimal? AirDryWeightKg { get; set; }

            public decimal? AirDryMetricTon { get; set; }

            public int? PackageCount { get; set; }

            public decimal? AirDryPct { get; set; }
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
                    return attributeSet.AttributeSetName;
                }
                throw new ArgumentException("!IdRegex.IsMatch(attributeSet.AttributeSetName)");
            }

            public string GenerateAttributeId(CreateAttribute attribute)
            {
                if (IdRegex.IsMatch(attribute.AttributeName))
                {
                    return attribute.AttributeName;
                }
                throw new ArgumentException("!IdRegex.IsMatch(attribute.AttributeName)");
                //return attribute.AttributeName + System.DateTime.Now.Ticks;
            }
        }

        #endregion
    }
}
