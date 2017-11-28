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
import org.dddml.wms.domain.inventoryitemeventtype.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("InventoryItemEventTypes") @Produces(MediaType.APPLICATION_JSON)
public class InventoryItemEventTypeResource {


    @Autowired
    private InventoryItemEventTypeApplicationService inventoryItemEventTypeApplicationService;


    @GET
    public InventoryItemEventTypeStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<InventoryItemEventTypeState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = inventoryItemEventTypeApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (InventoryItemEventTypeFilteringProperties.aliasMap.containsKey(n) ? InventoryItemEventTypeFilteringProperties.aliasMap.get(n) : n)),
                        InventoryItemEventTypeResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = inventoryItemEventTypeApplicationService.get(
                        InventoryItemEventTypeResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        InventoryItemEventTypeResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            InventoryItemEventTypeStateDto.DtoConverter dtoConverter = new InventoryItemEventTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryItemEventTypeStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public InventoryItemEventTypeStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            String idObj = id;
            InventoryItemEventTypeState state = inventoryItemEventTypeApplicationService.get(idObj);
            if (state == null) { return null; }

            InventoryItemEventTypeStateDto.DtoConverter dtoConverter = new InventoryItemEventTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryItemEventTypeStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = inventoryItemEventTypeApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (InventoryItemEventTypeFilteringProperties.aliasMap.containsKey(n) ? InventoryItemEventTypeFilteringProperties.aliasMap.get(n) : n)));
            } else {
                count = inventoryItemEventTypeApplicationService.getCount(InventoryItemEventTypeResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchInventoryItemEventTypeDto.CreateInventoryItemEventTypeDto value) {
        try {

            InventoryItemEventTypeCommand.CreateInventoryItemEventType cmd = value.toCreateInventoryItemEventType();
            InventoryItemEventTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            inventoryItemEventTypeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchInventoryItemEventTypeDto.MergePatchInventoryItemEventTypeDto value) {
        try {

            InventoryItemEventTypeCommand.MergePatchInventoryItemEventType cmd = value.toMergePatchInventoryItemEventType();
            InventoryItemEventTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            inventoryItemEventTypeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @DELETE
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            InventoryItemEventTypeCommand.DeleteInventoryItemEventType deleteCmd = new AbstractInventoryItemEventTypeCommand.SimpleDeleteInventoryItemEventType();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            InventoryItemEventTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            inventoryItemEventTypeApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            InventoryItemEventTypeFilteringProperties.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public InventoryItemEventTypeStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            String idObj = id;
            InventoryItemEventTypeStateEventDtoConverter dtoConverter = getInventoryItemEventTypeStateEventDtoConverter();
            return dtoConverter.toInventoryItemEventTypeStateEventDto((AbstractInventoryItemEventTypeStateEvent) inventoryItemEventTypeApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public InventoryItemEventTypeStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            String idObj = id;
            InventoryItemEventTypeStateDto.DtoConverter dtoConverter = new InventoryItemEventTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryItemEventTypeStateDto(inventoryItemEventTypeApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  InventoryItemEventTypeStateEventDtoConverter getInventoryItemEventTypeStateEventDtoConverter() {
        return new InventoryItemEventTypeStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new InventoryItemEventTypePropertyTypeResolver();
    }

    // ////////////////////////////////

    private class InventoryItemEventTypePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return InventoryItemEventTypeResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class InventoryItemEventTypeResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, InventoryItemEventTypeCommand value) {
            String idObj = id;
            if (value.getInventoryItemEventTypeId() == null) {
                value.setInventoryItemEventTypeId(idObj);
            } else if (!value.getInventoryItemEventTypeId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getInventoryItemEventTypeId());
            }
        }
    


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (InventoryItemEventTypeFilteringProperties.aliasMap.containsKey(fieldName)) {
                return InventoryItemEventTypeFilteringProperties.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (InventoryItemEventTypeFilteringProperties.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = InventoryItemEventTypeFilteringProperties.propertyTypeMap.get(propertyName);
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

        public static InventoryItemEventTypeStateDto[] toInventoryItemEventTypeStateDtoArray(Iterable<String> ids) {
            List<InventoryItemEventTypeStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                InventoryItemEventTypeStateDto dto = new InventoryItemEventTypeStateDto();
                dto.setInventoryItemEventTypeId(id);
                states.add(dto);
            });
            return states.toArray(new InventoryItemEventTypeStateDto[0]);
        }

    }

}

