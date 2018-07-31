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
import org.dddml.wms.domain.goodidentificationtype.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "GoodIdentificationTypes", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class GoodIdentificationTypeResource {


    @Autowired
    private GoodIdentificationTypeApplicationService goodIdentificationTypeApplicationService;


    @GetMapping
    public GoodIdentificationTypeStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<GoodIdentificationTypeState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = goodIdentificationTypeApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (GoodIdentificationTypeMetadata.aliasMap.containsKey(n) ? GoodIdentificationTypeMetadata.aliasMap.get(n) : n)),
                        GoodIdentificationTypeResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = goodIdentificationTypeApplicationService.get(
                        GoodIdentificationTypeResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        GoodIdentificationTypeResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            GoodIdentificationTypeStateDto.DtoConverter dtoConverter = new GoodIdentificationTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toGoodIdentificationTypeStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_page")
    public Page<GoodIdentificationTypeStateDto> getPage( HttpServletRequest request,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "page", defaultValue = "0") Integer page,
                                   @RequestParam(value = "size", required = false) @NotNull Integer size) {
        try {
            List<String> sort = GoodIdentificationTypeResourceUtils.getQuerySorts(request.getParameterMap());
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<GoodIdentificationTypeState> states = null; 
            Iterable<Map.Entry<String, Object>> queryFilterMap = GoodIdentificationTypeResourceUtils.getQueryFilterMap(request.getParameterMap());
            states = goodIdentificationTypeApplicationService.get(
                        queryFilterMap,
                        GoodIdentificationTypeResourceUtils.getQuerySorts(request.getParameterMap()),
                        firstResult, maxResults);
            long count = goodIdentificationTypeApplicationService.getCount(queryFilterMap);

            GoodIdentificationTypeStateDto.DtoConverter dtoConverter = new GoodIdentificationTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<GoodIdentificationTypeStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toGoodIdentificationTypeStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public GoodIdentificationTypeStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = id;
            GoodIdentificationTypeState state = goodIdentificationTypeApplicationService.get(idObj);
            if (state == null) { return null; }

            GoodIdentificationTypeStateDto.DtoConverter dtoConverter = new GoodIdentificationTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toGoodIdentificationTypeStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = goodIdentificationTypeApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (GoodIdentificationTypeMetadata.aliasMap.containsKey(n) ? GoodIdentificationTypeMetadata.aliasMap.get(n) : n)));
            } else {
                count = goodIdentificationTypeApplicationService.getCount(GoodIdentificationTypeResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public String post(@RequestBody CreateOrMergePatchGoodIdentificationTypeDto.CreateGoodIdentificationTypeDto value,  HttpServletResponse response) {
        try {
            GoodIdentificationTypeCommand.CreateGoodIdentificationType cmd = value.toCreateGoodIdentificationType();
            if (cmd.getGoodIdentificationTypeId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "GoodIdentificationType");
            }
            goodIdentificationTypeApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getGoodIdentificationTypeId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchGoodIdentificationTypeDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                GoodIdentificationTypeCommand.MergePatchGoodIdentificationType cmd = (GoodIdentificationTypeCommand.MergePatchGoodIdentificationType) value.toCommand();
                GoodIdentificationTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                goodIdentificationTypeApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            GoodIdentificationTypeCommand.CreateGoodIdentificationType cmd = (GoodIdentificationTypeCommand.CreateGoodIdentificationType) value.toCommand();
            GoodIdentificationTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            goodIdentificationTypeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchGoodIdentificationTypeDto.MergePatchGoodIdentificationTypeDto value) {
        try {

            GoodIdentificationTypeCommand.MergePatchGoodIdentificationType cmd = value.toMergePatchGoodIdentificationType();
            GoodIdentificationTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            goodIdentificationTypeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            GoodIdentificationTypeCommand.DeleteGoodIdentificationType deleteCmd = new AbstractGoodIdentificationTypeCommand.SimpleDeleteGoodIdentificationType();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            GoodIdentificationTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            goodIdentificationTypeApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            GoodIdentificationTypeMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_events/{version}")
    public GoodIdentificationTypeEvent getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            String idObj = id;
            //GoodIdentificationTypeStateEventDtoConverter dtoConverter = getGoodIdentificationTypeStateEventDtoConverter();
            return goodIdentificationTypeApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public GoodIdentificationTypeStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = id;
            GoodIdentificationTypeStateDto.DtoConverter dtoConverter = new GoodIdentificationTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toGoodIdentificationTypeStateDto(goodIdentificationTypeApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  GoodIdentificationTypeStateEventDtoConverter getGoodIdentificationTypeStateEventDtoConverter() {
    //    return new GoodIdentificationTypeStateEventDtoConverter();
    //}

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new GoodIdentificationTypePropertyTypeResolver();
    }

    // ////////////////////////////////

    private class GoodIdentificationTypePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return GoodIdentificationTypeResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class GoodIdentificationTypeResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String id, GoodIdentificationTypeCommand value) {
            String idObj = id;
            if (value.getGoodIdentificationTypeId() == null) {
                value.setGoodIdentificationTypeId(idObj);
            } else if (!value.getGoodIdentificationTypeId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getGoodIdentificationTypeId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            return QueryParamUtils.getQuerySorts(queryNameValuePairs);
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (GoodIdentificationTypeMetadata.aliasMap.containsKey(fieldName)) {
                return GoodIdentificationTypeMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (GoodIdentificationTypeMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = GoodIdentificationTypeMetadata.propertyTypeMap.get(propertyName);
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

        public static GoodIdentificationTypeStateDto[] toGoodIdentificationTypeStateDtoArray(Iterable<String> ids) {
            List<GoodIdentificationTypeStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                GoodIdentificationTypeStateDto dto = new GoodIdentificationTypeStateDto();
                dto.setGoodIdentificationTypeId(id);
                states.add(dto);
            });
            return states.toArray(new GoodIdentificationTypeStateDto[0]);
        }

    }

}

