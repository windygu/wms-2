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
import org.dddml.wms.domain.facility.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("Facilities") @Produces(MediaType.APPLICATION_JSON)
public class FacilityResource {


    @Autowired
    private FacilityApplicationService facilityApplicationService;


    @GET
    public FacilityStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<FacilityState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = facilityApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (FacilityMetadata.aliasMap.containsKey(n) ? FacilityMetadata.aliasMap.get(n) : n)),
                        FacilityResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = facilityApplicationService.get(
                        FacilityResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        FacilityResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            FacilityStateDto.DtoConverter dtoConverter = new FacilityStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toFacilityStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public FacilityStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            String idObj = id;
            FacilityState state = facilityApplicationService.get(idObj);
            if (state == null) { return null; }

            FacilityStateDto.DtoConverter dtoConverter = new FacilityStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toFacilityStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = facilityApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (FacilityMetadata.aliasMap.containsKey(n) ? FacilityMetadata.aliasMap.get(n) : n)));
            } else {
                count = facilityApplicationService.getCount(FacilityResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @POST
    public String post(CreateOrMergePatchFacilityDto.CreateFacilityDto value, @Context HttpServletResponse response) {
        try {
            FacilityCommand.CreateFacility cmd = value.toCreateFacility();
            if (cmd.getFacilityId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "Facility");
            }

            response.setStatus(Response.Status.CREATED.getStatusCode());
            return cmd.getFacilityId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchFacilityDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                FacilityCommand.MergePatchFacility cmd = (FacilityCommand.MergePatchFacility) value.toCommand();
                FacilityResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                facilityApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            FacilityCommand.CreateFacility cmd = (FacilityCommand.CreateFacility) value.toCommand();
            FacilityResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            facilityApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchFacilityDto.MergePatchFacilityDto value) {
        try {

            FacilityCommand.MergePatchFacility cmd = value.toMergePatchFacility();
            FacilityResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            facilityApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @DELETE
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            FacilityCommand.DeleteFacility deleteCmd = new AbstractFacilityCommand.SimpleDeleteFacility();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            FacilityResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            facilityApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            FacilityMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public FacilityStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            String idObj = id;
            FacilityStateEventDtoConverter dtoConverter = getFacilityStateEventDtoConverter();
            return dtoConverter.toFacilityStateEventDto((AbstractFacilityStateEvent) facilityApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public FacilityStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            String idObj = id;
            FacilityStateDto.DtoConverter dtoConverter = new FacilityStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toFacilityStateDto(facilityApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  FacilityStateEventDtoConverter getFacilityStateEventDtoConverter() {
        return new FacilityStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new FacilityPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class FacilityPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return FacilityResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class FacilityResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, FacilityCommand value) {
            String idObj = id;
            if (value.getFacilityId() == null) {
                value.setFacilityId(idObj);
            } else if (!value.getFacilityId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getFacilityId());
            }
        }
    


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (FacilityMetadata.aliasMap.containsKey(fieldName)) {
                return FacilityMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (FacilityMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = FacilityMetadata.propertyTypeMap.get(propertyName);
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

        public static FacilityStateDto[] toFacilityStateDtoArray(Iterable<String> ids) {
            List<FacilityStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                FacilityStateDto dto = new FacilityStateDto();
                dto.setFacilityId(id);
                states.add(dto);
            });
            return states.toArray(new FacilityStateDto[0]);
        }

    }

}

