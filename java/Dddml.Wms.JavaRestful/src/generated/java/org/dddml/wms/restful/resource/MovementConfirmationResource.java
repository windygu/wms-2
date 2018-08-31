package org.dddml.wms.restful.resource;

import java.util.*;
import java.util.stream.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.annotation.*;
import org.dddml.wms.domain.movementconfirmation.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "MovementConfirmations", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class MovementConfirmationResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private MovementConfirmationApplicationService movementConfirmationApplicationService;


    /**
     * 查询.
     * 查询 MovementConfirmations
     */
    @GetMapping
    public MovementConfirmationStateDto[] getAll(@Specification(value = MovementConfirmationStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }

            Iterable<MovementConfirmationState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> MovementConfirmationResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (MovementConfirmationMetadata.aliasMap.containsKey(n) ? MovementConfirmationMetadata.aliasMap.get(n) : n));
            states = movementConfirmationApplicationService.get(
                c,
                MovementConfirmationResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            MovementConfirmationStateDto.DtoConverter dtoConverter = new MovementConfirmationStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toMovementConfirmationStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查询.
     * 分页查询 MovementConfirmations
     */
    @GetMapping("_page")
    public Page<MovementConfirmationStateDto> getPage(@Specification(value = MovementConfirmationStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<MovementConfirmationState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> MovementConfirmationResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (MovementConfirmationMetadata.aliasMap.containsKey(n) ? MovementConfirmationMetadata.aliasMap.get(n) : n));
            states = movementConfirmationApplicationService.get(
                c,
                MovementConfirmationResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = movementConfirmationApplicationService.getCount(c);

            MovementConfirmationStateDto.DtoConverter dtoConverter = new MovementConfirmationStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<MovementConfirmationStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toMovementConfirmationStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 MovementConfirmation
     */
    @GetMapping("{documentNumber}")
    public MovementConfirmationStateDto get(@PathVariable("documentNumber") String documentNumber, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = documentNumber;
            MovementConfirmationState state = movementConfirmationApplicationService.get(idObj);
            if (state == null) { return null; }

            MovementConfirmationStateDto.DtoConverter dtoConverter = new MovementConfirmationStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toMovementConfirmationStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_count")
    public long getCount(@Specification(value = MovementConfirmationStateDto.class) HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSONObject.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap());
            }
            count = movementConfirmationApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (MovementConfirmationMetadata.aliasMap.containsKey(n) ? MovementConfirmationMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 新建.
     * 新建 MovementConfirmation
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody CreateOrMergePatchMovementConfirmationDto.CreateMovementConfirmationDto value,  HttpServletResponse response) {
        try {
            MovementConfirmationCommand.CreateMovementConfirmation cmd = value.toCreateMovementConfirmation();
            if (cmd.getDocumentNumber() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "MovementConfirmation");
            }
            String idObj = cmd.getDocumentNumber();
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            movementConfirmationApplicationService.when(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 MovementConfirmation
     */
    @PutMapping("{documentNumber}")
    public void put(@PathVariable("documentNumber") String documentNumber, @RequestBody CreateOrMergePatchMovementConfirmationDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                MovementConfirmationCommand.MergePatchMovementConfirmation cmd = (MovementConfirmationCommand.MergePatchMovementConfirmation) value.toCommand();
                MovementConfirmationResourceUtils.setNullIdOrThrowOnInconsistentIds(documentNumber, cmd);
                cmd.setRequesterId(SecurityContextUtil.getRequesterId());
                movementConfirmationApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            MovementConfirmationCommand.CreateMovementConfirmation cmd = (MovementConfirmationCommand.CreateMovementConfirmation) value.toCommand();
            MovementConfirmationResourceUtils.setNullIdOrThrowOnInconsistentIds(documentNumber, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            movementConfirmationApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 修改.
     * 修改 MovementConfirmation
     */
    @PatchMapping("{documentNumber}")
    public void patch(@PathVariable("documentNumber") String documentNumber, @RequestBody CreateOrMergePatchMovementConfirmationDto.MergePatchMovementConfirmationDto value) {
        try {

            MovementConfirmationCommand.MergePatchMovementConfirmation cmd = value.toMergePatchMovementConfirmation();
            MovementConfirmationResourceUtils.setNullIdOrThrowOnInconsistentIds(documentNumber, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            movementConfirmationApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 删除.
     * 删除 MovementConfirmation
     */
    @DeleteMapping("{documentNumber}")
    public void delete(@PathVariable("documentNumber") String documentNumber,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            MovementConfirmationCommand.DeleteMovementConfirmation deleteCmd = new AbstractMovementConfirmationCommand.SimpleDeleteMovementConfirmation();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            MovementConfirmationResourceUtils.setNullIdOrThrowOnInconsistentIds(documentNumber, deleteCmd);
            deleteCmd.setRequesterId(SecurityContextUtil.getRequesterId());
            movementConfirmationApplicationService.when(deleteCmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    @PutMapping("{documentNumber}/_commands/DocumentAction")
    public void documentAction(@PathVariable("documentNumber") String documentNumber, @RequestBody MovementConfirmationCommands.DocumentAction content) {
        try {

            MovementConfirmationCommands.DocumentAction cmd = content;//.toDocumentAction();
            String idObj = documentNumber;
            if (cmd.getDocumentNumber() == null) {
                cmd.setDocumentNumber(idObj);
            } else if (!cmd.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", documentNumber, cmd.getDocumentNumber());
            }
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            movementConfirmationApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            MovementConfirmationMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{documentNumber}/_events/{version}")
    public MovementConfirmationEvent getStateEvent(@PathVariable("documentNumber") String documentNumber, @PathVariable("version") long version) {
        try {

            String idObj = documentNumber;
            //MovementConfirmationStateEventDtoConverter dtoConverter = getMovementConfirmationStateEventDtoConverter();
            return movementConfirmationApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{documentNumber}/_historyStates/{version}")
    public MovementConfirmationStateDto getHistoryState(@PathVariable("documentNumber") String documentNumber, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = documentNumber;
            MovementConfirmationStateDto.DtoConverter dtoConverter = new MovementConfirmationStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toMovementConfirmationStateDto(movementConfirmationApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 获取指定 LineNumber 的 MovementConfirmationLine
     */
    @GetMapping("{documentNumber}/MovementConfirmationLines/{lineNumber}")
    public MovementConfirmationLineStateDto getMovementConfirmationLine(@PathVariable("documentNumber") String documentNumber, @PathVariable("lineNumber") String lineNumber) {
        try {

            MovementConfirmationLineState state = movementConfirmationApplicationService.getMovementConfirmationLine(documentNumber, lineNumber);
            if (state == null) { return null; }
            MovementConfirmationLineStateDto.DtoConverter dtoConverter = new MovementConfirmationLineStateDto.DtoConverter();
            MovementConfirmationLineStateDto stateDto = dtoConverter.toMovementConfirmationLineStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 创建 or 修改.
     * 创建 or 修改 MovementConfirmationLine
     */
    @PutMapping(path = "{documentNumber}/MovementConfirmationLines/{lineNumber}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putMovementConfirmationLine(@PathVariable("documentNumber") String documentNumber, @PathVariable("lineNumber") String lineNumber,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchMovementConfirmationLineDto.MergePatchMovementConfirmationLineDto body) {
        try {
            MovementConfirmationCommand.MergePatchMovementConfirmation mergePatchMovementConfirmation = new AbstractMovementConfirmationCommand.SimpleMergePatchMovementConfirmation();
            mergePatchMovementConfirmation.setDocumentNumber(documentNumber);
            mergePatchMovementConfirmation.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchMovementConfirmation.setVersion(version); }
            mergePatchMovementConfirmation.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            MovementConfirmationLineCommand.MergePatchMovementConfirmationLine mergePatchMovementConfirmationLine = body.toMergePatchMovementConfirmationLine();
            mergePatchMovementConfirmationLine.setLineNumber(lineNumber);
            mergePatchMovementConfirmation.getMovementConfirmationLineCommands().add(mergePatchMovementConfirmationLine);
            mergePatchMovementConfirmation.setRequesterId(SecurityContextUtil.getRequesterId());
            movementConfirmationApplicationService.when(mergePatchMovementConfirmation);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 移除.
     * 移除 MovementConfirmationLine
     */
    @DeleteMapping("{documentNumber}/MovementConfirmationLines/{lineNumber}")
    public void deleteMovementConfirmationLine(@PathVariable("documentNumber") String documentNumber, @PathVariable("lineNumber") String lineNumber,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            MovementConfirmationCommand.MergePatchMovementConfirmation mergePatchMovementConfirmation = new AbstractMovementConfirmationCommand.SimpleMergePatchMovementConfirmation();
            mergePatchMovementConfirmation.setDocumentNumber(documentNumber);
            mergePatchMovementConfirmation.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { 
                mergePatchMovementConfirmation.setVersion(version); 
            } else {
                mergePatchMovementConfirmation.setVersion(movementConfirmationApplicationService.get(documentNumber).getVersion());
            }
            mergePatchMovementConfirmation.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            MovementConfirmationLineCommand.RemoveMovementConfirmationLine removeMovementConfirmationLine = new AbstractMovementConfirmationLineCommand.SimpleRemoveMovementConfirmationLine();
            removeMovementConfirmationLine.setLineNumber(lineNumber);
            mergePatchMovementConfirmation.getMovementConfirmationLineCommands().add(removeMovementConfirmationLine);
            mergePatchMovementConfirmation.setRequesterId(SecurityContextUtil.getRequesterId());
            movementConfirmationApplicationService.when(mergePatchMovementConfirmation);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * MovementConfirmationLine List
     */
    @GetMapping("{documentNumber}/MovementConfirmationLines")
    public MovementConfirmationLineStateDto[] getMovementConfirmationLines(@PathVariable("documentNumber") String documentNumber,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "filter", required = false) String filter,
                    @Specification(value = MovementConfirmationLineStateDto.class) HttpServletRequest request) {
        try {
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> MovementConfirmationResourceUtils.getMovementConfirmationLineFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (MovementConfirmationLineMetadata.aliasMap.containsKey(n) ? MovementConfirmationLineMetadata.aliasMap.get(n) : n));
            Iterable<MovementConfirmationLineState> states = movementConfirmationApplicationService.getMovementConfirmationLines(documentNumber, c,
                    MovementConfirmationResourceUtils.getMovementConfirmationLineQuerySorts(request.getParameterMap()));
            if (states == null) { return null; }
            MovementConfirmationLineStateDto.DtoConverter dtoConverter = new MovementConfirmationLineStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toMovementConfirmationLineStateDtoArray(states);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 新建.
     * 新建 MovementConfirmationLine
     */
    @PostMapping(path = "{documentNumber}/MovementConfirmationLines", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postMovementConfirmationLines(@PathVariable("documentNumber") String documentNumber,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchMovementConfirmationLineDto.CreateMovementConfirmationLineDto body) {
        try {
            MovementConfirmationCommand.MergePatchMovementConfirmation mergePatchMovementConfirmation = new AbstractMovementConfirmationCommand.SimpleMergePatchMovementConfirmation();
            mergePatchMovementConfirmation.setDocumentNumber(documentNumber);
            mergePatchMovementConfirmation.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchMovementConfirmation.setVersion(version); }
            mergePatchMovementConfirmation.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            MovementConfirmationLineCommand.CreateMovementConfirmationLine createMovementConfirmationLine = body.toCreateMovementConfirmationLine();
            mergePatchMovementConfirmation.getMovementConfirmationLineCommands().add(createMovementConfirmationLine);
            mergePatchMovementConfirmation.setRequesterId(SecurityContextUtil.getRequesterId());
            movementConfirmationApplicationService.when(mergePatchMovementConfirmation);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    //protected  MovementConfirmationStateEventDtoConverter getMovementConfirmationStateEventDtoConverter() {
    //    return new MovementConfirmationStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return MovementConfirmationResourceUtils.getFilterPropertyType(propertyName);
            }
        };
    }

    protected PropertyTypeResolver getMovementConfirmationLinePropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return MovementConfirmationResourceUtils.getMovementConfirmationLineFilterPropertyType(propertyName);
            }
        };
    }

    // ////////////////////////////////
 
    public static class MovementConfirmationResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String documentNumber, MovementConfirmationCommand value) {
            String idObj = documentNumber;
            if (value.getDocumentNumber() == null) {
                value.setDocumentNumber(idObj);
            } else if (!value.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", documentNumber, value.getDocumentNumber());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, MovementConfirmationMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, MovementConfirmationMetadata.aliasMap);
        }

        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (MovementConfirmationMetadata.aliasMap.containsKey(fieldName)) {
                return MovementConfirmationMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (MovementConfirmationMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = MovementConfirmationMetadata.propertyTypeMap.get(propertyName);
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

        public static List<String> getMovementConfirmationLineQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, MovementConfirmationLineMetadata.aliasMap);
        }

        public static List<String> getMovementConfirmationLineQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, MovementConfirmationLineMetadata.aliasMap);
        }

        public static String getMovementConfirmationLineFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (MovementConfirmationLineMetadata.aliasMap.containsKey(fieldName)) {
                return MovementConfirmationLineMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getMovementConfirmationLineFilterPropertyType(String propertyName) {
            if (MovementConfirmationLineMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = MovementConfirmationLineMetadata.propertyTypeMap.get(propertyName);
                if (!StringHelper.isNullOrEmpty(propertyType)) {
                    if (org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.containsKey(propertyType)) {
                        return org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.get(propertyType);
                    }
                }
            }
            return String.class;
        }

        public static Iterable<Map.Entry<String, Object>> getMovementConfirmationLineQueryFilterMap(Map<String, String[]> queryNameValuePairs) {
            Map<String, Object> filter = new HashMap<>();
            queryNameValuePairs.forEach((key, values) -> {
                if (values.length > 0) {
                    String pName = getMovementConfirmationLineFilterPropertyName(key);
                    if (!StringHelper.isNullOrEmpty(pName)) {
                        Class pClass = getMovementConfirmationLineFilterPropertyType(pName);
                        filter.put(pName, ApplicationContext.current.getTypeConverter().convertFromString(pClass, values[0]));
                    }
                }
            });
            return filter.entrySet();
        }

        public static MovementConfirmationStateDto[] toMovementConfirmationStateDtoArray(Iterable<String> ids) {
            List<MovementConfirmationStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                MovementConfirmationStateDto dto = new MovementConfirmationStateDto();
                dto.setDocumentNumber(i);
                states.add(dto);
            });
            return states.toArray(new MovementConfirmationStateDto[0]);
        }

    }

}

