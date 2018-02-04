package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.apache.cxf.jaxrs.ext.PATCH;

import org.dddml.support.criterion.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.physicalinventory.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("PhysicalInventories") @Produces(MediaType.APPLICATION_JSON)
public class PhysicalInventoryResource {


    @Autowired
    private PhysicalInventoryApplicationService physicalInventoryApplicationService;


    @GET
    public PhysicalInventoryStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<PhysicalInventoryState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = physicalInventoryApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (PhysicalInventoryFilteringProperties.aliasMap.containsKey(n) ? PhysicalInventoryFilteringProperties.aliasMap.get(n) : n)),
                        PhysicalInventoryResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = physicalInventoryApplicationService.get(
                        PhysicalInventoryResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        PhysicalInventoryResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            PhysicalInventoryStateDto.DtoConverter dtoConverter = new PhysicalInventoryStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPhysicalInventoryStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public PhysicalInventoryStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            String idObj = id;
            PhysicalInventoryState state = physicalInventoryApplicationService.get(idObj);
            if (state == null) { return null; }

            PhysicalInventoryStateDto.DtoConverter dtoConverter = new PhysicalInventoryStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPhysicalInventoryStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = physicalInventoryApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (PhysicalInventoryFilteringProperties.aliasMap.containsKey(n) ? PhysicalInventoryFilteringProperties.aliasMap.get(n) : n)));
            } else {
                count = physicalInventoryApplicationService.getCount(PhysicalInventoryResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchPhysicalInventoryDto.CreatePhysicalInventoryDto value) {
        try {

            PhysicalInventoryCommand.CreatePhysicalInventory cmd = value.toCreatePhysicalInventory();
            PhysicalInventoryResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            physicalInventoryApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchPhysicalInventoryDto.MergePatchPhysicalInventoryDto value) {
        try {

            PhysicalInventoryCommand.MergePatchPhysicalInventory cmd = value.toMergePatchPhysicalInventory();
            PhysicalInventoryResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            physicalInventoryApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @DELETE
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            PhysicalInventoryCommand.DeletePhysicalInventory deleteCmd = new AbstractPhysicalInventoryCommand.SimpleDeletePhysicalInventory();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            PhysicalInventoryResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            physicalInventoryApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}/_commands/DocumentAction") @PUT
    public void documentAction(@PathParam("id") String id, PhysicalInventoryCommandDtos.DocumentActionRequestContent content) {
        try {

            PhysicalInventoryCommands.DocumentAction cmd = content.toDocumentAction();
            String idObj = id;
            if (cmd.getDocumentNumber() == null) {
                cmd.setDocumentNumber(idObj);
            } else if (!cmd.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, cmd.getDocumentNumber());
            }
            physicalInventoryApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            PhysicalInventoryFilteringProperties.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public PhysicalInventoryStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            String idObj = id;
            PhysicalInventoryStateEventDtoConverter dtoConverter = getPhysicalInventoryStateEventDtoConverter();
            return dtoConverter.toPhysicalInventoryStateEventDto((AbstractPhysicalInventoryStateEvent) physicalInventoryApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public PhysicalInventoryStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            String idObj = id;
            PhysicalInventoryStateDto.DtoConverter dtoConverter = new PhysicalInventoryStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPhysicalInventoryStateDto(physicalInventoryApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{physicalInventoryDocumentNumber}/PhysicalInventoryLines/{lineNumber}") @GET
    public PhysicalInventoryLineStateDto getPhysicalInventoryLine(@PathParam("physicalInventoryDocumentNumber") String physicalInventoryDocumentNumber, @PathParam("lineNumber") String lineNumber) {
        try {

            PhysicalInventoryLineState state = physicalInventoryApplicationService.getPhysicalInventoryLine(physicalInventoryDocumentNumber, lineNumber);
            if (state == null) { return null; }
            PhysicalInventoryLineStateDto.DtoConverter dtoConverter = new PhysicalInventoryLineStateDto.DtoConverter();
            PhysicalInventoryLineStateDto stateDto = dtoConverter.toPhysicalInventoryLineStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  PhysicalInventoryStateEventDtoConverter getPhysicalInventoryStateEventDtoConverter() {
        return new PhysicalInventoryStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PhysicalInventoryPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class PhysicalInventoryPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return PhysicalInventoryResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class PhysicalInventoryResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, PhysicalInventoryCommand value) {
            String idObj = id;
            if (value.getDocumentNumber() == null) {
                value.setDocumentNumber(idObj);
            } else if (!value.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getDocumentNumber());
            }
        }
    


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (PhysicalInventoryFilteringProperties.aliasMap.containsKey(fieldName)) {
                return PhysicalInventoryFilteringProperties.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (PhysicalInventoryFilteringProperties.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = PhysicalInventoryFilteringProperties.propertyTypeMap.get(propertyName);
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

        public static PhysicalInventoryStateDto[] toPhysicalInventoryStateDtoArray(Iterable<String> ids) {
            List<PhysicalInventoryStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                PhysicalInventoryStateDto dto = new PhysicalInventoryStateDto();
                dto.setDocumentNumber(id);
                states.add(dto);
            });
            return states.toArray(new PhysicalInventoryStateDto[0]);
        }

    }

}

