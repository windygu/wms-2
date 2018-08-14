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
import org.dddml.wms.domain.attribute.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "Attributes", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class AttributeResource {

    @Autowired
    private IdGenerator<String, ?, ?> attributeIdGenerator;


    @Autowired
    private AttributeApplicationService attributeApplicationService;


    /**
     * 查询.
     * 查询 Attributes
     */
    @GetMapping
    public AttributeStateDto[] getAll( HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<AttributeState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> AttributeResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (AttributeMetadata.aliasMap.containsKey(n) ? AttributeMetadata.aliasMap.get(n) : n));
            states = attributeApplicationService.get(
                c,
                AttributeResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            AttributeStateDto.DtoConverter dtoConverter = new AttributeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查询.
     * 分页查询 Attributes
     */
    @GetMapping("_page")
    public Page<AttributeStateDto> getPage( HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<AttributeState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> AttributeResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (AttributeMetadata.aliasMap.containsKey(n) ? AttributeMetadata.aliasMap.get(n) : n));
            states = attributeApplicationService.get(
                c,
                AttributeResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = attributeApplicationService.getCount(c);

            AttributeStateDto.DtoConverter dtoConverter = new AttributeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<AttributeStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toAttributeStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            statePage.setTotalElements(count);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 Attribute
     */
    @GetMapping("{attributeId}")
    public AttributeStateDto get(@PathVariable("attributeId") String attributeId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = attributeId;
            AttributeState state = attributeApplicationService.get(idObj);
            if (state == null) { return null; }

            AttributeStateDto.DtoConverter dtoConverter = new AttributeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @GetMapping(value = "_nextId", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getNextId() {
        try {
            return attributeIdGenerator.getNextId();
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
            count = attributeApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (AttributeMetadata.aliasMap.containsKey(n) ? AttributeMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 新建.
     * 新建 Attribute
     */
    @PostMapping
    public String post(@RequestBody CreateOrMergePatchAttributeDto.CreateAttributeDto value,  HttpServletResponse response) {
        try {
            AttributeCommand.CreateAttribute cmd = value.toCreateAttribute();
            if (cmd.getAttributeId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "Attribute");
            }
            attributeApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getAttributeId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 Attribute
     */
    @PutMapping("{attributeId}")
    public void put(@PathVariable("attributeId") String attributeId, @RequestBody CreateOrMergePatchAttributeDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                AttributeCommand.MergePatchAttribute cmd = (AttributeCommand.MergePatchAttribute) value.toCommand();
                AttributeResourceUtils.setNullIdOrThrowOnInconsistentIds(attributeId, cmd);
                attributeApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            AttributeCommand.CreateAttribute cmd = (AttributeCommand.CreateAttribute) value.toCommand();
            AttributeResourceUtils.setNullIdOrThrowOnInconsistentIds(attributeId, cmd);
            attributeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 修改.
     * 修改 Attribute
     */
    @PatchMapping("{attributeId}")
    public void patch(@PathVariable("attributeId") String attributeId, @RequestBody CreateOrMergePatchAttributeDto.MergePatchAttributeDto value) {
        try {

            AttributeCommand.MergePatchAttribute cmd = value.toMergePatchAttribute();
            AttributeResourceUtils.setNullIdOrThrowOnInconsistentIds(attributeId, cmd);
            attributeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 删除.
     * 删除 Attribute
     */
    @DeleteMapping("{attributeId}")
    public void delete(@PathVariable("attributeId") String attributeId,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            AttributeCommand.DeleteAttribute deleteCmd = new AbstractAttributeCommand.SimpleDeleteAttribute();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            AttributeResourceUtils.setNullIdOrThrowOnInconsistentIds(attributeId, deleteCmd);
            attributeApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            AttributeMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{attributeId}/_events/{version}")
    public AttributeEvent getStateEvent(@PathVariable("attributeId") String attributeId, @PathVariable("version") long version) {
        try {

            String idObj = attributeId;
            //AttributeStateEventDtoConverter dtoConverter = getAttributeStateEventDtoConverter();
            return attributeApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{attributeId}/_historyStates/{version}")
    public AttributeStateDto getHistoryState(@PathVariable("attributeId") String attributeId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = attributeId;
            AttributeStateDto.DtoConverter dtoConverter = new AttributeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeStateDto(attributeApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 获取指定 Value 的 AttributeValue
     */
    @GetMapping("{attributeId}/AttributeValues/{value}")
    public AttributeValueStateDto getAttributeValue(@PathVariable("attributeId") String attributeId, @PathVariable("value") String value) {
        try {

            AttributeValueState state = attributeApplicationService.getAttributeValue(attributeId, value);
            if (state == null) { return null; }
            AttributeValueStateDto.DtoConverter dtoConverter = new AttributeValueStateDto.DtoConverter();
            AttributeValueStateDto stateDto = dtoConverter.toAttributeValueStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 创建 or 修改.
     * 创建 or 修改 AttributeValue
     */
    @PutMapping(path = "{attributeId}/AttributeValues/{value}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putAttributeValue(@PathVariable("attributeId") String attributeId, @PathVariable("value") String value,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchAttributeValueDto.MergePatchAttributeValueDto body) {
        try {
            AttributeCommand.MergePatchAttribute mergePatchAttribute = new AbstractAttributeCommand.SimpleMergePatchAttribute();
            mergePatchAttribute.setAttributeId(attributeId);
            mergePatchAttribute.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchAttribute.setVersion(version); }
            mergePatchAttribute.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            AttributeValueCommand.MergePatchAttributeValue mergePatchAttributeValue = body.toMergePatchAttributeValue();
            mergePatchAttributeValue.setValue(value);
            mergePatchAttribute.getAttributeValueCommands().add(mergePatchAttributeValue);
            attributeApplicationService.when(mergePatchAttribute);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 移除.
     * 移除 AttributeValue
     */
    @DeleteMapping("{attributeId}/AttributeValues/{value}")
    public void deleteAttributeValue(@PathVariable("attributeId") String attributeId, @PathVariable("value") String value,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            AttributeCommand.MergePatchAttribute mergePatchAttribute = new AbstractAttributeCommand.SimpleMergePatchAttribute();
            mergePatchAttribute.setAttributeId(attributeId);
            mergePatchAttribute.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchAttribute.setVersion(version); }
            mergePatchAttribute.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            AttributeValueCommand.RemoveAttributeValue removeAttributeValue = new AbstractAttributeValueCommand.SimpleRemoveAttributeValue();
            removeAttributeValue.setValue(value);
            mergePatchAttribute.getAttributeValueCommands().add(removeAttributeValue);
            attributeApplicationService.when(mergePatchAttribute);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * AttributeValue List
     */
    @GetMapping("{attributeId}/AttributeValues")
    public AttributeValueStateDto[] getAttributeValues(@PathVariable("attributeId") String attributeId) {
        try {
            Iterable<AttributeValueState> states = attributeApplicationService.getAttributeValues(attributeId);
            if (states == null) { return null; }
            AttributeValueStateDto.DtoConverter dtoConverter = new AttributeValueStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toAttributeValueStateDtoArray(states);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 新建.
     * 新建 AttributeValue
     */
    @PostMapping(path = "{attributeId}/AttributeValues", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postAttributeValues(@PathVariable("attributeId") String attributeId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchAttributeValueDto.CreateAttributeValueDto body) {
        try {
            AttributeCommand.MergePatchAttribute mergePatchAttribute = new AbstractAttributeCommand.SimpleMergePatchAttribute();
            mergePatchAttribute.setAttributeId(attributeId);
            mergePatchAttribute.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchAttribute.setVersion(version); }
            mergePatchAttribute.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            AttributeValueCommand.CreateAttributeValue createAttributeValue = body.toCreateAttributeValue();
            mergePatchAttribute.getAttributeValueCommands().add(createAttributeValue);
            attributeApplicationService.when(mergePatchAttribute);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 获取指定 Code 的 AttributeAlias
     */
    @GetMapping("{attributeId}/AttributeAlias/{code}")
    public AttributeAliasStateDto getAttributeAlias(@PathVariable("attributeId") String attributeId, @PathVariable("code") String code) {
        try {

            AttributeAliasState state = attributeApplicationService.getAttributeAlias(attributeId, code);
            if (state == null) { return null; }
            AttributeAliasStateDto.DtoConverter dtoConverter = new AttributeAliasStateDto.DtoConverter();
            AttributeAliasStateDto stateDto = dtoConverter.toAttributeAliasStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 创建 or 修改.
     * 创建 or 修改 AttributeAlias
     */
    @PutMapping(path = "{attributeId}/AttributeAlias/{code}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putAttributeAlias(@PathVariable("attributeId") String attributeId, @PathVariable("code") String code,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchAttributeAliasDto.MergePatchAttributeAliasDto body) {
        try {
            AttributeCommand.MergePatchAttribute mergePatchAttribute = new AbstractAttributeCommand.SimpleMergePatchAttribute();
            mergePatchAttribute.setAttributeId(attributeId);
            mergePatchAttribute.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchAttribute.setVersion(version); }
            mergePatchAttribute.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            AttributeAliasCommand.MergePatchAttributeAlias mergePatchAttributeAlias = body.toMergePatchAttributeAlias();
            mergePatchAttributeAlias.setCode(code);
            mergePatchAttribute.getAttributeAliasCommands().add(mergePatchAttributeAlias);
            attributeApplicationService.when(mergePatchAttribute);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 移除.
     * 移除 AttributeAlias
     */
    @DeleteMapping("{attributeId}/AttributeAlias/{code}")
    public void deleteAttributeAlias(@PathVariable("attributeId") String attributeId, @PathVariable("code") String code,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            AttributeCommand.MergePatchAttribute mergePatchAttribute = new AbstractAttributeCommand.SimpleMergePatchAttribute();
            mergePatchAttribute.setAttributeId(attributeId);
            mergePatchAttribute.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchAttribute.setVersion(version); }
            mergePatchAttribute.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            AttributeAliasCommand.RemoveAttributeAlias removeAttributeAlias = new AbstractAttributeAliasCommand.SimpleRemoveAttributeAlias();
            removeAttributeAlias.setCode(code);
            mergePatchAttribute.getAttributeAliasCommands().add(removeAttributeAlias);
            attributeApplicationService.when(mergePatchAttribute);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * AttributeAlias List
     */
    @GetMapping("{attributeId}/AttributeAlias")
    public AttributeAliasStateDto[] getAttributeAlias(@PathVariable("attributeId") String attributeId) {
        try {
            Iterable<AttributeAliasState> states = attributeApplicationService.getAttributeAlias(attributeId);
            if (states == null) { return null; }
            AttributeAliasStateDto.DtoConverter dtoConverter = new AttributeAliasStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toAttributeAliasStateDtoArray(states);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 新建.
     * 新建 AttributeAlias
     */
    @PostMapping(path = "{attributeId}/AttributeAlias", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postAttributeAlias(@PathVariable("attributeId") String attributeId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchAttributeAliasDto.CreateAttributeAliasDto body) {
        try {
            AttributeCommand.MergePatchAttribute mergePatchAttribute = new AbstractAttributeCommand.SimpleMergePatchAttribute();
            mergePatchAttribute.setAttributeId(attributeId);
            mergePatchAttribute.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchAttribute.setVersion(version); }
            mergePatchAttribute.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            AttributeAliasCommand.CreateAttributeAlias createAttributeAlias = body.toCreateAttributeAlias();
            mergePatchAttribute.getAttributeAliasCommands().add(createAttributeAlias);
            attributeApplicationService.when(mergePatchAttribute);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  AttributeStateEventDtoConverter getAttributeStateEventDtoConverter() {
    //    return new AttributeStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new AttributePropertyTypeResolver();
    }

    // ////////////////////////////////

    private class AttributePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return AttributeResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class AttributeResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String attributeId, AttributeCommand value) {
            String idObj = attributeId;
            if (value.getAttributeId() == null) {
                value.setAttributeId(idObj);
            } else if (!value.getAttributeId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", attributeId, value.getAttributeId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, AttributeMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, AttributeMetadata.aliasMap);
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (AttributeMetadata.aliasMap.containsKey(fieldName)) {
                return AttributeMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (AttributeMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = AttributeMetadata.propertyTypeMap.get(propertyName);
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

        public static AttributeStateDto[] toAttributeStateDtoArray(Iterable<String> ids) {
            List<AttributeStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                AttributeStateDto dto = new AttributeStateDto();
                dto.setAttributeId(i);
                states.add(dto);
            });
            return states.toArray(new AttributeStateDto[0]);
        }

    }

}

