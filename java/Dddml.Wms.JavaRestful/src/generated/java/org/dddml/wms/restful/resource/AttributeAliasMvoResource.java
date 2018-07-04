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
import org.dddml.wms.domain.attributealiasmvo.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "AttributeAliasMvos", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class AttributeAliasMvoResource {


    @Autowired
    private AttributeAliasMvoApplicationService attributeAliasMvoApplicationService;


    @GetMapping
    public AttributeAliasMvoStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<AttributeAliasMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = attributeAliasMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (AttributeAliasMvoMetadata.aliasMap.containsKey(n) ? AttributeAliasMvoMetadata.aliasMap.get(n) : n)),
                        AttributeAliasMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = attributeAliasMvoApplicationService.get(
                        AttributeAliasMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        AttributeAliasMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            AttributeAliasMvoStateDto.DtoConverter dtoConverter = new AttributeAliasMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeAliasMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public AttributeAliasMvoStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            AttributeAliasId idObj = AttributeAliasMvoResourceUtils.parseIdString(id);
            AttributeAliasMvoState state = attributeAliasMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            AttributeAliasMvoStateDto.DtoConverter dtoConverter = new AttributeAliasMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeAliasMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = attributeAliasMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (AttributeAliasMvoMetadata.aliasMap.containsKey(n) ? AttributeAliasMvoMetadata.aliasMap.get(n) : n)));
            } else {
                count = attributeAliasMvoApplicationService.getCount(AttributeAliasMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public AttributeAliasId post(@RequestBody CreateOrMergePatchAttributeAliasMvoDto.CreateAttributeAliasMvoDto value,  HttpServletResponse response) {
        try {
            AttributeAliasMvoCommand.CreateAttributeAliasMvo cmd = value.toCreateAttributeAliasMvo();
            if (cmd.getAttributeAliasId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "AttributeAliasMvo");
            }
            attributeAliasMvoApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getAttributeAliasId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchAttributeAliasMvoDto value) {
        try {
            if (value.getAttributeVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                AttributeAliasMvoCommand.MergePatchAttributeAliasMvo cmd = (AttributeAliasMvoCommand.MergePatchAttributeAliasMvo) value.toCommand();
                AttributeAliasMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                attributeAliasMvoApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            AttributeAliasMvoCommand.CreateAttributeAliasMvo cmd = (AttributeAliasMvoCommand.CreateAttributeAliasMvo) value.toCommand();
            AttributeAliasMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeAliasMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchAttributeAliasMvoDto.MergePatchAttributeAliasMvoDto value) {
        try {

            AttributeAliasMvoCommand.MergePatchAttributeAliasMvo cmd = value.toMergePatchAttributeAliasMvo();
            AttributeAliasMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeAliasMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            AttributeAliasMvoCommand.DeleteAttributeAliasMvo deleteCmd = new AbstractAttributeAliasMvoCommand.SimpleDeleteAttributeAliasMvo();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setAttributeVersion(version);
            AttributeAliasMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            attributeAliasMvoApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            AttributeAliasMvoMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_stateEvents/{version}")
    public AttributeAliasMvoStateEventDto getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            AttributeAliasId idObj = AttributeAliasMvoResourceUtils.parseIdString(id);
            AttributeAliasMvoStateEventDtoConverter dtoConverter = getAttributeAliasMvoStateEventDtoConverter();
            return dtoConverter.toAttributeAliasMvoStateEventDto((AbstractAttributeAliasMvoEvent) attributeAliasMvoApplicationService.getEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public AttributeAliasMvoStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            AttributeAliasId idObj = AttributeAliasMvoResourceUtils.parseIdString(id);
            AttributeAliasMvoStateDto.DtoConverter dtoConverter = new AttributeAliasMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeAliasMvoStateDto(attributeAliasMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  AttributeAliasMvoStateEventDtoConverter getAttributeAliasMvoStateEventDtoConverter() {
        return new AttributeAliasMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new AttributeAliasMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class AttributeAliasMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return AttributeAliasMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class AttributeAliasMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, AttributeAliasMvoCommand value) {
            AttributeAliasId idObj = parseIdString(id);
            if (value.getAttributeAliasId() == null) {
                value.setAttributeAliasId(idObj);
            } else if (!value.getAttributeAliasId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getAttributeAliasId());
            }
        }
    

        public static AttributeAliasId parseIdString(String idString) {
            TextFormatter<AttributeAliasId> formatter =
                    new AbstractValueObjectTextFormatter<AttributeAliasId>(AttributeAliasId.class) {
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
            if (AttributeAliasMvoMetadata.aliasMap.containsKey(fieldName)) {
                return AttributeAliasMvoMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (AttributeAliasMvoMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = AttributeAliasMvoMetadata.propertyTypeMap.get(propertyName);
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

        public static AttributeAliasMvoStateDto[] toAttributeAliasMvoStateDtoArray(Iterable<AttributeAliasId> ids) {
            List<AttributeAliasMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                AttributeAliasMvoStateDto dto = new AttributeAliasMvoStateDto();
                dto.setAttributeAliasId(id);
                states.add(dto);
            });
            return states.toArray(new AttributeAliasMvoStateDto[0]);
        }

    }

}

