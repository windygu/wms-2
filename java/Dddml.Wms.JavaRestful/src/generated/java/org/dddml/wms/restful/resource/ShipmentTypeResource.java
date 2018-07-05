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
import org.dddml.wms.domain.shipmenttype.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "ShipmentTypes", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ShipmentTypeResource {


    @Autowired
    private ShipmentTypeApplicationService shipmentTypeApplicationService;


    @GetMapping
    public ShipmentTypeStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<ShipmentTypeState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = shipmentTypeApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (ShipmentTypeMetadata.aliasMap.containsKey(n) ? ShipmentTypeMetadata.aliasMap.get(n) : n)),
                        ShipmentTypeResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = shipmentTypeApplicationService.get(
                        ShipmentTypeResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        ShipmentTypeResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            ShipmentTypeStateDto.DtoConverter dtoConverter = new ShipmentTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentTypeStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public ShipmentTypeStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = id;
            ShipmentTypeState state = shipmentTypeApplicationService.get(idObj);
            if (state == null) { return null; }

            ShipmentTypeStateDto.DtoConverter dtoConverter = new ShipmentTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentTypeStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = shipmentTypeApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (ShipmentTypeMetadata.aliasMap.containsKey(n) ? ShipmentTypeMetadata.aliasMap.get(n) : n)));
            } else {
                count = shipmentTypeApplicationService.getCount(ShipmentTypeResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public String post(@RequestBody CreateOrMergePatchShipmentTypeDto.CreateShipmentTypeDto value,  HttpServletResponse response) {
        try {
            ShipmentTypeCommand.CreateShipmentType cmd = value.toCreateShipmentType();
            if (cmd.getShipmentTypeId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "ShipmentType");
            }
            shipmentTypeApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getShipmentTypeId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchShipmentTypeDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                ShipmentTypeCommand.MergePatchShipmentType cmd = (ShipmentTypeCommand.MergePatchShipmentType) value.toCommand();
                ShipmentTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                shipmentTypeApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            ShipmentTypeCommand.CreateShipmentType cmd = (ShipmentTypeCommand.CreateShipmentType) value.toCommand();
            ShipmentTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            shipmentTypeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchShipmentTypeDto.MergePatchShipmentTypeDto value) {
        try {

            ShipmentTypeCommand.MergePatchShipmentType cmd = value.toMergePatchShipmentType();
            ShipmentTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            shipmentTypeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            ShipmentTypeMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new ShipmentTypePropertyTypeResolver();
    }

    // ////////////////////////////////

    private class ShipmentTypePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return ShipmentTypeResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class ShipmentTypeResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, ShipmentTypeCommand value) {
            String idObj = id;
            if (value.getShipmentTypeId() == null) {
                value.setShipmentTypeId(idObj);
            } else if (!value.getShipmentTypeId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getShipmentTypeId());
            }
        }
    


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (ShipmentTypeMetadata.aliasMap.containsKey(fieldName)) {
                return ShipmentTypeMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (ShipmentTypeMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = ShipmentTypeMetadata.propertyTypeMap.get(propertyName);
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

        public static ShipmentTypeStateDto[] toShipmentTypeStateDtoArray(Iterable<String> ids) {
            List<ShipmentTypeStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                ShipmentTypeStateDto dto = new ShipmentTypeStateDto();
                dto.setShipmentTypeId(id);
                states.add(dto);
            });
            return states.toArray(new ShipmentTypeStateDto[0]);
        }

    }

}

