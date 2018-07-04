package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inventoryitementrymvo.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "InventoryItemEntryMvos", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class InventoryItemEntryMvoResource {


    @Autowired
    private InventoryItemEntryMvoApplicationService inventoryItemEntryMvoApplicationService;


    @GetMapping
    public InventoryItemEntryMvoStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<InventoryItemEntryMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = inventoryItemEntryMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (InventoryItemEntryMvoMetadata.aliasMap.containsKey(n) ? InventoryItemEntryMvoMetadata.aliasMap.get(n) : n)),
                        InventoryItemEntryMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = inventoryItemEntryMvoApplicationService.get(
                        InventoryItemEntryMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        InventoryItemEntryMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            InventoryItemEntryMvoStateDto.DtoConverter dtoConverter = new InventoryItemEntryMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryItemEntryMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public InventoryItemEntryMvoStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            InventoryItemEntryId idObj = InventoryItemEntryMvoResourceUtils.parseIdString(id);
            InventoryItemEntryMvoState state = inventoryItemEntryMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            InventoryItemEntryMvoStateDto.DtoConverter dtoConverter = new InventoryItemEntryMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryItemEntryMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = inventoryItemEntryMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (InventoryItemEntryMvoMetadata.aliasMap.containsKey(n) ? InventoryItemEntryMvoMetadata.aliasMap.get(n) : n)));
            } else {
                count = inventoryItemEntryMvoApplicationService.getCount(InventoryItemEntryMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public InventoryItemEntryId post(@RequestBody CreateOrMergePatchInventoryItemEntryMvoDto.CreateInventoryItemEntryMvoDto value,  HttpServletResponse response) {
        try {
            InventoryItemEntryMvoCommand.CreateInventoryItemEntryMvo cmd = value.toCreateInventoryItemEntryMvo();
            if (cmd.getInventoryItemEntryId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "InventoryItemEntryMvo");
            }
            inventoryItemEntryMvoApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getInventoryItemEntryId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchInventoryItemEntryMvoDto value) {
        try {
            if (value.getInventoryItemVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                InventoryItemEntryMvoCommand.MergePatchInventoryItemEntryMvo cmd = (InventoryItemEntryMvoCommand.MergePatchInventoryItemEntryMvo) value.toCommand();
                InventoryItemEntryMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                inventoryItemEntryMvoApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            InventoryItemEntryMvoCommand.CreateInventoryItemEntryMvo cmd = (InventoryItemEntryMvoCommand.CreateInventoryItemEntryMvo) value.toCommand();
            InventoryItemEntryMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            inventoryItemEntryMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchInventoryItemEntryMvoDto.MergePatchInventoryItemEntryMvoDto value) {
        try {

            InventoryItemEntryMvoCommand.MergePatchInventoryItemEntryMvo cmd = value.toMergePatchInventoryItemEntryMvo();
            InventoryItemEntryMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            inventoryItemEntryMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            InventoryItemEntryMvoMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_stateEvents/{version}")
    public InventoryItemEntryMvoStateEventDto getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            InventoryItemEntryId idObj = InventoryItemEntryMvoResourceUtils.parseIdString(id);
            InventoryItemEntryMvoStateEventDtoConverter dtoConverter = getInventoryItemEntryMvoStateEventDtoConverter();
            return dtoConverter.toInventoryItemEntryMvoStateEventDto((AbstractInventoryItemEntryMvoEvent) inventoryItemEntryMvoApplicationService.getEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public InventoryItemEntryMvoStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            InventoryItemEntryId idObj = InventoryItemEntryMvoResourceUtils.parseIdString(id);
            InventoryItemEntryMvoStateDto.DtoConverter dtoConverter = new InventoryItemEntryMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryItemEntryMvoStateDto(inventoryItemEntryMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  InventoryItemEntryMvoStateEventDtoConverter getInventoryItemEntryMvoStateEventDtoConverter() {
        return new InventoryItemEntryMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new InventoryItemEntryMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class InventoryItemEntryMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return InventoryItemEntryMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class InventoryItemEntryMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, InventoryItemEntryMvoCommand value) {
            InventoryItemEntryId idObj = parseIdString(id);
            if (value.getInventoryItemEntryId() == null) {
                value.setInventoryItemEntryId(idObj);
            } else if (!value.getInventoryItemEntryId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getInventoryItemEntryId());
            }
        }
    

        public static InventoryItemEntryId parseIdString(String idString) {
            TextFormatter<InventoryItemEntryId> formatter =
                    new AbstractValueObjectTextFormatter<InventoryItemEntryId>(InventoryItemEntryId.class) {
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
            if (InventoryItemEntryMvoMetadata.aliasMap.containsKey(fieldName)) {
                return InventoryItemEntryMvoMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (InventoryItemEntryMvoMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = InventoryItemEntryMvoMetadata.propertyTypeMap.get(propertyName);
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

        public static InventoryItemEntryMvoStateDto[] toInventoryItemEntryMvoStateDtoArray(Iterable<InventoryItemEntryId> ids) {
            List<InventoryItemEntryMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                InventoryItemEntryMvoStateDto dto = new InventoryItemEntryMvoStateDto();
                dto.setInventoryItemEntryId(id);
                states.add(dto);
            });
            return states.toArray(new InventoryItemEntryMvoStateDto[0]);
        }

    }

}

