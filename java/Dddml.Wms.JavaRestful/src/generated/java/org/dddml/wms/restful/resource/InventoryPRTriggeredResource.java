package org.dddml.wms.restful.resource;

import java.util.*;
import java.util.stream.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.annotation.*;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "InventoryPRTriggereds", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class InventoryPRTriggeredResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private InventoryPRTriggeredApplicationService inventoryPRTriggeredApplicationService;


    /**
     * 查询.
     * 查询 InventoryPRTriggereds
     */
    @GetMapping
    public InventoryPRTriggeredStateDto[] getAll(@Specification(value = InventoryPRTriggeredStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<InventoryPRTriggeredState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> InventoryPRTriggeredResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (InventoryPRTriggeredMetadata.aliasMap.containsKey(n) ? InventoryPRTriggeredMetadata.aliasMap.get(n) : n));
            states = inventoryPRTriggeredApplicationService.get(
                c,
                InventoryPRTriggeredResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            InventoryPRTriggeredStateDto.DtoConverter dtoConverter = new InventoryPRTriggeredStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryPRTriggeredStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查询.
     * 分页查询 InventoryPRTriggereds
     */
    @GetMapping("_page")
    public Page<InventoryPRTriggeredStateDto> getPage(@Specification(value = InventoryPRTriggeredStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<InventoryPRTriggeredState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> InventoryPRTriggeredResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (InventoryPRTriggeredMetadata.aliasMap.containsKey(n) ? InventoryPRTriggeredMetadata.aliasMap.get(n) : n));
            states = inventoryPRTriggeredApplicationService.get(
                c,
                InventoryPRTriggeredResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = inventoryPRTriggeredApplicationService.getCount(c);

            InventoryPRTriggeredStateDto.DtoConverter dtoConverter = new InventoryPRTriggeredStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<InventoryPRTriggeredStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toInventoryPRTriggeredStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 InventoryPRTriggered
     */
    @GetMapping("{inventoryPRTriggeredId}")
    public InventoryPRTriggeredStateDto get(@PathVariable("inventoryPRTriggeredId") String inventoryPRTriggeredId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            InventoryPRTriggeredId idObj = InventoryPRTriggeredResourceUtils.parseIdString(inventoryPRTriggeredId);
            InventoryPRTriggeredState state = inventoryPRTriggeredApplicationService.get(idObj);
            if (state == null) { return null; }

            InventoryPRTriggeredStateDto.DtoConverter dtoConverter = new InventoryPRTriggeredStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryPRTriggeredStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount(@Specification(value = InventoryPRTriggeredStateDto.class) HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSONObject.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap());
            }
            count = inventoryPRTriggeredApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (InventoryPRTriggeredMetadata.aliasMap.containsKey(n) ? InventoryPRTriggeredMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 新建.
     * 新建 InventoryPRTriggered
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public InventoryPRTriggeredId post(@RequestBody CreateOrMergePatchInventoryPRTriggeredDto.CreateInventoryPRTriggeredDto value,  HttpServletResponse response) {
        try {
            InventoryPRTriggeredCommand.CreateInventoryPRTriggered cmd = value.toCreateInventoryPRTriggered();
            if (cmd.getInventoryPRTriggeredId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "InventoryPRTriggered");
            }
            InventoryPRTriggeredId idObj = cmd.getInventoryPRTriggeredId();
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            inventoryPRTriggeredApplicationService.when(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 InventoryPRTriggered
     */
    @PutMapping("{inventoryPRTriggeredId}")
    public void put(@PathVariable("inventoryPRTriggeredId") String inventoryPRTriggeredId, @RequestBody CreateOrMergePatchInventoryPRTriggeredDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                InventoryPRTriggeredCommand.MergePatchInventoryPRTriggered cmd = (InventoryPRTriggeredCommand.MergePatchInventoryPRTriggered) value.toCommand();
                InventoryPRTriggeredResourceUtils.setNullIdOrThrowOnInconsistentIds(inventoryPRTriggeredId, cmd);
                cmd.setRequesterId(SecurityContextUtil.getRequesterId());
                inventoryPRTriggeredApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            InventoryPRTriggeredCommand.CreateInventoryPRTriggered cmd = (InventoryPRTriggeredCommand.CreateInventoryPRTriggered) value.toCommand();
            InventoryPRTriggeredResourceUtils.setNullIdOrThrowOnInconsistentIds(inventoryPRTriggeredId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            inventoryPRTriggeredApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 修改.
     * 修改 InventoryPRTriggered
     */
    @PatchMapping("{inventoryPRTriggeredId}")
    public void patch(@PathVariable("inventoryPRTriggeredId") String inventoryPRTriggeredId, @RequestBody CreateOrMergePatchInventoryPRTriggeredDto.MergePatchInventoryPRTriggeredDto value) {
        try {

            InventoryPRTriggeredCommand.MergePatchInventoryPRTriggered cmd = value.toMergePatchInventoryPRTriggered();
            InventoryPRTriggeredResourceUtils.setNullIdOrThrowOnInconsistentIds(inventoryPRTriggeredId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            inventoryPRTriggeredApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            InventoryPRTriggeredMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  InventoryPRTriggeredStateEventDtoConverter getInventoryPRTriggeredStateEventDtoConverter() {
    //    return new InventoryPRTriggeredStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return InventoryPRTriggeredResourceUtils.getFilterPropertyType(propertyName);
            }
        };
    }

    // ////////////////////////////////
 
    public static class InventoryPRTriggeredResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String inventoryPRTriggeredId, InventoryPRTriggeredCommand value) {
            InventoryPRTriggeredId idObj = parseIdString(inventoryPRTriggeredId);
            if (value.getInventoryPRTriggeredId() == null) {
                value.setInventoryPRTriggeredId(idObj);
            } else if (!value.getInventoryPRTriggeredId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", inventoryPRTriggeredId, value.getInventoryPRTriggeredId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, InventoryPRTriggeredMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, InventoryPRTriggeredMetadata.aliasMap);
        }

        public static InventoryPRTriggeredId parseIdString(String idString) {
            TextFormatter<InventoryPRTriggeredId> formatter =
                    new AbstractValueObjectTextFormatter<InventoryPRTriggeredId>(InventoryPRTriggeredId.class) {
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
            if (InventoryPRTriggeredMetadata.aliasMap.containsKey(fieldName)) {
                return InventoryPRTriggeredMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (InventoryPRTriggeredMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = InventoryPRTriggeredMetadata.propertyTypeMap.get(propertyName);
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

        public static InventoryPRTriggeredStateDto[] toInventoryPRTriggeredStateDtoArray(Iterable<InventoryPRTriggeredId> ids) {
            List<InventoryPRTriggeredStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                InventoryPRTriggeredStateDto dto = new InventoryPRTriggeredStateDto();
                dto.setInventoryPRTriggeredId(i);
                states.add(dto);
            });
            return states.toArray(new InventoryPRTriggeredStateDto[0]);
        }

    }

}

