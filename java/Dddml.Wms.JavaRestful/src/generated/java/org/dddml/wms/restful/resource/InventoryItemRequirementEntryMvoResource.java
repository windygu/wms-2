package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.inventoryitemrequirement.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inventoryitemrequiremententrymvo.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "InventoryItemRequirementEntryMvos", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class InventoryItemRequirementEntryMvoResource {


    @Autowired
    private InventoryItemRequirementEntryMvoApplicationService inventoryItemRequirementEntryMvoApplicationService;


    @GetMapping
    public InventoryItemRequirementEntryMvoStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<InventoryItemRequirementEntryMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = inventoryItemRequirementEntryMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (InventoryItemRequirementEntryMvoMetadata.aliasMap.containsKey(n) ? InventoryItemRequirementEntryMvoMetadata.aliasMap.get(n) : n)),
                        InventoryItemRequirementEntryMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = inventoryItemRequirementEntryMvoApplicationService.get(
                        InventoryItemRequirementEntryMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        InventoryItemRequirementEntryMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            InventoryItemRequirementEntryMvoStateDto.DtoConverter dtoConverter = new InventoryItemRequirementEntryMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryItemRequirementEntryMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public InventoryItemRequirementEntryMvoStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            InventoryItemRequirementEntryId idObj = InventoryItemRequirementEntryMvoResourceUtils.parseIdString(id);
            InventoryItemRequirementEntryMvoState state = inventoryItemRequirementEntryMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            InventoryItemRequirementEntryMvoStateDto.DtoConverter dtoConverter = new InventoryItemRequirementEntryMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryItemRequirementEntryMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = inventoryItemRequirementEntryMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (InventoryItemRequirementEntryMvoMetadata.aliasMap.containsKey(n) ? InventoryItemRequirementEntryMvoMetadata.aliasMap.get(n) : n)));
            } else {
                count = inventoryItemRequirementEntryMvoApplicationService.getCount(InventoryItemRequirementEntryMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public InventoryItemRequirementEntryId post(@RequestBody CreateOrMergePatchInventoryItemRequirementEntryMvoDto.CreateInventoryItemRequirementEntryMvoDto value,  HttpServletResponse response) {
        try {
            InventoryItemRequirementEntryMvoCommand.CreateInventoryItemRequirementEntryMvo cmd = value.toCreateInventoryItemRequirementEntryMvo();
            if (cmd.getInventoryItemRequirementEntryId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "InventoryItemRequirementEntryMvo");
            }
            inventoryItemRequirementEntryMvoApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getInventoryItemRequirementEntryId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchInventoryItemRequirementEntryMvoDto value) {
        try {
            if (value.getInventoryItemRequirementVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                InventoryItemRequirementEntryMvoCommand.MergePatchInventoryItemRequirementEntryMvo cmd = (InventoryItemRequirementEntryMvoCommand.MergePatchInventoryItemRequirementEntryMvo) value.toCommand();
                InventoryItemRequirementEntryMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                inventoryItemRequirementEntryMvoApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            InventoryItemRequirementEntryMvoCommand.CreateInventoryItemRequirementEntryMvo cmd = (InventoryItemRequirementEntryMvoCommand.CreateInventoryItemRequirementEntryMvo) value.toCommand();
            InventoryItemRequirementEntryMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            inventoryItemRequirementEntryMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchInventoryItemRequirementEntryMvoDto.MergePatchInventoryItemRequirementEntryMvoDto value) {
        try {

            InventoryItemRequirementEntryMvoCommand.MergePatchInventoryItemRequirementEntryMvo cmd = value.toMergePatchInventoryItemRequirementEntryMvo();
            InventoryItemRequirementEntryMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            inventoryItemRequirementEntryMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            InventoryItemRequirementEntryMvoMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_stateEvents/{version}")
    public InventoryItemRequirementEntryMvoStateEventDto getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            InventoryItemRequirementEntryId idObj = InventoryItemRequirementEntryMvoResourceUtils.parseIdString(id);
            InventoryItemRequirementEntryMvoStateEventDtoConverter dtoConverter = getInventoryItemRequirementEntryMvoStateEventDtoConverter();
            return dtoConverter.toInventoryItemRequirementEntryMvoStateEventDto((AbstractInventoryItemRequirementEntryMvoEvent) inventoryItemRequirementEntryMvoApplicationService.getEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public InventoryItemRequirementEntryMvoStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            InventoryItemRequirementEntryId idObj = InventoryItemRequirementEntryMvoResourceUtils.parseIdString(id);
            InventoryItemRequirementEntryMvoStateDto.DtoConverter dtoConverter = new InventoryItemRequirementEntryMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryItemRequirementEntryMvoStateDto(inventoryItemRequirementEntryMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  InventoryItemRequirementEntryMvoStateEventDtoConverter getInventoryItemRequirementEntryMvoStateEventDtoConverter() {
        return new InventoryItemRequirementEntryMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new InventoryItemRequirementEntryMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class InventoryItemRequirementEntryMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return InventoryItemRequirementEntryMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class InventoryItemRequirementEntryMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, InventoryItemRequirementEntryMvoCommand value) {
            InventoryItemRequirementEntryId idObj = parseIdString(id);
            if (value.getInventoryItemRequirementEntryId() == null) {
                value.setInventoryItemRequirementEntryId(idObj);
            } else if (!value.getInventoryItemRequirementEntryId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getInventoryItemRequirementEntryId());
            }
        }
    

        public static InventoryItemRequirementEntryId parseIdString(String idString) {
            TextFormatter<InventoryItemRequirementEntryId> formatter =
                    new AbstractValueObjectTextFormatter<InventoryItemRequirementEntryId>(InventoryItemRequirementEntryId.class) {
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
            if (InventoryItemRequirementEntryMvoMetadata.aliasMap.containsKey(fieldName)) {
                return InventoryItemRequirementEntryMvoMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (InventoryItemRequirementEntryMvoMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = InventoryItemRequirementEntryMvoMetadata.propertyTypeMap.get(propertyName);
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

        public static InventoryItemRequirementEntryMvoStateDto[] toInventoryItemRequirementEntryMvoStateDtoArray(Iterable<InventoryItemRequirementEntryId> ids) {
            List<InventoryItemRequirementEntryMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                InventoryItemRequirementEntryMvoStateDto dto = new InventoryItemRequirementEntryMvoStateDto();
                dto.setInventoryItemRequirementEntryId(id);
                states.add(dto);
            });
            return states.toArray(new InventoryItemRequirementEntryMvoStateDto[0]);
        }

    }

}

