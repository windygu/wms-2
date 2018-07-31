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
import org.dddml.wms.domain.productcategorymember.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "ProductCategoryMembers", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ProductCategoryMemberResource {


    @Autowired
    private ProductCategoryMemberApplicationService productCategoryMemberApplicationService;


    @GetMapping
    public ProductCategoryMemberStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<ProductCategoryMemberState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = productCategoryMemberApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (ProductCategoryMemberMetadata.aliasMap.containsKey(n) ? ProductCategoryMemberMetadata.aliasMap.get(n) : n)),
                        ProductCategoryMemberResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = productCategoryMemberApplicationService.get(
                        ProductCategoryMemberResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        ProductCategoryMemberResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            ProductCategoryMemberStateDto.DtoConverter dtoConverter = new ProductCategoryMemberStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toProductCategoryMemberStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_page")
    public Page<ProductCategoryMemberStateDto> getPage( HttpServletRequest request,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "page", defaultValue = "0") Integer page,
                                   @RequestParam(value = "size", required = false) @NotNull Integer size) {
        try {
            List<String> sort = ProductCategoryMemberResourceUtils.getQuerySorts(request.getParameterMap());
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<ProductCategoryMemberState> states = null; 
            Criterion criterion = CriterionDto.toSubclass(
                    QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                            .filter(kv -> ProductCategoryMemberResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                            .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue()))),
                            getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (ProductCategoryMemberMetadata.aliasMap.containsKey(n) ? ProductCategoryMemberMetadata.aliasMap.get(n) : n));
            states = productCategoryMemberApplicationService.get(
                        criterion,
                        ProductCategoryMemberResourceUtils.getQuerySorts(request.getParameterMap()),
                        firstResult, maxResults);
            long count = productCategoryMemberApplicationService.getCount(criterion);

            ProductCategoryMemberStateDto.DtoConverter dtoConverter = new ProductCategoryMemberStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<ProductCategoryMemberStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toProductCategoryMemberStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            statePage.setTotalElements(count);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public ProductCategoryMemberStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            ProductCategoryMemberId idObj = ProductCategoryMemberResourceUtils.parseIdString(id);
            ProductCategoryMemberState state = productCategoryMemberApplicationService.get(idObj);
            if (state == null) { return null; }

            ProductCategoryMemberStateDto.DtoConverter dtoConverter = new ProductCategoryMemberStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toProductCategoryMemberStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = productCategoryMemberApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (ProductCategoryMemberMetadata.aliasMap.containsKey(n) ? ProductCategoryMemberMetadata.aliasMap.get(n) : n)));
            } else {
                count = productCategoryMemberApplicationService.getCount(ProductCategoryMemberResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public ProductCategoryMemberId post(@RequestBody CreateOrMergePatchProductCategoryMemberDto.CreateProductCategoryMemberDto value,  HttpServletResponse response) {
        try {
            ProductCategoryMemberCommand.CreateProductCategoryMember cmd = value.toCreateProductCategoryMember();
            if (cmd.getProductCategoryMemberId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "ProductCategoryMember");
            }
            productCategoryMemberApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getProductCategoryMemberId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchProductCategoryMemberDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                ProductCategoryMemberCommand.MergePatchProductCategoryMember cmd = (ProductCategoryMemberCommand.MergePatchProductCategoryMember) value.toCommand();
                ProductCategoryMemberResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                productCategoryMemberApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            ProductCategoryMemberCommand.CreateProductCategoryMember cmd = (ProductCategoryMemberCommand.CreateProductCategoryMember) value.toCommand();
            ProductCategoryMemberResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            productCategoryMemberApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchProductCategoryMemberDto.MergePatchProductCategoryMemberDto value) {
        try {

            ProductCategoryMemberCommand.MergePatchProductCategoryMember cmd = value.toMergePatchProductCategoryMember();
            ProductCategoryMemberResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            productCategoryMemberApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            ProductCategoryMemberMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_events/{version}")
    public ProductCategoryMemberEvent getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            ProductCategoryMemberId idObj = ProductCategoryMemberResourceUtils.parseIdString(id);
            //ProductCategoryMemberStateEventDtoConverter dtoConverter = getProductCategoryMemberStateEventDtoConverter();
            return productCategoryMemberApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public ProductCategoryMemberStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            ProductCategoryMemberId idObj = ProductCategoryMemberResourceUtils.parseIdString(id);
            ProductCategoryMemberStateDto.DtoConverter dtoConverter = new ProductCategoryMemberStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toProductCategoryMemberStateDto(productCategoryMemberApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  ProductCategoryMemberStateEventDtoConverter getProductCategoryMemberStateEventDtoConverter() {
    //    return new ProductCategoryMemberStateEventDtoConverter();
    //}

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new ProductCategoryMemberPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class ProductCategoryMemberPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return ProductCategoryMemberResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class ProductCategoryMemberResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String id, ProductCategoryMemberCommand value) {
            ProductCategoryMemberId idObj = parseIdString(id);
            if (value.getProductCategoryMemberId() == null) {
                value.setProductCategoryMemberId(idObj);
            } else if (!value.getProductCategoryMemberId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getProductCategoryMemberId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, ProductCategoryMemberMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            return QueryParamUtils.getQuerySorts(queryNameValuePairs, ProductCategoryMemberMetadata.aliasMap);
        }

        public static ProductCategoryMemberId parseIdString(String idString) {
            TextFormatter<ProductCategoryMemberId> formatter =
                    new AbstractValueObjectTextFormatter<ProductCategoryMemberId>(ProductCategoryMemberId.class) {
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
            if (ProductCategoryMemberMetadata.aliasMap.containsKey(fieldName)) {
                return ProductCategoryMemberMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (ProductCategoryMemberMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = ProductCategoryMemberMetadata.propertyTypeMap.get(propertyName);
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

        public static ProductCategoryMemberStateDto[] toProductCategoryMemberStateDtoArray(Iterable<ProductCategoryMemberId> ids) {
            List<ProductCategoryMemberStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                ProductCategoryMemberStateDto dto = new ProductCategoryMemberStateDto();
                dto.setProductCategoryMemberId(id);
                states.add(dto);
            });
            return states.toArray(new ProductCategoryMemberStateDto[0]);
        }

    }

}

