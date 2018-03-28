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
import org.dddml.wms.domain.orderitemshipgroupassociationmvo.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("OrderItemShipGroupAssociationMvos") @Produces(MediaType.APPLICATION_JSON)
public class OrderItemShipGroupAssociationMvoResource {


    @Autowired
    private OrderItemShipGroupAssociationMvoApplicationService orderItemShipGroupAssociationMvoApplicationService;


    @GET
    public OrderItemShipGroupAssociationMvoStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<OrderItemShipGroupAssociationMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = orderItemShipGroupAssociationMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (OrderItemShipGroupAssociationMvoFilteringProperties.aliasMap.containsKey(n) ? OrderItemShipGroupAssociationMvoFilteringProperties.aliasMap.get(n) : n)),
                        OrderItemShipGroupAssociationMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = orderItemShipGroupAssociationMvoApplicationService.get(
                        OrderItemShipGroupAssociationMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        OrderItemShipGroupAssociationMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            OrderItemShipGroupAssociationMvoStateDto.DtoConverter dtoConverter = new OrderItemShipGroupAssociationMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderItemShipGroupAssociationMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public OrderItemShipGroupAssociationMvoStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            OrderItemShipGroupAssociationId idObj = OrderItemShipGroupAssociationMvoResourceUtils.parseIdString(id);
            OrderItemShipGroupAssociationMvoState state = orderItemShipGroupAssociationMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            OrderItemShipGroupAssociationMvoStateDto.DtoConverter dtoConverter = new OrderItemShipGroupAssociationMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderItemShipGroupAssociationMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = orderItemShipGroupAssociationMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (OrderItemShipGroupAssociationMvoFilteringProperties.aliasMap.containsKey(n) ? OrderItemShipGroupAssociationMvoFilteringProperties.aliasMap.get(n) : n)));
            } else {
                count = orderItemShipGroupAssociationMvoApplicationService.getCount(OrderItemShipGroupAssociationMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchOrderItemShipGroupAssociationMvoDto.CreateOrderItemShipGroupAssociationMvoDto value) {
        try {

            OrderItemShipGroupAssociationMvoCommand.CreateOrderItemShipGroupAssociationMvo cmd = value.toCreateOrderItemShipGroupAssociationMvo();
            OrderItemShipGroupAssociationMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            orderItemShipGroupAssociationMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchOrderItemShipGroupAssociationMvoDto.MergePatchOrderItemShipGroupAssociationMvoDto value) {
        try {

            OrderItemShipGroupAssociationMvoCommand.MergePatchOrderItemShipGroupAssociationMvo cmd = value.toMergePatchOrderItemShipGroupAssociationMvo();
            OrderItemShipGroupAssociationMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            orderItemShipGroupAssociationMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @DELETE
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            OrderItemShipGroupAssociationMvoCommand.DeleteOrderItemShipGroupAssociationMvo deleteCmd = new AbstractOrderItemShipGroupAssociationMvoCommand.SimpleDeleteOrderItemShipGroupAssociationMvo();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setOrderVersion(version);
            OrderItemShipGroupAssociationMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            orderItemShipGroupAssociationMvoApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            OrderItemShipGroupAssociationMvoFilteringProperties.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public OrderItemShipGroupAssociationMvoStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            OrderItemShipGroupAssociationId idObj = OrderItemShipGroupAssociationMvoResourceUtils.parseIdString(id);
            OrderItemShipGroupAssociationMvoStateEventDtoConverter dtoConverter = getOrderItemShipGroupAssociationMvoStateEventDtoConverter();
            return dtoConverter.toOrderItemShipGroupAssociationMvoStateEventDto((AbstractOrderItemShipGroupAssociationMvoStateEvent) orderItemShipGroupAssociationMvoApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public OrderItemShipGroupAssociationMvoStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            OrderItemShipGroupAssociationId idObj = OrderItemShipGroupAssociationMvoResourceUtils.parseIdString(id);
            OrderItemShipGroupAssociationMvoStateDto.DtoConverter dtoConverter = new OrderItemShipGroupAssociationMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderItemShipGroupAssociationMvoStateDto(orderItemShipGroupAssociationMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  OrderItemShipGroupAssociationMvoStateEventDtoConverter getOrderItemShipGroupAssociationMvoStateEventDtoConverter() {
        return new OrderItemShipGroupAssociationMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new OrderItemShipGroupAssociationMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class OrderItemShipGroupAssociationMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return OrderItemShipGroupAssociationMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class OrderItemShipGroupAssociationMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, OrderItemShipGroupAssociationMvoCommand value) {
            OrderItemShipGroupAssociationId idObj = parseIdString(id);
            if (value.getOrderItemShipGroupAssociationId() == null) {
                value.setOrderItemShipGroupAssociationId(idObj);
            } else if (!value.getOrderItemShipGroupAssociationId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getOrderItemShipGroupAssociationId());
            }
        }
    

        public static OrderItemShipGroupAssociationId parseIdString(String idString) {
            TextFormatter<OrderItemShipGroupAssociationId> formatter =
                    new AbstractValueObjectTextFormatter<OrderItemShipGroupAssociationId>(OrderItemShipGroupAssociationId.class) {
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
            if (OrderItemShipGroupAssociationMvoFilteringProperties.aliasMap.containsKey(fieldName)) {
                return OrderItemShipGroupAssociationMvoFilteringProperties.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (OrderItemShipGroupAssociationMvoFilteringProperties.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = OrderItemShipGroupAssociationMvoFilteringProperties.propertyTypeMap.get(propertyName);
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

        public static OrderItemShipGroupAssociationMvoStateDto[] toOrderItemShipGroupAssociationMvoStateDtoArray(Iterable<OrderItemShipGroupAssociationId> ids) {
            List<OrderItemShipGroupAssociationMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                OrderItemShipGroupAssociationMvoStateDto dto = new OrderItemShipGroupAssociationMvoStateDto();
                dto.setOrderItemShipGroupAssociationId(id);
                states.add(dto);
            });
            return states.toArray(new OrderItemShipGroupAssociationMvoStateDto[0]);
        }

    }

}

