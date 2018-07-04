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
import org.dddml.wms.domain.itemissuancemvo.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "ItemIssuanceMvos", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ItemIssuanceMvoResource {


    @Autowired
    private ItemIssuanceMvoApplicationService itemIssuanceMvoApplicationService;


    @GetMapping
    public ItemIssuanceMvoStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<ItemIssuanceMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = itemIssuanceMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (ItemIssuanceMvoMetadata.aliasMap.containsKey(n) ? ItemIssuanceMvoMetadata.aliasMap.get(n) : n)),
                        ItemIssuanceMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = itemIssuanceMvoApplicationService.get(
                        ItemIssuanceMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        ItemIssuanceMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            ItemIssuanceMvoStateDto.DtoConverter dtoConverter = new ItemIssuanceMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toItemIssuanceMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public ItemIssuanceMvoStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            ShipmentItemIssuanceId idObj = ItemIssuanceMvoResourceUtils.parseIdString(id);
            ItemIssuanceMvoState state = itemIssuanceMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            ItemIssuanceMvoStateDto.DtoConverter dtoConverter = new ItemIssuanceMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toItemIssuanceMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = itemIssuanceMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (ItemIssuanceMvoMetadata.aliasMap.containsKey(n) ? ItemIssuanceMvoMetadata.aliasMap.get(n) : n)));
            } else {
                count = itemIssuanceMvoApplicationService.getCount(ItemIssuanceMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public ShipmentItemIssuanceId post(@RequestBody CreateOrMergePatchItemIssuanceMvoDto.CreateItemIssuanceMvoDto value,  HttpServletResponse response) {
        try {
            ItemIssuanceMvoCommand.CreateItemIssuanceMvo cmd = value.toCreateItemIssuanceMvo();
            if (cmd.getShipmentItemIssuanceId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "ItemIssuanceMvo");
            }
            itemIssuanceMvoApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getShipmentItemIssuanceId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchItemIssuanceMvoDto value) {
        try {
            if (value.getShipmentVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                ItemIssuanceMvoCommand.MergePatchItemIssuanceMvo cmd = (ItemIssuanceMvoCommand.MergePatchItemIssuanceMvo) value.toCommand();
                ItemIssuanceMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                itemIssuanceMvoApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            ItemIssuanceMvoCommand.CreateItemIssuanceMvo cmd = (ItemIssuanceMvoCommand.CreateItemIssuanceMvo) value.toCommand();
            ItemIssuanceMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            itemIssuanceMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchItemIssuanceMvoDto.MergePatchItemIssuanceMvoDto value) {
        try {

            ItemIssuanceMvoCommand.MergePatchItemIssuanceMvo cmd = value.toMergePatchItemIssuanceMvo();
            ItemIssuanceMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            itemIssuanceMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            ItemIssuanceMvoCommand.DeleteItemIssuanceMvo deleteCmd = new AbstractItemIssuanceMvoCommand.SimpleDeleteItemIssuanceMvo();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setShipmentVersion(version);
            ItemIssuanceMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            itemIssuanceMvoApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            ItemIssuanceMvoMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_stateEvents/{version}")
    public ItemIssuanceMvoStateEventDto getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            ShipmentItemIssuanceId idObj = ItemIssuanceMvoResourceUtils.parseIdString(id);
            ItemIssuanceMvoStateEventDtoConverter dtoConverter = getItemIssuanceMvoStateEventDtoConverter();
            return dtoConverter.toItemIssuanceMvoStateEventDto((AbstractItemIssuanceMvoEvent) itemIssuanceMvoApplicationService.getEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public ItemIssuanceMvoStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            ShipmentItemIssuanceId idObj = ItemIssuanceMvoResourceUtils.parseIdString(id);
            ItemIssuanceMvoStateDto.DtoConverter dtoConverter = new ItemIssuanceMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toItemIssuanceMvoStateDto(itemIssuanceMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  ItemIssuanceMvoStateEventDtoConverter getItemIssuanceMvoStateEventDtoConverter() {
        return new ItemIssuanceMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new ItemIssuanceMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class ItemIssuanceMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return ItemIssuanceMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class ItemIssuanceMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, ItemIssuanceMvoCommand value) {
            ShipmentItemIssuanceId idObj = parseIdString(id);
            if (value.getShipmentItemIssuanceId() == null) {
                value.setShipmentItemIssuanceId(idObj);
            } else if (!value.getShipmentItemIssuanceId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getShipmentItemIssuanceId());
            }
        }
    

        public static ShipmentItemIssuanceId parseIdString(String idString) {
            TextFormatter<ShipmentItemIssuanceId> formatter =
                    new AbstractValueObjectTextFormatter<ShipmentItemIssuanceId>(ShipmentItemIssuanceId.class) {
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
            if (ItemIssuanceMvoMetadata.aliasMap.containsKey(fieldName)) {
                return ItemIssuanceMvoMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (ItemIssuanceMvoMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = ItemIssuanceMvoMetadata.propertyTypeMap.get(propertyName);
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

        public static ItemIssuanceMvoStateDto[] toItemIssuanceMvoStateDtoArray(Iterable<ShipmentItemIssuanceId> ids) {
            List<ItemIssuanceMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                ItemIssuanceMvoStateDto dto = new ItemIssuanceMvoStateDto();
                dto.setShipmentItemIssuanceId(id);
                states.add(dto);
            });
            return states.toArray(new ItemIssuanceMvoStateDto[0]);
        }

    }

}

