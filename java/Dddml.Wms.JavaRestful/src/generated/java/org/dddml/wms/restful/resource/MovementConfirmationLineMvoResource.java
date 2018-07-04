package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.movementconfirmation.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.movementconfirmationlinemvo.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "MovementConfirmationLineMvos", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class MovementConfirmationLineMvoResource {


    @Autowired
    private MovementConfirmationLineMvoApplicationService movementConfirmationLineMvoApplicationService;


    @GetMapping
    public MovementConfirmationLineMvoStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<MovementConfirmationLineMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = movementConfirmationLineMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (MovementConfirmationLineMvoMetadata.aliasMap.containsKey(n) ? MovementConfirmationLineMvoMetadata.aliasMap.get(n) : n)),
                        MovementConfirmationLineMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = movementConfirmationLineMvoApplicationService.get(
                        MovementConfirmationLineMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        MovementConfirmationLineMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            MovementConfirmationLineMvoStateDto.DtoConverter dtoConverter = new MovementConfirmationLineMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toMovementConfirmationLineMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public MovementConfirmationLineMvoStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            MovementConfirmationLineId idObj = MovementConfirmationLineMvoResourceUtils.parseIdString(id);
            MovementConfirmationLineMvoState state = movementConfirmationLineMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            MovementConfirmationLineMvoStateDto.DtoConverter dtoConverter = new MovementConfirmationLineMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toMovementConfirmationLineMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = movementConfirmationLineMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (MovementConfirmationLineMvoMetadata.aliasMap.containsKey(n) ? MovementConfirmationLineMvoMetadata.aliasMap.get(n) : n)));
            } else {
                count = movementConfirmationLineMvoApplicationService.getCount(MovementConfirmationLineMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public MovementConfirmationLineId post(@RequestBody CreateOrMergePatchMovementConfirmationLineMvoDto.CreateMovementConfirmationLineMvoDto value,  HttpServletResponse response) {
        try {
            MovementConfirmationLineMvoCommand.CreateMovementConfirmationLineMvo cmd = value.toCreateMovementConfirmationLineMvo();
            if (cmd.getMovementConfirmationLineId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "MovementConfirmationLineMvo");
            }
            movementConfirmationLineMvoApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getMovementConfirmationLineId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchMovementConfirmationLineMvoDto value) {
        try {
            if (value.getMovementConfirmationVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                MovementConfirmationLineMvoCommand.MergePatchMovementConfirmationLineMvo cmd = (MovementConfirmationLineMvoCommand.MergePatchMovementConfirmationLineMvo) value.toCommand();
                MovementConfirmationLineMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                movementConfirmationLineMvoApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            MovementConfirmationLineMvoCommand.CreateMovementConfirmationLineMvo cmd = (MovementConfirmationLineMvoCommand.CreateMovementConfirmationLineMvo) value.toCommand();
            MovementConfirmationLineMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            movementConfirmationLineMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchMovementConfirmationLineMvoDto.MergePatchMovementConfirmationLineMvoDto value) {
        try {

            MovementConfirmationLineMvoCommand.MergePatchMovementConfirmationLineMvo cmd = value.toMergePatchMovementConfirmationLineMvo();
            MovementConfirmationLineMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            movementConfirmationLineMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            MovementConfirmationLineMvoCommand.DeleteMovementConfirmationLineMvo deleteCmd = new AbstractMovementConfirmationLineMvoCommand.SimpleDeleteMovementConfirmationLineMvo();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setMovementConfirmationVersion(version);
            MovementConfirmationLineMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            movementConfirmationLineMvoApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            MovementConfirmationLineMvoMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_stateEvents/{version}")
    public MovementConfirmationLineMvoStateEventDto getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            MovementConfirmationLineId idObj = MovementConfirmationLineMvoResourceUtils.parseIdString(id);
            MovementConfirmationLineMvoStateEventDtoConverter dtoConverter = getMovementConfirmationLineMvoStateEventDtoConverter();
            return dtoConverter.toMovementConfirmationLineMvoStateEventDto((AbstractMovementConfirmationLineMvoEvent) movementConfirmationLineMvoApplicationService.getEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public MovementConfirmationLineMvoStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            MovementConfirmationLineId idObj = MovementConfirmationLineMvoResourceUtils.parseIdString(id);
            MovementConfirmationLineMvoStateDto.DtoConverter dtoConverter = new MovementConfirmationLineMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toMovementConfirmationLineMvoStateDto(movementConfirmationLineMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  MovementConfirmationLineMvoStateEventDtoConverter getMovementConfirmationLineMvoStateEventDtoConverter() {
        return new MovementConfirmationLineMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new MovementConfirmationLineMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class MovementConfirmationLineMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return MovementConfirmationLineMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class MovementConfirmationLineMvoResourceUtils {

        public static List<String> getQueryOrders(String str, String separator) {
            List<String> orders = new ArrayList<>();
            if (StringHelper.isNullOrEmpty(str)) {
                return orders;
            }
            String[] splits = str.split(separator);
            for (String item : splits) {
                if (!StringHelper.isNullOrEmpty(item)) {
                    orders.add(item);
                }
            }
            return orders;
        }

        public static void setNullIdOrThrowOnInconsistentIds(String id, MovementConfirmationLineMvoCommand value) {
            MovementConfirmationLineId idObj = parseIdString(id);
            if (value.getMovementConfirmationLineId() == null) {
                value.setMovementConfirmationLineId(idObj);
            } else if (!value.getMovementConfirmationLineId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getMovementConfirmationLineId());
            }
        }
    

        public static MovementConfirmationLineId parseIdString(String idString) {
            TextFormatter<MovementConfirmationLineId> formatter =
                    new AbstractValueObjectTextFormatter<MovementConfirmationLineId>(MovementConfirmationLineId.class) {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    };
            return formatter.parse(idString);
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (MovementConfirmationLineMvoMetadata.aliasMap.containsKey(fieldName)) {
                return MovementConfirmationLineMvoMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (MovementConfirmationLineMvoMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = MovementConfirmationLineMvoMetadata.propertyTypeMap.get(propertyName);
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

        public static MovementConfirmationLineMvoStateDto[] toMovementConfirmationLineMvoStateDtoArray(Iterable<MovementConfirmationLineId> ids) {
            List<MovementConfirmationLineMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                MovementConfirmationLineMvoStateDto dto = new MovementConfirmationLineMvoStateDto();
                dto.setMovementConfirmationLineId(id);
                states.add(dto);
            });
            return states.toArray(new MovementConfirmationLineMvoStateDto[0]);
        }

    }

}

