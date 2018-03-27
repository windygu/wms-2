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
import org.dddml.wms.domain.pickwave.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("Pickwaves") @Produces(MediaType.APPLICATION_JSON)
public class PickwaveResource {


    @Autowired
    private PickwaveApplicationService pickwaveApplicationService;


    @GET
    public PickwaveStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<PickwaveState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = pickwaveApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (PickwaveFilteringProperties.aliasMap.containsKey(n) ? PickwaveFilteringProperties.aliasMap.get(n) : n)),
                        PickwaveResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = pickwaveApplicationService.get(
                        PickwaveResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        PickwaveResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            PickwaveStateDto.DtoConverter dtoConverter = new PickwaveStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPickwaveStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public PickwaveStateDto get(@PathParam("id") Long id, @QueryParam("fields") String fields) {
        try {
            Long idObj = id;
            PickwaveState state = pickwaveApplicationService.get(idObj);
            if (state == null) { return null; }

            PickwaveStateDto.DtoConverter dtoConverter = new PickwaveStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPickwaveStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = pickwaveApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (PickwaveFilteringProperties.aliasMap.containsKey(n) ? PickwaveFilteringProperties.aliasMap.get(n) : n)));
            } else {
                count = pickwaveApplicationService.getCount(PickwaveResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") Long id, CreateOrMergePatchPickwaveDto.CreatePickwaveDto value) {
        try {

            PickwaveCommand.CreatePickwave cmd = value.toCreatePickwave();
            PickwaveResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            pickwaveApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") Long id, CreateOrMergePatchPickwaveDto.MergePatchPickwaveDto value) {
        try {

            PickwaveCommand.MergePatchPickwave cmd = value.toMergePatchPickwave();
            PickwaveResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            pickwaveApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @DELETE
    public void delete(@PathParam("id") Long id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            PickwaveCommand.DeletePickwave deleteCmd = new AbstractPickwaveCommand.SimpleDeletePickwave();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            PickwaveResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            pickwaveApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            PickwaveFilteringProperties.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public PickwaveStateEventDto getStateEvent(@PathParam("id") Long id, @PathParam("version") long version) {
        try {

            Long idObj = id;
            PickwaveStateEventDtoConverter dtoConverter = getPickwaveStateEventDtoConverter();
            return dtoConverter.toPickwaveStateEventDto((AbstractPickwaveStateEvent) pickwaveApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public PickwaveStateDto getHistoryState(@PathParam("id") Long id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            Long idObj = id;
            PickwaveStateDto.DtoConverter dtoConverter = new PickwaveStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPickwaveStateDto(pickwaveApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  PickwaveStateEventDtoConverter getPickwaveStateEventDtoConverter() {
        return new PickwaveStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PickwavePropertyTypeResolver();
    }

    // ////////////////////////////////

    private class PickwavePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return PickwaveResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class PickwaveResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(Long id, PickwaveCommand value) {
            Long idObj = id;
            if (value.getPickwaveId() == null) {
                value.setPickwaveId(idObj);
            } else if (!value.getPickwaveId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getPickwaveId());
            }
        }
    


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (PickwaveFilteringProperties.aliasMap.containsKey(fieldName)) {
                return PickwaveFilteringProperties.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (PickwaveFilteringProperties.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = PickwaveFilteringProperties.propertyTypeMap.get(propertyName);
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

        public static PickwaveStateDto[] toPickwaveStateDtoArray(Iterable<Long> ids) {
            List<PickwaveStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                PickwaveStateDto dto = new PickwaveStateDto();
                dto.setPickwaveId(id);
                states.add(dto);
            });
            return states.toArray(new PickwaveStateDto[0]);
        }

    }

}

