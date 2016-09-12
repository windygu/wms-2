package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.dddml.support.criterion.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.apache.cxf.jaxrs.ext.PATCH;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.wms.restful.exception.WebApiApplicationException;
import org.dddml.support.criterion.TypeConverter;

@Path("AttributeSetInstances")
@Produces(MediaType.APPLICATION_JSON)
public class AttributeSetInstanceResource {

    @Autowired
    private AbstractDynamicObjectMapper<JSONObject,
            AttributeSetInstanceState,
            AttributeSetInstanceCommand.CreateAttributeSetInstance,
            AttributeSetInstanceCommand.MergePatchAttributeSetInstance> attributeSetInstanceDynamicObjectMapper;


    @Autowired
    private AttributeSetInstanceApplicationService attributeSetInstanceApplicationService;


    @GET
    public JSONArray getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<AttributeSetInstanceState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = attributeSetInstanceApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver()),
                        AttributeSetInstanceResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = attributeSetInstanceApplicationService.get(
                        AttributeSetInstanceResourceUtils.getQueryFilterDictionary(request.getParameterMap()),
                        AttributeSetInstanceResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            JSONArray dynamicArray = new JSONArray();
            if (states != null) {
                states.forEach(state -> {
                    dynamicArray.add(attributeSetInstanceDynamicObjectMapper.mapState(state, fields));
                });
            }
            return dynamicArray;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new WebApiApplicationException(ex); }
    }

    @GET
    @Path("{id}")
    public JSONObject get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            String idObj = id;
            AttributeSetInstanceState state = attributeSetInstanceApplicationService.get(idObj);
            if (state == null) { return null; }

            return attributeSetInstanceDynamicObjectMapper.mapState(state, fields);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new WebApiApplicationException(ex); }
    }

    @Path("_count")
    @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = attributeSetInstanceApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver()));
            } else {
                count = attributeSetInstanceApplicationService.getCount(AttributeSetInstanceResourceUtils.getQueryFilterDictionary(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new WebApiApplicationException(ex); }
    }


    @PUT
    @Path("/{id}")
    public void put(@PathParam("id") String id, JSONObject dynamicObject) {
        try {

            AttributeSetInstanceCommand.CreateAttributeSetInstance cmd = attributeSetInstanceDynamicObjectMapper.toCommandCreate(dynamicObject);
            AttributeSetInstanceResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeSetInstanceApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new WebApiApplicationException(ex); }
    }


    @PATCH
    @Path("/{id}")
    public void patch(@PathParam("id") String id, JSONObject dynamicObject) {
        try {

            AttributeSetInstanceCommand.MergePatchAttributeSetInstance cmd = attributeSetInstanceDynamicObjectMapper.toCommandMergePatch(dynamicObject);
            AttributeSetInstanceResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeSetInstanceApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new WebApiApplicationException(ex); }
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            AttributeSetInstanceCommand.DeleteAttributeSetInstance deleteCmd = new AbstractAttributeSetInstanceCommand.SimpleDeleteAttributeSetInstance();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            AttributeSetInstanceResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            attributeSetInstanceApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new WebApiApplicationException(ex); }
    }

    @Path("_metadata/filteringFields")
    @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            AttributeSetInstanceFilteringProperties.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new WebApiApplicationException(ex); }
    }

    @Path("{id}/_stateEvents/{version}")
    @GET
    public AttributeSetInstanceStateEvent getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            String idObj = id;
            return attributeSetInstanceApplicationService.getStateEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new WebApiApplicationException(ex); }
    }


    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new AttributeSetInstancePropertyTypeResolver();
    }

    // ////////////////////////////////

    private class AttributeSetInstancePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return AttributeSetInstanceResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class AttributeSetInstanceResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, AttributeSetInstanceCommand value) {
            String idObj = id;
            if (value.getAttributeSetInstanceId() == null) {
                value.setAttributeSetInstanceId(idObj);
            } else if (!value.getAttributeSetInstanceId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getAttributeSetInstanceId());
            }
        }
    


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (AttributeSetInstanceFilteringProperties.propertyTypeMap.containsKey(fieldName)) {
/* TODO...
                var p = AttributeSetInstanceMetadata.Instance.PropertyMetadataDictionary[fieldName];
                if (p.IsFilteringProperty)
                {
                    var propertyName = fieldName;
                    if (p.IsDerived)
                    {
                        propertyName = p.DerivedFrom;
                    }
                    return propertyName;
                }
*/
                return fieldName;
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (AttributeSetInstanceFilteringProperties.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = AttributeSetInstanceFilteringProperties.propertyTypeMap.get(propertyName);
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
                        Class pClass = getFilterPropertyType(pName);
                        filter.put(pName, ApplicationContext.current.getTypeConverter().convertFromString(pClass, values[0]));
                    }
                }
            });
            return filter.entrySet();
        }

    }

}

