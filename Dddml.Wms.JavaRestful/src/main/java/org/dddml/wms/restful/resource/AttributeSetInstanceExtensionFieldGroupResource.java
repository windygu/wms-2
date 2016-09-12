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

@Path("AttributeSetInstanceExtensionFieldGroups")
@Produces(MediaType.APPLICATION_JSON)
public class AttributeSetInstanceExtensionFieldGroupResource {


    @Autowired
    private AttributeSetInstanceExtensionFieldGroupApplicationService attributeSetInstanceExtensionFieldGroupApplicationService;


    @GET
    public AttributeSetInstanceExtensionFieldGroupStateDto[] getAll(@Context HttpServletRequest request,
                                   @QueryParam("sort") String sort,
                                   @QueryParam("fields") String fields,
                                   @QueryParam("firstResult") @DefaultValue("0") Integer firstResult,
                                   @QueryParam("maxResults") @DefaultValue("2147483647") Integer maxResults,
                                   @QueryParam("filter") String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<AttributeSetInstanceExtensionFieldGroupState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = attributeSetInstanceExtensionFieldGroupApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver()),
                        AttributeSetInstanceExtensionFieldGroupResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = attributeSetInstanceExtensionFieldGroupApplicationService.get(
                        AttributeSetInstanceExtensionFieldGroupResourceUtils.getQueryFilterDictionary(request.getParameterMap()),
                        AttributeSetInstanceExtensionFieldGroupResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            AttributeSetInstanceExtensionFieldGroupStateDto.DtoConverter dtoConverter = new AttributeSetInstanceExtensionFieldGroupStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeSetInstanceExtensionFieldGroupStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }    }

    @GET
    @Path("{id}")
    public AttributeSetInstanceExtensionFieldGroupStateDto get(@PathParam("id") String id, @QueryParam("fields") String fields) {
        try {
            String idObj = id;
            AttributeSetInstanceExtensionFieldGroupState state = attributeSetInstanceExtensionFieldGroupApplicationService.get(idObj);
            if (state == null) { return null; }

            AttributeSetInstanceExtensionFieldGroupStateDto.DtoConverter dtoConverter = new AttributeSetInstanceExtensionFieldGroupStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeSetInstanceExtensionFieldGroupStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_count")
    @GET
    public long getCount(@Context HttpServletRequest request,
                         @QueryParam("filter") String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = attributeSetInstanceExtensionFieldGroupApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver()));
            } else {
                count = attributeSetInstanceExtensionFieldGroupApplicationService.getCount(AttributeSetInstanceExtensionFieldGroupResourceUtils.getQueryFilterDictionary(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PUT
    @Path("/{id}")
    public void put(@PathParam("id") String id, CreateOrMergePatchAttributeSetInstanceExtensionFieldGroupDto.CreateAttributeSetInstanceExtensionFieldGroupDto value) {
        try {

            AttributeSetInstanceExtensionFieldGroupCommand.CreateAttributeSetInstanceExtensionFieldGroup cmd = value.toCreateAttributeSetInstanceExtensionFieldGroup();
            AttributeSetInstanceExtensionFieldGroupResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeSetInstanceExtensionFieldGroupApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PATCH
    @Path("/{id}")
    public void patch(@PathParam("id") String id, CreateOrMergePatchAttributeSetInstanceExtensionFieldGroupDto.MergePatchAttributeSetInstanceExtensionFieldGroupDto value) {
        try {

            AttributeSetInstanceExtensionFieldGroupCommand.MergePatchAttributeSetInstanceExtensionFieldGroup cmd = value.toMergePatchAttributeSetInstanceExtensionFieldGroup();
            AttributeSetInstanceExtensionFieldGroupResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            attributeSetInstanceExtensionFieldGroupApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id,
                       @NotNull @QueryParam("commandId") String commandId,
                       @NotNull @QueryParam("version") @Min(value = -1) Long version,
                       @QueryParam("requesterId") String requesterId) {
        try {

            AttributeSetInstanceExtensionFieldGroupCommand.DeleteAttributeSetInstanceExtensionFieldGroup deleteCmd = new AbstractAttributeSetInstanceExtensionFieldGroupCommand.SimpleDeleteAttributeSetInstanceExtensionFieldGroup();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            AttributeSetInstanceExtensionFieldGroupResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            attributeSetInstanceExtensionFieldGroupApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("_metadata/filteringFields")
    @GET
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            AttributeSetInstanceExtensionFieldGroupFilteringProperties.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{id}/_stateEvents/{version}")
    @GET
    public AttributeSetInstanceExtensionFieldGroupStateEvent getStateEvent(@PathParam("id") String id, @PathParam("version") long version) {
        try {

            String idObj = id;
            return attributeSetInstanceExtensionFieldGroupApplicationService.getStateEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @Path("{groupId}/AttributeSetInstanceExtensionFields/{index}")
    @GET
    public AttributeSetInstanceExtensionFieldStateDto getAttributeSetInstanceExtensionField(@PathParam("groupId") String groupId, @PathParam("index") String index) {
        try {

            AttributeSetInstanceExtensionFieldState state = attributeSetInstanceExtensionFieldGroupApplicationService.getAttributeSetInstanceExtensionField(groupId, index);
            if (state == null) { return null; }
            AttributeSetInstanceExtensionFieldStateDto.DtoConverter dtoConverter = new AttributeSetInstanceExtensionFieldStateDto.DtoConverter();
            AttributeSetInstanceExtensionFieldStateDto stateDto = dtoConverter.toAttributeSetInstanceExtensionFieldStateDto(state);
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
        return new AttributeSetInstanceExtensionFieldGroupPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class AttributeSetInstanceExtensionFieldGroupPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return AttributeSetInstanceExtensionFieldGroupResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class AttributeSetInstanceExtensionFieldGroupResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, AttributeSetInstanceExtensionFieldGroupCommand value) {
            String idObj = id;
            if (value.getId() == null) {
                value.setId(idObj);
            } else if (!value.getId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getId());
            }
        }
    


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (AttributeSetInstanceExtensionFieldGroupFilteringProperties.propertyTypeMap.containsKey(fieldName)) {
/* TODO...
                var p = AttributeSetInstanceExtensionFieldGroupMetadata.Instance.PropertyMetadataDictionary[fieldName];
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
            if (AttributeSetInstanceExtensionFieldGroupFilteringProperties.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = AttributeSetInstanceExtensionFieldGroupFilteringProperties.propertyTypeMap.get(propertyName);
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

