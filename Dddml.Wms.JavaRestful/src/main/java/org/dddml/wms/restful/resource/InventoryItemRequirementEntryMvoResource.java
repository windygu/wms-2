package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.apache.cxf.jaxrs.ext.PATCH;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.inventoryitemrequirement.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inventoryitemrequiremententrymvo.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("InventoryItemRequirementEntryMvos") @Produces(MediaType.APPLICATION_JSON)
public class InventoryItemRequirementEntryMvoResource {


    @Autowired
    private InventoryItemRequirementEntryMvoApplicationService inventoryItemRequirementEntryMvoApplicationService;


    @GET
    public InventoryItemRequirementEntryMvoStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<InventoryItemRequirementEntryMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = inventoryItemRequirementEntryMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (InventoryItemRequirementEntryMvoFilteringProperties.aliasMap.containsKey(n) ? InventoryItemRequirementEntryMvoFilteringProperties.aliasMap.get(n) : n)),
                        InventoryItemRequirementEntryMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = inventoryItemRequirementEntryMvoApplicationService.get(
                        InventoryItemRequirementEntryMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        InventoryItemRequirementEntryMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            InventoryItemRequirementEntryMvoStateDto.DtoConverter dtoConverter = new InventoryItemRequirementEntryMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryItemRequirementEntryMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public InventoryItemRequirementEntryMvoStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            InventoryItemRequirementEntryId idObj = InventoryItemRequirementEntryMvoResourceUtils.parseIdString(id);
            InventoryItemRequirementEntryMvoState state = inventoryItemRequirementEntryMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            InventoryItemRequirementEntryMvoStateDto.DtoConverter dtoConverter = new InventoryItemRequirementEntryMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryItemRequirementEntryMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = inventoryItemRequirementEntryMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (InventoryItemRequirementEntryMvoFilteringProperties.aliasMap.containsKey(n) ? InventoryItemRequirementEntryMvoFilteringProperties.aliasMap.get(n) : n)));
            } else {
                count = inventoryItemRequirementEntryMvoApplicationService.getCount(InventoryItemRequirementEntryMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchInventoryItemRequirementEntryMvoDto.CreateInventoryItemRequirementEntryMvoDto value) {
        try {

            InventoryItemRequirementEntryMvoCommand.CreateInventoryItemRequirementEntryMvo cmd = value.toCreateInventoryItemRequirementEntryMvo();
            InventoryItemRequirementEntryMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            inventoryItemRequirementEntryMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchInventoryItemRequirementEntryMvoDto.MergePatchInventoryItemRequirementEntryMvoDto value) {
        try {

            InventoryItemRequirementEntryMvoCommand.MergePatchInventoryItemRequirementEntryMvo cmd = value.toMergePatchInventoryItemRequirementEntryMvo();
            InventoryItemRequirementEntryMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            inventoryItemRequirementEntryMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            InventoryItemRequirementEntryMvoFilteringProperties.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public InventoryItemRequirementEntryMvoStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            InventoryItemRequirementEntryId idObj = InventoryItemRequirementEntryMvoResourceUtils.parseIdString(id);
            InventoryItemRequirementEntryMvoStateEventDtoConverter dtoConverter = getInventoryItemRequirementEntryMvoStateEventDtoConverter();
            return dtoConverter.toInventoryItemRequirementEntryMvoStateEventDto((AbstractInventoryItemRequirementEntryMvoStateEvent) inventoryItemRequirementEntryMvoApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public InventoryItemRequirementEntryMvoStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            InventoryItemRequirementEntryId idObj = InventoryItemRequirementEntryMvoResourceUtils.parseIdString(id);
            InventoryItemRequirementEntryMvoStateDto.DtoConverter dtoConverter = new InventoryItemRequirementEntryMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryItemRequirementEntryMvoStateDto(inventoryItemRequirementEntryMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  InventoryItemRequirementEntryMvoStateEventDtoConverter getInventoryItemRequirementEntryMvoStateEventDtoConverter() {
        return new InventoryItemRequirementEntryMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new InventoryItemRequirementEntryMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class InventoryItemRequirementEntryMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return InventoryItemRequirementEntryMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class InventoryItemRequirementEntryMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, InventoryItemRequirementEntryMvoCommand value) {
            InventoryItemRequirementEntryId idObj = parseIdString(id);
            if (value.getInventoryItemRequirementEntryId() == null) {
                value.setInventoryItemRequirementEntryId(idObj);
            } else if (!value.getInventoryItemRequirementEntryId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getInventoryItemRequirementEntryId());
            }
        }
    

        public static InventoryItemRequirementEntryId parseIdString(String idString) {
            InventoryItemRequirementEntryIdFlattenedDtoFormatter formatter = new InventoryItemRequirementEntryIdFlattenedDtoFormatter();
            InventoryItemRequirementEntryIdFlattenedDto idDto = formatter.parse(idString);
            return idDto.toInventoryItemRequirementEntryId();
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (InventoryItemRequirementEntryMvoFilteringProperties.aliasMap.containsKey(fieldName)) {
                return InventoryItemRequirementEntryMvoFilteringProperties.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (InventoryItemRequirementEntryMvoFilteringProperties.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = InventoryItemRequirementEntryMvoFilteringProperties.propertyTypeMap.get(propertyName);
                if (!StringHelper.isNullOrEmpty(propertyType)) {
                    if (ReflectUtils.CLASS_MAP.containsKey(propertyType)) {
                        return ReflectUtils.CLASS_MAP.get(propertyType);
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

        public static InventoryItemRequirementEntryMvoStateDto[] toInventoryItemRequirementEntryMvoStateDtoArray(Iterable<InventoryItemRequirementEntryId> ids) {
            List<InventoryItemRequirementEntryMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                InventoryItemRequirementEntryMvoStateDto dto = new InventoryItemRequirementEntryMvoStateDto();
                dto.setInventoryItemRequirementEntryId(new InventoryItemRequirementEntryIdDtoWrapper(id));
                states.add(dto);
            });
            return states.toArray(new InventoryItemRequirementEntryMvoStateDto[0]);
        }

    }

}

