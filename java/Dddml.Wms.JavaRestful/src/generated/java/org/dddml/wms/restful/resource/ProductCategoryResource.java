package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.apache.cxf.jaxrs.ext.PATCH;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.productcategory.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("ProductCategories") @Produces(MediaType.APPLICATION_JSON)
public class ProductCategoryResource {


    @Autowired
    private ProductCategoryApplicationService productCategoryApplicationService;


    @GET
    public ProductCategoryStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<ProductCategoryState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = productCategoryApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (ProductCategoryMetadata.aliasMap.containsKey(n) ? ProductCategoryMetadata.aliasMap.get(n) : n)),
                        ProductCategoryResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = productCategoryApplicationService.get(
                        ProductCategoryResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        ProductCategoryResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            ProductCategoryStateDto.DtoConverter dtoConverter = new ProductCategoryStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toProductCategoryStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public ProductCategoryStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            String idObj = id;
            ProductCategoryState state = productCategoryApplicationService.get(idObj);
            if (state == null) { return null; }

            ProductCategoryStateDto.DtoConverter dtoConverter = new ProductCategoryStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toProductCategoryStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = productCategoryApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (ProductCategoryMetadata.aliasMap.containsKey(n) ? ProductCategoryMetadata.aliasMap.get(n) : n)));
            } else {
                count = productCategoryApplicationService.getCount(ProductCategoryResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @POST
    public String post(CreateOrMergePatchProductCategoryDto.CreateProductCategoryDto value, @Context HttpServletResponse response) {
        try {
            ProductCategoryCommand.CreateProductCategory cmd = value.toCreateProductCategory();
            if (cmd.getProductCategoryId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "ProductCategory");
            }

            response.setStatus(Response.Status.CREATED.getStatusCode());
            return cmd.getProductCategoryId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchProductCategoryDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                ProductCategoryCommand.MergePatchProductCategory cmd = (ProductCategoryCommand.MergePatchProductCategory) value.toCommand();
                ProductCategoryResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                productCategoryApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            ProductCategoryCommand.CreateProductCategory cmd = (ProductCategoryCommand.CreateProductCategory) value.toCommand();
            ProductCategoryResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            productCategoryApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchProductCategoryDto.MergePatchProductCategoryDto value) {
        try {

            ProductCategoryCommand.MergePatchProductCategory cmd = value.toMergePatchProductCategory();
            ProductCategoryResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            productCategoryApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @DELETE
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            ProductCategoryCommand.DeleteProductCategory deleteCmd = new AbstractProductCategoryCommand.SimpleDeleteProductCategory();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            ProductCategoryResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            productCategoryApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            ProductCategoryMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public ProductCategoryStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            String idObj = id;
            ProductCategoryStateEventDtoConverter dtoConverter = getProductCategoryStateEventDtoConverter();
            return dtoConverter.toProductCategoryStateEventDto((AbstractProductCategoryStateEvent) productCategoryApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public ProductCategoryStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            String idObj = id;
            ProductCategoryStateDto.DtoConverter dtoConverter = new ProductCategoryStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toProductCategoryStateDto(productCategoryApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/ChildProductCategories") @GET
    public ProductCategoryStateDto[] getChildProductCategories(String id)
    {
        try {
            String idObj = id;
            Iterable<ProductCategoryState> states = productCategoryApplicationService.getChildProductCategories(idObj);
            if (states == null) { return null; }
            ProductCategoryStateDto.DtoConverter dtoConverter = new ProductCategoryStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toProductCategoryStateDtoArray(states);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  ProductCategoryStateEventDtoConverter getProductCategoryStateEventDtoConverter() {
        return new ProductCategoryStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new ProductCategoryPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class ProductCategoryPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return ProductCategoryResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class ProductCategoryResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, ProductCategoryCommand value) {
            String idObj = id;
            if (value.getProductCategoryId() == null) {
                value.setProductCategoryId(idObj);
            } else if (!value.getProductCategoryId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getProductCategoryId());
            }
        }
    


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (ProductCategoryMetadata.aliasMap.containsKey(fieldName)) {
                return ProductCategoryMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (ProductCategoryMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = ProductCategoryMetadata.propertyTypeMap.get(propertyName);
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

        public static ProductCategoryStateDto[] toProductCategoryStateDtoArray(Iterable<String> ids) {
            List<ProductCategoryStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                ProductCategoryStateDto dto = new ProductCategoryStateDto();
                dto.setProductCategoryId(id);
                states.add(dto);
            });
            return states.toArray(new ProductCategoryStateDto[0]);
        }

    }

}

