package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.apache.cxf.jaxrs.ext.PATCH;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.ordershipgroupmvo.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("OrderShipGroupMvos") @Produces(MediaType.APPLICATION_JSON)
public class OrderShipGroupMvoResource {


    @Autowired
    private OrderShipGroupMvoApplicationService orderShipGroupMvoApplicationService;


    @GET
    public OrderShipGroupMvoStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<OrderShipGroupMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = orderShipGroupMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (OrderShipGroupMvoFilteringProperties.aliasMap.containsKey(n) ? OrderShipGroupMvoFilteringProperties.aliasMap.get(n) : n)),
                        OrderShipGroupMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = orderShipGroupMvoApplicationService.get(
                        OrderShipGroupMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        OrderShipGroupMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            OrderShipGroupMvoStateDto.DtoConverter dtoConverter = new OrderShipGroupMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderShipGroupMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public OrderShipGroupMvoStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            OrderShipGroupId idObj = OrderShipGroupMvoResourceUtils.parseIdString(id);
            OrderShipGroupMvoState state = orderShipGroupMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            OrderShipGroupMvoStateDto.DtoConverter dtoConverter = new OrderShipGroupMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderShipGroupMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = orderShipGroupMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (OrderShipGroupMvoFilteringProperties.aliasMap.containsKey(n) ? OrderShipGroupMvoFilteringProperties.aliasMap.get(n) : n)));
            } else {
                count = orderShipGroupMvoApplicationService.getCount(OrderShipGroupMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchOrderShipGroupMvoDto.CreateOrderShipGroupMvoDto value) {
        try {

            OrderShipGroupMvoCommand.CreateOrderShipGroupMvo cmd = value.toCreateOrderShipGroupMvo();
            OrderShipGroupMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            orderShipGroupMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchOrderShipGroupMvoDto.MergePatchOrderShipGroupMvoDto value) {
        try {

            OrderShipGroupMvoCommand.MergePatchOrderShipGroupMvo cmd = value.toMergePatchOrderShipGroupMvo();
            OrderShipGroupMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            orderShipGroupMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @DELETE
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            OrderShipGroupMvoCommand.DeleteOrderShipGroupMvo deleteCmd = new AbstractOrderShipGroupMvoCommand.SimpleDeleteOrderShipGroupMvo();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setOrderVersion(version);
            OrderShipGroupMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            orderShipGroupMvoApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            OrderShipGroupMvoFilteringProperties.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public OrderShipGroupMvoStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            OrderShipGroupId idObj = OrderShipGroupMvoResourceUtils.parseIdString(id);
            OrderShipGroupMvoStateEventDtoConverter dtoConverter = getOrderShipGroupMvoStateEventDtoConverter();
            return dtoConverter.toOrderShipGroupMvoStateEventDto((AbstractOrderShipGroupMvoStateEvent) orderShipGroupMvoApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public OrderShipGroupMvoStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            OrderShipGroupId idObj = OrderShipGroupMvoResourceUtils.parseIdString(id);
            OrderShipGroupMvoStateDto.DtoConverter dtoConverter = new OrderShipGroupMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrderShipGroupMvoStateDto(orderShipGroupMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  OrderShipGroupMvoStateEventDtoConverter getOrderShipGroupMvoStateEventDtoConverter() {
        return new OrderShipGroupMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new OrderShipGroupMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class OrderShipGroupMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return OrderShipGroupMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class OrderShipGroupMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, OrderShipGroupMvoCommand value) {
            OrderShipGroupId idObj = parseIdString(id);
            if (value.getOrderShipGroupId() == null) {
                value.setOrderShipGroupId(idObj);
            } else if (!value.getOrderShipGroupId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getOrderShipGroupId());
            }
        }
    

        public static OrderShipGroupId parseIdString(String idString) {
            TextFormatter<OrderShipGroupId> formatter =
                    new AbstractValueObjectTextFormatter<OrderShipGroupId>(OrderShipGroupId.class) {
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
            if (OrderShipGroupMvoFilteringProperties.aliasMap.containsKey(fieldName)) {
                return OrderShipGroupMvoFilteringProperties.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (OrderShipGroupMvoFilteringProperties.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = OrderShipGroupMvoFilteringProperties.propertyTypeMap.get(propertyName);
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

        public static OrderShipGroupMvoStateDto[] toOrderShipGroupMvoStateDtoArray(Iterable<OrderShipGroupId> ids) {
            List<OrderShipGroupMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                OrderShipGroupMvoStateDto dto = new OrderShipGroupMvoStateDto();
                dto.setOrderShipGroupId(id);
                states.add(dto);
            });
            return states.toArray(new OrderShipGroupMvoStateDto[0]);
        }

    }

}

