package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.apache.cxf.jaxrs.ext.PATCH;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.wms.restful.exception.WebApiApplicationException;
import org.dddml.support.criterion.TypeConvert;

@Path("DayPlanMvos")
@Produces(MediaType.APPLICATION_JSON)
public class DayPlanMvoResource {


    @Autowired
    private DayPlanMvoApplicationService dayPlanMvoApplicationService;


    @GET
    public DayPlanMvoStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<DayPlanMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = dayPlanMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver()),
                        DayPlanMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = dayPlanMvoApplicationService.get(
                        DayPlanMvoResourceUtils.getQueryFilterDictionary(request.getParameterMap()),
                        DayPlanMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            DayPlanMvoStateDto.DtoConverter dtoConverter = new DayPlanMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toDayPlanMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new WebApiApplicationException(ex); }
    }

    @GET
    @Path("{id}")
    public DayPlanMvoStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            DayPlanId idObj = DayPlanMvoResourceUtils.parseIdString(id);
            DayPlanMvoState state = dayPlanMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            DayPlanMvoStateDto.DtoConverter dtoConverter = new DayPlanMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toDayPlanMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new WebApiApplicationException(ex); }
    }

    @Path("_count")
    @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = dayPlanMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver()));
            } else {
                count = dayPlanMvoApplicationService.getCount(DayPlanMvoResourceUtils.getQueryFilterDictionary(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new WebApiApplicationException(ex); }
    }


    @PUT
    @Path("/{id}")
    public void put(@PathParam("id") String id, CreateOrMergePatchDayPlanMvoDto.CreateDayPlanMvoDto value) {
        try {

            DayPlanMvoCommand.CreateDayPlanMvo cmd = value.toCreateDayPlanMvo();
            DayPlanMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            dayPlanMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new WebApiApplicationException(ex); }
    }


    @PATCH
    @Path("/{id}")
    public void patch(@PathParam("id") String id, CreateOrMergePatchDayPlanMvoDto.MergePatchDayPlanMvoDto value) {
        try {

            DayPlanMvoCommand.MergePatchDayPlanMvo cmd = value.toMergePatchDayPlanMvo();
            DayPlanMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            dayPlanMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new WebApiApplicationException(ex); }
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            DayPlanMvoCommand.DeleteDayPlanMvo deleteCmd = new AbstractDayPlanMvoCommand.SimpleDeleteDayPlanMvo();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setPersonVersion(version);
            DayPlanMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            dayPlanMvoApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new WebApiApplicationException(ex); }
    }

    @Path("_metadata/filteringFields")
    @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            DayPlanMvoFilteringProperties.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new WebApiApplicationException(ex); }
    }

    @Path("{id}/_stateEvents/{version}")
    @GET
    public DayPlanMvoStateEvent getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            DayPlanId idObj = DayPlanMvoResourceUtils.parseIdString(id);
            return dayPlanMvoApplicationService.getStateEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new WebApiApplicationException(ex); }
    }


    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new DayPlanMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class DayPlanMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return DayPlanMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class DayPlanMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, DayPlanMvoCommand value) {
            DayPlanId idObj = parseIdString(id);
            if (value.getDayPlanId() == null) {
                value.setDayPlanId(idObj);
            } else if (!value.getDayPlanId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getDayPlanId());
            }
        }
    

        public static DayPlanId parseIdString(String idString) {
            DayPlanIdFlattenedDtoFormatter formatter = new DayPlanIdFlattenedDtoFormatter();
            DayPlanIdFlattenedDto idDto = formatter.parse(idString);
            return idDto.toDayPlanId();
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (DayPlanMvoFilteringProperties.propertyTypeMap.containsKey(fieldName)) {
/* TODO...
                var p = DayPlanMvoMetadata.Instance.PropertyMetadataDictionary[fieldName];
                if (p.IsFilteringProperty)
                {
                    var propertyName = fieldName;
                    if (p.IsDerived)
                    {
                        propertyName = p.DerivedFrom;
                    }
                    return propertyName;
                }
*/
                return fieldName;
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (DayPlanMvoFilteringProperties.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = DayPlanMvoFilteringProperties.propertyTypeMap.get(propertyName);
                if (!StringHelper.isNullOrEmpty(propertyType)) {
                    if (ReflectUtils.CLASS_MAP.containsKey(propertyType)) {
                        return ReflectUtils.CLASS_MAP.get(propertyType);
                    }
                }
            }
            return String.class;
        }

        public static Iterable<Map.Entry<String, Object>> getQueryFilterDictionary(Map<String, String[]> queryNameValuePairs) {
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

    }

}

