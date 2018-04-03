package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.apache.cxf.jaxrs.ext.PATCH;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.movementlinemvo.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("MovementLineMvos") @Produces(MediaType.APPLICATION_JSON)
public class MovementLineMvoResource {


    @Autowired
    private MovementLineMvoApplicationService movementLineMvoApplicationService;


    @GET
    public MovementLineMvoStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<MovementLineMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = movementLineMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (MovementLineMvoMetadata.aliasMap.containsKey(n) ? MovementLineMvoMetadata.aliasMap.get(n) : n)),
                        MovementLineMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = movementLineMvoApplicationService.get(
                        MovementLineMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        MovementLineMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            MovementLineMvoStateDto.DtoConverter dtoConverter = new MovementLineMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toMovementLineMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public MovementLineMvoStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            MovementLineId idObj = MovementLineMvoResourceUtils.parseIdString(id);
            MovementLineMvoState state = movementLineMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            MovementLineMvoStateDto.DtoConverter dtoConverter = new MovementLineMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toMovementLineMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = movementLineMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (MovementLineMvoMetadata.aliasMap.containsKey(n) ? MovementLineMvoMetadata.aliasMap.get(n) : n)));
            } else {
                count = movementLineMvoApplicationService.getCount(MovementLineMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchMovementLineMvoDto.CreateMovementLineMvoDto value) {
        try {

            MovementLineMvoCommand.CreateMovementLineMvo cmd = value.toCreateMovementLineMvo();
            MovementLineMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            movementLineMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchMovementLineMvoDto.MergePatchMovementLineMvoDto value) {
        try {

            MovementLineMvoCommand.MergePatchMovementLineMvo cmd = value.toMergePatchMovementLineMvo();
            MovementLineMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            movementLineMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @DELETE
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            MovementLineMvoCommand.DeleteMovementLineMvo deleteCmd = new AbstractMovementLineMvoCommand.SimpleDeleteMovementLineMvo();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setMovementVersion(version);
            MovementLineMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            movementLineMvoApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            MovementLineMvoMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public MovementLineMvoStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            MovementLineId idObj = MovementLineMvoResourceUtils.parseIdString(id);
            MovementLineMvoStateEventDtoConverter dtoConverter = getMovementLineMvoStateEventDtoConverter();
            return dtoConverter.toMovementLineMvoStateEventDto((AbstractMovementLineMvoStateEvent) movementLineMvoApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public MovementLineMvoStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            MovementLineId idObj = MovementLineMvoResourceUtils.parseIdString(id);
            MovementLineMvoStateDto.DtoConverter dtoConverter = new MovementLineMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toMovementLineMvoStateDto(movementLineMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  MovementLineMvoStateEventDtoConverter getMovementLineMvoStateEventDtoConverter() {
        return new MovementLineMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new MovementLineMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class MovementLineMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return MovementLineMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class MovementLineMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, MovementLineMvoCommand value) {
            MovementLineId idObj = parseIdString(id);
            if (value.getMovementLineId() == null) {
                value.setMovementLineId(idObj);
            } else if (!value.getMovementLineId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getMovementLineId());
            }
        }
    

        public static MovementLineId parseIdString(String idString) {
            TextFormatter<MovementLineId> formatter =
                    new AbstractValueObjectTextFormatter<MovementLineId>(MovementLineId.class) {
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
            if (MovementLineMvoMetadata.aliasMap.containsKey(fieldName)) {
                return MovementLineMvoMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (MovementLineMvoMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = MovementLineMvoMetadata.propertyTypeMap.get(propertyName);
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

        public static MovementLineMvoStateDto[] toMovementLineMvoStateDtoArray(Iterable<MovementLineId> ids) {
            List<MovementLineMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                MovementLineMvoStateDto dto = new MovementLineMvoStateDto();
                dto.setMovementLineId(id);
                states.add(dto);
            });
            return states.toArray(new MovementLineMvoStateDto[0]);
        }

    }

}

