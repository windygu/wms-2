package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.apache.cxf.jaxrs.ext.PATCH;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.orderrolemvo.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("OrderRoleMvos") @Produces(MediaType.APPLICATION_JSON)
public class OrderRoleMvoResource {


    @Autowired
    private OrderRoleMvoApplicationService orderRoleMvoApplicationService;


    @GET
    public OrderRoleMvoStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<OrderRoleMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = orderRoleMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (OrderRoleMvoMetadata.aliasMap.containsKey(n) ? OrderRoleMvoMetadata.aliasMap.get(n) : n)),
                        OrderRoleMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = orderRoleMvoApplicationService.get(
                        OrderRoleMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        OrderRoleMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            OrderRoleMvoStateDto.DtoConverter dtoConverter = new OrderRoleMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderRoleMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public OrderRoleMvoStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            OrderRoleId idObj = OrderRoleMvoResourceUtils.parseIdString(id);
            OrderRoleMvoState state = orderRoleMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            OrderRoleMvoStateDto.DtoConverter dtoConverter = new OrderRoleMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderRoleMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = orderRoleMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (OrderRoleMvoMetadata.aliasMap.containsKey(n) ? OrderRoleMvoMetadata.aliasMap.get(n) : n)));
            } else {
                count = orderRoleMvoApplicationService.getCount(OrderRoleMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchOrderRoleMvoDto.CreateOrderRoleMvoDto value) {
        try {

            OrderRoleMvoCommand.CreateOrderRoleMvo cmd = value.toCreateOrderRoleMvo();
            OrderRoleMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            orderRoleMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchOrderRoleMvoDto.MergePatchOrderRoleMvoDto value) {
        try {

            OrderRoleMvoCommand.MergePatchOrderRoleMvo cmd = value.toMergePatchOrderRoleMvo();
            OrderRoleMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            orderRoleMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @DELETE
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            OrderRoleMvoCommand.DeleteOrderRoleMvo deleteCmd = new AbstractOrderRoleMvoCommand.SimpleDeleteOrderRoleMvo();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setOrderVersion(version);
            OrderRoleMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            orderRoleMvoApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            OrderRoleMvoMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public OrderRoleMvoStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            OrderRoleId idObj = OrderRoleMvoResourceUtils.parseIdString(id);
            OrderRoleMvoStateEventDtoConverter dtoConverter = getOrderRoleMvoStateEventDtoConverter();
            return dtoConverter.toOrderRoleMvoStateEventDto((AbstractOrderRoleMvoStateEvent) orderRoleMvoApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public OrderRoleMvoStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            OrderRoleId idObj = OrderRoleMvoResourceUtils.parseIdString(id);
            OrderRoleMvoStateDto.DtoConverter dtoConverter = new OrderRoleMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderRoleMvoStateDto(orderRoleMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  OrderRoleMvoStateEventDtoConverter getOrderRoleMvoStateEventDtoConverter() {
        return new OrderRoleMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new OrderRoleMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class OrderRoleMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return OrderRoleMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class OrderRoleMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, OrderRoleMvoCommand value) {
            OrderRoleId idObj = parseIdString(id);
            if (value.getOrderRoleId() == null) {
                value.setOrderRoleId(idObj);
            } else if (!value.getOrderRoleId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getOrderRoleId());
            }
        }
    

        public static OrderRoleId parseIdString(String idString) {
            TextFormatter<OrderRoleId> formatter =
                    new AbstractValueObjectTextFormatter<OrderRoleId>(OrderRoleId.class) {
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
            if (OrderRoleMvoMetadata.aliasMap.containsKey(fieldName)) {
                return OrderRoleMvoMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (OrderRoleMvoMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = OrderRoleMvoMetadata.propertyTypeMap.get(propertyName);
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

        public static OrderRoleMvoStateDto[] toOrderRoleMvoStateDtoArray(Iterable<OrderRoleId> ids) {
            List<OrderRoleMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                OrderRoleMvoStateDto dto = new OrderRoleMvoStateDto();
                dto.setOrderRoleId(id);
                states.add(dto);
            });
            return states.toArray(new OrderRoleMvoStateDto[0]);
        }

    }

}

