package org.dddml.wms.domain.attributesetinstance;

import org.apache.commons.beanutils.ConvertUtils;
import org.dddml.wms.domain.service.AttributeSetService;
import org.dddml.wms.specialization.DomainError;
import org.dddml.wms.specialization.ReflectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangjiefeng on 2018/2/7.
 */
public class AttributeSetInstanceUtils {

    public static String createAttributeSetInstance(
            AttributeSetService attributeSetService, AttributeSetInstanceApplicationService attrSetInstApplicationService,
                                                    String attrSetId, Map<String, Object> attrSetInstDict) {
        Map<String, String> nameDict = null;
        if (attrSetId == null) {
            nameDict = new HashMap<>();
        } else {
            nameDict = attributeSetService.getPropertyExtensionFieldDictionary(attrSetId);
        }
        AttributeSetInstanceCommand.CreateAttributeSetInstance createAttrSetInst = new AbstractAttributeSetInstanceCommand.SimpleCreateAttributeSetInstance();
        createAttrSetInst.setAttributeSetId(attrSetId == null ? "*" : attrSetId);
        for (Map.Entry<String, Object> kv : attrSetInstDict.entrySet()) {
            String fname = nameDict.containsKey(kv.getKey()) ? nameDict.get(kv.getKey()) : kv.getKey();
            // createAttrSetInst.AirDryMetricTon = (decimal)kv.Value;
            boolean b = ReflectUtils.trySetPropertyValue(fname, createAttrSetInst, kv.getValue(),
                    ConvertUtils::convert);
            if (!b) {
                String fmt = "Set property error. Property name: %1$s";
                //                if (_log.IsInfoEnabled) {
                //                    _log.Info(String.format(fmt, fname));
                //                }
                throw new DomainError(fmt, fname);
            }
            // //////////////////////////////////////////
        }
        String attrSetInstId = attrSetInstApplicationService.createWithoutId(createAttrSetInst);
        return attrSetInstId;
    }

}
