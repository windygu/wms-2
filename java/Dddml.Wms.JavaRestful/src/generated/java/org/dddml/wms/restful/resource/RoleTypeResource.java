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
import org.dddml.wms.domain.roletype.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "RoleTypes", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class RoleTypeResource {


    @Autowired
    private RoleTypeApplicationService roleTypeApplicationService;


    /**
     * 查询.
     * 查询 RoleTypes
     */
    @GetMapping
    public RoleTypeStateDto[] getAll( HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<RoleTypeState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> RoleTypeResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (RoleTypeMetadata.aliasMap.containsKey(n) ? RoleTypeMetadata.aliasMap.get(n) : n));
            states = roleTypeApplicationService.get(
                c,
                RoleTypeResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            RoleTypeStateDto.DtoConverter dtoConverter = new RoleTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toRoleTypeStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查询.
     * 分页查询 RoleTypes
     */
    @GetMapping("_page")
    public Page<RoleTypeStateDto> getPage( HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<RoleTypeState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> RoleTypeResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (RoleTypeMetadata.aliasMap.containsKey(n) ? RoleTypeMetadata.aliasMap.get(n) : n));
            states = roleTypeApplicationService.get(
                c,
                RoleTypeResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = roleTypeApplicationService.getCount(c);

            RoleTypeStateDto.DtoConverter dtoConverter = new RoleTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<RoleTypeStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toRoleTypeStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            statePage.setTotalElements(count);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 RoleType
     */
    @GetMapping("{roleTypeId}")
    public RoleTypeStateDto get(@PathVariable("roleTypeId") String roleTypeId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = roleTypeId;
            RoleTypeState state = roleTypeApplicationService.get(idObj);
            if (state == null) { return null; }

            RoleTypeStateDto.DtoConverter dtoConverter = new RoleTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toRoleTypeStateDto(state);

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
            count = roleTypeApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (RoleTypeMetadata.aliasMap.containsKey(n) ? RoleTypeMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 新建.
     * 新建 RoleType
     */
    @PostMapping
    public String post(@RequestBody CreateOrMergePatchRoleTypeDto.CreateRoleTypeDto value,  HttpServletResponse response) {
        try {
            RoleTypeCommand.CreateRoleType cmd = value.toCreateRoleType();
            if (cmd.getRoleTypeId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "RoleType");
            }
            roleTypeApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getRoleTypeId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{roleTypeId}")
    public void put(@PathVariable("roleTypeId") String roleTypeId, @RequestBody CreateOrMergePatchRoleTypeDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                RoleTypeCommand.MergePatchRoleType cmd = (RoleTypeCommand.MergePatchRoleType) value.toCommand();
                RoleTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(roleTypeId, cmd);
                roleTypeApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            RoleTypeCommand.CreateRoleType cmd = (RoleTypeCommand.CreateRoleType) value.toCommand();
            RoleTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(roleTypeId, cmd);
            roleTypeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{roleTypeId}")
    public void patch(@PathVariable("roleTypeId") String roleTypeId, @RequestBody CreateOrMergePatchRoleTypeDto.MergePatchRoleTypeDto value) {
        try {

            RoleTypeCommand.MergePatchRoleType cmd = value.toMergePatchRoleType();
            RoleTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(roleTypeId, cmd);
            roleTypeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{roleTypeId}")
    public void delete(@PathVariable("roleTypeId") String roleTypeId,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            RoleTypeCommand.DeleteRoleType deleteCmd = new AbstractRoleTypeCommand.SimpleDeleteRoleType();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            RoleTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(roleTypeId, deleteCmd);
            roleTypeApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            RoleTypeMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{roleTypeId}/_events/{version}")
    public RoleTypeEvent getStateEvent(@PathVariable("roleTypeId") String roleTypeId, @PathVariable("version") long version) {
        try {

            String idObj = roleTypeId;
            //RoleTypeStateEventDtoConverter dtoConverter = getRoleTypeStateEventDtoConverter();
            return roleTypeApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{roleTypeId}/_historyStates/{version}")
    public RoleTypeStateDto getHistoryState(@PathVariable("roleTypeId") String roleTypeId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = roleTypeId;
            RoleTypeStateDto.DtoConverter dtoConverter = new RoleTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toRoleTypeStateDto(roleTypeApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  RoleTypeStateEventDtoConverter getRoleTypeStateEventDtoConverter() {
    //    return new RoleTypeStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new RoleTypePropertyTypeResolver();
    }

    // ////////////////////////////////

    private class RoleTypePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return RoleTypeResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class RoleTypeResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String roleTypeId, RoleTypeCommand value) {
            String idObj = roleTypeId;
            if (value.getRoleTypeId() == null) {
                value.setRoleTypeId(idObj);
            } else if (!value.getRoleTypeId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", roleTypeId, value.getRoleTypeId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, RoleTypeMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, RoleTypeMetadata.aliasMap);
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (RoleTypeMetadata.aliasMap.containsKey(fieldName)) {
                return RoleTypeMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (RoleTypeMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = RoleTypeMetadata.propertyTypeMap.get(propertyName);
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

        public static RoleTypeStateDto[] toRoleTypeStateDtoArray(Iterable<String> ids) {
            List<RoleTypeStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                RoleTypeStateDto dto = new RoleTypeStateDto();
                dto.setRoleTypeId(i);
                states.add(dto);
            });
            return states.toArray(new RoleTypeStateDto[0]);
        }

    }

}

