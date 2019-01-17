package org.dddml.wms.domain.attributesetinstance;

import org.apache.commons.beanutils.ConvertUtils;
import org.dddml.wms.domain.service.AttributeSetService;
import org.dddml.wms.specialization.DomainError;
import org.dddml.wms.specialization.ReflectUtils;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.BiFunction;

/**
 * Created by yangjiefeng on 2018/2/7.
 */
public class AttributeSetInstanceUtils {

    private static final String ATTRIBUTE_SET_INSTANCE_ID_KEY = "attributeSetInstanceId";
    private static final String ATTRIBUTE_SET_INSTANCE_ID_KEY_2 = "AttributeSetInstanceId";

    public static String getSerialNumber(AttributeSetInstanceApplicationService attrSetInstApplicationService,  String attrSetInstId) {
        if (attrSetInstId == null) {
            throw new IllegalArgumentException("attrSetInstId is null.");
        }
        AttributeSetInstanceState attrSetInstState = attrSetInstApplicationService.get(attrSetInstId);
        if (attrSetInstState == null) {
            return null;
        }
        return attrSetInstState.getSerialNumber();
    }

    public static String createAttributeSetInstance(
            AttributeSetService attributeSetService, AttributeSetInstanceApplicationService attrSetInstApplicationService,
                                                    String attrSetId, Map<String, Object> attributeSetInstanceMap) {
        if (attributeSetInstanceMap == null) {
            throw new IllegalArgumentException("attributeSetInstanceMap is null.");
        }
        String attrSetInstId = null;
        // /////////////// 如果传入的 Map 包含 attributeSetInstanceId ////////////////////
        if (attributeSetInstanceMap.containsKey(ATTRIBUTE_SET_INSTANCE_ID_KEY)) {
            attrSetInstId = attributeSetInstanceMap.get(ATTRIBUTE_SET_INSTANCE_ID_KEY).toString();
        } else if (attributeSetInstanceMap.containsKey(ATTRIBUTE_SET_INSTANCE_ID_KEY_2)) {
            attrSetInstId = attributeSetInstanceMap.get(ATTRIBUTE_SET_INSTANCE_ID_KEY_2).toString();
        }
        if (attrSetInstId != null) {
            // 且该 Id 在数据库中已经存在对应的属性集实例，则不再创建新的属性集实例
            AttributeSetInstanceState attrSetInstState = attrSetInstApplicationService.get(attrSetInstId);
            if (attrSetInstState != null) {
                return attrSetInstId;
            }
        }
        // ///////////////////////////////////////////////////////////////////////////////
        Map<String, String> nameDict = null;
        if (attrSetId == null) {
            nameDict = new HashMap<>();
        } else {
            nameDict = attributeSetService.getPropertyExtensionFieldDictionary(attrSetId);
        }
        AttributeSetInstanceCommand.CreateAttributeSetInstance createAttrSetInst = new AbstractAttributeSetInstanceCommand.SimpleCreateAttributeSetInstance();
        createAttrSetInst.setAttributeSetId(attrSetId == null ? "*" : attrSetId);

        for (Map.Entry<String, Object> kv : attributeSetInstanceMap.entrySet()) {
            String fname = nameDict.containsKey(kv.getKey()) ? nameDict.get(kv.getKey()) : kv.getKey();
            // createAttrSetInst.AirDryMetricTon = (decimal)kv.Value;
            boolean b = ReflectUtils.trySetPropertyValue(fname, createAttrSetInst, kv.getValue(), getConvertFunction());

            // //////////////////////////////////////////
            if (!b) {
                String fmt = "Set attributeSetInstance property error. Property name: %1$s";
                //                if (_log.IsInfoEnabled) {
                //                    _log.Info(String.format(fmt, fname));
                //                }
                if (kv.getValue() != null && !kv.getValue().toString().trim().isEmpty()) {
                    if (ReflectUtils.isPropertyPresent(fname, createAttrSetInst)) {
                        throw DomainError.named("setPropertyError", fmt, fname);
                    }
                }
            }

        }// end for (Map.Entry<String, Object> kv : attributeSetIntanceMap.entrySet())
        attrSetInstId = attrSetInstApplicationService.createWithoutId(createAttrSetInst);
        return attrSetInstId;
    }

    static BiFunction<Object, Class<?>, Object> getConvertFunction() {
        return (Object o, Class<?> c) -> {
            // //////////////////////////////////////////////
            // 先判断源类型
            if (o instanceof String) {
                if (c.equals(String.class)) {
                    return o;
                }
                String s = ((String)o).trim();
                if (s.isEmpty()) {
                    return null;
                }
                if (c.equals(Boolean.class)) {
                    return Boolean.parseBoolean(s);
                }
                //目标类型是数字类型的处理：
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
            }
            // //////////////////////////////////////////////
            // 再看看目标类型
            if (c.equals(Integer.class)) {
                // ////////////////////////////////////////////////
                // 目标类型是整数
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
                // ////////////////////////////////////////////////
                // 目标类型是字符串
                if (o != null) {
                    return o.toString();
                }
            } else if (c.equals(Set.class)) {
                // ////////////////////////////////////////////////
                // 目标类型是“集”
                if (o == null) {
                    return o;
                }
                if (o.getClass().isArray()) {
                    //o.getClass().getComponentType();
                    Object array = o;
                    Set resultSet = new HashSet();
                    if (array.getClass().isArray()) {
                        int length = Array.getLength(array);
                        for (int i = 0; i < length; i ++) {
                            Object arrayElement = Array.get(array, i);
                            resultSet.add(arrayElement);
                        }
                    }
                    return resultSet;
                } else if (Collection.class.isAssignableFrom(o.getClass())) {
                    Collection collection = (Collection) o;
                    Set resultSet = new HashSet();
                    resultSet.addAll(collection);
                    return resultSet;
                }
            }
            return ConvertUtils.convert(o, c);
        };
    }

}
