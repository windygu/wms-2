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
import org.dddml.wms.domain.damagereason.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("DamageReasons") @Produces(MediaType.APPLICATION_JSON)
public class DamageReasonResource {


    @Autowired
    private DamageReasonApplicationService damageReasonApplicationService;


    @GET
    public DamageReasonStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<DamageReasonState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = damageReasonApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (DamageReasonMetadata.aliasMap.containsKey(n) ? DamageReasonMetadata.aliasMap.get(n) : n)),
                        DamageReasonResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = damageReasonApplicationService.get(
                        DamageReasonResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        DamageReasonResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            DamageReasonStateDto.DtoConverter dtoConverter = new DamageReasonStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toDamageReasonStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public DamageReasonStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            String idObj = id;
            DamageReasonState state = damageReasonApplicationService.get(idObj);
            if (state == null) { return null; }

            DamageReasonStateDto.DtoConverter dtoConverter = new DamageReasonStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toDamageReasonStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = damageReasonApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (DamageReasonMetadata.aliasMap.containsKey(n) ? DamageReasonMetadata.aliasMap.get(n) : n)));
            } else {
                count = damageReasonApplicationService.getCount(DamageReasonResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @POST
    public String post(CreateOrMergePatchDamageReasonDto.CreateDamageReasonDto value, @Context HttpServletResponse response) {
        try {
            DamageReasonCommand.CreateDamageReason cmd = value.toCreateDamageReason();
            if (cmd.getDamageReasonId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "DamageReason");
            }

            response.setStatus(Response.Status.CREATED.getStatusCode());
            return cmd.getDamageReasonId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchDamageReasonDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                DamageReasonCommand.MergePatchDamageReason cmd = (DamageReasonCommand.MergePatchDamageReason) value.toCommand();
                DamageReasonResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                damageReasonApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            DamageReasonCommand.CreateDamageReason cmd = (DamageReasonCommand.CreateDamageReason) value.toCommand();
            DamageReasonResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            damageReasonApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchDamageReasonDto.MergePatchDamageReasonDto value) {
        try {

            DamageReasonCommand.MergePatchDamageReason cmd = value.toMergePatchDamageReason();
            DamageReasonResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            damageReasonApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @DELETE
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            DamageReasonCommand.DeleteDamageReason deleteCmd = new AbstractDamageReasonCommand.SimpleDeleteDamageReason();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            DamageReasonResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            damageReasonApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            DamageReasonMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public DamageReasonStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            String idObj = id;
            DamageReasonStateEventDtoConverter dtoConverter = getDamageReasonStateEventDtoConverter();
            return dtoConverter.toDamageReasonStateEventDto((AbstractDamageReasonStateEvent) damageReasonApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public DamageReasonStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            String idObj = id;
            DamageReasonStateDto.DtoConverter dtoConverter = new DamageReasonStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toDamageReasonStateDto(damageReasonApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  DamageReasonStateEventDtoConverter getDamageReasonStateEventDtoConverter() {
        return new DamageReasonStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new DamageReasonPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class DamageReasonPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return DamageReasonResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class DamageReasonResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, DamageReasonCommand value) {
            String idObj = id;
            if (value.getDamageReasonId() == null) {
                value.setDamageReasonId(idObj);
            } else if (!value.getDamageReasonId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getDamageReasonId());
            }
        }
    


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (DamageReasonMetadata.aliasMap.containsKey(fieldName)) {
                return DamageReasonMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (DamageReasonMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = DamageReasonMetadata.propertyTypeMap.get(propertyName);
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

        public static DamageReasonStateDto[] toDamageReasonStateDtoArray(Iterable<String> ids) {
            List<DamageReasonStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                DamageReasonStateDto dto = new DamageReasonStateDto();
                dto.setDamageReasonId(id);
                states.add(dto);
            });
            return states.toArray(new DamageReasonStateDto[0]);
        }

    }

}

