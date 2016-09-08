package org.dddml.wms.restful.resource;

import com.alibaba.fastjson.JSON;
import org.dddml.support.criterion.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.meta.LocatorFilteringProperties;
import org.dddml.wms.domain.meta.PersonFilteringProperties;
import org.dddml.wms.restful.exception.WebApiApplicationException;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.DomainError;
import org.dddml.wms.specialization.PropertyMetadataDto;
import org.dddml.wms.specialization.ReflectUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import java.util.*;

/**
 * Created by Li Yongchun on 2016/9/7.
 */
@Path("locatorTrees")
public class LocatorTreesResource {
    @Autowired
    LocatorTreeApplicationService locatorTreeApplicationService;

    /**
     * 根据条件查询 Locator
     *
     * @param request     Http 请求
     * @param parentId    父Id
     * @param sort        排序
     * @param fields      指定返回的字段列表
     * @param firstResult 符合条件的数据的起始位置
     * @param maxResults  返回的符合条件的数据的数量
     * @param filter      查询条件
     * @return
     */
    @GET
    public List<LocatorStateDto> get(@Context HttpServletRequest request,
                                     @QueryParam("parentId") String parentId,
                                     @QueryParam("sort") String sort,
                                     @QueryParam("fields") String fields,
                                     @DefaultValue("0") @QueryParam("firstResult") Integer firstResult,
                                     @QueryParam("maxResults") Integer maxResults,
                                     @QueryParam("filter") String filter) {
        if (firstResult < 0) {
            firstResult = 0;
        }
        if (maxResults == null || maxResults < 1) {
            maxResults = Integer.MAX_VALUE;
        }
        try {
            Iterable<LocatorState> states = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                if (parentId == null) {//父parentId为null
                    if (isOnlyIdReturned(fields)) {
                        Iterable<String> ids = locatorTreeApplicationService.getRootIds(
                                CriterionDto.toSubclass(
                                        JSON.parseObject(filter, CriterionDto.class),
                                        getCriterionDefaultTypeConvert(),
                                        new LocatorTreesPropertyTypeResolver()),
                                LocatorTreesApiUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult,
                                maxResults);
                        return LocatorTreesApiUtils.toLocatorStateDtoCollection(ids);
                    } else {
                        states = locatorTreeApplicationService.getRoots(
                                CriterionDto.toSubclass(
                                        JSON.parseObject(filter, CriterionDto.class),
                                        getCriterionDefaultTypeConvert(),
                                        new LocatorTreesPropertyTypeResolver()),
                                LocatorTreesApiUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult,
                                maxResults);
                    }
                } else {//父parentId不为null
                    if (isOnlyIdReturned(fields)) {
                        Iterable<String> ids = locatorTreeApplicationService.getChildIds(parentId,
                                CriterionDto.toSubclass(
                                        JSON.parseObject(filter, CriterionDto.class),
                                        getCriterionDefaultTypeConvert(),
                                        new LocatorTreesPropertyTypeResolver()),
                                LocatorTreesApiUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult,
                                maxResults);
                        return LocatorTreesApiUtils.toLocatorStateDtoCollection(ids);
                    } else {
                        states = locatorTreeApplicationService.getChildren(
                                parentId,
                                CriterionDto.toSubclass(
                                        JSON.parseObject(filter, CriterionDto.class),
                                        getCriterionDefaultTypeConvert(),
                                        new LocatorTreesPropertyTypeResolver()),
                                LocatorTreesApiUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult,
                                maxResults);
                    }
                }
            } else { //filter为空
                if (parentId == null) {
                    if (isOnlyIdReturned(fields)) {
                        Iterable<String> ids = locatorTreeApplicationService.getRootIds(
                                LocatorTreesApiUtils.getQueryFilterDictionary(request.getParameterMap()),
                                LocatorTreesApiUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult,
                                maxResults);
                        return LocatorTreesApiUtils.toLocatorStateDtoCollection(ids);
                    } else {
                        states = locatorTreeApplicationService.getChildren(
                                parentId,
                                LocatorTreesApiUtils.getQueryFilterDictionary(request.getParameterMap()),
                                LocatorTreesApiUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult,
                                maxResults);
                    }
                } else {
                    if (isOnlyIdReturned(fields)) {
                        Iterable<String> ids = locatorTreeApplicationService.getChildIds(
                                parentId,
                                LocatorTreesApiUtils.getQueryFilterDictionary(request.getParameterMap()),
                                LocatorTreesApiUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult,
                                maxResults);
                        return LocatorTreesApiUtils.toLocatorStateDtoCollection(ids);
                    } else {
                        states = locatorTreeApplicationService.getChildren(
                                parentId,
                                LocatorTreesApiUtils.getQueryFilterDictionary(request.getParameterMap()),
                                LocatorTreesApiUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult,
                                maxResults);
                    }
                }
            }
            if (states == null) {
                return new ArrayList<>();
            } else {
                LocatorStateDto.DtoConverter dtoConverter = new LocatorStateDto.DtoConverter();
                if (fields == null) {
                    dtoConverter.setAllFieldsReturned(true);
                } else {
                    dtoConverter.setReturnedFieldsString(fields);
                }
                return Arrays.asList(dtoConverter.toLocatorStateDtoArray(states));
            }
        } catch (DomainError error) {
            throw error;
        } catch (Exception ex) {
            throw new WebApiApplicationException(ex);
        }
    }


    @Path("_metadata/filteringFields")
    @GET
    public Iterable<PropertyMetadataDto> GetMetadataFilteringFields() {
        try {
            List<PropertyMetadataDto> filtering = new ArrayList<>();
            LocatorFilteringProperties.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;
        } catch (Exception ex) {
            throw new WebApiApplicationException(ex);
        }
    }


    /**
     * 判断是否只是返回Id
     *
     * @param fields
     * @return
     */

    private boolean isOnlyIdReturned(String fields) {
        if ("LocatorId".equalsIgnoreCase(fields)) {
            return true;
        }
        return false;
    }


    private String getQueryOrderSeparator() {
        return ",";
    }

    private TypeConverter getCriterionDefaultTypeConvert() {
        return new DefaultTypeConverter();
    }

    private class LocatorTreesPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return LocatorTreesApiUtils.GetFilterPropertyType(propertyName);
        }
    }


    private static class LocatorTreesApiUtils {
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
                        ApplicationContext.current.getTypeConverter().convertFromString(pClass, values[0]);
                        filter.put(pName, null);
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


        public static void setNullIdOrThrowOnInconsistentIds(String id, CreateOrMergePatchPersonDto value) {
            PersonalNameDto personalNameDto = new PersonalNameDto(parseIdString(id));
            if (value.getPersonalName() == null) {
                value.setPersonalName(personalNameDto);
            } else if (!value.getPersonalName().equals(personalNameDto)) {
                throw DomainError.named("inconsistentId", "Argument Id {0} NOT equals body Id {1}", id, value.getPersonalName());
            }
        }


        public static List<LocatorStateDto> toLocatorStateDtoCollection(Iterable<String> ids) {
            List<LocatorStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                LocatorStateDto dto = new LocatorStateDto();
                dto.setLocatorId(id);
                states.add(dto);
            });
            return states;
        }
    }
}
