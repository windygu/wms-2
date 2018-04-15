package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.apache.cxf.jaxrs.ext.PATCH;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.shipmentreceiptmvo.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("ShipmentReceiptMvos") @Produces(MediaType.APPLICATION_JSON)
public class ShipmentReceiptMvoResource {


    @Autowired
    private ShipmentReceiptMvoApplicationService shipmentReceiptMvoApplicationService;


    @GET
    public ShipmentReceiptMvoStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<ShipmentReceiptMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = shipmentReceiptMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (ShipmentReceiptMvoMetadata.aliasMap.containsKey(n) ? ShipmentReceiptMvoMetadata.aliasMap.get(n) : n)),
                        ShipmentReceiptMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = shipmentReceiptMvoApplicationService.get(
                        ShipmentReceiptMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        ShipmentReceiptMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            ShipmentReceiptMvoStateDto.DtoConverter dtoConverter = new ShipmentReceiptMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentReceiptMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public ShipmentReceiptMvoStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            ShipmentReceiptId idObj = ShipmentReceiptMvoResourceUtils.parseIdString(id);
            ShipmentReceiptMvoState state = shipmentReceiptMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            ShipmentReceiptMvoStateDto.DtoConverter dtoConverter = new ShipmentReceiptMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentReceiptMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = shipmentReceiptMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (ShipmentReceiptMvoMetadata.aliasMap.containsKey(n) ? ShipmentReceiptMvoMetadata.aliasMap.get(n) : n)));
            } else {
                count = shipmentReceiptMvoApplicationService.getCount(ShipmentReceiptMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @POST
    public ShipmentReceiptId post(CreateOrMergePatchShipmentReceiptMvoDto.CreateShipmentReceiptMvoDto value, @Context HttpServletResponse response) {
        try {
            ShipmentReceiptMvoCommand.CreateShipmentReceiptMvo cmd = value.toCreateShipmentReceiptMvo();
            if (cmd.getShipmentReceiptId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "ShipmentReceiptMvo");
            }
            shipmentReceiptMvoApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getShipmentReceiptId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchShipmentReceiptMvoDto value) {
        try {
            if (value.getShipmentVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                ShipmentReceiptMvoCommand.MergePatchShipmentReceiptMvo cmd = (ShipmentReceiptMvoCommand.MergePatchShipmentReceiptMvo) value.toCommand();
                ShipmentReceiptMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                shipmentReceiptMvoApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            ShipmentReceiptMvoCommand.CreateShipmentReceiptMvo cmd = (ShipmentReceiptMvoCommand.CreateShipmentReceiptMvo) value.toCommand();
            ShipmentReceiptMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            shipmentReceiptMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchShipmentReceiptMvoDto.MergePatchShipmentReceiptMvoDto value) {
        try {

            ShipmentReceiptMvoCommand.MergePatchShipmentReceiptMvo cmd = value.toMergePatchShipmentReceiptMvo();
            ShipmentReceiptMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            shipmentReceiptMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            ShipmentReceiptMvoMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public ShipmentReceiptMvoStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            ShipmentReceiptId idObj = ShipmentReceiptMvoResourceUtils.parseIdString(id);
            ShipmentReceiptMvoStateEventDtoConverter dtoConverter = getShipmentReceiptMvoStateEventDtoConverter();
            return dtoConverter.toShipmentReceiptMvoStateEventDto((AbstractShipmentReceiptMvoEvent) shipmentReceiptMvoApplicationService.getEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public ShipmentReceiptMvoStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            ShipmentReceiptId idObj = ShipmentReceiptMvoResourceUtils.parseIdString(id);
            ShipmentReceiptMvoStateDto.DtoConverter dtoConverter = new ShipmentReceiptMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentReceiptMvoStateDto(shipmentReceiptMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  ShipmentReceiptMvoStateEventDtoConverter getShipmentReceiptMvoStateEventDtoConverter() {
        return new ShipmentReceiptMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new ShipmentReceiptMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class ShipmentReceiptMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return ShipmentReceiptMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class ShipmentReceiptMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, ShipmentReceiptMvoCommand value) {
            ShipmentReceiptId idObj = parseIdString(id);
            if (value.getShipmentReceiptId() == null) {
                value.setShipmentReceiptId(idObj);
            } else if (!value.getShipmentReceiptId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getShipmentReceiptId());
            }
        }
    

        public static ShipmentReceiptId parseIdString(String idString) {
            TextFormatter<ShipmentReceiptId> formatter =
                    new AbstractValueObjectTextFormatter<ShipmentReceiptId>(ShipmentReceiptId.class) {
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
            if (ShipmentReceiptMvoMetadata.aliasMap.containsKey(fieldName)) {
                return ShipmentReceiptMvoMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (ShipmentReceiptMvoMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = ShipmentReceiptMvoMetadata.propertyTypeMap.get(propertyName);
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

        public static ShipmentReceiptMvoStateDto[] toShipmentReceiptMvoStateDtoArray(Iterable<ShipmentReceiptId> ids) {
            List<ShipmentReceiptMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                ShipmentReceiptMvoStateDto dto = new ShipmentReceiptMvoStateDto();
                dto.setShipmentReceiptId(id);
                states.add(dto);
            });
            return states.toArray(new ShipmentReceiptMvoStateDto[0]);
        }

    }

}

