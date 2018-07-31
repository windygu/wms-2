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

    @GetMapping("_page")
    public Page<OrderStateDto> getPage( HttpServletRequest request,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "page", defaultValue = "0") Integer page,
                                   @RequestParam(value = "size", required = false) @NotNull Integer size) {
        try {
            List<String> sort = OrderResourceUtils.getQuerySorts(request.getParameterMap());
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<OrderState> states = null; 
            Iterable<Map.Entry<String, Object>> queryFilterMap = OrderResourceUtils.getQueryFilterMap(request.getParameterMap());
            states = orderApplicationService.get(
                        queryFilterMap,
                        OrderResourceUtils.getQuerySorts(request.getParameterMap()),
                        firstResult, maxResults);
            long count = orderApplicationService.getCount(queryFilterMap);

            OrderStateDto.DtoConverter dtoConverter = new OrderStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<OrderStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toOrderStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

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

    @GetMapping("{id}/_events/{version}")
    public OrderEvent getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            String idObj = id;
            //OrderStateEventDtoConverter dtoConverter = getOrderStateEventDtoConverter();
            return orderApplicationService.getEvent(idObj, version);

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

    @PutMapping("{orderId}/OrderRoles/{partyRoleId}")
    public void putOrderRole(@PathVariable("orderId") String orderId, @PathVariable("partyRoleId") String partyRoleId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchOrderRoleDto.MergePatchOrderRoleDto body) {
        try {
            OrderCommand.MergePatchOrder mergePatchOrder = new AbstractOrderCommand.SimpleMergePatchOrder();
            mergePatchOrder.setOrderId(orderId);
            mergePatchOrder.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchOrder.setVersion(version); }
            mergePatchOrder.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            OrderRoleCommand.MergePatchOrderRole mergePatchOrderRole = body.toMergePatchOrderRole();
            mergePatchOrderRole.setPartyRoleId((new AbstractValueObjectTextFormatter<PartyRoleId>(PartyRoleId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(partyRoleId)));
            mergePatchOrder.getOrderRoleCommands().add(mergePatchOrderRole);
            orderApplicationService.when(mergePatchOrder);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{orderId}/OrderRoles/{partyRoleId}")
    public void deleteOrderRole(@PathVariable("orderId") String orderId, @PathVariable("partyRoleId") String partyRoleId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            OrderCommand.MergePatchOrder mergePatchOrder = new AbstractOrderCommand.SimpleMergePatchOrder();
            mergePatchOrder.setOrderId(orderId);
            mergePatchOrder.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchOrder.setVersion(version); }
            mergePatchOrder.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            OrderRoleCommand.RemoveOrderRole removeOrderRole = new AbstractOrderRoleCommand.SimpleRemoveOrderRole();
            removeOrderRole.setPartyRoleId((new AbstractValueObjectTextFormatter<PartyRoleId>(PartyRoleId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(partyRoleId)));
            mergePatchOrder.getOrderRoleCommands().add(removeOrderRole);
            orderApplicationService.when(mergePatchOrder);
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

    @PostMapping("{orderId}/OrderRoles/")
    public void postOrderRoles(@PathVariable("orderId") String orderId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchOrderRoleDto.CreateOrderRoleDto body) {
        try {
            OrderCommand.MergePatchOrder mergePatchOrder = new AbstractOrderCommand.SimpleMergePatchOrder();
            mergePatchOrder.setOrderId(orderId);
            mergePatchOrder.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchOrder.setVersion(version); }
            mergePatchOrder.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            OrderRoleCommand.CreateOrderRole createOrderRole = body.toCreateOrderRole();
            mergePatchOrder.getOrderRoleCommands().add(createOrderRole);
            orderApplicationService.when(mergePatchOrder);
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

    @PutMapping("{orderId}/OrderItems/{orderItemSeqId}")
    public void putOrderItem(@PathVariable("orderId") String orderId, @PathVariable("orderItemSeqId") String orderItemSeqId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchOrderItemDto.MergePatchOrderItemDto body) {
        try {
            OrderCommand.MergePatchOrder mergePatchOrder = new AbstractOrderCommand.SimpleMergePatchOrder();
            mergePatchOrder.setOrderId(orderId);
            mergePatchOrder.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchOrder.setVersion(version); }
            mergePatchOrder.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            OrderItemCommand.MergePatchOrderItem mergePatchOrderItem = body.toMergePatchOrderItem();
            mergePatchOrderItem.setOrderItemSeqId(orderItemSeqId);
            mergePatchOrder.getOrderItemCommands().add(mergePatchOrderItem);
            orderApplicationService.when(mergePatchOrder);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{orderId}/OrderItems/{orderItemSeqId}")
    public void deleteOrderItem(@PathVariable("orderId") String orderId, @PathVariable("orderItemSeqId") String orderItemSeqId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            OrderCommand.MergePatchOrder mergePatchOrder = new AbstractOrderCommand.SimpleMergePatchOrder();
            mergePatchOrder.setOrderId(orderId);
            mergePatchOrder.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchOrder.setVersion(version); }
            mergePatchOrder.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            OrderItemCommand.RemoveOrderItem removeOrderItem = new AbstractOrderItemCommand.SimpleRemoveOrderItem();
            removeOrderItem.setOrderItemSeqId(orderItemSeqId);
            mergePatchOrder.getOrderItemCommands().add(removeOrderItem);
            orderApplicationService.when(mergePatchOrder);
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

    @PostMapping("{orderId}/OrderItems/")
    public void postOrderItems(@PathVariable("orderId") String orderId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchOrderItemDto.CreateOrderItemDto body) {
        try {
            OrderCommand.MergePatchOrder mergePatchOrder = new AbstractOrderCommand.SimpleMergePatchOrder();
            mergePatchOrder.setOrderId(orderId);
            mergePatchOrder.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchOrder.setVersion(version); }
            mergePatchOrder.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            OrderItemCommand.CreateOrderItem createOrderItem = body.toCreateOrderItem();
            mergePatchOrder.getOrderItemCommands().add(createOrderItem);
            orderApplicationService.when(mergePatchOrder);
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

    @PutMapping("{orderId}/OrderShipGroups/{shipGroupSeqId}")
    public void putOrderShipGroup(@PathVariable("orderId") String orderId, @PathVariable("shipGroupSeqId") Long shipGroupSeqId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchOrderShipGroupDto.MergePatchOrderShipGroupDto body) {
        try {
            OrderCommand.MergePatchOrder mergePatchOrder = new AbstractOrderCommand.SimpleMergePatchOrder();
            mergePatchOrder.setOrderId(orderId);
            mergePatchOrder.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchOrder.setVersion(version); }
            mergePatchOrder.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            OrderShipGroupCommand.MergePatchOrderShipGroup mergePatchOrderShipGroup = body.toMergePatchOrderShipGroup();
            mergePatchOrderShipGroup.setShipGroupSeqId(shipGroupSeqId);
            mergePatchOrder.getOrderShipGroupCommands().add(mergePatchOrderShipGroup);
            orderApplicationService.when(mergePatchOrder);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{orderId}/OrderShipGroups/{shipGroupSeqId}")
    public void deleteOrderShipGroup(@PathVariable("orderId") String orderId, @PathVariable("shipGroupSeqId") Long shipGroupSeqId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            OrderCommand.MergePatchOrder mergePatchOrder = new AbstractOrderCommand.SimpleMergePatchOrder();
            mergePatchOrder.setOrderId(orderId);
            mergePatchOrder.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchOrder.setVersion(version); }
            mergePatchOrder.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            OrderShipGroupCommand.RemoveOrderShipGroup removeOrderShipGroup = new AbstractOrderShipGroupCommand.SimpleRemoveOrderShipGroup();
            removeOrderShipGroup.setShipGroupSeqId(shipGroupSeqId);
            mergePatchOrder.getOrderShipGroupCommands().add(removeOrderShipGroup);
            orderApplicationService.when(mergePatchOrder);
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

    @PostMapping("{orderId}/OrderShipGroups/")
    public void postOrderShipGroups(@PathVariable("orderId") String orderId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchOrderShipGroupDto.CreateOrderShipGroupDto body) {
        try {
            OrderCommand.MergePatchOrder mergePatchOrder = new AbstractOrderCommand.SimpleMergePatchOrder();
            mergePatchOrder.setOrderId(orderId);
            mergePatchOrder.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchOrder.setVersion(version); }
            mergePatchOrder.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            OrderShipGroupCommand.CreateOrderShipGroup createOrderShipGroup = body.toCreateOrderShipGroup();
            mergePatchOrder.getOrderShipGroupCommands().add(createOrderShipGroup);
            orderApplicationService.when(mergePatchOrder);
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

    @PutMapping("{orderId}/OrderShipGroups/{orderShipGroupShipGroupSeqId}/OrderItemShipGroupAssociations/{orderItemSeqId}")
    public void putOrderItemShipGroupAssociation(@PathVariable("orderId") String orderId, @PathVariable("orderShipGroupShipGroupSeqId") Long orderShipGroupShipGroupSeqId, @PathVariable("orderItemSeqId") String orderItemSeqId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchOrderItemShipGroupAssociationDto.MergePatchOrderItemShipGroupAssociationDto body) {
        try {
            OrderCommand.MergePatchOrder mergePatchOrder = new AbstractOrderCommand.SimpleMergePatchOrder();
            mergePatchOrder.setOrderId(orderId);
            mergePatchOrder.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchOrder.setVersion(version); }
            mergePatchOrder.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            OrderShipGroupCommand.MergePatchOrderShipGroup mergePatchOrderShipGroup = new AbstractOrderShipGroupCommand.SimpleMergePatchOrderShipGroup();
            mergePatchOrderShipGroup.setShipGroupSeqId(orderShipGroupShipGroupSeqId);
            mergePatchOrder.getOrderShipGroupCommands().add(mergePatchOrderShipGroup);
            OrderItemShipGroupAssociationCommand.MergePatchOrderItemShipGroupAssociation mergePatchOrderItemShipGroupAssociation = body.toMergePatchOrderItemShipGroupAssociation();
            mergePatchOrderItemShipGroupAssociation.setOrderItemSeqId(orderItemSeqId);
            mergePatchOrderShipGroup.getOrderItemShipGroupAssociationCommands().add(mergePatchOrderItemShipGroupAssociation);
            orderApplicationService.when(mergePatchOrder);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{orderId}/OrderShipGroups/{orderShipGroupShipGroupSeqId}/OrderItemShipGroupAssociations/{orderItemSeqId}")
    public void deleteOrderItemShipGroupAssociation(@PathVariable("orderId") String orderId, @PathVariable("orderShipGroupShipGroupSeqId") Long orderShipGroupShipGroupSeqId, @PathVariable("orderItemSeqId") String orderItemSeqId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            OrderCommand.MergePatchOrder mergePatchOrder = new AbstractOrderCommand.SimpleMergePatchOrder();
            mergePatchOrder.setOrderId(orderId);
            mergePatchOrder.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchOrder.setVersion(version); }
            mergePatchOrder.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            OrderShipGroupCommand.MergePatchOrderShipGroup mergePatchOrderShipGroup = new AbstractOrderShipGroupCommand.SimpleMergePatchOrderShipGroup();
            mergePatchOrderShipGroup.setShipGroupSeqId(orderShipGroupShipGroupSeqId);
            mergePatchOrder.getOrderShipGroupCommands().add(mergePatchOrderShipGroup);
            OrderItemShipGroupAssociationCommand.RemoveOrderItemShipGroupAssociation removeOrderItemShipGroupAssociation = new AbstractOrderItemShipGroupAssociationCommand.SimpleRemoveOrderItemShipGroupAssociation();
            removeOrderItemShipGroupAssociation.setOrderItemSeqId(orderItemSeqId);
            mergePatchOrderShipGroup.getOrderItemShipGroupAssociationCommands().add(removeOrderItemShipGroupAssociation);
            orderApplicationService.when(mergePatchOrder);
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

    @PostMapping("{orderId}/OrderShipGroups/{orderShipGroupShipGroupSeqId}/OrderItemShipGroupAssociations/")
    public void postOrderItemShipGroupAssociations(@PathVariable("orderId") String orderId, @PathVariable("orderShipGroupShipGroupSeqId") Long orderShipGroupShipGroupSeqId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchOrderItemShipGroupAssociationDto.CreateOrderItemShipGroupAssociationDto body) {
        try {
            OrderCommand.MergePatchOrder mergePatchOrder = new AbstractOrderCommand.SimpleMergePatchOrder();
            mergePatchOrder.setOrderId(orderId);
            mergePatchOrder.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchOrder.setVersion(version); }
            mergePatchOrder.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            OrderShipGroupCommand.MergePatchOrderShipGroup mergePatchOrderShipGroup = new AbstractOrderShipGroupCommand.SimpleMergePatchOrderShipGroup();
            mergePatchOrderShipGroup.setShipGroupSeqId(orderShipGroupShipGroupSeqId);
            mergePatchOrder.getOrderShipGroupCommands().add(mergePatchOrderShipGroup);
            OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation createOrderItemShipGroupAssociation = body.toCreateOrderItemShipGroupAssociation();
            mergePatchOrderShipGroup.getOrderItemShipGroupAssociationCommands().add(createOrderItemShipGroupAssociation);
            orderApplicationService.when(mergePatchOrder);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  OrderStateEventDtoConverter getOrderStateEventDtoConverter() {
    //    return new OrderStateEventDtoConverter();
    //}

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, OrderCommand value) {
            String idObj = id;
            if (value.getOrderId() == null) {
                value.setOrderId(idObj);
            } else if (!value.getOrderId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getOrderId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            return QueryParamUtils.getQuerySorts(queryNameValuePairs);
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

