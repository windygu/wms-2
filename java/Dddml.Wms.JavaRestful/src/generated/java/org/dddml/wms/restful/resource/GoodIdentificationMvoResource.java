package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import org.dddml.wms.domain.product.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.goodidentificationmvo.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "GoodIdentificationMvos", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class GoodIdentificationMvoResource {


    @Autowired
    private GoodIdentificationMvoApplicationService goodIdentificationMvoApplicationService;


    @GetMapping
    public GoodIdentificationMvoStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<GoodIdentificationMvoState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = goodIdentificationMvoApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (GoodIdentificationMvoMetadata.aliasMap.containsKey(n) ? GoodIdentificationMvoMetadata.aliasMap.get(n) : n)),
                        GoodIdentificationMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = goodIdentificationMvoApplicationService.get(
                        GoodIdentificationMvoResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        GoodIdentificationMvoResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            GoodIdentificationMvoStateDto.DtoConverter dtoConverter = new GoodIdentificationMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toGoodIdentificationMvoStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public GoodIdentificationMvoStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            ProductGoodIdentificationId idObj = GoodIdentificationMvoResourceUtils.parseIdString(id);
            GoodIdentificationMvoState state = goodIdentificationMvoApplicationService.get(idObj);
            if (state == null) { return null; }

            GoodIdentificationMvoStateDto.DtoConverter dtoConverter = new GoodIdentificationMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toGoodIdentificationMvoStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = goodIdentificationMvoApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (GoodIdentificationMvoMetadata.aliasMap.containsKey(n) ? GoodIdentificationMvoMetadata.aliasMap.get(n) : n)));
            } else {
                count = goodIdentificationMvoApplicationService.getCount(GoodIdentificationMvoResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public ProductGoodIdentificationId post(@RequestBody CreateOrMergePatchGoodIdentificationMvoDto.CreateGoodIdentificationMvoDto value,  HttpServletResponse response) {
        try {
            GoodIdentificationMvoCommand.CreateGoodIdentificationMvo cmd = value.toCreateGoodIdentificationMvo();
            if (cmd.getProductGoodIdentificationId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "GoodIdentificationMvo");
            }
            goodIdentificationMvoApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getProductGoodIdentificationId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchGoodIdentificationMvoDto value) {
        try {
            if (value.getProductVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                GoodIdentificationMvoCommand.MergePatchGoodIdentificationMvo cmd = (GoodIdentificationMvoCommand.MergePatchGoodIdentificationMvo) value.toCommand();
                GoodIdentificationMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                goodIdentificationMvoApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            GoodIdentificationMvoCommand.CreateGoodIdentificationMvo cmd = (GoodIdentificationMvoCommand.CreateGoodIdentificationMvo) value.toCommand();
            GoodIdentificationMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            goodIdentificationMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchGoodIdentificationMvoDto.MergePatchGoodIdentificationMvoDto value) {
        try {

            GoodIdentificationMvoCommand.MergePatchGoodIdentificationMvo cmd = value.toMergePatchGoodIdentificationMvo();
            GoodIdentificationMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            goodIdentificationMvoApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            GoodIdentificationMvoCommand.DeleteGoodIdentificationMvo deleteCmd = new AbstractGoodIdentificationMvoCommand.SimpleDeleteGoodIdentificationMvo();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setProductVersion(version);
            GoodIdentificationMvoResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            goodIdentificationMvoApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            GoodIdentificationMvoMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_stateEvents/{version}")
    public GoodIdentificationMvoStateEventDto getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            ProductGoodIdentificationId idObj = GoodIdentificationMvoResourceUtils.parseIdString(id);
            GoodIdentificationMvoStateEventDtoConverter dtoConverter = getGoodIdentificationMvoStateEventDtoConverter();
            return dtoConverter.toGoodIdentificationMvoStateEventDto((AbstractGoodIdentificationMvoEvent) goodIdentificationMvoApplicationService.getEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public GoodIdentificationMvoStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            ProductGoodIdentificationId idObj = GoodIdentificationMvoResourceUtils.parseIdString(id);
            GoodIdentificationMvoStateDto.DtoConverter dtoConverter = new GoodIdentificationMvoStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toGoodIdentificationMvoStateDto(goodIdentificationMvoApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  GoodIdentificationMvoStateEventDtoConverter getGoodIdentificationMvoStateEventDtoConverter() {
        return new GoodIdentificationMvoStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new GoodIdentificationMvoPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class GoodIdentificationMvoPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return GoodIdentificationMvoResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class GoodIdentificationMvoResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, GoodIdentificationMvoCommand value) {
            ProductGoodIdentificationId idObj = parseIdString(id);
            if (value.getProductGoodIdentificationId() == null) {
                value.setProductGoodIdentificationId(idObj);
            } else if (!value.getProductGoodIdentificationId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getProductGoodIdentificationId());
            }
        }
    

        public static ProductGoodIdentificationId parseIdString(String idString) {
            TextFormatter<ProductGoodIdentificationId> formatter =
                    new AbstractValueObjectTextFormatter<ProductGoodIdentificationId>(ProductGoodIdentificationId.class) {
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
            if (GoodIdentificationMvoMetadata.aliasMap.containsKey(fieldName)) {
                return GoodIdentificationMvoMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (GoodIdentificationMvoMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = GoodIdentificationMvoMetadata.propertyTypeMap.get(propertyName);
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

        public static GoodIdentificationMvoStateDto[] toGoodIdentificationMvoStateDtoArray(Iterable<ProductGoodIdentificationId> ids) {
            List<GoodIdentificationMvoStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                GoodIdentificationMvoStateDto dto = new GoodIdentificationMvoStateDto();
                dto.setProductGoodIdentificationId(id);
                states.add(dto);
            });
            return states.toArray(new GoodIdentificationMvoStateDto[0]);
        }

    }

}

