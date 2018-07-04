package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.shipmentmethodtype.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "ShipmentMethodTypes", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ShipmentMethodTypeResource {


    @Autowired
    private ShipmentMethodTypeApplicationService shipmentMethodTypeApplicationService;


    @GetMapping
    public ShipmentMethodTypeStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<ShipmentMethodTypeState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = shipmentMethodTypeApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (ShipmentMethodTypeMetadata.aliasMap.containsKey(n) ? ShipmentMethodTypeMetadata.aliasMap.get(n) : n)),
                        ShipmentMethodTypeResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = shipmentMethodTypeApplicationService.get(
                        ShipmentMethodTypeResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        ShipmentMethodTypeResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            ShipmentMethodTypeStateDto.DtoConverter dtoConverter = new ShipmentMethodTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentMethodTypeStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public ShipmentMethodTypeStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = id;
            ShipmentMethodTypeState state = shipmentMethodTypeApplicationService.get(idObj);
            if (state == null) { return null; }

            ShipmentMethodTypeStateDto.DtoConverter dtoConverter = new ShipmentMethodTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentMethodTypeStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = shipmentMethodTypeApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (ShipmentMethodTypeMetadata.aliasMap.containsKey(n) ? ShipmentMethodTypeMetadata.aliasMap.get(n) : n)));
            } else {
                count = shipmentMethodTypeApplicationService.getCount(ShipmentMethodTypeResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public String post(@RequestBody CreateOrMergePatchShipmentMethodTypeDto.CreateShipmentMethodTypeDto value,  HttpServletResponse response) {
        try {
            ShipmentMethodTypeCommand.CreateShipmentMethodType cmd = value.toCreateShipmentMethodType();
            if (cmd.getShipmentMethodTypeId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "ShipmentMethodType");
            }
            shipmentMethodTypeApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getShipmentMethodTypeId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchShipmentMethodTypeDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                ShipmentMethodTypeCommand.MergePatchShipmentMethodType cmd = (ShipmentMethodTypeCommand.MergePatchShipmentMethodType) value.toCommand();
                ShipmentMethodTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                shipmentMethodTypeApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            ShipmentMethodTypeCommand.CreateShipmentMethodType cmd = (ShipmentMethodTypeCommand.CreateShipmentMethodType) value.toCommand();
            ShipmentMethodTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            shipmentMethodTypeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchShipmentMethodTypeDto.MergePatchShipmentMethodTypeDto value) {
        try {

            ShipmentMethodTypeCommand.MergePatchShipmentMethodType cmd = value.toMergePatchShipmentMethodType();
            ShipmentMethodTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            shipmentMethodTypeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            ShipmentMethodTypeCommand.DeleteShipmentMethodType deleteCmd = new AbstractShipmentMethodTypeCommand.SimpleDeleteShipmentMethodType();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            ShipmentMethodTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            shipmentMethodTypeApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            ShipmentMethodTypeMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_stateEvents/{version}")
    public ShipmentMethodTypeStateEventDto getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            String idObj = id;
            ShipmentMethodTypeStateEventDtoConverter dtoConverter = getShipmentMethodTypeStateEventDtoConverter();
            return dtoConverter.toShipmentMethodTypeStateEventDto((AbstractShipmentMethodTypeEvent) shipmentMethodTypeApplicationService.getEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public ShipmentMethodTypeStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = id;
            ShipmentMethodTypeStateDto.DtoConverter dtoConverter = new ShipmentMethodTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentMethodTypeStateDto(shipmentMethodTypeApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  ShipmentMethodTypeStateEventDtoConverter getShipmentMethodTypeStateEventDtoConverter() {
        return new ShipmentMethodTypeStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new ShipmentMethodTypePropertyTypeResolver();
    }

    // ////////////////////////////////

    private class ShipmentMethodTypePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return ShipmentMethodTypeResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class ShipmentMethodTypeResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, ShipmentMethodTypeCommand value) {
            String idObj = id;
            if (value.getShipmentMethodTypeId() == null) {
                value.setShipmentMethodTypeId(idObj);
            } else if (!value.getShipmentMethodTypeId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getShipmentMethodTypeId());
            }
        }
    


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (ShipmentMethodTypeMetadata.aliasMap.containsKey(fieldName)) {
                return ShipmentMethodTypeMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (ShipmentMethodTypeMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = ShipmentMethodTypeMetadata.propertyTypeMap.get(propertyName);
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

        public static ShipmentMethodTypeStateDto[] toShipmentMethodTypeStateDtoArray(Iterable<String> ids) {
            List<ShipmentMethodTypeStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                ShipmentMethodTypeStateDto dto = new ShipmentMethodTypeStateDto();
                dto.setShipmentMethodTypeId(id);
                states.add(dto);
            });
            return states.toArray(new ShipmentMethodTypeStateDto[0]);
        }

    }

}

