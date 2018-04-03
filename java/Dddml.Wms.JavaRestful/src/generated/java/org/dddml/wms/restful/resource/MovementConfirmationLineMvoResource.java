package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.apache.cxf.jaxrs.ext.PATCH;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.movementconfirmation.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.movementconfirmationlinemvo.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("MovementConfirmationLineMvos") @Produces(MediaType.APPLICATION_JSON)
public class MovementConfirmationLineMvoResource {


    @Autowired
    private MovementConfirmationLineMvoApplicationService movementConfirmationLineMvoApplicationService;


    @GET
    public MovementConfirmationLineMvoStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<MovementConfirmationLineMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = movementConfirmationLineMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (MovementConfirmationLineMvoMetadata.aliasMap.containsKey(n) ? MovementConfirmationLineMvoMetadata.aliasMap.get(n) : n)),
                        MovementConfirmationLineMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = movementConfirmationLineMvoApplicationService.get(
                        MovementConfirmationLineMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        MovementConfirmationLineMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            MovementConfirmationLineMvoStateDto.DtoConverter dtoConverter = new MovementConfirmationLineMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toMovementConfirmationLineMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public MovementConfirmationLineMvoStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            MovementConfirmationLineId idObj = MovementConfirmationLineMvoResourceUtils.parseIdString(id);
            MovementConfirmationLineMvoState state = movementConfirmationLineMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            MovementConfirmationLineMvoStateDto.DtoConverter dtoConverter = new MovementConfirmationLineMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toMovementConfirmationLineMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = movementConfirmationLineMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (MovementConfirmationLineMvoMetadata.aliasMap.containsKey(n) ? MovementConfirmationLineMvoMetadata.aliasMap.get(n) : n)));
            } else {
                count = movementConfirmationLineMvoApplicationService.getCount(MovementConfirmationLineMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @POST
    public MovementConfirmationLineId post(CreateOrMergePatchMovementConfirmationLineMvoDto.CreateMovementConfirmationLineMvoDto value, @Context HttpServletResponse response) {
        try {
            MovementConfirmationLineMvoCommand.CreateMovementConfirmationLineMvo cmd = value.toCreateMovementConfirmationLineMvo();
            if (cmd.getMovementConfirmationLineId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "MovementConfirmationLineMvo");
            }
            movementConfirmationLineMvoApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getMovementConfirmationLineId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchMovementConfirmationLineMvoDto value) {
        try {
            if (value.getMovementConfirmationVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                MovementConfirmationLineMvoCommand.MergePatchMovementConfirmationLineMvo cmd = (MovementConfirmationLineMvoCommand.MergePatchMovementConfirmationLineMvo) value.toCommand();
                MovementConfirmationLineMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                movementConfirmationLineMvoApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            MovementConfirmationLineMvoCommand.CreateMovementConfirmationLineMvo cmd = (MovementConfirmationLineMvoCommand.CreateMovementConfirmationLineMvo) value.toCommand();
            MovementConfirmationLineMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            movementConfirmationLineMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchMovementConfirmationLineMvoDto.MergePatchMovementConfirmationLineMvoDto value) {
        try {

            MovementConfirmationLineMvoCommand.MergePatchMovementConfirmationLineMvo cmd = value.toMergePatchMovementConfirmationLineMvo();
            MovementConfirmationLineMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            movementConfirmationLineMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @DELETE
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            MovementConfirmationLineMvoCommand.DeleteMovementConfirmationLineMvo deleteCmd = new AbstractMovementConfirmationLineMvoCommand.SimpleDeleteMovementConfirmationLineMvo();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setMovementConfirmationVersion(version);
            MovementConfirmationLineMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            movementConfirmationLineMvoApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            MovementConfirmationLineMvoMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public MovementConfirmationLineMvoStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            MovementConfirmationLineId idObj = MovementConfirmationLineMvoResourceUtils.parseIdString(id);
            MovementConfirmationLineMvoStateEventDtoConverter dtoConverter = getMovementConfirmationLineMvoStateEventDtoConverter();
            return dtoConverter.toMovementConfirmationLineMvoStateEventDto((AbstractMovementConfirmationLineMvoStateEvent) movementConfirmationLineMvoApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public MovementConfirmationLineMvoStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            MovementConfirmationLineId idObj = MovementConfirmationLineMvoResourceUtils.parseIdString(id);
            MovementConfirmationLineMvoStateDto.DtoConverter dtoConverter = new MovementConfirmationLineMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toMovementConfirmationLineMvoStateDto(movementConfirmationLineMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  MovementConfirmationLineMvoStateEventDtoConverter getMovementConfirmationLineMvoStateEventDtoConverter() {
        return new MovementConfirmationLineMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new MovementConfirmationLineMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class MovementConfirmationLineMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return MovementConfirmationLineMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class MovementConfirmationLineMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, MovementConfirmationLineMvoCommand value) {
            MovementConfirmationLineId idObj = parseIdString(id);
            if (value.getMovementConfirmationLineId() == null) {
                value.setMovementConfirmationLineId(idObj);
            } else if (!value.getMovementConfirmationLineId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getMovementConfirmationLineId());
            }
        }
    

        public static MovementConfirmationLineId parseIdString(String idString) {
            TextFormatter<MovementConfirmationLineId> formatter =
                    new AbstractValueObjectTextFormatter<MovementConfirmationLineId>(MovementConfirmationLineId.class) {
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
            if (MovementConfirmationLineMvoMetadata.aliasMap.containsKey(fieldName)) {
                return MovementConfirmationLineMvoMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (MovementConfirmationLineMvoMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = MovementConfirmationLineMvoMetadata.propertyTypeMap.get(propertyName);
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

        public static MovementConfirmationLineMvoStateDto[] toMovementConfirmationLineMvoStateDtoArray(Iterable<MovementConfirmationLineId> ids) {
            List<MovementConfirmationLineMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                MovementConfirmationLineMvoStateDto dto = new MovementConfirmationLineMvoStateDto();
                dto.setMovementConfirmationLineId(id);
                states.add(dto);
            });
            return states.toArray(new MovementConfirmationLineMvoStateDto[0]);
        }

    }

}

