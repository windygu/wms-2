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
import org.dddml.wms.domain.organizationstructure.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("OrganizationStructures") @Produces(MediaType.APPLICATION_JSON)
public class OrganizationStructureResource {


    @Autowired
    private OrganizationStructureApplicationService organizationStructureApplicationService;


    @GET
    public OrganizationStructureStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<OrganizationStructureState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = organizationStructureApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (OrganizationStructureFilteringProperties.aliasMap.containsKey(n) ? OrganizationStructureFilteringProperties.aliasMap.get(n) : n)),
                        OrganizationStructureResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = organizationStructureApplicationService.get(
                        OrganizationStructureResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        OrganizationStructureResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            OrganizationStructureStateDto.DtoConverter dtoConverter = new OrganizationStructureStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrganizationStructureStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public OrganizationStructureStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            OrganizationStructureId idObj = OrganizationStructureResourceUtils.parseIdString(id);
            OrganizationStructureState state = organizationStructureApplicationService.get(idObj);
            if (state == null) { return null; }

            OrganizationStructureStateDto.DtoConverter dtoConverter = new OrganizationStructureStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrganizationStructureStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = organizationStructureApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (OrganizationStructureFilteringProperties.aliasMap.containsKey(n) ? OrganizationStructureFilteringProperties.aliasMap.get(n) : n)));
            } else {
                count = organizationStructureApplicationService.getCount(OrganizationStructureResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchOrganizationStructureDto.CreateOrganizationStructureDto value) {
        try {

            OrganizationStructureCommand.CreateOrganizationStructure cmd = value.toCreateOrganizationStructure();
            OrganizationStructureResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            organizationStructureApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchOrganizationStructureDto.MergePatchOrganizationStructureDto value) {
        try {

            OrganizationStructureCommand.MergePatchOrganizationStructure cmd = value.toMergePatchOrganizationStructure();
            OrganizationStructureResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            organizationStructureApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @DELETE
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            OrganizationStructureCommand.DeleteOrganizationStructure deleteCmd = new AbstractOrganizationStructureCommand.SimpleDeleteOrganizationStructure();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            OrganizationStructureResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            organizationStructureApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            OrganizationStructureFilteringProperties.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public OrganizationStructureStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            OrganizationStructureId idObj = OrganizationStructureResourceUtils.parseIdString(id);
            OrganizationStructureStateEventDtoConverter dtoConverter = getOrganizationStructureStateEventDtoConverter();
            return dtoConverter.toOrganizationStructureStateEventDto((AbstractOrganizationStructureStateEvent) organizationStructureApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public OrganizationStructureStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            OrganizationStructureId idObj = OrganizationStructureResourceUtils.parseIdString(id);
            OrganizationStructureStateDto.DtoConverter dtoConverter = new OrganizationStructureStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrganizationStructureStateDto(organizationStructureApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  OrganizationStructureStateEventDtoConverter getOrganizationStructureStateEventDtoConverter() {
        return new OrganizationStructureStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new OrganizationStructurePropertyTypeResolver();
    }

    // ////////////////////////////////

    private class OrganizationStructurePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return OrganizationStructureResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class OrganizationStructureResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, OrganizationStructureCommand value) {
            OrganizationStructureId idObj = parseIdString(id);
            if (value.getId() == null) {
                value.setId(idObj);
            } else if (!value.getId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getId());
            }
        }
    

        public static OrganizationStructureId parseIdString(String idString) {
            TextFormatter<OrganizationStructureId> formatter =
                    new AbstractValueObjectTextFormatter<OrganizationStructureId>(OrganizationStructureId.class) {
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
            if (OrganizationStructureFilteringProperties.aliasMap.containsKey(fieldName)) {
                return OrganizationStructureFilteringProperties.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (OrganizationStructureFilteringProperties.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = OrganizationStructureFilteringProperties.propertyTypeMap.get(propertyName);
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

        public static OrganizationStructureStateDto[] toOrganizationStructureStateDtoArray(Iterable<OrganizationStructureId> ids) {
            List<OrganizationStructureStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                OrganizationStructureStateDto dto = new OrganizationStructureStateDto();
                dto.setId(id);
                states.add(dto);
            });
            return states.toArray(new OrganizationStructureStateDto[0]);
        }

    }

}

