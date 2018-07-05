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
import org.dddml.wms.domain.pickwave.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "Pickwaves", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class PickwaveResource {


    @Autowired
    private PickwaveApplicationService pickwaveApplicationService;


    @GetMapping
    public PickwaveStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<PickwaveState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = pickwaveApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (PickwaveMetadata.aliasMap.containsKey(n) ? PickwaveMetadata.aliasMap.get(n) : n)),
                        PickwaveResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = pickwaveApplicationService.get(
                        PickwaveResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        PickwaveResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            PickwaveStateDto.DtoConverter dtoConverter = new PickwaveStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPickwaveStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public PickwaveStateDto get(@PathVariable("id") Long id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            Long idObj = id;
            PickwaveState state = pickwaveApplicationService.get(idObj);
            if (state == null) { return null; }

            PickwaveStateDto.DtoConverter dtoConverter = new PickwaveStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPickwaveStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = pickwaveApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (PickwaveMetadata.aliasMap.containsKey(n) ? PickwaveMetadata.aliasMap.get(n) : n)));
            } else {
                count = pickwaveApplicationService.getCount(PickwaveResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public Long post(@RequestBody CreateOrMergePatchPickwaveDto.CreatePickwaveDto value,  HttpServletResponse response) {
        try {
            PickwaveCommand.CreatePickwave cmd = value.toCreatePickwave();
            if (cmd.getPickwaveId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "Pickwave");
            }
            pickwaveApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getPickwaveId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") Long id, @RequestBody CreateOrMergePatchPickwaveDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                PickwaveCommand.MergePatchPickwave cmd = (PickwaveCommand.MergePatchPickwave) value.toCommand();
                PickwaveResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                pickwaveApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            PickwaveCommand.CreatePickwave cmd = (PickwaveCommand.CreatePickwave) value.toCommand();
            PickwaveResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            pickwaveApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") Long id, @RequestBody CreateOrMergePatchPickwaveDto.MergePatchPickwaveDto value) {
        try {

            PickwaveCommand.MergePatchPickwave cmd = value.toMergePatchPickwave();
            PickwaveResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            pickwaveApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            PickwaveCommand.DeletePickwave deleteCmd = new AbstractPickwaveCommand.SimpleDeletePickwave();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            PickwaveResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            pickwaveApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            PickwaveMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_stateEvents/{version}")
    public PickwaveStateEventDto getStateEvent(@PathVariable("id") Long id, @PathVariable("version") long version) {
        try {

            Long idObj = id;
            PickwaveStateEventDtoConverter dtoConverter = getPickwaveStateEventDtoConverter();
            return dtoConverter.toPickwaveStateEventDto((AbstractPickwaveEvent) pickwaveApplicationService.getEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public PickwaveStateDto getHistoryState(@PathVariable("id") Long id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            Long idObj = id;
            PickwaveStateDto.DtoConverter dtoConverter = new PickwaveStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPickwaveStateDto(pickwaveApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  PickwaveStateEventDtoConverter getPickwaveStateEventDtoConverter() {
        return new PickwaveStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PickwavePropertyTypeResolver();
    }

    // ////////////////////////////////

    private class PickwavePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return PickwaveResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class PickwaveResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(Long id, PickwaveCommand value) {
            Long idObj = id;
            if (value.getPickwaveId() == null) {
                value.setPickwaveId(idObj);
            } else if (!value.getPickwaveId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getPickwaveId());
            }
        }
    


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (PickwaveMetadata.aliasMap.containsKey(fieldName)) {
                return PickwaveMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (PickwaveMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = PickwaveMetadata.propertyTypeMap.get(propertyName);
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

        public static PickwaveStateDto[] toPickwaveStateDtoArray(Iterable<Long> ids) {
            List<PickwaveStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                PickwaveStateDto dto = new PickwaveStateDto();
                dto.setPickwaveId(id);
                states.add(dto);
            });
            return states.toArray(new PickwaveStateDto[0]);
        }

    }

}

