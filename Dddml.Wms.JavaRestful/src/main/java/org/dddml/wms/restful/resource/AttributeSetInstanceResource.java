package org.dddml.wms.restful.resource;

import com.alibaba.fastjson.JSONObject;
import org.dddml.support.criterion.DefaultTypeConverter;
import org.dddml.support.criterion.PropertyTypeResolver;
import org.dddml.support.criterion.StringHelper;
import org.dddml.support.criterion.TypeConverter;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.meta.AttributeSetInstanceFilteringProperties;
import org.dddml.wms.domain.meta.PersonFilteringProperties;
import org.dddml.wms.ext.AttributeSetInstanceIdGenerator;
import org.dddml.wms.restful.exception.WebApiApplicationException;
import org.dddml.wms.specialization.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Li Yongchun on 2016/9/8.
 */
@Path("/attributeSetInstances")
public class AttributeSetInstanceResource {
    @Autowired
    private AttributeSetInstanceApplicationService attributeSetInstanceApplicationService;

    @Autowired
    private AttributeSetInstanceIdGenerator attributeSetInstanceIdGenerator;

    @Autowired
    private AbstractDynamicObjectMapper<JSONObject,
            AttributeSetInstanceStateDto,
            AttributeSetInstanceCommand.CreateAttributeSetInstance,
            AttributeSetInstanceCommand.MergePatchAttributeSetInstance> dynamicObjectMapper;

    /**
     * 获取单个属性集实例的信息
     *
     * @param id     属性集实例Id
     * @param fields 属性集实例的属性字段
     * @return 属性集实例的JSonObject表示
     */
    @GET
    @Path("{id}")
    public JSONObject get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            AttributeSetInstanceState state = attributeSetInstanceApplicationService.get(id);
            if (state == null) {
                return null;
            }
            AttributeSetInstanceStateDto.DtoConverter converter = new AttributeSetInstanceStateDto.DtoConverter();
            if (!StringHelper.isNullOrEmpty(fields)) {
                converter.setAllFieldsReturned(true);
            } else {
                converter.setReturnedFieldsString(fields);
            }
            AttributeSetInstanceStateDto stateDto = converter.toAttributeSetInstanceStateDto(state);
            return dynamicObjectMapper.mapState(stateDto);
        } catch (DomainError error) {
            throw error;
        } catch (Exception ex) {
            throw new WebApiApplicationException(ex);
        }
    }

    /**
     * 添加
     *
     * @param jsonObject
     * @param response
     * @return
     */
    @POST
    public String post(JSONObject jsonObject, @Context HttpServletResponse response) {
        try {
            AttributeSetInstanceCommand.CreateAttributeSetInstance createAttributeSetInstance
                    = dynamicObjectMapper.toCommandCreate(jsonObject);
            IdGenerator.GetOrGenerateIdResult<String> idResult = attributeSetInstanceIdGenerator.getOrGenerateId(createAttributeSetInstance);
            createAttributeSetInstance.setAttributeSetInstanceId(idResult.getId());
            attributeSetInstanceApplicationService.when(createAttributeSetInstance);
            response.setStatus(Response.Status.CREATED.getStatusCode());
            return idResult.getId();
        } catch (DomainError error) {
            throw error;
        } catch (Exception ex) {
            throw new WebApiApplicationException(ex);
        }
    }


    private String getQueryOrderSeparator() {
        return ",";
    }

    private TypeConverter getCriterionDefaultTypeConvert() {
        return new DefaultTypeConverter();
    }

    private class AttributeSetInstancePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return AttributeSetInstanceResource.AttributeSetInstanceApiUtils.GetFilterPropertyType(propertyName);
        }
    }


    private static class AttributeSetInstanceApiUtils {
        public static List<String> getQueryOrders(String str, String separator) {
            List<String> orders = new ArrayList<>();
            if (StringHelper.isNullOrEmpty(str)) {
                return orders;
            }
            String[] splits = str.split(separator);
            for (String item : splits) {
                if (!StringHelper.isNullOrEmpty(item)) {
                    orders.add(item);
                }
            }
            return orders;
        }

        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (AttributeSetInstanceFilteringProperties.propertyTypeMap.containsKey(fieldName)) {
                return fieldName;
            }
            return null;
        }

        public static Class GetFilterPropertyType(String propertyName) {
            if (AttributeSetInstanceFilteringProperties.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = PersonFilteringProperties.propertyTypeMap.get(propertyName);
                if (!StringHelper.isNullOrEmpty(propertyType)) {
                    if (ReflectUtils.CLASS_MAP.containsKey(propertyType)) {
                        return ReflectUtils.CLASS_MAP.get(propertyType);
                    }
                }
            }
            return String.class;
        }


        public static Iterable<Map.Entry<String, Object>> getQueryFilterDictionary(Map<String, String[]> queryNameValuePairs) {
            Map<String, Object> filter = new HashMap<>();
            queryNameValuePairs.forEach((key, values) -> {
                if (values.length > 0) {
                    String pName = getFilterPropertyName(key);
                    if (!StringHelper.isNullOrEmpty(pName)) {
                        Class pClass = GetFilterPropertyType(pName);
                        ApplicationContext.current.getTypeConverter().convertFromString(pClass, values[0]);
                        filter.put(pName, null);
                    }
                }
            });
            return filter.entrySet();
        }
    }
}
