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
import org.dddml.wms.domain.attributeset.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "AttributeSets", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class AttributeSetResource {


    @Autowired
    private AttributeSetApplicationService attributeSetApplicationService;


    @GetMapping
    public AttributeSetStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<AttributeSetState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = attributeSetApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (AttributeSetMetadata.aliasMap.containsKey(n) ? AttributeSetMetadata.aliasMap.get(n) : n)),
                        AttributeSetResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = attributeSetApplicationService.get(
                        AttributeSetResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        AttributeSetResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            AttributeSetStateDto.DtoConverter dtoConverter = new AttributeSetStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeSetStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public AttributeSetStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = id;
            AttributeSetState state = attributeSetApplicationService.get(idObj);
            if (state == null) { return null; }

            AttributeSetStateDto.DtoConverter dtoConverter = new AttributeSetStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeSetStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = attributeSetApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (AttributeSetMetadata.aliasMap.containsKey(n) ? AttributeSetMetadata.aliasMap.get(n) : n)));
            } else {
                count = attributeSetApplicationService.getCount(AttributeSetResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public String post(@RequestBody CreateOrMergePatchAttributeSetDto.CreateAttributeSetDto value,  HttpServletResponse response) {
        try {
            AttributeSetCommand.CreateAttributeSet cmd = value.toCreateAttributeSet();
            if (cmd.getAttributeSetId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "AttributeSet");
            }
            attributeSetApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getAttributeSetId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchAttributeSetDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                AttributeSetCommand.MergePatchAttributeSet cmd = (AttributeSetCommand.MergePatchAttributeSet) value.toCommand();
                AttributeSetResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                attributeSetApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            AttributeSetCommand.CreateAttributeSet cmd = (AttributeSetCommand.CreateAttributeSet) value.toCommand();
            AttributeSetResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeSetApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchAttributeSetDto.MergePatchAttributeSetDto value) {
        try {

            AttributeSetCommand.MergePatchAttributeSet cmd = value.toMergePatchAttributeSet();
            AttributeSetResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeSetApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            AttributeSetCommand.DeleteAttributeSet deleteCmd = new AbstractAttributeSetCommand.SimpleDeleteAttributeSet();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            AttributeSetResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            attributeSetApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            AttributeSetMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_events/{version}")
    public AttributeSetEvent getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            String idObj = id;
            //AttributeSetStateEventDtoConverter dtoConverter = getAttributeSetStateEventDtoConverter();
            return attributeSetApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public AttributeSetStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = id;
            AttributeSetStateDto.DtoConverter dtoConverter = new AttributeSetStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeSetStateDto(attributeSetApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{attributeSetId}/AttributeUses/{attributeId}")
    public AttributeUseStateDto getAttributeUse(@PathVariable("attributeSetId") String attributeSetId, @PathVariable("attributeId") String attributeId) {
        try {

            AttributeUseState state = attributeSetApplicationService.getAttributeUse(attributeSetId, attributeId);
            if (state == null) { return null; }
            AttributeUseStateDto.DtoConverter dtoConverter = new AttributeUseStateDto.DtoConverter();
            AttributeUseStateDto stateDto = dtoConverter.toAttributeUseStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{attributeSetId}/AttributeUses/")
    public AttributeUseStateDto[] getAttributeUses(@PathVariable("attributeSetId") String attributeSetId) {
        try {
            Iterable<AttributeUseState> states = attributeSetApplicationService.getAttributeUses(attributeSetId);
            if (states == null) { return null; }
            AttributeUseStateDto.DtoConverter dtoConverter = new AttributeUseStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toAttributeUseStateDtoArray(states);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @PostMapping("{attributeSetId}/AttributeUses/")
    public void postAttributeUses(@PathVariable("attributeSetId") String attributeSetId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchAttributeUseDto.CreateAttributeUseDto body) {
        try {
            AttributeSetCommand.MergePatchAttributeSet mergePatchAttributeSet = new AbstractAttributeSetCommand.SimpleMergePatchAttributeSet();
            mergePatchAttributeSet.setAttributeSetId(attributeSetId);
            mergePatchAttributeSet.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchAttributeSet.setVersion(version); }
            mergePatchAttributeSet.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            AttributeUseCommand.CreateAttributeUse createAttributeUse = body.toCreateAttributeUse();
            mergePatchAttributeSet.getAttributeUseCommands().add(createAttributeUse);
            attributeSetApplicationService.when(mergePatchAttributeSet);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  AttributeSetStateEventDtoConverter getAttributeSetStateEventDtoConverter() {
    //    return new AttributeSetStateEventDtoConverter();
    //}

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new AttributeSetPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class AttributeSetPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return AttributeSetResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class AttributeSetResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, AttributeSetCommand value) {
            String idObj = id;
            if (value.getAttributeSetId() == null) {
                value.setAttributeSetId(idObj);
            } else if (!value.getAttributeSetId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getAttributeSetId());
            }
        }
    


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (AttributeSetMetadata.aliasMap.containsKey(fieldName)) {
                return AttributeSetMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (AttributeSetMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = AttributeSetMetadata.propertyTypeMap.get(propertyName);
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

        public static AttributeSetStateDto[] toAttributeSetStateDtoArray(Iterable<String> ids) {
            List<AttributeSetStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                AttributeSetStateDto dto = new AttributeSetStateDto();
                dto.setAttributeSetId(id);
                states.add(dto);
            });
            return states.toArray(new AttributeSetStateDto[0]);
        }

    }

}

