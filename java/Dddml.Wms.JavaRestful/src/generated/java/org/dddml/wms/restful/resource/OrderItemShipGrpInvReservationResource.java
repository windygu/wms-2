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
import org.dddml.wms.domain.orderitemshipgrpinvreservation.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("OrderItemShipGrpInvReservations") @Produces(MediaType.APPLICATION_JSON)
public class OrderItemShipGrpInvReservationResource {


    @Autowired
    private OrderItemShipGrpInvReservationApplicationService orderItemShipGrpInvReservationApplicationService;


    @GET
    public OrderItemShipGrpInvReservationStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<OrderItemShipGrpInvReservationState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = orderItemShipGrpInvReservationApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (OrderItemShipGrpInvReservationMetadata.aliasMap.containsKey(n) ? OrderItemShipGrpInvReservationMetadata.aliasMap.get(n) : n)),
                        OrderItemShipGrpInvReservationResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = orderItemShipGrpInvReservationApplicationService.get(
                        OrderItemShipGrpInvReservationResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        OrderItemShipGrpInvReservationResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            OrderItemShipGrpInvReservationStateDto.DtoConverter dtoConverter = new OrderItemShipGrpInvReservationStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderItemShipGrpInvReservationStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public OrderItemShipGrpInvReservationStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            OrderItemShipGrpInvResId idObj = OrderItemShipGrpInvReservationResourceUtils.parseIdString(id);
            OrderItemShipGrpInvReservationState state = orderItemShipGrpInvReservationApplicationService.get(idObj);
            if (state == null) { return null; }

            OrderItemShipGrpInvReservationStateDto.DtoConverter dtoConverter = new OrderItemShipGrpInvReservationStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderItemShipGrpInvReservationStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = orderItemShipGrpInvReservationApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (OrderItemShipGrpInvReservationMetadata.aliasMap.containsKey(n) ? OrderItemShipGrpInvReservationMetadata.aliasMap.get(n) : n)));
            } else {
                count = orderItemShipGrpInvReservationApplicationService.getCount(OrderItemShipGrpInvReservationResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @POST
    public OrderItemShipGrpInvResId post(CreateOrMergePatchOrderItemShipGrpInvReservationDto.CreateOrderItemShipGrpInvReservationDto value, @Context HttpServletResponse response) {
        try {
            OrderItemShipGrpInvReservationCommand.CreateOrderItemShipGrpInvReservation cmd = value.toCreateOrderItemShipGrpInvReservation();
            if (cmd.getOrderItemShipGrpInvResId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "OrderItemShipGrpInvReservation");
            }

            response.setStatus(Response.Status.CREATED.getStatusCode());
            return cmd.getOrderItemShipGrpInvResId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchOrderItemShipGrpInvReservationDto.CreateOrderItemShipGrpInvReservationDto value) {
        try {

            OrderItemShipGrpInvReservationCommand.CreateOrderItemShipGrpInvReservation cmd = value.toCreateOrderItemShipGrpInvReservation();
            OrderItemShipGrpInvReservationResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            orderItemShipGrpInvReservationApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchOrderItemShipGrpInvReservationDto.MergePatchOrderItemShipGrpInvReservationDto value) {
        try {

            OrderItemShipGrpInvReservationCommand.MergePatchOrderItemShipGrpInvReservation cmd = value.toMergePatchOrderItemShipGrpInvReservation();
            OrderItemShipGrpInvReservationResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            orderItemShipGrpInvReservationApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @DELETE
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            OrderItemShipGrpInvReservationCommand.DeleteOrderItemShipGrpInvReservation deleteCmd = new AbstractOrderItemShipGrpInvReservationCommand.SimpleDeleteOrderItemShipGrpInvReservation();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            OrderItemShipGrpInvReservationResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            orderItemShipGrpInvReservationApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            OrderItemShipGrpInvReservationMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public OrderItemShipGrpInvReservationStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            OrderItemShipGrpInvResId idObj = OrderItemShipGrpInvReservationResourceUtils.parseIdString(id);
            OrderItemShipGrpInvReservationStateEventDtoConverter dtoConverter = getOrderItemShipGrpInvReservationStateEventDtoConverter();
            return dtoConverter.toOrderItemShipGrpInvReservationStateEventDto((AbstractOrderItemShipGrpInvReservationStateEvent) orderItemShipGrpInvReservationApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public OrderItemShipGrpInvReservationStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            OrderItemShipGrpInvResId idObj = OrderItemShipGrpInvReservationResourceUtils.parseIdString(id);
            OrderItemShipGrpInvReservationStateDto.DtoConverter dtoConverter = new OrderItemShipGrpInvReservationStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderItemShipGrpInvReservationStateDto(orderItemShipGrpInvReservationApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  OrderItemShipGrpInvReservationStateEventDtoConverter getOrderItemShipGrpInvReservationStateEventDtoConverter() {
        return new OrderItemShipGrpInvReservationStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new OrderItemShipGrpInvReservationPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class OrderItemShipGrpInvReservationPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return OrderItemShipGrpInvReservationResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class OrderItemShipGrpInvReservationResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, OrderItemShipGrpInvReservationCommand value) {
            OrderItemShipGrpInvResId idObj = parseIdString(id);
            if (value.getOrderItemShipGrpInvResId() == null) {
                value.setOrderItemShipGrpInvResId(idObj);
            } else if (!value.getOrderItemShipGrpInvResId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getOrderItemShipGrpInvResId());
            }
        }
    

        public static OrderItemShipGrpInvResId parseIdString(String idString) {
            TextFormatter<OrderItemShipGrpInvResId> formatter =
                    new AbstractValueObjectTextFormatter<OrderItemShipGrpInvResId>(OrderItemShipGrpInvResId.class) {
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
            if (OrderItemShipGrpInvReservationMetadata.aliasMap.containsKey(fieldName)) {
                return OrderItemShipGrpInvReservationMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (OrderItemShipGrpInvReservationMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = OrderItemShipGrpInvReservationMetadata.propertyTypeMap.get(propertyName);
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

        public static OrderItemShipGrpInvReservationStateDto[] toOrderItemShipGrpInvReservationStateDtoArray(Iterable<OrderItemShipGrpInvResId> ids) {
            List<OrderItemShipGrpInvReservationStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                OrderItemShipGrpInvReservationStateDto dto = new OrderItemShipGrpInvReservationStateDto();
                dto.setOrderItemShipGrpInvResId(id);
                states.add(dto);
            });
            return states.toArray(new OrderItemShipGrpInvReservationStateDto[0]);
        }

    }

}

