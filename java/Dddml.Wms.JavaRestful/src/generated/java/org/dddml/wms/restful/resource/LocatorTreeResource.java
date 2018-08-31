package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.annotation.*;
import org.dddml.wms.domain.locator.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "LocatorTrees", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class LocatorTreeResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LocatorTreeApplicationService locatorTreeApplicationService;

    @GetMapping
    public LocatorStateDto[] get( HttpServletRequest request,
                                   @RequestParam(value = "parentId", required = false) String parentId,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        try {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }

            String parentIdObj = parentId == null ? null : parentId;
            Iterable<LocatorState> states = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                if (parentIdObj == null) {
                    if (isOnlyIdReturned(fields)) {
                        Iterable<String> ids = locatorTreeApplicationService.getRootIds(
                                CriterionDto.toSubclass(
                                        JSON.parseObject(filter, CriterionDto.class),
                                        getCriterionTypeConverter(),
                                        getPropertyTypeResolver(), n -> (LocatorMetadata.aliasMap.containsKey(n) ? LocatorMetadata.aliasMap.get(n) : n)),
                                LocatorResource.LocatorResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult, maxResults);

                        return LocatorResource.LocatorResourceUtils.toLocatorStateDtoArray(ids);
                    } else {
                        states = locatorTreeApplicationService.getRoots(
                                CriterionDto.toSubclass(
                                        JSON.parseObject(filter, CriterionDto.class),
                                        getCriterionTypeConverter(),
                                        getPropertyTypeResolver(), n -> (LocatorMetadata.aliasMap.containsKey(n) ? LocatorMetadata.aliasMap.get(n) : n)),
                                LocatorResource.LocatorResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult, maxResults);

                    }
                } else {// parentIdObj != null
                    if (isOnlyIdReturned(fields)) {
                        Iterable<String> ids = locatorTreeApplicationService.getChildIds(parentIdObj,
                                CriterionDto.toSubclass(
                                        JSON.parseObject(filter, CriterionDto.class),
                                        getCriterionTypeConverter(),
                                        getPropertyTypeResolver(), n -> (LocatorMetadata.aliasMap.containsKey(n) ? LocatorMetadata.aliasMap.get(n) : n)),
                                LocatorResource.LocatorResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult, maxResults);

                        return LocatorResource.LocatorResourceUtils.toLocatorStateDtoArray(ids);
                    } else {
                        states = locatorTreeApplicationService.getChildren(
                                parentIdObj,
                                CriterionDto.toSubclass(
                                        JSON.parseObject(filter, CriterionDto.class),
                                        getCriterionTypeConverter(),
                                        getPropertyTypeResolver(), n -> (LocatorMetadata.aliasMap.containsKey(n) ? LocatorMetadata.aliasMap.get(n) : n)),
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


        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }    }


    @GetMapping("_metadata/filteringFields")
    public Iterable<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            LocatorMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
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

