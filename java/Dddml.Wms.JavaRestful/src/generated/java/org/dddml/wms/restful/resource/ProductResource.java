package org.dddml.wms.restful.resource;

import java.util.*;
import java.util.stream.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.annotation.*;
import org.dddml.wms.domain.product.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "Products", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ProductResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private ProductApplicationService productApplicationService;


    /**
     * 查询.
     * 查询 Products
     */
    @GetMapping
    public ProductStateDto[] getAll(@Specification(value = ProductStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<ProductState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> ProductResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (ProductMetadata.aliasMap.containsKey(n) ? ProductMetadata.aliasMap.get(n) : n));
            states = productApplicationService.get(
                c,
                ProductResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            ProductStateDto.DtoConverter dtoConverter = new ProductStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toProductStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查询.
     * 分页查询 Products
     */
    @GetMapping("_page")
    public Page<ProductStateDto> getPage(@Specification(value = ProductStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<ProductState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> ProductResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (ProductMetadata.aliasMap.containsKey(n) ? ProductMetadata.aliasMap.get(n) : n));
            states = productApplicationService.get(
                c,
                ProductResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = productApplicationService.getCount(c);

            ProductStateDto.DtoConverter dtoConverter = new ProductStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<ProductStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toProductStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 Product
     */
    @GetMapping("{productId}")
    public ProductStateDto get(@PathVariable("productId") String productId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = productId;
            ProductState state = productApplicationService.get(idObj);
            if (state == null) { return null; }

            ProductStateDto.DtoConverter dtoConverter = new ProductStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toProductStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount(@Specification(value = ProductStateDto.class) HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSONObject.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap());
            }
            count = productApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (ProductMetadata.aliasMap.containsKey(n) ? ProductMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 新建.
     * 新建 Product
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody CreateOrMergePatchProductDto.CreateProductDto value,  HttpServletResponse response) {
        try {
            ProductCommand.CreateProduct cmd = value.toCreateProduct();
            if (cmd.getProductId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "Product");
            }
            String idObj = cmd.getProductId();
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            productApplicationService.when(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 Product
     */
    @PutMapping("{productId}")
    public void put(@PathVariable("productId") String productId, @RequestBody CreateOrMergePatchProductDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                ProductCommand.MergePatchProduct cmd = (ProductCommand.MergePatchProduct) value.toCommand();
                ProductResourceUtils.setNullIdOrThrowOnInconsistentIds(productId, cmd);
                cmd.setRequesterId(SecurityContextUtil.getRequesterId());
                productApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            ProductCommand.CreateProduct cmd = (ProductCommand.CreateProduct) value.toCommand();
            ProductResourceUtils.setNullIdOrThrowOnInconsistentIds(productId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            productApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 修改.
     * 修改 Product
     */
    @PatchMapping("{productId}")
    public void patch(@PathVariable("productId") String productId, @RequestBody CreateOrMergePatchProductDto.MergePatchProductDto value) {
        try {

            ProductCommand.MergePatchProduct cmd = value.toMergePatchProduct();
            ProductResourceUtils.setNullIdOrThrowOnInconsistentIds(productId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            productApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            ProductMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{productId}/_events/{version}")
    public ProductEvent getStateEvent(@PathVariable("productId") String productId, @PathVariable("version") long version) {
        try {

            String idObj = productId;
            //ProductStateEventDtoConverter dtoConverter = getProductStateEventDtoConverter();
            return productApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{productId}/_historyStates/{version}")
    public ProductStateDto getHistoryState(@PathVariable("productId") String productId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = productId;
            ProductStateDto.DtoConverter dtoConverter = new ProductStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toProductStateDto(productApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 获取指定 GoodIdentificationTypeId 的 GoodIdentification
     */
    @GetMapping("{productId}/GoodIdentifications/{goodIdentificationTypeId}")
    public GoodIdentificationStateDto getGoodIdentification(@PathVariable("productId") String productId, @PathVariable("goodIdentificationTypeId") String goodIdentificationTypeId) {
        try {

            GoodIdentificationState state = productApplicationService.getGoodIdentification(productId, goodIdentificationTypeId);
            if (state == null) { return null; }
            GoodIdentificationStateDto.DtoConverter dtoConverter = new GoodIdentificationStateDto.DtoConverter();
            GoodIdentificationStateDto stateDto = dtoConverter.toGoodIdentificationStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 创建 or 修改.
     * 创建 or 修改 GoodIdentification
     */
    @PutMapping(path = "{productId}/GoodIdentifications/{goodIdentificationTypeId}", consumes = MediaType.APPLICATION_JSON_VALUE)
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
            mergePatchProduct.setRequesterId(SecurityContextUtil.getRequesterId());
            productApplicationService.when(mergePatchProduct);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 移除.
     * 移除 GoodIdentification
     */
    @DeleteMapping("{productId}/GoodIdentifications/{goodIdentificationTypeId}")
    public void deleteGoodIdentification(@PathVariable("productId") String productId, @PathVariable("goodIdentificationTypeId") String goodIdentificationTypeId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            ProductCommand.MergePatchProduct mergePatchProduct = new AbstractProductCommand.SimpleMergePatchProduct();
            mergePatchProduct.setProductId(productId);
            mergePatchProduct.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { 
                mergePatchProduct.setVersion(version); 
            } else {
                mergePatchProduct.setVersion(productApplicationService.get(productId).getVersion());
            }
            mergePatchProduct.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            GoodIdentificationCommand.RemoveGoodIdentification removeGoodIdentification = new AbstractGoodIdentificationCommand.SimpleRemoveGoodIdentification();
            removeGoodIdentification.setGoodIdentificationTypeId(goodIdentificationTypeId);
            mergePatchProduct.getGoodIdentificationCommands().add(removeGoodIdentification);
            mergePatchProduct.setRequesterId(SecurityContextUtil.getRequesterId());
            productApplicationService.when(mergePatchProduct);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * GoodIdentification List
     */
    @GetMapping("{productId}/GoodIdentifications")
    public GoodIdentificationStateDto[] getGoodIdentifications(@PathVariable("productId") String productId) {
        try {
            Iterable<GoodIdentificationState> states = productApplicationService.getGoodIdentifications(productId);
            if (states == null) { return null; }
            GoodIdentificationStateDto.DtoConverter dtoConverter = new GoodIdentificationStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toGoodIdentificationStateDtoArray(states);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 新建.
     * 新建 GoodIdentification
     */
    @PostMapping(path = "{productId}/GoodIdentifications", consumes = MediaType.APPLICATION_JSON_VALUE)
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
            mergePatchProduct.setRequesterId(SecurityContextUtil.getRequesterId());
            productApplicationService.when(mergePatchProduct);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  ProductStateEventDtoConverter getProductStateEventDtoConverter() {
    //    return new ProductStateEventDtoConverter();
    //}

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

        public static void setNullIdOrThrowOnInconsistentIds(String productId, ProductCommand value) {
            String idObj = productId;
            if (value.getProductId() == null) {
                value.setProductId(idObj);
            } else if (!value.getProductId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", productId, value.getProductId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, ProductMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, ProductMetadata.aliasMap);
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
            ids.forEach(i -> {
                ProductStateDto dto = new ProductStateDto();
                dto.setProductId(i);
                states.add(dto);
            });
            return states.toArray(new ProductStateDto[0]);
        }

    }

}

