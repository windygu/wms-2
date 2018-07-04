package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.picklist.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.picklistrolemvo.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "PicklistRoleMvos", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class PicklistRoleMvoResource {


    @Autowired
    private PicklistRoleMvoApplicationService picklistRoleMvoApplicationService;


    @GetMapping
    public PicklistRoleMvoStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<PicklistRoleMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = picklistRoleMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (PicklistRoleMvoMetadata.aliasMap.containsKey(n) ? PicklistRoleMvoMetadata.aliasMap.get(n) : n)),
                        PicklistRoleMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = picklistRoleMvoApplicationService.get(
                        PicklistRoleMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        PicklistRoleMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            PicklistRoleMvoStateDto.DtoConverter dtoConverter = new PicklistRoleMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPicklistRoleMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public PicklistRoleMvoStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            PicklistRoleId idObj = PicklistRoleMvoResourceUtils.parseIdString(id);
            PicklistRoleMvoState state = picklistRoleMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            PicklistRoleMvoStateDto.DtoConverter dtoConverter = new PicklistRoleMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPicklistRoleMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = picklistRoleMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (PicklistRoleMvoMetadata.aliasMap.containsKey(n) ? PicklistRoleMvoMetadata.aliasMap.get(n) : n)));
            } else {
                count = picklistRoleMvoApplicationService.getCount(PicklistRoleMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public PicklistRoleId post(@RequestBody CreateOrMergePatchPicklistRoleMvoDto.CreatePicklistRoleMvoDto value,  HttpServletResponse response) {
        try {
            PicklistRoleMvoCommand.CreatePicklistRoleMvo cmd = value.toCreatePicklistRoleMvo();
            if (cmd.getPicklistRoleId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "PicklistRoleMvo");
            }
            picklistRoleMvoApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getPicklistRoleId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchPicklistRoleMvoDto value) {
        try {
            if (value.getPicklistVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                PicklistRoleMvoCommand.MergePatchPicklistRoleMvo cmd = (PicklistRoleMvoCommand.MergePatchPicklistRoleMvo) value.toCommand();
                PicklistRoleMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                picklistRoleMvoApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            PicklistRoleMvoCommand.CreatePicklistRoleMvo cmd = (PicklistRoleMvoCommand.CreatePicklistRoleMvo) value.toCommand();
            PicklistRoleMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            picklistRoleMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchPicklistRoleMvoDto.MergePatchPicklistRoleMvoDto value) {
        try {

            PicklistRoleMvoCommand.MergePatchPicklistRoleMvo cmd = value.toMergePatchPicklistRoleMvo();
            PicklistRoleMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            picklistRoleMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            PicklistRoleMvoCommand.DeletePicklistRoleMvo deleteCmd = new AbstractPicklistRoleMvoCommand.SimpleDeletePicklistRoleMvo();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setPicklistVersion(version);
            PicklistRoleMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            picklistRoleMvoApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            PicklistRoleMvoMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_stateEvents/{version}")
    public PicklistRoleMvoStateEventDto getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            PicklistRoleId idObj = PicklistRoleMvoResourceUtils.parseIdString(id);
            PicklistRoleMvoStateEventDtoConverter dtoConverter = getPicklistRoleMvoStateEventDtoConverter();
            return dtoConverter.toPicklistRoleMvoStateEventDto((AbstractPicklistRoleMvoEvent) picklistRoleMvoApplicationService.getEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public PicklistRoleMvoStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            PicklistRoleId idObj = PicklistRoleMvoResourceUtils.parseIdString(id);
            PicklistRoleMvoStateDto.DtoConverter dtoConverter = new PicklistRoleMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPicklistRoleMvoStateDto(picklistRoleMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  PicklistRoleMvoStateEventDtoConverter getPicklistRoleMvoStateEventDtoConverter() {
        return new PicklistRoleMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PicklistRoleMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class PicklistRoleMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return PicklistRoleMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class PicklistRoleMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, PicklistRoleMvoCommand value) {
            PicklistRoleId idObj = parseIdString(id);
            if (value.getPicklistRoleId() == null) {
                value.setPicklistRoleId(idObj);
            } else if (!value.getPicklistRoleId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getPicklistRoleId());
            }
        }
    

        public static PicklistRoleId parseIdString(String idString) {
            TextFormatter<PicklistRoleId> formatter =
                    new AbstractValueObjectTextFormatter<PicklistRoleId>(PicklistRoleId.class) {
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
            if (PicklistRoleMvoMetadata.aliasMap.containsKey(fieldName)) {
                return PicklistRoleMvoMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (PicklistRoleMvoMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = PicklistRoleMvoMetadata.propertyTypeMap.get(propertyName);
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

        public static PicklistRoleMvoStateDto[] toPicklistRoleMvoStateDtoArray(Iterable<PicklistRoleId> ids) {
            List<PicklistRoleMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                PicklistRoleMvoStateDto dto = new PicklistRoleMvoStateDto();
                dto.setPicklistRoleId(id);
                states.add(dto);
            });
            return states.toArray(new PicklistRoleMvoStateDto[0]);
        }

    }

}

