package org.dddml.wms.restful.resource;

import java.util.*;
import java.util.stream.*;
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
import org.dddml.wms.domain.sellableinventoryitem.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "SellableInventoryItems", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class SellableInventoryItemResource {


    @Autowired
    private SellableInventoryItemApplicationService sellableInventoryItemApplicationService;


    /**
     * 查询.
     * 查询 SellableInventoryItems
     */
    @GetMapping
    public SellableInventoryItemStateDto[] getAll( HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

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

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查询.
     * 分页查询 SellableInventoryItems
     */
    @GetMapping("_page")
    public Page<SellableInventoryItemStateDto> getPage( HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
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
            Page.PageImpl<SellableInventoryItemStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toSellableInventoryItemStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            statePage.setTotalElements(count);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
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

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSONObject.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap());
            }
            count = sellableInventoryItemApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (SellableInventoryItemMetadata.aliasMap.containsKey(n) ? SellableInventoryItemMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 新建.
     * 新建 SellableInventoryItem
     */
    @PostMapping
    public InventoryItemId post(@RequestBody CreateOrMergePatchSellableInventoryItemDto.CreateSellableInventoryItemDto value,  HttpServletResponse response) {
        try {
            SellableInventoryItemCommand.CreateSellableInventoryItem cmd = value.toCreateSellableInventoryItem();
            if (cmd.getSellableInventoryItemId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "SellableInventoryItem");
            }
            sellableInventoryItemApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getSellableInventoryItemId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
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
                sellableInventoryItemApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            SellableInventoryItemCommand.CreateSellableInventoryItem cmd = (SellableInventoryItemCommand.CreateSellableInventoryItem) value.toCommand();
            SellableInventoryItemResourceUtils.setNullIdOrThrowOnInconsistentIds(sellableInventoryItemId, cmd);
            sellableInventoryItemApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
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
            sellableInventoryItemApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            SellableInventoryItemMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
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

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * SellableInventoryItemEntry List
     */
    @GetMapping("{sellableInventoryItemId}/SellableInventoryItemEntries")
    public SellableInventoryItemEntryStateDto[] getSellableInventoryItemEntries(@PathVariable("sellableInventoryItemId") String sellableInventoryItemId) {
        try {
            Iterable<SellableInventoryItemEntryState> states = sellableInventoryItemApplicationService.getSellableInventoryItemEntries((new AbstractValueObjectTextFormatter<InventoryItemId>(InventoryItemId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(sellableInventoryItemId)));
            if (states == null) { return null; }
            SellableInventoryItemEntryStateDto.DtoConverter dtoConverter = new SellableInventoryItemEntryStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toSellableInventoryItemEntryStateDtoArray(states);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  SellableInventoryItemStateEventDtoConverter getSellableInventoryItemStateEventDtoConverter() {
    //    return new SellableInventoryItemStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new SellableInventoryItemPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class SellableInventoryItemPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return SellableInventoryItemResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class SellableInventoryItemResourceUtils {

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

