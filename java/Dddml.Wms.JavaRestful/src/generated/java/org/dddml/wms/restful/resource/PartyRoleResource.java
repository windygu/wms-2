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
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "PartyRoles", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class PartyRoleResource {


    @Autowired
    private PartyRoleApplicationService partyRoleApplicationService;


    @GetMapping
    public PartyRoleStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<PartyRoleState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap());
            }
            states = partyRoleApplicationService.get(
                CriterionDto.toSubclass(
                        criterion,
                        getCriterionTypeConverter(), 
                        getPropertyTypeResolver(), 
                        n -> (PartyRoleMetadata.aliasMap.containsKey(n) ? PartyRoleMetadata.aliasMap.get(n) : n)),
                PartyRoleResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            PartyRoleStateDto.DtoConverter dtoConverter = new PartyRoleStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPartyRoleStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_page")
    public Page<PartyRoleStateDto> getPage( HttpServletRequest request,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "page", defaultValue = "0") Integer page,
                                   @RequestParam(value = "size", required = false) @NotNull Integer size) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<PartyRoleState> states = null; 
            Criterion criterion = CriterionDto.toSubclass(
                QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> PartyRoleResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue()))),
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (PartyRoleMetadata.aliasMap.containsKey(n) ? PartyRoleMetadata.aliasMap.get(n) : n));
            states = partyRoleApplicationService.get(
                criterion,
                PartyRoleResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = partyRoleApplicationService.getCount(criterion);

            PartyRoleStateDto.DtoConverter dtoConverter = new PartyRoleStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<PartyRoleStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toPartyRoleStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            statePage.setTotalElements(count);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public PartyRoleStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            PartyRoleId idObj = PartyRoleResourceUtils.parseIdString(id);
            PartyRoleState state = partyRoleApplicationService.get(idObj);
            if (state == null) { return null; }

            PartyRoleStateDto.DtoConverter dtoConverter = new PartyRoleStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPartyRoleStateDto(state);

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
            count = partyRoleApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (PartyRoleMetadata.aliasMap.containsKey(n) ? PartyRoleMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public PartyRoleId post(@RequestBody CreateOrMergePatchPartyRoleDto.CreatePartyRoleDto value,  HttpServletResponse response) {
        try {
            PartyRoleCommand.CreatePartyRole cmd = value.toCreatePartyRole();
            if (cmd.getPartyRoleId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "PartyRole");
            }
            partyRoleApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getPartyRoleId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchPartyRoleDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                PartyRoleCommand.MergePatchPartyRole cmd = (PartyRoleCommand.MergePatchPartyRole) value.toCommand();
                PartyRoleResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                partyRoleApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            PartyRoleCommand.CreatePartyRole cmd = (PartyRoleCommand.CreatePartyRole) value.toCommand();
            PartyRoleResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            partyRoleApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchPartyRoleDto.MergePatchPartyRoleDto value) {
        try {

            PartyRoleCommand.MergePatchPartyRole cmd = value.toMergePatchPartyRole();
            PartyRoleResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            partyRoleApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            PartyRoleCommand.DeletePartyRole deleteCmd = new AbstractPartyRoleCommand.SimpleDeletePartyRole();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            PartyRoleResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            partyRoleApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            PartyRoleMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_events/{version}")
    public PartyRoleEvent getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            PartyRoleId idObj = PartyRoleResourceUtils.parseIdString(id);
            //PartyRoleStateEventDtoConverter dtoConverter = getPartyRoleStateEventDtoConverter();
            return partyRoleApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public PartyRoleStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            PartyRoleId idObj = PartyRoleResourceUtils.parseIdString(id);
            PartyRoleStateDto.DtoConverter dtoConverter = new PartyRoleStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPartyRoleStateDto(partyRoleApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  PartyRoleStateEventDtoConverter getPartyRoleStateEventDtoConverter() {
    //    return new PartyRoleStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PartyRolePropertyTypeResolver();
    }

    // ////////////////////////////////

    private class PartyRolePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return PartyRoleResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class PartyRoleResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String id, PartyRoleCommand value) {
            PartyRoleId idObj = parseIdString(id);
            if (value.getPartyRoleId() == null) {
                value.setPartyRoleId(idObj);
            } else if (!value.getPartyRoleId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getPartyRoleId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, PartyRoleMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, PartyRoleMetadata.aliasMap);
        }

        public static PartyRoleId parseIdString(String idString) {
            TextFormatter<PartyRoleId> formatter =
                    new AbstractValueObjectTextFormatter<PartyRoleId>(PartyRoleId.class) {
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
            if (PartyRoleMetadata.aliasMap.containsKey(fieldName)) {
                return PartyRoleMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (PartyRoleMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = PartyRoleMetadata.propertyTypeMap.get(propertyName);
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

        public static PartyRoleStateDto[] toPartyRoleStateDtoArray(Iterable<PartyRoleId> ids) {
            List<PartyRoleStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                PartyRoleStateDto dto = new PartyRoleStateDto();
                dto.setPartyRoleId(id);
                states.add(dto);
            });
            return states.toArray(new PartyRoleStateDto[0]);
        }

    }

}

