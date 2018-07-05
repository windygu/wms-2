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
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inventoryitemrequirement.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "InventoryItemRequirements", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class InventoryItemRequirementResource {


    @Autowired
    private InventoryItemRequirementApplicationService inventoryItemRequirementApplicationService;


    @GetMapping
    public InventoryItemRequirementStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<InventoryItemRequirementState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = inventoryItemRequirementApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (InventoryItemRequirementMetadata.aliasMap.containsKey(n) ? InventoryItemRequirementMetadata.aliasMap.get(n) : n)),
                        InventoryItemRequirementResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = inventoryItemRequirementApplicationService.get(
                        InventoryItemRequirementResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        InventoryItemRequirementResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            InventoryItemRequirementStateDto.DtoConverter dtoConverter = new InventoryItemRequirementStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryItemRequirementStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public InventoryItemRequirementStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            InventoryItemId idObj = InventoryItemRequirementResourceUtils.parseIdString(id);
            InventoryItemRequirementState state = inventoryItemRequirementApplicationService.get(idObj);
            if (state == null) { return null; }

            InventoryItemRequirementStateDto.DtoConverter dtoConverter = new InventoryItemRequirementStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryItemRequirementStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = inventoryItemRequirementApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (InventoryItemRequirementMetadata.aliasMap.containsKey(n) ? InventoryItemRequirementMetadata.aliasMap.get(n) : n)));
            } else {
                count = inventoryItemRequirementApplicationService.getCount(InventoryItemRequirementResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public InventoryItemId post(@RequestBody CreateOrMergePatchInventoryItemRequirementDto.CreateInventoryItemRequirementDto value,  HttpServletResponse response) {
        try {
            InventoryItemRequirementCommand.CreateInventoryItemRequirement cmd = value.toCreateInventoryItemRequirement();
            if (cmd.getInventoryItemRequirementId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "InventoryItemRequirement");
            }
            inventoryItemRequirementApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getInventoryItemRequirementId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchInventoryItemRequirementDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                InventoryItemRequirementCommand.MergePatchInventoryItemRequirement cmd = (InventoryItemRequirementCommand.MergePatchInventoryItemRequirement) value.toCommand();
                InventoryItemRequirementResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                inventoryItemRequirementApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            InventoryItemRequirementCommand.CreateInventoryItemRequirement cmd = (InventoryItemRequirementCommand.CreateInventoryItemRequirement) value.toCommand();
            InventoryItemRequirementResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            inventoryItemRequirementApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchInventoryItemRequirementDto.MergePatchInventoryItemRequirementDto value) {
        try {

            InventoryItemRequirementCommand.MergePatchInventoryItemRequirement cmd = value.toMergePatchInventoryItemRequirement();
            InventoryItemRequirementResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            inventoryItemRequirementApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            InventoryItemRequirementMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{inventoryItemRequirementId}/InventoryItemRequirementEntries/{entrySeqId}")
    public InventoryItemRequirementEntryStateDto getInventoryItemRequirementEntry(@PathVariable("inventoryItemRequirementId") String inventoryItemRequirementId, @PathVariable("entrySeqId") Long entrySeqId) {
        try {

            InventoryItemRequirementEntryState state = inventoryItemRequirementApplicationService.getInventoryItemRequirementEntry((new AbstractValueObjectTextFormatter<InventoryItemId>(InventoryItemId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(inventoryItemRequirementId)), entrySeqId);
            if (state == null) { return null; }
            InventoryItemRequirementEntryStateDto.DtoConverter dtoConverter = new InventoryItemRequirementEntryStateDto.DtoConverter();
            InventoryItemRequirementEntryStateDto stateDto = dtoConverter.toInventoryItemRequirementEntryStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{inventoryItemRequirementId}/InventoryItemRequirementEntries/")
    public InventoryItemRequirementEntryStateDto[] getInventoryItemRequirementEntries(@PathVariable("inventoryItemRequirementId") String inventoryItemRequirementId) {
        try {
            Iterable<InventoryItemRequirementEntryState> states = inventoryItemRequirementApplicationService.getInventoryItemRequirementEntries((new AbstractValueObjectTextFormatter<InventoryItemId>(InventoryItemId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(inventoryItemRequirementId)));
            if (states == null) { return null; }
            InventoryItemRequirementEntryStateDto.DtoConverter dtoConverter = new InventoryItemRequirementEntryStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toInventoryItemRequirementEntryStateDtoArray(states);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  InventoryItemRequirementStateEventDtoConverter getInventoryItemRequirementStateEventDtoConverter() {
        return new InventoryItemRequirementStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new InventoryItemRequirementPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class InventoryItemRequirementPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return InventoryItemRequirementResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class InventoryItemRequirementResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, InventoryItemRequirementCommand value) {
            InventoryItemId idObj = parseIdString(id);
            if (value.getInventoryItemRequirementId() == null) {
                value.setInventoryItemRequirementId(idObj);
            } else if (!value.getInventoryItemRequirementId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getInventoryItemRequirementId());
            }
        }
    

        public static InventoryItemId parseIdString(String idString) {
            TextFormatter<InventoryItemId> formatter =
                    new AbstractValueObjectTextFormatter<InventoryItemId>(InventoryItemId.class) {
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
            if (InventoryItemRequirementMetadata.aliasMap.containsKey(fieldName)) {
                return InventoryItemRequirementMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (InventoryItemRequirementMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = InventoryItemRequirementMetadata.propertyTypeMap.get(propertyName);
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

        public static InventoryItemRequirementStateDto[] toInventoryItemRequirementStateDtoArray(Iterable<InventoryItemId> ids) {
            List<InventoryItemRequirementStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                InventoryItemRequirementStateDto dto = new InventoryItemRequirementStateDto();
                dto.setInventoryItemRequirementId(id);
                states.add(dto);
            });
            return states.toArray(new InventoryItemRequirementStateDto[0]);
        }

    }

}

