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
import org.dddml.wms.domain.damagereason.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "DamageReasons", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class DamageReasonResource {


    @Autowired
    private DamageReasonApplicationService damageReasonApplicationService;


    /**
     * 查询.
     * 查询 DamageReasons
     */
    @GetMapping
    public DamageReasonStateDto[] getAll( HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<DamageReasonState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> DamageReasonResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (DamageReasonMetadata.aliasMap.containsKey(n) ? DamageReasonMetadata.aliasMap.get(n) : n));
            states = damageReasonApplicationService.get(
                c,
                DamageReasonResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            DamageReasonStateDto.DtoConverter dtoConverter = new DamageReasonStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toDamageReasonStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查询.
     * 分页查询 DamageReasons
     */
    @GetMapping("_page")
    public Page<DamageReasonStateDto> getPage( HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<DamageReasonState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> DamageReasonResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (DamageReasonMetadata.aliasMap.containsKey(n) ? DamageReasonMetadata.aliasMap.get(n) : n));
            states = damageReasonApplicationService.get(
                c,
                DamageReasonResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = damageReasonApplicationService.getCount(c);

            DamageReasonStateDto.DtoConverter dtoConverter = new DamageReasonStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<DamageReasonStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toDamageReasonStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            statePage.setTotalElements(count);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 DamageReason
     */
    @GetMapping("{damageReasonId}")
    public DamageReasonStateDto get(@PathVariable("damageReasonId") String damageReasonId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = damageReasonId;
            DamageReasonState state = damageReasonApplicationService.get(idObj);
            if (state == null) { return null; }

            DamageReasonStateDto.DtoConverter dtoConverter = new DamageReasonStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toDamageReasonStateDto(state);

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
            count = damageReasonApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (DamageReasonMetadata.aliasMap.containsKey(n) ? DamageReasonMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public String post(@RequestBody CreateOrMergePatchDamageReasonDto.CreateDamageReasonDto value,  HttpServletResponse response) {
        try {
            DamageReasonCommand.CreateDamageReason cmd = value.toCreateDamageReason();
            if (cmd.getDamageReasonId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "DamageReason");
            }
            damageReasonApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getDamageReasonId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{damageReasonId}")
    public void put(@PathVariable("damageReasonId") String damageReasonId, @RequestBody CreateOrMergePatchDamageReasonDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                DamageReasonCommand.MergePatchDamageReason cmd = (DamageReasonCommand.MergePatchDamageReason) value.toCommand();
                DamageReasonResourceUtils.setNullIdOrThrowOnInconsistentIds(damageReasonId, cmd);
                damageReasonApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            DamageReasonCommand.CreateDamageReason cmd = (DamageReasonCommand.CreateDamageReason) value.toCommand();
            DamageReasonResourceUtils.setNullIdOrThrowOnInconsistentIds(damageReasonId, cmd);
            damageReasonApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{damageReasonId}")
    public void patch(@PathVariable("damageReasonId") String damageReasonId, @RequestBody CreateOrMergePatchDamageReasonDto.MergePatchDamageReasonDto value) {
        try {

            DamageReasonCommand.MergePatchDamageReason cmd = value.toMergePatchDamageReason();
            DamageReasonResourceUtils.setNullIdOrThrowOnInconsistentIds(damageReasonId, cmd);
            damageReasonApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{damageReasonId}")
    public void delete(@PathVariable("damageReasonId") String damageReasonId,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            DamageReasonCommand.DeleteDamageReason deleteCmd = new AbstractDamageReasonCommand.SimpleDeleteDamageReason();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            DamageReasonResourceUtils.setNullIdOrThrowOnInconsistentIds(damageReasonId, deleteCmd);
            damageReasonApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            DamageReasonMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{damageReasonId}/_events/{version}")
    public DamageReasonEvent getStateEvent(@PathVariable("damageReasonId") String damageReasonId, @PathVariable("version") long version) {
        try {

            String idObj = damageReasonId;
            //DamageReasonStateEventDtoConverter dtoConverter = getDamageReasonStateEventDtoConverter();
            return damageReasonApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{damageReasonId}/_historyStates/{version}")
    public DamageReasonStateDto getHistoryState(@PathVariable("damageReasonId") String damageReasonId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = damageReasonId;
            DamageReasonStateDto.DtoConverter dtoConverter = new DamageReasonStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toDamageReasonStateDto(damageReasonApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  DamageReasonStateEventDtoConverter getDamageReasonStateEventDtoConverter() {
    //    return new DamageReasonStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new DamageReasonPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class DamageReasonPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return DamageReasonResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class DamageReasonResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String damageReasonId, DamageReasonCommand value) {
            String idObj = damageReasonId;
            if (value.getDamageReasonId() == null) {
                value.setDamageReasonId(idObj);
            } else if (!value.getDamageReasonId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", damageReasonId, value.getDamageReasonId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, DamageReasonMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, DamageReasonMetadata.aliasMap);
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (DamageReasonMetadata.aliasMap.containsKey(fieldName)) {
                return DamageReasonMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (DamageReasonMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = DamageReasonMetadata.propertyTypeMap.get(propertyName);
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

        public static DamageReasonStateDto[] toDamageReasonStateDtoArray(Iterable<String> ids) {
            List<DamageReasonStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                DamageReasonStateDto dto = new DamageReasonStateDto();
                dto.setDamageReasonId(i);
                states.add(dto);
            });
            return states.toArray(new DamageReasonStateDto[0]);
        }

    }

}

