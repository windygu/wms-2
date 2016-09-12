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
import org.dddml.support.criterion.TypeConverter;

@Path("MonthPlanMvos")
@Produces(MediaType.APPLICATION_JSON)
public class MonthPlanMvoResource {


    @Autowired
    private MonthPlanMvoApplicationService monthPlanMvoApplicationService;


    @GET
    public MonthPlanMvoStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<MonthPlanMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = monthPlanMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver()),
                        MonthPlanMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = monthPlanMvoApplicationService.get(
                        MonthPlanMvoResourceUtils.getQueryFilterDictionary(request.getParameterMap()),
                        MonthPlanMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            MonthPlanMvoStateDto.DtoConverter dtoConverter = new MonthPlanMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toMonthPlanMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new WebApiApplicationException(ex); }
    }

    @GET
    @Path("{id}")
    public MonthPlanMvoStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            MonthPlanId idObj = MonthPlanMvoResourceUtils.parseIdString(id);
            MonthPlanMvoState state = monthPlanMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            MonthPlanMvoStateDto.DtoConverter dtoConverter = new MonthPlanMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toMonthPlanMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new WebApiApplicationException(ex); }
    }

    @Path("_count")
    @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = monthPlanMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver()));
            } else {
                count = monthPlanMvoApplicationService.getCount(MonthPlanMvoResourceUtils.getQueryFilterDictionary(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new WebApiApplicationException(ex); }
    }


    @PUT
    @Path("/{id}")
    public void put(@PathParam("id") String id, CreateOrMergePatchMonthPlanMvoDto.CreateMonthPlanMvoDto value) {
        try {

            MonthPlanMvoCommand.CreateMonthPlanMvo cmd = value.toCreateMonthPlanMvo();
            MonthPlanMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            monthPlanMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new WebApiApplicationException(ex); }
    }


    @PATCH
    @Path("/{id}")
    public void patch(@PathParam("id") String id, CreateOrMergePatchMonthPlanMvoDto.MergePatchMonthPlanMvoDto value) {
        try {

            MonthPlanMvoCommand.MergePatchMonthPlanMvo cmd = value.toMergePatchMonthPlanMvo();
            MonthPlanMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            monthPlanMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new WebApiApplicationException(ex); }
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            MonthPlanMvoCommand.DeleteMonthPlanMvo deleteCmd = new AbstractMonthPlanMvoCommand.SimpleDeleteMonthPlanMvo();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setPersonVersion(version);
            MonthPlanMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            monthPlanMvoApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new WebApiApplicationException(ex); }
    }

    @Path("_metadata/filteringFields")
    @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            MonthPlanMvoFilteringProperties.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new WebApiApplicationException(ex); }
    }

    @Path("{id}/_stateEvents/{version}")
    @GET
    public MonthPlanMvoStateEvent getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            MonthPlanId idObj = MonthPlanMvoResourceUtils.parseIdString(id);
            return monthPlanMvoApplicationService.getStateEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new WebApiApplicationException(ex); }
    }


    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new MonthPlanMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class MonthPlanMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return MonthPlanMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class MonthPlanMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, MonthPlanMvoCommand value) {
            MonthPlanId idObj = parseIdString(id);
            if (value.getMonthPlanId() == null) {
                value.setMonthPlanId(idObj);
            } else if (!value.getMonthPlanId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getMonthPlanId());
            }
        }
    

        public static MonthPlanId parseIdString(String idString) {
            MonthPlanIdFlattenedDtoFormatter formatter = new MonthPlanIdFlattenedDtoFormatter();
            MonthPlanIdFlattenedDto idDto = formatter.parse(idString);
            return idDto.toMonthPlanId();
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (MonthPlanMvoFilteringProperties.propertyTypeMap.containsKey(fieldName)) {
/* TODO...
                var p = MonthPlanMvoMetadata.Instance.PropertyMetadataDictionary[fieldName];
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
            if (MonthPlanMvoFilteringProperties.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = MonthPlanMvoFilteringProperties.propertyTypeMap.get(propertyName);
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

