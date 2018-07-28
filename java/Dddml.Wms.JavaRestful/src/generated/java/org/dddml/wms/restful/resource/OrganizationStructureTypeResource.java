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
import org.dddml.wms.domain.organizationstructuretype.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "OrganizationStructureTypes", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class OrganizationStructureTypeResource {


    @Autowired
    private OrganizationStructureTypeApplicationService organizationStructureTypeApplicationService;


    @GetMapping
    public OrganizationStructureTypeStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<OrganizationStructureTypeState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = organizationStructureTypeApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (OrganizationStructureTypeMetadata.aliasMap.containsKey(n) ? OrganizationStructureTypeMetadata.aliasMap.get(n) : n)),
                        OrganizationStructureTypeResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = organizationStructureTypeApplicationService.get(
                        OrganizationStructureTypeResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        OrganizationStructureTypeResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            OrganizationStructureTypeStateDto.DtoConverter dtoConverter = new OrganizationStructureTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrganizationStructureTypeStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public OrganizationStructureTypeStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = id;
            OrganizationStructureTypeState state = organizationStructureTypeApplicationService.get(idObj);
            if (state == null) { return null; }

            OrganizationStructureTypeStateDto.DtoConverter dtoConverter = new OrganizationStructureTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrganizationStructureTypeStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = organizationStructureTypeApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (OrganizationStructureTypeMetadata.aliasMap.containsKey(n) ? OrganizationStructureTypeMetadata.aliasMap.get(n) : n)));
            } else {
                count = organizationStructureTypeApplicationService.getCount(OrganizationStructureTypeResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public String post(@RequestBody CreateOrMergePatchOrganizationStructureTypeDto.CreateOrganizationStructureTypeDto value,  HttpServletResponse response) {
        try {
            OrganizationStructureTypeCommand.CreateOrganizationStructureType cmd = value.toCreateOrganizationStructureType();
            if (cmd.getId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "OrganizationStructureType");
            }
            organizationStructureTypeApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchOrganizationStructureTypeDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                OrganizationStructureTypeCommand.MergePatchOrganizationStructureType cmd = (OrganizationStructureTypeCommand.MergePatchOrganizationStructureType) value.toCommand();
                OrganizationStructureTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                organizationStructureTypeApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            OrganizationStructureTypeCommand.CreateOrganizationStructureType cmd = (OrganizationStructureTypeCommand.CreateOrganizationStructureType) value.toCommand();
            OrganizationStructureTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            organizationStructureTypeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchOrganizationStructureTypeDto.MergePatchOrganizationStructureTypeDto value) {
        try {

            OrganizationStructureTypeCommand.MergePatchOrganizationStructureType cmd = value.toMergePatchOrganizationStructureType();
            OrganizationStructureTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            organizationStructureTypeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            OrganizationStructureTypeCommand.DeleteOrganizationStructureType deleteCmd = new AbstractOrganizationStructureTypeCommand.SimpleDeleteOrganizationStructureType();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            OrganizationStructureTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            organizationStructureTypeApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            OrganizationStructureTypeMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_events/{version}")
    public OrganizationStructureTypeEvent getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            String idObj = id;
            //OrganizationStructureTypeStateEventDtoConverter dtoConverter = getOrganizationStructureTypeStateEventDtoConverter();
            return organizationStructureTypeApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public OrganizationStructureTypeStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = id;
            OrganizationStructureTypeStateDto.DtoConverter dtoConverter = new OrganizationStructureTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrganizationStructureTypeStateDto(organizationStructureTypeApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  OrganizationStructureTypeStateEventDtoConverter getOrganizationStructureTypeStateEventDtoConverter() {
    //    return new OrganizationStructureTypeStateEventDtoConverter();
    //}

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new OrganizationStructureTypePropertyTypeResolver();
    }

    // ////////////////////////////////

    private class OrganizationStructureTypePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return OrganizationStructureTypeResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class OrganizationStructureTypeResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, OrganizationStructureTypeCommand value) {
            String idObj = id;
            if (value.getId() == null) {
                value.setId(idObj);
            } else if (!value.getId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getId());
            }
        }
    


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (OrganizationStructureTypeMetadata.aliasMap.containsKey(fieldName)) {
                return OrganizationStructureTypeMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (OrganizationStructureTypeMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = OrganizationStructureTypeMetadata.propertyTypeMap.get(propertyName);
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

        public static OrganizationStructureTypeStateDto[] toOrganizationStructureTypeStateDtoArray(Iterable<String> ids) {
            List<OrganizationStructureTypeStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                OrganizationStructureTypeStateDto dto = new OrganizationStructureTypeStateDto();
                dto.setId(id);
                states.add(dto);
            });
            return states.toArray(new OrganizationStructureTypeStateDto[0]);
        }

    }

}

