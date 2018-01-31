package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.apache.cxf.jaxrs.ext.PATCH;

import org.dddml.support.criterion.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("InventoryItems") @Produces(MediaType.APPLICATION_JSON)
public class InventoryItemResource {


    @Autowired
    private InventoryItemApplicationService inventoryItemApplicationService;


    @GET
    public InventoryItemStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<InventoryItemState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = inventoryItemApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (InventoryItemFilteringProperties.aliasMap.containsKey(n) ? InventoryItemFilteringProperties.aliasMap.get(n) : n)),
                        InventoryItemResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = inventoryItemApplicationService.get(
                        InventoryItemResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        InventoryItemResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            InventoryItemStateDto.DtoConverter dtoConverter = new InventoryItemStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryItemStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public InventoryItemStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            InventoryItemId idObj = InventoryItemResourceUtils.parseIdString(id);
            InventoryItemState state = inventoryItemApplicationService.get(idObj);
            if (state == null) { return null; }

            InventoryItemStateDto.DtoConverter dtoConverter = new InventoryItemStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryItemStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = inventoryItemApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (InventoryItemFilteringProperties.aliasMap.containsKey(n) ? InventoryItemFilteringProperties.aliasMap.get(n) : n)));
            } else {
                count = inventoryItemApplicationService.getCount(InventoryItemResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            InventoryItemFilteringProperties.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public InventoryItemStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            InventoryItemId idObj = InventoryItemResourceUtils.parseIdString(id);
            InventoryItemStateEventDtoConverter dtoConverter = getInventoryItemStateEventDtoConverter();
            return dtoConverter.toInventoryItemStateEventDto((AbstractInventoryItemStateEvent) inventoryItemApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public InventoryItemStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            InventoryItemId idObj = InventoryItemResourceUtils.parseIdString(id);
            InventoryItemStateDto.DtoConverter dtoConverter = new InventoryItemStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryItemStateDto(inventoryItemApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{inventoryItemId}/InventoryItemEntries/{entrySeqId}") @GET
    public InventoryItemEntryStateDto getInventoryItemEntry(@PathParam("inventoryItemId") String inventoryItemId, @PathParam("entrySeqId") Long entrySeqId) {
        try {

            InventoryItemEntryState state = inventoryItemApplicationService.getInventoryItemEntry((new InventoryItemIdFlattenedDtoFormatter().parse(inventoryItemId)).toInventoryItemId(), entrySeqId);
            if (state == null) { return null; }
            InventoryItemEntryStateDto.DtoConverter dtoConverter = new InventoryItemEntryStateDto.DtoConverter();
            InventoryItemEntryStateDto stateDto = dtoConverter.toInventoryItemEntryStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  InventoryItemStateEventDtoConverter getInventoryItemStateEventDtoConverter() {
        return new InventoryItemStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new InventoryItemPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class InventoryItemPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return InventoryItemResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class InventoryItemResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, InventoryItemCommand value) {
            InventoryItemId idObj = parseIdString(id);
            if (value.getInventoryItemId() == null) {
                value.setInventoryItemId(idObj);
            } else if (!value.getInventoryItemId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getInventoryItemId());
            }
        }
    

        public static InventoryItemId parseIdString(String idString) {
            InventoryItemIdFlattenedDtoFormatter formatter = new InventoryItemIdFlattenedDtoFormatter();
            InventoryItemIdFlattenedDto idDto = formatter.parse(idString);
            return idDto.toInventoryItemId();
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (InventoryItemFilteringProperties.aliasMap.containsKey(fieldName)) {
                return InventoryItemFilteringProperties.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (InventoryItemFilteringProperties.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = InventoryItemFilteringProperties.propertyTypeMap.get(propertyName);
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

        public static InventoryItemStateDto[] toInventoryItemStateDtoArray(Iterable<InventoryItemId> ids) {
            List<InventoryItemStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                InventoryItemStateDto dto = new InventoryItemStateDto();
                dto.setInventoryItemId(new InventoryItemIdDtoWrapper(id));
                states.add(dto);
            });
            return states.toArray(new InventoryItemStateDto[0]);
        }

    }

}

