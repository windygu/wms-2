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

@Path("AttributeSetInstanceExtensionFieldMvos")
@Produces(MediaType.APPLICATION_JSON)
public class AttributeSetInstanceExtensionFieldMvoResource {


    @Autowired
    private AttributeSetInstanceExtensionFieldMvoApplicationService attributeSetInstanceExtensionFieldMvoApplicationService;


    @GET
    public AttributeSetInstanceExtensionFieldMvoStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<AttributeSetInstanceExtensionFieldMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = attributeSetInstanceExtensionFieldMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver()),
                        AttributeSetInstanceExtensionFieldMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = attributeSetInstanceExtensionFieldMvoApplicationService.get(
                        AttributeSetInstanceExtensionFieldMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        AttributeSetInstanceExtensionFieldMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            AttributeSetInstanceExtensionFieldMvoStateDto.DtoConverter dtoConverter = new AttributeSetInstanceExtensionFieldMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeSetInstanceExtensionFieldMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GET
    @Path("{id}")
    public AttributeSetInstanceExtensionFieldMvoStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            AttributeSetInstanceExtensionFieldId idObj = AttributeSetInstanceExtensionFieldMvoResourceUtils.parseIdString(id);
            AttributeSetInstanceExtensionFieldMvoState state = attributeSetInstanceExtensionFieldMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            AttributeSetInstanceExtensionFieldMvoStateDto.DtoConverter dtoConverter = new AttributeSetInstanceExtensionFieldMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeSetInstanceExtensionFieldMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count")
    @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = attributeSetInstanceExtensionFieldMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver()));
            } else {
                count = attributeSetInstanceExtensionFieldMvoApplicationService.getCount(AttributeSetInstanceExtensionFieldMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PUT
    @Path("/{id}")
    public void put(@PathParam("id") String id, CreateOrMergePatchAttributeSetInstanceExtensionFieldMvoDto.CreateAttributeSetInstanceExtensionFieldMvoDto value) {
        try {

            AttributeSetInstanceExtensionFieldMvoCommand.CreateAttributeSetInstanceExtensionFieldMvo cmd = value.toCreateAttributeSetInstanceExtensionFieldMvo();
            AttributeSetInstanceExtensionFieldMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeSetInstanceExtensionFieldMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PATCH
    @Path("/{id}")
    public void patch(@PathParam("id") String id, CreateOrMergePatchAttributeSetInstanceExtensionFieldMvoDto.MergePatchAttributeSetInstanceExtensionFieldMvoDto value) {
        try {

            AttributeSetInstanceExtensionFieldMvoCommand.MergePatchAttributeSetInstanceExtensionFieldMvo cmd = value.toMergePatchAttributeSetInstanceExtensionFieldMvo();
            AttributeSetInstanceExtensionFieldMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeSetInstanceExtensionFieldMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            AttributeSetInstanceExtensionFieldMvoCommand.DeleteAttributeSetInstanceExtensionFieldMvo deleteCmd = new AbstractAttributeSetInstanceExtensionFieldMvoCommand.SimpleDeleteAttributeSetInstanceExtensionFieldMvo();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setAttrSetInstEFGroupVersion(version);
            AttributeSetInstanceExtensionFieldMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            attributeSetInstanceExtensionFieldMvoApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields")
    @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            AttributeSetInstanceExtensionFieldMvoFilteringProperties.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}")
    @GET
    public AttributeSetInstanceExtensionFieldMvoStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            AttributeSetInstanceExtensionFieldId idObj = AttributeSetInstanceExtensionFieldMvoResourceUtils.parseIdString(id);
            AttributeSetInstanceExtensionFieldMvoStateEventDtoConverter dtoConverter = getAttributeSetInstanceExtensionFieldMvoStateEventDtoConverter();
            return dtoConverter.toAttributeSetInstanceExtensionFieldMvoStateEventDto((AbstractAttributeSetInstanceExtensionFieldMvoStateEvent) attributeSetInstanceExtensionFieldMvoApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}")
    @GET
    public AttributeSetInstanceExtensionFieldMvoStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            AttributeSetInstanceExtensionFieldId idObj = AttributeSetInstanceExtensionFieldMvoResourceUtils.parseIdString(id);
            AttributeSetInstanceExtensionFieldMvoStateDto.DtoConverter dtoConverter = new AttributeSetInstanceExtensionFieldMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeSetInstanceExtensionFieldMvoStateDto(attributeSetInstanceExtensionFieldMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  AttributeSetInstanceExtensionFieldMvoStateEventDtoConverter getAttributeSetInstanceExtensionFieldMvoStateEventDtoConverter() {
        return new AttributeSetInstanceExtensionFieldMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new AttributeSetInstanceExtensionFieldMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class AttributeSetInstanceExtensionFieldMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return AttributeSetInstanceExtensionFieldMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class AttributeSetInstanceExtensionFieldMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, AttributeSetInstanceExtensionFieldMvoCommand value) {
            AttributeSetInstanceExtensionFieldId idObj = parseIdString(id);
            if (value.getAttributeSetInstanceExtensionFieldId() == null) {
                value.setAttributeSetInstanceExtensionFieldId(idObj);
            } else if (!value.getAttributeSetInstanceExtensionFieldId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getAttributeSetInstanceExtensionFieldId());
            }
        }
    

        public static AttributeSetInstanceExtensionFieldId parseIdString(String idString) {
            AttributeSetInstanceExtensionFieldIdFlattenedDtoFormatter formatter = new AttributeSetInstanceExtensionFieldIdFlattenedDtoFormatter();
            AttributeSetInstanceExtensionFieldIdFlattenedDto idDto = formatter.parse(idString);
            return idDto.toAttributeSetInstanceExtensionFieldId();
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (AttributeSetInstanceExtensionFieldMvoFilteringProperties.propertyTypeMap.containsKey(fieldName)) {
                return fieldName;
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (AttributeSetInstanceExtensionFieldMvoFilteringProperties.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = AttributeSetInstanceExtensionFieldMvoFilteringProperties.propertyTypeMap.get(propertyName);
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

        public static AttributeSetInstanceExtensionFieldMvoStateDto[] toAttributeSetInstanceExtensionFieldMvoStateDtoArray(Iterable<AttributeSetInstanceExtensionFieldId> ids) {
            List<AttributeSetInstanceExtensionFieldMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                AttributeSetInstanceExtensionFieldMvoStateDto dto = new AttributeSetInstanceExtensionFieldMvoStateDto();
                dto.setAttributeSetInstanceExtensionFieldId(new AttributeSetInstanceExtensionFieldIdDtoWrapper(id));
                states.add(dto);
            });
            return states.toArray(new AttributeSetInstanceExtensionFieldMvoStateDto[0]);
        }

    }

}

