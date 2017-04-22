package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.attribute.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.attributevaluemvo.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.apache.cxf.jaxrs.ext.PATCH;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("AttributeValueMvos")
@Produces(MediaType.APPLICATION_JSON)
public class AttributeValueMvoResource {


    @Autowired
    private AttributeValueMvoApplicationService attributeValueMvoApplicationService;


    @GET
    public AttributeValueMvoStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<AttributeValueMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = attributeValueMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (AttributeValueMvoFilteringProperties.aliasMap.containsKey(n) ? AttributeValueMvoFilteringProperties.aliasMap.get(n) : n)),
                        AttributeValueMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = attributeValueMvoApplicationService.get(
                        AttributeValueMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        AttributeValueMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            AttributeValueMvoStateDto.DtoConverter dtoConverter = new AttributeValueMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeValueMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GET
    @Path("{id}")
    public AttributeValueMvoStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            AttributeValueId idObj = AttributeValueMvoResourceUtils.parseIdString(id);
            AttributeValueMvoState state = attributeValueMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            AttributeValueMvoStateDto.DtoConverter dtoConverter = new AttributeValueMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeValueMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count")
    @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = attributeValueMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (AttributeValueMvoFilteringProperties.aliasMap.containsKey(n) ? AttributeValueMvoFilteringProperties.aliasMap.get(n) : n)));
            } else {
                count = attributeValueMvoApplicationService.getCount(AttributeValueMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PUT
    @Path("/{id}")
    public void put(@PathParam("id") String id, CreateOrMergePatchAttributeValueMvoDto.CreateAttributeValueMvoDto value) {
        try {

            AttributeValueMvoCommand.CreateAttributeValueMvo cmd = value.toCreateAttributeValueMvo();
            AttributeValueMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeValueMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PATCH
    @Path("/{id}")
    public void patch(@PathParam("id") String id, CreateOrMergePatchAttributeValueMvoDto.MergePatchAttributeValueMvoDto value) {
        try {

            AttributeValueMvoCommand.MergePatchAttributeValueMvo cmd = value.toMergePatchAttributeValueMvo();
            AttributeValueMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeValueMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            AttributeValueMvoCommand.DeleteAttributeValueMvo deleteCmd = new AbstractAttributeValueMvoCommand.SimpleDeleteAttributeValueMvo();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setAttributeVersion(version);
            AttributeValueMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            attributeValueMvoApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields")
    @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            AttributeValueMvoFilteringProperties.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}")
    @GET
    public AttributeValueMvoStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            AttributeValueId idObj = AttributeValueMvoResourceUtils.parseIdString(id);
            AttributeValueMvoStateEventDtoConverter dtoConverter = getAttributeValueMvoStateEventDtoConverter();
            return dtoConverter.toAttributeValueMvoStateEventDto((AbstractAttributeValueMvoStateEvent) attributeValueMvoApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}")
    @GET
    public AttributeValueMvoStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            AttributeValueId idObj = AttributeValueMvoResourceUtils.parseIdString(id);
            AttributeValueMvoStateDto.DtoConverter dtoConverter = new AttributeValueMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeValueMvoStateDto(attributeValueMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  AttributeValueMvoStateEventDtoConverter getAttributeValueMvoStateEventDtoConverter() {
        return new AttributeValueMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new AttributeValueMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class AttributeValueMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return AttributeValueMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class AttributeValueMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, AttributeValueMvoCommand value) {
            AttributeValueId idObj = parseIdString(id);
            if (value.getAttributeValueId() == null) {
                value.setAttributeValueId(idObj);
            } else if (!value.getAttributeValueId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getAttributeValueId());
            }
        }
    

        public static AttributeValueId parseIdString(String idString) {
            AttributeValueIdFlattenedDtoFormatter formatter = new AttributeValueIdFlattenedDtoFormatter();
            AttributeValueIdFlattenedDto idDto = formatter.parse(idString);
            return idDto.toAttributeValueId();
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (AttributeValueMvoFilteringProperties.aliasMap.containsKey(fieldName)) {
                return AttributeValueMvoFilteringProperties.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (AttributeValueMvoFilteringProperties.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = AttributeValueMvoFilteringProperties.propertyTypeMap.get(propertyName);
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

        public static AttributeValueMvoStateDto[] toAttributeValueMvoStateDtoArray(Iterable<AttributeValueId> ids) {
            List<AttributeValueMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                AttributeValueMvoStateDto dto = new AttributeValueMvoStateDto();
                dto.setAttributeValueId(new AttributeValueIdDtoWrapper(id));
                states.add(dto);
            });
            return states.toArray(new AttributeValueMvoStateDto[0]);
        }

    }

}

