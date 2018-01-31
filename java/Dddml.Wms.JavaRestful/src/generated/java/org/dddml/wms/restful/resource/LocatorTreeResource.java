package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.locator.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("LocatorTrees") @Produces(MediaType.APPLICATION_JSON)
public class LocatorTreeResource {

    @Autowired
    LocatorTreeApplicationService locatorTreeApplicationService;

    @GET
    public LocatorStateDto[] get(@Context HttpServletRequest request,
                                   @QueryParam("parentId") String parentId,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            String parentIdObj = parentId == null ? null : parentId;
            Iterable<LocatorState> states = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                if (parentIdObj == null) {
                    if (isOnlyIdReturned(fields)) {
                        Iterable<String> ids = locatorTreeApplicationService.getRootIds(
                                CriterionDto.toSubclass(
                                        JSON.parseObject(filter, CriterionDto.class),
                                        getCriterionTypeConverter(),
                                        getPropertyTypeResolver(), n -> (LocatorFilteringProperties.aliasMap.containsKey(n) ? LocatorFilteringProperties.aliasMap.get(n) : n)),
                                LocatorResource.LocatorResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult, maxResults);

                        return LocatorResource.LocatorResourceUtils.toLocatorStateDtoArray(ids);
                    } else {
                        states = locatorTreeApplicationService.getRoots(
                                CriterionDto.toSubclass(
                                        JSON.parseObject(filter, CriterionDto.class),
                                        getCriterionTypeConverter(),
                                        getPropertyTypeResolver(), n -> (LocatorFilteringProperties.aliasMap.containsKey(n) ? LocatorFilteringProperties.aliasMap.get(n) : n)),
                                LocatorResource.LocatorResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult, maxResults);

                    }
                } else {// parentIdObj != null
                    if (isOnlyIdReturned(fields)) {
                        Iterable<String> ids = locatorTreeApplicationService.getChildIds(parentIdObj,
                                CriterionDto.toSubclass(
                                        JSON.parseObject(filter, CriterionDto.class),
                                        getCriterionTypeConverter(),
                                        getPropertyTypeResolver(), n -> (LocatorFilteringProperties.aliasMap.containsKey(n) ? LocatorFilteringProperties.aliasMap.get(n) : n)),
                                LocatorResource.LocatorResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult, maxResults);

                        return LocatorResource.LocatorResourceUtils.toLocatorStateDtoArray(ids);
                    } else {
                        states = locatorTreeApplicationService.getChildren(
                                parentIdObj,
                                CriterionDto.toSubclass(
                                        JSON.parseObject(filter, CriterionDto.class),
                                        getCriterionTypeConverter(),
                                        getPropertyTypeResolver(), n -> (LocatorFilteringProperties.aliasMap.containsKey(n) ? LocatorFilteringProperties.aliasMap.get(n) : n)),
                                LocatorResource.LocatorResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult, maxResults);
                    }
                }
            } else { // filter == null
                if (parentIdObj == null) {
                    if (isOnlyIdReturned(fields)) {
                        Iterable<String> ids = locatorTreeApplicationService.getRootIds(
                                LocatorResource.LocatorResourceUtils.getQueryFilterMap(request.getParameterMap()),
                                LocatorResource.LocatorResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult, maxResults);

                        return LocatorResource.LocatorResourceUtils.toLocatorStateDtoArray(ids);
                    } else {
                        states = locatorTreeApplicationService.getChildren(
                                parentIdObj,
                                LocatorResource.LocatorResourceUtils.getQueryFilterMap(request.getParameterMap()),
                                LocatorResource.LocatorResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult, maxResults);
                    }
                } else {
                    if (isOnlyIdReturned(fields)) {
                        Iterable<String> ids = locatorTreeApplicationService.getChildIds(
                                parentIdObj,
                                LocatorResource.LocatorResourceUtils.getQueryFilterMap(request.getParameterMap()),
                                LocatorResource.LocatorResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult, maxResults);

                        return LocatorResource.LocatorResourceUtils.toLocatorStateDtoArray(ids);
                    } else {
                        states = locatorTreeApplicationService.getChildren(
                                parentIdObj,
                                LocatorResource.LocatorResourceUtils.getQueryFilterMap(request.getParameterMap()),
                                LocatorResource.LocatorResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult, maxResults);
                    }
                }
            }

            if (states == null) { return new LocatorStateDto[0]; }
            LocatorStateDto.DtoConverter dtoConverter = new LocatorStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toLocatorStateDtoArray(states);


        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("_metadata/filteringFields") @GET
    public Iterable<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            LocatorFilteringProperties.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

		// /////////////////////////////////////////////////

    private boolean isOnlyIdReturned(String fields) {
        if ("LocatorId".equalsIgnoreCase(fields)) {
            return true;
        }
        return false;
    }


    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new LocatorTreePropertyTypeResolver();
    }

    private class LocatorTreePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return LocatorResource.LocatorResourceUtils.getFilterPropertyType(propertyName);
        }
    }

}

