package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.shipmentitemmvo.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "ShipmentItemMvos", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ShipmentItemMvoResource {


    @Autowired
    private ShipmentItemMvoApplicationService shipmentItemMvoApplicationService;


    @GetMapping
    public ShipmentItemMvoStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<ShipmentItemMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = shipmentItemMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (ShipmentItemMvoMetadata.aliasMap.containsKey(n) ? ShipmentItemMvoMetadata.aliasMap.get(n) : n)),
                        ShipmentItemMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = shipmentItemMvoApplicationService.get(
                        ShipmentItemMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        ShipmentItemMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            ShipmentItemMvoStateDto.DtoConverter dtoConverter = new ShipmentItemMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentItemMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public ShipmentItemMvoStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            ShipmentItemId idObj = ShipmentItemMvoResourceUtils.parseIdString(id);
            ShipmentItemMvoState state = shipmentItemMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            ShipmentItemMvoStateDto.DtoConverter dtoConverter = new ShipmentItemMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentItemMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = shipmentItemMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (ShipmentItemMvoMetadata.aliasMap.containsKey(n) ? ShipmentItemMvoMetadata.aliasMap.get(n) : n)));
            } else {
                count = shipmentItemMvoApplicationService.getCount(ShipmentItemMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public ShipmentItemId post(@RequestBody CreateOrMergePatchShipmentItemMvoDto.CreateShipmentItemMvoDto value,  HttpServletResponse response) {
        try {
            ShipmentItemMvoCommand.CreateShipmentItemMvo cmd = value.toCreateShipmentItemMvo();
            if (cmd.getShipmentItemId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "ShipmentItemMvo");
            }
            shipmentItemMvoApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getShipmentItemId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchShipmentItemMvoDto value) {
        try {
            if (value.getShipmentVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                ShipmentItemMvoCommand.MergePatchShipmentItemMvo cmd = (ShipmentItemMvoCommand.MergePatchShipmentItemMvo) value.toCommand();
                ShipmentItemMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                shipmentItemMvoApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            ShipmentItemMvoCommand.CreateShipmentItemMvo cmd = (ShipmentItemMvoCommand.CreateShipmentItemMvo) value.toCommand();
            ShipmentItemMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            shipmentItemMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchShipmentItemMvoDto.MergePatchShipmentItemMvoDto value) {
        try {

            ShipmentItemMvoCommand.MergePatchShipmentItemMvo cmd = value.toMergePatchShipmentItemMvo();
            ShipmentItemMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            shipmentItemMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            ShipmentItemMvoMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_stateEvents/{version}")
    public ShipmentItemMvoStateEventDto getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            ShipmentItemId idObj = ShipmentItemMvoResourceUtils.parseIdString(id);
            ShipmentItemMvoStateEventDtoConverter dtoConverter = getShipmentItemMvoStateEventDtoConverter();
            return dtoConverter.toShipmentItemMvoStateEventDto((AbstractShipmentItemMvoEvent) shipmentItemMvoApplicationService.getEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public ShipmentItemMvoStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            ShipmentItemId idObj = ShipmentItemMvoResourceUtils.parseIdString(id);
            ShipmentItemMvoStateDto.DtoConverter dtoConverter = new ShipmentItemMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentItemMvoStateDto(shipmentItemMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  ShipmentItemMvoStateEventDtoConverter getShipmentItemMvoStateEventDtoConverter() {
        return new ShipmentItemMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new ShipmentItemMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class ShipmentItemMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return ShipmentItemMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class ShipmentItemMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, ShipmentItemMvoCommand value) {
            ShipmentItemId idObj = parseIdString(id);
            if (value.getShipmentItemId() == null) {
                value.setShipmentItemId(idObj);
            } else if (!value.getShipmentItemId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getShipmentItemId());
            }
        }
    

        public static ShipmentItemId parseIdString(String idString) {
            TextFormatter<ShipmentItemId> formatter =
                    new AbstractValueObjectTextFormatter<ShipmentItemId>(ShipmentItemId.class) {
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
            if (ShipmentItemMvoMetadata.aliasMap.containsKey(fieldName)) {
                return ShipmentItemMvoMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (ShipmentItemMvoMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = ShipmentItemMvoMetadata.propertyTypeMap.get(propertyName);
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

        public static ShipmentItemMvoStateDto[] toShipmentItemMvoStateDtoArray(Iterable<ShipmentItemId> ids) {
            List<ShipmentItemMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                ShipmentItemMvoStateDto dto = new ShipmentItemMvoStateDto();
                dto.setShipmentItemId(id);
                states.add(dto);
            });
            return states.toArray(new ShipmentItemMvoStateDto[0]);
        }

    }

}

