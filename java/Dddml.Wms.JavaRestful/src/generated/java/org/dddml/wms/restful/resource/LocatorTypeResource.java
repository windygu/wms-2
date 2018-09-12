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
import org.dddml.wms.domain.locatortype.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "LocatorTypes", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class LocatorTypeResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private LocatorTypeApplicationService locatorTypeApplicationService;


    /**
     * 查询.
     * 查询 LocatorTypes
     */
    @GetMapping
    public LocatorTypeStateDto[] getAll(@Specification(value = LocatorTypeStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }

            Iterable<LocatorTypeState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> LocatorTypeResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (LocatorTypeMetadata.aliasMap.containsKey(n) ? LocatorTypeMetadata.aliasMap.get(n) : n));
            states = locatorTypeApplicationService.get(
                c,
                LocatorTypeResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            LocatorTypeStateDto.DtoConverter dtoConverter = new LocatorTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toLocatorTypeStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查询.
     * 分页查询 LocatorTypes
     */
    @GetMapping("_page")
    public Page<LocatorTypeStateDto> getPage(@Specification(value = LocatorTypeStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<LocatorTypeState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> LocatorTypeResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (LocatorTypeMetadata.aliasMap.containsKey(n) ? LocatorTypeMetadata.aliasMap.get(n) : n));
            states = locatorTypeApplicationService.get(
                c,
                LocatorTypeResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = locatorTypeApplicationService.getCount(c);

            LocatorTypeStateDto.DtoConverter dtoConverter = new LocatorTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<LocatorTypeStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toLocatorTypeStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 LocatorType
     */
    @GetMapping("{locatorTypeId}")
    public LocatorTypeStateDto get(@PathVariable("locatorTypeId") String locatorTypeId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = locatorTypeId;
            LocatorTypeState state = locatorTypeApplicationService.get(idObj);
            if (state == null) { return null; }

            LocatorTypeStateDto.DtoConverter dtoConverter = new LocatorTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toLocatorTypeStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_count")
    public long getCount(@Specification(value = LocatorTypeStateDto.class) HttpServletRequest request,
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
                n -> (LocatorTypeMetadata.aliasMap.containsKey(n) ? LocatorTypeMetadata.aliasMap.get(n) : n));
            count = locatorTypeApplicationService.getCount(c);
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 新建.
     * 新建 LocatorType
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody CreateOrMergePatchLocatorTypeDto.CreateLocatorTypeDto value,  HttpServletResponse response) {
        try {
            LocatorTypeCommand.CreateLocatorType cmd = value.toCreateLocatorType();
            if (cmd.getLocatorTypeId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "LocatorType");
            }
            String idObj = cmd.getLocatorTypeId();
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            locatorTypeApplicationService.when(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 LocatorType
     */
    @PutMapping("{locatorTypeId}")
    public void put(@PathVariable("locatorTypeId") String locatorTypeId, @RequestBody CreateOrMergePatchLocatorTypeDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                LocatorTypeCommand.MergePatchLocatorType cmd = (LocatorTypeCommand.MergePatchLocatorType) value.toCommand();
                LocatorTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(locatorTypeId, cmd);
                cmd.setRequesterId(SecurityContextUtil.getRequesterId());
                locatorTypeApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            LocatorTypeCommand.CreateLocatorType cmd = (LocatorTypeCommand.CreateLocatorType) value.toCommand();
            LocatorTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(locatorTypeId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            locatorTypeApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 修改.
     * 修改 LocatorType
     */
    @PatchMapping("{locatorTypeId}")
    public void patch(@PathVariable("locatorTypeId") String locatorTypeId, @RequestBody CreateOrMergePatchLocatorTypeDto.MergePatchLocatorTypeDto value) {
        try {

            LocatorTypeCommand.MergePatchLocatorType cmd = value.toMergePatchLocatorType();
            LocatorTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(locatorTypeId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            locatorTypeApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 删除.
     * 删除 LocatorType
     */
    @DeleteMapping("{locatorTypeId}")
    public void delete(@PathVariable("locatorTypeId") String locatorTypeId,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            LocatorTypeCommand.DeleteLocatorType deleteCmd = new AbstractLocatorTypeCommand.SimpleDeleteLocatorType();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            LocatorTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(locatorTypeId, deleteCmd);
            deleteCmd.setRequesterId(SecurityContextUtil.getRequesterId());
            locatorTypeApplicationService.when(deleteCmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            LocatorTypeMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{locatorTypeId}/_events/{version}")
    public LocatorTypeEvent getStateEvent(@PathVariable("locatorTypeId") String locatorTypeId, @PathVariable("version") long version) {
        try {

            String idObj = locatorTypeId;
            //LocatorTypeStateEventDtoConverter dtoConverter = getLocatorTypeStateEventDtoConverter();
            return locatorTypeApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{locatorTypeId}/_historyStates/{version}")
    public LocatorTypeStateDto getHistoryState(@PathVariable("locatorTypeId") String locatorTypeId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = locatorTypeId;
            LocatorTypeStateDto.DtoConverter dtoConverter = new LocatorTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toLocatorTypeStateDto(locatorTypeApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    //protected  LocatorTypeStateEventDtoConverter getLocatorTypeStateEventDtoConverter() {
    //    return new LocatorTypeStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return LocatorTypeResourceUtils.getFilterPropertyType(propertyName);
            }
        };
    }

    // ////////////////////////////////
 
    public static class LocatorTypeResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String locatorTypeId, LocatorTypeCommand value) {
            String idObj = locatorTypeId;
            if (value.getLocatorTypeId() == null) {
                value.setLocatorTypeId(idObj);
            } else if (!value.getLocatorTypeId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", locatorTypeId, value.getLocatorTypeId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, LocatorTypeMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, LocatorTypeMetadata.aliasMap);
        }

        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (LocatorTypeMetadata.aliasMap.containsKey(fieldName)) {
                return LocatorTypeMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (LocatorTypeMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = LocatorTypeMetadata.propertyTypeMap.get(propertyName);
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

        public static LocatorTypeStateDto[] toLocatorTypeStateDtoArray(Iterable<String> ids) {
            List<LocatorTypeStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                LocatorTypeStateDto dto = new LocatorTypeStateDto();
                dto.setLocatorTypeId(i);
                states.add(dto);
            });
            return states.toArray(new LocatorTypeStateDto[0]);
        }

    }

}

