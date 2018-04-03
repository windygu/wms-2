package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.apache.cxf.jaxrs.ext.PATCH;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.sellableinventoryitem.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("SellableInventoryItems") @Produces(MediaType.APPLICATION_JSON)
public class SellableInventoryItemResource {


    @Autowired
    private SellableInventoryItemApplicationService sellableInventoryItemApplicationService;


    @GET
    public SellableInventoryItemStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<SellableInventoryItemState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = sellableInventoryItemApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (SellableInventoryItemMetadata.aliasMap.containsKey(n) ? SellableInventoryItemMetadata.aliasMap.get(n) : n)),
                        SellableInventoryItemResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = sellableInventoryItemApplicationService.get(
                        SellableInventoryItemResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        SellableInventoryItemResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            SellableInventoryItemStateDto.DtoConverter dtoConverter = new SellableInventoryItemStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toSellableInventoryItemStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public SellableInventoryItemStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            InventoryItemId idObj = SellableInventoryItemResourceUtils.parseIdString(id);
            SellableInventoryItemState state = sellableInventoryItemApplicationService.get(idObj);
            if (state == null) { return null; }

            SellableInventoryItemStateDto.DtoConverter dtoConverter = new SellableInventoryItemStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toSellableInventoryItemStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = sellableInventoryItemApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (SellableInventoryItemMetadata.aliasMap.containsKey(n) ? SellableInventoryItemMetadata.aliasMap.get(n) : n)));
            } else {
                count = sellableInventoryItemApplicationService.getCount(SellableInventoryItemResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @POST
    public InventoryItemId post(CreateOrMergePatchSellableInventoryItemDto.CreateSellableInventoryItemDto value, @Context HttpServletResponse response) {
        try {
            SellableInventoryItemCommand.CreateSellableInventoryItem cmd = value.toCreateSellableInventoryItem();
            if (cmd.getSellableInventoryItemId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "SellableInventoryItem");
            }

            response.setStatus(Response.Status.CREATED.getStatusCode());
            return cmd.getSellableInventoryItemId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchSellableInventoryItemDto.CreateSellableInventoryItemDto value) {
        try {

            SellableInventoryItemCommand.CreateSellableInventoryItem cmd = value.toCreateSellableInventoryItem();
            SellableInventoryItemResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            sellableInventoryItemApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchSellableInventoryItemDto.MergePatchSellableInventoryItemDto value) {
        try {

            SellableInventoryItemCommand.MergePatchSellableInventoryItem cmd = value.toMergePatchSellableInventoryItem();
            SellableInventoryItemResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            sellableInventoryItemApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            SellableInventoryItemMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{sellableInventoryItemId}/SellableInventoryItemEntries/{entrySeqId}") @GET
    public SellableInventoryItemEntryStateDto getSellableInventoryItemEntry(@PathParam("sellableInventoryItemId") String sellableInventoryItemId, @PathParam("entrySeqId") Long entrySeqId) {
        try {

            SellableInventoryItemEntryState state = sellableInventoryItemApplicationService.getSellableInventoryItemEntry((new AbstractValueObjectTextFormatter<InventoryItemId>(InventoryItemId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(sellableInventoryItemId)), entrySeqId);
            if (state == null) { return null; }
            SellableInventoryItemEntryStateDto.DtoConverter dtoConverter = new SellableInventoryItemEntryStateDto.DtoConverter();
            SellableInventoryItemEntryStateDto stateDto = dtoConverter.toSellableInventoryItemEntryStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  SellableInventoryItemStateEventDtoConverter getSellableInventoryItemStateEventDtoConverter() {
        return new SellableInventoryItemStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new SellableInventoryItemPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class SellableInventoryItemPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return SellableInventoryItemResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class SellableInventoryItemResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, SellableInventoryItemCommand value) {
            InventoryItemId idObj = parseIdString(id);
            if (value.getSellableInventoryItemId() == null) {
                value.setSellableInventoryItemId(idObj);
            } else if (!value.getSellableInventoryItemId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getSellableInventoryItemId());
            }
        }
    

        public static InventoryItemId parseIdString(String idString) {
            TextFormatter<InventoryItemId> formatter =
                    new AbstractValueObjectTextFormatter<InventoryItemId>(InventoryItemId.class) {
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
            if (SellableInventoryItemMetadata.aliasMap.containsKey(fieldName)) {
                return SellableInventoryItemMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (SellableInventoryItemMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = SellableInventoryItemMetadata.propertyTypeMap.get(propertyName);
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

        public static SellableInventoryItemStateDto[] toSellableInventoryItemStateDtoArray(Iterable<InventoryItemId> ids) {
            List<SellableInventoryItemStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                SellableInventoryItemStateDto dto = new SellableInventoryItemStateDto();
                dto.setSellableInventoryItemId(id);
                states.add(dto);
            });
            return states.toArray(new SellableInventoryItemStateDto[0]);
        }

    }

}

