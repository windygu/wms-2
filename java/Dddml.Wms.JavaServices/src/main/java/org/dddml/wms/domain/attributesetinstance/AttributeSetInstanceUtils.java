package org.dddml.wms.domain.attributesetinstance;

import org.apache.commons.beanutils.ConvertUtils;
import org.dddml.wms.domain.service.AttributeSetService;
import org.dddml.wms.specialization.DomainError;
import org.dddml.wms.specialization.ReflectUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangjiefeng on 2018/2/7.
 */
public class AttributeSetInstanceUtils {

    public static String createAttributeSetInstance(
            AttributeSetService attributeSetService, AttributeSetInstanceApplicationService attrSetInstApplicationService,
                                                    String attrSetId, Map<String, Object> attributeSetIntanceMap) {
        if (attributeSetIntanceMap == null) {
            throw new IllegalArgumentException("attributeSetInstanceMap is null.");
        }
        Map<String, String> nameDict = null;
        if (attrSetId == null) {
            nameDict = new HashMap<>();
        } else {
            nameDict = attributeSetService.getPropertyExtensionFieldDictionary(attrSetId);
        }
        AttributeSetInstanceCommand.CreateAttributeSetInstance createAttrSetInst = new AbstractAttributeSetInstanceCommand.SimpleCreateAttributeSetInstance();
        createAttrSetInst.setAttributeSetId(attrSetId == null ? "*" : attrSetId);
        for (Map.Entry<String, Object> kv : attributeSetIntanceMap.entrySet()) {
            String fname = nameDict.containsKey(kv.getKey()) ? nameDict.get(kv.getKey()) : kv.getKey();
            // createAttrSetInst.AirDryMetricTon = (decimal)kv.Value;
            boolean b = ReflectUtils.trySetPropertyValue(fname, createAttrSetInst, kv.getValue(),
                    (Object o, Class<?> c) -> {
                        if (o instanceof String) {
                            if (((String) o).trim().isEmpty()) {
                                return null;
                            }
                            String s = (String)o;
                            s = s.replace(",", "");
                            if (c.equals(BigDecimal.class)) {
                                return new BigDecimal(s);
                            }
                            if (c.equals(Long.class)) {
                                return Long.parseLong(s);
                            }
                            if (c.equals(Integer.class)) {
                                return Integer.parseInt(s);
                            }
                            if (c.equals(Boolean.class)) {
                                return Boolean.parseBoolean(s);
                            }
                        }
                        return ConvertUtils.convert(o, c);
                    });
            if (!b) {
                String fmt = "Set property error. Property name: %1$s";
                //                if (_log.IsInfoEnabled) {
                //                    _log.Info(String.format(fmt, fname));
                //                }
                //todo ???
                //throw new DomainError(fmt, fname);
            }
            // //////////////////////////////////////////
        }
        String attrSetInstId = attrSetInstApplicationService.createWithoutId(createAttrSetInst);
        return attrSetInstId;
    }

}
