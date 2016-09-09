package org.dddml.wms.ext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.dddml.wms.domain.AbstractAttributeSetInstanceCommand;
import org.dddml.wms.domain.AttributeSetInstanceCommand;
import org.dddml.wms.domain.AttributeSetInstanceStateDto;
import org.dddml.wms.specialization.AbstractDynamicObjectMapper;

import java.util.Map;

/**
 * Created by Li Yongchun on 2016/9/8.
 */
public class AttributeSetInstanceDtoJsonObjectMapper extends AbstractDynamicObjectMapper<JSONObject,
        AttributeSetInstanceStateDto,
        AttributeSetInstanceCommand.CreateAttributeSetInstance,
        AttributeSetInstanceCommand.MergePatchAttributeSetInstance> {

    private AttributeSetService attributeSetService;

    private static String resolveFieldName(String fieldName) {
        if (fieldName == null) {
            return fieldName;
        }
        if (fieldName.startsWith("_")) {
            return fieldName.substring(1);
        }
        return fieldName;
    }

    @Override
    public JSONObject mapState(AttributeSetInstanceStateDto attributeSetInstanceStateDto) {
        JSONObject jsonObject = (JSONObject) JSON.toJSON(attributeSetInstanceStateDto);
        Map<String, String> maps = attributeSetService.
                getExtensionPropertyFieldDictionary(attributeSetInstanceStateDto.getAttributeSetId());
        maps.forEach((name, filedName) -> {
            try {
                /**这里还是自己重写吧，没有必要引进一个库，直接使用 JDK 的内省读写*/
                Object value = new PropertyUtilsBean().getSimpleProperty(attributeSetInstanceStateDto, filedName);
                if (value != null) {
                    jsonObject.remove(resolveFieldName(filedName));
                    jsonObject.put(name, value);
                }
            } catch (Exception ex) {

            }
        });
        return jsonObject;
    }

    @Override
    public AttributeSetInstanceCommand.CreateAttributeSetInstance toCommandCreate(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        AbstractAttributeSetInstanceCommand.SimpleCreateAttributeSetInstance createAttributeSetInstance =
                jsonObject.toJavaObject(AbstractAttributeSetInstanceCommand.SimpleCreateAttributeSetInstance.class);
        Map<String, String> maps = attributeSetService.
                getExtensionPropertyFieldDictionary(createAttributeSetInstance.getAttributeSetId());
        maps.forEach((name, filedName) -> {
            try {
                Object value = jsonObject.get(name);
                if (value != null) {
                    BeanUtils.setProperty(createAttributeSetInstance, filedName, value);
                }
            } catch (Exception ex) {

            }
        });
        return createAttributeSetInstance;
    }

    @Override
    public AttributeSetInstanceCommand.MergePatchAttributeSetInstance toCommandMergePatch(JSONObject jsonObject) {
        AbstractAttributeSetInstanceCommand.MergePatchAttributeSetInstance mergePatchAttributeSetInstance =
                jsonObject.toJavaObject(AbstractAttributeSetInstanceCommand.MergePatchAttributeSetInstance.class);
        Map<String, String> maps = attributeSetService.
                getExtensionPropertyFieldDictionary(mergePatchAttributeSetInstance.getAttributeSetId());
        maps.forEach((name, filedName) -> {
            try {
                Object value = jsonObject.get(name);
                if (value != null) {
                    BeanUtils.setProperty(mergePatchAttributeSetInstance, filedName, value);
                }
            } catch (Exception ex) {

            }
        });
        return mergePatchAttributeSetInstance;
    }

    public void setAttributeSetService(AttributeSetService attributeSetService) {
        this.attributeSetService = attributeSetService;
    }
}
