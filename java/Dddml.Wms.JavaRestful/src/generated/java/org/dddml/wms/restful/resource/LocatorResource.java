package org.dddml.wms.restful.resource;

import java.util.*;
import java.util.stream.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.locator.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "Locators", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class LocatorResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private LocatorApplicationService locatorApplicationService;


    /**
     * 查询.
     * 查询 Locators
     */
    @GetMapping
    public LocatorStateDto[] getAll( HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<LocatorState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> LocatorResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (LocatorMetadata.aliasMap.containsKey(n) ? LocatorMetadata.aliasMap.get(n) : n));
            states = locatorApplicationService.get(
                c,
                LocatorResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            LocatorStateDto.DtoConverter dtoConverter = new LocatorStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toLocatorStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查询.
     * 分页查询 Locators
     */
    @GetMapping("_page")
    public Page<LocatorStateDto> getPage( HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<LocatorState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> LocatorResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (LocatorMetadata.aliasMap.containsKey(n) ? LocatorMetadata.aliasMap.get(n) : n));
            states = locatorApplicationService.get(
                c,
                LocatorResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = locatorApplicationService.getCount(c);

            LocatorStateDto.DtoConverter dtoConverter = new LocatorStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<LocatorStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toLocatorStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 Locator
     */
    @GetMapping("{locatorId}")
    public LocatorStateDto get(@PathVariable("locatorId") String locatorId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = locatorId;
            LocatorState state = locatorApplicationService.get(idObj);
            if (state == null) { return null; }

            LocatorStateDto.DtoConverter dtoConverter = new LocatorStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toLocatorStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
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
            count = locatorApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (LocatorMetadata.aliasMap.containsKey(n) ? LocatorMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 新建.
     * 新建 Locator
     */
    @PostMapping
    public String post(@RequestBody CreateOrMergePatchLocatorDto.CreateLocatorDto value,  HttpServletResponse response) {
        try {
            LocatorCommand.CreateLocator cmd = value.toCreateLocator();
            if (cmd.getLocatorId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "Locator");
            }
            String idObj = cmd.getLocatorId();
            locatorApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 Locator
     */
    @PutMapping("{locatorId}")
    public void put(@PathVariable("locatorId") String locatorId, @RequestBody CreateOrMergePatchLocatorDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                LocatorCommand.MergePatchLocator cmd = (LocatorCommand.MergePatchLocator) value.toCommand();
                LocatorResourceUtils.setNullIdOrThrowOnInconsistentIds(locatorId, cmd);
                locatorApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            LocatorCommand.CreateLocator cmd = (LocatorCommand.CreateLocator) value.toCommand();
            LocatorResourceUtils.setNullIdOrThrowOnInconsistentIds(locatorId, cmd);
            locatorApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 修改.
     * 修改 Locator
     */
    @PatchMapping("{locatorId}")
    public void patch(@PathVariable("locatorId") String locatorId, @RequestBody CreateOrMergePatchLocatorDto.MergePatchLocatorDto value) {
        try {

            LocatorCommand.MergePatchLocator cmd = value.toMergePatchLocator();
            LocatorResourceUtils.setNullIdOrThrowOnInconsistentIds(locatorId, cmd);
            locatorApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 删除.
     * 删除 Locator
     */
    @DeleteMapping("{locatorId}")
    public void delete(@PathVariable("locatorId") String locatorId,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            LocatorCommand.DeleteLocator deleteCmd = new AbstractLocatorCommand.SimpleDeleteLocator();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            LocatorResourceUtils.setNullIdOrThrowOnInconsistentIds(locatorId, deleteCmd);
            locatorApplicationService.when(deleteCmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            LocatorMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{locatorId}/_events/{version}")
    public LocatorEvent getStateEvent(@PathVariable("locatorId") String locatorId, @PathVariable("version") long version) {
        try {

            String idObj = locatorId;
            //LocatorStateEventDtoConverter dtoConverter = getLocatorStateEventDtoConverter();
            return locatorApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{locatorId}/_historyStates/{version}")
    public LocatorStateDto getHistoryState(@PathVariable("locatorId") String locatorId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = locatorId;
            LocatorStateDto.DtoConverter dtoConverter = new LocatorStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toLocatorStateDto(locatorApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  LocatorStateEventDtoConverter getLocatorStateEventDtoConverter() {
    //    return new LocatorStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new LocatorPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class LocatorPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return LocatorResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class LocatorResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String locatorId, LocatorCommand value) {
            String idObj = locatorId;
            if (value.getLocatorId() == null) {
                value.setLocatorId(idObj);
            } else if (!value.getLocatorId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", locatorId, value.getLocatorId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, LocatorMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, LocatorMetadata.aliasMap);
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (LocatorMetadata.aliasMap.containsKey(fieldName)) {
                return LocatorMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (LocatorMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = LocatorMetadata.propertyTypeMap.get(propertyName);
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

        public static LocatorStateDto[] toLocatorStateDtoArray(Iterable<String> ids) {
            List<LocatorStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                LocatorStateDto dto = new LocatorStateDto();
                dto.setLocatorId(i);
                states.add(dto);
            });
            return states.toArray(new LocatorStateDto[0]);
        }

    }

}

