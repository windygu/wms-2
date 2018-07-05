package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.attribute.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.attributevaluemvo.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "AttributeValueMvos", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class AttributeValueMvoResource {


    @Autowired
    private AttributeValueMvoApplicationService attributeValueMvoApplicationService;


    @GetMapping
    public AttributeValueMvoStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<AttributeValueMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = attributeValueMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (AttributeValueMvoMetadata.aliasMap.containsKey(n) ? AttributeValueMvoMetadata.aliasMap.get(n) : n)),
                        AttributeValueMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = attributeValueMvoApplicationService.get(
                        AttributeValueMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        AttributeValueMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            AttributeValueMvoStateDto.DtoConverter dtoConverter = new AttributeValueMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeValueMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public AttributeValueMvoStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            AttributeValueId idObj = AttributeValueMvoResourceUtils.parseIdString(id);
            AttributeValueMvoState state = attributeValueMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            AttributeValueMvoStateDto.DtoConverter dtoConverter = new AttributeValueMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeValueMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = attributeValueMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (AttributeValueMvoMetadata.aliasMap.containsKey(n) ? AttributeValueMvoMetadata.aliasMap.get(n) : n)));
            } else {
                count = attributeValueMvoApplicationService.getCount(AttributeValueMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public AttributeValueId post(@RequestBody CreateOrMergePatchAttributeValueMvoDto.CreateAttributeValueMvoDto value,  HttpServletResponse response) {
        try {
            AttributeValueMvoCommand.CreateAttributeValueMvo cmd = value.toCreateAttributeValueMvo();
            if (cmd.getAttributeValueId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "AttributeValueMvo");
            }
            attributeValueMvoApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getAttributeValueId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchAttributeValueMvoDto value) {
        try {
            if (value.getAttributeVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                AttributeValueMvoCommand.MergePatchAttributeValueMvo cmd = (AttributeValueMvoCommand.MergePatchAttributeValueMvo) value.toCommand();
                AttributeValueMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                attributeValueMvoApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            AttributeValueMvoCommand.CreateAttributeValueMvo cmd = (AttributeValueMvoCommand.CreateAttributeValueMvo) value.toCommand();
            AttributeValueMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeValueMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchAttributeValueMvoDto.MergePatchAttributeValueMvoDto value) {
        try {

            AttributeValueMvoCommand.MergePatchAttributeValueMvo cmd = value.toMergePatchAttributeValueMvo();
            AttributeValueMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeValueMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            AttributeValueMvoCommand.DeleteAttributeValueMvo deleteCmd = new AbstractAttributeValueMvoCommand.SimpleDeleteAttributeValueMvo();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setAttributeVersion(version);
            AttributeValueMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            attributeValueMvoApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            AttributeValueMvoMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_stateEvents/{version}")
    public AttributeValueMvoStateEventDto getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            AttributeValueId idObj = AttributeValueMvoResourceUtils.parseIdString(id);
            AttributeValueMvoStateEventDtoConverter dtoConverter = getAttributeValueMvoStateEventDtoConverter();
            return dtoConverter.toAttributeValueMvoStateEventDto((AbstractAttributeValueMvoEvent) attributeValueMvoApplicationService.getEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public AttributeValueMvoStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            AttributeValueId idObj = AttributeValueMvoResourceUtils.parseIdString(id);
            AttributeValueMvoStateDto.DtoConverter dtoConverter = new AttributeValueMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeValueMvoStateDto(attributeValueMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  AttributeValueMvoStateEventDtoConverter getAttributeValueMvoStateEventDtoConverter() {
        return new AttributeValueMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new AttributeValueMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class AttributeValueMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return AttributeValueMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class AttributeValueMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, AttributeValueMvoCommand value) {
            AttributeValueId idObj = parseIdString(id);
            if (value.getAttributeValueId() == null) {
                value.setAttributeValueId(idObj);
            } else if (!value.getAttributeValueId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getAttributeValueId());
            }
        }
    

        public static AttributeValueId parseIdString(String idString) {
            TextFormatter<AttributeValueId> formatter =
                    new AbstractValueObjectTextFormatter<AttributeValueId>(AttributeValueId.class) {
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
            if (AttributeValueMvoMetadata.aliasMap.containsKey(fieldName)) {
                return AttributeValueMvoMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (AttributeValueMvoMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = AttributeValueMvoMetadata.propertyTypeMap.get(propertyName);
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

        public static AttributeValueMvoStateDto[] toAttributeValueMvoStateDtoArray(Iterable<AttributeValueId> ids) {
            List<AttributeValueMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                AttributeValueMvoStateDto dto = new AttributeValueMvoStateDto();
                dto.setAttributeValueId(id);
                states.add(dto);
            });
            return states.toArray(new AttributeValueMvoStateDto[0]);
        }

    }

}

