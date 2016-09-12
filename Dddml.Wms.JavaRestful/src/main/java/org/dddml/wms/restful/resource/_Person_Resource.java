package org.dddml.wms.restful.resource;

import com.alibaba.fastjson.JSON;
import org.apache.cxf.jaxrs.ext.PATCH;
import org.dddml.support.criterion.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.meta.PersonFilteringProperties;
import org.dddml.wms.restful.exception.WebApiApplicationException;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.DomainError;
import org.dddml.wms.specialization.PropertyMetadataDto;
import org.dddml.wms.specialization.ReflectUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Li Yongchun on 2016/9/3.
 */
@Path("people")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Autowired
    private PersonApplicationService personApplicationService;

    /**
     * 根据指定条件查询人
     *
     * @param sort        排序
     * @param fields      返回字段
     * @param firstResult 第一行
     * @param maxResults  查询数量
     * @param filter      过滤条件
     * @return Person列表
     */
    @GET
    public PersonStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   /*@DefaultValue(String.valueOf(Integer.MAX_VALUE))*/
                                   @QueryParam("maxResults") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }

        try {
            Iterable<PersonState> states = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = personApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionDefaultTypeConvert(),
                                new PeoplePropertyTypeResolver()),
                        PeopleApiUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult,
                        maxResults);
            } else {
                states = personApplicationService.get(
                        PeopleApiUtils.getQueryFilterDictionary(request.getParameterMap()),
                        PeopleApiUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult,
                        maxResults);
            }
            PersonStateDto.DtoConverter dtoConverter = new PersonStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPersonStateDtoArray(states);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new WebApiApplicationException(ex); }
    }


    /**
     * 获取某个人的详细信息
     *
     * @param id
     * @param fields
     * @return
     */
    @GET
    @Path("/{id}")
    public PersonStateDto Get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            PersonalName personalName = PeopleApiUtils.parseIdString(id);
            PersonState personState = personApplicationService.get(personalName);
            if (personState == null) {
                return null;
            }
            PersonStateDto.DtoConverter dtoConverter = new PersonStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPersonStateDto(personState);
        } catch (DomainError error) {
            throw error;
        } catch (Exception ex) {
            throw new WebApplicationException(ex);
        }
    }

    /**
     * 获取符合条件的人的数量
     *
     * @param request
     * @param filter  过滤条件
     * @return
     */
    @GET
    @Path("/_count")
    public long GetCount(@Context HttpServletRequest request, @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = personApplicationService.getCount(CriterionDto.toSubclass(JSON.parseObject(filter, CriterionDto.class),
                        getCriterionDefaultTypeConvert(), new PeoplePropertyTypeResolver()));
            } else {
                count = personApplicationService.getCount(PeopleApiUtils.getQueryFilterDictionary(request.getParameterMap()));
            }
            return count;
        } catch (DomainError error) {
            throw error;
        } catch (Exception ex) {
            throw new WebApplicationException(ex);
        }
    }


    /**
     * 创建
     *
     * @param id    唯一标识
     * @param value
     */
    @PUT
    @Path("/{id}")
    public void Put(@PathParam("id") String id, CreateOrMergePatchPersonDto.CreatePersonDto value) {
        try {
            PeopleApiUtils.setNullIdOrThrowOnInconsistentIds(id, value);
            personApplicationService.when(value.toCreatePerson());
        } catch (DomainError error) {
            throw error;
        } catch (Exception ex) {
            throw new WebApiApplicationException(ex);
        }
    }

    /**
     * 修改
     *
     * @param id  唯一标识
     * @param dto
     */
    @PATCH
    @Path("/{id}")
    public void Put(@PathParam("id") String id, CreateOrMergePatchPersonDto.MergePatchPersonDto dto) {
        try {
            PeopleApiUtils.setNullIdOrThrowOnInconsistentIds(id, dto);
            personApplicationService.when(dto.toMergePatchPerson());
        } catch (DomainError error) {
            throw error;
        } catch (Exception ex) {
            throw new WebApiApplicationException(ex);
        }
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id,
                       @NotNull(message = "commandId can't be null") @QueryParam("commandId") String commandId,
                       @NotNull(message = "version can't be null") @QueryParam("version") @Min(value = -1, message = "version error") Long version,
                       @QueryParam("requestId") String requestId) {
        try {
            DeletePersonDto deletePersonDto = new DeletePersonDto();
            deletePersonDto.setCommandId(commandId);
            deletePersonDto.setVersion(version);
            deletePersonDto.setPersonalName(new PersonalNameDto(PeopleApiUtils.parseIdString(id)));
            personApplicationService.when(deletePersonDto.toDeletePerson());
        } catch (DomainError error) {
            throw error;
        } catch (Exception ex) {
            throw new WebApiApplicationException(ex);
        }
    }


    @Path("_metadata/filteringFields")
    @GET
    public List<PropertyMetadataDto> GetMetadataFilteringFields() {
        try {
            List<PropertyMetadataDto> filtering = new ArrayList<>();
            PersonFilteringProperties.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;
        } catch (DomainError ex) {
            throw ex;
        } catch (Exception ex) {
            throw new WebApiApplicationException(ex);
        }
    }


    @Path("{id}/_stateEvents/{version}")
    @GET
    public PersonStateEvent GetStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {
            PersonalName idObj = PeopleApiUtils.parseIdString(id);
            return personApplicationService.getStateEvent(idObj, version);
        } catch (DomainError error) {
            throw error;
        } catch (Exception ex) {
            throw new WebApiApplicationException(ex);
        }
    }


    /**
     * 获取某 Person 某年的年计划
     *
     * @param personalName
     * @param year
     * @return
     */
    @Path("{personalName}/YearPlans/{year}")
    @GET
    public YearPlanStateDto GetYearPlan(@PathParam("personalName") String personalName, @PathParam("year") int year) {
        try {
            YearPlanState state = personApplicationService.getYearPlan(PeopleApiUtils.parseIdString(personalName), year);
            if (state == null) {
                return null;
            }
            YearPlanStateDto.DtoConverter dtoConverter = new YearPlanStateDto.DtoConverter();
            YearPlanStateDto stateDto = dtoConverter.toYearPlanStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;
        } catch (DomainError error) {
            throw error;
        } catch (Exception ex) {
            throw new WebApiApplicationException(ex);
        }
    }


    @Path("{personalName}/YearPlans/{year}/MonthPlans/{month}")
    @GET
    public MonthPlanStateDto GetMonthPlan(@PathParam("personalName") String personalName,
                                          @PathParam("year") int year,
                                          @PathParam("month") int month) {
        try {
            MonthPlanState state = personApplicationService.getMonthPlan(PeopleApiUtils.parseIdString(personalName), year, month);
            if (state == null) {
                return null;
            }
            MonthPlanStateDto.DtoConverter dtoConverter = new MonthPlanStateDto.DtoConverter();
            MonthPlanStateDto stateDto = dtoConverter.toMonthPlanStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;
        } catch (DomainError error) {
            throw error;
        } catch (Exception ex) {
            throw new WebApiApplicationException(ex);
        }
    }


    /**
     * 获取某人某年某月某日的计划
     *
     * @param personalName
     * @param year
     * @param month
     * @param day
     * @return
     */
    @Path("{personalName}/YearPlans/{year}/MonthPlans/{month}/DayPlans/{day}")
    @GET
    public DayPlanStateDto GetDayPlan(@PathParam("personalName") String personalName,
                                      @PathParam("year") int year,
                                      @PathParam("month") int month,
                                      @PathParam("day") int day) {
        try {
            DayPlanState state = personApplicationService.getDayPlan(PeopleApiUtils.parseIdString(personalName), year, month, day);
            if (state == null) {
                return null;
            }
            DayPlanStateDto.DtoConverter dtoConverter = new DayPlanStateDto.DtoConverter();
            DayPlanStateDto stateDto = dtoConverter.toDayPlanStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;
        } catch (DomainError error) {
            throw error;
        } catch (Exception ex) {
            throw new WebApiApplicationException(ex);
        }
    }


    private String getQueryOrderSeparator() {
        return ",";
    }

    private TypeConverter getCriterionDefaultTypeConvert() {
        return new DefaultTypeConverter();
    }

    private class PeoplePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return PeopleApiUtils.GetFilterPropertyType(propertyName);
        }
    }


    private static class PeopleApiUtils {
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

        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (PersonFilteringProperties.propertyTypeMap.containsKey(fieldName)) {
                return fieldName;
            }
            return null;
        }

        public static Class GetFilterPropertyType(String propertyName) {
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


        public static Iterable<Map.Entry<String, Object>> getQueryFilterDictionary(Map<String, String[]> queryNameValuePairs) {
            Map<String, Object> filter = new HashMap<>();
            queryNameValuePairs.forEach((key, values) -> {
                if (values.length > 0) {
                    String pName = getFilterPropertyName(key);
                    if (!StringHelper.isNullOrEmpty(pName)) {
                        Class pClass = GetFilterPropertyType(pName);
                        filter.put(pName, ApplicationContext.current.getTypeConverter().convertFromString(pClass, values[0]));
                    }
                }
            });
            return filter.entrySet();
        }

        public static PersonalName parseIdString(String idString) {
            PersonalNameFlattenedDtoFormatter formatter = new PersonalNameFlattenedDtoFormatter();
            PersonalNameFlattenedDto idDto = formatter.parse(idString);
            return idDto.toPersonalName();
        }


        public static void setNullIdOrThrowOnInconsistentIds(String id, PersonCommand value) {
            PersonalNameDto personalNameDto = new PersonalNameDto(parseIdString(id));
            if (value.getPersonalName() == null) {
                value.setPersonalName(personalNameDto);
            } else if (!value.getPersonalName().equals(personalNameDto)) {
                throw DomainError.named("inconsistentId", "Argument Id {0} NOT equals body Id {1}", id, value.getPersonalName());
            }
        }
    }

}
