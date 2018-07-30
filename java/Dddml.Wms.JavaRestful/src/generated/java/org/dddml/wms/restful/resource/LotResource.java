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
import org.dddml.wms.domain.lot.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "Lots", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class LotResource {


    @Autowired
    private LotApplicationService lotApplicationService;


    @GetMapping
    public LotStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<LotState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = lotApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (LotMetadata.aliasMap.containsKey(n) ? LotMetadata.aliasMap.get(n) : n)),
                        LotResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = lotApplicationService.get(
                        LotResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        LotResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            LotStateDto.DtoConverter dtoConverter = new LotStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toLotStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_page")
    public Page<LotStateDto> getPage( HttpServletRequest request,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "page", defaultValue = "0") Integer page,
                                   @RequestParam(value = "size", required = false) @NotNull Integer size) {
        try {
            List<String> sort = LotResourceUtils.getQuerySorts(request.getParameterMap());
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<LotState> states = null; 
            Iterable<Map.Entry<String, Object>> queryFilterMap = LotResourceUtils.getQueryFilterMap(request.getParameterMap());
            states = lotApplicationService.get(
                        queryFilterMap,
                        LotResourceUtils.getQuerySorts(request.getParameterMap()),
                        firstResult, maxResults);
            long count = lotApplicationService.getCount(queryFilterMap);

            LotStateDto.DtoConverter dtoConverter = new LotStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<LotStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toLotStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public LotStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = id;
            LotState state = lotApplicationService.get(idObj);
            if (state == null) { return null; }

            LotStateDto.DtoConverter dtoConverter = new LotStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toLotStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = lotApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (LotMetadata.aliasMap.containsKey(n) ? LotMetadata.aliasMap.get(n) : n)));
            } else {
                count = lotApplicationService.getCount(LotResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public String post(@RequestBody CreateOrMergePatchLotDto.CreateLotDto value,  HttpServletResponse response) {
        try {
            LotCommand.CreateLot cmd = value.toCreateLot();
            if (cmd.getLotId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "Lot");
            }
            lotApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getLotId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchLotDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                LotCommand.MergePatchLot cmd = (LotCommand.MergePatchLot) value.toCommand();
                LotResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                lotApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            LotCommand.CreateLot cmd = (LotCommand.CreateLot) value.toCommand();
            LotResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            lotApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchLotDto.MergePatchLotDto value) {
        try {

            LotCommand.MergePatchLot cmd = value.toMergePatchLot();
            LotResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            lotApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            LotCommand.DeleteLot deleteCmd = new AbstractLotCommand.SimpleDeleteLot();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            LotResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            lotApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            LotMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_events/{version}")
    public LotEvent getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            String idObj = id;
            //LotStateEventDtoConverter dtoConverter = getLotStateEventDtoConverter();
            return lotApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public LotStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = id;
            LotStateDto.DtoConverter dtoConverter = new LotStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toLotStateDto(lotApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  LotStateEventDtoConverter getLotStateEventDtoConverter() {
    //    return new LotStateEventDtoConverter();
    //}

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new LotPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class LotPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return LotResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class LotResourceUtils {

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

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            List<String> sorts = new ArrayList<>();
            if (values == null) {
                return null;
            }
            if (values.length == 1
                    && !values[0].toLowerCase().endsWith(",asc")
                    && !values[0].toLowerCase().endsWith(",desc")) {
                return getQueryOrders(values[0], ",");
            }
            Arrays.stream(values).forEach(s -> {
                if (s.toLowerCase().endsWith(",asc")) {
                    String f = s.substring(0, s.length() - 4).trim();
                    if (!f.isEmpty()) {
                        sorts.add(f);
                    }
                } else if (s.toLowerCase().endsWith(",desc")) {
                    String f = s.substring(0, s.length() - 5).trim();
                    if (!f.isEmpty()) {
                        sorts.add("-" + f);
                    }
                } else {
                    String f = s.trim();
                    if (!f.isEmpty()) {
                        sorts.add(f);
                    }
                }
            });
            return sorts;
        }

        public static void setNullIdOrThrowOnInconsistentIds(String id, LotCommand value) {
            String idObj = id;
            if (value.getLotId() == null) {
                value.setLotId(idObj);
            } else if (!value.getLotId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getLotId());
            }
        }
    


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (LotMetadata.aliasMap.containsKey(fieldName)) {
                return LotMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (LotMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = LotMetadata.propertyTypeMap.get(propertyName);
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

        public static LotStateDto[] toLotStateDtoArray(Iterable<String> ids) {
            List<LotStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                LotStateDto dto = new LotStateDto();
                dto.setLotId(id);
                states.add(dto);
            });
            return states.toArray(new LotStateDto[0]);
        }

    }

}

