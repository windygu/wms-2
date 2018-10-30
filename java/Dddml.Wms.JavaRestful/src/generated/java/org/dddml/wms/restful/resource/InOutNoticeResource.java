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
import org.dddml.wms.domain.inoutnotice.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "InOutNotices", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class InOutNoticeResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private InOutNoticeApplicationService inOutNoticeApplicationService;


    /**
     * 查询.
     * 查询 InOutNotices
     */
    @GetMapping
    public InOutNoticeStateDto[] getAll(@Specification(value = InOutNoticeStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }

            Iterable<InOutNoticeState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> InOutNoticeResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (InOutNoticeMetadata.aliasMap.containsKey(n) ? InOutNoticeMetadata.aliasMap.get(n) : n));
            states = inOutNoticeApplicationService.get(
                c,
                InOutNoticeResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            InOutNoticeStateDto.DtoConverter dtoConverter = new InOutNoticeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInOutNoticeStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查询.
     * 分页查询 InOutNotices
     */
    @GetMapping("_page")
    public Page<InOutNoticeStateDto> getPage(@Specification(value = InOutNoticeStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * (size == null ? 20 : size);
            Integer maxResults = (size == null ? 20 : size);
            Iterable<InOutNoticeState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> InOutNoticeResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (InOutNoticeMetadata.aliasMap.containsKey(n) ? InOutNoticeMetadata.aliasMap.get(n) : n));
            states = inOutNoticeApplicationService.get(
                c,
                InOutNoticeResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = inOutNoticeApplicationService.getCount(c);

            InOutNoticeStateDto.DtoConverter dtoConverter = new InOutNoticeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<InOutNoticeStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toInOutNoticeStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 InOutNotice
     */
    @GetMapping("{inOutNoticeId}")
    public InOutNoticeStateDto get(@PathVariable("inOutNoticeId") String inOutNoticeId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = inOutNoticeId;
            InOutNoticeState state = inOutNoticeApplicationService.get(idObj);
            if (state == null) { return null; }

            InOutNoticeStateDto.DtoConverter dtoConverter = new InOutNoticeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInOutNoticeStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_count")
    public long getCount(@Specification(value = InOutNoticeStateDto.class) HttpServletRequest request,
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
                n -> (InOutNoticeMetadata.aliasMap.containsKey(n) ? InOutNoticeMetadata.aliasMap.get(n) : n));
            count = inOutNoticeApplicationService.getCount(c);
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 新建.
     * 新建 InOutNotice
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody CreateOrMergePatchInOutNoticeDto.CreateInOutNoticeDto value,  HttpServletResponse response) {
        try {
            InOutNoticeCommand.CreateInOutNotice cmd = value.toCreateInOutNotice();
            if (cmd.getInOutNoticeId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "InOutNotice");
            }
            String idObj = cmd.getInOutNoticeId();
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            inOutNoticeApplicationService.when(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 InOutNotice
     */
    @PutMapping("{inOutNoticeId}")
    public void put(@PathVariable("inOutNoticeId") String inOutNoticeId, @RequestBody CreateOrMergePatchInOutNoticeDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                InOutNoticeCommand.MergePatchInOutNotice cmd = (InOutNoticeCommand.MergePatchInOutNotice) value.toCommand();
                InOutNoticeResourceUtils.setNullIdOrThrowOnInconsistentIds(inOutNoticeId, cmd);
                cmd.setRequesterId(SecurityContextUtil.getRequesterId());
                inOutNoticeApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            InOutNoticeCommand.CreateInOutNotice cmd = (InOutNoticeCommand.CreateInOutNotice) value.toCommand();
            InOutNoticeResourceUtils.setNullIdOrThrowOnInconsistentIds(inOutNoticeId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            inOutNoticeApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 修改.
     * 修改 InOutNotice
     */
    @PatchMapping("{inOutNoticeId}")
    public void patch(@PathVariable("inOutNoticeId") String inOutNoticeId, @RequestBody CreateOrMergePatchInOutNoticeDto.MergePatchInOutNoticeDto value) {
        try {

            InOutNoticeCommand.MergePatchInOutNotice cmd = value.toMergePatchInOutNotice();
            InOutNoticeResourceUtils.setNullIdOrThrowOnInconsistentIds(inOutNoticeId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            inOutNoticeApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 删除.
     * 删除 InOutNotice
     */
    @DeleteMapping("{inOutNoticeId}")
    public void delete(@PathVariable("inOutNoticeId") String inOutNoticeId,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            InOutNoticeCommand.DeleteInOutNotice deleteCmd = new AbstractInOutNoticeCommand.SimpleDeleteInOutNotice();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            InOutNoticeResourceUtils.setNullIdOrThrowOnInconsistentIds(inOutNoticeId, deleteCmd);
            deleteCmd.setRequesterId(SecurityContextUtil.getRequesterId());
            inOutNoticeApplicationService.when(deleteCmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    @PutMapping("{inOutNoticeId}/_commands/InOutNoticeAction")
    public void inOutNoticeAction(@PathVariable("inOutNoticeId") String inOutNoticeId, @RequestBody InOutNoticeCommands.InOutNoticeAction content) {
        try {

            InOutNoticeCommands.InOutNoticeAction cmd = content;//.toInOutNoticeAction();
            String idObj = inOutNoticeId;
            if (cmd.getInOutNoticeId() == null) {
                cmd.setInOutNoticeId(idObj);
            } else if (!cmd.getInOutNoticeId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", inOutNoticeId, cmd.getInOutNoticeId());
            }
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            inOutNoticeApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            InOutNoticeMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{inOutNoticeId}/_events/{version}")
    public InOutNoticeEvent getStateEvent(@PathVariable("inOutNoticeId") String inOutNoticeId, @PathVariable("version") long version) {
        try {

            String idObj = inOutNoticeId;
            //InOutNoticeStateEventDtoConverter dtoConverter = getInOutNoticeStateEventDtoConverter();
            return inOutNoticeApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{inOutNoticeId}/_historyStates/{version}")
    public InOutNoticeStateDto getHistoryState(@PathVariable("inOutNoticeId") String inOutNoticeId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = inOutNoticeId;
            InOutNoticeStateDto.DtoConverter dtoConverter = new InOutNoticeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInOutNoticeStateDto(inOutNoticeApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    //protected  InOutNoticeStateEventDtoConverter getInOutNoticeStateEventDtoConverter() {
    //    return new InOutNoticeStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return InOutNoticeResourceUtils.getFilterPropertyType(propertyName);
            }
        };
    }

    // ////////////////////////////////
 
    public static class InOutNoticeResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String inOutNoticeId, InOutNoticeCommand value) {
            String idObj = inOutNoticeId;
            if (value.getInOutNoticeId() == null) {
                value.setInOutNoticeId(idObj);
            } else if (!value.getInOutNoticeId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", inOutNoticeId, value.getInOutNoticeId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, InOutNoticeMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, InOutNoticeMetadata.aliasMap);
        }

        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (InOutNoticeMetadata.aliasMap.containsKey(fieldName)) {
                return InOutNoticeMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (InOutNoticeMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = InOutNoticeMetadata.propertyTypeMap.get(propertyName);
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

        public static InOutNoticeStateDto[] toInOutNoticeStateDtoArray(Iterable<String> ids) {
            List<InOutNoticeStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                InOutNoticeStateDto dto = new InOutNoticeStateDto();
                dto.setInOutNoticeId(i);
                states.add(dto);
            });
            return states.toArray(new InOutNoticeStateDto[0]);
        }

    }

}

