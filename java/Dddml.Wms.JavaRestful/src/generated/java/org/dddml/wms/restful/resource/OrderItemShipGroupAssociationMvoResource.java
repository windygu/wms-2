package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

@RequestMapping(path = "OrderItemShipGroupAssociationMvos", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class OrderItemShipGroupAssociationMvoResource {


    @Autowired
    private OrderItemShipGroupAssociationMvoApplicationService orderItemShipGroupAssociationMvoApplicationService;


    @GetMapping
    public OrderItemShipGroupAssociationMvoStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<OrderItemShipGroupAssociationMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = orderItemShipGroupAssociationMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (OrderItemShipGroupAssociationMvoMetadata.aliasMap.containsKey(n) ? OrderItemShipGroupAssociationMvoMetadata.aliasMap.get(n) : n)),
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

    @GetMapping("{id}")
    public OrderItemShipGroupAssociationMvoStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
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

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = orderItemShipGroupAssociationMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (OrderItemShipGroupAssociationMvoMetadata.aliasMap.containsKey(n) ? OrderItemShipGroupAssociationMvoMetadata.aliasMap.get(n) : n)));
            } else {
                count = orderItemShipGroupAssociationMvoApplicationService.getCount(OrderItemShipGroupAssociationMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public OrderItemShipGroupAssociationId post(@RequestBody CreateOrMergePatchOrderItemShipGroupAssociationMvoDto.CreateOrderItemShipGroupAssociationMvoDto value,  HttpServletResponse response) {
        try {
            OrderItemShipGroupAssociationMvoCommand.CreateOrderItemShipGroupAssociationMvo cmd = value.toCreateOrderItemShipGroupAssociationMvo();
            if (cmd.getOrderItemShipGroupAssociationId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "OrderItemShipGroupAssociationMvo");
            }
            orderItemShipGroupAssociationMvoApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getOrderItemShipGroupAssociationId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchOrderItemShipGroupAssociationMvoDto value) {
        try {
            if (value.getOrderVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                OrderItemShipGroupAssociationMvoCommand.MergePatchOrderItemShipGroupAssociationMvo cmd = (OrderItemShipGroupAssociationMvoCommand.MergePatchOrderItemShipGroupAssociationMvo) value.toCommand();
                OrderItemShipGroupAssociationMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                orderItemShipGroupAssociationMvoApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            OrderItemShipGroupAssociationMvoCommand.CreateOrderItemShipGroupAssociationMvo cmd = (OrderItemShipGroupAssociationMvoCommand.CreateOrderItemShipGroupAssociationMvo) value.toCommand();
            OrderItemShipGroupAssociationMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            orderItemShipGroupAssociationMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchOrderItemShipGroupAssociationMvoDto.MergePatchOrderItemShipGroupAssociationMvoDto value) {
        try {

            OrderItemShipGroupAssociationMvoCommand.MergePatchOrderItemShipGroupAssociationMvo cmd = value.toMergePatchOrderItemShipGroupAssociationMvo();
            OrderItemShipGroupAssociationMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            orderItemShipGroupAssociationMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            OrderItemShipGroupAssociationMvoCommand.DeleteOrderItemShipGroupAssociationMvo deleteCmd = new AbstractOrderItemShipGroupAssociationMvoCommand.SimpleDeleteOrderItemShipGroupAssociationMvo();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setOrderVersion(version);
            OrderItemShipGroupAssociationMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            orderItemShipGroupAssociationMvoApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            OrderItemShipGroupAssociationMvoMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_stateEvents/{version}")
    public OrderItemShipGroupAssociationMvoStateEventDto getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            OrderItemShipGroupAssociationId idObj = OrderItemShipGroupAssociationMvoResourceUtils.parseIdString(id);
            OrderItemShipGroupAssociationMvoStateEventDtoConverter dtoConverter = getOrderItemShipGroupAssociationMvoStateEventDtoConverter();
            return dtoConverter.toOrderItemShipGroupAssociationMvoStateEventDto((AbstractOrderItemShipGroupAssociationMvoEvent) orderItemShipGroupAssociationMvoApplicationService.getEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public OrderItemShipGroupAssociationMvoStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
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
            if (OrderItemShipGroupAssociationMvoMetadata.aliasMap.containsKey(fieldName)) {
                return OrderItemShipGroupAssociationMvoMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (OrderItemShipGroupAssociationMvoMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = OrderItemShipGroupAssociationMvoMetadata.propertyTypeMap.get(propertyName);
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

