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
import org.dddml.wms.domain.ordershipment.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("OrderShipments") @Produces(MediaType.APPLICATION_JSON)
public class OrderShipmentResource {


    @Autowired
    private OrderShipmentApplicationService orderShipmentApplicationService;


    @GET
    public OrderShipmentStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<OrderShipmentState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = orderShipmentApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (OrderShipmentMetadata.aliasMap.containsKey(n) ? OrderShipmentMetadata.aliasMap.get(n) : n)),
                        OrderShipmentResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = orderShipmentApplicationService.get(
                        OrderShipmentResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        OrderShipmentResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            OrderShipmentStateDto.DtoConverter dtoConverter = new OrderShipmentStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderShipmentStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public OrderShipmentStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            OrderShipmentId idObj = OrderShipmentResourceUtils.parseIdString(id);
            OrderShipmentState state = orderShipmentApplicationService.get(idObj);
            if (state == null) { return null; }

            OrderShipmentStateDto.DtoConverter dtoConverter = new OrderShipmentStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderShipmentStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = orderShipmentApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (OrderShipmentMetadata.aliasMap.containsKey(n) ? OrderShipmentMetadata.aliasMap.get(n) : n)));
            } else {
                count = orderShipmentApplicationService.getCount(OrderShipmentResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @POST
    public OrderShipmentId post(CreateOrMergePatchOrderShipmentDto.CreateOrderShipmentDto value, @Context HttpServletResponse response) {
        try {
            OrderShipmentCommand.CreateOrderShipment cmd = value.toCreateOrderShipment();
            if (cmd.getOrderShipmentId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "OrderShipment");
            }
            orderShipmentApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getOrderShipmentId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchOrderShipmentDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                OrderShipmentCommand.MergePatchOrderShipment cmd = (OrderShipmentCommand.MergePatchOrderShipment) value.toCommand();
                OrderShipmentResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                orderShipmentApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            OrderShipmentCommand.CreateOrderShipment cmd = (OrderShipmentCommand.CreateOrderShipment) value.toCommand();
            OrderShipmentResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            orderShipmentApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchOrderShipmentDto.MergePatchOrderShipmentDto value) {
        try {

            OrderShipmentCommand.MergePatchOrderShipment cmd = value.toMergePatchOrderShipment();
            OrderShipmentResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            orderShipmentApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            OrderShipmentMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public OrderShipmentStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            OrderShipmentId idObj = OrderShipmentResourceUtils.parseIdString(id);
            OrderShipmentStateEventDtoConverter dtoConverter = getOrderShipmentStateEventDtoConverter();
            return dtoConverter.toOrderShipmentStateEventDto((AbstractOrderShipmentStateEvent) orderShipmentApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public OrderShipmentStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            OrderShipmentId idObj = OrderShipmentResourceUtils.parseIdString(id);
            OrderShipmentStateDto.DtoConverter dtoConverter = new OrderShipmentStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderShipmentStateDto(orderShipmentApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  OrderShipmentStateEventDtoConverter getOrderShipmentStateEventDtoConverter() {
        return new OrderShipmentStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new OrderShipmentPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class OrderShipmentPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return OrderShipmentResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class OrderShipmentResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, OrderShipmentCommand value) {
            OrderShipmentId idObj = parseIdString(id);
            if (value.getOrderShipmentId() == null) {
                value.setOrderShipmentId(idObj);
            } else if (!value.getOrderShipmentId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getOrderShipmentId());
            }
        }
    

        public static OrderShipmentId parseIdString(String idString) {
            TextFormatter<OrderShipmentId> formatter =
                    new AbstractValueObjectTextFormatter<OrderShipmentId>(OrderShipmentId.class) {
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
            if (OrderShipmentMetadata.aliasMap.containsKey(fieldName)) {
                return OrderShipmentMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (OrderShipmentMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = OrderShipmentMetadata.propertyTypeMap.get(propertyName);
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

        public static OrderShipmentStateDto[] toOrderShipmentStateDtoArray(Iterable<OrderShipmentId> ids) {
            List<OrderShipmentStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                OrderShipmentStateDto dto = new OrderShipmentStateDto();
                dto.setOrderShipmentId(id);
                states.add(dto);
            });
            return states.toArray(new OrderShipmentStateDto[0]);
        }

    }

}

