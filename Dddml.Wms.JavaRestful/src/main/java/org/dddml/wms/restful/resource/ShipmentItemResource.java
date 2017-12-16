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
import org.dddml.wms.domain.shipmentitem.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("ShipmentItems") @Produces(MediaType.APPLICATION_JSON)
public class ShipmentItemResource {


    @Autowired
    private ShipmentItemApplicationService shipmentItemApplicationService;


    @GET
    public ShipmentItemStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<ShipmentItemState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = shipmentItemApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (ShipmentItemFilteringProperties.aliasMap.containsKey(n) ? ShipmentItemFilteringProperties.aliasMap.get(n) : n)),
                        ShipmentItemResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = shipmentItemApplicationService.get(
                        ShipmentItemResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        ShipmentItemResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            ShipmentItemStateDto.DtoConverter dtoConverter = new ShipmentItemStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentItemStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public ShipmentItemStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            ShipmentItemId idObj = ShipmentItemResourceUtils.parseIdString(id);
            ShipmentItemState state = shipmentItemApplicationService.get(idObj);
            if (state == null) { return null; }

            ShipmentItemStateDto.DtoConverter dtoConverter = new ShipmentItemStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentItemStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = shipmentItemApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (ShipmentItemFilteringProperties.aliasMap.containsKey(n) ? ShipmentItemFilteringProperties.aliasMap.get(n) : n)));
            } else {
                count = shipmentItemApplicationService.getCount(ShipmentItemResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchShipmentItemDto.CreateShipmentItemDto value) {
        try {

            ShipmentItemCommand.CreateShipmentItem cmd = value.toCreateShipmentItem();
            ShipmentItemResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            shipmentItemApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchShipmentItemDto.MergePatchShipmentItemDto value) {
        try {

            ShipmentItemCommand.MergePatchShipmentItem cmd = value.toMergePatchShipmentItem();
            ShipmentItemResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            shipmentItemApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            ShipmentItemFilteringProperties.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public ShipmentItemStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            ShipmentItemId idObj = ShipmentItemResourceUtils.parseIdString(id);
            ShipmentItemStateEventDtoConverter dtoConverter = getShipmentItemStateEventDtoConverter();
            return dtoConverter.toShipmentItemStateEventDto((AbstractShipmentItemStateEvent) shipmentItemApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public ShipmentItemStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            ShipmentItemId idObj = ShipmentItemResourceUtils.parseIdString(id);
            ShipmentItemStateDto.DtoConverter dtoConverter = new ShipmentItemStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentItemStateDto(shipmentItemApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  ShipmentItemStateEventDtoConverter getShipmentItemStateEventDtoConverter() {
        return new ShipmentItemStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new ShipmentItemPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class ShipmentItemPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return ShipmentItemResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class ShipmentItemResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, ShipmentItemCommand value) {
            ShipmentItemId idObj = parseIdString(id);
            if (value.getShipmentItemId() == null) {
                value.setShipmentItemId(idObj);
            } else if (!value.getShipmentItemId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getShipmentItemId());
            }
        }
    

        public static ShipmentItemId parseIdString(String idString) {
            ShipmentItemIdFlattenedDtoFormatter formatter = new ShipmentItemIdFlattenedDtoFormatter();
            ShipmentItemIdFlattenedDto idDto = formatter.parse(idString);
            return idDto.toShipmentItemId();
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (ShipmentItemFilteringProperties.aliasMap.containsKey(fieldName)) {
                return ShipmentItemFilteringProperties.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (ShipmentItemFilteringProperties.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = ShipmentItemFilteringProperties.propertyTypeMap.get(propertyName);
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

        public static ShipmentItemStateDto[] toShipmentItemStateDtoArray(Iterable<ShipmentItemId> ids) {
            List<ShipmentItemStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                ShipmentItemStateDto dto = new ShipmentItemStateDto();
                dto.setShipmentItemId(new ShipmentItemIdDtoWrapper(id));
                states.add(dto);
            });
            return states.toArray(new ShipmentItemStateDto[0]);
        }

    }

}

