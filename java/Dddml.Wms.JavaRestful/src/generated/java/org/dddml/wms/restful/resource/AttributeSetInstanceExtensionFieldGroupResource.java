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
import org.dddml.wms.domain.attributesetinstanceextensionfieldgroup.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "AttributeSetInstanceExtensionFieldGroups", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class AttributeSetInstanceExtensionFieldGroupResource {


    @Autowired
    private AttributeSetInstanceExtensionFieldGroupApplicationService attributeSetInstanceExtensionFieldGroupApplicationService;


    @GetMapping
    public AttributeSetInstanceExtensionFieldGroupStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<AttributeSetInstanceExtensionFieldGroupState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = attributeSetInstanceExtensionFieldGroupApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (AttributeSetInstanceExtensionFieldGroupMetadata.aliasMap.containsKey(n) ? AttributeSetInstanceExtensionFieldGroupMetadata.aliasMap.get(n) : n)),
                        AttributeSetInstanceExtensionFieldGroupResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = attributeSetInstanceExtensionFieldGroupApplicationService.get(
                        AttributeSetInstanceExtensionFieldGroupResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        AttributeSetInstanceExtensionFieldGroupResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            AttributeSetInstanceExtensionFieldGroupStateDto.DtoConverter dtoConverter = new AttributeSetInstanceExtensionFieldGroupStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeSetInstanceExtensionFieldGroupStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_page")
    public Page<AttributeSetInstanceExtensionFieldGroupStateDto> getPage( HttpServletRequest request,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "page", defaultValue = "0") Integer page,
                                   @RequestParam(value = "size", required = false) @NotNull Integer size) {
        try {
            List<String> sort = AttributeSetInstanceExtensionFieldGroupResourceUtils.getQuerySorts(request.getParameterMap());
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<AttributeSetInstanceExtensionFieldGroupState> states = null; 
            Iterable<Map.Entry<String, Object>> queryFilterMap = AttributeSetInstanceExtensionFieldGroupResourceUtils.getQueryFilterMap(request.getParameterMap());
            states = attributeSetInstanceExtensionFieldGroupApplicationService.get(
                        queryFilterMap,
                        AttributeSetInstanceExtensionFieldGroupResourceUtils.getQuerySorts(request.getParameterMap()),
                        firstResult, maxResults);
            long count = attributeSetInstanceExtensionFieldGroupApplicationService.getCount(queryFilterMap);

            AttributeSetInstanceExtensionFieldGroupStateDto.DtoConverter dtoConverter = new AttributeSetInstanceExtensionFieldGroupStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<AttributeSetInstanceExtensionFieldGroupStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toAttributeSetInstanceExtensionFieldGroupStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public AttributeSetInstanceExtensionFieldGroupStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = id;
            AttributeSetInstanceExtensionFieldGroupState state = attributeSetInstanceExtensionFieldGroupApplicationService.get(idObj);
            if (state == null) { return null; }

            AttributeSetInstanceExtensionFieldGroupStateDto.DtoConverter dtoConverter = new AttributeSetInstanceExtensionFieldGroupStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeSetInstanceExtensionFieldGroupStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = attributeSetInstanceExtensionFieldGroupApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (AttributeSetInstanceExtensionFieldGroupMetadata.aliasMap.containsKey(n) ? AttributeSetInstanceExtensionFieldGroupMetadata.aliasMap.get(n) : n)));
            } else {
                count = attributeSetInstanceExtensionFieldGroupApplicationService.getCount(AttributeSetInstanceExtensionFieldGroupResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public String post(@RequestBody CreateOrMergePatchAttributeSetInstanceExtensionFieldGroupDto.CreateAttributeSetInstanceExtensionFieldGroupDto value,  HttpServletResponse response) {
        try {
            AttributeSetInstanceExtensionFieldGroupCommand.CreateAttributeSetInstanceExtensionFieldGroup cmd = value.toCreateAttributeSetInstanceExtensionFieldGroup();
            if (cmd.getId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "AttributeSetInstanceExtensionFieldGroup");
            }
            attributeSetInstanceExtensionFieldGroupApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchAttributeSetInstanceExtensionFieldGroupDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                AttributeSetInstanceExtensionFieldGroupCommand.MergePatchAttributeSetInstanceExtensionFieldGroup cmd = (AttributeSetInstanceExtensionFieldGroupCommand.MergePatchAttributeSetInstanceExtensionFieldGroup) value.toCommand();
                AttributeSetInstanceExtensionFieldGroupResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                attributeSetInstanceExtensionFieldGroupApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            AttributeSetInstanceExtensionFieldGroupCommand.CreateAttributeSetInstanceExtensionFieldGroup cmd = (AttributeSetInstanceExtensionFieldGroupCommand.CreateAttributeSetInstanceExtensionFieldGroup) value.toCommand();
            AttributeSetInstanceExtensionFieldGroupResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeSetInstanceExtensionFieldGroupApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchAttributeSetInstanceExtensionFieldGroupDto.MergePatchAttributeSetInstanceExtensionFieldGroupDto value) {
        try {

            AttributeSetInstanceExtensionFieldGroupCommand.MergePatchAttributeSetInstanceExtensionFieldGroup cmd = value.toMergePatchAttributeSetInstanceExtensionFieldGroup();
            AttributeSetInstanceExtensionFieldGroupResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeSetInstanceExtensionFieldGroupApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            AttributeSetInstanceExtensionFieldGroupCommand.DeleteAttributeSetInstanceExtensionFieldGroup deleteCmd = new AbstractAttributeSetInstanceExtensionFieldGroupCommand.SimpleDeleteAttributeSetInstanceExtensionFieldGroup();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            AttributeSetInstanceExtensionFieldGroupResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            attributeSetInstanceExtensionFieldGroupApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            AttributeSetInstanceExtensionFieldGroupMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_events/{version}")
    public AttributeSetInstanceExtensionFieldGroupEvent getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            String idObj = id;
            //AttributeSetInstanceExtensionFieldGroupStateEventDtoConverter dtoConverter = getAttributeSetInstanceExtensionFieldGroupStateEventDtoConverter();
            return attributeSetInstanceExtensionFieldGroupApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public AttributeSetInstanceExtensionFieldGroupStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = id;
            AttributeSetInstanceExtensionFieldGroupStateDto.DtoConverter dtoConverter = new AttributeSetInstanceExtensionFieldGroupStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeSetInstanceExtensionFieldGroupStateDto(attributeSetInstanceExtensionFieldGroupApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  AttributeSetInstanceExtensionFieldGroupStateEventDtoConverter getAttributeSetInstanceExtensionFieldGroupStateEventDtoConverter() {
    //    return new AttributeSetInstanceExtensionFieldGroupStateEventDtoConverter();
    //}

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new AttributeSetInstanceExtensionFieldGroupPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class AttributeSetInstanceExtensionFieldGroupPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return AttributeSetInstanceExtensionFieldGroupResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class AttributeSetInstanceExtensionFieldGroupResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, AttributeSetInstanceExtensionFieldGroupCommand value) {
            String idObj = id;
            if (value.getId() == null) {
                value.setId(idObj);
            } else if (!value.getId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getId());
            }
        }
    


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (AttributeSetInstanceExtensionFieldGroupMetadata.aliasMap.containsKey(fieldName)) {
                return AttributeSetInstanceExtensionFieldGroupMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (AttributeSetInstanceExtensionFieldGroupMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = AttributeSetInstanceExtensionFieldGroupMetadata.propertyTypeMap.get(propertyName);
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

        public static AttributeSetInstanceExtensionFieldGroupStateDto[] toAttributeSetInstanceExtensionFieldGroupStateDtoArray(Iterable<String> ids) {
            List<AttributeSetInstanceExtensionFieldGroupStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                AttributeSetInstanceExtensionFieldGroupStateDto dto = new AttributeSetInstanceExtensionFieldGroupStateDto();
                dto.setId(id);
                states.add(dto);
            });
            return states.toArray(new AttributeSetInstanceExtensionFieldGroupStateDto[0]);
        }

    }

}

