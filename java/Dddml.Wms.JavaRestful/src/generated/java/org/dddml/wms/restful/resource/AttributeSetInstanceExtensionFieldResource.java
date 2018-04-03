package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.apache.cxf.jaxrs.ext.PATCH;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.attributesetinstanceextensionfield.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("AttributeSetInstanceExtensionFields") @Produces(MediaType.APPLICATION_JSON)
public class AttributeSetInstanceExtensionFieldResource {


    @Autowired
    private AttributeSetInstanceExtensionFieldApplicationService attributeSetInstanceExtensionFieldApplicationService;


    @GET
    public AttributeSetInstanceExtensionFieldStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<AttributeSetInstanceExtensionFieldState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = attributeSetInstanceExtensionFieldApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (AttributeSetInstanceExtensionFieldMetadata.aliasMap.containsKey(n) ? AttributeSetInstanceExtensionFieldMetadata.aliasMap.get(n) : n)),
                        AttributeSetInstanceExtensionFieldResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = attributeSetInstanceExtensionFieldApplicationService.get(
                        AttributeSetInstanceExtensionFieldResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        AttributeSetInstanceExtensionFieldResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            AttributeSetInstanceExtensionFieldStateDto.DtoConverter dtoConverter = new AttributeSetInstanceExtensionFieldStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeSetInstanceExtensionFieldStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public AttributeSetInstanceExtensionFieldStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            String idObj = id;
            AttributeSetInstanceExtensionFieldState state = attributeSetInstanceExtensionFieldApplicationService.get(idObj);
            if (state == null) { return null; }

            AttributeSetInstanceExtensionFieldStateDto.DtoConverter dtoConverter = new AttributeSetInstanceExtensionFieldStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeSetInstanceExtensionFieldStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = attributeSetInstanceExtensionFieldApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (AttributeSetInstanceExtensionFieldMetadata.aliasMap.containsKey(n) ? AttributeSetInstanceExtensionFieldMetadata.aliasMap.get(n) : n)));
            } else {
                count = attributeSetInstanceExtensionFieldApplicationService.getCount(AttributeSetInstanceExtensionFieldResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchAttributeSetInstanceExtensionFieldDto.CreateAttributeSetInstanceExtensionFieldDto value) {
        try {

            AttributeSetInstanceExtensionFieldCommand.CreateAttributeSetInstanceExtensionField cmd = value.toCreateAttributeSetInstanceExtensionField();
            AttributeSetInstanceExtensionFieldResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeSetInstanceExtensionFieldApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchAttributeSetInstanceExtensionFieldDto.MergePatchAttributeSetInstanceExtensionFieldDto value) {
        try {

            AttributeSetInstanceExtensionFieldCommand.MergePatchAttributeSetInstanceExtensionField cmd = value.toMergePatchAttributeSetInstanceExtensionField();
            AttributeSetInstanceExtensionFieldResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeSetInstanceExtensionFieldApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @DELETE
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            AttributeSetInstanceExtensionFieldCommand.DeleteAttributeSetInstanceExtensionField deleteCmd = new AbstractAttributeSetInstanceExtensionFieldCommand.SimpleDeleteAttributeSetInstanceExtensionField();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            AttributeSetInstanceExtensionFieldResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            attributeSetInstanceExtensionFieldApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            AttributeSetInstanceExtensionFieldMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public AttributeSetInstanceExtensionFieldStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            String idObj = id;
            AttributeSetInstanceExtensionFieldStateEventDtoConverter dtoConverter = getAttributeSetInstanceExtensionFieldStateEventDtoConverter();
            return dtoConverter.toAttributeSetInstanceExtensionFieldStateEventDto((AbstractAttributeSetInstanceExtensionFieldStateEvent) attributeSetInstanceExtensionFieldApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public AttributeSetInstanceExtensionFieldStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            String idObj = id;
            AttributeSetInstanceExtensionFieldStateDto.DtoConverter dtoConverter = new AttributeSetInstanceExtensionFieldStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeSetInstanceExtensionFieldStateDto(attributeSetInstanceExtensionFieldApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  AttributeSetInstanceExtensionFieldStateEventDtoConverter getAttributeSetInstanceExtensionFieldStateEventDtoConverter() {
        return new AttributeSetInstanceExtensionFieldStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new AttributeSetInstanceExtensionFieldPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class AttributeSetInstanceExtensionFieldPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return AttributeSetInstanceExtensionFieldResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class AttributeSetInstanceExtensionFieldResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, AttributeSetInstanceExtensionFieldCommand value) {
            String idObj = id;
            if (value.getName() == null) {
                value.setName(idObj);
            } else if (!value.getName().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getName());
            }
        }
    


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (AttributeSetInstanceExtensionFieldMetadata.aliasMap.containsKey(fieldName)) {
                return AttributeSetInstanceExtensionFieldMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (AttributeSetInstanceExtensionFieldMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = AttributeSetInstanceExtensionFieldMetadata.propertyTypeMap.get(propertyName);
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

        public static AttributeSetInstanceExtensionFieldStateDto[] toAttributeSetInstanceExtensionFieldStateDtoArray(Iterable<String> ids) {
            List<AttributeSetInstanceExtensionFieldStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                AttributeSetInstanceExtensionFieldStateDto dto = new AttributeSetInstanceExtensionFieldStateDto();
                dto.setName(id);
                states.add(dto);
            });
            return states.toArray(new AttributeSetInstanceExtensionFieldStateDto[0]);
        }

    }

}

