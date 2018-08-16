package org.dddml.wms.restful.resource;

import java.util.*;
import java.util.stream.*;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "Orders", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class OrderResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private OrderApplicationService orderApplicationService;


    /**
     * 查询.
     * 查询 Orders
     */
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
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> OrderResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (OrderMetadata.aliasMap.containsKey(n) ? OrderMetadata.aliasMap.get(n) : n));
            states = orderApplicationService.get(
                c,
                OrderResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            OrderStateDto.DtoConverter dtoConverter = new OrderStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查询.
     * 分页查询 Orders
     */
    @GetMapping("_page")
    public Page<OrderStateDto> getPage( HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<OrderState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> OrderResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (OrderMetadata.aliasMap.containsKey(n) ? OrderMetadata.aliasMap.get(n) : n));
            states = orderApplicationService.get(
                c,
                OrderResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = orderApplicationService.getCount(c);

            OrderStateDto.DtoConverter dtoConverter = new OrderStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<OrderStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toOrderStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            statePage.setTotalElements(count);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 Order
     */
    @GetMapping("{orderId}")
    public OrderStateDto get(@PathVariable("orderId") String orderId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = orderId;
            OrderState state = orderApplicationService.get(idObj);
            if (state == null) { return null; }

            OrderStateDto.DtoConverter dtoConverter = new OrderStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSONObject.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap());
            }
            count = orderApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (OrderMetadata.aliasMap.containsKey(n) ? OrderMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 新建.
     * 新建 Order
     */
    @PostMapping
    public String post(@RequestBody CreateOrMergePatchOrderDto.CreateOrderDto value,  HttpServletResponse response) {
        try {
            OrderCommand.CreateOrder cmd = value.toCreateOrder();
            if (cmd.getOrderId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "Order");
            }
            String idObj = cmd.getOrderId();
            orderApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 Order
     */
    @PutMapping("{orderId}")
    public void put(@PathVariable("orderId") String orderId, @RequestBody CreateOrMergePatchOrderDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                OrderCommand.MergePatchOrder cmd = (OrderCommand.MergePatchOrder) value.toCommand();
                OrderResourceUtils.setNullIdOrThrowOnInconsistentIds(orderId, cmd);
                orderApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            OrderCommand.CreateOrder cmd = (OrderCommand.CreateOrder) value.toCommand();
            OrderResourceUtils.setNullIdOrThrowOnInconsistentIds(orderId, cmd);
            orderApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 修改.
     * 修改 Order
     */
    @PatchMapping("{orderId}")
    public void patch(@PathVariable("orderId") String orderId, @RequestBody CreateOrMergePatchOrderDto.MergePatchOrderDto value) {
        try {

            OrderCommand.MergePatchOrder cmd = value.toMergePatchOrder();
            OrderResourceUtils.setNullIdOrThrowOnInconsistentIds(orderId, cmd);
            orderApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            OrderMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{orderId}/_events/{version}")
    public OrderEvent getStateEvent(@PathVariable("orderId") String orderId, @PathVariable("version") long version) {
        try {

            String idObj = orderId;
            //OrderStateEventDtoConverter dtoConverter = getOrderStateEventDtoConverter();
            return orderApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{orderId}/_historyStates/{version}")
    public OrderStateDto getHistoryState(@PathVariable("orderId") String orderId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = orderId;
            OrderStateDto.DtoConverter dtoConverter = new OrderStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderStateDto(orderApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 获取指定 PartyRoleId 的 OrderRole
     */
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

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 创建 or 修改.
     * 创建 or 修改 OrderRole
     */
    @PutMapping(path = "{orderId}/OrderRoles/{partyRoleId}", consumes = MediaType.APPLICATION_JSON_VALUE)
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
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 移除.
     * 移除 OrderRole
     */
    @DeleteMapping("{orderId}/OrderRoles/{partyRoleId}")
    public void deleteOrderRole(@PathVariable("orderId") String orderId, @PathVariable("partyRoleId") String partyRoleId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            OrderCommand.MergePatchOrder mergePatchOrder = new AbstractOrderCommand.SimpleMergePatchOrder();
            mergePatchOrder.setOrderId(orderId);
            mergePatchOrder.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { 
                mergePatchOrder.setVersion(version); 
            } else {
                mergePatchOrder.setVersion(orderApplicationService.get(orderId).getVersion());
            }
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
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * OrderRole List
     */
    @GetMapping("{orderId}/OrderRoles")
    public OrderRoleStateDto[] getOrderRoles(@PathVariable("orderId") String orderId) {
        try {
            Iterable<OrderRoleState> states = orderApplicationService.getOrderRoles(orderId);
            if (states == null) { return null; }
            OrderRoleStateDto.DtoConverter dtoConverter = new OrderRoleStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toOrderRoleStateDtoArray(states);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 新建.
     * 新建 OrderRole
     */
    @PostMapping(path = "{orderId}/OrderRoles", consumes = MediaType.APPLICATION_JSON_VALUE)
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
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 获取指定 OrderItemSeqId 的 OrderItem
     */
    @GetMapping("{orderId}/OrderItems/{orderItemSeqId}")
    public OrderItemStateDto getOrderItem(@PathVariable("orderId") String orderId, @PathVariable("orderItemSeqId") String orderItemSeqId) {
        try {

            OrderItemState state = orderApplicationService.getOrderItem(orderId, orderItemSeqId);
            if (state == null) { return null; }
            OrderItemStateDto.DtoConverter dtoConverter = new OrderItemStateDto.DtoConverter();
            OrderItemStateDto stateDto = dtoConverter.toOrderItemStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 创建 or 修改.
     * 创建 or 修改 OrderItem
     */
    @PutMapping(path = "{orderId}/OrderItems/{orderItemSeqId}", consumes = MediaType.APPLICATION_JSON_VALUE)
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
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 移除.
     * 移除 OrderItem
     */
    @DeleteMapping("{orderId}/OrderItems/{orderItemSeqId}")
    public void deleteOrderItem(@PathVariable("orderId") String orderId, @PathVariable("orderItemSeqId") String orderItemSeqId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            OrderCommand.MergePatchOrder mergePatchOrder = new AbstractOrderCommand.SimpleMergePatchOrder();
            mergePatchOrder.setOrderId(orderId);
            mergePatchOrder.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { 
                mergePatchOrder.setVersion(version); 
            } else {
                mergePatchOrder.setVersion(orderApplicationService.get(orderId).getVersion());
            }
            mergePatchOrder.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            OrderItemCommand.RemoveOrderItem removeOrderItem = new AbstractOrderItemCommand.SimpleRemoveOrderItem();
            removeOrderItem.setOrderItemSeqId(orderItemSeqId);
            mergePatchOrder.getOrderItemCommands().add(removeOrderItem);
            orderApplicationService.when(mergePatchOrder);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * OrderItem List
     */
    @GetMapping("{orderId}/OrderItems")
    public OrderItemStateDto[] getOrderItems(@PathVariable("orderId") String orderId) {
        try {
            Iterable<OrderItemState> states = orderApplicationService.getOrderItems(orderId);
            if (states == null) { return null; }
            OrderItemStateDto.DtoConverter dtoConverter = new OrderItemStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toOrderItemStateDtoArray(states);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 新建.
     * 新建 OrderItem
     */
    @PostMapping(path = "{orderId}/OrderItems", consumes = MediaType.APPLICATION_JSON_VALUE)
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
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 获取指定 ShipGroupSeqId 的 OrderShipGroup
     */
    @GetMapping("{orderId}/OrderShipGroups/{shipGroupSeqId}")
    public OrderShipGroupStateDto getOrderShipGroup(@PathVariable("orderId") String orderId, @PathVariable("shipGroupSeqId") Long shipGroupSeqId) {
        try {

            OrderShipGroupState state = orderApplicationService.getOrderShipGroup(orderId, shipGroupSeqId);
            if (state == null) { return null; }
            OrderShipGroupStateDto.DtoConverter dtoConverter = new OrderShipGroupStateDto.DtoConverter();
            OrderShipGroupStateDto stateDto = dtoConverter.toOrderShipGroupStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 创建 or 修改.
     * 创建 or 修改 OrderShipGroup
     */
    @PutMapping(path = "{orderId}/OrderShipGroups/{shipGroupSeqId}", consumes = MediaType.APPLICATION_JSON_VALUE)
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
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 移除.
     * 移除 OrderShipGroup
     */
    @DeleteMapping("{orderId}/OrderShipGroups/{shipGroupSeqId}")
    public void deleteOrderShipGroup(@PathVariable("orderId") String orderId, @PathVariable("shipGroupSeqId") Long shipGroupSeqId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            OrderCommand.MergePatchOrder mergePatchOrder = new AbstractOrderCommand.SimpleMergePatchOrder();
            mergePatchOrder.setOrderId(orderId);
            mergePatchOrder.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { 
                mergePatchOrder.setVersion(version); 
            } else {
                mergePatchOrder.setVersion(orderApplicationService.get(orderId).getVersion());
            }
            mergePatchOrder.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            OrderShipGroupCommand.RemoveOrderShipGroup removeOrderShipGroup = new AbstractOrderShipGroupCommand.SimpleRemoveOrderShipGroup();
            removeOrderShipGroup.setShipGroupSeqId(shipGroupSeqId);
            mergePatchOrder.getOrderShipGroupCommands().add(removeOrderShipGroup);
            orderApplicationService.when(mergePatchOrder);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * OrderShipGroup List
     */
    @GetMapping("{orderId}/OrderShipGroups")
    public OrderShipGroupStateDto[] getOrderShipGroups(@PathVariable("orderId") String orderId) {
        try {
            Iterable<OrderShipGroupState> states = orderApplicationService.getOrderShipGroups(orderId);
            if (states == null) { return null; }
            OrderShipGroupStateDto.DtoConverter dtoConverter = new OrderShipGroupStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toOrderShipGroupStateDtoArray(states);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 新建.
     * 新建 OrderShipGroup
     */
    @PostMapping(path = "{orderId}/OrderShipGroups", consumes = MediaType.APPLICATION_JSON_VALUE)
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
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 获取指定 OrderItemSeqId 的 OrderItemShipGroupAssociation
     */
    @GetMapping("{orderId}/OrderShipGroups/{orderShipGroupShipGroupSeqId}/OrderItemShipGroupAssociations/{orderItemSeqId}")
    public OrderItemShipGroupAssociationStateDto getOrderItemShipGroupAssociation(@PathVariable("orderId") String orderId, @PathVariable("orderShipGroupShipGroupSeqId") Long orderShipGroupShipGroupSeqId, @PathVariable("orderItemSeqId") String orderItemSeqId) {
        try {

            OrderItemShipGroupAssociationState state = orderApplicationService.getOrderItemShipGroupAssociation(orderId, orderShipGroupShipGroupSeqId, orderItemSeqId);
            if (state == null) { return null; }
            OrderItemShipGroupAssociationStateDto.DtoConverter dtoConverter = new OrderItemShipGroupAssociationStateDto.DtoConverter();
            OrderItemShipGroupAssociationStateDto stateDto = dtoConverter.toOrderItemShipGroupAssociationStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 创建 or 修改.
     * 创建 or 修改 OrderItemShipGroupAssociation
     */
    @PutMapping(path = "{orderId}/OrderShipGroups/{orderShipGroupShipGroupSeqId}/OrderItemShipGroupAssociations/{orderItemSeqId}", consumes = MediaType.APPLICATION_JSON_VALUE)
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
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 移除.
     * 移除 OrderItemShipGroupAssociation
     */
    @DeleteMapping("{orderId}/OrderShipGroups/{orderShipGroupShipGroupSeqId}/OrderItemShipGroupAssociations/{orderItemSeqId}")
    public void deleteOrderItemShipGroupAssociation(@PathVariable("orderId") String orderId, @PathVariable("orderShipGroupShipGroupSeqId") Long orderShipGroupShipGroupSeqId, @PathVariable("orderItemSeqId") String orderItemSeqId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            OrderCommand.MergePatchOrder mergePatchOrder = new AbstractOrderCommand.SimpleMergePatchOrder();
            mergePatchOrder.setOrderId(orderId);
            mergePatchOrder.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { 
                mergePatchOrder.setVersion(version); 
            } else {
                mergePatchOrder.setVersion(orderApplicationService.get(orderId).getVersion());
            }
            mergePatchOrder.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            OrderShipGroupCommand.MergePatchOrderShipGroup mergePatchOrderShipGroup = new AbstractOrderShipGroupCommand.SimpleMergePatchOrderShipGroup();
            mergePatchOrderShipGroup.setShipGroupSeqId(orderShipGroupShipGroupSeqId);
            mergePatchOrder.getOrderShipGroupCommands().add(mergePatchOrderShipGroup);
            OrderItemShipGroupAssociationCommand.RemoveOrderItemShipGroupAssociation removeOrderItemShipGroupAssociation = new AbstractOrderItemShipGroupAssociationCommand.SimpleRemoveOrderItemShipGroupAssociation();
            removeOrderItemShipGroupAssociation.setOrderItemSeqId(orderItemSeqId);
            mergePatchOrderShipGroup.getOrderItemShipGroupAssociationCommands().add(removeOrderItemShipGroupAssociation);
            orderApplicationService.when(mergePatchOrder);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * OrderItemShipGroupAssociation List
     */
    @GetMapping("{orderId}/OrderShipGroups/{orderShipGroupShipGroupSeqId}/OrderItemShipGroupAssociations")
    public OrderItemShipGroupAssociationStateDto[] getOrderItemShipGroupAssociations(@PathVariable("orderId") String orderId, @PathVariable("orderShipGroupShipGroupSeqId") Long orderShipGroupShipGroupSeqId) {
        try {
            Iterable<OrderItemShipGroupAssociationState> states = orderApplicationService.getOrderItemShipGroupAssociations(orderId, orderShipGroupShipGroupSeqId);
            if (states == null) { return null; }
            OrderItemShipGroupAssociationStateDto.DtoConverter dtoConverter = new OrderItemShipGroupAssociationStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toOrderItemShipGroupAssociationStateDtoArray(states);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 新建.
     * 新建 OrderItemShipGroupAssociation
     */
    @PostMapping(path = "{orderId}/OrderShipGroups/{orderShipGroupShipGroupSeqId}/OrderItemShipGroupAssociations", consumes = MediaType.APPLICATION_JSON_VALUE)
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
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  OrderStateEventDtoConverter getOrderStateEventDtoConverter() {
    //    return new OrderStateEventDtoConverter();
    //}

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

        public static void setNullIdOrThrowOnInconsistentIds(String orderId, OrderCommand value) {
            String idObj = orderId;
            if (value.getOrderId() == null) {
                value.setOrderId(idObj);
            } else if (!value.getOrderId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", orderId, value.getOrderId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, OrderMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, OrderMetadata.aliasMap);
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
            ids.forEach(i -> {
                OrderStateDto dto = new OrderStateDto();
                dto.setOrderId(i);
                states.add(dto);
            });
            return states.toArray(new OrderStateDto[0]);
        }

    }

}

