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
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("PartyRoles") @Produces(MediaType.APPLICATION_JSON)
public class PartyRoleResource {


    @Autowired
    private PartyRoleApplicationService partyRoleApplicationService;


    @GET
    public PartyRoleStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<PartyRoleState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = partyRoleApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (PartyRoleMetadata.aliasMap.containsKey(n) ? PartyRoleMetadata.aliasMap.get(n) : n)),
                        PartyRoleResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = partyRoleApplicationService.get(
                        PartyRoleResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        PartyRoleResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            PartyRoleStateDto.DtoConverter dtoConverter = new PartyRoleStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPartyRoleStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public PartyRoleStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            PartyRoleId idObj = PartyRoleResourceUtils.parseIdString(id);
            PartyRoleState state = partyRoleApplicationService.get(idObj);
            if (state == null) { return null; }

            PartyRoleStateDto.DtoConverter dtoConverter = new PartyRoleStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPartyRoleStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = partyRoleApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (PartyRoleMetadata.aliasMap.containsKey(n) ? PartyRoleMetadata.aliasMap.get(n) : n)));
            } else {
                count = partyRoleApplicationService.getCount(PartyRoleResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @POST
    public PartyRoleId post(CreateOrMergePatchPartyRoleDto.CreatePartyRoleDto value, @Context HttpServletResponse response) {
        try {
            PartyRoleCommand.CreatePartyRole cmd = value.toCreatePartyRole();
            if (cmd.getPartyRoleId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "PartyRole");
            }

            response.setStatus(Response.Status.CREATED.getStatusCode());
            return cmd.getPartyRoleId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchPartyRoleDto.CreatePartyRoleDto value) {
        try {

            PartyRoleCommand.CreatePartyRole cmd = value.toCreatePartyRole();
            PartyRoleResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            partyRoleApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchPartyRoleDto.MergePatchPartyRoleDto value) {
        try {

            PartyRoleCommand.MergePatchPartyRole cmd = value.toMergePatchPartyRole();
            PartyRoleResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            partyRoleApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @DELETE
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            PartyRoleCommand.DeletePartyRole deleteCmd = new AbstractPartyRoleCommand.SimpleDeletePartyRole();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            PartyRoleResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            partyRoleApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            PartyRoleMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public PartyRoleStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            PartyRoleId idObj = PartyRoleResourceUtils.parseIdString(id);
            PartyRoleStateEventDtoConverter dtoConverter = getPartyRoleStateEventDtoConverter();
            return dtoConverter.toPartyRoleStateEventDto((AbstractPartyRoleStateEvent) partyRoleApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public PartyRoleStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            PartyRoleId idObj = PartyRoleResourceUtils.parseIdString(id);
            PartyRoleStateDto.DtoConverter dtoConverter = new PartyRoleStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPartyRoleStateDto(partyRoleApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  PartyRoleStateEventDtoConverter getPartyRoleStateEventDtoConverter() {
        return new PartyRoleStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PartyRolePropertyTypeResolver();
    }

    // ////////////////////////////////

    private class PartyRolePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return PartyRoleResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class PartyRoleResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, PartyRoleCommand value) {
            PartyRoleId idObj = parseIdString(id);
            if (value.getPartyRoleId() == null) {
                value.setPartyRoleId(idObj);
            } else if (!value.getPartyRoleId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getPartyRoleId());
            }
        }
    

        public static PartyRoleId parseIdString(String idString) {
            TextFormatter<PartyRoleId> formatter =
                    new AbstractValueObjectTextFormatter<PartyRoleId>(PartyRoleId.class) {
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
            if (PartyRoleMetadata.aliasMap.containsKey(fieldName)) {
                return PartyRoleMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (PartyRoleMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = PartyRoleMetadata.propertyTypeMap.get(propertyName);
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

        public static PartyRoleStateDto[] toPartyRoleStateDtoArray(Iterable<PartyRoleId> ids) {
            List<PartyRoleStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                PartyRoleStateDto dto = new PartyRoleStateDto();
                dto.setPartyRoleId(id);
                states.add(dto);
            });
            return states.toArray(new PartyRoleStateDto[0]);
        }

    }

}

