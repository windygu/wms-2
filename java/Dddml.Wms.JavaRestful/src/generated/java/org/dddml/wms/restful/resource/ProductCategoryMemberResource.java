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
import org.dddml.wms.domain.productcategorymember.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("ProductCategoryMembers") @Produces(MediaType.APPLICATION_JSON)
public class ProductCategoryMemberResource {


    @Autowired
    private ProductCategoryMemberApplicationService productCategoryMemberApplicationService;


    @GET
    public ProductCategoryMemberStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
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

    @Path("{id}") @GET
    public ProductCategoryMemberStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
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

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
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


    @POST
    public ProductCategoryMemberId post(CreateOrMergePatchProductCategoryMemberDto.CreateProductCategoryMemberDto value, @Context HttpServletResponse response) {
        try {
            ProductCategoryMemberCommand.CreateProductCategoryMember cmd = value.toCreateProductCategoryMember();
            if (cmd.getProductCategoryMemberId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "ProductCategoryMember");
            }

            response.setStatus(Response.Status.CREATED.getStatusCode());
            return cmd.getProductCategoryMemberId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchProductCategoryMemberDto.CreateProductCategoryMemberDto value) {
        try {

            ProductCategoryMemberCommand.CreateProductCategoryMember cmd = value.toCreateProductCategoryMember();
            ProductCategoryMemberResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            productCategoryMemberApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchProductCategoryMemberDto.MergePatchProductCategoryMemberDto value) {
        try {

            ProductCategoryMemberCommand.MergePatchProductCategoryMember cmd = value.toMergePatchProductCategoryMember();
            ProductCategoryMemberResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            productCategoryMemberApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            ProductCategoryMemberMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public ProductCategoryMemberStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            ProductCategoryMemberId idObj = ProductCategoryMemberResourceUtils.parseIdString(id);
            ProductCategoryMemberStateEventDtoConverter dtoConverter = getProductCategoryMemberStateEventDtoConverter();
            return dtoConverter.toProductCategoryMemberStateEventDto((AbstractProductCategoryMemberStateEvent) productCategoryMemberApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public ProductCategoryMemberStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
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


    protected  ProductCategoryMemberStateEventDtoConverter getProductCategoryMemberStateEventDtoConverter() {
        return new ProductCategoryMemberStateEventDtoConverter();
    }

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, ProductCategoryMemberCommand value) {
            ProductCategoryMemberId idObj = parseIdString(id);
            if (value.getProductCategoryMemberId() == null) {
                value.setProductCategoryMemberId(idObj);
            } else if (!value.getProductCategoryMemberId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getProductCategoryMemberId());
            }
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

