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
        public virtual IDictionary<string, string> GetExtensionPropertyFieldDictionary(string attributeSetId)
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
                        if (String.IsNullOrWhiteSpace(fname))
                        {
                            // ??? /////////////////////////////////////
                            if (FieldNameRegex.IsMatch(a.AttributeId)) 
                            {
                                fname = a.AttributeId;
                            }
                            else if (FieldNameRegex.IsMatch(a.AttributeName))
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
