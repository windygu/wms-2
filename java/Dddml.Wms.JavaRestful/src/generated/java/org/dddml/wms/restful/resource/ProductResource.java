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
import org.dddml.wms.domain.product.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "Products", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ProductResource {


    @Autowired
    private ProductApplicationService productApplicationService;


    @GetMapping
    public ProductStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<ProductState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = productApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (ProductMetadata.aliasMap.containsKey(n) ? ProductMetadata.aliasMap.get(n) : n)),
                        ProductResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = productApplicationService.get(
                        ProductResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        ProductResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            ProductStateDto.DtoConverter dtoConverter = new ProductStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toProductStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_page")
    public Page<ProductStateDto> getPage( HttpServletRequest request,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "page", defaultValue = "0") Integer page,
                                   @RequestParam(value = "size", required = false) @NotNull Integer size) {
        try {
            List<String> sort = ProductResourceUtils.getQuerySorts(request.getParameterMap());
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<ProductState> states = null; 
            Iterable<Map.Entry<String, Object>> queryFilterMap = ProductResourceUtils.getQueryFilterMap(request.getParameterMap());
            states = productApplicationService.get(
                        queryFilterMap,
                        ProductResourceUtils.getQuerySorts(request.getParameterMap()),
                        firstResult, maxResults);
            long count = productApplicationService.getCount(queryFilterMap);

            ProductStateDto.DtoConverter dtoConverter = new ProductStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<ProductStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toProductStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public ProductStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = id;
            ProductState state = productApplicationService.get(idObj);
            if (state == null) { return null; }

            ProductStateDto.DtoConverter dtoConverter = new ProductStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toProductStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = productApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (ProductMetadata.aliasMap.containsKey(n) ? ProductMetadata.aliasMap.get(n) : n)));
            } else {
                count = productApplicationService.getCount(ProductResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public String post(@RequestBody CreateOrMergePatchProductDto.CreateProductDto value,  HttpServletResponse response) {
        try {
            ProductCommand.CreateProduct cmd = value.toCreateProduct();
            if (cmd.getProductId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "Product");
            }
            productApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getProductId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchProductDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                ProductCommand.MergePatchProduct cmd = (ProductCommand.MergePatchProduct) value.toCommand();
                ProductResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                productApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            ProductCommand.CreateProduct cmd = (ProductCommand.CreateProduct) value.toCommand();
            ProductResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            productApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchProductDto.MergePatchProductDto value) {
        try {

            ProductCommand.MergePatchProduct cmd = value.toMergePatchProduct();
            ProductResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            productApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            ProductMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_events/{version}")
    public ProductEvent getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            String idObj = id;
            //ProductStateEventDtoConverter dtoConverter = getProductStateEventDtoConverter();
            return productApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public ProductStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = id;
            ProductStateDto.DtoConverter dtoConverter = new ProductStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toProductStateDto(productApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{productId}/GoodIdentifications/{goodIdentificationTypeId}")
    public GoodIdentificationStateDto getGoodIdentification(@PathVariable("productId") String productId, @PathVariable("goodIdentificationTypeId") String goodIdentificationTypeId) {
        try {

            GoodIdentificationState state = productApplicationService.getGoodIdentification(productId, goodIdentificationTypeId);
            if (state == null) { return null; }
            GoodIdentificationStateDto.DtoConverter dtoConverter = new GoodIdentificationStateDto.DtoConverter();
            GoodIdentificationStateDto stateDto = dtoConverter.toGoodIdentificationStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @PutMapping("{productId}/GoodIdentifications/{goodIdentificationTypeId}")
    public void putGoodIdentification(@PathVariable("productId") String productId, @PathVariable("goodIdentificationTypeId") String goodIdentificationTypeId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchGoodIdentificationDto.MergePatchGoodIdentificationDto body) {
        try {
            ProductCommand.MergePatchProduct mergePatchProduct = new AbstractProductCommand.SimpleMergePatchProduct();
            mergePatchProduct.setProductId(productId);
            mergePatchProduct.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchProduct.setVersion(version); }
            mergePatchProduct.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            GoodIdentificationCommand.MergePatchGoodIdentification mergePatchGoodIdentification = body.toMergePatchGoodIdentification();
            mergePatchGoodIdentification.setGoodIdentificationTypeId(goodIdentificationTypeId);
            mergePatchProduct.getGoodIdentificationCommands().add(mergePatchGoodIdentification);
            productApplicationService.when(mergePatchProduct);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{productId}/GoodIdentifications/{goodIdentificationTypeId}")
    public void deleteGoodIdentification(@PathVariable("productId") String productId, @PathVariable("goodIdentificationTypeId") String goodIdentificationTypeId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            ProductCommand.MergePatchProduct mergePatchProduct = new AbstractProductCommand.SimpleMergePatchProduct();
            mergePatchProduct.setProductId(productId);
            mergePatchProduct.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchProduct.setVersion(version); }
            mergePatchProduct.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            GoodIdentificationCommand.RemoveGoodIdentification removeGoodIdentification = new AbstractGoodIdentificationCommand.SimpleRemoveGoodIdentification();
            removeGoodIdentification.setGoodIdentificationTypeId(goodIdentificationTypeId);
            mergePatchProduct.getGoodIdentificationCommands().add(removeGoodIdentification);
            productApplicationService.when(mergePatchProduct);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{productId}/GoodIdentifications/")
    public GoodIdentificationStateDto[] getGoodIdentifications(@PathVariable("productId") String productId) {
        try {
            Iterable<GoodIdentificationState> states = productApplicationService.getGoodIdentifications(productId);
            if (states == null) { return null; }
            GoodIdentificationStateDto.DtoConverter dtoConverter = new GoodIdentificationStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toGoodIdentificationStateDtoArray(states);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @PostMapping("{productId}/GoodIdentifications/")
    public void postGoodIdentifications(@PathVariable("productId") String productId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchGoodIdentificationDto.CreateGoodIdentificationDto body) {
        try {
            ProductCommand.MergePatchProduct mergePatchProduct = new AbstractProductCommand.SimpleMergePatchProduct();
            mergePatchProduct.setProductId(productId);
            mergePatchProduct.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchProduct.setVersion(version); }
            mergePatchProduct.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            GoodIdentificationCommand.CreateGoodIdentification createGoodIdentification = body.toCreateGoodIdentification();
            mergePatchProduct.getGoodIdentificationCommands().add(createGoodIdentification);
            productApplicationService.when(mergePatchProduct);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  ProductStateEventDtoConverter getProductStateEventDtoConverter() {
    //    return new ProductStateEventDtoConverter();
    //}

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new ProductPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class ProductPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return ProductResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class ProductResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, ProductCommand value) {
            String idObj = id;
            if (value.getProductId() == null) {
                value.setProductId(idObj);
            } else if (!value.getProductId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getProductId());
            }
        }
    


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (ProductMetadata.aliasMap.containsKey(fieldName)) {
                return ProductMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (ProductMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = ProductMetadata.propertyTypeMap.get(propertyName);
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

        public static ProductStateDto[] toProductStateDtoArray(Iterable<String> ids) {
            List<ProductStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                ProductStateDto dto = new ProductStateDto();
                dto.setProductId(id);
                states.add(dto);
            });
            return states.toArray(new ProductStateDto[0]);
        }

    }

}

