package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.order.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "Orders", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class OrderResource {


    @Autowired
    private OrderApplicationService orderApplicationService;


    @GetMapping
    public OrderStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<OrderState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = orderApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (OrderMetadata.aliasMap.containsKey(n) ? OrderMetadata.aliasMap.get(n) : n)),
                        OrderResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = orderApplicationService.get(
                        OrderResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        OrderResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            OrderStateDto.DtoConverter dtoConverter = new OrderStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public OrderStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = id;
            OrderState state = orderApplicationService.get(idObj);
            if (state == null) { return null; }

            OrderStateDto.DtoConverter dtoConverter = new OrderStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = orderApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (OrderMetadata.aliasMap.containsKey(n) ? OrderMetadata.aliasMap.get(n) : n)));
            } else {
                count = orderApplicationService.getCount(OrderResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public String post(@RequestBody CreateOrMergePatchOrderDto.CreateOrderDto value,  HttpServletResponse response) {
        try {
            OrderCommand.CreateOrder cmd = value.toCreateOrder();
            if (cmd.getOrderId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "Order");
            }
            orderApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getOrderId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchOrderDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                OrderCommand.MergePatchOrder cmd = (OrderCommand.MergePatchOrder) value.toCommand();
                OrderResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                orderApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            OrderCommand.CreateOrder cmd = (OrderCommand.CreateOrder) value.toCommand();
            OrderResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            orderApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchOrderDto.MergePatchOrderDto value) {
        try {

            OrderCommand.MergePatchOrder cmd = value.toMergePatchOrder();
            OrderResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            orderApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            OrderMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_stateEvents/{version}")
    public OrderStateEventDto getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            String idObj = id;
            OrderStateEventDtoConverter dtoConverter = getOrderStateEventDtoConverter();
            return dtoConverter.toOrderStateEventDto((AbstractOrderEvent) orderApplicationService.getEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public OrderStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = id;
            OrderStateDto.DtoConverter dtoConverter = new OrderStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderStateDto(orderApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{orderId}/OrderRoles/{partyRoleId}")
    public OrderRoleStateDto getOrderRole(@PathVariable("orderId") String orderId, @PathVariable("partyRoleId") String partyRoleId) {
        try {

            OrderRoleState state = orderApplicationService.getOrderRole(orderId, (new AbstractValueObjectTextFormatter<PartyRoleId>(PartyRoleId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(partyRoleId)));
            if (state == null) { return null; }
            OrderRoleStateDto.DtoConverter dtoConverter = new OrderRoleStateDto.DtoConverter();
            OrderRoleStateDto stateDto = dtoConverter.toOrderRoleStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{orderId}/OrderRoles/")
    public OrderRoleStateDto[] getOrderRoles(@PathVariable("orderId") String orderId) {
        try {
            Iterable<OrderRoleState> states = orderApplicationService.getOrderRoles(orderId);
            if (states == null) { return null; }
            OrderRoleStateDto.DtoConverter dtoConverter = new OrderRoleStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toOrderRoleStateDtoArray(states);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{orderId}/OrderItems/{orderItemSeqId}")
    public OrderItemStateDto getOrderItem(@PathVariable("orderId") String orderId, @PathVariable("orderItemSeqId") String orderItemSeqId) {
        try {

            OrderItemState state = orderApplicationService.getOrderItem(orderId, orderItemSeqId);
            if (state == null) { return null; }
            OrderItemStateDto.DtoConverter dtoConverter = new OrderItemStateDto.DtoConverter();
            OrderItemStateDto stateDto = dtoConverter.toOrderItemStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{orderId}/OrderItems/")
    public OrderItemStateDto[] getOrderItems(@PathVariable("orderId") String orderId) {
        try {
            Iterable<OrderItemState> states = orderApplicationService.getOrderItems(orderId);
            if (states == null) { return null; }
            OrderItemStateDto.DtoConverter dtoConverter = new OrderItemStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toOrderItemStateDtoArray(states);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{orderId}/OrderShipGroups/{shipGroupSeqId}")
    public OrderShipGroupStateDto getOrderShipGroup(@PathVariable("orderId") String orderId, @PathVariable("shipGroupSeqId") Long shipGroupSeqId) {
        try {

            OrderShipGroupState state = orderApplicationService.getOrderShipGroup(orderId, shipGroupSeqId);
            if (state == null) { return null; }
            OrderShipGroupStateDto.DtoConverter dtoConverter = new OrderShipGroupStateDto.DtoConverter();
            OrderShipGroupStateDto stateDto = dtoConverter.toOrderShipGroupStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{orderId}/OrderShipGroups/")
    public OrderShipGroupStateDto[] getOrderShipGroups(@PathVariable("orderId") String orderId) {
        try {
            Iterable<OrderShipGroupState> states = orderApplicationService.getOrderShipGroups(orderId);
            if (states == null) { return null; }
            OrderShipGroupStateDto.DtoConverter dtoConverter = new OrderShipGroupStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toOrderShipGroupStateDtoArray(states);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{orderId}/OrderShipGroups/{orderShipGroupShipGroupSeqId}/OrderItemShipGroupAssociations/{orderItemSeqId}")
    public OrderItemShipGroupAssociationStateDto getOrderItemShipGroupAssociation(@PathVariable("orderId") String orderId, @PathVariable("orderShipGroupShipGroupSeqId") Long orderShipGroupShipGroupSeqId, @PathVariable("orderItemSeqId") String orderItemSeqId) {
        try {

            OrderItemShipGroupAssociationState state = orderApplicationService.getOrderItemShipGroupAssociation(orderId, orderShipGroupShipGroupSeqId, orderItemSeqId);
            if (state == null) { return null; }
            OrderItemShipGroupAssociationStateDto.DtoConverter dtoConverter = new OrderItemShipGroupAssociationStateDto.DtoConverter();
            OrderItemShipGroupAssociationStateDto stateDto = dtoConverter.toOrderItemShipGroupAssociationStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{orderId}/OrderShipGroups/{orderShipGroupShipGroupSeqId}/OrderItemShipGroupAssociations/")
    public OrderItemShipGroupAssociationStateDto[] getOrderItemShipGroupAssociations(@PathVariable("orderId") String orderId, @PathVariable("orderShipGroupShipGroupSeqId") Long orderShipGroupShipGroupSeqId) {
        try {
            Iterable<OrderItemShipGroupAssociationState> states = orderApplicationService.getOrderItemShipGroupAssociations(orderId, orderShipGroupShipGroupSeqId);
            if (states == null) { return null; }
            OrderItemShipGroupAssociationStateDto.DtoConverter dtoConverter = new OrderItemShipGroupAssociationStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toOrderItemShipGroupAssociationStateDtoArray(states);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  OrderStateEventDtoConverter getOrderStateEventDtoConverter() {
        return new OrderStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new OrderPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class OrderPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return OrderResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class OrderResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, OrderCommand value) {
            String idObj = id;
            if (value.getOrderId() == null) {
                value.setOrderId(idObj);
            } else if (!value.getOrderId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getOrderId());
            }
        }
    


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (OrderMetadata.aliasMap.containsKey(fieldName)) {
                return OrderMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (OrderMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = OrderMetadata.propertyTypeMap.get(propertyName);
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

        public static OrderStateDto[] toOrderStateDtoArray(Iterable<String> ids) {
            List<OrderStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                OrderStateDto dto = new OrderStateDto();
                dto.setOrderId(id);
                states.add(dto);
            });
            return states.toArray(new OrderStateDto[0]);
        }

    }

}

