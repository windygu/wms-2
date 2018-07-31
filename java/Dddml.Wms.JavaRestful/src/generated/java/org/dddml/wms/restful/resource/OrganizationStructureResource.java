package org.dddml.wms.restful.resource;

import java.util.*;
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

@RequestMapping(path = "OrganizationStructures", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class OrganizationStructureResource {


    @Autowired
    private OrganizationStructureApplicationService organizationStructureApplicationService;


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
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = organizationStructureApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (OrganizationStructureMetadata.aliasMap.containsKey(n) ? OrganizationStructureMetadata.aliasMap.get(n) : n)),
                        OrganizationStructureResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = organizationStructureApplicationService.get(
                        OrganizationStructureResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        OrganizationStructureResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            OrganizationStructureStateDto.DtoConverter dtoConverter = new OrganizationStructureStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrganizationStructureStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_page")
    public Page<OrganizationStructureStateDto> getPage( HttpServletRequest request,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "page", defaultValue = "0") Integer page,
                                   @RequestParam(value = "size", required = false) @NotNull Integer size) {
        try {
            List<String> sort = OrganizationStructureResourceUtils.getQuerySorts(request.getParameterMap());
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<OrganizationStructureState> states = null; 
            Iterable<Map.Entry<String, Object>> queryFilterMap = OrganizationStructureResourceUtils.getQueryFilterMap(request.getParameterMap());
            states = organizationStructureApplicationService.get(
                        queryFilterMap,
                        OrganizationStructureResourceUtils.getQuerySorts(request.getParameterMap()),
                        firstResult, maxResults);
            long count = organizationStructureApplicationService.getCount(queryFilterMap);

            OrganizationStructureStateDto.DtoConverter dtoConverter = new OrganizationStructureStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<OrganizationStructureStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toOrganizationStructureStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

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
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = organizationStructureApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (OrganizationStructureMetadata.aliasMap.containsKey(n) ? OrganizationStructureMetadata.aliasMap.get(n) : n)));
            } else {
                count = organizationStructureApplicationService.getCount(OrganizationStructureResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


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


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchOrganizationStructureDto.MergePatchOrganizationStructureDto value) {
        try {

            OrganizationStructureCommand.MergePatchOrganizationStructure cmd = value.toMergePatchOrganizationStructure();
            OrganizationStructureResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            organizationStructureApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

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

    protected String getQueryOrderSeparator() {
        return ",";
    }

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
            return QueryParamUtils.getQueryOrders(str, separator);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            return QueryParamUtils.getQuerySorts(queryNameValuePairs);
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
            ids.forEach(id -> {
                OrganizationStructureStateDto dto = new OrganizationStructureStateDto();
                dto.setId(id);
                states.add(dto);
            });
            return states.toArray(new OrganizationStructureStateDto[0]);
        }

    }

}

