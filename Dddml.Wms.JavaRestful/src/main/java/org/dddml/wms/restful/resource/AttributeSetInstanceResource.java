package org.dddml.wms.restful.resource;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.cxf.jaxrs.ext.PATCH;
import org.dddml.support.criterion.*;
import org.dddml.support.criterion.TypeConverter;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.meta.AttributeSetInstanceFilteringProperties;
import org.dddml.wms.domain.meta.PersonFilteringProperties;
import org.dddml.wms.ext.AttributeSetInstanceIdGenerator;
import org.dddml.wms.restful.exception.WebApiApplicationException;
import org.dddml.wms.specialization.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
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
            AttributeSetInstanceState,
            AttributeSetInstanceCommand.CreateAttributeSetInstance,
            AttributeSetInstanceCommand.MergePatchAttributeSetInstance> dynamicObjectMapper;

    /**
     * 根据指定条件查询 AttributeSetInstance
     *
     * @param request     请求
     * @param sort        排序
     * @param fields      返回属性字段
     * @param firstResult 起始行
     * @param maxResults  最大结果数量
     * @param filter      过滤条件
     * @return 结果
     */
    @GET
    public JSONArray GetAll(@Context HttpServletRequest request,
                            @QueryParam("sort") String sort,
                            @QueryParam("fields") String fields,
                            @DefaultValue("0") @QueryParam("firstResult") Integer firstResult,
                            @QueryParam("maxResults") Integer maxResults,
                            @QueryParam("filter") String filter) {
        if (maxResults == null || maxResults < 1) {
            maxResults = Integer.MAX_VALUE;
        }
        if (firstResult < 0) {
            firstResult = 0;
        }
        try {
            Iterable<AttributeSetInstanceState> states = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = attributeSetInstanceApplicationService.get(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionDefaultTypeConvert(), new AttributeSetInstancePropertyTypeResolver())
                        , AttributeSetInstanceApiUtils.getQueryOrders(sort, getQueryOrderSeparator()), firstResult, maxResults);
            } else {
                states = attributeSetInstanceApplicationService.get(AttributeSetInstanceApiUtils.getQueryFilterDictionary(request.getParameterMap())
                        , AttributeSetInstanceApiUtils.getQueryOrders(sort, getQueryOrderSeparator()), firstResult, maxResults);
            }
            JSONArray dynamicArray = new JSONArray();
            if (states != null) {
                states.forEach(state -> {
                    dynamicArray.add(dynamicObjectMapper.mapState(state, fields));
                });
            }
            return dynamicArray;
        } catch (DomainError error) {
            throw error;
        } catch (Exception ex) {
            throw new WebApiApplicationException(ex);
        }
    }


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
            return dynamicObjectMapper.mapState(state, fields);
        } catch (DomainError error) {
            throw error;
        } catch (Exception ex) {
            throw new WebApiApplicationException(ex);
        }
    }


    /**
     * 查询符合条件的 AttributeSetInstance 数量
     *
     * @param request 请求
     * @param filter  过滤条件
     * @return 数量
     */
    @Path("_count")
    @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = attributeSetInstanceApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionDefaultTypeConvert(), new AttributeSetInstancePropertyTypeResolver()));
            } else {
                count = attributeSetInstanceApplicationService.getCount(AttributeSetInstanceApiUtils.getQueryFilterDictionary(request.getParameterMap()));
            }
            return count;
        } catch (DomainError error) {
            throw error;
        } catch (Exception ex) {
            throw new WebApiApplicationException(ex);
        }
    }


    /**
     * 修改AttributeSetInstance
     *
     * @param id            AttributeSetInstanceId
     * @param dynamicObject AttributeSetInstance Body
     */
    @PUT
    @Path("/{id}")
    public void Put(@PathParam("id") String id, JSONObject dynamicObject) {
        try {
            AttributeSetInstanceCommand.CreateAttributeSetInstance value = dynamicObjectMapper.toCommandCreate(dynamicObject);
            //System.out.println(value.get_F_C5_4_());
            AttributeSetInstanceApiUtils.setNullIdOrThrowOnInconsistentIds(id, value);
            attributeSetInstanceApplicationService.when(value);
        } catch (DomainError error) {
            throw error;
        } catch (Exception ex) {
            throw new WebApiApplicationException(ex);
        }
    }


    /**
     * 添加 AttributeSetInstance
     *
     * @param jsonObject AttributeSetInstance Body
     * @param response   响应
     * @return AttributeSetInstance Id
     */
    @POST
    public String post(JSONObject jsonObject, @Context HttpServletResponse response) {
        try {
            AttributeSetInstanceCommand.CreateAttributeSetInstance createAttributeSetInstance
                    = dynamicObjectMapper.toCommandCreate(jsonObject);
            IdGenerator.GetOrGenerateIdResult<String> idResult = attributeSetInstanceIdGenerator.getOrGenerateId(createAttributeSetInstance);
            createAttributeSetInstance.setAttributeSetInstanceId(idResult.getId());
            if (!idResult.isReused()) {
                attributeSetInstanceApplicationService.when(createAttributeSetInstance);
            }
            response.setStatus(Response.Status.CREATED.getStatusCode());
            return idResult.getId();
        } catch (DomainError error) {
            throw error;
        } catch (Exception ex) {
            throw new WebApiApplicationException(ex);
        }
    }


    /**
     * 修改已经存在的 AttributeSetInstance
     *
     * @param id            AttributeSetInstance Id
     * @param dynamicObject 修改的属性
     */
    @PATCH
    @Path("{id}")
    public void patch(@PathParam("id") String id, JSONObject dynamicObject) {
        try {
            AttributeSetInstanceCommand.MergePatchAttributeSetInstance value = dynamicObjectMapper.toCommandMergePatch(dynamicObject);
            AttributeSetInstanceApiUtils.setNullIdOrThrowOnInconsistentIds(id, value);
            attributeSetInstanceApplicationService.when(value);
        } catch (DomainError error) {
            throw error;
        } catch (Exception ex) {
            throw new WebApiApplicationException(ex);
        }
    }


    /**
     * 删除
     *
     * @param id
     * @param commandId
     * @param version
     * @param requesterId
     */
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id, @QueryParam("commandId") String commandId,
                       @NotNull(message = "version can't be null") @QueryParam("version") String version,
                       @QueryParam("requesterId") String requesterId) {
        try {
            AttributeSetInstanceCommand.DeleteAttributeSetInstance value = new AbstractAttributeSetInstanceCommand.SimpleDeleteAttributeSetInstance();
            value.setCommandId(commandId);
            value.setRequesterId(requesterId);
            value.setVersion(Long.parseLong(version));
            AttributeSetInstanceApiUtils.setNullIdOrThrowOnInconsistentIds(id, value);
            attributeSetInstanceApplicationService.when(value);
        } catch (DomainError error) {
            throw error;
        } catch (Exception ex) {
            throw new WebApiApplicationException(ex);
        }
    }


    @Path("_metadata/filteringFields")
    @GET
    public Iterable<PropertyMetadataDto> getMetadataFilteringFields() {
        try {
            List<PropertyMetadataDto> filtering = new ArrayList<>();
            AttributeSetInstanceFilteringProperties.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;
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


        public static void setNullIdOrThrowOnInconsistentIds(String id, AttributeSetInstanceCommand.CreateOrMergePatchAttributeSetInstance value) {
            if (value.getAttributeSetInstanceId() == null) {
                value.setAttributeSetInstanceId(id);
            } else if (!value.getAttributeSetInstanceId().equals(id)) {
                throw DomainError.named("inconsistentId", "Argument Id {0} NOT equals body Id {1}", id, value.getAttributeSetInstanceId());
            }
        }

        public static void setNullIdOrThrowOnInconsistentIds(String id, AttributeSetInstanceCommand.DeleteAttributeSetInstance value) {
            if (value.getAttributeSetInstanceId() == null) {
                value.setAttributeSetInstanceId(id);
            } else if (!value.getAttributeSetInstanceId().equals(id)) {
                throw DomainError.named("inconsistentId", "Argument Id {0} NOT equals body Id {1}", id, value.getAttributeSetInstanceId());
            }
        }

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
                        filter.put(pName, ApplicationContext.current.getTypeConverter().convertFromString(pClass, values[0]));
                    }
                }
            });
            return filter.entrySet();
        }
    }
}
