package org.dddml.wms.restful.resource;

import java.util.*;
import java.util.stream.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.picklist.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "Picklists", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class PicklistResource {


    @Autowired
    private PicklistApplicationService picklistApplicationService;


    @GetMapping
    public PicklistStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<PicklistState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap());
            }
            states = picklistApplicationService.get(
                CriterionDto.toSubclass(
                        criterion,
                        getCriterionTypeConverter(), 
                        getPropertyTypeResolver(), 
                        n -> (PicklistMetadata.aliasMap.containsKey(n) ? PicklistMetadata.aliasMap.get(n) : n)),
                PicklistResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            PicklistStateDto.DtoConverter dtoConverter = new PicklistStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPicklistStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_page")
    public Page<PicklistStateDto> getPage( HttpServletRequest request,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "page", defaultValue = "0") Integer page,
                                   @RequestParam(value = "size", required = false) @NotNull Integer size) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<PicklistState> states = null; 
            Criterion criterion = CriterionDto.toSubclass(
                QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> PicklistResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue()))),
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (PicklistMetadata.aliasMap.containsKey(n) ? PicklistMetadata.aliasMap.get(n) : n));
            states = picklistApplicationService.get(
                criterion,
                PicklistResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = picklistApplicationService.getCount(criterion);

            PicklistStateDto.DtoConverter dtoConverter = new PicklistStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<PicklistStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toPicklistStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            statePage.setTotalElements(count);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public PicklistStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = id;
            PicklistState state = picklistApplicationService.get(idObj);
            if (state == null) { return null; }

            PicklistStateDto.DtoConverter dtoConverter = new PicklistStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPicklistStateDto(state);

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
            count = picklistApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (PicklistMetadata.aliasMap.containsKey(n) ? PicklistMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public String post(@RequestBody CreateOrMergePatchPicklistDto.CreatePicklistDto value,  HttpServletResponse response) {
        try {
            PicklistCommand.CreatePicklist cmd = value.toCreatePicklist();
            if (cmd.getPicklistId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "Picklist");
            }
            picklistApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getPicklistId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchPicklistDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                PicklistCommand.MergePatchPicklist cmd = (PicklistCommand.MergePatchPicklist) value.toCommand();
                PicklistResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                picklistApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            PicklistCommand.CreatePicklist cmd = (PicklistCommand.CreatePicklist) value.toCommand();
            PicklistResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            picklistApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchPicklistDto.MergePatchPicklistDto value) {
        try {

            PicklistCommand.MergePatchPicklist cmd = value.toMergePatchPicklist();
            PicklistResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            picklistApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            PicklistCommand.DeletePicklist deleteCmd = new AbstractPicklistCommand.SimpleDeletePicklist();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            PicklistResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            picklistApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            PicklistMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_events/{version}")
    public PicklistEvent getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            String idObj = id;
            //PicklistStateEventDtoConverter dtoConverter = getPicklistStateEventDtoConverter();
            return picklistApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public PicklistStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = id;
            PicklistStateDto.DtoConverter dtoConverter = new PicklistStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPicklistStateDto(picklistApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{picklistId}/PicklistRoles/{partyRoleId}")
    public PicklistRoleStateDto getPicklistRole(@PathVariable("picklistId") String picklistId, @PathVariable("partyRoleId") String partyRoleId) {
        try {

            PicklistRoleState state = picklistApplicationService.getPicklistRole(picklistId, (new AbstractValueObjectTextFormatter<PartyRoleId>(PartyRoleId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(partyRoleId)));
            if (state == null) { return null; }
            PicklistRoleStateDto.DtoConverter dtoConverter = new PicklistRoleStateDto.DtoConverter();
            PicklistRoleStateDto stateDto = dtoConverter.toPicklistRoleStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @PutMapping("{picklistId}/PicklistRoles/{partyRoleId}")
    public void putPicklistRole(@PathVariable("picklistId") String picklistId, @PathVariable("partyRoleId") String partyRoleId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchPicklistRoleDto.MergePatchPicklistRoleDto body) {
        try {
            PicklistCommand.MergePatchPicklist mergePatchPicklist = new AbstractPicklistCommand.SimpleMergePatchPicklist();
            mergePatchPicklist.setPicklistId(picklistId);
            mergePatchPicklist.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchPicklist.setVersion(version); }
            mergePatchPicklist.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            PicklistRoleCommand.MergePatchPicklistRole mergePatchPicklistRole = body.toMergePatchPicklistRole();
            mergePatchPicklistRole.setPartyRoleId((new AbstractValueObjectTextFormatter<PartyRoleId>(PartyRoleId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(partyRoleId)));
            mergePatchPicklist.getPicklistRoleCommands().add(mergePatchPicklistRole);
            picklistApplicationService.when(mergePatchPicklist);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{picklistId}/PicklistRoles/{partyRoleId}")
    public void deletePicklistRole(@PathVariable("picklistId") String picklistId, @PathVariable("partyRoleId") String partyRoleId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            PicklistCommand.MergePatchPicklist mergePatchPicklist = new AbstractPicklistCommand.SimpleMergePatchPicklist();
            mergePatchPicklist.setPicklistId(picklistId);
            mergePatchPicklist.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchPicklist.setVersion(version); }
            mergePatchPicklist.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            PicklistRoleCommand.RemovePicklistRole removePicklistRole = new AbstractPicklistRoleCommand.SimpleRemovePicklistRole();
            removePicklistRole.setPartyRoleId((new AbstractValueObjectTextFormatter<PartyRoleId>(PartyRoleId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(partyRoleId)));
            mergePatchPicklist.getPicklistRoleCommands().add(removePicklistRole);
            picklistApplicationService.when(mergePatchPicklist);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{picklistId}/PicklistRoles/")
    public PicklistRoleStateDto[] getPicklistRoles(@PathVariable("picklistId") String picklistId) {
        try {
            Iterable<PicklistRoleState> states = picklistApplicationService.getPicklistRoles(picklistId);
            if (states == null) { return null; }
            PicklistRoleStateDto.DtoConverter dtoConverter = new PicklistRoleStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toPicklistRoleStateDtoArray(states);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @PostMapping("{picklistId}/PicklistRoles/")
    public void postPicklistRoles(@PathVariable("picklistId") String picklistId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchPicklistRoleDto.CreatePicklistRoleDto body) {
        try {
            PicklistCommand.MergePatchPicklist mergePatchPicklist = new AbstractPicklistCommand.SimpleMergePatchPicklist();
            mergePatchPicklist.setPicklistId(picklistId);
            mergePatchPicklist.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchPicklist.setVersion(version); }
            mergePatchPicklist.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            PicklistRoleCommand.CreatePicklistRole createPicklistRole = body.toCreatePicklistRole();
            mergePatchPicklist.getPicklistRoleCommands().add(createPicklistRole);
            picklistApplicationService.when(mergePatchPicklist);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  PicklistStateEventDtoConverter getPicklistStateEventDtoConverter() {
    //    return new PicklistStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PicklistPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class PicklistPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return PicklistResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class PicklistResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String id, PicklistCommand value) {
            String idObj = id;
            if (value.getPicklistId() == null) {
                value.setPicklistId(idObj);
            } else if (!value.getPicklistId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getPicklistId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, PicklistMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, PicklistMetadata.aliasMap);
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (PicklistMetadata.aliasMap.containsKey(fieldName)) {
                return PicklistMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (PicklistMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = PicklistMetadata.propertyTypeMap.get(propertyName);
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

        public static PicklistStateDto[] toPicklistStateDtoArray(Iterable<String> ids) {
            List<PicklistStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                PicklistStateDto dto = new PicklistStateDto();
                dto.setPicklistId(id);
                states.add(dto);
            });
            return states.toArray(new PicklistStateDto[0]);
        }

    }

}

