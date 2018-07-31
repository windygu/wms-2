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
import org.dddml.wms.domain.ordershipment.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "OrderShipments", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class OrderShipmentResource {


    @Autowired
    private OrderShipmentApplicationService orderShipmentApplicationService;


    @GetMapping
    public OrderShipmentStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
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

    @GetMapping("_page")
    public Page<OrderShipmentStateDto> getPage( HttpServletRequest request,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "page", defaultValue = "0") Integer page,
                                   @RequestParam(value = "size", required = false) @NotNull Integer size) {
        try {
            List<String> sort = OrderShipmentResourceUtils.getQuerySorts(request.getParameterMap());
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<OrderShipmentState> states = null; 
            Iterable<Map.Entry<String, Object>> queryFilterMap = OrderShipmentResourceUtils.getQueryFilterMap(request.getParameterMap());
            states = orderShipmentApplicationService.get(
                        queryFilterMap,
                        OrderShipmentResourceUtils.getQuerySorts(request.getParameterMap()),
                        firstResult, maxResults);
            long count = orderShipmentApplicationService.getCount(queryFilterMap);

            OrderShipmentStateDto.DtoConverter dtoConverter = new OrderShipmentStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<OrderShipmentStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toOrderShipmentStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public OrderShipmentStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
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

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
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


    @PostMapping
    public OrderShipmentId post(@RequestBody CreateOrMergePatchOrderShipmentDto.CreateOrderShipmentDto value,  HttpServletResponse response) {
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


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchOrderShipmentDto value) {
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


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchOrderShipmentDto.MergePatchOrderShipmentDto value) {
        try {

            OrderShipmentCommand.MergePatchOrderShipment cmd = value.toMergePatchOrderShipment();
            OrderShipmentResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            orderShipmentApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            OrderShipmentMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_events/{version}")
    public OrderShipmentEvent getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            OrderShipmentId idObj = OrderShipmentResourceUtils.parseIdString(id);
            //OrderShipmentStateEventDtoConverter dtoConverter = getOrderShipmentStateEventDtoConverter();
            return orderShipmentApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public OrderShipmentStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
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


    //protected  OrderShipmentStateEventDtoConverter getOrderShipmentStateEventDtoConverter() {
    //    return new OrderShipmentStateEventDtoConverter();
    //}

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, OrderShipmentCommand value) {
            OrderShipmentId idObj = parseIdString(id);
            if (value.getOrderShipmentId() == null) {
                value.setOrderShipmentId(idObj);
            } else if (!value.getOrderShipmentId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getOrderShipmentId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            return QueryParamUtils.getQuerySorts(queryNameValuePairs);
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

