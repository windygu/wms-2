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
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.annotation.*;
import org.dddml.wms.domain.inventorypostingrule.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "InventoryPostingRules", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class InventoryPostingRuleResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private InventoryPostingRuleApplicationService inventoryPostingRuleApplicationService;


    /**
     * 查询.
     * 查询 InventoryPostingRules
     */
    @GetMapping
    public InventoryPostingRuleStateDto[] getAll(@Specification(value = InventoryPostingRuleStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }

            Iterable<InventoryPostingRuleState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> InventoryPostingRuleResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (InventoryPostingRuleMetadata.aliasMap.containsKey(n) ? InventoryPostingRuleMetadata.aliasMap.get(n) : n));
            states = inventoryPostingRuleApplicationService.get(
                c,
                InventoryPostingRuleResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            InventoryPostingRuleStateDto.DtoConverter dtoConverter = new InventoryPostingRuleStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryPostingRuleStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查询.
     * 分页查询 InventoryPostingRules
     */
    @GetMapping("_page")
    public Page<InventoryPostingRuleStateDto> getPage(@Specification(value = InventoryPostingRuleStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<InventoryPostingRuleState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> InventoryPostingRuleResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (InventoryPostingRuleMetadata.aliasMap.containsKey(n) ? InventoryPostingRuleMetadata.aliasMap.get(n) : n));
            states = inventoryPostingRuleApplicationService.get(
                c,
                InventoryPostingRuleResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = inventoryPostingRuleApplicationService.getCount(c);

            InventoryPostingRuleStateDto.DtoConverter dtoConverter = new InventoryPostingRuleStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<InventoryPostingRuleStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toInventoryPostingRuleStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 InventoryPostingRule
     */
    @GetMapping("{inventoryPostingRuleId}")
    public InventoryPostingRuleStateDto get(@PathVariable("inventoryPostingRuleId") String inventoryPostingRuleId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = inventoryPostingRuleId;
            InventoryPostingRuleState state = inventoryPostingRuleApplicationService.get(idObj);
            if (state == null) { return null; }

            InventoryPostingRuleStateDto.DtoConverter dtoConverter = new InventoryPostingRuleStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryPostingRuleStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_count")
    public long getCount(@Specification(value = InventoryPostingRuleStateDto.class) HttpServletRequest request,
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
                n -> (InventoryPostingRuleMetadata.aliasMap.containsKey(n) ? InventoryPostingRuleMetadata.aliasMap.get(n) : n));
            count = inventoryPostingRuleApplicationService.getCount(c);
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 新建.
     * 新建 InventoryPostingRule
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody CreateOrMergePatchInventoryPostingRuleDto.CreateInventoryPostingRuleDto value,  HttpServletResponse response) {
        try {
            InventoryPostingRuleCommand.CreateInventoryPostingRule cmd = value.toCreateInventoryPostingRule();
            if (cmd.getInventoryPostingRuleId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "InventoryPostingRule");
            }
            String idObj = cmd.getInventoryPostingRuleId();
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            inventoryPostingRuleApplicationService.when(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 InventoryPostingRule
     */
    @PutMapping("{inventoryPostingRuleId}")
    public void put(@PathVariable("inventoryPostingRuleId") String inventoryPostingRuleId, @RequestBody CreateOrMergePatchInventoryPostingRuleDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                InventoryPostingRuleCommand.MergePatchInventoryPostingRule cmd = (InventoryPostingRuleCommand.MergePatchInventoryPostingRule) value.toCommand();
                InventoryPostingRuleResourceUtils.setNullIdOrThrowOnInconsistentIds(inventoryPostingRuleId, cmd);
                cmd.setRequesterId(SecurityContextUtil.getRequesterId());
                inventoryPostingRuleApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            InventoryPostingRuleCommand.CreateInventoryPostingRule cmd = (InventoryPostingRuleCommand.CreateInventoryPostingRule) value.toCommand();
            InventoryPostingRuleResourceUtils.setNullIdOrThrowOnInconsistentIds(inventoryPostingRuleId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            inventoryPostingRuleApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 修改.
     * 修改 InventoryPostingRule
     */
    @PatchMapping("{inventoryPostingRuleId}")
    public void patch(@PathVariable("inventoryPostingRuleId") String inventoryPostingRuleId, @RequestBody CreateOrMergePatchInventoryPostingRuleDto.MergePatchInventoryPostingRuleDto value) {
        try {

            InventoryPostingRuleCommand.MergePatchInventoryPostingRule cmd = value.toMergePatchInventoryPostingRule();
            InventoryPostingRuleResourceUtils.setNullIdOrThrowOnInconsistentIds(inventoryPostingRuleId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            inventoryPostingRuleApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 删除.
     * 删除 InventoryPostingRule
     */
    @DeleteMapping("{inventoryPostingRuleId}")
    public void delete(@PathVariable("inventoryPostingRuleId") String inventoryPostingRuleId,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            InventoryPostingRuleCommand.DeleteInventoryPostingRule deleteCmd = new AbstractInventoryPostingRuleCommand.SimpleDeleteInventoryPostingRule();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            InventoryPostingRuleResourceUtils.setNullIdOrThrowOnInconsistentIds(inventoryPostingRuleId, deleteCmd);
            deleteCmd.setRequesterId(SecurityContextUtil.getRequesterId());
            inventoryPostingRuleApplicationService.when(deleteCmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            InventoryPostingRuleMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{inventoryPostingRuleId}/_events/{version}")
    public InventoryPostingRuleEvent getStateEvent(@PathVariable("inventoryPostingRuleId") String inventoryPostingRuleId, @PathVariable("version") long version) {
        try {

            String idObj = inventoryPostingRuleId;
            //InventoryPostingRuleStateEventDtoConverter dtoConverter = getInventoryPostingRuleStateEventDtoConverter();
            return inventoryPostingRuleApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{inventoryPostingRuleId}/_historyStates/{version}")
    public InventoryPostingRuleStateDto getHistoryState(@PathVariable("inventoryPostingRuleId") String inventoryPostingRuleId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = inventoryPostingRuleId;
            InventoryPostingRuleStateDto.DtoConverter dtoConverter = new InventoryPostingRuleStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryPostingRuleStateDto(inventoryPostingRuleApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    //protected  InventoryPostingRuleStateEventDtoConverter getInventoryPostingRuleStateEventDtoConverter() {
    //    return new InventoryPostingRuleStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return InventoryPostingRuleResourceUtils.getFilterPropertyType(propertyName);
            }
        };
    }

    // ////////////////////////////////
 
    public static class InventoryPostingRuleResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String inventoryPostingRuleId, InventoryPostingRuleCommand value) {
            String idObj = inventoryPostingRuleId;
            if (value.getInventoryPostingRuleId() == null) {
                value.setInventoryPostingRuleId(idObj);
            } else if (!value.getInventoryPostingRuleId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", inventoryPostingRuleId, value.getInventoryPostingRuleId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, InventoryPostingRuleMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, InventoryPostingRuleMetadata.aliasMap);
        }

        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (InventoryPostingRuleMetadata.aliasMap.containsKey(fieldName)) {
                return InventoryPostingRuleMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (InventoryPostingRuleMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = InventoryPostingRuleMetadata.propertyTypeMap.get(propertyName);
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

        public static InventoryPostingRuleStateDto[] toInventoryPostingRuleStateDtoArray(Iterable<String> ids) {
            List<InventoryPostingRuleStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                InventoryPostingRuleStateDto dto = new InventoryPostingRuleStateDto();
                dto.setInventoryPostingRuleId(i);
                states.add(dto);
            });
            return states.toArray(new InventoryPostingRuleStateDto[0]);
        }

    }

}

