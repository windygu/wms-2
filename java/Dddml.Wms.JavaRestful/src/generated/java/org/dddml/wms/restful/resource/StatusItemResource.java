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
import org.dddml.wms.domain.statusitem.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("StatusItems") @Produces(MediaType.APPLICATION_JSON)
public class StatusItemResource {


    @Autowired
    private StatusItemApplicationService statusItemApplicationService;


    @GET
    public StatusItemStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<StatusItemState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = statusItemApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (StatusItemMetadata.aliasMap.containsKey(n) ? StatusItemMetadata.aliasMap.get(n) : n)),
                        StatusItemResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = statusItemApplicationService.get(
                        StatusItemResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        StatusItemResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            StatusItemStateDto.DtoConverter dtoConverter = new StatusItemStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toStatusItemStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public StatusItemStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            String idObj = id;
            StatusItemState state = statusItemApplicationService.get(idObj);
            if (state == null) { return null; }

            StatusItemStateDto.DtoConverter dtoConverter = new StatusItemStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toStatusItemStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = statusItemApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (StatusItemMetadata.aliasMap.containsKey(n) ? StatusItemMetadata.aliasMap.get(n) : n)));
            } else {
                count = statusItemApplicationService.getCount(StatusItemResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @POST
    public String post(CreateOrMergePatchStatusItemDto.CreateStatusItemDto value, @Context HttpServletResponse response) {
        try {
            StatusItemCommand.CreateStatusItem cmd = value.toCreateStatusItem();
            if (cmd.getStatusId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "StatusItem");
            }

            response.setStatus(Response.Status.CREATED.getStatusCode());
            return cmd.getStatusId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchStatusItemDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                StatusItemCommand.MergePatchStatusItem cmd = (StatusItemCommand.MergePatchStatusItem) value.toCommand();
                StatusItemResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                statusItemApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            StatusItemCommand.CreateStatusItem cmd = (StatusItemCommand.CreateStatusItem) value.toCommand();
            StatusItemResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            statusItemApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchStatusItemDto.MergePatchStatusItemDto value) {
        try {

            StatusItemCommand.MergePatchStatusItem cmd = value.toMergePatchStatusItem();
            StatusItemResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            statusItemApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            StatusItemMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  StatusItemStateEventDtoConverter getStatusItemStateEventDtoConverter() {
        return new StatusItemStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new StatusItemPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class StatusItemPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return StatusItemResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class StatusItemResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, StatusItemCommand value) {
            String idObj = id;
            if (value.getStatusId() == null) {
                value.setStatusId(idObj);
            } else if (!value.getStatusId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getStatusId());
            }
        }
    


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (StatusItemMetadata.aliasMap.containsKey(fieldName)) {
                return StatusItemMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (StatusItemMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = StatusItemMetadata.propertyTypeMap.get(propertyName);
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

        public static StatusItemStateDto[] toStatusItemStateDtoArray(Iterable<String> ids) {
            List<StatusItemStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                StatusItemStateDto dto = new StatusItemStateDto();
                dto.setStatusId(id);
                states.add(dto);
            });
            return states.toArray(new StatusItemStateDto[0]);
        }

    }

}

