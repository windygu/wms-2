package org.dddml.wms.restful.resource;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.cxf.jaxrs.ext.PATCH;
import org.dddml.support.criterion.*;
import org.dddml.support.criterion.TypeConverter;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.meta.*;
import org.dddml.wms.ext.*;
import org.dddml.wms.restful.exception.WebApiApplicationException;
import org.dddml.wms.specialization.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
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
public class <#= Aggregate.Name #>Resource {
    @Autowired
    private <#= Aggregate.Name #>ApplicationService attributeSetInstanceApplicationService;

    @Autowired
    private IdGenerator<String, <#= Aggregate.Name #>Command.Create<#= Aggregate.Name #>> attributeSetInstanceIdGenerator;

    @Autowired
    private AbstractDynamicObjectMapper<JSONObject,
            <#= Aggregate.Name #>State,
            <#= Aggregate.Name #>Command.Create<#= Aggregate.Name #>,
            <#= Aggregate.Name #>Command.MergePatch<#= Aggregate.Name #>> <#= aggregateDynamicObjectMapperPrivateFieldName #>;

    /**
     * 根据指定条件查询 <#= Aggregate.Name #>
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
            Iterable<<#= Aggregate.Name #>State> states = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = attributeSetInstanceApplicationService.get(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionDefaultTypeConvert(), new <#= Aggregate.Name #>PropertyTypeResolver())
                        , <#= controllerUtilsClassName #>.getQueryOrders(sort, getQueryOrderSeparator()), firstResult, maxResults);
            } else {
                states = attributeSetInstanceApplicationService.get(<#= controllerUtilsClassName #>.getQueryFilterDictionary(request.getParameterMap())
                        , <#= controllerUtilsClassName #>.getQueryOrders(sort, getQueryOrderSeparator()), firstResult, maxResults);
            }
            JSONArray dynamicArray = new JSONArray();
            if (states != null) {
                states.forEach(state -> {
                    dynamicArray.add(<#= aggregateDynamicObjectMapperPrivateFieldName #>.mapState(state, fields));
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
            <#= Aggregate.Name #>State state = attributeSetInstanceApplicationService.get(id);
            if (state == null) {
                return null;
            }
            return <#= aggregateDynamicObjectMapperPrivateFieldName #>.mapState(state, fields);
        } catch (DomainError error) {
            throw error;
        } catch (Exception ex) {
            throw new WebApiApplicationException(ex);
        }
    }


    /**
     * 查询符合条件的 <#= Aggregate.Name #> 数量
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
                        getCriterionDefaultTypeConvert(), new <#= Aggregate.Name #>PropertyTypeResolver()));
            } else {
                count = attributeSetInstanceApplicationService.getCount(<#= controllerUtilsClassName #>.getQueryFilterDictionary(request.getParameterMap()));
            }
            return count;
        } catch (DomainError error) {
            throw error;
        } catch (Exception ex) {
            throw new WebApiApplicationException(ex);
        }
    }


    /**
     * 修改<#= Aggregate.Name #>
     *
     * @param id            <#= Aggregate.Name #>Id
     * @param dynamicObject <#= Aggregate.Name #> Body
     */
    @PUT
    @Path("/{id}")
    public void Put(@PathParam("id") String id, JSONObject dynamicObject) {
        try {
            <#= Aggregate.Name #>Command.Create<#= Aggregate.Name #> value = <#= aggregateDynamicObjectMapperPrivateFieldName #>.toCommandCreate(dynamicObject);
            //System.out.println(value.get_F_C5_4_());
            <#= controllerUtilsClassName #>.setNullIdOrThrowOnInconsistentIds(id, value);
            attributeSetInstanceApplicationService.when(value);
        } catch (DomainError error) {
            throw error;
        } catch (Exception ex) {
            throw new WebApiApplicationException(ex);
        }
    }


    /**
     * 添加 <#= Aggregate.Name #>
     *
     * @param jsonObject <#= Aggregate.Name #> Body
     * @param response   响应
     * @return <#= Aggregate.Name #> Id
     */
    @POST
    public String post(JSONObject jsonObject, @Context HttpServletResponse response) {
        try {
            <#= Aggregate.Name #>Command.Create<#= Aggregate.Name #> create<#= Aggregate.Name #>
                    = <#= aggregateDynamicObjectMapperPrivateFieldName #>.toCommandCreate(jsonObject);
            IdGenerator.GetOrGenerateIdResult<String> idResult = attributeSetInstanceIdGenerator.getOrGenerateId(create<#= Aggregate.Name #>);
            create<#= Aggregate.Name #>.set<#= Aggregate.Name #>Id(idResult.getId());
            if (!idResult.isReused()) {
                attributeSetInstanceApplicationService.when(create<#= Aggregate.Name #>);
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
     * 修改已经存在的 <#= Aggregate.Name #>
     *
     * @param id            <#= Aggregate.Name #> Id
     * @param dynamicObject 修改的属性
     */
    @PATCH
    @Path("{id}")
    public void patch(@PathParam("id") String id, JSONObject dynamicObject) {
        try {
            <#= Aggregate.Name #>Command.MergePatch<#= Aggregate.Name #> value = <#= aggregateDynamicObjectMapperPrivateFieldName #>.toCommandMergePatch(dynamicObject);
            <#= controllerUtilsClassName #>.setNullIdOrThrowOnInconsistentIds(id, value);
            attributeSetInstanceApplicationService.when(value);
        } catch (DomainError error) {
            throw error;
        } catch (Exception ex) {
            throw new WebApiApplicationException(ex);
        }
    }


    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id, @QueryParam("commandId") String commandId, @QueryParam("version") String version,
                       @QueryParam("requesterId") String requesterId) {
        /*try {
            var value = new Delete<#= Aggregate.Name #>Dto();
            value.CommandId = commandId;
            value.RequesterId = requesterId;
            value.Version = (long) Convert.ChangeType(version, typeof(long));
            <#= Aggregate.Name #>sControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _attributeSetInstanceApplicationService.When(value as IDelete<#= Aggregate.Name #>);
        } catch (Exception ex) {
            var response = <#= Aggregate.Name #>sControllerUtils.GetErrorHttpResponseMessage(ex);
            throw new HttpResponseException(response);
        }*/
    }


    @Path("_metadata/filteringFields")
    @GET
    public Iterable<PropertyMetadataDto> getMetadataFilteringFields() {
        try {
            List<PropertyMetadataDto> filtering = new ArrayList<>();
            <#= Aggregate.Name #>FilteringProperties.propertyTypeMap.forEach((key, value) -> {
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

    private class <#= Aggregate.Name #>PropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return <#= Aggregate.Name #>Resource.<#= controllerUtilsClassName #>.GetFilterPropertyType(propertyName);
        }
    }


    private static class <#= controllerUtilsClassName #> {


        public static void setNullIdOrThrowOnInconsistentIds(String id, <#= Aggregate.Name #>Command.CreateOrMergePatch<#= Aggregate.Name #> value) {
            if (value.get<#= Aggregate.Name #>Id() == null) {
                value.set<#= Aggregate.Name #>Id(id);
            } else if (!value.get<#= Aggregate.Name #>Id().equals(id)) {
                throw DomainError.named("inconsistentId", "Argument Id {0} NOT equals body Id {1}", id, value.get<#= Aggregate.Name #>Id());
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
            if (<#= Aggregate.Name #>FilteringProperties.propertyTypeMap.containsKey(fieldName)) {
                return fieldName;
            }
            return null;
        }

        public static Class GetFilterPropertyType(String propertyName) {
            if (<#= Aggregate.Name #>FilteringProperties.propertyTypeMap.containsKey(propertyName)) {
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
