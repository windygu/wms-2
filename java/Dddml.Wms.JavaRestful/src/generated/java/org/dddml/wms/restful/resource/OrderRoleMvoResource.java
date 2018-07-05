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
import org.dddml.wms.domain.orderrolemvo.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "OrderRoleMvos", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class OrderRoleMvoResource {


    @Autowired
    private OrderRoleMvoApplicationService orderRoleMvoApplicationService;


    @GetMapping
    public OrderRoleMvoStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<OrderRoleMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = orderRoleMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (OrderRoleMvoMetadata.aliasMap.containsKey(n) ? OrderRoleMvoMetadata.aliasMap.get(n) : n)),
                        OrderRoleMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = orderRoleMvoApplicationService.get(
                        OrderRoleMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        OrderRoleMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            OrderRoleMvoStateDto.DtoConverter dtoConverter = new OrderRoleMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderRoleMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public OrderRoleMvoStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            OrderRoleId idObj = OrderRoleMvoResourceUtils.parseIdString(id);
            OrderRoleMvoState state = orderRoleMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            OrderRoleMvoStateDto.DtoConverter dtoConverter = new OrderRoleMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderRoleMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = orderRoleMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (OrderRoleMvoMetadata.aliasMap.containsKey(n) ? OrderRoleMvoMetadata.aliasMap.get(n) : n)));
            } else {
                count = orderRoleMvoApplicationService.getCount(OrderRoleMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public OrderRoleId post(@RequestBody CreateOrMergePatchOrderRoleMvoDto.CreateOrderRoleMvoDto value,  HttpServletResponse response) {
        try {
            OrderRoleMvoCommand.CreateOrderRoleMvo cmd = value.toCreateOrderRoleMvo();
            if (cmd.getOrderRoleId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "OrderRoleMvo");
            }
            orderRoleMvoApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getOrderRoleId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchOrderRoleMvoDto value) {
        try {
            if (value.getOrderVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                OrderRoleMvoCommand.MergePatchOrderRoleMvo cmd = (OrderRoleMvoCommand.MergePatchOrderRoleMvo) value.toCommand();
                OrderRoleMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                orderRoleMvoApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            OrderRoleMvoCommand.CreateOrderRoleMvo cmd = (OrderRoleMvoCommand.CreateOrderRoleMvo) value.toCommand();
            OrderRoleMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            orderRoleMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchOrderRoleMvoDto.MergePatchOrderRoleMvoDto value) {
        try {

            OrderRoleMvoCommand.MergePatchOrderRoleMvo cmd = value.toMergePatchOrderRoleMvo();
            OrderRoleMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            orderRoleMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            OrderRoleMvoCommand.DeleteOrderRoleMvo deleteCmd = new AbstractOrderRoleMvoCommand.SimpleDeleteOrderRoleMvo();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setOrderVersion(version);
            OrderRoleMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            orderRoleMvoApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            OrderRoleMvoMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_stateEvents/{version}")
    public OrderRoleMvoStateEventDto getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            OrderRoleId idObj = OrderRoleMvoResourceUtils.parseIdString(id);
            OrderRoleMvoStateEventDtoConverter dtoConverter = getOrderRoleMvoStateEventDtoConverter();
            return dtoConverter.toOrderRoleMvoStateEventDto((AbstractOrderRoleMvoEvent) orderRoleMvoApplicationService.getEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public OrderRoleMvoStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            OrderRoleId idObj = OrderRoleMvoResourceUtils.parseIdString(id);
            OrderRoleMvoStateDto.DtoConverter dtoConverter = new OrderRoleMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderRoleMvoStateDto(orderRoleMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  OrderRoleMvoStateEventDtoConverter getOrderRoleMvoStateEventDtoConverter() {
        return new OrderRoleMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new OrderRoleMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class OrderRoleMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return OrderRoleMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class OrderRoleMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, OrderRoleMvoCommand value) {
            OrderRoleId idObj = parseIdString(id);
            if (value.getOrderRoleId() == null) {
                value.setOrderRoleId(idObj);
            } else if (!value.getOrderRoleId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getOrderRoleId());
            }
        }
    

        public static OrderRoleId parseIdString(String idString) {
            TextFormatter<OrderRoleId> formatter =
                    new AbstractValueObjectTextFormatter<OrderRoleId>(OrderRoleId.class) {
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
            if (OrderRoleMvoMetadata.aliasMap.containsKey(fieldName)) {
                return OrderRoleMvoMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (OrderRoleMvoMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = OrderRoleMvoMetadata.propertyTypeMap.get(propertyName);
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

        public static OrderRoleMvoStateDto[] toOrderRoleMvoStateDtoArray(Iterable<OrderRoleId> ids) {
            List<OrderRoleMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                OrderRoleMvoStateDto dto = new OrderRoleMvoStateDto();
                dto.setOrderRoleId(id);
                states.add(dto);
            });
            return states.toArray(new OrderRoleMvoStateDto[0]);
        }

    }

}

