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
import org.dddml.wms.domain.organizationstructure.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "OrganizationStructures", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class OrganizationStructureResource {


    @Autowired
    private OrganizationStructureApplicationService organizationStructureApplicationService;


    /**
     * 查询.
     * 查询 OrganizationStructures
     */
    @GetMapping
    public OrganizationStructureStateDto[] getAll( HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<OrganizationStructureState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> OrganizationStructureResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (OrganizationStructureMetadata.aliasMap.containsKey(n) ? OrganizationStructureMetadata.aliasMap.get(n) : n));
            states = organizationStructureApplicationService.get(
                c,
                OrganizationStructureResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            OrganizationStructureStateDto.DtoConverter dtoConverter = new OrganizationStructureStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrganizationStructureStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查询.
     * 分页查询 OrganizationStructures
     */
    @GetMapping("_page")
    public Page<OrganizationStructureStateDto> getPage( HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<OrganizationStructureState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> OrganizationStructureResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (OrganizationStructureMetadata.aliasMap.containsKey(n) ? OrganizationStructureMetadata.aliasMap.get(n) : n));
            states = organizationStructureApplicationService.get(
                c,
                OrganizationStructureResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = organizationStructureApplicationService.getCount(c);

            OrganizationStructureStateDto.DtoConverter dtoConverter = new OrganizationStructureStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<OrganizationStructureStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toOrganizationStructureStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            statePage.setTotalElements(count);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 OrganizationStructure
     */
    @GetMapping("{id}")
    public OrganizationStructureStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            OrganizationStructureId idObj = OrganizationStructureResourceUtils.parseIdString(id);
            OrganizationStructureState state = organizationStructureApplicationService.get(idObj);
            if (state == null) { return null; }

            OrganizationStructureStateDto.DtoConverter dtoConverter = new OrganizationStructureStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrganizationStructureStateDto(state);

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
            count = organizationStructureApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (OrganizationStructureMetadata.aliasMap.containsKey(n) ? OrganizationStructureMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 新建.
     * 新建 OrganizationStructure
     */
    @PostMapping
    public OrganizationStructureId post(@RequestBody CreateOrMergePatchOrganizationStructureDto.CreateOrganizationStructureDto value,  HttpServletResponse response) {
        try {
            OrganizationStructureCommand.CreateOrganizationStructure cmd = value.toCreateOrganizationStructure();
            if (cmd.getId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "OrganizationStructure");
            }
            organizationStructureApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 OrganizationStructure
     */
    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchOrganizationStructureDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                OrganizationStructureCommand.MergePatchOrganizationStructure cmd = (OrganizationStructureCommand.MergePatchOrganizationStructure) value.toCommand();
                OrganizationStructureResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                organizationStructureApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            OrganizationStructureCommand.CreateOrganizationStructure cmd = (OrganizationStructureCommand.CreateOrganizationStructure) value.toCommand();
            OrganizationStructureResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            organizationStructureApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 修改.
     * 修改 OrganizationStructure
     */
    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchOrganizationStructureDto.MergePatchOrganizationStructureDto value) {
        try {

            OrganizationStructureCommand.MergePatchOrganizationStructure cmd = value.toMergePatchOrganizationStructure();
            OrganizationStructureResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            organizationStructureApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 删除.
     * 删除 OrganizationStructure
     */
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            OrganizationStructureCommand.DeleteOrganizationStructure deleteCmd = new AbstractOrganizationStructureCommand.SimpleDeleteOrganizationStructure();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            OrganizationStructureResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            organizationStructureApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            OrganizationStructureMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_events/{version}")
    public OrganizationStructureEvent getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            OrganizationStructureId idObj = OrganizationStructureResourceUtils.parseIdString(id);
            //OrganizationStructureStateEventDtoConverter dtoConverter = getOrganizationStructureStateEventDtoConverter();
            return organizationStructureApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public OrganizationStructureStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            OrganizationStructureId idObj = OrganizationStructureResourceUtils.parseIdString(id);
            OrganizationStructureStateDto.DtoConverter dtoConverter = new OrganizationStructureStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrganizationStructureStateDto(organizationStructureApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  OrganizationStructureStateEventDtoConverter getOrganizationStructureStateEventDtoConverter() {
    //    return new OrganizationStructureStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new OrganizationStructurePropertyTypeResolver();
    }

    // ////////////////////////////////

    private class OrganizationStructurePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return OrganizationStructureResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class OrganizationStructureResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String id, OrganizationStructureCommand value) {
            OrganizationStructureId idObj = parseIdString(id);
            if (value.getId() == null) {
                value.setId(idObj);
            } else if (!value.getId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, OrganizationStructureMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, OrganizationStructureMetadata.aliasMap);
        }

        public static OrganizationStructureId parseIdString(String idString) {
            TextFormatter<OrganizationStructureId> formatter =
                    new AbstractValueObjectTextFormatter<OrganizationStructureId>(OrganizationStructureId.class) {
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
            if (OrganizationStructureMetadata.aliasMap.containsKey(fieldName)) {
                return OrganizationStructureMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (OrganizationStructureMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = OrganizationStructureMetadata.propertyTypeMap.get(propertyName);
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

        public static OrganizationStructureStateDto[] toOrganizationStructureStateDtoArray(Iterable<OrganizationStructureId> ids) {
            List<OrganizationStructureStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                OrganizationStructureStateDto dto = new OrganizationStructureStateDto();
                dto.setId(i);
                states.add(dto);
            });
            return states.toArray(new OrganizationStructureStateDto[0]);
        }

    }

}

