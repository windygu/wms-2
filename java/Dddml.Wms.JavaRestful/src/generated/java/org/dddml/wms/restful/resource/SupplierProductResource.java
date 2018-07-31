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
import org.dddml.wms.domain.supplierproduct.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "SupplierProducts", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class SupplierProductResource {


    @Autowired
    private SupplierProductApplicationService supplierProductApplicationService;


    @GetMapping
    public SupplierProductStateDto[] getAll( HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<SupplierProductState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> SupplierProductResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (SupplierProductMetadata.aliasMap.containsKey(n) ? SupplierProductMetadata.aliasMap.get(n) : n));
            states = supplierProductApplicationService.get(
                c,
                SupplierProductResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            SupplierProductStateDto.DtoConverter dtoConverter = new SupplierProductStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toSupplierProductStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_page")
    public Page<SupplierProductStateDto> getPage( HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", required = false) @NotNull Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<SupplierProductState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> SupplierProductResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (SupplierProductMetadata.aliasMap.containsKey(n) ? SupplierProductMetadata.aliasMap.get(n) : n));
            states = supplierProductApplicationService.get(
                c,
                SupplierProductResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = supplierProductApplicationService.getCount(c);

            SupplierProductStateDto.DtoConverter dtoConverter = new SupplierProductStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<SupplierProductStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toSupplierProductStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            statePage.setTotalElements(count);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public SupplierProductStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            SupplierProductId idObj = SupplierProductResourceUtils.parseIdString(id);
            SupplierProductState state = supplierProductApplicationService.get(idObj);
            if (state == null) { return null; }

            SupplierProductStateDto.DtoConverter dtoConverter = new SupplierProductStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toSupplierProductStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSONObject.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap());
            }
            count = supplierProductApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (SupplierProductMetadata.aliasMap.containsKey(n) ? SupplierProductMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public SupplierProductId post(@RequestBody CreateOrMergePatchSupplierProductDto.CreateSupplierProductDto value,  HttpServletResponse response) {
        try {
            SupplierProductCommand.CreateSupplierProduct cmd = value.toCreateSupplierProduct();
            if (cmd.getSupplierProductId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "SupplierProduct");
            }
            supplierProductApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getSupplierProductId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchSupplierProductDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                SupplierProductCommand.MergePatchSupplierProduct cmd = (SupplierProductCommand.MergePatchSupplierProduct) value.toCommand();
                SupplierProductResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                supplierProductApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            SupplierProductCommand.CreateSupplierProduct cmd = (SupplierProductCommand.CreateSupplierProduct) value.toCommand();
            SupplierProductResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            supplierProductApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchSupplierProductDto.MergePatchSupplierProductDto value) {
        try {

            SupplierProductCommand.MergePatchSupplierProduct cmd = value.toMergePatchSupplierProduct();
            SupplierProductResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            supplierProductApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            SupplierProductMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_events/{version}")
    public SupplierProductEvent getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            SupplierProductId idObj = SupplierProductResourceUtils.parseIdString(id);
            //SupplierProductStateEventDtoConverter dtoConverter = getSupplierProductStateEventDtoConverter();
            return supplierProductApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public SupplierProductStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            SupplierProductId idObj = SupplierProductResourceUtils.parseIdString(id);
            SupplierProductStateDto.DtoConverter dtoConverter = new SupplierProductStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toSupplierProductStateDto(supplierProductApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  SupplierProductStateEventDtoConverter getSupplierProductStateEventDtoConverter() {
    //    return new SupplierProductStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new SupplierProductPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class SupplierProductPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return SupplierProductResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class SupplierProductResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String id, SupplierProductCommand value) {
            SupplierProductId idObj = parseIdString(id);
            if (value.getSupplierProductId() == null) {
                value.setSupplierProductId(idObj);
            } else if (!value.getSupplierProductId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getSupplierProductId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, SupplierProductMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, SupplierProductMetadata.aliasMap);
        }

        public static SupplierProductId parseIdString(String idString) {
            TextFormatter<SupplierProductId> formatter =
                    new AbstractValueObjectTextFormatter<SupplierProductId>(SupplierProductId.class) {
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
            if (SupplierProductMetadata.aliasMap.containsKey(fieldName)) {
                return SupplierProductMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (SupplierProductMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = SupplierProductMetadata.propertyTypeMap.get(propertyName);
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

        public static SupplierProductStateDto[] toSupplierProductStateDtoArray(Iterable<SupplierProductId> ids) {
            List<SupplierProductStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                SupplierProductStateDto dto = new SupplierProductStateDto();
                dto.setSupplierProductId(id);
                states.add(dto);
            });
            return states.toArray(new SupplierProductStateDto[0]);
        }

    }

}

