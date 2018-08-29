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
import org.dddml.wms.domain.rejectionreason.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "RejectionReasons", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class RejectionReasonResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private RejectionReasonApplicationService rejectionReasonApplicationService;


    /**
     * 查询.
     * 查询 RejectionReasons
     */
    @GetMapping
    public RejectionReasonStateDto[] getAll(@Specification(value = RejectionReasonStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<RejectionReasonState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> RejectionReasonResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (RejectionReasonMetadata.aliasMap.containsKey(n) ? RejectionReasonMetadata.aliasMap.get(n) : n));
            states = rejectionReasonApplicationService.get(
                c,
                RejectionReasonResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            RejectionReasonStateDto.DtoConverter dtoConverter = new RejectionReasonStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toRejectionReasonStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查询.
     * 分页查询 RejectionReasons
     */
    @GetMapping("_page")
    public Page<RejectionReasonStateDto> getPage(@Specification(value = RejectionReasonStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<RejectionReasonState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> RejectionReasonResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (RejectionReasonMetadata.aliasMap.containsKey(n) ? RejectionReasonMetadata.aliasMap.get(n) : n));
            states = rejectionReasonApplicationService.get(
                c,
                RejectionReasonResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = rejectionReasonApplicationService.getCount(c);

            RejectionReasonStateDto.DtoConverter dtoConverter = new RejectionReasonStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<RejectionReasonStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toRejectionReasonStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 RejectionReason
     */
    @GetMapping("{rejectionReasonId}")
    public RejectionReasonStateDto get(@PathVariable("rejectionReasonId") String rejectionReasonId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = rejectionReasonId;
            RejectionReasonState state = rejectionReasonApplicationService.get(idObj);
            if (state == null) { return null; }

            RejectionReasonStateDto.DtoConverter dtoConverter = new RejectionReasonStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toRejectionReasonStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_count")
    public long getCount(@Specification(value = RejectionReasonStateDto.class) HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSONObject.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap());
            }
            count = rejectionReasonApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (RejectionReasonMetadata.aliasMap.containsKey(n) ? RejectionReasonMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 新建.
     * 新建 RejectionReason
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody CreateOrMergePatchRejectionReasonDto.CreateRejectionReasonDto value,  HttpServletResponse response) {
        try {
            RejectionReasonCommand.CreateRejectionReason cmd = value.toCreateRejectionReason();
            if (cmd.getRejectionReasonId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "RejectionReason");
            }
            String idObj = cmd.getRejectionReasonId();
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            rejectionReasonApplicationService.when(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 RejectionReason
     */
    @PutMapping("{rejectionReasonId}")
    public void put(@PathVariable("rejectionReasonId") String rejectionReasonId, @RequestBody CreateOrMergePatchRejectionReasonDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                RejectionReasonCommand.MergePatchRejectionReason cmd = (RejectionReasonCommand.MergePatchRejectionReason) value.toCommand();
                RejectionReasonResourceUtils.setNullIdOrThrowOnInconsistentIds(rejectionReasonId, cmd);
                cmd.setRequesterId(SecurityContextUtil.getRequesterId());
                rejectionReasonApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            RejectionReasonCommand.CreateRejectionReason cmd = (RejectionReasonCommand.CreateRejectionReason) value.toCommand();
            RejectionReasonResourceUtils.setNullIdOrThrowOnInconsistentIds(rejectionReasonId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            rejectionReasonApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 修改.
     * 修改 RejectionReason
     */
    @PatchMapping("{rejectionReasonId}")
    public void patch(@PathVariable("rejectionReasonId") String rejectionReasonId, @RequestBody CreateOrMergePatchRejectionReasonDto.MergePatchRejectionReasonDto value) {
        try {

            RejectionReasonCommand.MergePatchRejectionReason cmd = value.toMergePatchRejectionReason();
            RejectionReasonResourceUtils.setNullIdOrThrowOnInconsistentIds(rejectionReasonId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            rejectionReasonApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 删除.
     * 删除 RejectionReason
     */
    @DeleteMapping("{rejectionReasonId}")
    public void delete(@PathVariable("rejectionReasonId") String rejectionReasonId,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            RejectionReasonCommand.DeleteRejectionReason deleteCmd = new AbstractRejectionReasonCommand.SimpleDeleteRejectionReason();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            RejectionReasonResourceUtils.setNullIdOrThrowOnInconsistentIds(rejectionReasonId, deleteCmd);
            deleteCmd.setRequesterId(SecurityContextUtil.getRequesterId());
            rejectionReasonApplicationService.when(deleteCmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            RejectionReasonMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{rejectionReasonId}/_events/{version}")
    public RejectionReasonEvent getStateEvent(@PathVariable("rejectionReasonId") String rejectionReasonId, @PathVariable("version") long version) {
        try {

            String idObj = rejectionReasonId;
            //RejectionReasonStateEventDtoConverter dtoConverter = getRejectionReasonStateEventDtoConverter();
            return rejectionReasonApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{rejectionReasonId}/_historyStates/{version}")
    public RejectionReasonStateDto getHistoryState(@PathVariable("rejectionReasonId") String rejectionReasonId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = rejectionReasonId;
            RejectionReasonStateDto.DtoConverter dtoConverter = new RejectionReasonStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toRejectionReasonStateDto(rejectionReasonApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    //protected  RejectionReasonStateEventDtoConverter getRejectionReasonStateEventDtoConverter() {
    //    return new RejectionReasonStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return RejectionReasonResourceUtils.getFilterPropertyType(propertyName);
            }
        };
    }

    // ////////////////////////////////
 
    public static class RejectionReasonResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String rejectionReasonId, RejectionReasonCommand value) {
            String idObj = rejectionReasonId;
            if (value.getRejectionReasonId() == null) {
                value.setRejectionReasonId(idObj);
            } else if (!value.getRejectionReasonId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", rejectionReasonId, value.getRejectionReasonId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, RejectionReasonMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, RejectionReasonMetadata.aliasMap);
        }

        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (RejectionReasonMetadata.aliasMap.containsKey(fieldName)) {
                return RejectionReasonMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (RejectionReasonMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = RejectionReasonMetadata.propertyTypeMap.get(propertyName);
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

        public static RejectionReasonStateDto[] toRejectionReasonStateDtoArray(Iterable<String> ids) {
            List<RejectionReasonStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                RejectionReasonStateDto dto = new RejectionReasonStateDto();
                dto.setRejectionReasonId(i);
                states.add(dto);
            });
            return states.toArray(new RejectionReasonStateDto[0]);
        }

    }

}

