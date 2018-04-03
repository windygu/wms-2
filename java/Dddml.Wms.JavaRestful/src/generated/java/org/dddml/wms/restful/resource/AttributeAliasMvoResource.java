package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.apache.cxf.jaxrs.ext.PATCH;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.attribute.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.attributealiasmvo.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("AttributeAliasMvos") @Produces(MediaType.APPLICATION_JSON)
public class AttributeAliasMvoResource {


    @Autowired
    private AttributeAliasMvoApplicationService attributeAliasMvoApplicationService;


    @GET
    public AttributeAliasMvoStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<AttributeAliasMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = attributeAliasMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (AttributeAliasMvoMetadata.aliasMap.containsKey(n) ? AttributeAliasMvoMetadata.aliasMap.get(n) : n)),
                        AttributeAliasMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = attributeAliasMvoApplicationService.get(
                        AttributeAliasMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        AttributeAliasMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            AttributeAliasMvoStateDto.DtoConverter dtoConverter = new AttributeAliasMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeAliasMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public AttributeAliasMvoStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            AttributeAliasId idObj = AttributeAliasMvoResourceUtils.parseIdString(id);
            AttributeAliasMvoState state = attributeAliasMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            AttributeAliasMvoStateDto.DtoConverter dtoConverter = new AttributeAliasMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeAliasMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = attributeAliasMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (AttributeAliasMvoMetadata.aliasMap.containsKey(n) ? AttributeAliasMvoMetadata.aliasMap.get(n) : n)));
            } else {
                count = attributeAliasMvoApplicationService.getCount(AttributeAliasMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @POST
    public AttributeAliasId post(CreateOrMergePatchAttributeAliasMvoDto.CreateAttributeAliasMvoDto value, @Context HttpServletResponse response) {
        try {
            AttributeAliasMvoCommand.CreateAttributeAliasMvo cmd = value.toCreateAttributeAliasMvo();
            if (cmd.getAttributeAliasId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "AttributeAliasMvo");
            }
            attributeAliasMvoApplicationService.when(cmd);

            response.setStatus(Response.Status.CREATED.getStatusCode());
            return cmd.getAttributeAliasId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchAttributeAliasMvoDto value) {
        try {
            if (value.getAttributeVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                AttributeAliasMvoCommand.MergePatchAttributeAliasMvo cmd = (AttributeAliasMvoCommand.MergePatchAttributeAliasMvo) value.toCommand();
                AttributeAliasMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                attributeAliasMvoApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            AttributeAliasMvoCommand.CreateAttributeAliasMvo cmd = (AttributeAliasMvoCommand.CreateAttributeAliasMvo) value.toCommand();
            AttributeAliasMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeAliasMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchAttributeAliasMvoDto.MergePatchAttributeAliasMvoDto value) {
        try {

            AttributeAliasMvoCommand.MergePatchAttributeAliasMvo cmd = value.toMergePatchAttributeAliasMvo();
            AttributeAliasMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeAliasMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @DELETE
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            AttributeAliasMvoCommand.DeleteAttributeAliasMvo deleteCmd = new AbstractAttributeAliasMvoCommand.SimpleDeleteAttributeAliasMvo();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setAttributeVersion(version);
            AttributeAliasMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            attributeAliasMvoApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            AttributeAliasMvoMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public AttributeAliasMvoStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            AttributeAliasId idObj = AttributeAliasMvoResourceUtils.parseIdString(id);
            AttributeAliasMvoStateEventDtoConverter dtoConverter = getAttributeAliasMvoStateEventDtoConverter();
            return dtoConverter.toAttributeAliasMvoStateEventDto((AbstractAttributeAliasMvoStateEvent) attributeAliasMvoApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public AttributeAliasMvoStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            AttributeAliasId idObj = AttributeAliasMvoResourceUtils.parseIdString(id);
            AttributeAliasMvoStateDto.DtoConverter dtoConverter = new AttributeAliasMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeAliasMvoStateDto(attributeAliasMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  AttributeAliasMvoStateEventDtoConverter getAttributeAliasMvoStateEventDtoConverter() {
        return new AttributeAliasMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new AttributeAliasMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class AttributeAliasMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return AttributeAliasMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class AttributeAliasMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, AttributeAliasMvoCommand value) {
            AttributeAliasId idObj = parseIdString(id);
            if (value.getAttributeAliasId() == null) {
                value.setAttributeAliasId(idObj);
            } else if (!value.getAttributeAliasId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getAttributeAliasId());
            }
        }
    

        public static AttributeAliasId parseIdString(String idString) {
            TextFormatter<AttributeAliasId> formatter =
                    new AbstractValueObjectTextFormatter<AttributeAliasId>(AttributeAliasId.class) {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    };
            return formatter.parse(idString);
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (AttributeAliasMvoMetadata.aliasMap.containsKey(fieldName)) {
                return AttributeAliasMvoMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (AttributeAliasMvoMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = AttributeAliasMvoMetadata.propertyTypeMap.get(propertyName);
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

        public static AttributeAliasMvoStateDto[] toAttributeAliasMvoStateDtoArray(Iterable<AttributeAliasId> ids) {
            List<AttributeAliasMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                AttributeAliasMvoStateDto dto = new AttributeAliasMvoStateDto();
                dto.setAttributeAliasId(id);
                states.add(dto);
            });
            return states.toArray(new AttributeAliasMvoStateDto[0]);
        }

    }

}

