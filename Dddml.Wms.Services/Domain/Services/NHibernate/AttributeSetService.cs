using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Attribute;
using Dddml.Wms.Domain.AttributeSet;
using Dddml.Wms.Domain.Services;
using Dddml.Wms.Specialization;
using Spring.Transaction.Interceptor;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;


namespace Dddml.Wms.Domain.Services.NHibernate
{

    public class AttributeSetService : IAttributeSetService
    {

        public IAttributeSetStateQueryRepository AttributeSetStateQueryRepository { get; set; }

        public IAttributeStateQueryRepository AttributeStateQueryRepository { get; set; }

        public AttributeSetService()
        {
        }

        // ///////////////////////////////////////////////////////
        static Regex FieldNameRegex = new Regex("^[_A-Za-z][_A-Za-z0-9]*$");
        // ///////////////////////////////////////////////////////

        [Transaction(ReadOnly = true)]
        public virtual IDictionary<string, string> GetPropertyExtensionFieldDictionary(string attributeSetId)
        {
            var attrSet = AttributeSetStateQueryRepository.Get(attributeSetId);
            var pDic = new Dictionary<string, string>();
            if (attrSet != null)
            {
                foreach (var au in attrSet.AttributeUses)
                {
                    var a = AttributeStateQueryRepository.Get(au.AttributeId);
                    if (a != null)
                    {
                        var fname = a.FieldName;
                        // /////////////////////////////////////////////////////////////////////////////////////
                        //
                        // 我们通过这样的方式支持动态“属性”：
                        //
                        // 预先在实体中预留若干扩展“字段”，然后，通过元数据（配置）来实现这样的映射：
                        // 
                        // 属性名 -> 字段名 -> 列名
                        //
                        // 这里的“字段名”是指可以直接映射到“底层”存储————列名的那个名称（“中间层”）。
                        // 
                        // 这里的例子，属性名 -> 字段名的映射元数据保存在数据库中（运行时可变），
                        // 
                        // 字段名 -> 列名的映射实际上是通过 ORM 来完成的。
                        //
                        // /////////////////////////////////////////////////////////////////////////////////////

                        if (String.IsNullOrWhiteSpace(fname)) // 如果“属性”没有指定字段名
                        {
                            if (FieldNameRegex.IsMatch(a.AttributeId)) // 使用“属性 Id”作为字段名
                            {
                                fname = a.AttributeId;
                            }
                            else if (FieldNameRegex.IsMatch(a.AttributeName)) //使用“属性名称”作为字段名
                            {
                                fname = a.AttributeName;
                            }
                        }
                        if (!String.IsNullOrWhiteSpace(fname))
                        {
                            pDic.Add(a.AttributeId, fname);
                            pDic.Add(a.AttributeName, fname);
                            // ???
                            //if (a.Aliases != null)
                            //{
                            //    foreach (var alias in a.Aliases)
                            //    {
                            //        pDic.Add(alias.Name, fname);
                            //    }
                            //}
                        }
                        
                    }
                }
            }
            return pDic;
        }

    }

}
