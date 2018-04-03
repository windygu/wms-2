package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.apache.cxf.jaxrs.ext.PATCH;

import org.dddml.support.criterion.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.attributesetinstance.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("AttributeSetInstances") @Produces(MediaType.APPLICATION_JSON)
public class AttributeSetInstanceResource {

    @Autowired
    private IdGenerator<String, AttributeSetInstanceCommand.CreateAttributeSetInstance, AttributeSetInstanceState> attributeSetInstanceIdGenerator;

    @Autowired
    private AbstractDynamicObjectMapper<JSONObject,
            AttributeSetInstanceState,
            AttributeSetInstanceCommand.CreateAttributeSetInstance,
            Object> attributeSetInstanceDynamicObjectMapper;


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
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (AttributeSetInstanceMetadata.aliasMap.containsKey(n) ? AttributeSetInstanceMetadata.aliasMap.get(n) : n)),
                        AttributeSetInstanceResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = attributeSetInstanceApplicationService.get(
                        AttributeSetInstanceResourceUtils.getQueryFilterMap(request.getParameterMap()),
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

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public JSONObject get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            String idObj = id;
            AttributeSetInstanceState state = attributeSetInstanceApplicationService.get(idObj);
            if (state == null) { return null; }

            return attributeSetInstanceDynamicObjectMapper.mapState(state, fields);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = attributeSetInstanceApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (AttributeSetInstanceMetadata.aliasMap.containsKey(n) ? AttributeSetInstanceMetadata.aliasMap.get(n) : n)));
            } else {
                count = attributeSetInstanceApplicationService.getCount(AttributeSetInstanceResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @POST
    public String post(JSONObject dynamicObject, @Context HttpServletResponse response) {
        try {
            AttributeSetInstanceCommand.CreateAttributeSetInstance cmd = attributeSetInstanceDynamicObjectMapper.toCommandCreate(dynamicObject);
            String idObj = attributeSetInstanceApplicationService.createWithoutId(cmd);

            response.setStatus(Response.Status.CREATED.getStatusCode());
            return idObj;
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, JSONObject dynamicObject) {
        try {

            AttributeSetInstanceCommand.CreateAttributeSetInstance cmd = attributeSetInstanceDynamicObjectMapper.toCommandCreate(dynamicObject);
            AttributeSetInstanceResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeSetInstanceApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            AttributeSetInstanceMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public AttributeSetInstanceStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            String idObj = id;
            AttributeSetInstanceStateEventDtoConverter dtoConverter = getAttributeSetInstanceStateEventDtoConverter();
            return dtoConverter.toAttributeSetInstanceStateEventDto((AbstractAttributeSetInstanceStateEvent) attributeSetInstanceApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public AttributeSetInstanceStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            String idObj = id;
            AttributeSetInstanceStateDto.DtoConverter dtoConverter = new AttributeSetInstanceStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeSetInstanceStateDto(attributeSetInstanceApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  AttributeSetInstanceStateEventDtoConverter getAttributeSetInstanceStateEventDtoConverter() {
        return new AttributeSetInstanceStateEventDtoConverter();
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
            if (AttributeSetInstanceMetadata.aliasMap.containsKey(fieldName)) {
                return AttributeSetInstanceMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (AttributeSetInstanceMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = AttributeSetInstanceMetadata.propertyTypeMap.get(propertyName);
                if (!StringHelper.isNullOrEmpty(propertyType)) {
                    if (org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.containsKey(propertyType)) {
                        return org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.get(propertyType);
                    }
                }
            }
            return String.class;
        }

        public static Iterable<Map.Entry<String, Object>> getQueryFilterMap(Map<String, String[]> queryNameValuePairs) {
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

        public static AttributeSetInstanceStateDto[] toAttributeSetInstanceStateDtoArray(Iterable<String> ids) {
            List<AttributeSetInstanceStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                AttributeSetInstanceStateDto dto = new AttributeSetInstanceStateDto();
                dto.setAttributeSetInstanceId(id);
                states.add(dto);
            });
            return states.toArray(new AttributeSetInstanceStateDto[0]);
        }

    }

}

