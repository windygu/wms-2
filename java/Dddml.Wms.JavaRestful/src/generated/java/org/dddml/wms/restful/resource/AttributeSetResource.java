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
import org.dddml.wms.domain.attributeset.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "AttributeSets", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class AttributeSetResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private AttributeSetApplicationService attributeSetApplicationService;


    /**
     * 查询.
     * 查询 AttributeSets
     */
    @GetMapping
    public AttributeSetStateDto[] getAll(@Specification(value = AttributeSetStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<AttributeSetState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> AttributeSetResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (AttributeSetMetadata.aliasMap.containsKey(n) ? AttributeSetMetadata.aliasMap.get(n) : n));
            states = attributeSetApplicationService.get(
                c,
                AttributeSetResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            AttributeSetStateDto.DtoConverter dtoConverter = new AttributeSetStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeSetStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查询.
     * 分页查询 AttributeSets
     */
    @GetMapping("_page")
    public Page<AttributeSetStateDto> getPage(@Specification(value = AttributeSetStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<AttributeSetState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> AttributeSetResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (AttributeSetMetadata.aliasMap.containsKey(n) ? AttributeSetMetadata.aliasMap.get(n) : n));
            states = attributeSetApplicationService.get(
                c,
                AttributeSetResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = attributeSetApplicationService.getCount(c);

            AttributeSetStateDto.DtoConverter dtoConverter = new AttributeSetStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<AttributeSetStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toAttributeSetStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 AttributeSet
     */
    @GetMapping("{attributeSetId}")
    public AttributeSetStateDto get(@PathVariable("attributeSetId") String attributeSetId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = attributeSetId;
            AttributeSetState state = attributeSetApplicationService.get(idObj);
            if (state == null) { return null; }

            AttributeSetStateDto.DtoConverter dtoConverter = new AttributeSetStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeSetStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount(@Specification(value = AttributeSetStateDto.class) HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSONObject.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap());
            }
            count = attributeSetApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (AttributeSetMetadata.aliasMap.containsKey(n) ? AttributeSetMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 新建.
     * 新建 AttributeSet
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody CreateOrMergePatchAttributeSetDto.CreateAttributeSetDto value,  HttpServletResponse response) {
        try {
            AttributeSetCommand.CreateAttributeSet cmd = value.toCreateAttributeSet();
            if (cmd.getAttributeSetId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "AttributeSet");
            }
            String idObj = cmd.getAttributeSetId();
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            attributeSetApplicationService.when(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 AttributeSet
     */
    @PutMapping("{attributeSetId}")
    public void put(@PathVariable("attributeSetId") String attributeSetId, @RequestBody CreateOrMergePatchAttributeSetDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                AttributeSetCommand.MergePatchAttributeSet cmd = (AttributeSetCommand.MergePatchAttributeSet) value.toCommand();
                AttributeSetResourceUtils.setNullIdOrThrowOnInconsistentIds(attributeSetId, cmd);
                cmd.setRequesterId(SecurityContextUtil.getRequesterId());
                attributeSetApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            AttributeSetCommand.CreateAttributeSet cmd = (AttributeSetCommand.CreateAttributeSet) value.toCommand();
            AttributeSetResourceUtils.setNullIdOrThrowOnInconsistentIds(attributeSetId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            attributeSetApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 修改.
     * 修改 AttributeSet
     */
    @PatchMapping("{attributeSetId}")
    public void patch(@PathVariable("attributeSetId") String attributeSetId, @RequestBody CreateOrMergePatchAttributeSetDto.MergePatchAttributeSetDto value) {
        try {

            AttributeSetCommand.MergePatchAttributeSet cmd = value.toMergePatchAttributeSet();
            AttributeSetResourceUtils.setNullIdOrThrowOnInconsistentIds(attributeSetId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            attributeSetApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 删除.
     * 删除 AttributeSet
     */
    @DeleteMapping("{attributeSetId}")
    public void delete(@PathVariable("attributeSetId") String attributeSetId,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            AttributeSetCommand.DeleteAttributeSet deleteCmd = new AbstractAttributeSetCommand.SimpleDeleteAttributeSet();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            AttributeSetResourceUtils.setNullIdOrThrowOnInconsistentIds(attributeSetId, deleteCmd);
            deleteCmd.setRequesterId(SecurityContextUtil.getRequesterId());
            attributeSetApplicationService.when(deleteCmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            AttributeSetMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{attributeSetId}/_events/{version}")
    public AttributeSetEvent getStateEvent(@PathVariable("attributeSetId") String attributeSetId, @PathVariable("version") long version) {
        try {

            String idObj = attributeSetId;
            //AttributeSetStateEventDtoConverter dtoConverter = getAttributeSetStateEventDtoConverter();
            return attributeSetApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{attributeSetId}/_historyStates/{version}")
    public AttributeSetStateDto getHistoryState(@PathVariable("attributeSetId") String attributeSetId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = attributeSetId;
            AttributeSetStateDto.DtoConverter dtoConverter = new AttributeSetStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeSetStateDto(attributeSetApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 获取指定 AttributeId 的 AttributeUse
     */
    @GetMapping("{attributeSetId}/AttributeUses/{attributeId}")
    public AttributeUseStateDto getAttributeUse(@PathVariable("attributeSetId") String attributeSetId, @PathVariable("attributeId") String attributeId) {
        try {

            AttributeUseState state = attributeSetApplicationService.getAttributeUse(attributeSetId, attributeId);
            if (state == null) { return null; }
            AttributeUseStateDto.DtoConverter dtoConverter = new AttributeUseStateDto.DtoConverter();
            AttributeUseStateDto stateDto = dtoConverter.toAttributeUseStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 创建 or 修改.
     * 创建 or 修改 AttributeUse
     */
    @PutMapping(path = "{attributeSetId}/AttributeUses/{attributeId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putAttributeUse(@PathVariable("attributeSetId") String attributeSetId, @PathVariable("attributeId") String attributeId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchAttributeUseDto.MergePatchAttributeUseDto body) {
        try {
            AttributeSetCommand.MergePatchAttributeSet mergePatchAttributeSet = new AbstractAttributeSetCommand.SimpleMergePatchAttributeSet();
            mergePatchAttributeSet.setAttributeSetId(attributeSetId);
            mergePatchAttributeSet.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchAttributeSet.setVersion(version); }
            mergePatchAttributeSet.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            AttributeUseCommand.MergePatchAttributeUse mergePatchAttributeUse = body.toMergePatchAttributeUse();
            mergePatchAttributeUse.setAttributeId(attributeId);
            mergePatchAttributeSet.getAttributeUseCommands().add(mergePatchAttributeUse);
            mergePatchAttributeSet.setRequesterId(SecurityContextUtil.getRequesterId());
            attributeSetApplicationService.when(mergePatchAttributeSet);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 移除.
     * 移除 AttributeUse
     */
    @DeleteMapping("{attributeSetId}/AttributeUses/{attributeId}")
    public void deleteAttributeUse(@PathVariable("attributeSetId") String attributeSetId, @PathVariable("attributeId") String attributeId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            AttributeSetCommand.MergePatchAttributeSet mergePatchAttributeSet = new AbstractAttributeSetCommand.SimpleMergePatchAttributeSet();
            mergePatchAttributeSet.setAttributeSetId(attributeSetId);
            mergePatchAttributeSet.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { 
                mergePatchAttributeSet.setVersion(version); 
            } else {
                mergePatchAttributeSet.setVersion(attributeSetApplicationService.get(attributeSetId).getVersion());
            }
            mergePatchAttributeSet.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            AttributeUseCommand.RemoveAttributeUse removeAttributeUse = new AbstractAttributeUseCommand.SimpleRemoveAttributeUse();
            removeAttributeUse.setAttributeId(attributeId);
            mergePatchAttributeSet.getAttributeUseCommands().add(removeAttributeUse);
            mergePatchAttributeSet.setRequesterId(SecurityContextUtil.getRequesterId());
            attributeSetApplicationService.when(mergePatchAttributeSet);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * AttributeUse List
     */
    @GetMapping("{attributeSetId}/AttributeUses")
    public AttributeUseStateDto[] getAttributeUses(@PathVariable("attributeSetId") String attributeSetId) {
        try {
            Iterable<AttributeUseState> states = attributeSetApplicationService.getAttributeUses(attributeSetId);
            if (states == null) { return null; }
            AttributeUseStateDto.DtoConverter dtoConverter = new AttributeUseStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toAttributeUseStateDtoArray(states);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 新建.
     * 新建 AttributeUse
     */
    @PostMapping(path = "{attributeSetId}/AttributeUses", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postAttributeUses(@PathVariable("attributeSetId") String attributeSetId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchAttributeUseDto.CreateAttributeUseDto body) {
        try {
            AttributeSetCommand.MergePatchAttributeSet mergePatchAttributeSet = new AbstractAttributeSetCommand.SimpleMergePatchAttributeSet();
            mergePatchAttributeSet.setAttributeSetId(attributeSetId);
            mergePatchAttributeSet.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchAttributeSet.setVersion(version); }
            mergePatchAttributeSet.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            AttributeUseCommand.CreateAttributeUse createAttributeUse = body.toCreateAttributeUse();
            mergePatchAttributeSet.getAttributeUseCommands().add(createAttributeUse);
            mergePatchAttributeSet.setRequesterId(SecurityContextUtil.getRequesterId());
            attributeSetApplicationService.when(mergePatchAttributeSet);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  AttributeSetStateEventDtoConverter getAttributeSetStateEventDtoConverter() {
    //    return new AttributeSetStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new AttributeSetPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class AttributeSetPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return AttributeSetResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class AttributeSetResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String attributeSetId, AttributeSetCommand value) {
            String idObj = attributeSetId;
            if (value.getAttributeSetId() == null) {
                value.setAttributeSetId(idObj);
            } else if (!value.getAttributeSetId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", attributeSetId, value.getAttributeSetId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, AttributeSetMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, AttributeSetMetadata.aliasMap);
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (AttributeSetMetadata.aliasMap.containsKey(fieldName)) {
                return AttributeSetMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (AttributeSetMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = AttributeSetMetadata.propertyTypeMap.get(propertyName);
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

        public static AttributeSetStateDto[] toAttributeSetStateDtoArray(Iterable<String> ids) {
            List<AttributeSetStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                AttributeSetStateDto dto = new AttributeSetStateDto();
                dto.setAttributeSetId(i);
                states.add(dto);
            });
            return states.toArray(new AttributeSetStateDto[0]);
        }

    }

}

