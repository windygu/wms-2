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
import org.dddml.wms.domain.damagehandlingmethod.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "DamageHandlingMethods", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class DamageHandlingMethodResource {


    @Autowired
    private DamageHandlingMethodApplicationService damageHandlingMethodApplicationService;


    /**
     * 查询.
     * 查询 DamageHandlingMethods
     */
    @GetMapping
    public DamageHandlingMethodStateDto[] getAll( HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<DamageHandlingMethodState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> DamageHandlingMethodResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (DamageHandlingMethodMetadata.aliasMap.containsKey(n) ? DamageHandlingMethodMetadata.aliasMap.get(n) : n));
            states = damageHandlingMethodApplicationService.get(
                c,
                DamageHandlingMethodResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            DamageHandlingMethodStateDto.DtoConverter dtoConverter = new DamageHandlingMethodStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toDamageHandlingMethodStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查询.
     * 分页查询 DamageHandlingMethods
     */
    @GetMapping("_page")
    public Page<DamageHandlingMethodStateDto> getPage( HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<DamageHandlingMethodState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> DamageHandlingMethodResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (DamageHandlingMethodMetadata.aliasMap.containsKey(n) ? DamageHandlingMethodMetadata.aliasMap.get(n) : n));
            states = damageHandlingMethodApplicationService.get(
                c,
                DamageHandlingMethodResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = damageHandlingMethodApplicationService.getCount(c);

            DamageHandlingMethodStateDto.DtoConverter dtoConverter = new DamageHandlingMethodStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<DamageHandlingMethodStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toDamageHandlingMethodStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            statePage.setTotalElements(count);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 DamageHandlingMethod
     */
    @GetMapping("{damageHandlingMethodId}")
    public DamageHandlingMethodStateDto get(@PathVariable("damageHandlingMethodId") String damageHandlingMethodId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = damageHandlingMethodId;
            DamageHandlingMethodState state = damageHandlingMethodApplicationService.get(idObj);
            if (state == null) { return null; }

            DamageHandlingMethodStateDto.DtoConverter dtoConverter = new DamageHandlingMethodStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toDamageHandlingMethodStateDto(state);

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
            count = damageHandlingMethodApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (DamageHandlingMethodMetadata.aliasMap.containsKey(n) ? DamageHandlingMethodMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 新建.
     * 新建 DamageHandlingMethod
     */
    @PostMapping
    public String post(@RequestBody CreateOrMergePatchDamageHandlingMethodDto.CreateDamageHandlingMethodDto value,  HttpServletResponse response) {
        try {
            DamageHandlingMethodCommand.CreateDamageHandlingMethod cmd = value.toCreateDamageHandlingMethod();
            if (cmd.getDamageHandlingMethodId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "DamageHandlingMethod");
            }
            damageHandlingMethodApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getDamageHandlingMethodId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 DamageHandlingMethod
     */
    @PutMapping("{damageHandlingMethodId}")
    public void put(@PathVariable("damageHandlingMethodId") String damageHandlingMethodId, @RequestBody CreateOrMergePatchDamageHandlingMethodDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                DamageHandlingMethodCommand.MergePatchDamageHandlingMethod cmd = (DamageHandlingMethodCommand.MergePatchDamageHandlingMethod) value.toCommand();
                DamageHandlingMethodResourceUtils.setNullIdOrThrowOnInconsistentIds(damageHandlingMethodId, cmd);
                damageHandlingMethodApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            DamageHandlingMethodCommand.CreateDamageHandlingMethod cmd = (DamageHandlingMethodCommand.CreateDamageHandlingMethod) value.toCommand();
            DamageHandlingMethodResourceUtils.setNullIdOrThrowOnInconsistentIds(damageHandlingMethodId, cmd);
            damageHandlingMethodApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 修改.
     * 修改 DamageHandlingMethod
     */
    @PatchMapping("{damageHandlingMethodId}")
    public void patch(@PathVariable("damageHandlingMethodId") String damageHandlingMethodId, @RequestBody CreateOrMergePatchDamageHandlingMethodDto.MergePatchDamageHandlingMethodDto value) {
        try {

            DamageHandlingMethodCommand.MergePatchDamageHandlingMethod cmd = value.toMergePatchDamageHandlingMethod();
            DamageHandlingMethodResourceUtils.setNullIdOrThrowOnInconsistentIds(damageHandlingMethodId, cmd);
            damageHandlingMethodApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 删除.
     * 删除 DamageHandlingMethod
     */
    @DeleteMapping("{damageHandlingMethodId}")
    public void delete(@PathVariable("damageHandlingMethodId") String damageHandlingMethodId,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            DamageHandlingMethodCommand.DeleteDamageHandlingMethod deleteCmd = new DeleteDamageHandlingMethodDto().toDeleteDamageHandlingMethod();;

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            DamageHandlingMethodResourceUtils.setNullIdOrThrowOnInconsistentIds(damageHandlingMethodId, deleteCmd);
            damageHandlingMethodApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            DamageHandlingMethodMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new DamageHandlingMethodPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class DamageHandlingMethodPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return DamageHandlingMethodResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class DamageHandlingMethodResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String damageHandlingMethodId, DamageHandlingMethodCommand value) {
            String idObj = damageHandlingMethodId;
            if (value.getDamageHandlingMethodId() == null) {
                value.setDamageHandlingMethodId(idObj);
            } else if (!value.getDamageHandlingMethodId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", damageHandlingMethodId, value.getDamageHandlingMethodId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, DamageHandlingMethodMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, DamageHandlingMethodMetadata.aliasMap);
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (DamageHandlingMethodMetadata.aliasMap.containsKey(fieldName)) {
                return DamageHandlingMethodMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (DamageHandlingMethodMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = DamageHandlingMethodMetadata.propertyTypeMap.get(propertyName);
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

        public static DamageHandlingMethodStateDto[] toDamageHandlingMethodStateDtoArray(Iterable<String> ids) {
            List<DamageHandlingMethodStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                DamageHandlingMethodStateDto dto = new DamageHandlingMethodStateDto();
                dto.setDamageHandlingMethodId(i);
                states.add(dto);
            });
            return states.toArray(new DamageHandlingMethodStateDto[0]);
        }

    }

}

