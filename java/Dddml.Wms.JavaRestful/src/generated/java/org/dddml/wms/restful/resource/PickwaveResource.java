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
import org.dddml.wms.domain.pickwave.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "Pickwaves", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class PickwaveResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private PickwaveApplicationService pickwaveApplicationService;


    /**
     * 查询.
     * 查询 Pickwaves
     */
    @GetMapping
    public PickwaveStateDto[] getAll( HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<PickwaveState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> PickwaveResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (PickwaveMetadata.aliasMap.containsKey(n) ? PickwaveMetadata.aliasMap.get(n) : n));
            states = pickwaveApplicationService.get(
                c,
                PickwaveResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            PickwaveStateDto.DtoConverter dtoConverter = new PickwaveStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPickwaveStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查询.
     * 分页查询 Pickwaves
     */
    @GetMapping("_page")
    public Page<PickwaveStateDto> getPage( HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<PickwaveState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> PickwaveResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (PickwaveMetadata.aliasMap.containsKey(n) ? PickwaveMetadata.aliasMap.get(n) : n));
            states = pickwaveApplicationService.get(
                c,
                PickwaveResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = pickwaveApplicationService.getCount(c);

            PickwaveStateDto.DtoConverter dtoConverter = new PickwaveStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<PickwaveStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toPickwaveStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 Pickwave
     */
    @GetMapping("{pickwaveId}")
    public PickwaveStateDto get(@PathVariable("pickwaveId") Long pickwaveId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            Long idObj = pickwaveId;
            PickwaveState state = pickwaveApplicationService.get(idObj);
            if (state == null) { return null; }

            PickwaveStateDto.DtoConverter dtoConverter = new PickwaveStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPickwaveStateDto(state);

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
            count = pickwaveApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (PickwaveMetadata.aliasMap.containsKey(n) ? PickwaveMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 新建.
     * 新建 Pickwave
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public Long post(@RequestBody CreateOrMergePatchPickwaveDto.CreatePickwaveDto value,  HttpServletResponse response) {
        try {
            PickwaveCommand.CreatePickwave cmd = value.toCreatePickwave();
            if (cmd.getPickwaveId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "Pickwave");
            }
            Long idObj = cmd.getPickwaveId();
            pickwaveApplicationService.when(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 Pickwave
     */
    @PutMapping("{pickwaveId}")
    public void put(@PathVariable("pickwaveId") Long pickwaveId, @RequestBody CreateOrMergePatchPickwaveDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                PickwaveCommand.MergePatchPickwave cmd = (PickwaveCommand.MergePatchPickwave) value.toCommand();
                PickwaveResourceUtils.setNullIdOrThrowOnInconsistentIds(pickwaveId, cmd);
                pickwaveApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            PickwaveCommand.CreatePickwave cmd = (PickwaveCommand.CreatePickwave) value.toCommand();
            PickwaveResourceUtils.setNullIdOrThrowOnInconsistentIds(pickwaveId, cmd);
            pickwaveApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 修改.
     * 修改 Pickwave
     */
    @PatchMapping("{pickwaveId}")
    public void patch(@PathVariable("pickwaveId") Long pickwaveId, @RequestBody CreateOrMergePatchPickwaveDto.MergePatchPickwaveDto value) {
        try {

            PickwaveCommand.MergePatchPickwave cmd = value.toMergePatchPickwave();
            PickwaveResourceUtils.setNullIdOrThrowOnInconsistentIds(pickwaveId, cmd);
            pickwaveApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 删除.
     * 删除 Pickwave
     */
    @DeleteMapping("{pickwaveId}")
    public void delete(@PathVariable("pickwaveId") Long pickwaveId,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            PickwaveCommand.DeletePickwave deleteCmd = new AbstractPickwaveCommand.SimpleDeletePickwave();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            PickwaveResourceUtils.setNullIdOrThrowOnInconsistentIds(pickwaveId, deleteCmd);
            pickwaveApplicationService.when(deleteCmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            PickwaveMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{pickwaveId}/_events/{version}")
    public PickwaveEvent getStateEvent(@PathVariable("pickwaveId") Long pickwaveId, @PathVariable("version") long version) {
        try {

            Long idObj = pickwaveId;
            //PickwaveStateEventDtoConverter dtoConverter = getPickwaveStateEventDtoConverter();
            return pickwaveApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{pickwaveId}/_historyStates/{version}")
    public PickwaveStateDto getHistoryState(@PathVariable("pickwaveId") Long pickwaveId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            Long idObj = pickwaveId;
            PickwaveStateDto.DtoConverter dtoConverter = new PickwaveStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPickwaveStateDto(pickwaveApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  PickwaveStateEventDtoConverter getPickwaveStateEventDtoConverter() {
    //    return new PickwaveStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PickwavePropertyTypeResolver();
    }

    // ////////////////////////////////

    private class PickwavePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return PickwaveResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class PickwaveResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(Long pickwaveId, PickwaveCommand value) {
            Long idObj = pickwaveId;
            if (value.getPickwaveId() == null) {
                value.setPickwaveId(idObj);
            } else if (!value.getPickwaveId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", pickwaveId, value.getPickwaveId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, PickwaveMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, PickwaveMetadata.aliasMap);
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (PickwaveMetadata.aliasMap.containsKey(fieldName)) {
                return PickwaveMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (PickwaveMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = PickwaveMetadata.propertyTypeMap.get(propertyName);
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

        public static PickwaveStateDto[] toPickwaveStateDtoArray(Iterable<Long> ids) {
            List<PickwaveStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                PickwaveStateDto dto = new PickwaveStateDto();
                dto.setPickwaveId(i);
                states.add(dto);
            });
            return states.toArray(new PickwaveStateDto[0]);
        }

    }

}

