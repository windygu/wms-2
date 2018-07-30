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
import org.dddml.wms.domain.picklistbin.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "PicklistBins", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class PicklistBinResource {


    @Autowired
    private PicklistBinApplicationService picklistBinApplicationService;


    @GetMapping
    public PicklistBinStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<PicklistBinState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = picklistBinApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (PicklistBinMetadata.aliasMap.containsKey(n) ? PicklistBinMetadata.aliasMap.get(n) : n)),
                        PicklistBinResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = picklistBinApplicationService.get(
                        PicklistBinResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        PicklistBinResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            PicklistBinStateDto.DtoConverter dtoConverter = new PicklistBinStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPicklistBinStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_page")
    public Page<PicklistBinStateDto> getPage( HttpServletRequest request,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "page", defaultValue = "0") Integer page,
                                   @RequestParam(value = "size", required = false) @NotNull Integer size) {
        try {
            List<String> sort = PicklistBinResourceUtils.getQuerySorts(request.getParameterMap());
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<PicklistBinState> states = null; 
            Iterable<Map.Entry<String, Object>> queryFilterMap = PicklistBinResourceUtils.getQueryFilterMap(request.getParameterMap());
            states = picklistBinApplicationService.get(
                        queryFilterMap,
                        PicklistBinResourceUtils.getQuerySorts(request.getParameterMap()),
                        firstResult, maxResults);
            long count = picklistBinApplicationService.getCount(queryFilterMap);

            PicklistBinStateDto.DtoConverter dtoConverter = new PicklistBinStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<PicklistBinStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toPicklistBinStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public PicklistBinStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = id;
            PicklistBinState state = picklistBinApplicationService.get(idObj);
            if (state == null) { return null; }

            PicklistBinStateDto.DtoConverter dtoConverter = new PicklistBinStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPicklistBinStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = picklistBinApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (PicklistBinMetadata.aliasMap.containsKey(n) ? PicklistBinMetadata.aliasMap.get(n) : n)));
            } else {
                count = picklistBinApplicationService.getCount(PicklistBinResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public String post(@RequestBody CreateOrMergePatchPicklistBinDto.CreatePicklistBinDto value,  HttpServletResponse response) {
        try {
            PicklistBinCommand.CreatePicklistBin cmd = value.toCreatePicklistBin();
            if (cmd.getPicklistBinId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "PicklistBin");
            }
            picklistBinApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getPicklistBinId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchPicklistBinDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                PicklistBinCommand.MergePatchPicklistBin cmd = (PicklistBinCommand.MergePatchPicklistBin) value.toCommand();
                PicklistBinResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                picklistBinApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            PicklistBinCommand.CreatePicklistBin cmd = (PicklistBinCommand.CreatePicklistBin) value.toCommand();
            PicklistBinResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            picklistBinApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchPicklistBinDto.MergePatchPicklistBinDto value) {
        try {

            PicklistBinCommand.MergePatchPicklistBin cmd = value.toMergePatchPicklistBin();
            PicklistBinResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            picklistBinApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            PicklistBinCommand.DeletePicklistBin deleteCmd = new AbstractPicklistBinCommand.SimpleDeletePicklistBin();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            PicklistBinResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            picklistBinApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            PicklistBinMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_events/{version}")
    public PicklistBinEvent getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            String idObj = id;
            //PicklistBinStateEventDtoConverter dtoConverter = getPicklistBinStateEventDtoConverter();
            return picklistBinApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public PicklistBinStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = id;
            PicklistBinStateDto.DtoConverter dtoConverter = new PicklistBinStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPicklistBinStateDto(picklistBinApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{picklistBinId}/PicklistItems/{picklistItemOrderShipGrpInvId}")
    public PicklistItemStateDto getPicklistItem(@PathVariable("picklistBinId") String picklistBinId, @PathVariable("picklistItemOrderShipGrpInvId") String picklistItemOrderShipGrpInvId) {
        try {

            PicklistItemState state = picklistBinApplicationService.getPicklistItem(picklistBinId, (new AbstractValueObjectTextFormatter<PicklistItemOrderShipGrpInvId>(PicklistItemOrderShipGrpInvId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(picklistItemOrderShipGrpInvId)));
            if (state == null) { return null; }
            PicklistItemStateDto.DtoConverter dtoConverter = new PicklistItemStateDto.DtoConverter();
            PicklistItemStateDto stateDto = dtoConverter.toPicklistItemStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @PutMapping("{picklistBinId}/PicklistItems/{picklistItemOrderShipGrpInvId}")
    public void putPicklistItem(@PathVariable("picklistBinId") String picklistBinId, @PathVariable("picklistItemOrderShipGrpInvId") String picklistItemOrderShipGrpInvId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchPicklistItemDto.MergePatchPicklistItemDto body) {
        try {
            PicklistBinCommand.MergePatchPicklistBin mergePatchPicklistBin = new AbstractPicklistBinCommand.SimpleMergePatchPicklistBin();
            mergePatchPicklistBin.setPicklistBinId(picklistBinId);
            mergePatchPicklistBin.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchPicklistBin.setVersion(version); }
            mergePatchPicklistBin.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            PicklistItemCommand.MergePatchPicklistItem mergePatchPicklistItem = body.toMergePatchPicklistItem();
            mergePatchPicklistItem.setPicklistItemOrderShipGrpInvId((new AbstractValueObjectTextFormatter<PicklistItemOrderShipGrpInvId>(PicklistItemOrderShipGrpInvId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(picklistItemOrderShipGrpInvId)));
            mergePatchPicklistBin.getPicklistItemCommands().add(mergePatchPicklistItem);
            picklistBinApplicationService.when(mergePatchPicklistBin);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{picklistBinId}/PicklistItems/{picklistItemOrderShipGrpInvId}")
    public void deletePicklistItem(@PathVariable("picklistBinId") String picklistBinId, @PathVariable("picklistItemOrderShipGrpInvId") String picklistItemOrderShipGrpInvId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            PicklistBinCommand.MergePatchPicklistBin mergePatchPicklistBin = new AbstractPicklistBinCommand.SimpleMergePatchPicklistBin();
            mergePatchPicklistBin.setPicklistBinId(picklistBinId);
            mergePatchPicklistBin.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchPicklistBin.setVersion(version); }
            mergePatchPicklistBin.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            PicklistItemCommand.RemovePicklistItem removePicklistItem = new AbstractPicklistItemCommand.SimpleRemovePicklistItem();
            removePicklistItem.setPicklistItemOrderShipGrpInvId((new AbstractValueObjectTextFormatter<PicklistItemOrderShipGrpInvId>(PicklistItemOrderShipGrpInvId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(picklistItemOrderShipGrpInvId)));
            mergePatchPicklistBin.getPicklistItemCommands().add(removePicklistItem);
            picklistBinApplicationService.when(mergePatchPicklistBin);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{picklistBinId}/PicklistItems/")
    public PicklistItemStateDto[] getPicklistItems(@PathVariable("picklistBinId") String picklistBinId) {
        try {
            Iterable<PicklistItemState> states = picklistBinApplicationService.getPicklistItems(picklistBinId);
            if (states == null) { return null; }
            PicklistItemStateDto.DtoConverter dtoConverter = new PicklistItemStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toPicklistItemStateDtoArray(states);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @PostMapping("{picklistBinId}/PicklistItems/")
    public void postPicklistItems(@PathVariable("picklistBinId") String picklistBinId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchPicklistItemDto.CreatePicklistItemDto body) {
        try {
            PicklistBinCommand.MergePatchPicklistBin mergePatchPicklistBin = new AbstractPicklistBinCommand.SimpleMergePatchPicklistBin();
            mergePatchPicklistBin.setPicklistBinId(picklistBinId);
            mergePatchPicklistBin.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchPicklistBin.setVersion(version); }
            mergePatchPicklistBin.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            PicklistItemCommand.CreatePicklistItem createPicklistItem = body.toCreatePicklistItem();
            mergePatchPicklistBin.getPicklistItemCommands().add(createPicklistItem);
            picklistBinApplicationService.when(mergePatchPicklistBin);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  PicklistBinStateEventDtoConverter getPicklistBinStateEventDtoConverter() {
    //    return new PicklistBinStateEventDtoConverter();
    //}

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PicklistBinPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class PicklistBinPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return PicklistBinResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class PicklistBinResourceUtils {

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

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            List<String> sorts = new ArrayList<>();
            if (values == null) {
                return null;
            }
            if (values.length == 1
                    && !values[0].toLowerCase().endsWith(",asc")
                    && !values[0].toLowerCase().endsWith(",desc")) {
                return getQueryOrders(values[0], ",");
            }
            Arrays.stream(values).forEach(s -> {
                if (s.toLowerCase().endsWith(",asc")) {
                    String f = s.substring(0, s.length() - 4).trim();
                    if (!f.isEmpty()) {
                        sorts.add(f);
                    }
                } else if (s.toLowerCase().endsWith(",desc")) {
                    String f = s.substring(0, s.length() - 5).trim();
                    if (!f.isEmpty()) {
                        sorts.add("-" + f);
                    }
                } else {
                    String f = s.trim();
                    if (!f.isEmpty()) {
                        sorts.add(f);
                    }
                }
            });
            return sorts;
        }

        public static void setNullIdOrThrowOnInconsistentIds(String id, PicklistBinCommand value) {
            String idObj = id;
            if (value.getPicklistBinId() == null) {
                value.setPicklistBinId(idObj);
            } else if (!value.getPicklistBinId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getPicklistBinId());
            }
        }
    


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (PicklistBinMetadata.aliasMap.containsKey(fieldName)) {
                return PicklistBinMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (PicklistBinMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = PicklistBinMetadata.propertyTypeMap.get(propertyName);
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

        public static PicklistBinStateDto[] toPicklistBinStateDtoArray(Iterable<String> ids) {
            List<PicklistBinStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                PicklistBinStateDto dto = new PicklistBinStateDto();
                dto.setPicklistBinId(id);
                states.add(dto);
            });
            return states.toArray(new PicklistBinStateDto[0]);
        }

    }

}

