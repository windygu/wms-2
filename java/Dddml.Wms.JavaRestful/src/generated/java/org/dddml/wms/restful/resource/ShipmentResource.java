package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.apache.cxf.jaxrs.ext.PATCH;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.shipment.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("Shipments") @Produces(MediaType.APPLICATION_JSON)
public class ShipmentResource {


    @Autowired
    private ShipmentApplicationService shipmentApplicationService;


    @GET
    public ShipmentStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<ShipmentState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = shipmentApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (ShipmentMetadata.aliasMap.containsKey(n) ? ShipmentMetadata.aliasMap.get(n) : n)),
                        ShipmentResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = shipmentApplicationService.get(
                        ShipmentResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        ShipmentResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            ShipmentStateDto.DtoConverter dtoConverter = new ShipmentStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public ShipmentStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            String idObj = id;
            ShipmentState state = shipmentApplicationService.get(idObj);
            if (state == null) { return null; }

            ShipmentStateDto.DtoConverter dtoConverter = new ShipmentStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = shipmentApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (ShipmentMetadata.aliasMap.containsKey(n) ? ShipmentMetadata.aliasMap.get(n) : n)));
            } else {
                count = shipmentApplicationService.getCount(ShipmentResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @POST
    public String post(CreateOrMergePatchShipmentDto.CreateShipmentDto value, @Context HttpServletResponse response) {
        try {
            ShipmentCommand.CreateShipment cmd = value.toCreateShipment();
            if (cmd.getShipmentId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "Shipment");
            }
            shipmentApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getShipmentId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchShipmentDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                ShipmentCommand.MergePatchShipment cmd = (ShipmentCommand.MergePatchShipment) value.toCommand();
                ShipmentResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                shipmentApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            ShipmentCommand.CreateShipment cmd = (ShipmentCommand.CreateShipment) value.toCommand();
            ShipmentResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            shipmentApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchShipmentDto.MergePatchShipmentDto value) {
        try {

            ShipmentCommand.MergePatchShipment cmd = value.toMergePatchShipment();
            ShipmentResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            shipmentApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}/_commands/Import") @PUT
    public void _import(@PathParam("id") String id, ShipmentCommandDtos.ImportRequestContent content) {
        try {

            ShipmentCommands.Import cmd = content.toImport();
            String idObj = id;
            if (cmd.getShipmentId() == null) {
                cmd.setShipmentId(idObj);
            } else if (!cmd.getShipmentId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, cmd.getShipmentId());
            }
            shipmentApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}/_commands/Ship") @PUT
    public void ship(@PathParam("id") String id, ShipmentCommandDtos.ShipRequestContent content) {
        try {

            ShipmentCommands.Ship cmd = content.toShip();
            String idObj = id;
            if (cmd.getShipmentId() == null) {
                cmd.setShipmentId(idObj);
            } else if (!cmd.getShipmentId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, cmd.getShipmentId());
            }
            shipmentApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}/_commands/ReceiveItem") @PUT
    public void receiveItem(@PathParam("id") String id, ShipmentCommandDtos.ReceiveItemRequestContent content) {
        try {

            ShipmentCommands.ReceiveItem cmd = content.toReceiveItem();
            String idObj = id;
            if (cmd.getShipmentId() == null) {
                cmd.setShipmentId(idObj);
            } else if (!cmd.getShipmentId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, cmd.getShipmentId());
            }
            shipmentApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}/_commands/ConfirmAllItemsReceived") @PUT
    public void confirmAllItemsReceived(@PathParam("id") String id, ShipmentCommandDtos.ConfirmAllItemsReceivedRequestContent content) {
        try {

            ShipmentCommands.ConfirmAllItemsReceived cmd = content.toConfirmAllItemsReceived();
            String idObj = id;
            if (cmd.getShipmentId() == null) {
                cmd.setShipmentId(idObj);
            } else if (!cmd.getShipmentId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, cmd.getShipmentId());
            }
            shipmentApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            ShipmentMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public ShipmentStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            String idObj = id;
            ShipmentStateEventDtoConverter dtoConverter = getShipmentStateEventDtoConverter();
            return dtoConverter.toShipmentStateEventDto((AbstractShipmentEvent) shipmentApplicationService.getEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public ShipmentStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            String idObj = id;
            ShipmentStateDto.DtoConverter dtoConverter = new ShipmentStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentStateDto(shipmentApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{shipmentId}/ShipmentItems/{shipmentItemSeqId}") @GET
    public ShipmentItemStateDto getShipmentItem(@PathParam("shipmentId") String shipmentId, @PathParam("shipmentItemSeqId") String shipmentItemSeqId) {
        try {

            ShipmentItemState state = shipmentApplicationService.getShipmentItem(shipmentId, shipmentItemSeqId);
            if (state == null) { return null; }
            ShipmentItemStateDto.DtoConverter dtoConverter = new ShipmentItemStateDto.DtoConverter();
            ShipmentItemStateDto stateDto = dtoConverter.toShipmentItemStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{shipmentId}/ShipmentItems/") @GET
    public ShipmentItemStateDto[] getShipmentItems(@PathParam("shipmentId") String shipmentId) {
        try {
            Iterable<ShipmentItemState> states = shipmentApplicationService.getShipmentItems(shipmentId);
            if (states == null) { return null; }
            ShipmentItemStateDto.DtoConverter dtoConverter = new ShipmentItemStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toShipmentItemStateDtoArray(states);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{shipmentId}/ShipmentReceipts/{receiptSeqId}") @GET
    public ShipmentReceiptStateDto getShipmentReceipt(@PathParam("shipmentId") String shipmentId, @PathParam("receiptSeqId") String receiptSeqId) {
        try {

            ShipmentReceiptState state = shipmentApplicationService.getShipmentReceipt(shipmentId, receiptSeqId);
            if (state == null) { return null; }
            ShipmentReceiptStateDto.DtoConverter dtoConverter = new ShipmentReceiptStateDto.DtoConverter();
            ShipmentReceiptStateDto stateDto = dtoConverter.toShipmentReceiptStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{shipmentId}/ShipmentReceipts/") @GET
    public ShipmentReceiptStateDto[] getShipmentReceipts(@PathParam("shipmentId") String shipmentId) {
        try {
            Iterable<ShipmentReceiptState> states = shipmentApplicationService.getShipmentReceipts(shipmentId);
            if (states == null) { return null; }
            ShipmentReceiptStateDto.DtoConverter dtoConverter = new ShipmentReceiptStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toShipmentReceiptStateDtoArray(states);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{shipmentId}/ItemIssuances/{itemIssuanceSeqId}") @GET
    public ItemIssuanceStateDto getItemIssuance(@PathParam("shipmentId") String shipmentId, @PathParam("itemIssuanceSeqId") String itemIssuanceSeqId) {
        try {

            ItemIssuanceState state = shipmentApplicationService.getItemIssuance(shipmentId, itemIssuanceSeqId);
            if (state == null) { return null; }
            ItemIssuanceStateDto.DtoConverter dtoConverter = new ItemIssuanceStateDto.DtoConverter();
            ItemIssuanceStateDto stateDto = dtoConverter.toItemIssuanceStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{shipmentId}/ItemIssuances/") @GET
    public ItemIssuanceStateDto[] getItemIssuances(@PathParam("shipmentId") String shipmentId) {
        try {
            Iterable<ItemIssuanceState> states = shipmentApplicationService.getItemIssuances(shipmentId);
            if (states == null) { return null; }
            ItemIssuanceStateDto.DtoConverter dtoConverter = new ItemIssuanceStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toItemIssuanceStateDtoArray(states);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  ShipmentStateEventDtoConverter getShipmentStateEventDtoConverter() {
        return new ShipmentStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new ShipmentPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class ShipmentPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return ShipmentResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class ShipmentResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, ShipmentCommand value) {
            String idObj = id;
            if (value.getShipmentId() == null) {
                value.setShipmentId(idObj);
            } else if (!value.getShipmentId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getShipmentId());
            }
        }
    


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (ShipmentMetadata.aliasMap.containsKey(fieldName)) {
                return ShipmentMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (ShipmentMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = ShipmentMetadata.propertyTypeMap.get(propertyName);
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

        public static ShipmentStateDto[] toShipmentStateDtoArray(Iterable<String> ids) {
            List<ShipmentStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                ShipmentStateDto dto = new ShipmentStateDto();
                dto.setShipmentId(id);
                states.add(dto);
            });
            return states.toArray(new ShipmentStateDto[0]);
        }

    }

}

