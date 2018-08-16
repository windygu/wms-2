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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "MovementTypes", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class MovementTypeResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private MovementTypeApplicationService movementTypeApplicationService;


    /**
     * 查询.
     * 查询 MovementTypes
     */
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
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> MovementTypeResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (MovementTypeMetadata.aliasMap.containsKey(n) ? MovementTypeMetadata.aliasMap.get(n) : n));
            states = movementTypeApplicationService.get(
                c,
                MovementTypeResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            MovementTypeStateDto.DtoConverter dtoConverter = new MovementTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toMovementTypeStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查询.
     * 分页查询 MovementTypes
     */
    @GetMapping("_page")
    public Page<MovementTypeStateDto> getPage( HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<MovementTypeState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> MovementTypeResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (MovementTypeMetadata.aliasMap.containsKey(n) ? MovementTypeMetadata.aliasMap.get(n) : n));
            states = movementTypeApplicationService.get(
                c,
                MovementTypeResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = movementTypeApplicationService.getCount(c);

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

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 MovementType
     */
    @GetMapping("{movementTypeId}")
    public MovementTypeStateDto get(@PathVariable("movementTypeId") String movementTypeId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = movementTypeId;
            MovementTypeState state = movementTypeApplicationService.get(idObj);
            if (state == null) { return null; }

            MovementTypeStateDto.DtoConverter dtoConverter = new MovementTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toMovementTypeStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
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
            count = movementTypeApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (MovementTypeMetadata.aliasMap.containsKey(n) ? MovementTypeMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 新建.
     * 新建 MovementType
     */
    @PostMapping
    public String post(@RequestBody CreateOrMergePatchMovementTypeDto.CreateMovementTypeDto value,  HttpServletResponse response) {
        try {
            MovementTypeCommand.CreateMovementType cmd = value.toCreateMovementType();
            if (cmd.getMovementTypeId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "MovementType");
            }
            String idObj = cmd.getMovementTypeId();
            movementTypeApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 MovementType
     */
    @PutMapping("{movementTypeId}")
    public void put(@PathVariable("movementTypeId") String movementTypeId, @RequestBody CreateOrMergePatchMovementTypeDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                MovementTypeCommand.MergePatchMovementType cmd = (MovementTypeCommand.MergePatchMovementType) value.toCommand();
                MovementTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(movementTypeId, cmd);
                movementTypeApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            MovementTypeCommand.CreateMovementType cmd = (MovementTypeCommand.CreateMovementType) value.toCommand();
            MovementTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(movementTypeId, cmd);
            movementTypeApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 修改.
     * 修改 MovementType
     */
    @PatchMapping("{movementTypeId}")
    public void patch(@PathVariable("movementTypeId") String movementTypeId, @RequestBody CreateOrMergePatchMovementTypeDto.MergePatchMovementTypeDto value) {
        try {

            MovementTypeCommand.MergePatchMovementType cmd = value.toMergePatchMovementType();
            MovementTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(movementTypeId, cmd);
            movementTypeApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 删除.
     * 删除 MovementType
     */
    @DeleteMapping("{movementTypeId}")
    public void delete(@PathVariable("movementTypeId") String movementTypeId,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            MovementTypeCommand.DeleteMovementType deleteCmd = new DeleteMovementTypeDto().toDeleteMovementType();;

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            MovementTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(movementTypeId, deleteCmd);
            movementTypeApplicationService.when(deleteCmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            MovementTypeMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
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

        public static void setNullIdOrThrowOnInconsistentIds(String movementTypeId, MovementTypeCommand value) {
            String idObj = movementTypeId;
            if (value.getMovementTypeId() == null) {
                value.setMovementTypeId(idObj);
            } else if (!value.getMovementTypeId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", movementTypeId, value.getMovementTypeId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, MovementTypeMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, MovementTypeMetadata.aliasMap);
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
            ids.forEach(i -> {
                MovementTypeStateDto dto = new MovementTypeStateDto();
                dto.setMovementTypeId(i);
                states.add(dto);
            });
            return states.toArray(new MovementTypeStateDto[0]);
        }

    }

}

