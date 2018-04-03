package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.apache.cxf.jaxrs.ext.PATCH;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.picklist.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.picklistrolemvo.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("PicklistRoleMvos") @Produces(MediaType.APPLICATION_JSON)
public class PicklistRoleMvoResource {


    @Autowired
    private PicklistRoleMvoApplicationService picklistRoleMvoApplicationService;


    @GET
    public PicklistRoleMvoStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<PicklistRoleMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = picklistRoleMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (PicklistRoleMvoMetadata.aliasMap.containsKey(n) ? PicklistRoleMvoMetadata.aliasMap.get(n) : n)),
                        PicklistRoleMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = picklistRoleMvoApplicationService.get(
                        PicklistRoleMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        PicklistRoleMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            PicklistRoleMvoStateDto.DtoConverter dtoConverter = new PicklistRoleMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPicklistRoleMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public PicklistRoleMvoStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            PicklistRoleId idObj = PicklistRoleMvoResourceUtils.parseIdString(id);
            PicklistRoleMvoState state = picklistRoleMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            PicklistRoleMvoStateDto.DtoConverter dtoConverter = new PicklistRoleMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPicklistRoleMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = picklistRoleMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (PicklistRoleMvoMetadata.aliasMap.containsKey(n) ? PicklistRoleMvoMetadata.aliasMap.get(n) : n)));
            } else {
                count = picklistRoleMvoApplicationService.getCount(PicklistRoleMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchPicklistRoleMvoDto.CreatePicklistRoleMvoDto value) {
        try {

            PicklistRoleMvoCommand.CreatePicklistRoleMvo cmd = value.toCreatePicklistRoleMvo();
            PicklistRoleMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            picklistRoleMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchPicklistRoleMvoDto.MergePatchPicklistRoleMvoDto value) {
        try {

            PicklistRoleMvoCommand.MergePatchPicklistRoleMvo cmd = value.toMergePatchPicklistRoleMvo();
            PicklistRoleMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            picklistRoleMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @DELETE
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            PicklistRoleMvoCommand.DeletePicklistRoleMvo deleteCmd = new AbstractPicklistRoleMvoCommand.SimpleDeletePicklistRoleMvo();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setPicklistVersion(version);
            PicklistRoleMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            picklistRoleMvoApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            PicklistRoleMvoMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public PicklistRoleMvoStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            PicklistRoleId idObj = PicklistRoleMvoResourceUtils.parseIdString(id);
            PicklistRoleMvoStateEventDtoConverter dtoConverter = getPicklistRoleMvoStateEventDtoConverter();
            return dtoConverter.toPicklistRoleMvoStateEventDto((AbstractPicklistRoleMvoStateEvent) picklistRoleMvoApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public PicklistRoleMvoStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            PicklistRoleId idObj = PicklistRoleMvoResourceUtils.parseIdString(id);
            PicklistRoleMvoStateDto.DtoConverter dtoConverter = new PicklistRoleMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPicklistRoleMvoStateDto(picklistRoleMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  PicklistRoleMvoStateEventDtoConverter getPicklistRoleMvoStateEventDtoConverter() {
        return new PicklistRoleMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PicklistRoleMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class PicklistRoleMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return PicklistRoleMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class PicklistRoleMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, PicklistRoleMvoCommand value) {
            PicklistRoleId idObj = parseIdString(id);
            if (value.getPicklistRoleId() == null) {
                value.setPicklistRoleId(idObj);
            } else if (!value.getPicklistRoleId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getPicklistRoleId());
            }
        }
    

        public static PicklistRoleId parseIdString(String idString) {
            TextFormatter<PicklistRoleId> formatter =
                    new AbstractValueObjectTextFormatter<PicklistRoleId>(PicklistRoleId.class) {
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
            if (PicklistRoleMvoMetadata.aliasMap.containsKey(fieldName)) {
                return PicklistRoleMvoMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (PicklistRoleMvoMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = PicklistRoleMvoMetadata.propertyTypeMap.get(propertyName);
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

        public static PicklistRoleMvoStateDto[] toPicklistRoleMvoStateDtoArray(Iterable<PicklistRoleId> ids) {
            List<PicklistRoleMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                PicklistRoleMvoStateDto dto = new PicklistRoleMvoStateDto();
                dto.setPicklistRoleId(id);
                states.add(dto);
            });
            return states.toArray(new PicklistRoleMvoStateDto[0]);
        }

    }

}

