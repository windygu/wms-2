package org.dddml.wms.domain.service;

import org.dddml.wms.domain.attributeset.AttributeSetState;
import org.dddml.wms.domain.attributeset.AttributeSetStateQueryRepository;
import org.dddml.wms.domain.attribute.AttributeState;
import org.dddml.wms.domain.attribute.AttributeStateQueryRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Li Yongchun on 2016/9/8.
 */
public class AttributeSetServiceImpl implements AttributeSetService {

    private AttributeSetStateQueryRepository attributeSetStateQueryRepository;

    private AttributeStateQueryRepository attributeStateQueryRepository;

    public void setAttributeSetStateQueryRepository(AttributeSetStateQueryRepository attributeSetStateQueryRepository) {
        this.attributeSetStateQueryRepository = attributeSetStateQueryRepository;
    }

    public void setAttributeStateQueryRepository(AttributeStateQueryRepository attributeStateQueryRepository) {
        this.attributeStateQueryRepository = attributeStateQueryRepository;
    }

    @Transactional(readOnly = true)
    public Map<String, String> getPropertyExtensionFieldDictionary(String attributeSetId) {
        AttributeSetState attributeSetState = attributeSetStateQueryRepository.get(attributeSetId);
        Map<String, String> map = new HashMap<>();
        if (attributeSetState != null && attributeSetState.getAttributeUses() != null) {
            attributeSetState.getAttributeUses().forEach(useState -> {
                AttributeState attributeState = attributeStateQueryRepository.get(useState.getAttributeId());
                if (attributeSetState != null) {
                    //map.put(attributeState.getAttributeName(), attributeState.getFieldName());
                    propertyExtensionFieldDictionaryAdd(map, attributeState);
                }
            });
        }
        return map;
    }

    // ///////////////////////////////////////////////////////
    private static Pattern fieldNamePattern = Pattern.compile("^[_A-Za-z][_A-Za-z0-9]*$");

    private static void propertyExtensionFieldDictionaryAdd(Map<String, String> pDic, AttributeState a) {
        String fname = a.getFieldName();
        // /////////////////////////////////////////////////////////////////////////////////////
        //
        // 我们通过这样的方式支持动态"属性"：
        //
        // 预先在实体中预留若干扩展"字段"，然后，通过元数据（配置）来实现这样的映射：
        //
        // 属性名 -> 字段名 -> 列名
        //
        // 这里的"字段名"是指可以直接映射到"底层"存储————列名的那个名称（"中间层"）。
        //
        // 这里的例子，属性名 -> 字段名的映射元数据保存在数据库中（运行时可变），
        //
        // 字段名 -> 列名的映射实际上是通过 ORM 来完成的。
        //
        // /////////////////////////////////////////////////////////////////////////////////////

        if (fname == null || "".equals(fname)) // 如果"属性"没有指定字段名
        {
            if (fieldNamePattern.matcher(a.getAttributeId()).find()) // 使用"属性 Id"作为字段名
            {
                fname = a.getAttributeId();
            } else if (fieldNamePattern.matcher(a.getAttributeName()).find()) //使用"属性名称"作为字段名
            {
                fname = a.getAttributeName();
            }
        }
        if (!(fname == null || "".equals(fname))) {
            // ///////////////////////////////
            //if (pDic.containsKey(a.getAttributeId())) {
            //if (_log.IsInfoEnabled) {
            //    _log.Info(String.format("pDic.ContainsKey(a.AttributeId). Key: %1$s", a.AttributeId));
            //}
            //}
            //if (pDic.containsKey(a.getAttributeName())) {
            //if (_log.IsDebugEnabled) {
            //    _log.Debug(String.format("pDic.ContainsKey(a.AttributeName). Key: %1$s", a.AttributeName));
            //}
            //}
            // ///////////////////////////////
            if (!pDic.containsKey(a.getAttributeId())) {
                pDic.put(a.getAttributeId(), fname);
            }
            if (!pDic.containsKey(a.getAttributeName())) {
                pDic.put(a.getAttributeName(), fname);
            }
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
