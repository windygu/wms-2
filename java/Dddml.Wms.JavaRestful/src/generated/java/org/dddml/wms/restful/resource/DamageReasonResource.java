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
import org.dddml.wms.domain.damagereason.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "DamageReasons", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class DamageReasonResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private DamageReasonApplicationService damageReasonApplicationService;


    /**
     * 查询.
     * 查询 DamageReasons
     */
    @GetMapping
    public DamageReasonStateDto[] getAll(@Specification(value = DamageReasonStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<DamageReasonState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> DamageReasonResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (DamageReasonMetadata.aliasMap.containsKey(n) ? DamageReasonMetadata.aliasMap.get(n) : n));
            states = damageReasonApplicationService.get(
                c,
                DamageReasonResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            DamageReasonStateDto.DtoConverter dtoConverter = new DamageReasonStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toDamageReasonStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查询.
     * 分页查询 DamageReasons
     */
    @GetMapping("_page")
    public Page<DamageReasonStateDto> getPage(@Specification(value = DamageReasonStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<DamageReasonState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> DamageReasonResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (DamageReasonMetadata.aliasMap.containsKey(n) ? DamageReasonMetadata.aliasMap.get(n) : n));
            states = damageReasonApplicationService.get(
                c,
                DamageReasonResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = damageReasonApplicationService.getCount(c);

            DamageReasonStateDto.DtoConverter dtoConverter = new DamageReasonStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<DamageReasonStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toDamageReasonStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 DamageReason
     */
    @GetMapping("{damageReasonId}")
    public DamageReasonStateDto get(@PathVariable("damageReasonId") String damageReasonId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = damageReasonId;
            DamageReasonState state = damageReasonApplicationService.get(idObj);
            if (state == null) { return null; }

            DamageReasonStateDto.DtoConverter dtoConverter = new DamageReasonStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toDamageReasonStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_count")
    public long getCount(@Specification(value = DamageReasonStateDto.class) HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSONObject.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap());
            }
            count = damageReasonApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (DamageReasonMetadata.aliasMap.containsKey(n) ? DamageReasonMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 新建.
     * 新建 DamageReason
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody CreateOrMergePatchDamageReasonDto.CreateDamageReasonDto value,  HttpServletResponse response) {
        try {
            DamageReasonCommand.CreateDamageReason cmd = value.toCreateDamageReason();
            if (cmd.getDamageReasonId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "DamageReason");
            }
            String idObj = cmd.getDamageReasonId();
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            damageReasonApplicationService.when(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 DamageReason
     */
    @PutMapping("{damageReasonId}")
    public void put(@PathVariable("damageReasonId") String damageReasonId, @RequestBody CreateOrMergePatchDamageReasonDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                DamageReasonCommand.MergePatchDamageReason cmd = (DamageReasonCommand.MergePatchDamageReason) value.toCommand();
                DamageReasonResourceUtils.setNullIdOrThrowOnInconsistentIds(damageReasonId, cmd);
                cmd.setRequesterId(SecurityContextUtil.getRequesterId());
                damageReasonApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            DamageReasonCommand.CreateDamageReason cmd = (DamageReasonCommand.CreateDamageReason) value.toCommand();
            DamageReasonResourceUtils.setNullIdOrThrowOnInconsistentIds(damageReasonId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            damageReasonApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 修改.
     * 修改 DamageReason
     */
    @PatchMapping("{damageReasonId}")
    public void patch(@PathVariable("damageReasonId") String damageReasonId, @RequestBody CreateOrMergePatchDamageReasonDto.MergePatchDamageReasonDto value) {
        try {

            DamageReasonCommand.MergePatchDamageReason cmd = value.toMergePatchDamageReason();
            DamageReasonResourceUtils.setNullIdOrThrowOnInconsistentIds(damageReasonId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            damageReasonApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 删除.
     * 删除 DamageReason
     */
    @DeleteMapping("{damageReasonId}")
    public void delete(@PathVariable("damageReasonId") String damageReasonId,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            DamageReasonCommand.DeleteDamageReason deleteCmd = new AbstractDamageReasonCommand.SimpleDeleteDamageReason();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            DamageReasonResourceUtils.setNullIdOrThrowOnInconsistentIds(damageReasonId, deleteCmd);
            deleteCmd.setRequesterId(SecurityContextUtil.getRequesterId());
            damageReasonApplicationService.when(deleteCmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            DamageReasonMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{damageReasonId}/_events/{version}")
    public DamageReasonEvent getStateEvent(@PathVariable("damageReasonId") String damageReasonId, @PathVariable("version") long version) {
        try {

            String idObj = damageReasonId;
            //DamageReasonStateEventDtoConverter dtoConverter = getDamageReasonStateEventDtoConverter();
            return damageReasonApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{damageReasonId}/_historyStates/{version}")
    public DamageReasonStateDto getHistoryState(@PathVariable("damageReasonId") String damageReasonId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = damageReasonId;
            DamageReasonStateDto.DtoConverter dtoConverter = new DamageReasonStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toDamageReasonStateDto(damageReasonApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    //protected  DamageReasonStateEventDtoConverter getDamageReasonStateEventDtoConverter() {
    //    return new DamageReasonStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return DamageReasonResourceUtils.getFilterPropertyType(propertyName);
            }
        };
    }

    // ////////////////////////////////
 
    public static class DamageReasonResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String damageReasonId, DamageReasonCommand value) {
            String idObj = damageReasonId;
            if (value.getDamageReasonId() == null) {
                value.setDamageReasonId(idObj);
            } else if (!value.getDamageReasonId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", damageReasonId, value.getDamageReasonId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, DamageReasonMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, DamageReasonMetadata.aliasMap);
        }

        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (DamageReasonMetadata.aliasMap.containsKey(fieldName)) {
                return DamageReasonMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (DamageReasonMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = DamageReasonMetadata.propertyTypeMap.get(propertyName);
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

        public static DamageReasonStateDto[] toDamageReasonStateDtoArray(Iterable<String> ids) {
            List<DamageReasonStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                DamageReasonStateDto dto = new DamageReasonStateDto();
                dto.setDamageReasonId(i);
                states.add(dto);
            });
            return states.toArray(new DamageReasonStateDto[0]);
        }

    }

}

