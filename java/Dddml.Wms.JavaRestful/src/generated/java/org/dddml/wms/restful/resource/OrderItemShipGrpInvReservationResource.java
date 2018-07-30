package org.dddml.wms.restful.resource;

import java.util.*;
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

@RequestMapping(path = "OrderItemShipGrpInvReservations", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class OrderItemShipGrpInvReservationResource {


    @Autowired
    private OrderItemShipGrpInvReservationApplicationService orderItemShipGrpInvReservationApplicationService;


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

    @GetMapping("_page")
    public Page<OrderItemShipGrpInvReservationStateDto> getPage( HttpServletRequest request,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "page", defaultValue = "0") Integer page,
                                   @RequestParam(value = "size", required = false) @NotNull Integer size) {
        try {
            List<String> sort = OrderItemShipGrpInvReservationResourceUtils.getQuerySorts(request.getParameterMap());
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<OrderItemShipGrpInvReservationState> states = null; 
            Iterable<Map.Entry<String, Object>> queryFilterMap = OrderItemShipGrpInvReservationResourceUtils.getQueryFilterMap(request.getParameterMap());
            states = orderItemShipGrpInvReservationApplicationService.get(
                        queryFilterMap,
                        OrderItemShipGrpInvReservationResourceUtils.getQuerySorts(request.getParameterMap()),
                        firstResult, maxResults);
            long count = orderItemShipGrpInvReservationApplicationService.getCount(queryFilterMap);

            OrderItemShipGrpInvReservationStateDto.DtoConverter dtoConverter = new OrderItemShipGrpInvReservationStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<OrderItemShipGrpInvReservationStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toOrderItemShipGrpInvReservationStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public OrderItemShipGrpInvReservationStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
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

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
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


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchOrderItemShipGrpInvReservationDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                OrderItemShipGrpInvReservationCommand.MergePatchOrderItemShipGrpInvReservation cmd = (OrderItemShipGrpInvReservationCommand.MergePatchOrderItemShipGrpInvReservation) value.toCommand();
                OrderItemShipGrpInvReservationResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                orderItemShipGrpInvReservationApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            OrderItemShipGrpInvReservationCommand.CreateOrderItemShipGrpInvReservation cmd = (OrderItemShipGrpInvReservationCommand.CreateOrderItemShipGrpInvReservation) value.toCommand();
            OrderItemShipGrpInvReservationResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            orderItemShipGrpInvReservationApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchOrderItemShipGrpInvReservationDto.MergePatchOrderItemShipGrpInvReservationDto value) {
        try {

            OrderItemShipGrpInvReservationCommand.MergePatchOrderItemShipGrpInvReservation cmd = value.toMergePatchOrderItemShipGrpInvReservation();
            OrderItemShipGrpInvReservationResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            orderItemShipGrpInvReservationApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            OrderItemShipGrpInvReservationCommand.DeleteOrderItemShipGrpInvReservation deleteCmd = new AbstractOrderItemShipGrpInvReservationCommand.SimpleDeleteOrderItemShipGrpInvReservation();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            OrderItemShipGrpInvReservationResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
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

    @GetMapping("{id}/_events/{version}")
    public OrderItemShipGrpInvReservationEvent getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            OrderItemShipGrpInvResId idObj = OrderItemShipGrpInvReservationResourceUtils.parseIdString(id);
            //OrderItemShipGrpInvReservationStateEventDtoConverter dtoConverter = getOrderItemShipGrpInvReservationStateEventDtoConverter();
            return orderItemShipGrpInvReservationApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public OrderItemShipGrpInvReservationStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
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


    //protected  OrderItemShipGrpInvReservationStateEventDtoConverter getOrderItemShipGrpInvReservationStateEventDtoConverter() {
    //    return new OrderItemShipGrpInvReservationStateEventDtoConverter();
    //}

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

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            List<String> sorts = new ArrayList<>();
            if (values == null) {
                return null;
            }
            if (values.length == 1
                    && !values[0].toLowerCase().endsWith(",asc")
                    && !values[0].toLowerCase().endsWith(",desc")) {
                return getQueryOrders(values[0], ",");
            }
            Arrays.stream(values).forEach(s -> {
                if (s.toLowerCase().endsWith(",asc")) {
                    String f = s.substring(0, s.length() - 4).trim();
                    if (!f.isEmpty()) {
                        sorts.add(f);
                    }
                } else if (s.toLowerCase().endsWith(",desc")) {
                    String f = s.substring(0, s.length() - 5).trim();
                    if (!f.isEmpty()) {
                        sorts.add("-" + f);
                    }
                } else {
                    String f = s.trim();
                    if (!f.isEmpty()) {
                        sorts.add(f);
                    }
                }
            });
            return sorts;
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

