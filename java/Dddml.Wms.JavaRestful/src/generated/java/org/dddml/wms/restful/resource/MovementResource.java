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
import java.math.BigDecimal;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.annotation.*;
import org.dddml.wms.domain.movement.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "Movements", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class MovementResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private MovementApplicationService movementApplicationService;


    /**
     * 查询.
     * 查询 Movements
     */
    @GetMapping
    public MovementStateDto[] getAll(@Specification(value = MovementStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<MovementState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> MovementResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (MovementMetadata.aliasMap.containsKey(n) ? MovementMetadata.aliasMap.get(n) : n));
            states = movementApplicationService.get(
                c,
                MovementResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            MovementStateDto.DtoConverter dtoConverter = new MovementStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toMovementStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查询.
     * 分页查询 Movements
     */
    @GetMapping("_page")
    public Page<MovementStateDto> getPage(@Specification(value = MovementStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<MovementState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> MovementResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (MovementMetadata.aliasMap.containsKey(n) ? MovementMetadata.aliasMap.get(n) : n));
            states = movementApplicationService.get(
                c,
                MovementResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = movementApplicationService.getCount(c);

            MovementStateDto.DtoConverter dtoConverter = new MovementStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<MovementStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toMovementStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 Movement
     */
    @GetMapping("{documentNumber}")
    public MovementStateDto get(@PathVariable("documentNumber") String documentNumber, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = documentNumber;
            MovementState state = movementApplicationService.get(idObj);
            if (state == null) { return null; }

            MovementStateDto.DtoConverter dtoConverter = new MovementStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toMovementStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount(@Specification(value = MovementStateDto.class) HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSONObject.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap());
            }
            count = movementApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (MovementMetadata.aliasMap.containsKey(n) ? MovementMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 新建.
     * 新建 Movement
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody CreateOrMergePatchMovementDto.CreateMovementDto value,  HttpServletResponse response) {
        try {
            MovementCommand.CreateMovement cmd = value.toCreateMovement();
            if (cmd.getDocumentNumber() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "Movement");
            }
            String idObj = cmd.getDocumentNumber();
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            movementApplicationService.when(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 Movement
     */
    @PutMapping("{documentNumber}")
    public void put(@PathVariable("documentNumber") String documentNumber, @RequestBody CreateOrMergePatchMovementDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                MovementCommand.MergePatchMovement cmd = (MovementCommand.MergePatchMovement) value.toCommand();
                MovementResourceUtils.setNullIdOrThrowOnInconsistentIds(documentNumber, cmd);
                cmd.setRequesterId(SecurityContextUtil.getRequesterId());
                movementApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            MovementCommand.CreateMovement cmd = (MovementCommand.CreateMovement) value.toCommand();
            MovementResourceUtils.setNullIdOrThrowOnInconsistentIds(documentNumber, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            movementApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 修改.
     * 修改 Movement
     */
    @PatchMapping("{documentNumber}")
    public void patch(@PathVariable("documentNumber") String documentNumber, @RequestBody CreateOrMergePatchMovementDto.MergePatchMovementDto value) {
        try {

            MovementCommand.MergePatchMovement cmd = value.toMergePatchMovement();
            MovementResourceUtils.setNullIdOrThrowOnInconsistentIds(documentNumber, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            movementApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 删除.
     * 删除 Movement
     */
    @DeleteMapping("{documentNumber}")
    public void delete(@PathVariable("documentNumber") String documentNumber,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            MovementCommand.DeleteMovement deleteCmd = new AbstractMovementCommand.SimpleDeleteMovement();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            MovementResourceUtils.setNullIdOrThrowOnInconsistentIds(documentNumber, deleteCmd);
            deleteCmd.setRequesterId(SecurityContextUtil.getRequesterId());
            movementApplicationService.when(deleteCmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{documentNumber}/_commands/AddLine")
    public void addLine(@PathVariable("documentNumber") String documentNumber, @RequestBody MovementCommands.AddLine content) {
        try {

            MovementCommands.AddLine cmd = content;//.toAddLine();
            String idObj = documentNumber;
            if (cmd.getDocumentNumber() == null) {
                cmd.setDocumentNumber(idObj);
            } else if (!cmd.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", documentNumber, cmd.getDocumentNumber());
            }
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            movementApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{documentNumber}/_commands/DocumentAction")
    public void documentAction(@PathVariable("documentNumber") String documentNumber, @RequestBody MovementCommands.DocumentAction content) {
        try {

            MovementCommands.DocumentAction cmd = content;//.toDocumentAction();
            String idObj = documentNumber;
            if (cmd.getDocumentNumber() == null) {
                cmd.setDocumentNumber(idObj);
            } else if (!cmd.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", documentNumber, cmd.getDocumentNumber());
            }
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            movementApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            MovementMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{documentNumber}/_events/{version}")
    public MovementEvent getStateEvent(@PathVariable("documentNumber") String documentNumber, @PathVariable("version") long version) {
        try {

            String idObj = documentNumber;
            //MovementStateEventDtoConverter dtoConverter = getMovementStateEventDtoConverter();
            return movementApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{documentNumber}/_historyStates/{version}")
    public MovementStateDto getHistoryState(@PathVariable("documentNumber") String documentNumber, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = documentNumber;
            MovementStateDto.DtoConverter dtoConverter = new MovementStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toMovementStateDto(movementApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 获取指定 LineNumber 的 MovementLine
     */
    @GetMapping("{documentNumber}/MovementLines/{lineNumber}")
    public MovementLineStateDto getMovementLine(@PathVariable("documentNumber") String documentNumber, @PathVariable("lineNumber") String lineNumber) {
        try {

            MovementLineState state = movementApplicationService.getMovementLine(documentNumber, lineNumber);
            if (state == null) { return null; }
            MovementLineStateDto.DtoConverter dtoConverter = new MovementLineStateDto.DtoConverter();
            MovementLineStateDto stateDto = dtoConverter.toMovementLineStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 创建 or 修改.
     * 创建 or 修改 MovementLine
     */
    @PutMapping(path = "{documentNumber}/MovementLines/{lineNumber}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putMovementLine(@PathVariable("documentNumber") String documentNumber, @PathVariable("lineNumber") String lineNumber,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchMovementLineDto.MergePatchMovementLineDto body) {
        try {
            MovementCommand.MergePatchMovement mergePatchMovement = new AbstractMovementCommand.SimpleMergePatchMovement();
            mergePatchMovement.setDocumentNumber(documentNumber);
            mergePatchMovement.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchMovement.setVersion(version); }
            mergePatchMovement.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            MovementLineCommand.MergePatchMovementLine mergePatchMovementLine = body.toMergePatchMovementLine();
            mergePatchMovementLine.setLineNumber(lineNumber);
            mergePatchMovement.getMovementLineCommands().add(mergePatchMovementLine);
            mergePatchMovement.setRequesterId(SecurityContextUtil.getRequesterId());
            movementApplicationService.when(mergePatchMovement);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 移除.
     * 移除 MovementLine
     */
    @DeleteMapping("{documentNumber}/MovementLines/{lineNumber}")
    public void deleteMovementLine(@PathVariable("documentNumber") String documentNumber, @PathVariable("lineNumber") String lineNumber,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            MovementCommand.MergePatchMovement mergePatchMovement = new AbstractMovementCommand.SimpleMergePatchMovement();
            mergePatchMovement.setDocumentNumber(documentNumber);
            mergePatchMovement.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { 
                mergePatchMovement.setVersion(version); 
            } else {
                mergePatchMovement.setVersion(movementApplicationService.get(documentNumber).getVersion());
            }
            mergePatchMovement.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            MovementLineCommand.RemoveMovementLine removeMovementLine = new AbstractMovementLineCommand.SimpleRemoveMovementLine();
            removeMovementLine.setLineNumber(lineNumber);
            mergePatchMovement.getMovementLineCommands().add(removeMovementLine);
            mergePatchMovement.setRequesterId(SecurityContextUtil.getRequesterId());
            movementApplicationService.when(mergePatchMovement);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * MovementLine List
     */
    @GetMapping("{documentNumber}/MovementLines")
    public MovementLineStateDto[] getMovementLines(@PathVariable("documentNumber") String documentNumber,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "filter", required = false) String filter,
                    @Specification(value = MovementLineStateDto.class) HttpServletRequest request) {
        try {
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> MovementResourceUtils.getMovementLineFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (MovementLineMetadata.aliasMap.containsKey(n) ? MovementLineMetadata.aliasMap.get(n) : n));
            Iterable<MovementLineState> states = movementApplicationService.getMovementLines(documentNumber, c,
                    MovementResourceUtils.getMovementLineQuerySorts(request.getParameterMap()));
            if (states == null) { return null; }
            MovementLineStateDto.DtoConverter dtoConverter = new MovementLineStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toMovementLineStateDtoArray(states);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 新建.
     * 新建 MovementLine
     */
    @PostMapping(path = "{documentNumber}/MovementLines", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postMovementLines(@PathVariable("documentNumber") String documentNumber,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchMovementLineDto.CreateMovementLineDto body) {
        try {
            MovementCommand.MergePatchMovement mergePatchMovement = new AbstractMovementCommand.SimpleMergePatchMovement();
            mergePatchMovement.setDocumentNumber(documentNumber);
            mergePatchMovement.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchMovement.setVersion(version); }
            mergePatchMovement.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            MovementLineCommand.CreateMovementLine createMovementLine = body.toCreateMovementLine();
            mergePatchMovement.getMovementLineCommands().add(createMovementLine);
            mergePatchMovement.setRequesterId(SecurityContextUtil.getRequesterId());
            movementApplicationService.when(mergePatchMovement);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  MovementStateEventDtoConverter getMovementStateEventDtoConverter() {
    //    return new MovementStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return MovementResourceUtils.getFilterPropertyType(propertyName);
            }
        };
    }

    protected PropertyTypeResolver getMovementLinePropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return MovementResourceUtils.getMovementLineFilterPropertyType(propertyName);
            }
        };
    }

    // ////////////////////////////////
 
    public static class MovementResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String documentNumber, MovementCommand value) {
            String idObj = documentNumber;
            if (value.getDocumentNumber() == null) {
                value.setDocumentNumber(idObj);
            } else if (!value.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", documentNumber, value.getDocumentNumber());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, MovementMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, MovementMetadata.aliasMap);
        }

        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (MovementMetadata.aliasMap.containsKey(fieldName)) {
                return MovementMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (MovementMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = MovementMetadata.propertyTypeMap.get(propertyName);
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

        public static List<String> getMovementLineQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, MovementLineMetadata.aliasMap);
        }

        public static List<String> getMovementLineQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, MovementLineMetadata.aliasMap);
        }

        public static String getMovementLineFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (MovementLineMetadata.aliasMap.containsKey(fieldName)) {
                return MovementLineMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getMovementLineFilterPropertyType(String propertyName) {
            if (MovementLineMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = MovementLineMetadata.propertyTypeMap.get(propertyName);
                if (!StringHelper.isNullOrEmpty(propertyType)) {
                    if (org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.containsKey(propertyType)) {
                        return org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.get(propertyType);
                    }
                }
            }
            return String.class;
        }

        public static Iterable<Map.Entry<String, Object>> getMovementLineQueryFilterMap(Map<String, String[]> queryNameValuePairs) {
            Map<String, Object> filter = new HashMap<>();
            queryNameValuePairs.forEach((key, values) -> {
                if (values.length > 0) {
                    String pName = getMovementLineFilterPropertyName(key);
                    if (!StringHelper.isNullOrEmpty(pName)) {
                        Class pClass = getMovementLineFilterPropertyType(pName);
                        filter.put(pName, ApplicationContext.current.getTypeConverter().convertFromString(pClass, values[0]));
                    }
                }
            });
            return filter.entrySet();
        }

        public static MovementStateDto[] toMovementStateDtoArray(Iterable<String> ids) {
            List<MovementStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                MovementStateDto dto = new MovementStateDto();
                dto.setDocumentNumber(i);
                states.add(dto);
            });
            return states.toArray(new MovementStateDto[0]);
        }

    }

}

