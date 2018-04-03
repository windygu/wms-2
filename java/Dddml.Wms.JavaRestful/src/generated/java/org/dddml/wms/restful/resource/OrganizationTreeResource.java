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
import org.dddml.wms.domain.party.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("OrganizationTrees") @Produces(MediaType.APPLICATION_JSON)
public class OrganizationTreeResource {

    @Autowired
    OrganizationTreeApplicationService organizationTreeApplicationService;

    @GET
    public OrganizationStateDto[] get(@Context HttpServletRequest request,
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
            Iterable<OrganizationState> states = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                if (parentIdObj == null) {
                    if (isOnlyIdReturned(fields)) {
                        Iterable<String> ids = organizationTreeApplicationService.getRootIds(
                                CriterionDto.toSubclass(
                                        JSON.parseObject(filter, CriterionDto.class),
                                        getCriterionTypeConverter(),
                                        getPropertyTypeResolver(), n -> (OrganizationStructureMetadata.aliasMap.containsKey(n) ? OrganizationStructureMetadata.aliasMap.get(n) : n)),
                                OrganizationStructureResource.OrganizationStructureResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult, maxResults);

                        return OrganizationResource.OrganizationResourceUtils.toOrganizationStateDtoArray(ids);
                    } else {
                        states = organizationTreeApplicationService.getRoots(
                                CriterionDto.toSubclass(
                                        JSON.parseObject(filter, CriterionDto.class),
                                        getCriterionTypeConverter(),
                                        getPropertyTypeResolver(), n -> (OrganizationStructureMetadata.aliasMap.containsKey(n) ? OrganizationStructureMetadata.aliasMap.get(n) : n)),
                                OrganizationStructureResource.OrganizationStructureResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult, maxResults);

                    }
                } else {// parentIdObj != null
                    if (isOnlyIdReturned(fields)) {
                        Iterable<String> ids = organizationTreeApplicationService.getChildIds(parentIdObj,
                                CriterionDto.toSubclass(
                                        JSON.parseObject(filter, CriterionDto.class),
                                        getCriterionTypeConverter(),
                                        getPropertyTypeResolver(), n -> (OrganizationStructureMetadata.aliasMap.containsKey(n) ? OrganizationStructureMetadata.aliasMap.get(n) : n)),
                                OrganizationStructureResource.OrganizationStructureResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult, maxResults);

                        return OrganizationResource.OrganizationResourceUtils.toOrganizationStateDtoArray(ids);
                    } else {
                        states = organizationTreeApplicationService.getChildren(
                                parentIdObj,
                                CriterionDto.toSubclass(
                                        JSON.parseObject(filter, CriterionDto.class),
                                        getCriterionTypeConverter(),
                                        getPropertyTypeResolver(), n -> (OrganizationStructureMetadata.aliasMap.containsKey(n) ? OrganizationStructureMetadata.aliasMap.get(n) : n)),
                                OrganizationStructureResource.OrganizationStructureResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult, maxResults);
                    }
                }
            } else { // filter == null
                if (parentIdObj == null) {
                    if (isOnlyIdReturned(fields)) {
                        Iterable<String> ids = organizationTreeApplicationService.getRootIds(
                                OrganizationStructureResource.OrganizationStructureResourceUtils.getQueryFilterMap(request.getParameterMap()),
                                OrganizationStructureResource.OrganizationStructureResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult, maxResults);

                        return OrganizationResource.OrganizationResourceUtils.toOrganizationStateDtoArray(ids);
                    } else {
                        states = organizationTreeApplicationService.getChildren(
                                parentIdObj,
                                OrganizationStructureResource.OrganizationStructureResourceUtils.getQueryFilterMap(request.getParameterMap()),
                                OrganizationStructureResource.OrganizationStructureResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult, maxResults);
                    }
                } else {
                    if (isOnlyIdReturned(fields)) {
                        Iterable<String> ids = organizationTreeApplicationService.getChildIds(
                                parentIdObj,
                                OrganizationStructureResource.OrganizationStructureResourceUtils.getQueryFilterMap(request.getParameterMap()),
                                OrganizationStructureResource.OrganizationStructureResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult, maxResults);

                        return OrganizationResource.OrganizationResourceUtils.toOrganizationStateDtoArray(ids);
                    } else {
                        states = organizationTreeApplicationService.getChildren(
                                parentIdObj,
                                OrganizationStructureResource.OrganizationStructureResourceUtils.getQueryFilterMap(request.getParameterMap()),
                                OrganizationStructureResource.OrganizationStructureResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                                firstResult, maxResults);
                    }
                }
            }

            if (states == null) { return new OrganizationStateDto[0]; }
            OrganizationStateDto.DtoConverter dtoConverter = new OrganizationStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toOrganizationStateDtoArray(states);


        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("_metadata/filteringFields") @GET
    public Iterable<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            OrganizationStructureMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

		// /////////////////////////////////////////////////

    private boolean isOnlyIdReturned(String fields) {
        if ("PartyId".equalsIgnoreCase(fields)) {
            return true;
        }
        if ("Id.SubsidiaryId".equalsIgnoreCase(fields)) {
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
        return new OrganizationTreePropertyTypeResolver();
    }

    private class OrganizationTreePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return OrganizationStructureResource.OrganizationStructureResourceUtils.getFilterPropertyType(propertyName);
        }
    }

}

