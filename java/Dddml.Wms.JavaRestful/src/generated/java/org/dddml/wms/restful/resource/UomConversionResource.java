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
import org.dddml.wms.domain.uomconversion.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "UomConversions", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class UomConversionResource {


    @Autowired
    private UomConversionApplicationService uomConversionApplicationService;


    @GetMapping
    public UomConversionStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<UomConversionState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = uomConversionApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (UomConversionMetadata.aliasMap.containsKey(n) ? UomConversionMetadata.aliasMap.get(n) : n)),
                        UomConversionResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = uomConversionApplicationService.get(
                        UomConversionResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        UomConversionResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            UomConversionStateDto.DtoConverter dtoConverter = new UomConversionStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toUomConversionStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public UomConversionStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            UomConversionId idObj = UomConversionResourceUtils.parseIdString(id);
            UomConversionState state = uomConversionApplicationService.get(idObj);
            if (state == null) { return null; }

            UomConversionStateDto.DtoConverter dtoConverter = new UomConversionStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toUomConversionStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = uomConversionApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (UomConversionMetadata.aliasMap.containsKey(n) ? UomConversionMetadata.aliasMap.get(n) : n)));
            } else {
                count = uomConversionApplicationService.getCount(UomConversionResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public UomConversionId post(@RequestBody CreateOrMergePatchUomConversionDto.CreateUomConversionDto value,  HttpServletResponse response) {
        try {
            UomConversionCommand.CreateUomConversion cmd = value.toCreateUomConversion();
            if (cmd.getUomConversionId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "UomConversion");
            }
            uomConversionApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getUomConversionId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchUomConversionDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                UomConversionCommand.MergePatchUomConversion cmd = (UomConversionCommand.MergePatchUomConversion) value.toCommand();
                UomConversionResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                uomConversionApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            UomConversionCommand.CreateUomConversion cmd = (UomConversionCommand.CreateUomConversion) value.toCommand();
            UomConversionResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            uomConversionApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchUomConversionDto.MergePatchUomConversionDto value) {
        try {

            UomConversionCommand.MergePatchUomConversion cmd = value.toMergePatchUomConversion();
            UomConversionResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            uomConversionApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            UomConversionCommand.DeleteUomConversion deleteCmd = new AbstractUomConversionCommand.SimpleDeleteUomConversion();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            UomConversionResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            uomConversionApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            UomConversionMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_events/{version}")
    public UomConversionEvent getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            UomConversionId idObj = UomConversionResourceUtils.parseIdString(id);
            //UomConversionStateEventDtoConverter dtoConverter = getUomConversionStateEventDtoConverter();
            return uomConversionApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public UomConversionStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            UomConversionId idObj = UomConversionResourceUtils.parseIdString(id);
            UomConversionStateDto.DtoConverter dtoConverter = new UomConversionStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toUomConversionStateDto(uomConversionApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  UomConversionStateEventDtoConverter getUomConversionStateEventDtoConverter() {
    //    return new UomConversionStateEventDtoConverter();
    //}

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new UomConversionPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class UomConversionPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return UomConversionResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class UomConversionResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, UomConversionCommand value) {
            UomConversionId idObj = parseIdString(id);
            if (value.getUomConversionId() == null) {
                value.setUomConversionId(idObj);
            } else if (!value.getUomConversionId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getUomConversionId());
            }
        }
    

        public static UomConversionId parseIdString(String idString) {
            TextFormatter<UomConversionId> formatter =
                    new AbstractValueObjectTextFormatter<UomConversionId>(UomConversionId.class) {
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
            if (UomConversionMetadata.aliasMap.containsKey(fieldName)) {
                return UomConversionMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (UomConversionMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = UomConversionMetadata.propertyTypeMap.get(propertyName);
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

        public static UomConversionStateDto[] toUomConversionStateDtoArray(Iterable<UomConversionId> ids) {
            List<UomConversionStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                UomConversionStateDto dto = new UomConversionStateDto();
                dto.setUomConversionId(id);
                states.add(dto);
            });
            return states.toArray(new UomConversionStateDto[0]);
        }

    }

}

