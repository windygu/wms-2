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
import org.dddml.wms.domain.sellableinventoryitem.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "SellableInventoryItems", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class SellableInventoryItemResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private SellableInventoryItemApplicationService sellableInventoryItemApplicationService;


    /**
     * 查询.
     * 查询 SellableInventoryItems
     */
    @GetMapping
    public SellableInventoryItemStateDto[] getAll(@Specification(value = SellableInventoryItemStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }

            Iterable<SellableInventoryItemState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> SellableInventoryItemResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (SellableInventoryItemMetadata.aliasMap.containsKey(n) ? SellableInventoryItemMetadata.aliasMap.get(n) : n));
            states = sellableInventoryItemApplicationService.get(
                c,
                SellableInventoryItemResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            SellableInventoryItemStateDto.DtoConverter dtoConverter = new SellableInventoryItemStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toSellableInventoryItemStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查询.
     * 分页查询 SellableInventoryItems
     */
    @GetMapping("_page")
    public Page<SellableInventoryItemStateDto> getPage(@Specification(value = SellableInventoryItemStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * (size == null ? 20 : size);
            Integer maxResults = (size == null ? 20 : size);
            Iterable<SellableInventoryItemState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> SellableInventoryItemResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (SellableInventoryItemMetadata.aliasMap.containsKey(n) ? SellableInventoryItemMetadata.aliasMap.get(n) : n));
            states = sellableInventoryItemApplicationService.get(
                c,
                SellableInventoryItemResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = sellableInventoryItemApplicationService.getCount(c);

            SellableInventoryItemStateDto.DtoConverter dtoConverter = new SellableInventoryItemStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<SellableInventoryItemStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toSellableInventoryItemStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 SellableInventoryItem
     */
    @GetMapping("{sellableInventoryItemId}")
    public SellableInventoryItemStateDto get(@PathVariable("sellableInventoryItemId") String sellableInventoryItemId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            InventoryItemId idObj = SellableInventoryItemResourceUtils.parseIdString(sellableInventoryItemId);
            SellableInventoryItemState state = sellableInventoryItemApplicationService.get(idObj);
            if (state == null) { return null; }

            SellableInventoryItemStateDto.DtoConverter dtoConverter = new SellableInventoryItemStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toSellableInventoryItemStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_count")
    public long getCount(@Specification(value = SellableInventoryItemStateDto.class) HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSONObject.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap());
            }
            Criterion c = CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (SellableInventoryItemMetadata.aliasMap.containsKey(n) ? SellableInventoryItemMetadata.aliasMap.get(n) : n));
            count = sellableInventoryItemApplicationService.getCount(c);
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 新建.
     * 新建 SellableInventoryItem
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public InventoryItemId post(@RequestBody CreateOrMergePatchSellableInventoryItemDto.CreateSellableInventoryItemDto value,  HttpServletResponse response) {
        try {
            SellableInventoryItemCommand.CreateSellableInventoryItem cmd = value.toCreateSellableInventoryItem();
            if (cmd.getSellableInventoryItemId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "SellableInventoryItem");
            }
            InventoryItemId idObj = cmd.getSellableInventoryItemId();
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            sellableInventoryItemApplicationService.when(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 SellableInventoryItem
     */
    @PutMapping("{sellableInventoryItemId}")
    public void put(@PathVariable("sellableInventoryItemId") String sellableInventoryItemId, @RequestBody CreateOrMergePatchSellableInventoryItemDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                SellableInventoryItemCommand.MergePatchSellableInventoryItem cmd = (SellableInventoryItemCommand.MergePatchSellableInventoryItem) value.toCommand();
                SellableInventoryItemResourceUtils.setNullIdOrThrowOnInconsistentIds(sellableInventoryItemId, cmd);
                cmd.setRequesterId(SecurityContextUtil.getRequesterId());
                sellableInventoryItemApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            SellableInventoryItemCommand.CreateSellableInventoryItem cmd = (SellableInventoryItemCommand.CreateSellableInventoryItem) value.toCommand();
            SellableInventoryItemResourceUtils.setNullIdOrThrowOnInconsistentIds(sellableInventoryItemId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            sellableInventoryItemApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 修改.
     * 修改 SellableInventoryItem
     */
    @PatchMapping("{sellableInventoryItemId}")
    public void patch(@PathVariable("sellableInventoryItemId") String sellableInventoryItemId, @RequestBody CreateOrMergePatchSellableInventoryItemDto.MergePatchSellableInventoryItemDto value) {
        try {

            SellableInventoryItemCommand.MergePatchSellableInventoryItem cmd = value.toMergePatchSellableInventoryItem();
            SellableInventoryItemResourceUtils.setNullIdOrThrowOnInconsistentIds(sellableInventoryItemId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            sellableInventoryItemApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            SellableInventoryItemMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 获取指定 EntrySeqId 的 SellableInventoryItemEntry
     */
    @GetMapping("{sellableInventoryItemId}/SellableInventoryItemEntries/{entrySeqId}")
    public SellableInventoryItemEntryStateDto getSellableInventoryItemEntry(@PathVariable("sellableInventoryItemId") String sellableInventoryItemId, @PathVariable("entrySeqId") Long entrySeqId) {
        try {

            SellableInventoryItemEntryState state = sellableInventoryItemApplicationService.getSellableInventoryItemEntry((new AbstractValueObjectTextFormatter<InventoryItemId>(InventoryItemId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(sellableInventoryItemId)), entrySeqId);
            if (state == null) { return null; }
            SellableInventoryItemEntryStateDto.DtoConverter dtoConverter = new SellableInventoryItemEntryStateDto.DtoConverter();
            SellableInventoryItemEntryStateDto stateDto = dtoConverter.toSellableInventoryItemEntryStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * SellableInventoryItemEntry List
     */
    @GetMapping("{sellableInventoryItemId}/SellableInventoryItemEntries")
    public SellableInventoryItemEntryStateDto[] getSellableInventoryItemEntries(@PathVariable("sellableInventoryItemId") String sellableInventoryItemId,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "filter", required = false) String filter,
                    @Specification(value = SellableInventoryItemEntryStateDto.class) HttpServletRequest request) {
        try {
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> SellableInventoryItemResourceUtils.getSellableInventoryItemEntryFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (SellableInventoryItemEntryMetadata.aliasMap.containsKey(n) ? SellableInventoryItemEntryMetadata.aliasMap.get(n) : n));
            Iterable<SellableInventoryItemEntryState> states = sellableInventoryItemApplicationService.getSellableInventoryItemEntries((new AbstractValueObjectTextFormatter<InventoryItemId>(InventoryItemId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(sellableInventoryItemId)), c,
                    SellableInventoryItemResourceUtils.getSellableInventoryItemEntryQuerySorts(request.getParameterMap()));
            if (states == null) { return null; }
            SellableInventoryItemEntryStateDto.DtoConverter dtoConverter = new SellableInventoryItemEntryStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toSellableInventoryItemEntryStateDtoArray(states);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    //protected  SellableInventoryItemStateEventDtoConverter getSellableInventoryItemStateEventDtoConverter() {
    //    return new SellableInventoryItemStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return SellableInventoryItemResourceUtils.getFilterPropertyType(propertyName);
            }
        };
    }

    protected PropertyTypeResolver getSellableInventoryItemEntryPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return SellableInventoryItemResourceUtils.getSellableInventoryItemEntryFilterPropertyType(propertyName);
            }
        };
    }

    // ////////////////////////////////
 
    public static class SellableInventoryItemResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String sellableInventoryItemId, SellableInventoryItemCommand value) {
            InventoryItemId idObj = parseIdString(sellableInventoryItemId);
            if (value.getSellableInventoryItemId() == null) {
                value.setSellableInventoryItemId(idObj);
            } else if (!value.getSellableInventoryItemId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", sellableInventoryItemId, value.getSellableInventoryItemId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, SellableInventoryItemMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, SellableInventoryItemMetadata.aliasMap);
        }

        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (SellableInventoryItemMetadata.aliasMap.containsKey(fieldName)) {
                return SellableInventoryItemMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (SellableInventoryItemMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = SellableInventoryItemMetadata.propertyTypeMap.get(propertyName);
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

        public static List<String> getSellableInventoryItemEntryQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, SellableInventoryItemEntryMetadata.aliasMap);
        }

        public static List<String> getSellableInventoryItemEntryQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, SellableInventoryItemEntryMetadata.aliasMap);
        }

        public static String getSellableInventoryItemEntryFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (SellableInventoryItemEntryMetadata.aliasMap.containsKey(fieldName)) {
                return SellableInventoryItemEntryMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getSellableInventoryItemEntryFilterPropertyType(String propertyName) {
            if (SellableInventoryItemEntryMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = SellableInventoryItemEntryMetadata.propertyTypeMap.get(propertyName);
                if (!StringHelper.isNullOrEmpty(propertyType)) {
                    if (org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.containsKey(propertyType)) {
                        return org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.get(propertyType);
                    }
                }
            }
            return String.class;
        }

        public static Iterable<Map.Entry<String, Object>> getSellableInventoryItemEntryQueryFilterMap(Map<String, String[]> queryNameValuePairs) {
            Map<String, Object> filter = new HashMap<>();
            queryNameValuePairs.forEach((key, values) -> {
                if (values.length > 0) {
                    String pName = getSellableInventoryItemEntryFilterPropertyName(key);
                    if (!StringHelper.isNullOrEmpty(pName)) {
                        Class pClass = getSellableInventoryItemEntryFilterPropertyType(pName);
                        filter.put(pName, ApplicationContext.current.getTypeConverter().convertFromString(pClass, values[0]));
                    }
                }
            });
            return filter.entrySet();
        }

        public static SellableInventoryItemStateDto[] toSellableInventoryItemStateDtoArray(Iterable<InventoryItemId> ids) {
            List<SellableInventoryItemStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                SellableInventoryItemStateDto dto = new SellableInventoryItemStateDto();
                dto.setSellableInventoryItemId(i);
                states.add(dto);
            });
            return states.toArray(new SellableInventoryItemStateDto[0]);
        }

    }

}

