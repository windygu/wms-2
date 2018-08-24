package org.dddml.wms.restful.resource;

import java.util.*;
import java.util.stream.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.annotation.*;
import org.dddml.wms.domain.inventoryitemrequirement.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "InventoryItemRequirements", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class InventoryItemRequirementResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private InventoryItemRequirementApplicationService inventoryItemRequirementApplicationService;


    /**
     * 查询.
     * 查询 InventoryItemRequirements
     */
    @GetMapping
    public InventoryItemRequirementStateDto[] getAll(@Specification(value = InventoryItemRequirementStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<InventoryItemRequirementState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> InventoryItemRequirementResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (InventoryItemRequirementMetadata.aliasMap.containsKey(n) ? InventoryItemRequirementMetadata.aliasMap.get(n) : n));
            states = inventoryItemRequirementApplicationService.get(
                c,
                InventoryItemRequirementResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            InventoryItemRequirementStateDto.DtoConverter dtoConverter = new InventoryItemRequirementStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryItemRequirementStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查询.
     * 分页查询 InventoryItemRequirements
     */
    @GetMapping("_page")
    public Page<InventoryItemRequirementStateDto> getPage(@Specification(value = InventoryItemRequirementStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<InventoryItemRequirementState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> InventoryItemRequirementResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (InventoryItemRequirementMetadata.aliasMap.containsKey(n) ? InventoryItemRequirementMetadata.aliasMap.get(n) : n));
            states = inventoryItemRequirementApplicationService.get(
                c,
                InventoryItemRequirementResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = inventoryItemRequirementApplicationService.getCount(c);

            InventoryItemRequirementStateDto.DtoConverter dtoConverter = new InventoryItemRequirementStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<InventoryItemRequirementStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toInventoryItemRequirementStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 InventoryItemRequirement
     */
    @GetMapping("{inventoryItemRequirementId}")
    public InventoryItemRequirementStateDto get(@PathVariable("inventoryItemRequirementId") String inventoryItemRequirementId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            InventoryItemId idObj = InventoryItemRequirementResourceUtils.parseIdString(inventoryItemRequirementId);
            InventoryItemRequirementState state = inventoryItemRequirementApplicationService.get(idObj);
            if (state == null) { return null; }

            InventoryItemRequirementStateDto.DtoConverter dtoConverter = new InventoryItemRequirementStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryItemRequirementStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount(@Specification(value = InventoryItemRequirementStateDto.class) HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSONObject.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap());
            }
            count = inventoryItemRequirementApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (InventoryItemRequirementMetadata.aliasMap.containsKey(n) ? InventoryItemRequirementMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 新建.
     * 新建 InventoryItemRequirement
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public InventoryItemId post(@RequestBody CreateOrMergePatchInventoryItemRequirementDto.CreateInventoryItemRequirementDto value,  HttpServletResponse response) {
        try {
            InventoryItemRequirementCommand.CreateInventoryItemRequirement cmd = value.toCreateInventoryItemRequirement();
            if (cmd.getInventoryItemRequirementId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "InventoryItemRequirement");
            }
            InventoryItemId idObj = cmd.getInventoryItemRequirementId();
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            inventoryItemRequirementApplicationService.when(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 InventoryItemRequirement
     */
    @PutMapping("{inventoryItemRequirementId}")
    public void put(@PathVariable("inventoryItemRequirementId") String inventoryItemRequirementId, @RequestBody CreateOrMergePatchInventoryItemRequirementDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                InventoryItemRequirementCommand.MergePatchInventoryItemRequirement cmd = (InventoryItemRequirementCommand.MergePatchInventoryItemRequirement) value.toCommand();
                InventoryItemRequirementResourceUtils.setNullIdOrThrowOnInconsistentIds(inventoryItemRequirementId, cmd);
                cmd.setRequesterId(SecurityContextUtil.getRequesterId());
                inventoryItemRequirementApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            InventoryItemRequirementCommand.CreateInventoryItemRequirement cmd = (InventoryItemRequirementCommand.CreateInventoryItemRequirement) value.toCommand();
            InventoryItemRequirementResourceUtils.setNullIdOrThrowOnInconsistentIds(inventoryItemRequirementId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            inventoryItemRequirementApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 修改.
     * 修改 InventoryItemRequirement
     */
    @PatchMapping("{inventoryItemRequirementId}")
    public void patch(@PathVariable("inventoryItemRequirementId") String inventoryItemRequirementId, @RequestBody CreateOrMergePatchInventoryItemRequirementDto.MergePatchInventoryItemRequirementDto value) {
        try {

            InventoryItemRequirementCommand.MergePatchInventoryItemRequirement cmd = value.toMergePatchInventoryItemRequirement();
            InventoryItemRequirementResourceUtils.setNullIdOrThrowOnInconsistentIds(inventoryItemRequirementId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            inventoryItemRequirementApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            InventoryItemRequirementMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 获取指定 EntrySeqId 的 InventoryItemRequirementEntry
     */
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

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * InventoryItemRequirementEntry List
     */
    @GetMapping("{inventoryItemRequirementId}/InventoryItemRequirementEntries")
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
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  InventoryItemRequirementStateEventDtoConverter getInventoryItemRequirementStateEventDtoConverter() {
    //    return new InventoryItemRequirementStateEventDtoConverter();
    //}

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

        public static void setNullIdOrThrowOnInconsistentIds(String inventoryItemRequirementId, InventoryItemRequirementCommand value) {
            InventoryItemId idObj = parseIdString(inventoryItemRequirementId);
            if (value.getInventoryItemRequirementId() == null) {
                value.setInventoryItemRequirementId(idObj);
            } else if (!value.getInventoryItemRequirementId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", inventoryItemRequirementId, value.getInventoryItemRequirementId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, InventoryItemRequirementMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, InventoryItemRequirementMetadata.aliasMap);
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
            ids.forEach(i -> {
                InventoryItemRequirementStateDto dto = new InventoryItemRequirementStateDto();
                dto.setInventoryItemRequirementId(i);
                states.add(dto);
            });
            return states.toArray(new InventoryItemRequirementStateDto[0]);
        }

    }

}

