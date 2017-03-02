package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.dddml.support.criterion.*;
import java.math.BigDecimal;
import java.util.Date;
import org.joda.money.Money;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.apache.cxf.jaxrs.ext.PATCH;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@Path("InOutLineMvos")
@Produces(MediaType.APPLICATION_JSON)
public class InOutLineMvoResource {


    @Autowired
    private InOutLineMvoApplicationService inOutLineMvoApplicationService;


    @GET
    public InOutLineMvoStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<InOutLineMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = inOutLineMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver()),
                        InOutLineMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = inOutLineMvoApplicationService.get(
                        InOutLineMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        InOutLineMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            InOutLineMvoStateDto.DtoConverter dtoConverter = new InOutLineMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInOutLineMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GET
    @Path("{id}")
    public InOutLineMvoStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            InOutLineId idObj = InOutLineMvoResourceUtils.parseIdString(id);
            InOutLineMvoState state = inOutLineMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            InOutLineMvoStateDto.DtoConverter dtoConverter = new InOutLineMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInOutLineMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count")
    @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = inOutLineMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver()));
            } else {
                count = inOutLineMvoApplicationService.getCount(InOutLineMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PUT
    @Path("/{id}")
    public void put(@PathParam("id") String id, CreateOrMergePatchInOutLineMvoDto.CreateInOutLineMvoDto value) {
        try {

            InOutLineMvoCommand.CreateInOutLineMvo cmd = value.toCreateInOutLineMvo();
            InOutLineMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            inOutLineMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PATCH
    @Path("/{id}")
    public void patch(@PathParam("id") String id, CreateOrMergePatchInOutLineMvoDto.MergePatchInOutLineMvoDto value) {
        try {

            InOutLineMvoCommand.MergePatchInOutLineMvo cmd = value.toMergePatchInOutLineMvo();
            InOutLineMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            inOutLineMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            InOutLineMvoCommand.DeleteInOutLineMvo deleteCmd = new AbstractInOutLineMvoCommand.SimpleDeleteInOutLineMvo();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setInOutVersion(version);
            InOutLineMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            inOutLineMvoApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields")
    @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            InOutLineMvoFilteringProperties.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}")
    @GET
    public InOutLineMvoStateEventDto getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            InOutLineId idObj = InOutLineMvoResourceUtils.parseIdString(id);
            InOutLineMvoStateEventDtoConverter dtoConverter = getInOutLineMvoStateEventDtoConverter();
            return dtoConverter.toInOutLineMvoStateEventDto((AbstractInOutLineMvoStateEvent) inOutLineMvoApplicationService.getStateEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_historyStates/{version}")
    @GET
    public InOutLineMvoStateDto getHistoryState(@PathParam("id") String id, @PathParam("version") long version, @QueryParam("fields") String fields) {
        try {

            InOutLineId idObj = InOutLineMvoResourceUtils.parseIdString(id);
            InOutLineMvoStateDto.DtoConverter dtoConverter = new InOutLineMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInOutLineMvoStateDto(inOutLineMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  InOutLineMvoStateEventDtoConverter getInOutLineMvoStateEventDtoConverter() {
        return new InOutLineMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new InOutLineMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class InOutLineMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return InOutLineMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class InOutLineMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, InOutLineMvoCommand value) {
            InOutLineId idObj = parseIdString(id);
            if (value.getInOutLineId() == null) {
                value.setInOutLineId(idObj);
            } else if (!value.getInOutLineId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getInOutLineId());
            }
        }
    

        public static InOutLineId parseIdString(String idString) {
            InOutLineIdFlattenedDtoFormatter formatter = new InOutLineIdFlattenedDtoFormatter();
            InOutLineIdFlattenedDto idDto = formatter.parse(idString);
            return idDto.toInOutLineId();
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (InOutLineMvoFilteringProperties.propertyTypeMap.containsKey(fieldName)) {
                return fieldName;
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (InOutLineMvoFilteringProperties.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = InOutLineMvoFilteringProperties.propertyTypeMap.get(propertyName);
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

        public static InOutLineMvoStateDto[] toInOutLineMvoStateDtoArray(Iterable<InOutLineId> ids) {
            List<InOutLineMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                InOutLineMvoStateDto dto = new InOutLineMvoStateDto();
                dto.setInOutLineId(new InOutLineIdDtoWrapper(id));
                states.add(dto);
            });
            return states.toArray(new InOutLineMvoStateDto[0]);
        }

    }

}

