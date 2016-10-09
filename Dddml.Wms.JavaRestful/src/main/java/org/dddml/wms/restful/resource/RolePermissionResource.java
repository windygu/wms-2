package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.apache.cxf.jaxrs.ext.PATCH;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("RolePermissions")
@Produces(MediaType.APPLICATION_JSON)
public class RolePermissionResource {


    @Autowired
    private RolePermissionApplicationService rolePermissionApplicationService;


    @GET
    public RolePermissionStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<RolePermissionState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = rolePermissionApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver()),
                        RolePermissionResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = rolePermissionApplicationService.get(
                        RolePermissionResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        RolePermissionResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            RolePermissionStateDto.DtoConverter dtoConverter = new RolePermissionStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toRolePermissionStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GET
    @Path("{id}")
    public RolePermissionStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            RolePermissionId idObj = RolePermissionResourceUtils.parseIdString(id);
            RolePermissionState state = rolePermissionApplicationService.get(idObj);
            if (state == null) { return null; }

            RolePermissionStateDto.DtoConverter dtoConverter = new RolePermissionStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toRolePermissionStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count")
    @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = rolePermissionApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver()));
            } else {
                count = rolePermissionApplicationService.getCount(RolePermissionResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PUT
    @Path("/{id}")
    public void put(@PathParam("id") String id, CreateOrMergePatchRolePermissionDto.CreateRolePermissionDto value) {
        try {

            RolePermissionCommand.CreateRolePermission cmd = value.toCreateRolePermission();
            RolePermissionResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            rolePermissionApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PATCH
    @Path("/{id}")
    public void patch(@PathParam("id") String id, CreateOrMergePatchRolePermissionDto.MergePatchRolePermissionDto value) {
        try {

            RolePermissionCommand.MergePatchRolePermission cmd = value.toMergePatchRolePermission();
            RolePermissionResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            rolePermissionApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            RolePermissionCommand.DeleteRolePermission deleteCmd = new AbstractRolePermissionCommand.SimpleDeleteRolePermission();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            RolePermissionResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            rolePermissionApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields")
    @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            RolePermissionFilteringProperties.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}")
    @GET
    public RolePermissionStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            RolePermissionId idObj = RolePermissionResourceUtils.parseIdString(id);
            RolePermissionStateEventDtoConverter dtoConverter = getRolePermissionStateEventDtoConverter();
            return dtoConverter.toRolePermissionStateEventDto((AbstractRolePermissionStateEvent) rolePermissionApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}")
    @GET
    public RolePermissionStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            RolePermissionId idObj = RolePermissionResourceUtils.parseIdString(id);
            RolePermissionStateDto.DtoConverter dtoConverter = new RolePermissionStateDto.DtoConverter();
            return dtoConverter.toRolePermissionStateDto(rolePermissionApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  RolePermissionStateEventDtoConverter getRolePermissionStateEventDtoConverter() {
        return new RolePermissionStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new RolePermissionPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class RolePermissionPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return RolePermissionResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class RolePermissionResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, RolePermissionCommand value) {
            RolePermissionId idObj = parseIdString(id);
            if (value.getId() == null) {
                value.setId(idObj);
            } else if (!value.getId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getId());
            }
        }
    

        public static RolePermissionId parseIdString(String idString) {
            RolePermissionIdFlattenedDtoFormatter formatter = new RolePermissionIdFlattenedDtoFormatter();
            RolePermissionIdFlattenedDto idDto = formatter.parse(idString);
            return idDto.toRolePermissionId();
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (RolePermissionFilteringProperties.propertyTypeMap.containsKey(fieldName)) {
                return fieldName;
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (RolePermissionFilteringProperties.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = RolePermissionFilteringProperties.propertyTypeMap.get(propertyName);
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

        public static RolePermissionStateDto[] toRolePermissionStateDtoArray(Iterable<RolePermissionId> ids) {
            List<RolePermissionStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                RolePermissionStateDto dto = new RolePermissionStateDto();
                dto.setId(new RolePermissionIdDtoWrapper(id));
                states.add(dto);
            });
            return states.toArray(new RolePermissionStateDto[0]);
        }

    }

}

