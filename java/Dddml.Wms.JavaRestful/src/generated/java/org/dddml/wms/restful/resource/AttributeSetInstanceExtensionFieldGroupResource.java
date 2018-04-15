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
import org.dddml.wms.domain.attributesetinstanceextensionfieldgroup.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("AttributeSetInstanceExtensionFieldGroups") @Produces(MediaType.APPLICATION_JSON)
public class AttributeSetInstanceExtensionFieldGroupResource {


    @Autowired
    private AttributeSetInstanceExtensionFieldGroupApplicationService attributeSetInstanceExtensionFieldGroupApplicationService;


    @GET
    public AttributeSetInstanceExtensionFieldGroupStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<AttributeSetInstanceExtensionFieldGroupState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = attributeSetInstanceExtensionFieldGroupApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (AttributeSetInstanceExtensionFieldGroupMetadata.aliasMap.containsKey(n) ? AttributeSetInstanceExtensionFieldGroupMetadata.aliasMap.get(n) : n)),
                        AttributeSetInstanceExtensionFieldGroupResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = attributeSetInstanceExtensionFieldGroupApplicationService.get(
                        AttributeSetInstanceExtensionFieldGroupResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        AttributeSetInstanceExtensionFieldGroupResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            AttributeSetInstanceExtensionFieldGroupStateDto.DtoConverter dtoConverter = new AttributeSetInstanceExtensionFieldGroupStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeSetInstanceExtensionFieldGroupStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public AttributeSetInstanceExtensionFieldGroupStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            String idObj = id;
            AttributeSetInstanceExtensionFieldGroupState state = attributeSetInstanceExtensionFieldGroupApplicationService.get(idObj);
            if (state == null) { return null; }

            AttributeSetInstanceExtensionFieldGroupStateDto.DtoConverter dtoConverter = new AttributeSetInstanceExtensionFieldGroupStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeSetInstanceExtensionFieldGroupStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = attributeSetInstanceExtensionFieldGroupApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (AttributeSetInstanceExtensionFieldGroupMetadata.aliasMap.containsKey(n) ? AttributeSetInstanceExtensionFieldGroupMetadata.aliasMap.get(n) : n)));
            } else {
                count = attributeSetInstanceExtensionFieldGroupApplicationService.getCount(AttributeSetInstanceExtensionFieldGroupResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @POST
    public String post(CreateOrMergePatchAttributeSetInstanceExtensionFieldGroupDto.CreateAttributeSetInstanceExtensionFieldGroupDto value, @Context HttpServletResponse response) {
        try {
            AttributeSetInstanceExtensionFieldGroupCommand.CreateAttributeSetInstanceExtensionFieldGroup cmd = value.toCreateAttributeSetInstanceExtensionFieldGroup();
            if (cmd.getId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "AttributeSetInstanceExtensionFieldGroup");
            }
            attributeSetInstanceExtensionFieldGroupApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchAttributeSetInstanceExtensionFieldGroupDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                AttributeSetInstanceExtensionFieldGroupCommand.MergePatchAttributeSetInstanceExtensionFieldGroup cmd = (AttributeSetInstanceExtensionFieldGroupCommand.MergePatchAttributeSetInstanceExtensionFieldGroup) value.toCommand();
                AttributeSetInstanceExtensionFieldGroupResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                attributeSetInstanceExtensionFieldGroupApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            AttributeSetInstanceExtensionFieldGroupCommand.CreateAttributeSetInstanceExtensionFieldGroup cmd = (AttributeSetInstanceExtensionFieldGroupCommand.CreateAttributeSetInstanceExtensionFieldGroup) value.toCommand();
            AttributeSetInstanceExtensionFieldGroupResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeSetInstanceExtensionFieldGroupApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchAttributeSetInstanceExtensionFieldGroupDto.MergePatchAttributeSetInstanceExtensionFieldGroupDto value) {
        try {

            AttributeSetInstanceExtensionFieldGroupCommand.MergePatchAttributeSetInstanceExtensionFieldGroup cmd = value.toMergePatchAttributeSetInstanceExtensionFieldGroup();
            AttributeSetInstanceExtensionFieldGroupResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeSetInstanceExtensionFieldGroupApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @DELETE
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            AttributeSetInstanceExtensionFieldGroupCommand.DeleteAttributeSetInstanceExtensionFieldGroup deleteCmd = new AbstractAttributeSetInstanceExtensionFieldGroupCommand.SimpleDeleteAttributeSetInstanceExtensionFieldGroup();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            AttributeSetInstanceExtensionFieldGroupResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            attributeSetInstanceExtensionFieldGroupApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            AttributeSetInstanceExtensionFieldGroupMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public AttributeSetInstanceExtensionFieldGroupStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            String idObj = id;
            AttributeSetInstanceExtensionFieldGroupStateEventDtoConverter dtoConverter = getAttributeSetInstanceExtensionFieldGroupStateEventDtoConverter();
            return dtoConverter.toAttributeSetInstanceExtensionFieldGroupStateEventDto((AbstractAttributeSetInstanceExtensionFieldGroupEvent) attributeSetInstanceExtensionFieldGroupApplicationService.getEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public AttributeSetInstanceExtensionFieldGroupStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            String idObj = id;
            AttributeSetInstanceExtensionFieldGroupStateDto.DtoConverter dtoConverter = new AttributeSetInstanceExtensionFieldGroupStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeSetInstanceExtensionFieldGroupStateDto(attributeSetInstanceExtensionFieldGroupApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  AttributeSetInstanceExtensionFieldGroupStateEventDtoConverter getAttributeSetInstanceExtensionFieldGroupStateEventDtoConverter() {
        return new AttributeSetInstanceExtensionFieldGroupStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new AttributeSetInstanceExtensionFieldGroupPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class AttributeSetInstanceExtensionFieldGroupPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return AttributeSetInstanceExtensionFieldGroupResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class AttributeSetInstanceExtensionFieldGroupResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, AttributeSetInstanceExtensionFieldGroupCommand value) {
            String idObj = id;
            if (value.getId() == null) {
                value.setId(idObj);
            } else if (!value.getId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getId());
            }
        }
    


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (AttributeSetInstanceExtensionFieldGroupMetadata.aliasMap.containsKey(fieldName)) {
                return AttributeSetInstanceExtensionFieldGroupMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (AttributeSetInstanceExtensionFieldGroupMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = AttributeSetInstanceExtensionFieldGroupMetadata.propertyTypeMap.get(propertyName);
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

        public static AttributeSetInstanceExtensionFieldGroupStateDto[] toAttributeSetInstanceExtensionFieldGroupStateDtoArray(Iterable<String> ids) {
            List<AttributeSetInstanceExtensionFieldGroupStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                AttributeSetInstanceExtensionFieldGroupStateDto dto = new AttributeSetInstanceExtensionFieldGroupStateDto();
                dto.setId(id);
                states.add(dto);
            });
            return states.toArray(new AttributeSetInstanceExtensionFieldGroupStateDto[0]);
        }

    }

}

