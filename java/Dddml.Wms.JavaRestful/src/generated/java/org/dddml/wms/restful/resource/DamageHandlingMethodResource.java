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
import org.dddml.wms.domain.damagehandlingmethod.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "DamageHandlingMethods", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class DamageHandlingMethodResource {


    @Autowired
    private DamageHandlingMethodApplicationService damageHandlingMethodApplicationService;


    @GetMapping
    public DamageHandlingMethodStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<DamageHandlingMethodState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = damageHandlingMethodApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (DamageHandlingMethodMetadata.aliasMap.containsKey(n) ? DamageHandlingMethodMetadata.aliasMap.get(n) : n)),
                        DamageHandlingMethodResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = damageHandlingMethodApplicationService.get(
                        DamageHandlingMethodResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        DamageHandlingMethodResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            DamageHandlingMethodStateDto.DtoConverter dtoConverter = new DamageHandlingMethodStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toDamageHandlingMethodStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_page")
    public Page<DamageHandlingMethodStateDto> getPage( HttpServletRequest request,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "page", defaultValue = "0") Integer page,
                                   @RequestParam(value = "size", required = false) @NotNull Integer size) {
        try {
            List<String> sort = DamageHandlingMethodResourceUtils.getQuerySorts(request.getParameterMap());
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<DamageHandlingMethodState> states = null; 
            Iterable<Map.Entry<String, Object>> queryFilterMap = DamageHandlingMethodResourceUtils.getQueryFilterMap(request.getParameterMap());
            states = damageHandlingMethodApplicationService.get(
                        queryFilterMap,
                        DamageHandlingMethodResourceUtils.getQuerySorts(request.getParameterMap()),
                        firstResult, maxResults);
            long count = damageHandlingMethodApplicationService.getCount(queryFilterMap);

            DamageHandlingMethodStateDto.DtoConverter dtoConverter = new DamageHandlingMethodStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<DamageHandlingMethodStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toDamageHandlingMethodStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public DamageHandlingMethodStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = id;
            DamageHandlingMethodState state = damageHandlingMethodApplicationService.get(idObj);
            if (state == null) { return null; }

            DamageHandlingMethodStateDto.DtoConverter dtoConverter = new DamageHandlingMethodStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toDamageHandlingMethodStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = damageHandlingMethodApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (DamageHandlingMethodMetadata.aliasMap.containsKey(n) ? DamageHandlingMethodMetadata.aliasMap.get(n) : n)));
            } else {
                count = damageHandlingMethodApplicationService.getCount(DamageHandlingMethodResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public String post(@RequestBody CreateOrMergePatchDamageHandlingMethodDto.CreateDamageHandlingMethodDto value,  HttpServletResponse response) {
        try {
            DamageHandlingMethodCommand.CreateDamageHandlingMethod cmd = value.toCreateDamageHandlingMethod();
            if (cmd.getDamageHandlingMethodId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "DamageHandlingMethod");
            }
            damageHandlingMethodApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getDamageHandlingMethodId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchDamageHandlingMethodDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                DamageHandlingMethodCommand.MergePatchDamageHandlingMethod cmd = (DamageHandlingMethodCommand.MergePatchDamageHandlingMethod) value.toCommand();
                DamageHandlingMethodResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                damageHandlingMethodApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            DamageHandlingMethodCommand.CreateDamageHandlingMethod cmd = (DamageHandlingMethodCommand.CreateDamageHandlingMethod) value.toCommand();
            DamageHandlingMethodResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            damageHandlingMethodApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchDamageHandlingMethodDto.MergePatchDamageHandlingMethodDto value) {
        try {

            DamageHandlingMethodCommand.MergePatchDamageHandlingMethod cmd = value.toMergePatchDamageHandlingMethod();
            DamageHandlingMethodResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            damageHandlingMethodApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            DamageHandlingMethodCommand.DeleteDamageHandlingMethod deleteCmd = new DeleteDamageHandlingMethodDto().toDeleteDamageHandlingMethod();;

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            DamageHandlingMethodResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            damageHandlingMethodApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            DamageHandlingMethodMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new DamageHandlingMethodPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class DamageHandlingMethodPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return DamageHandlingMethodResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class DamageHandlingMethodResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String id, DamageHandlingMethodCommand value) {
            String idObj = id;
            if (value.getDamageHandlingMethodId() == null) {
                value.setDamageHandlingMethodId(idObj);
            } else if (!value.getDamageHandlingMethodId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getDamageHandlingMethodId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            return QueryParamUtils.getQuerySorts(queryNameValuePairs);
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (DamageHandlingMethodMetadata.aliasMap.containsKey(fieldName)) {
                return DamageHandlingMethodMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (DamageHandlingMethodMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = DamageHandlingMethodMetadata.propertyTypeMap.get(propertyName);
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

        public static DamageHandlingMethodStateDto[] toDamageHandlingMethodStateDtoArray(Iterable<String> ids) {
            List<DamageHandlingMethodStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                DamageHandlingMethodStateDto dto = new DamageHandlingMethodStateDto();
                dto.setDamageHandlingMethodId(id);
                states.add(dto);
            });
            return states.toArray(new DamageHandlingMethodStateDto[0]);
        }

    }

}

