package org.dddml.wms.restful.resource;

import java.util.*;
import java.util.stream.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.orderitemshipgrpinvreservation.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "OrderItemShipGrpInvReservations", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class OrderItemShipGrpInvReservationResource {


    @Autowired
    private OrderItemShipGrpInvReservationApplicationService orderItemShipGrpInvReservationApplicationService;


    /**
     * 查询.
     * 查询 OrderItemShipGrpInvReservations
     */
    @GetMapping
    public OrderItemShipGrpInvReservationStateDto[] getAll( HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<OrderItemShipGrpInvReservationState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> OrderItemShipGrpInvReservationResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (OrderItemShipGrpInvReservationMetadata.aliasMap.containsKey(n) ? OrderItemShipGrpInvReservationMetadata.aliasMap.get(n) : n));
            states = orderItemShipGrpInvReservationApplicationService.get(
                c,
                OrderItemShipGrpInvReservationResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            OrderItemShipGrpInvReservationStateDto.DtoConverter dtoConverter = new OrderItemShipGrpInvReservationStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderItemShipGrpInvReservationStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查询.
     * 分页查询 OrderItemShipGrpInvReservations
     */
    @GetMapping("_page")
    public Page<OrderItemShipGrpInvReservationStateDto> getPage( HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<OrderItemShipGrpInvReservationState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> OrderItemShipGrpInvReservationResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (OrderItemShipGrpInvReservationMetadata.aliasMap.containsKey(n) ? OrderItemShipGrpInvReservationMetadata.aliasMap.get(n) : n));
            states = orderItemShipGrpInvReservationApplicationService.get(
                c,
                OrderItemShipGrpInvReservationResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = orderItemShipGrpInvReservationApplicationService.getCount(c);

            OrderItemShipGrpInvReservationStateDto.DtoConverter dtoConverter = new OrderItemShipGrpInvReservationStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<OrderItemShipGrpInvReservationStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toOrderItemShipGrpInvReservationStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            statePage.setTotalElements(count);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 OrderItemShipGrpInvReservation
     */
    @GetMapping("{orderItemShipGrpInvResId}")
    public OrderItemShipGrpInvReservationStateDto get(@PathVariable("orderItemShipGrpInvResId") String orderItemShipGrpInvResId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            OrderItemShipGrpInvResId idObj = OrderItemShipGrpInvReservationResourceUtils.parseIdString(orderItemShipGrpInvResId);
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
            count = orderItemShipGrpInvReservationApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (OrderItemShipGrpInvReservationMetadata.aliasMap.containsKey(n) ? OrderItemShipGrpInvReservationMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 新建.
     * 新建 OrderItemShipGrpInvReservation
     */
    @PostMapping
    public OrderItemShipGrpInvResId post(@RequestBody CreateOrMergePatchOrderItemShipGrpInvReservationDto.CreateOrderItemShipGrpInvReservationDto value,  HttpServletResponse response) {
        try {
            OrderItemShipGrpInvReservationCommand.CreateOrderItemShipGrpInvReservation cmd = value.toCreateOrderItemShipGrpInvReservation();
            if (cmd.getOrderItemShipGrpInvResId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "OrderItemShipGrpInvReservation");
            }
            orderItemShipGrpInvReservationApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getOrderItemShipGrpInvResId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 OrderItemShipGrpInvReservation
     */
    @PutMapping("{orderItemShipGrpInvResId}")
    public void put(@PathVariable("orderItemShipGrpInvResId") String orderItemShipGrpInvResId, @RequestBody CreateOrMergePatchOrderItemShipGrpInvReservationDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                OrderItemShipGrpInvReservationCommand.MergePatchOrderItemShipGrpInvReservation cmd = (OrderItemShipGrpInvReservationCommand.MergePatchOrderItemShipGrpInvReservation) value.toCommand();
                OrderItemShipGrpInvReservationResourceUtils.setNullIdOrThrowOnInconsistentIds(orderItemShipGrpInvResId, cmd);
                orderItemShipGrpInvReservationApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            OrderItemShipGrpInvReservationCommand.CreateOrderItemShipGrpInvReservation cmd = (OrderItemShipGrpInvReservationCommand.CreateOrderItemShipGrpInvReservation) value.toCommand();
            OrderItemShipGrpInvReservationResourceUtils.setNullIdOrThrowOnInconsistentIds(orderItemShipGrpInvResId, cmd);
            orderItemShipGrpInvReservationApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 修改.
     * 修改 OrderItemShipGrpInvReservation
     */
    @PatchMapping("{orderItemShipGrpInvResId}")
    public void patch(@PathVariable("orderItemShipGrpInvResId") String orderItemShipGrpInvResId, @RequestBody CreateOrMergePatchOrderItemShipGrpInvReservationDto.MergePatchOrderItemShipGrpInvReservationDto value) {
        try {

            OrderItemShipGrpInvReservationCommand.MergePatchOrderItemShipGrpInvReservation cmd = value.toMergePatchOrderItemShipGrpInvReservation();
            OrderItemShipGrpInvReservationResourceUtils.setNullIdOrThrowOnInconsistentIds(orderItemShipGrpInvResId, cmd);
            orderItemShipGrpInvReservationApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 删除.
     * 删除 OrderItemShipGrpInvReservation
     */
    @DeleteMapping("{orderItemShipGrpInvResId}")
    public void delete(@PathVariable("orderItemShipGrpInvResId") String orderItemShipGrpInvResId,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            OrderItemShipGrpInvReservationCommand.DeleteOrderItemShipGrpInvReservation deleteCmd = new AbstractOrderItemShipGrpInvReservationCommand.SimpleDeleteOrderItemShipGrpInvReservation();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            OrderItemShipGrpInvReservationResourceUtils.setNullIdOrThrowOnInconsistentIds(orderItemShipGrpInvResId, deleteCmd);
            orderItemShipGrpInvReservationApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            OrderItemShipGrpInvReservationMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{orderItemShipGrpInvResId}/_events/{version}")
    public OrderItemShipGrpInvReservationEvent getStateEvent(@PathVariable("orderItemShipGrpInvResId") String orderItemShipGrpInvResId, @PathVariable("version") long version) {
        try {

            OrderItemShipGrpInvResId idObj = OrderItemShipGrpInvReservationResourceUtils.parseIdString(orderItemShipGrpInvResId);
            //OrderItemShipGrpInvReservationStateEventDtoConverter dtoConverter = getOrderItemShipGrpInvReservationStateEventDtoConverter();
            return orderItemShipGrpInvReservationApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{orderItemShipGrpInvResId}/_historyStates/{version}")
    public OrderItemShipGrpInvReservationStateDto getHistoryState(@PathVariable("orderItemShipGrpInvResId") String orderItemShipGrpInvResId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            OrderItemShipGrpInvResId idObj = OrderItemShipGrpInvReservationResourceUtils.parseIdString(orderItemShipGrpInvResId);
            OrderItemShipGrpInvReservationStateDto.DtoConverter dtoConverter = new OrderItemShipGrpInvReservationStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderItemShipGrpInvReservationStateDto(orderItemShipGrpInvReservationApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  OrderItemShipGrpInvReservationStateEventDtoConverter getOrderItemShipGrpInvReservationStateEventDtoConverter() {
    //    return new OrderItemShipGrpInvReservationStateEventDtoConverter();
    //}

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

        public static void setNullIdOrThrowOnInconsistentIds(String orderItemShipGrpInvResId, OrderItemShipGrpInvReservationCommand value) {
            OrderItemShipGrpInvResId idObj = parseIdString(orderItemShipGrpInvResId);
            if (value.getOrderItemShipGrpInvResId() == null) {
                value.setOrderItemShipGrpInvResId(idObj);
            } else if (!value.getOrderItemShipGrpInvResId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", orderItemShipGrpInvResId, value.getOrderItemShipGrpInvResId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, OrderItemShipGrpInvReservationMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, OrderItemShipGrpInvReservationMetadata.aliasMap);
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
            ids.forEach(i -> {
                OrderItemShipGrpInvReservationStateDto dto = new OrderItemShipGrpInvReservationStateDto();
                dto.setOrderItemShipGrpInvResId(i);
                states.add(dto);
            });
            return states.toArray(new OrderItemShipGrpInvReservationStateDto[0]);
        }

    }

}

