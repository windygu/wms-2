package org.dddml.wms.restful.resource;

import java.util.*;
import java.util.stream.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.movement.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "Movements", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class MovementResource {


    @Autowired
    private MovementApplicationService movementApplicationService;


    @GetMapping
    public MovementStateDto[] getAll( HttpServletRequest request,
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
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap());
            }
            states = movementApplicationService.get(
                CriterionDto.toSubclass(
                        criterion,
                        getCriterionTypeConverter(), 
                        getPropertyTypeResolver(), 
                        n -> (MovementMetadata.aliasMap.containsKey(n) ? MovementMetadata.aliasMap.get(n) : n)),
                MovementResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            MovementStateDto.DtoConverter dtoConverter = new MovementStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toMovementStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_page")
    public Page<MovementStateDto> getPage( HttpServletRequest request,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "page", defaultValue = "0") Integer page,
                                   @RequestParam(value = "size", required = false) @NotNull Integer size) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<MovementState> states = null; 
            Criterion criterion = CriterionDto.toSubclass(
                QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> MovementResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue()))),
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (MovementMetadata.aliasMap.containsKey(n) ? MovementMetadata.aliasMap.get(n) : n));
            states = movementApplicationService.get(
                criterion,
                MovementResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = movementApplicationService.getCount(criterion);

            MovementStateDto.DtoConverter dtoConverter = new MovementStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<MovementStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toMovementStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            statePage.setTotalElements(count);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public MovementStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = id;
            MovementState state = movementApplicationService.get(idObj);
            if (state == null) { return null; }

            MovementStateDto.DtoConverter dtoConverter = new MovementStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toMovementStateDto(state);

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
            count = movementApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (MovementMetadata.aliasMap.containsKey(n) ? MovementMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public String post(@RequestBody CreateOrMergePatchMovementDto.CreateMovementDto value,  HttpServletResponse response) {
        try {
            MovementCommand.CreateMovement cmd = value.toCreateMovement();
            if (cmd.getDocumentNumber() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "Movement");
            }
            movementApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getDocumentNumber();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchMovementDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                MovementCommand.MergePatchMovement cmd = (MovementCommand.MergePatchMovement) value.toCommand();
                MovementResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                movementApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            MovementCommand.CreateMovement cmd = (MovementCommand.CreateMovement) value.toCommand();
            MovementResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            movementApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchMovementDto.MergePatchMovementDto value) {
        try {

            MovementCommand.MergePatchMovement cmd = value.toMergePatchMovement();
            MovementResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            movementApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            MovementCommand.DeleteMovement deleteCmd = new AbstractMovementCommand.SimpleDeleteMovement();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            MovementResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            movementApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}/_commands/AddLine")
    public void addLine(@PathVariable("id") String id, @RequestBody MovementCommands.AddLine content) {
        try {

            MovementCommands.AddLine cmd = content;//.toAddLine();
            String idObj = id;
            if (cmd.getDocumentNumber() == null) {
                cmd.setDocumentNumber(idObj);
            } else if (!cmd.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, cmd.getDocumentNumber());
            }
            movementApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}/_commands/DocumentAction")
    public void documentAction(@PathVariable("id") String id, @RequestBody MovementCommands.DocumentAction content) {
        try {

            MovementCommands.DocumentAction cmd = content;//.toDocumentAction();
            String idObj = id;
            if (cmd.getDocumentNumber() == null) {
                cmd.setDocumentNumber(idObj);
            } else if (!cmd.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, cmd.getDocumentNumber());
            }
            movementApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            MovementMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_events/{version}")
    public MovementEvent getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            String idObj = id;
            //MovementStateEventDtoConverter dtoConverter = getMovementStateEventDtoConverter();
            return movementApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public MovementStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = id;
            MovementStateDto.DtoConverter dtoConverter = new MovementStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toMovementStateDto(movementApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{movementDocumentNumber}/MovementLines/{lineNumber}")
    public MovementLineStateDto getMovementLine(@PathVariable("movementDocumentNumber") String movementDocumentNumber, @PathVariable("lineNumber") String lineNumber) {
        try {

            MovementLineState state = movementApplicationService.getMovementLine(movementDocumentNumber, lineNumber);
            if (state == null) { return null; }
            MovementLineStateDto.DtoConverter dtoConverter = new MovementLineStateDto.DtoConverter();
            MovementLineStateDto stateDto = dtoConverter.toMovementLineStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @PutMapping("{movementDocumentNumber}/MovementLines/{lineNumber}")
    public void putMovementLine(@PathVariable("movementDocumentNumber") String movementDocumentNumber, @PathVariable("lineNumber") String lineNumber,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchMovementLineDto.MergePatchMovementLineDto body) {
        try {
            MovementCommand.MergePatchMovement mergePatchMovement = new AbstractMovementCommand.SimpleMergePatchMovement();
            mergePatchMovement.setDocumentNumber(movementDocumentNumber);
            mergePatchMovement.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchMovement.setVersion(version); }
            mergePatchMovement.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            MovementLineCommand.MergePatchMovementLine mergePatchMovementLine = body.toMergePatchMovementLine();
            mergePatchMovementLine.setLineNumber(lineNumber);
            mergePatchMovement.getMovementLineCommands().add(mergePatchMovementLine);
            movementApplicationService.when(mergePatchMovement);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{movementDocumentNumber}/MovementLines/{lineNumber}")
    public void deleteMovementLine(@PathVariable("movementDocumentNumber") String movementDocumentNumber, @PathVariable("lineNumber") String lineNumber,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            MovementCommand.MergePatchMovement mergePatchMovement = new AbstractMovementCommand.SimpleMergePatchMovement();
            mergePatchMovement.setDocumentNumber(movementDocumentNumber);
            mergePatchMovement.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchMovement.setVersion(version); }
            mergePatchMovement.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            MovementLineCommand.RemoveMovementLine removeMovementLine = new AbstractMovementLineCommand.SimpleRemoveMovementLine();
            removeMovementLine.setLineNumber(lineNumber);
            mergePatchMovement.getMovementLineCommands().add(removeMovementLine);
            movementApplicationService.when(mergePatchMovement);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{movementDocumentNumber}/MovementLines/")
    public MovementLineStateDto[] getMovementLines(@PathVariable("movementDocumentNumber") String movementDocumentNumber) {
        try {
            Iterable<MovementLineState> states = movementApplicationService.getMovementLines(movementDocumentNumber);
            if (states == null) { return null; }
            MovementLineStateDto.DtoConverter dtoConverter = new MovementLineStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toMovementLineStateDtoArray(states);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @PostMapping("{movementDocumentNumber}/MovementLines/")
    public void postMovementLines(@PathVariable("movementDocumentNumber") String movementDocumentNumber,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchMovementLineDto.CreateMovementLineDto body) {
        try {
            MovementCommand.MergePatchMovement mergePatchMovement = new AbstractMovementCommand.SimpleMergePatchMovement();
            mergePatchMovement.setDocumentNumber(movementDocumentNumber);
            mergePatchMovement.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchMovement.setVersion(version); }
            mergePatchMovement.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            MovementLineCommand.CreateMovementLine createMovementLine = body.toCreateMovementLine();
            mergePatchMovement.getMovementLineCommands().add(createMovementLine);
            movementApplicationService.when(mergePatchMovement);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  MovementStateEventDtoConverter getMovementStateEventDtoConverter() {
    //    return new MovementStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new MovementPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class MovementPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return MovementResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class MovementResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String id, MovementCommand value) {
            String idObj = id;
            if (value.getDocumentNumber() == null) {
                value.setDocumentNumber(idObj);
            } else if (!value.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getDocumentNumber());
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

        public static MovementStateDto[] toMovementStateDtoArray(Iterable<String> ids) {
            List<MovementStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                MovementStateDto dto = new MovementStateDto();
                dto.setDocumentNumber(id);
                states.add(dto);
            });
            return states.toArray(new MovementStateDto[0]);
        }

    }

}

