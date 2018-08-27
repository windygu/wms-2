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
                            if (c.equals(Double.class)) {
                                return new Double(s);
                            }
                            if (c.equals(Long.class)) {
                                return (new BigDecimal(o.toString())).longValue();
                            }
                            if (c.equals(Integer.class)) {
                                return (new BigDecimal(o.toString())).intValue();
                            }
                            if (c.equals(Boolean.class)) {
                                return Boolean.parseBoolean(s);
                            }
                        }
                        if (c.equals(Integer.class)) {
                            if (o instanceof Integer) {
                                return o;
                            }
                            if (o instanceof Double) {
                                return ((Double) o).intValue();
                            } else if (o instanceof BigDecimal) {
                                return ((BigDecimal) o).intValue();
                            } else {
                                if (o == null) return null;
                                return (new BigDecimal(o.toString())).intValue();
                            }
                        } else if (c.equals(String.class)) {
                            if (o != null) {
                                return o.toString();
                            }
                        }
                        return ConvertUtils.convert(o, c);
                    });

            // //////////////////////////////////////////
            if (!b) {
                String fmt = "Set property error. Property name: %1$s";
                //                if (_log.IsInfoEnabled) {
                //                    _log.Info(String.format(fmt, fname));
                //                }
                if (kv.getValue() != null && !kv.getValue().toString().trim().isEmpty()) {
                    //todo ???
                    //throw new DomainError(fmt, fname);
                }
            }

        }// end for (Map.Entry<String, Object> kv : attributeSetIntanceMap.entrySet())
        String attrSetInstId = attrSetInstApplicationService.createWithoutId(createAttrSetInst);
        return attrSetInstId;
    }

}
