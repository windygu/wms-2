using Common.Logging;
using Dddml.Wms.Domain.AttributeSetInstance;
using Dddml.Wms.Domain.Services;
using Dddml.Wms.Specialization;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Domain.AttributeSetInstance
{
    public static class AttributeSetInstanceUtils
    {
        //static readonly ILog _log = LogManager.GetLogger<AttributeSetInstanceUtils>();

        public static string CreateAttributeSetInstance(IAttributeSetService attributeSetService, IAttributeSetInstanceApplicationService attrSetInstApplicationService,
            string attrSetId, IDictionary<string, object> attrSetInstDict)
        {
            IDictionary<string, string> nameDict = null;
            if (String.IsNullOrWhiteSpace(attrSetId))
            {
                nameDict = new Dictionary<string, string>();
            }
            else
            {
                nameDict = attributeSetService.GetPropertyExtensionFieldDictionary(attrSetId);
            }

            var createAttrSetInst = new CreateAttributeSetInstance();
            createAttrSetInst.AttributeSetId = (attrSetId == null ? "*" : attrSetId);
            foreach (var kv in attrSetInstDict)
            {
                // //////////////////////////////////////////
                var fname = nameDict.ContainsKey(kv.Key) ? nameDict[kv.Key] : kv.Key;
                // createAttrSetInst.AirDryMetricTon = (decimal)kv.Value;
                var b = ReflectUtils.TrySetPropertyValue(fname, createAttrSetInst, kv.Value);
                if (!b)
                {
                    var fmt = "Set property error. Property name: {0}";
                    //if (_log.IsInfoEnabled) { _log.Info(String.Format(fmt, fname)); }
                    throw new DomainError(fmt, fname);
                }
                // //////////////////////////////////////////
            }
            var attrSetInstId = attrSetInstApplicationService.CreateWithoutId(createAttrSetInst);
            return attrSetInstId;
        }
    }
}
