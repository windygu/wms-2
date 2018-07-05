package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.attributeset.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.attributeusemvo.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "AttributeUseMvos", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class AttributeUseMvoResource {


    @Autowired
    private AttributeUseMvoApplicationService attributeUseMvoApplicationService;


    @GetMapping
    public AttributeUseMvoStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<AttributeUseMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = attributeUseMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (AttributeUseMvoMetadata.aliasMap.containsKey(n) ? AttributeUseMvoMetadata.aliasMap.get(n) : n)),
                        AttributeUseMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = attributeUseMvoApplicationService.get(
                        AttributeUseMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        AttributeUseMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            AttributeUseMvoStateDto.DtoConverter dtoConverter = new AttributeUseMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeUseMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public AttributeUseMvoStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            AttributeSetAttributeUseId idObj = AttributeUseMvoResourceUtils.parseIdString(id);
            AttributeUseMvoState state = attributeUseMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            AttributeUseMvoStateDto.DtoConverter dtoConverter = new AttributeUseMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeUseMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = attributeUseMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (AttributeUseMvoMetadata.aliasMap.containsKey(n) ? AttributeUseMvoMetadata.aliasMap.get(n) : n)));
            } else {
                count = attributeUseMvoApplicationService.getCount(AttributeUseMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public AttributeSetAttributeUseId post(@RequestBody CreateOrMergePatchAttributeUseMvoDto.CreateAttributeUseMvoDto value,  HttpServletResponse response) {
        try {
            AttributeUseMvoCommand.CreateAttributeUseMvo cmd = value.toCreateAttributeUseMvo();
            if (cmd.getAttributeSetAttributeUseId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "AttributeUseMvo");
            }
            attributeUseMvoApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getAttributeSetAttributeUseId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchAttributeUseMvoDto value) {
        try {
            if (value.getAttributeSetVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                AttributeUseMvoCommand.MergePatchAttributeUseMvo cmd = (AttributeUseMvoCommand.MergePatchAttributeUseMvo) value.toCommand();
                AttributeUseMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                attributeUseMvoApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            AttributeUseMvoCommand.CreateAttributeUseMvo cmd = (AttributeUseMvoCommand.CreateAttributeUseMvo) value.toCommand();
            AttributeUseMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeUseMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchAttributeUseMvoDto.MergePatchAttributeUseMvoDto value) {
        try {

            AttributeUseMvoCommand.MergePatchAttributeUseMvo cmd = value.toMergePatchAttributeUseMvo();
            AttributeUseMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeUseMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            AttributeUseMvoCommand.DeleteAttributeUseMvo deleteCmd = new AbstractAttributeUseMvoCommand.SimpleDeleteAttributeUseMvo();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setAttributeSetVersion(version);
            AttributeUseMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            attributeUseMvoApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            AttributeUseMvoMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_stateEvents/{version}")
    public AttributeUseMvoStateEventDto getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            AttributeSetAttributeUseId idObj = AttributeUseMvoResourceUtils.parseIdString(id);
            AttributeUseMvoStateEventDtoConverter dtoConverter = getAttributeUseMvoStateEventDtoConverter();
            return dtoConverter.toAttributeUseMvoStateEventDto((AbstractAttributeUseMvoEvent) attributeUseMvoApplicationService.getEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public AttributeUseMvoStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            AttributeSetAttributeUseId idObj = AttributeUseMvoResourceUtils.parseIdString(id);
            AttributeUseMvoStateDto.DtoConverter dtoConverter = new AttributeUseMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeUseMvoStateDto(attributeUseMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  AttributeUseMvoStateEventDtoConverter getAttributeUseMvoStateEventDtoConverter() {
        return new AttributeUseMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new AttributeUseMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class AttributeUseMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return AttributeUseMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class AttributeUseMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, AttributeUseMvoCommand value) {
            AttributeSetAttributeUseId idObj = parseIdString(id);
            if (value.getAttributeSetAttributeUseId() == null) {
                value.setAttributeSetAttributeUseId(idObj);
            } else if (!value.getAttributeSetAttributeUseId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getAttributeSetAttributeUseId());
            }
        }
    

        public static AttributeSetAttributeUseId parseIdString(String idString) {
            TextFormatter<AttributeSetAttributeUseId> formatter =
                    new AbstractValueObjectTextFormatter<AttributeSetAttributeUseId>(AttributeSetAttributeUseId.class) {
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
            if (AttributeUseMvoMetadata.aliasMap.containsKey(fieldName)) {
                return AttributeUseMvoMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (AttributeUseMvoMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = AttributeUseMvoMetadata.propertyTypeMap.get(propertyName);
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

        public static AttributeUseMvoStateDto[] toAttributeUseMvoStateDtoArray(Iterable<AttributeSetAttributeUseId> ids) {
            List<AttributeUseMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                AttributeUseMvoStateDto dto = new AttributeUseMvoStateDto();
                dto.setAttributeSetAttributeUseId(id);
                states.add(dto);
            });
            return states.toArray(new AttributeUseMvoStateDto[0]);
        }

    }

}

