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

@Path("UserRoleMvos")
@Produces(MediaType.APPLICATION_JSON)
public class UserRoleMvoResource {


    @Autowired
    private UserRoleMvoApplicationService userRoleMvoApplicationService;


    @GET
    public UserRoleMvoStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<UserRoleMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = userRoleMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver()),
                        UserRoleMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = userRoleMvoApplicationService.get(
                        UserRoleMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        UserRoleMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            UserRoleMvoStateDto.DtoConverter dtoConverter = new UserRoleMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toUserRoleMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GET
    @Path("{id}")
    public UserRoleMvoStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            UserRoleId idObj = UserRoleMvoResourceUtils.parseIdString(id);
            UserRoleMvoState state = userRoleMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            UserRoleMvoStateDto.DtoConverter dtoConverter = new UserRoleMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toUserRoleMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count")
    @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = userRoleMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver()));
            } else {
                count = userRoleMvoApplicationService.getCount(UserRoleMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PUT
    @Path("/{id}")
    public void put(@PathParam("id") String id, CreateOrMergePatchUserRoleMvoDto.CreateUserRoleMvoDto value) {
        try {

            UserRoleMvoCommand.CreateUserRoleMvo cmd = value.toCreateUserRoleMvo();
            UserRoleMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            userRoleMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PATCH
    @Path("/{id}")
    public void patch(@PathParam("id") String id, CreateOrMergePatchUserRoleMvoDto.MergePatchUserRoleMvoDto value) {
        try {

            UserRoleMvoCommand.MergePatchUserRoleMvo cmd = value.toMergePatchUserRoleMvo();
            UserRoleMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            userRoleMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            UserRoleMvoCommand.DeleteUserRoleMvo deleteCmd = new AbstractUserRoleMvoCommand.SimpleDeleteUserRoleMvo();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setUserVersion(version);
            UserRoleMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            userRoleMvoApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields")
    @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            UserRoleMvoFilteringProperties.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}")
    @GET
    public UserRoleMvoStateEvent getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            UserRoleId idObj = UserRoleMvoResourceUtils.parseIdString(id);
            return userRoleMvoApplicationService.getStateEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new UserRoleMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class UserRoleMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return UserRoleMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class UserRoleMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, UserRoleMvoCommand value) {
            UserRoleId idObj = parseIdString(id);
            if (value.getUserRoleId() == null) {
                value.setUserRoleId(idObj);
            } else if (!value.getUserRoleId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getUserRoleId());
            }
        }
    

        public static UserRoleId parseIdString(String idString) {
            UserRoleIdFlattenedDtoFormatter formatter = new UserRoleIdFlattenedDtoFormatter();
            UserRoleIdFlattenedDto idDto = formatter.parse(idString);
            return idDto.toUserRoleId();
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (UserRoleMvoFilteringProperties.propertyTypeMap.containsKey(fieldName)) {
/* TODO...
                var p = UserRoleMvoMetadata.Instance.PropertyMetadataDictionary[fieldName];
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
            if (UserRoleMvoFilteringProperties.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = UserRoleMvoFilteringProperties.propertyTypeMap.get(propertyName);
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

        public static UserRoleMvoStateDto[] toUserRoleMvoStateDtoArray(Iterable<UserRoleId> ids) {
            List<UserRoleMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                UserRoleMvoStateDto dto = new UserRoleMvoStateDto();
                dto.setUserRoleId(new UserRoleIdDto(id));
                states.add(dto);
            });
            return states.toArray(new UserRoleMvoStateDto[0]);
        }

    }

}

