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
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inventoryitementrymvo.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("InventoryItemEntryMvos") @Produces(MediaType.APPLICATION_JSON)
public class InventoryItemEntryMvoResource {


    @Autowired
    private InventoryItemEntryMvoApplicationService inventoryItemEntryMvoApplicationService;


    @GET
    public InventoryItemEntryMvoStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<InventoryItemEntryMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = inventoryItemEntryMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (InventoryItemEntryMvoMetadata.aliasMap.containsKey(n) ? InventoryItemEntryMvoMetadata.aliasMap.get(n) : n)),
                        InventoryItemEntryMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = inventoryItemEntryMvoApplicationService.get(
                        InventoryItemEntryMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        InventoryItemEntryMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            InventoryItemEntryMvoStateDto.DtoConverter dtoConverter = new InventoryItemEntryMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryItemEntryMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public InventoryItemEntryMvoStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            InventoryItemEntryId idObj = InventoryItemEntryMvoResourceUtils.parseIdString(id);
            InventoryItemEntryMvoState state = inventoryItemEntryMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            InventoryItemEntryMvoStateDto.DtoConverter dtoConverter = new InventoryItemEntryMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryItemEntryMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = inventoryItemEntryMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (InventoryItemEntryMvoMetadata.aliasMap.containsKey(n) ? InventoryItemEntryMvoMetadata.aliasMap.get(n) : n)));
            } else {
                count = inventoryItemEntryMvoApplicationService.getCount(InventoryItemEntryMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @POST
    public InventoryItemEntryId post(CreateOrMergePatchInventoryItemEntryMvoDto.CreateInventoryItemEntryMvoDto value, @Context HttpServletResponse response) {
        try {
            InventoryItemEntryMvoCommand.CreateInventoryItemEntryMvo cmd = value.toCreateInventoryItemEntryMvo();
            if (cmd.getInventoryItemEntryId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "InventoryItemEntryMvo");
            }
            inventoryItemEntryMvoApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getInventoryItemEntryId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchInventoryItemEntryMvoDto value) {
        try {
            if (value.getInventoryItemVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                InventoryItemEntryMvoCommand.MergePatchInventoryItemEntryMvo cmd = (InventoryItemEntryMvoCommand.MergePatchInventoryItemEntryMvo) value.toCommand();
                InventoryItemEntryMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                inventoryItemEntryMvoApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            InventoryItemEntryMvoCommand.CreateInventoryItemEntryMvo cmd = (InventoryItemEntryMvoCommand.CreateInventoryItemEntryMvo) value.toCommand();
            InventoryItemEntryMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            inventoryItemEntryMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchInventoryItemEntryMvoDto.MergePatchInventoryItemEntryMvoDto value) {
        try {

            InventoryItemEntryMvoCommand.MergePatchInventoryItemEntryMvo cmd = value.toMergePatchInventoryItemEntryMvo();
            InventoryItemEntryMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            inventoryItemEntryMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            InventoryItemEntryMvoMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public InventoryItemEntryMvoStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            InventoryItemEntryId idObj = InventoryItemEntryMvoResourceUtils.parseIdString(id);
            InventoryItemEntryMvoStateEventDtoConverter dtoConverter = getInventoryItemEntryMvoStateEventDtoConverter();
            return dtoConverter.toInventoryItemEntryMvoStateEventDto((AbstractInventoryItemEntryMvoEvent) inventoryItemEntryMvoApplicationService.getEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public InventoryItemEntryMvoStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            InventoryItemEntryId idObj = InventoryItemEntryMvoResourceUtils.parseIdString(id);
            InventoryItemEntryMvoStateDto.DtoConverter dtoConverter = new InventoryItemEntryMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryItemEntryMvoStateDto(inventoryItemEntryMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  InventoryItemEntryMvoStateEventDtoConverter getInventoryItemEntryMvoStateEventDtoConverter() {
        return new InventoryItemEntryMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new InventoryItemEntryMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class InventoryItemEntryMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return InventoryItemEntryMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class InventoryItemEntryMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, InventoryItemEntryMvoCommand value) {
            InventoryItemEntryId idObj = parseIdString(id);
            if (value.getInventoryItemEntryId() == null) {
                value.setInventoryItemEntryId(idObj);
            } else if (!value.getInventoryItemEntryId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getInventoryItemEntryId());
            }
        }
    

        public static InventoryItemEntryId parseIdString(String idString) {
            TextFormatter<InventoryItemEntryId> formatter =
                    new AbstractValueObjectTextFormatter<InventoryItemEntryId>(InventoryItemEntryId.class) {
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
            if (InventoryItemEntryMvoMetadata.aliasMap.containsKey(fieldName)) {
                return InventoryItemEntryMvoMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (InventoryItemEntryMvoMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = InventoryItemEntryMvoMetadata.propertyTypeMap.get(propertyName);
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

        public static InventoryItemEntryMvoStateDto[] toInventoryItemEntryMvoStateDtoArray(Iterable<InventoryItemEntryId> ids) {
            List<InventoryItemEntryMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                InventoryItemEntryMvoStateDto dto = new InventoryItemEntryMvoStateDto();
                dto.setInventoryItemEntryId(id);
                states.add(dto);
            });
            return states.toArray(new InventoryItemEntryMvoStateDto[0]);
        }

    }

}

