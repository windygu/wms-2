package org.dddml.wms.restful.resource;

import java.util.*;
import java.util.stream.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "InventoryItems", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class InventoryItemResource {


    @Autowired
    private InventoryItemApplicationService inventoryItemApplicationService;


    /**
     * 查询.
     * 查询 InventoryItems
     */
    @GetMapping
    public InventoryItemStateDto[] getAll( HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<InventoryItemState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> InventoryItemResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (InventoryItemMetadata.aliasMap.containsKey(n) ? InventoryItemMetadata.aliasMap.get(n) : n));
            states = inventoryItemApplicationService.get(
                c,
                InventoryItemResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            InventoryItemStateDto.DtoConverter dtoConverter = new InventoryItemStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryItemStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查询.
     * 分页查询 InventoryItems
     */
    @GetMapping("_page")
    public Page<InventoryItemStateDto> getPage( HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<InventoryItemState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> InventoryItemResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (InventoryItemMetadata.aliasMap.containsKey(n) ? InventoryItemMetadata.aliasMap.get(n) : n));
            states = inventoryItemApplicationService.get(
                c,
                InventoryItemResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = inventoryItemApplicationService.getCount(c);

            InventoryItemStateDto.DtoConverter dtoConverter = new InventoryItemStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<InventoryItemStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toInventoryItemStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            statePage.setTotalElements(count);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 InventoryItem
     */
    @GetMapping("{inventoryItemId}")
    public InventoryItemStateDto get(@PathVariable("inventoryItemId") String inventoryItemId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            InventoryItemId idObj = InventoryItemResourceUtils.parseIdString(inventoryItemId);
            InventoryItemState state = inventoryItemApplicationService.get(idObj);
            if (state == null) { return null; }

            InventoryItemStateDto.DtoConverter dtoConverter = new InventoryItemStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryItemStateDto(state);

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
            count = inventoryItemApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (InventoryItemMetadata.aliasMap.containsKey(n) ? InventoryItemMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            InventoryItemMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{inventoryItemId}/_events/{version}")
    public InventoryItemEvent getStateEvent(@PathVariable("inventoryItemId") String inventoryItemId, @PathVariable("version") long version) {
        try {

            InventoryItemId idObj = InventoryItemResourceUtils.parseIdString(inventoryItemId);
            //InventoryItemStateEventDtoConverter dtoConverter = getInventoryItemStateEventDtoConverter();
            return inventoryItemApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{inventoryItemId}/_historyStates/{version}")
    public InventoryItemStateDto getHistoryState(@PathVariable("inventoryItemId") String inventoryItemId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            InventoryItemId idObj = InventoryItemResourceUtils.parseIdString(inventoryItemId);
            InventoryItemStateDto.DtoConverter dtoConverter = new InventoryItemStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryItemStateDto(inventoryItemApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{inventoryItemId}/InventoryItemEntries/{entrySeqId}")
    public InventoryItemEntryStateDto getInventoryItemEntry(@PathVariable("inventoryItemId") String inventoryItemId, @PathVariable("entrySeqId") Long entrySeqId) {
        try {

            InventoryItemEntryState state = inventoryItemApplicationService.getInventoryItemEntry((new AbstractValueObjectTextFormatter<InventoryItemId>(InventoryItemId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(inventoryItemId)), entrySeqId);
            if (state == null) { return null; }
            InventoryItemEntryStateDto.DtoConverter dtoConverter = new InventoryItemEntryStateDto.DtoConverter();
            InventoryItemEntryStateDto stateDto = dtoConverter.toInventoryItemEntryStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{inventoryItemId}/InventoryItemEntries/")
    public InventoryItemEntryStateDto[] getInventoryItemEntries(@PathVariable("inventoryItemId") String inventoryItemId) {
        try {
            Iterable<InventoryItemEntryState> states = inventoryItemApplicationService.getInventoryItemEntries((new AbstractValueObjectTextFormatter<InventoryItemId>(InventoryItemId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(inventoryItemId)));
            if (states == null) { return null; }
            InventoryItemEntryStateDto.DtoConverter dtoConverter = new InventoryItemEntryStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toInventoryItemEntryStateDtoArray(states);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  InventoryItemStateEventDtoConverter getInventoryItemStateEventDtoConverter() {
    //    return new InventoryItemStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new InventoryItemPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class InventoryItemPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return InventoryItemResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class InventoryItemResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String inventoryItemId, InventoryItemCommand value) {
            InventoryItemId idObj = parseIdString(inventoryItemId);
            if (value.getInventoryItemId() == null) {
                value.setInventoryItemId(idObj);
            } else if (!value.getInventoryItemId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", inventoryItemId, value.getInventoryItemId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, InventoryItemMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, InventoryItemMetadata.aliasMap);
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
            if (InventoryItemMetadata.aliasMap.containsKey(fieldName)) {
                return InventoryItemMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (InventoryItemMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = InventoryItemMetadata.propertyTypeMap.get(propertyName);
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

        public static InventoryItemStateDto[] toInventoryItemStateDtoArray(Iterable<InventoryItemId> ids) {
            List<InventoryItemStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                InventoryItemStateDto dto = new InventoryItemStateDto();
                dto.setInventoryItemId(i);
                states.add(dto);
            });
            return states.toArray(new InventoryItemStateDto[0]);
        }

    }

}

