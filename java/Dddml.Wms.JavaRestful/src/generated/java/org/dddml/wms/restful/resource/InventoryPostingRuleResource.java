package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.apache.cxf.jaxrs.ext.PATCH;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inventorypostingrule.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("InventoryPostingRules") @Produces(MediaType.APPLICATION_JSON)
public class InventoryPostingRuleResource {


    @Autowired
    private InventoryPostingRuleApplicationService inventoryPostingRuleApplicationService;


    @GET
    public InventoryPostingRuleStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<InventoryPostingRuleState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = inventoryPostingRuleApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (InventoryPostingRuleMetadata.aliasMap.containsKey(n) ? InventoryPostingRuleMetadata.aliasMap.get(n) : n)),
                        InventoryPostingRuleResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = inventoryPostingRuleApplicationService.get(
                        InventoryPostingRuleResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        InventoryPostingRuleResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            InventoryPostingRuleStateDto.DtoConverter dtoConverter = new InventoryPostingRuleStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryPostingRuleStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public InventoryPostingRuleStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            String idObj = id;
            InventoryPostingRuleState state = inventoryPostingRuleApplicationService.get(idObj);
            if (state == null) { return null; }

            InventoryPostingRuleStateDto.DtoConverter dtoConverter = new InventoryPostingRuleStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryPostingRuleStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = inventoryPostingRuleApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (InventoryPostingRuleMetadata.aliasMap.containsKey(n) ? InventoryPostingRuleMetadata.aliasMap.get(n) : n)));
            } else {
                count = inventoryPostingRuleApplicationService.getCount(InventoryPostingRuleResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @POST
    public String post(CreateOrMergePatchInventoryPostingRuleDto.CreateInventoryPostingRuleDto value, @Context HttpServletResponse response) {
        try {
            InventoryPostingRuleCommand.CreateInventoryPostingRule cmd = value.toCreateInventoryPostingRule();
            if (cmd.getInventoryPostingRuleId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "InventoryPostingRule");
            }

            response.setStatus(Response.Status.CREATED.getStatusCode());
            return cmd.getInventoryPostingRuleId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchInventoryPostingRuleDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                InventoryPostingRuleCommand.MergePatchInventoryPostingRule cmd = (InventoryPostingRuleCommand.MergePatchInventoryPostingRule) value.toCommand();
                InventoryPostingRuleResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                inventoryPostingRuleApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            InventoryPostingRuleCommand.CreateInventoryPostingRule cmd = (InventoryPostingRuleCommand.CreateInventoryPostingRule) value.toCommand();
            InventoryPostingRuleResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            inventoryPostingRuleApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchInventoryPostingRuleDto.MergePatchInventoryPostingRuleDto value) {
        try {

            InventoryPostingRuleCommand.MergePatchInventoryPostingRule cmd = value.toMergePatchInventoryPostingRule();
            InventoryPostingRuleResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            inventoryPostingRuleApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @DELETE
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            InventoryPostingRuleCommand.DeleteInventoryPostingRule deleteCmd = new AbstractInventoryPostingRuleCommand.SimpleDeleteInventoryPostingRule();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            InventoryPostingRuleResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            inventoryPostingRuleApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            InventoryPostingRuleMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public InventoryPostingRuleStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            String idObj = id;
            InventoryPostingRuleStateEventDtoConverter dtoConverter = getInventoryPostingRuleStateEventDtoConverter();
            return dtoConverter.toInventoryPostingRuleStateEventDto((AbstractInventoryPostingRuleStateEvent) inventoryPostingRuleApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public InventoryPostingRuleStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            String idObj = id;
            InventoryPostingRuleStateDto.DtoConverter dtoConverter = new InventoryPostingRuleStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInventoryPostingRuleStateDto(inventoryPostingRuleApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  InventoryPostingRuleStateEventDtoConverter getInventoryPostingRuleStateEventDtoConverter() {
        return new InventoryPostingRuleStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new InventoryPostingRulePropertyTypeResolver();
    }

    // ////////////////////////////////

    private class InventoryPostingRulePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return InventoryPostingRuleResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class InventoryPostingRuleResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, InventoryPostingRuleCommand value) {
            String idObj = id;
            if (value.getInventoryPostingRuleId() == null) {
                value.setInventoryPostingRuleId(idObj);
            } else if (!value.getInventoryPostingRuleId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getInventoryPostingRuleId());
            }
        }
    


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (InventoryPostingRuleMetadata.aliasMap.containsKey(fieldName)) {
                return InventoryPostingRuleMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (InventoryPostingRuleMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = InventoryPostingRuleMetadata.propertyTypeMap.get(propertyName);
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

        public static InventoryPostingRuleStateDto[] toInventoryPostingRuleStateDtoArray(Iterable<String> ids) {
            List<InventoryPostingRuleStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                InventoryPostingRuleStateDto dto = new InventoryPostingRuleStateDto();
                dto.setInventoryPostingRuleId(id);
                states.add(dto);
            });
            return states.toArray(new InventoryPostingRuleStateDto[0]);
        }

    }

}

