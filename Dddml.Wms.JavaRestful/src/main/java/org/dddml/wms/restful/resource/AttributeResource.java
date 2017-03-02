package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.apache.cxf.jaxrs.ext.PATCH;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("Attributes")
@Produces(MediaType.APPLICATION_JSON)
public class AttributeResource {

    @Autowired
    private IdGenerator<String, AttributeCommand.CreateAttribute> attributeIdGenerator;


    @Autowired
    private AttributeApplicationService attributeApplicationService;


    @GET
    public AttributeStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<AttributeState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = attributeApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver()),
                        AttributeResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = attributeApplicationService.get(
                        AttributeResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        AttributeResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            AttributeStateDto.DtoConverter dtoConverter = new AttributeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GET
    @Path("{id}")
    public AttributeStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            String idObj = id;
            AttributeState state = attributeApplicationService.get(idObj);
            if (state == null) { return null; }

            AttributeStateDto.DtoConverter dtoConverter = new AttributeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("_nextId")
    @GET
    public String getNextId() {
        try {
            return attributeIdGenerator.getNextId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count")
    @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = attributeApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver()));
            } else {
                count = attributeApplicationService.getCount(AttributeResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PUT
    @Path("/{id}")
    public void put(@PathParam("id") String id, CreateOrMergePatchAttributeDto.CreateAttributeDto value) {
        try {

            AttributeCommand.CreateAttribute cmd = value.toCreateAttribute();
            AttributeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PATCH
    @Path("/{id}")
    public void patch(@PathParam("id") String id, CreateOrMergePatchAttributeDto.MergePatchAttributeDto value) {
        try {

            AttributeCommand.MergePatchAttribute cmd = value.toMergePatchAttribute();
            AttributeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            AttributeCommand.DeleteAttribute deleteCmd = new AbstractAttributeCommand.SimpleDeleteAttribute();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            AttributeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            attributeApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields")
    @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            AttributeFilteringProperties.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}")
    @GET
    public AttributeStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            String idObj = id;
            AttributeStateEventDtoConverter dtoConverter = getAttributeStateEventDtoConverter();
            return dtoConverter.toAttributeStateEventDto((AbstractAttributeStateEvent) attributeApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}")
    @GET
    public AttributeStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            String idObj = id;
            AttributeStateDto.DtoConverter dtoConverter = new AttributeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeStateDto(attributeApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{attributeId}/AttributeValues/{value}")
    @GET
    public AttributeValueStateDto getAttributeValue(@PathParam("attributeId") String attributeId, @PathParam("value") String value) {
        try {

            AttributeValueState state = attributeApplicationService.getAttributeValue(attributeId, value);
            if (state == null) { return null; }
            AttributeValueStateDto.DtoConverter dtoConverter = new AttributeValueStateDto.DtoConverter();
            AttributeValueStateDto stateDto = dtoConverter.toAttributeValueStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  AttributeStateEventDtoConverter getAttributeStateEventDtoConverter() {
        return new AttributeStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new AttributePropertyTypeResolver();
    }

    // ////////////////////////////////

    private class AttributePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return AttributeResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class AttributeResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, AttributeCommand value) {
            String idObj = id;
            if (value.getAttributeId() == null) {
                value.setAttributeId(idObj);
            } else if (!value.getAttributeId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getAttributeId());
            }
        }
    


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (AttributeFilteringProperties.propertyTypeMap.containsKey(fieldName)) {
                return fieldName;
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (AttributeFilteringProperties.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = AttributeFilteringProperties.propertyTypeMap.get(propertyName);
                if (!StringHelper.isNullOrEmpty(propertyType)) {
                    if (ReflectUtils.CLASS_MAP.containsKey(propertyType)) {
                        return ReflectUtils.CLASS_MAP.get(propertyType);
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

        public static AttributeStateDto[] toAttributeStateDtoArray(Iterable<String> ids) {
            List<AttributeStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                AttributeStateDto dto = new AttributeStateDto();
                dto.setAttributeId(id);
                states.add(dto);
            });
            return states.toArray(new AttributeStateDto[0]);
        }

    }

}

