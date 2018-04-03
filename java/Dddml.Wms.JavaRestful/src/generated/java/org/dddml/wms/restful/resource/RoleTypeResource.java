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
import org.dddml.wms.domain.roletype.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("RoleTypes") @Produces(MediaType.APPLICATION_JSON)
public class RoleTypeResource {


    @Autowired
    private RoleTypeApplicationService roleTypeApplicationService;


    @GET
    public RoleTypeStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<RoleTypeState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = roleTypeApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (RoleTypeMetadata.aliasMap.containsKey(n) ? RoleTypeMetadata.aliasMap.get(n) : n)),
                        RoleTypeResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = roleTypeApplicationService.get(
                        RoleTypeResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        RoleTypeResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            RoleTypeStateDto.DtoConverter dtoConverter = new RoleTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toRoleTypeStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public RoleTypeStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            String idObj = id;
            RoleTypeState state = roleTypeApplicationService.get(idObj);
            if (state == null) { return null; }

            RoleTypeStateDto.DtoConverter dtoConverter = new RoleTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toRoleTypeStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = roleTypeApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (RoleTypeMetadata.aliasMap.containsKey(n) ? RoleTypeMetadata.aliasMap.get(n) : n)));
            } else {
                count = roleTypeApplicationService.getCount(RoleTypeResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @POST
    public String post(CreateOrMergePatchRoleTypeDto.CreateRoleTypeDto value, @Context HttpServletResponse response) {
        try {
            RoleTypeCommand.CreateRoleType cmd = value.toCreateRoleType();
            if (cmd.getRoleTypeId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "RoleType");
            }

            response.setStatus(Response.Status.CREATED.getStatusCode());
            return cmd.getRoleTypeId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchRoleTypeDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                RoleTypeCommand.MergePatchRoleType cmd = (RoleTypeCommand.MergePatchRoleType) value.toCommand();
                RoleTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                roleTypeApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            RoleTypeCommand.CreateRoleType cmd = (RoleTypeCommand.CreateRoleType) value.toCommand();
            RoleTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            roleTypeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchRoleTypeDto.MergePatchRoleTypeDto value) {
        try {

            RoleTypeCommand.MergePatchRoleType cmd = value.toMergePatchRoleType();
            RoleTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            roleTypeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @DELETE
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            RoleTypeCommand.DeleteRoleType deleteCmd = new AbstractRoleTypeCommand.SimpleDeleteRoleType();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            RoleTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            roleTypeApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            RoleTypeMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public RoleTypeStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            String idObj = id;
            RoleTypeStateEventDtoConverter dtoConverter = getRoleTypeStateEventDtoConverter();
            return dtoConverter.toRoleTypeStateEventDto((AbstractRoleTypeStateEvent) roleTypeApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public RoleTypeStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            String idObj = id;
            RoleTypeStateDto.DtoConverter dtoConverter = new RoleTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toRoleTypeStateDto(roleTypeApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  RoleTypeStateEventDtoConverter getRoleTypeStateEventDtoConverter() {
        return new RoleTypeStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new RoleTypePropertyTypeResolver();
    }

    // ////////////////////////////////

    private class RoleTypePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return RoleTypeResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class RoleTypeResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, RoleTypeCommand value) {
            String idObj = id;
            if (value.getRoleTypeId() == null) {
                value.setRoleTypeId(idObj);
            } else if (!value.getRoleTypeId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getRoleTypeId());
            }
        }
    


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (RoleTypeMetadata.aliasMap.containsKey(fieldName)) {
                return RoleTypeMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (RoleTypeMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = RoleTypeMetadata.propertyTypeMap.get(propertyName);
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

        public static RoleTypeStateDto[] toRoleTypeStateDtoArray(Iterable<String> ids) {
            List<RoleTypeStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                RoleTypeStateDto dto = new RoleTypeStateDto();
                dto.setRoleTypeId(id);
                states.add(dto);
            });
            return states.toArray(new RoleTypeStateDto[0]);
        }

    }

}

