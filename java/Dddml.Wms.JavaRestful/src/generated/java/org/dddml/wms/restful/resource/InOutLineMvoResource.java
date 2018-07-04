package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.inout.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inoutlinemvo.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "InOutLineMvos", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class InOutLineMvoResource {


    @Autowired
    private InOutLineMvoApplicationService inOutLineMvoApplicationService;


    @GetMapping
    public InOutLineMvoStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<InOutLineMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = inOutLineMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (InOutLineMvoMetadata.aliasMap.containsKey(n) ? InOutLineMvoMetadata.aliasMap.get(n) : n)),
                        InOutLineMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = inOutLineMvoApplicationService.get(
                        InOutLineMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        InOutLineMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            InOutLineMvoStateDto.DtoConverter dtoConverter = new InOutLineMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInOutLineMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public InOutLineMvoStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            InOutLineId idObj = InOutLineMvoResourceUtils.parseIdString(id);
            InOutLineMvoState state = inOutLineMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            InOutLineMvoStateDto.DtoConverter dtoConverter = new InOutLineMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInOutLineMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = inOutLineMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (InOutLineMvoMetadata.aliasMap.containsKey(n) ? InOutLineMvoMetadata.aliasMap.get(n) : n)));
            } else {
                count = inOutLineMvoApplicationService.getCount(InOutLineMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public InOutLineId post(@RequestBody CreateOrMergePatchInOutLineMvoDto.CreateInOutLineMvoDto value,  HttpServletResponse response) {
        try {
            InOutLineMvoCommand.CreateInOutLineMvo cmd = value.toCreateInOutLineMvo();
            if (cmd.getInOutLineId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "InOutLineMvo");
            }
            inOutLineMvoApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getInOutLineId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchInOutLineMvoDto value) {
        try {
            if (value.getInOutVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                InOutLineMvoCommand.MergePatchInOutLineMvo cmd = (InOutLineMvoCommand.MergePatchInOutLineMvo) value.toCommand();
                InOutLineMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                inOutLineMvoApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            InOutLineMvoCommand.CreateInOutLineMvo cmd = (InOutLineMvoCommand.CreateInOutLineMvo) value.toCommand();
            InOutLineMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            inOutLineMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchInOutLineMvoDto.MergePatchInOutLineMvoDto value) {
        try {

            InOutLineMvoCommand.MergePatchInOutLineMvo cmd = value.toMergePatchInOutLineMvo();
            InOutLineMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            inOutLineMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            InOutLineMvoCommand.DeleteInOutLineMvo deleteCmd = new AbstractInOutLineMvoCommand.SimpleDeleteInOutLineMvo();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setInOutVersion(version);
            InOutLineMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            inOutLineMvoApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            InOutLineMvoMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_stateEvents/{version}")
    public InOutLineMvoStateEventDto getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            InOutLineId idObj = InOutLineMvoResourceUtils.parseIdString(id);
            InOutLineMvoStateEventDtoConverter dtoConverter = getInOutLineMvoStateEventDtoConverter();
            return dtoConverter.toInOutLineMvoStateEventDto((AbstractInOutLineMvoEvent) inOutLineMvoApplicationService.getEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public InOutLineMvoStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            InOutLineId idObj = InOutLineMvoResourceUtils.parseIdString(id);
            InOutLineMvoStateDto.DtoConverter dtoConverter = new InOutLineMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInOutLineMvoStateDto(inOutLineMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  InOutLineMvoStateEventDtoConverter getInOutLineMvoStateEventDtoConverter() {
        return new InOutLineMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new InOutLineMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class InOutLineMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return InOutLineMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class InOutLineMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, InOutLineMvoCommand value) {
            InOutLineId idObj = parseIdString(id);
            if (value.getInOutLineId() == null) {
                value.setInOutLineId(idObj);
            } else if (!value.getInOutLineId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getInOutLineId());
            }
        }
    

        public static InOutLineId parseIdString(String idString) {
            TextFormatter<InOutLineId> formatter =
                    new AbstractValueObjectTextFormatter<InOutLineId>(InOutLineId.class) {
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
            if (InOutLineMvoMetadata.aliasMap.containsKey(fieldName)) {
                return InOutLineMvoMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (InOutLineMvoMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = InOutLineMvoMetadata.propertyTypeMap.get(propertyName);
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

        public static InOutLineMvoStateDto[] toInOutLineMvoStateDtoArray(Iterable<InOutLineId> ids) {
            List<InOutLineMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                InOutLineMvoStateDto dto = new InOutLineMvoStateDto();
                dto.setInOutLineId(id);
                states.add(dto);
            });
            return states.toArray(new InOutLineMvoStateDto[0]);
        }

    }

}

