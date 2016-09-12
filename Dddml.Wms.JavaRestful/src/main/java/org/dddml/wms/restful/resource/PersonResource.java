package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
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
import org.dddml.support.criterion.TypeConverter;

@Path("People")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {


    @Autowired
    private PersonApplicationService personApplicationService;


    @GET
    public PersonStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<PersonState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = personApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver()),
                        PersonResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = personApplicationService.get(
                        PersonResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        PersonResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            PersonStateDto.DtoConverter dtoConverter = new PersonStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPersonStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GET
    @Path("{id}")
    public PersonStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            PersonalName idObj = PersonResourceUtils.parseIdString(id);
            PersonState state = personApplicationService.get(idObj);
            if (state == null) { return null; }

            PersonStateDto.DtoConverter dtoConverter = new PersonStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPersonStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count")
    @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = personApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver()));
            } else {
                count = personApplicationService.getCount(PersonResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PUT
    @Path("/{id}")
    public void put(@PathParam("id") String id, CreateOrMergePatchPersonDto.CreatePersonDto value) {
        try {

            PersonCommand.CreatePerson cmd = value.toCreatePerson();
            PersonResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            personApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PATCH
    @Path("/{id}")
    public void patch(@PathParam("id") String id, CreateOrMergePatchPersonDto.MergePatchPersonDto value) {
        try {

            PersonCommand.MergePatchPerson cmd = value.toMergePatchPerson();
            PersonResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            personApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            PersonCommand.DeletePerson deleteCmd = new AbstractPersonCommand.SimpleDeletePerson();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            PersonResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            personApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields")
    @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            PersonFilteringProperties.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}")
    @GET
    public PersonStateEvent getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            PersonalName idObj = PersonResourceUtils.parseIdString(id);
            return personApplicationService.getStateEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{personalName}/YearPlans/{year}")
    @GET
    public YearPlanStateDto getYearPlan(@PathParam("personalName") String personalName, @PathParam("year") Integer year) {
        try {

            YearPlanState state = personApplicationService.getYearPlan((new PersonalNameFlattenedDtoFormatter().parse(personalName)).toPersonalName(), year);
            if (state == null) { return null; }
            YearPlanStateDto.DtoConverter dtoConverter = new YearPlanStateDto.DtoConverter();
            YearPlanStateDto stateDto = dtoConverter.toYearPlanStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{personalName}/YearPlans/{year}/MonthPlans/{month}")
    @GET
    public MonthPlanStateDto getMonthPlan(@PathParam("personalName") String personalName, @PathParam("year") Integer year, @PathParam("month") Integer month) {
        try {

            MonthPlanState state = personApplicationService.getMonthPlan((new PersonalNameFlattenedDtoFormatter().parse(personalName)).toPersonalName(), year, month);
            if (state == null) { return null; }
            MonthPlanStateDto.DtoConverter dtoConverter = new MonthPlanStateDto.DtoConverter();
            MonthPlanStateDto stateDto = dtoConverter.toMonthPlanStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{personalName}/YearPlans/{year}/MonthPlans/{month}/DayPlans/{day}")
    @GET
    public DayPlanStateDto getDayPlan(@PathParam("personalName") String personalName, @PathParam("year") Integer year, @PathParam("month") Integer month, @PathParam("day") Integer day) {
        try {

            DayPlanState state = personApplicationService.getDayPlan((new PersonalNameFlattenedDtoFormatter().parse(personalName)).toPersonalName(), year, month, day);
            if (state == null) { return null; }
            DayPlanStateDto.DtoConverter dtoConverter = new DayPlanStateDto.DtoConverter();
            DayPlanStateDto stateDto = dtoConverter.toDayPlanStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PersonPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class PersonPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return PersonResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class PersonResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, PersonCommand value) {
            PersonalName idObj = parseIdString(id);
            if (value.getPersonalName() == null) {
                value.setPersonalName(idObj);
            } else if (!value.getPersonalName().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getPersonalName());
            }
        }
    

        public static PersonalName parseIdString(String idString) {
            PersonalNameFlattenedDtoFormatter formatter = new PersonalNameFlattenedDtoFormatter();
            PersonalNameFlattenedDto idDto = formatter.parse(idString);
            return idDto.toPersonalName();
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (PersonFilteringProperties.propertyTypeMap.containsKey(fieldName)) {
/* TODO...
                var p = PersonMetadata.Instance.PropertyMetadataDictionary[fieldName];
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
            if (PersonFilteringProperties.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = PersonFilteringProperties.propertyTypeMap.get(propertyName);
                if (!StringHelper.isNullOrEmpty(propertyType)) {
                    if (ReflectUtils.CLASS_MAP.containsKey(propertyType)) {
                        return ReflectUtils.CLASS_MAP.get(propertyType);
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

        public static PersonStateDto[] toPersonStateDtoArray(Iterable<PersonalName> ids) {
            List<PersonStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                PersonStateDto dto = new PersonStateDto();
                dto.setPersonalName(id);
                states.add(dto);
            });
            return states.toArray(new PersonStateDto[0]);
        }

    }

}

