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
import org.dddml.wms.domain.uomconversion.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("UomConversions") @Produces(MediaType.APPLICATION_JSON)
public class UomConversionResource {


    @Autowired
    private UomConversionApplicationService uomConversionApplicationService;


    @GET
    public UomConversionStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<UomConversionState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = uomConversionApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (UomConversionFilteringProperties.aliasMap.containsKey(n) ? UomConversionFilteringProperties.aliasMap.get(n) : n)),
                        UomConversionResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = uomConversionApplicationService.get(
                        UomConversionResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        UomConversionResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            UomConversionStateDto.DtoConverter dtoConverter = new UomConversionStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toUomConversionStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @GET
    public UomConversionStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            UomConversionId idObj = UomConversionResourceUtils.parseIdString(id);
            UomConversionState state = uomConversionApplicationService.get(idObj);
            if (state == null) { return null; }

            UomConversionStateDto.DtoConverter dtoConverter = new UomConversionStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toUomConversionStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count") @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = uomConversionApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (UomConversionFilteringProperties.aliasMap.containsKey(n) ? UomConversionFilteringProperties.aliasMap.get(n) : n)));
            } else {
                count = uomConversionApplicationService.getCount(UomConversionResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PUT
    public void put(@PathParam("id") String id, CreateOrMergePatchUomConversionDto.CreateUomConversionDto value) {
        try {

            UomConversionCommand.CreateUomConversion cmd = value.toCreateUomConversion();
            UomConversionResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            uomConversionApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @Path("{id}") @PATCH
    public void patch(@PathParam("id") String id, CreateOrMergePatchUomConversionDto.MergePatchUomConversionDto value) {
        try {

            UomConversionCommand.MergePatchUomConversion cmd = value.toMergePatchUomConversion();
            UomConversionResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            uomConversionApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}") @DELETE
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            UomConversionCommand.DeleteUomConversion deleteCmd = new AbstractUomConversionCommand.SimpleDeleteUomConversion();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            UomConversionResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            uomConversionApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields") @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            UomConversionFilteringProperties.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}") @GET
    public UomConversionStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            UomConversionId idObj = UomConversionResourceUtils.parseIdString(id);
            UomConversionStateEventDtoConverter dtoConverter = getUomConversionStateEventDtoConverter();
            return dtoConverter.toUomConversionStateEventDto((AbstractUomConversionStateEvent) uomConversionApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}") @GET
    public UomConversionStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            UomConversionId idObj = UomConversionResourceUtils.parseIdString(id);
            UomConversionStateDto.DtoConverter dtoConverter = new UomConversionStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toUomConversionStateDto(uomConversionApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  UomConversionStateEventDtoConverter getUomConversionStateEventDtoConverter() {
        return new UomConversionStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new UomConversionPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class UomConversionPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return UomConversionResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class UomConversionResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, UomConversionCommand value) {
            UomConversionId idObj = parseIdString(id);
            if (value.getUomConversionId() == null) {
                value.setUomConversionId(idObj);
            } else if (!value.getUomConversionId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getUomConversionId());
            }
        }
    

        public static UomConversionId parseIdString(String idString) {
            TextFormatter<UomConversionId> formatter =
                    new AbstractValueObjectTextFormatter<UomConversionId>(UomConversionId.class) {
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
            if (UomConversionFilteringProperties.aliasMap.containsKey(fieldName)) {
                return UomConversionFilteringProperties.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (UomConversionFilteringProperties.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = UomConversionFilteringProperties.propertyTypeMap.get(propertyName);
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

        public static UomConversionStateDto[] toUomConversionStateDtoArray(Iterable<UomConversionId> ids) {
            List<UomConversionStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                UomConversionStateDto dto = new UomConversionStateDto();
                dto.setUomConversionId(id);
                states.add(dto);
            });
            return states.toArray(new UomConversionStateDto[0]);
        }

    }

}

