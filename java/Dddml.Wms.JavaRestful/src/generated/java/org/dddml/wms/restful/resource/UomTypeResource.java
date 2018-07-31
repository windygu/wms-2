package org.dddml.wms.restful.resource;

import java.util.*;
import java.util.stream.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.uomtype.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "UomTypes", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class UomTypeResource {


    @Autowired
    private UomTypeApplicationService uomTypeApplicationService;


    @GetMapping
    public UomTypeStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<UomTypeState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = uomTypeApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (UomTypeMetadata.aliasMap.containsKey(n) ? UomTypeMetadata.aliasMap.get(n) : n)),
                        UomTypeResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = uomTypeApplicationService.get(
                        UomTypeResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        UomTypeResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            UomTypeStateDto.DtoConverter dtoConverter = new UomTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toUomTypeStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_page")
    public Page<UomTypeStateDto> getPage( HttpServletRequest request,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "page", defaultValue = "0") Integer page,
                                   @RequestParam(value = "size", required = false) @NotNull Integer size) {
        try {
            List<String> sort = UomTypeResourceUtils.getQuerySorts(request.getParameterMap());
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<UomTypeState> states = null; 
            Criterion criterion = CriterionDto.toSubclass(
                    QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                            .filter(kv -> UomTypeResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                            .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue()))),
                            getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (UomTypeMetadata.aliasMap.containsKey(n) ? UomTypeMetadata.aliasMap.get(n) : n));
            states = uomTypeApplicationService.get(
                        criterion,
                        UomTypeResourceUtils.getQuerySorts(request.getParameterMap()),
                        firstResult, maxResults);
            long count = uomTypeApplicationService.getCount(criterion);

            UomTypeStateDto.DtoConverter dtoConverter = new UomTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<UomTypeStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toUomTypeStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            statePage.setTotalElements(count);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public UomTypeStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = id;
            UomTypeState state = uomTypeApplicationService.get(idObj);
            if (state == null) { return null; }

            UomTypeStateDto.DtoConverter dtoConverter = new UomTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toUomTypeStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = uomTypeApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (UomTypeMetadata.aliasMap.containsKey(n) ? UomTypeMetadata.aliasMap.get(n) : n)));
            } else {
                count = uomTypeApplicationService.getCount(UomTypeResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public String post(@RequestBody CreateOrMergePatchUomTypeDto.CreateUomTypeDto value,  HttpServletResponse response) {
        try {
            UomTypeCommand.CreateUomType cmd = value.toCreateUomType();
            if (cmd.getUomTypeId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "UomType");
            }
            uomTypeApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getUomTypeId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchUomTypeDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                UomTypeCommand.MergePatchUomType cmd = (UomTypeCommand.MergePatchUomType) value.toCommand();
                UomTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                uomTypeApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            UomTypeCommand.CreateUomType cmd = (UomTypeCommand.CreateUomType) value.toCommand();
            UomTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            uomTypeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchUomTypeDto.MergePatchUomTypeDto value) {
        try {

            UomTypeCommand.MergePatchUomType cmd = value.toMergePatchUomType();
            UomTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            uomTypeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            UomTypeCommand.DeleteUomType deleteCmd = new DeleteUomTypeDto().toDeleteUomType();;

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            UomTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            uomTypeApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            UomTypeMetadata.propertyTypeMap.forEach((key, value) -> {
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
        return new UomTypePropertyTypeResolver();
    }

    // ////////////////////////////////

    private class UomTypePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return UomTypeResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class UomTypeResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String id, UomTypeCommand value) {
            String idObj = id;
            if (value.getUomTypeId() == null) {
                value.setUomTypeId(idObj);
            } else if (!value.getUomTypeId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getUomTypeId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, UomTypeMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            return QueryParamUtils.getQuerySorts(queryNameValuePairs, UomTypeMetadata.aliasMap);
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (UomTypeMetadata.aliasMap.containsKey(fieldName)) {
                return UomTypeMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (UomTypeMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = UomTypeMetadata.propertyTypeMap.get(propertyName);
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

        public static UomTypeStateDto[] toUomTypeStateDtoArray(Iterable<String> ids) {
            List<UomTypeStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                UomTypeStateDto dto = new UomTypeStateDto();
                dto.setUomTypeId(id);
                states.add(dto);
            });
            return states.toArray(new UomTypeStateDto[0]);
        }

    }

}

