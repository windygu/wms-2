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
import org.dddml.wms.domain.orderitemmvo.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "OrderItemMvos", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class OrderItemMvoResource {


    @Autowired
    private OrderItemMvoApplicationService orderItemMvoApplicationService;


    @GetMapping
    public OrderItemMvoStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<OrderItemMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = orderItemMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (OrderItemMvoMetadata.aliasMap.containsKey(n) ? OrderItemMvoMetadata.aliasMap.get(n) : n)),
                        OrderItemMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = orderItemMvoApplicationService.get(
                        OrderItemMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        OrderItemMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            OrderItemMvoStateDto.DtoConverter dtoConverter = new OrderItemMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderItemMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public OrderItemMvoStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            OrderItemId idObj = OrderItemMvoResourceUtils.parseIdString(id);
            OrderItemMvoState state = orderItemMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            OrderItemMvoStateDto.DtoConverter dtoConverter = new OrderItemMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderItemMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = orderItemMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (OrderItemMvoMetadata.aliasMap.containsKey(n) ? OrderItemMvoMetadata.aliasMap.get(n) : n)));
            } else {
                count = orderItemMvoApplicationService.getCount(OrderItemMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public OrderItemId post(@RequestBody CreateOrMergePatchOrderItemMvoDto.CreateOrderItemMvoDto value,  HttpServletResponse response) {
        try {
            OrderItemMvoCommand.CreateOrderItemMvo cmd = value.toCreateOrderItemMvo();
            if (cmd.getOrderItemId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "OrderItemMvo");
            }
            orderItemMvoApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getOrderItemId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchOrderItemMvoDto value) {
        try {
            if (value.getOrderVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                OrderItemMvoCommand.MergePatchOrderItemMvo cmd = (OrderItemMvoCommand.MergePatchOrderItemMvo) value.toCommand();
                OrderItemMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                orderItemMvoApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            OrderItemMvoCommand.CreateOrderItemMvo cmd = (OrderItemMvoCommand.CreateOrderItemMvo) value.toCommand();
            OrderItemMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            orderItemMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchOrderItemMvoDto.MergePatchOrderItemMvoDto value) {
        try {

            OrderItemMvoCommand.MergePatchOrderItemMvo cmd = value.toMergePatchOrderItemMvo();
            OrderItemMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            orderItemMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            OrderItemMvoMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_stateEvents/{version}")
    public OrderItemMvoStateEventDto getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            OrderItemId idObj = OrderItemMvoResourceUtils.parseIdString(id);
            OrderItemMvoStateEventDtoConverter dtoConverter = getOrderItemMvoStateEventDtoConverter();
            return dtoConverter.toOrderItemMvoStateEventDto((AbstractOrderItemMvoEvent) orderItemMvoApplicationService.getEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public OrderItemMvoStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            OrderItemId idObj = OrderItemMvoResourceUtils.parseIdString(id);
            OrderItemMvoStateDto.DtoConverter dtoConverter = new OrderItemMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderItemMvoStateDto(orderItemMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  OrderItemMvoStateEventDtoConverter getOrderItemMvoStateEventDtoConverter() {
        return new OrderItemMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new OrderItemMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class OrderItemMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return OrderItemMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class OrderItemMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, OrderItemMvoCommand value) {
            OrderItemId idObj = parseIdString(id);
            if (value.getOrderItemId() == null) {
                value.setOrderItemId(idObj);
            } else if (!value.getOrderItemId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getOrderItemId());
            }
        }
    

        public static OrderItemId parseIdString(String idString) {
            TextFormatter<OrderItemId> formatter =
                    new AbstractValueObjectTextFormatter<OrderItemId>(OrderItemId.class) {
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
            if (OrderItemMvoMetadata.aliasMap.containsKey(fieldName)) {
                return OrderItemMvoMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (OrderItemMvoMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = OrderItemMvoMetadata.propertyTypeMap.get(propertyName);
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

        public static OrderItemMvoStateDto[] toOrderItemMvoStateDtoArray(Iterable<OrderItemId> ids) {
            List<OrderItemMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                OrderItemMvoStateDto dto = new OrderItemMvoStateDto();
                dto.setOrderItemId(id);
                states.add(dto);
            });
            return states.toArray(new OrderItemMvoStateDto[0]);
        }

    }

}

