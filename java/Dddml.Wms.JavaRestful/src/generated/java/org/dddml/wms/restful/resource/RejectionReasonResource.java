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
import org.dddml.wms.domain.rejectionreason.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "RejectionReasons", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class RejectionReasonResource {


    @Autowired
    private RejectionReasonApplicationService rejectionReasonApplicationService;


    @GetMapping
    public RejectionReasonStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<RejectionReasonState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = rejectionReasonApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (RejectionReasonMetadata.aliasMap.containsKey(n) ? RejectionReasonMetadata.aliasMap.get(n) : n)),
                        RejectionReasonResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = rejectionReasonApplicationService.get(
                        RejectionReasonResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        RejectionReasonResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            RejectionReasonStateDto.DtoConverter dtoConverter = new RejectionReasonStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toRejectionReasonStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public RejectionReasonStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = id;
            RejectionReasonState state = rejectionReasonApplicationService.get(idObj);
            if (state == null) { return null; }

            RejectionReasonStateDto.DtoConverter dtoConverter = new RejectionReasonStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toRejectionReasonStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = rejectionReasonApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (RejectionReasonMetadata.aliasMap.containsKey(n) ? RejectionReasonMetadata.aliasMap.get(n) : n)));
            } else {
                count = rejectionReasonApplicationService.getCount(RejectionReasonResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public String post(@RequestBody CreateOrMergePatchRejectionReasonDto.CreateRejectionReasonDto value,  HttpServletResponse response) {
        try {
            RejectionReasonCommand.CreateRejectionReason cmd = value.toCreateRejectionReason();
            if (cmd.getRejectionReasonId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "RejectionReason");
            }
            rejectionReasonApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getRejectionReasonId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchRejectionReasonDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                RejectionReasonCommand.MergePatchRejectionReason cmd = (RejectionReasonCommand.MergePatchRejectionReason) value.toCommand();
                RejectionReasonResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                rejectionReasonApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            RejectionReasonCommand.CreateRejectionReason cmd = (RejectionReasonCommand.CreateRejectionReason) value.toCommand();
            RejectionReasonResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            rejectionReasonApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchRejectionReasonDto.MergePatchRejectionReasonDto value) {
        try {

            RejectionReasonCommand.MergePatchRejectionReason cmd = value.toMergePatchRejectionReason();
            RejectionReasonResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            rejectionReasonApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            RejectionReasonCommand.DeleteRejectionReason deleteCmd = new AbstractRejectionReasonCommand.SimpleDeleteRejectionReason();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            RejectionReasonResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            rejectionReasonApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            RejectionReasonMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_events/{version}")
    public RejectionReasonEvent getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            String idObj = id;
            //RejectionReasonStateEventDtoConverter dtoConverter = getRejectionReasonStateEventDtoConverter();
            return rejectionReasonApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public RejectionReasonStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = id;
            RejectionReasonStateDto.DtoConverter dtoConverter = new RejectionReasonStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toRejectionReasonStateDto(rejectionReasonApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  RejectionReasonStateEventDtoConverter getRejectionReasonStateEventDtoConverter() {
    //    return new RejectionReasonStateEventDtoConverter();
    //}

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new RejectionReasonPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class RejectionReasonPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return RejectionReasonResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class RejectionReasonResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, RejectionReasonCommand value) {
            String idObj = id;
            if (value.getRejectionReasonId() == null) {
                value.setRejectionReasonId(idObj);
            } else if (!value.getRejectionReasonId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getRejectionReasonId());
            }
        }
    


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (RejectionReasonMetadata.aliasMap.containsKey(fieldName)) {
                return RejectionReasonMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (RejectionReasonMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = RejectionReasonMetadata.propertyTypeMap.get(propertyName);
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

        public static RejectionReasonStateDto[] toRejectionReasonStateDtoArray(Iterable<String> ids) {
            List<RejectionReasonStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                RejectionReasonStateDto dto = new RejectionReasonStateDto();
                dto.setRejectionReasonId(id);
                states.add(dto);
            });
            return states.toArray(new RejectionReasonStateDto[0]);
        }

    }

}

