package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.apache.cxf.jaxrs.ext.PATCH;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.physicalinventory.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.physicalinventorylinemvo.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("PhysicalInventoryLineMvos") @Produces(MediaType.APPLICATION_JSON)
public class PhysicalInventoryLineMvoResource {


    @Autowired
    private PhysicalInventoryLineMvoApplicationService physicalInventoryLineMvoApplicationService;


    @GET
    public PhysicalInventoryLineMvoStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<PhysicalInventoryLineMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = physicalInventoryLineMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (PhysicalInventoryLineMvoMetadata.aliasMap.containsKey(n) ? PhysicalInventoryLineMvoMetadata.aliasMap.get(n) : n)),
                        PhysicalInventoryLineMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = physicalInventoryLineMvoApplicationService.get(
                        PhysicalInventoryLineMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        PhysicalInventoryLineMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            PhysicalInventoryLineMvoStateDto.DtoConverter dtoConverter = new PhysicalInventoryLineMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPhysicalInventoryLineMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public PhysicalInventoryLineMvoStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            PhysicalInventoryLineId idObj = PhysicalInventoryLineMvoResourceUtils.parseIdString(id);
            PhysicalInventoryLineMvoState state = physicalInventoryLineMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            PhysicalInventoryLineMvoStateDto.DtoConverter dtoConverter = new PhysicalInventoryLineMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPhysicalInventoryLineMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = physicalInventoryLineMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (PhysicalInventoryLineMvoMetadata.aliasMap.containsKey(n) ? PhysicalInventoryLineMvoMetadata.aliasMap.get(n) : n)));
            } else {
                count = physicalInventoryLineMvoApplicationService.getCount(PhysicalInventoryLineMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @POST
    public PhysicalInventoryLineId post(CreateOrMergePatchPhysicalInventoryLineMvoDto.CreatePhysicalInventoryLineMvoDto value, @Context HttpServletResponse response) {
        try {
            PhysicalInventoryLineMvoCommand.CreatePhysicalInventoryLineMvo cmd = value.toCreatePhysicalInventoryLineMvo();
            if (cmd.getPhysicalInventoryLineId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "PhysicalInventoryLineMvo");
            }
            physicalInventoryLineMvoApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getPhysicalInventoryLineId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchPhysicalInventoryLineMvoDto value) {
        try {
            if (value.getPhysicalInventoryVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                PhysicalInventoryLineMvoCommand.MergePatchPhysicalInventoryLineMvo cmd = (PhysicalInventoryLineMvoCommand.MergePatchPhysicalInventoryLineMvo) value.toCommand();
                PhysicalInventoryLineMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                physicalInventoryLineMvoApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            PhysicalInventoryLineMvoCommand.CreatePhysicalInventoryLineMvo cmd = (PhysicalInventoryLineMvoCommand.CreatePhysicalInventoryLineMvo) value.toCommand();
            PhysicalInventoryLineMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            physicalInventoryLineMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchPhysicalInventoryLineMvoDto.MergePatchPhysicalInventoryLineMvoDto value) {
        try {

            PhysicalInventoryLineMvoCommand.MergePatchPhysicalInventoryLineMvo cmd = value.toMergePatchPhysicalInventoryLineMvo();
            PhysicalInventoryLineMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            physicalInventoryLineMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @DELETE
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            PhysicalInventoryLineMvoCommand.DeletePhysicalInventoryLineMvo deleteCmd = new AbstractPhysicalInventoryLineMvoCommand.SimpleDeletePhysicalInventoryLineMvo();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setPhysicalInventoryVersion(version);
            PhysicalInventoryLineMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            physicalInventoryLineMvoApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            PhysicalInventoryLineMvoMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public PhysicalInventoryLineMvoStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            PhysicalInventoryLineId idObj = PhysicalInventoryLineMvoResourceUtils.parseIdString(id);
            PhysicalInventoryLineMvoStateEventDtoConverter dtoConverter = getPhysicalInventoryLineMvoStateEventDtoConverter();
            return dtoConverter.toPhysicalInventoryLineMvoStateEventDto((AbstractPhysicalInventoryLineMvoStateEvent) physicalInventoryLineMvoApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public PhysicalInventoryLineMvoStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            PhysicalInventoryLineId idObj = PhysicalInventoryLineMvoResourceUtils.parseIdString(id);
            PhysicalInventoryLineMvoStateDto.DtoConverter dtoConverter = new PhysicalInventoryLineMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPhysicalInventoryLineMvoStateDto(physicalInventoryLineMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  PhysicalInventoryLineMvoStateEventDtoConverter getPhysicalInventoryLineMvoStateEventDtoConverter() {
        return new PhysicalInventoryLineMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PhysicalInventoryLineMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class PhysicalInventoryLineMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return PhysicalInventoryLineMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class PhysicalInventoryLineMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, PhysicalInventoryLineMvoCommand value) {
            PhysicalInventoryLineId idObj = parseIdString(id);
            if (value.getPhysicalInventoryLineId() == null) {
                value.setPhysicalInventoryLineId(idObj);
            } else if (!value.getPhysicalInventoryLineId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getPhysicalInventoryLineId());
            }
        }
    

        public static PhysicalInventoryLineId parseIdString(String idString) {
            TextFormatter<PhysicalInventoryLineId> formatter =
                    new AbstractValueObjectTextFormatter<PhysicalInventoryLineId>(PhysicalInventoryLineId.class) {
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
            if (PhysicalInventoryLineMvoMetadata.aliasMap.containsKey(fieldName)) {
                return PhysicalInventoryLineMvoMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (PhysicalInventoryLineMvoMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = PhysicalInventoryLineMvoMetadata.propertyTypeMap.get(propertyName);
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

        public static PhysicalInventoryLineMvoStateDto[] toPhysicalInventoryLineMvoStateDtoArray(Iterable<PhysicalInventoryLineId> ids) {
            List<PhysicalInventoryLineMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                PhysicalInventoryLineMvoStateDto dto = new PhysicalInventoryLineMvoStateDto();
                dto.setPhysicalInventoryLineId(id);
                states.add(dto);
            });
            return states.toArray(new PhysicalInventoryLineMvoStateDto[0]);
        }

    }

}

