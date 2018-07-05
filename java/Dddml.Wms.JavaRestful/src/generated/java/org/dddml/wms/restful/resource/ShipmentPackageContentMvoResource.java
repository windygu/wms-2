package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.shipmentpackage.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.shipmentpackagecontentmvo.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "ShipmentPackageContentMvos", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ShipmentPackageContentMvoResource {


    @Autowired
    private ShipmentPackageContentMvoApplicationService shipmentPackageContentMvoApplicationService;


    @GetMapping
    public ShipmentPackageContentMvoStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<ShipmentPackageContentMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = shipmentPackageContentMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (ShipmentPackageContentMvoMetadata.aliasMap.containsKey(n) ? ShipmentPackageContentMvoMetadata.aliasMap.get(n) : n)),
                        ShipmentPackageContentMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = shipmentPackageContentMvoApplicationService.get(
                        ShipmentPackageContentMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        ShipmentPackageContentMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            ShipmentPackageContentMvoStateDto.DtoConverter dtoConverter = new ShipmentPackageContentMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentPackageContentMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public ShipmentPackageContentMvoStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            ShipmentPackageContentId idObj = ShipmentPackageContentMvoResourceUtils.parseIdString(id);
            ShipmentPackageContentMvoState state = shipmentPackageContentMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            ShipmentPackageContentMvoStateDto.DtoConverter dtoConverter = new ShipmentPackageContentMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentPackageContentMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = shipmentPackageContentMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (ShipmentPackageContentMvoMetadata.aliasMap.containsKey(n) ? ShipmentPackageContentMvoMetadata.aliasMap.get(n) : n)));
            } else {
                count = shipmentPackageContentMvoApplicationService.getCount(ShipmentPackageContentMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public ShipmentPackageContentId post(@RequestBody CreateOrMergePatchShipmentPackageContentMvoDto.CreateShipmentPackageContentMvoDto value,  HttpServletResponse response) {
        try {
            ShipmentPackageContentMvoCommand.CreateShipmentPackageContentMvo cmd = value.toCreateShipmentPackageContentMvo();
            if (cmd.getShipmentPackageContentId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "ShipmentPackageContentMvo");
            }
            shipmentPackageContentMvoApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getShipmentPackageContentId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchShipmentPackageContentMvoDto value) {
        try {
            if (value.getShipmentPackageVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                ShipmentPackageContentMvoCommand.MergePatchShipmentPackageContentMvo cmd = (ShipmentPackageContentMvoCommand.MergePatchShipmentPackageContentMvo) value.toCommand();
                ShipmentPackageContentMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                shipmentPackageContentMvoApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            ShipmentPackageContentMvoCommand.CreateShipmentPackageContentMvo cmd = (ShipmentPackageContentMvoCommand.CreateShipmentPackageContentMvo) value.toCommand();
            ShipmentPackageContentMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            shipmentPackageContentMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchShipmentPackageContentMvoDto.MergePatchShipmentPackageContentMvoDto value) {
        try {

            ShipmentPackageContentMvoCommand.MergePatchShipmentPackageContentMvo cmd = value.toMergePatchShipmentPackageContentMvo();
            ShipmentPackageContentMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            shipmentPackageContentMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            ShipmentPackageContentMvoCommand.DeleteShipmentPackageContentMvo deleteCmd = new AbstractShipmentPackageContentMvoCommand.SimpleDeleteShipmentPackageContentMvo();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setShipmentPackageVersion(version);
            ShipmentPackageContentMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            shipmentPackageContentMvoApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            ShipmentPackageContentMvoMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_stateEvents/{version}")
    public ShipmentPackageContentMvoStateEventDto getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            ShipmentPackageContentId idObj = ShipmentPackageContentMvoResourceUtils.parseIdString(id);
            ShipmentPackageContentMvoStateEventDtoConverter dtoConverter = getShipmentPackageContentMvoStateEventDtoConverter();
            return dtoConverter.toShipmentPackageContentMvoStateEventDto((AbstractShipmentPackageContentMvoEvent) shipmentPackageContentMvoApplicationService.getEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public ShipmentPackageContentMvoStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            ShipmentPackageContentId idObj = ShipmentPackageContentMvoResourceUtils.parseIdString(id);
            ShipmentPackageContentMvoStateDto.DtoConverter dtoConverter = new ShipmentPackageContentMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentPackageContentMvoStateDto(shipmentPackageContentMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  ShipmentPackageContentMvoStateEventDtoConverter getShipmentPackageContentMvoStateEventDtoConverter() {
        return new ShipmentPackageContentMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new ShipmentPackageContentMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class ShipmentPackageContentMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return ShipmentPackageContentMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class ShipmentPackageContentMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, ShipmentPackageContentMvoCommand value) {
            ShipmentPackageContentId idObj = parseIdString(id);
            if (value.getShipmentPackageContentId() == null) {
                value.setShipmentPackageContentId(idObj);
            } else if (!value.getShipmentPackageContentId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getShipmentPackageContentId());
            }
        }
    

        public static ShipmentPackageContentId parseIdString(String idString) {
            TextFormatter<ShipmentPackageContentId> formatter =
                    new AbstractValueObjectTextFormatter<ShipmentPackageContentId>(ShipmentPackageContentId.class) {
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
            if (ShipmentPackageContentMvoMetadata.aliasMap.containsKey(fieldName)) {
                return ShipmentPackageContentMvoMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (ShipmentPackageContentMvoMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = ShipmentPackageContentMvoMetadata.propertyTypeMap.get(propertyName);
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

        public static ShipmentPackageContentMvoStateDto[] toShipmentPackageContentMvoStateDtoArray(Iterable<ShipmentPackageContentId> ids) {
            List<ShipmentPackageContentMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                ShipmentPackageContentMvoStateDto dto = new ShipmentPackageContentMvoStateDto();
                dto.setShipmentPackageContentId(id);
                states.add(dto);
            });
            return states.toArray(new ShipmentPackageContentMvoStateDto[0]);
        }

    }

}

