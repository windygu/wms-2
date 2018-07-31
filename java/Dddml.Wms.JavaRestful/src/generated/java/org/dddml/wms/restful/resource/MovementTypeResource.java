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
import org.dddml.wms.domain.movementtype.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "MovementTypes", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class MovementTypeResource {


    @Autowired
    private MovementTypeApplicationService movementTypeApplicationService;


    @GetMapping
    public MovementTypeStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<MovementTypeState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = movementTypeApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (MovementTypeMetadata.aliasMap.containsKey(n) ? MovementTypeMetadata.aliasMap.get(n) : n)),
                        MovementTypeResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = movementTypeApplicationService.get(
                        MovementTypeResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        MovementTypeResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            MovementTypeStateDto.DtoConverter dtoConverter = new MovementTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toMovementTypeStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_page")
    public Page<MovementTypeStateDto> getPage( HttpServletRequest request,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "page", defaultValue = "0") Integer page,
                                   @RequestParam(value = "size", required = false) @NotNull Integer size) {
        try {
            List<String> sort = MovementTypeResourceUtils.getQuerySorts(request.getParameterMap());
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<MovementTypeState> states = null; 
            Criterion criterion = CriterionDto.toSubclass(
                    QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                            .filter(kv -> MovementTypeResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                            .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue()))),
                            getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (MovementTypeMetadata.aliasMap.containsKey(n) ? MovementTypeMetadata.aliasMap.get(n) : n));
            states = movementTypeApplicationService.get(
                        criterion,
                        MovementTypeResourceUtils.getQuerySorts(request.getParameterMap()),
                        firstResult, maxResults);
            long count = movementTypeApplicationService.getCount(criterion);

            MovementTypeStateDto.DtoConverter dtoConverter = new MovementTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<MovementTypeStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toMovementTypeStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            statePage.setTotalElements(count);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public MovementTypeStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = id;
            MovementTypeState state = movementTypeApplicationService.get(idObj);
            if (state == null) { return null; }

            MovementTypeStateDto.DtoConverter dtoConverter = new MovementTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toMovementTypeStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = movementTypeApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (MovementTypeMetadata.aliasMap.containsKey(n) ? MovementTypeMetadata.aliasMap.get(n) : n)));
            } else {
                count = movementTypeApplicationService.getCount(MovementTypeResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public String post(@RequestBody CreateOrMergePatchMovementTypeDto.CreateMovementTypeDto value,  HttpServletResponse response) {
        try {
            MovementTypeCommand.CreateMovementType cmd = value.toCreateMovementType();
            if (cmd.getMovementTypeId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "MovementType");
            }
            movementTypeApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getMovementTypeId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchMovementTypeDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                MovementTypeCommand.MergePatchMovementType cmd = (MovementTypeCommand.MergePatchMovementType) value.toCommand();
                MovementTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                movementTypeApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            MovementTypeCommand.CreateMovementType cmd = (MovementTypeCommand.CreateMovementType) value.toCommand();
            MovementTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            movementTypeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchMovementTypeDto.MergePatchMovementTypeDto value) {
        try {

            MovementTypeCommand.MergePatchMovementType cmd = value.toMergePatchMovementType();
            MovementTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            movementTypeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            MovementTypeCommand.DeleteMovementType deleteCmd = new DeleteMovementTypeDto().toDeleteMovementType();;

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            MovementTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            movementTypeApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            MovementTypeMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new MovementTypePropertyTypeResolver();
    }

    // ////////////////////////////////

    private class MovementTypePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return MovementTypeResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class MovementTypeResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String id, MovementTypeCommand value) {
            String idObj = id;
            if (value.getMovementTypeId() == null) {
                value.setMovementTypeId(idObj);
            } else if (!value.getMovementTypeId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getMovementTypeId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, MovementTypeMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            return QueryParamUtils.getQuerySorts(queryNameValuePairs, MovementTypeMetadata.aliasMap);
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (MovementTypeMetadata.aliasMap.containsKey(fieldName)) {
                return MovementTypeMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (MovementTypeMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = MovementTypeMetadata.propertyTypeMap.get(propertyName);
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

        public static MovementTypeStateDto[] toMovementTypeStateDtoArray(Iterable<String> ids) {
            List<MovementTypeStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                MovementTypeStateDto dto = new MovementTypeStateDto();
                dto.setMovementTypeId(id);
                states.add(dto);
            });
            return states.toArray(new MovementTypeStateDto[0]);
        }

    }

}

