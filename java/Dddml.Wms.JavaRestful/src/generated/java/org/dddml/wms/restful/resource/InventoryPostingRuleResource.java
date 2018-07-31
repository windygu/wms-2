package org.dddml.wms.restful.resource;

import java.util.*;
import java.util.stream.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inventorypostingrule.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "InventoryPostingRules", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class InventoryPostingRuleResource {


    @Autowired
    private InventoryPostingRuleApplicationService inventoryPostingRuleApplicationService;


    @GetMapping
    public InventoryPostingRuleStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<InventoryPostingRuleState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = inventoryPostingRuleApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (InventoryPostingRuleMetadata.aliasMap.containsKey(n) ? InventoryPostingRuleMetadata.aliasMap.get(n) : n)),
                        InventoryPostingRuleResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = inventoryPostingRuleApplicationService.get(
                        InventoryPostingRuleResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        InventoryPostingRuleResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            InventoryPostingRuleStateDto.DtoConverter dtoConverter = new InventoryPostingRuleStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryPostingRuleStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_page")
    public Page<InventoryPostingRuleStateDto> getPage( HttpServletRequest request,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "page", defaultValue = "0") Integer page,
                                   @RequestParam(value = "size", required = false) @NotNull Integer size) {
        try {
            List<String> sort = InventoryPostingRuleResourceUtils.getQuerySorts(request.getParameterMap());
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<InventoryPostingRuleState> states = null; 
            Criterion criterion = CriterionDto.toSubclass(
                    QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                            .filter(kv -> InventoryPostingRuleResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                            .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue()))),
                            getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (InventoryPostingRuleMetadata.aliasMap.containsKey(n) ? InventoryPostingRuleMetadata.aliasMap.get(n) : n));
            states = inventoryPostingRuleApplicationService.get(
                        criterion,
                        InventoryPostingRuleResourceUtils.getQuerySorts(request.getParameterMap()),
                        firstResult, maxResults);
            long count = inventoryPostingRuleApplicationService.getCount(criterion);

            InventoryPostingRuleStateDto.DtoConverter dtoConverter = new InventoryPostingRuleStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<InventoryPostingRuleStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toInventoryPostingRuleStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            statePage.setTotalElements(count);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public InventoryPostingRuleStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = id;
            InventoryPostingRuleState state = inventoryPostingRuleApplicationService.get(idObj);
            if (state == null) { return null; }

            InventoryPostingRuleStateDto.DtoConverter dtoConverter = new InventoryPostingRuleStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryPostingRuleStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = inventoryPostingRuleApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (InventoryPostingRuleMetadata.aliasMap.containsKey(n) ? InventoryPostingRuleMetadata.aliasMap.get(n) : n)));
            } else {
                count = inventoryPostingRuleApplicationService.getCount(InventoryPostingRuleResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public String post(@RequestBody CreateOrMergePatchInventoryPostingRuleDto.CreateInventoryPostingRuleDto value,  HttpServletResponse response) {
        try {
            InventoryPostingRuleCommand.CreateInventoryPostingRule cmd = value.toCreateInventoryPostingRule();
            if (cmd.getInventoryPostingRuleId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "InventoryPostingRule");
            }
            inventoryPostingRuleApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getInventoryPostingRuleId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchInventoryPostingRuleDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                InventoryPostingRuleCommand.MergePatchInventoryPostingRule cmd = (InventoryPostingRuleCommand.MergePatchInventoryPostingRule) value.toCommand();
                InventoryPostingRuleResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                inventoryPostingRuleApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            InventoryPostingRuleCommand.CreateInventoryPostingRule cmd = (InventoryPostingRuleCommand.CreateInventoryPostingRule) value.toCommand();
            InventoryPostingRuleResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            inventoryPostingRuleApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchInventoryPostingRuleDto.MergePatchInventoryPostingRuleDto value) {
        try {

            InventoryPostingRuleCommand.MergePatchInventoryPostingRule cmd = value.toMergePatchInventoryPostingRule();
            InventoryPostingRuleResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            inventoryPostingRuleApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            InventoryPostingRuleCommand.DeleteInventoryPostingRule deleteCmd = new AbstractInventoryPostingRuleCommand.SimpleDeleteInventoryPostingRule();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            InventoryPostingRuleResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            inventoryPostingRuleApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            InventoryPostingRuleMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_events/{version}")
    public InventoryPostingRuleEvent getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            String idObj = id;
            //InventoryPostingRuleStateEventDtoConverter dtoConverter = getInventoryPostingRuleStateEventDtoConverter();
            return inventoryPostingRuleApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public InventoryPostingRuleStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = id;
            InventoryPostingRuleStateDto.DtoConverter dtoConverter = new InventoryPostingRuleStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryPostingRuleStateDto(inventoryPostingRuleApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  InventoryPostingRuleStateEventDtoConverter getInventoryPostingRuleStateEventDtoConverter() {
    //    return new InventoryPostingRuleStateEventDtoConverter();
    //}

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new InventoryPostingRulePropertyTypeResolver();
    }

    // ////////////////////////////////

    private class InventoryPostingRulePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return InventoryPostingRuleResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class InventoryPostingRuleResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String id, InventoryPostingRuleCommand value) {
            String idObj = id;
            if (value.getInventoryPostingRuleId() == null) {
                value.setInventoryPostingRuleId(idObj);
            } else if (!value.getInventoryPostingRuleId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getInventoryPostingRuleId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, InventoryPostingRuleMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            return QueryParamUtils.getQuerySorts(queryNameValuePairs, InventoryPostingRuleMetadata.aliasMap);
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (InventoryPostingRuleMetadata.aliasMap.containsKey(fieldName)) {
                return InventoryPostingRuleMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (InventoryPostingRuleMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = InventoryPostingRuleMetadata.propertyTypeMap.get(propertyName);
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

        public static InventoryPostingRuleStateDto[] toInventoryPostingRuleStateDtoArray(Iterable<String> ids) {
            List<InventoryPostingRuleStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                InventoryPostingRuleStateDto dto = new InventoryPostingRuleStateDto();
                dto.setInventoryPostingRuleId(id);
                states.add(dto);
            });
            return states.toArray(new InventoryPostingRuleStateDto[0]);
        }

    }

}

