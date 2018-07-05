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

    @GetMapping("{id}/_stateEvents/{version}")
    public PicklistBinStateEventDto getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            String idObj = id;
            PicklistBinStateEventDtoConverter dtoConverter = getPicklistBinStateEventDtoConverter();
            return dtoConverter.toPicklistBinStateEventDto((AbstractPicklistBinEvent) picklistBinApplicationService.getEvent(idObj, version));

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


    protected  PicklistBinStateEventDtoConverter getPicklistBinStateEventDtoConverter() {
        return new PicklistBinStateEventDtoConverter();
    }

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

