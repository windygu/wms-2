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
import org.dddml.wms.domain.damagetype.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "DamageTypes", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class DamageTypeResource {


    @Autowired
    private DamageTypeApplicationService damageTypeApplicationService;


    /**
     * 查询.
     * 查询 DamageTypes
     */
    @GetMapping
    public DamageTypeStateDto[] getAll( HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<DamageTypeState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> DamageTypeResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (DamageTypeMetadata.aliasMap.containsKey(n) ? DamageTypeMetadata.aliasMap.get(n) : n));
            states = damageTypeApplicationService.get(
                c,
                DamageTypeResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            DamageTypeStateDto.DtoConverter dtoConverter = new DamageTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toDamageTypeStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查询.
     * 分页查询 DamageTypes
     */
    @GetMapping("_page")
    public Page<DamageTypeStateDto> getPage( HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<DamageTypeState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> DamageTypeResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (DamageTypeMetadata.aliasMap.containsKey(n) ? DamageTypeMetadata.aliasMap.get(n) : n));
            states = damageTypeApplicationService.get(
                c,
                DamageTypeResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = damageTypeApplicationService.getCount(c);

            DamageTypeStateDto.DtoConverter dtoConverter = new DamageTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<DamageTypeStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toDamageTypeStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            statePage.setTotalElements(count);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 DamageType
     */
    @GetMapping("{damageTypeId}")
    public DamageTypeStateDto get(@PathVariable("damageTypeId") String damageTypeId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = damageTypeId;
            DamageTypeState state = damageTypeApplicationService.get(idObj);
            if (state == null) { return null; }

            DamageTypeStateDto.DtoConverter dtoConverter = new DamageTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toDamageTypeStateDto(state);

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
            count = damageTypeApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (DamageTypeMetadata.aliasMap.containsKey(n) ? DamageTypeMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 新建.
     * 新建 DamageType
     */
    @PostMapping
    public String post(@RequestBody CreateOrMergePatchDamageTypeDto.CreateDamageTypeDto value,  HttpServletResponse response) {
        try {
            DamageTypeCommand.CreateDamageType cmd = value.toCreateDamageType();
            if (cmd.getDamageTypeId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "DamageType");
            }
            damageTypeApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getDamageTypeId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 DamageType
     */
    @PutMapping("{damageTypeId}")
    public void put(@PathVariable("damageTypeId") String damageTypeId, @RequestBody CreateOrMergePatchDamageTypeDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                DamageTypeCommand.MergePatchDamageType cmd = (DamageTypeCommand.MergePatchDamageType) value.toCommand();
                DamageTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(damageTypeId, cmd);
                damageTypeApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            DamageTypeCommand.CreateDamageType cmd = (DamageTypeCommand.CreateDamageType) value.toCommand();
            DamageTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(damageTypeId, cmd);
            damageTypeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 修改.
     * 修改 DamageType
     */
    @PatchMapping("{damageTypeId}")
    public void patch(@PathVariable("damageTypeId") String damageTypeId, @RequestBody CreateOrMergePatchDamageTypeDto.MergePatchDamageTypeDto value) {
        try {

            DamageTypeCommand.MergePatchDamageType cmd = value.toMergePatchDamageType();
            DamageTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(damageTypeId, cmd);
            damageTypeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 删除.
     * 删除 DamageType
     */
    @DeleteMapping("{damageTypeId}")
    public void delete(@PathVariable("damageTypeId") String damageTypeId,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            DamageTypeCommand.DeleteDamageType deleteCmd = new DeleteDamageTypeDto().toDeleteDamageType();;

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            DamageTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(damageTypeId, deleteCmd);
            damageTypeApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            DamageTypeMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new DamageTypePropertyTypeResolver();
    }

    // ////////////////////////////////

    private class DamageTypePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return DamageTypeResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class DamageTypeResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String damageTypeId, DamageTypeCommand value) {
            String idObj = damageTypeId;
            if (value.getDamageTypeId() == null) {
                value.setDamageTypeId(idObj);
            } else if (!value.getDamageTypeId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", damageTypeId, value.getDamageTypeId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, DamageTypeMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, DamageTypeMetadata.aliasMap);
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (DamageTypeMetadata.aliasMap.containsKey(fieldName)) {
                return DamageTypeMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (DamageTypeMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = DamageTypeMetadata.propertyTypeMap.get(propertyName);
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

        public static DamageTypeStateDto[] toDamageTypeStateDtoArray(Iterable<String> ids) {
            List<DamageTypeStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                DamageTypeStateDto dto = new DamageTypeStateDto();
                dto.setDamageTypeId(i);
                states.add(dto);
            });
            return states.toArray(new DamageTypeStateDto[0]);
        }

    }

}

