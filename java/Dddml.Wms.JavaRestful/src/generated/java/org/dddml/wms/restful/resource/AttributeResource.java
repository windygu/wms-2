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
import org.dddml.wms.domain.attribute.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "Attributes", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class AttributeResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IdGenerator<String, ?, ?> attributeIdGenerator;


    @Autowired
    private AttributeApplicationService attributeApplicationService;


    /**
     * 查询.
     * 查询 Attributes
     */
    @GetMapping
    public AttributeStateDto[] getAll(@Specification(value = AttributeStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }

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

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查询.
     * 分页查询 Attributes
     */
    @GetMapping("_page")
    public Page<AttributeStateDto> getPage(@Specification(value = AttributeStateDto.class) HttpServletRequest request,
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
            Page.PageImpl<AttributeStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toAttributeStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
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

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    @GetMapping(value = "_nextId", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getNextId() {
        try {
            return attributeIdGenerator.getNextId();
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_count")
    public long getCount(@Specification(value = AttributeStateDto.class) HttpServletRequest request,
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

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 新建.
     * 新建 Attribute
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody CreateOrMergePatchAttributeDto.CreateAttributeDto value,  HttpServletResponse response) {
        try {
            AttributeCommand.CreateAttribute cmd = value.toCreateAttribute();
            if (cmd.getAttributeId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "Attribute");
            }
            String idObj = cmd.getAttributeId();
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            attributeApplicationService.when(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
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
                cmd.setRequesterId(SecurityContextUtil.getRequesterId());
                attributeApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            AttributeCommand.CreateAttribute cmd = (AttributeCommand.CreateAttribute) value.toCommand();
            AttributeResourceUtils.setNullIdOrThrowOnInconsistentIds(attributeId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            attributeApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
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
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            attributeApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
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
            deleteCmd.setRequesterId(SecurityContextUtil.getRequesterId());
            attributeApplicationService.when(deleteCmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            AttributeMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{attributeId}/_events/{version}")
    public AttributeEvent getStateEvent(@PathVariable("attributeId") String attributeId, @PathVariable("version") long version) {
        try {

            String idObj = attributeId;
            //AttributeStateEventDtoConverter dtoConverter = getAttributeStateEventDtoConverter();
            return attributeApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
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

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
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

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
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
            mergePatchAttribute.setRequesterId(SecurityContextUtil.getRequesterId());
            attributeApplicationService.when(mergePatchAttribute);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
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
            if (version != null) { 
                mergePatchAttribute.setVersion(version); 
            } else {
                mergePatchAttribute.setVersion(attributeApplicationService.get(attributeId).getVersion());
            }
            mergePatchAttribute.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            AttributeValueCommand.RemoveAttributeValue removeAttributeValue = new AbstractAttributeValueCommand.SimpleRemoveAttributeValue();
            removeAttributeValue.setValue(value);
            mergePatchAttribute.getAttributeValueCommands().add(removeAttributeValue);
            mergePatchAttribute.setRequesterId(SecurityContextUtil.getRequesterId());
            attributeApplicationService.when(mergePatchAttribute);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * AttributeValue List
     */
    @GetMapping("{attributeId}/AttributeValues")
    public AttributeValueStateDto[] getAttributeValues(@PathVariable("attributeId") String attributeId,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "filter", required = false) String filter,
                    @Specification(value = AttributeValueStateDto.class) HttpServletRequest request) {
        try {
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> AttributeResourceUtils.getAttributeValueFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (AttributeValueMetadata.aliasMap.containsKey(n) ? AttributeValueMetadata.aliasMap.get(n) : n));
            Iterable<AttributeValueState> states = attributeApplicationService.getAttributeValues(attributeId, c,
                    AttributeResourceUtils.getAttributeValueQuerySorts(request.getParameterMap()));
            if (states == null) { return null; }
            AttributeValueStateDto.DtoConverter dtoConverter = new AttributeValueStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeValueStateDtoArray(states);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
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
            mergePatchAttribute.setRequesterId(SecurityContextUtil.getRequesterId());
            attributeApplicationService.when(mergePatchAttribute);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
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

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
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
            mergePatchAttribute.setRequesterId(SecurityContextUtil.getRequesterId());
            attributeApplicationService.when(mergePatchAttribute);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
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
            if (version != null) { 
                mergePatchAttribute.setVersion(version); 
            } else {
                mergePatchAttribute.setVersion(attributeApplicationService.get(attributeId).getVersion());
            }
            mergePatchAttribute.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            AttributeAliasCommand.RemoveAttributeAlias removeAttributeAlias = new AbstractAttributeAliasCommand.SimpleRemoveAttributeAlias();
            removeAttributeAlias.setCode(code);
            mergePatchAttribute.getAttributeAliasCommands().add(removeAttributeAlias);
            mergePatchAttribute.setRequesterId(SecurityContextUtil.getRequesterId());
            attributeApplicationService.when(mergePatchAttribute);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * AttributeAlias List
     */
    @GetMapping("{attributeId}/AttributeAlias")
    public AttributeAliasStateDto[] getAttributeAlias(@PathVariable("attributeId") String attributeId,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "filter", required = false) String filter,
                    @Specification(value = AttributeAliasStateDto.class) HttpServletRequest request) {
        try {
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> AttributeResourceUtils.getAttributeAliasFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (AttributeAliasMetadata.aliasMap.containsKey(n) ? AttributeAliasMetadata.aliasMap.get(n) : n));
            Iterable<AttributeAliasState> states = attributeApplicationService.getAttributeAlias(attributeId, c,
                    AttributeResourceUtils.getAttributeAliasQuerySorts(request.getParameterMap()));
            if (states == null) { return null; }
            AttributeAliasStateDto.DtoConverter dtoConverter = new AttributeAliasStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeAliasStateDtoArray(states);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
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
            mergePatchAttribute.setRequesterId(SecurityContextUtil.getRequesterId());
            attributeApplicationService.when(mergePatchAttribute);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    //protected  AttributeStateEventDtoConverter getAttributeStateEventDtoConverter() {
    //    return new AttributeStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return AttributeResourceUtils.getFilterPropertyType(propertyName);
            }
        };
    }

    protected PropertyTypeResolver getAttributeValuePropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return AttributeResourceUtils.getAttributeValueFilterPropertyType(propertyName);
            }
        };
    }

    protected PropertyTypeResolver getAttributeAliasPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return AttributeResourceUtils.getAttributeAliasFilterPropertyType(propertyName);
            }
        };
    }

    // ////////////////////////////////
 
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

        public static List<String> getAttributeValueQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, AttributeValueMetadata.aliasMap);
        }

        public static List<String> getAttributeValueQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, AttributeValueMetadata.aliasMap);
        }

        public static String getAttributeValueFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (AttributeValueMetadata.aliasMap.containsKey(fieldName)) {
                return AttributeValueMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getAttributeValueFilterPropertyType(String propertyName) {
            if (AttributeValueMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = AttributeValueMetadata.propertyTypeMap.get(propertyName);
                if (!StringHelper.isNullOrEmpty(propertyType)) {
                    if (org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.containsKey(propertyType)) {
                        return org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.get(propertyType);
                    }
                }
            }
            return String.class;
        }

        public static Iterable<Map.Entry<String, Object>> getAttributeValueQueryFilterMap(Map<String, String[]> queryNameValuePairs) {
            Map<String, Object> filter = new HashMap<>();
            queryNameValuePairs.forEach((key, values) -> {
                if (values.length > 0) {
                    String pName = getAttributeValueFilterPropertyName(key);
                    if (!StringHelper.isNullOrEmpty(pName)) {
                        Class pClass = getAttributeValueFilterPropertyType(pName);
                        filter.put(pName, ApplicationContext.current.getTypeConverter().convertFromString(pClass, values[0]));
                    }
                }
            });
            return filter.entrySet();
        }

        public static List<String> getAttributeAliasQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, AttributeAliasMetadata.aliasMap);
        }

        public static List<String> getAttributeAliasQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, AttributeAliasMetadata.aliasMap);
        }

        public static String getAttributeAliasFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (AttributeAliasMetadata.aliasMap.containsKey(fieldName)) {
                return AttributeAliasMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getAttributeAliasFilterPropertyType(String propertyName) {
            if (AttributeAliasMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = AttributeAliasMetadata.propertyTypeMap.get(propertyName);
                if (!StringHelper.isNullOrEmpty(propertyType)) {
                    if (org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.containsKey(propertyType)) {
                        return org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.get(propertyType);
                    }
                }
            }
            return String.class;
        }

        public static Iterable<Map.Entry<String, Object>> getAttributeAliasQueryFilterMap(Map<String, String[]> queryNameValuePairs) {
            Map<String, Object> filter = new HashMap<>();
            queryNameValuePairs.forEach((key, values) -> {
                if (values.length > 0) {
                    String pName = getAttributeAliasFilterPropertyName(key);
                    if (!StringHelper.isNullOrEmpty(pName)) {
                        Class pClass = getAttributeAliasFilterPropertyType(pName);
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

