package org.dddml.wms.restful.resource;

import java.util.*;
import java.util.stream.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.picklistbin.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "PicklistBins", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class PicklistBinResource {


    @Autowired
    private PicklistBinApplicationService picklistBinApplicationService;


    /**
     * 查询.
     * 查询 PicklistBins
     */
    @GetMapping
    public PicklistBinStateDto[] getAll( HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<PicklistBinState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> PicklistBinResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (PicklistBinMetadata.aliasMap.containsKey(n) ? PicklistBinMetadata.aliasMap.get(n) : n));
            states = picklistBinApplicationService.get(
                c,
                PicklistBinResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            PicklistBinStateDto.DtoConverter dtoConverter = new PicklistBinStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPicklistBinStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查询.
     * 分页查询 PicklistBins
     */
    @GetMapping("_page")
    public Page<PicklistBinStateDto> getPage( HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<PicklistBinState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> PicklistBinResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (PicklistBinMetadata.aliasMap.containsKey(n) ? PicklistBinMetadata.aliasMap.get(n) : n));
            states = picklistBinApplicationService.get(
                c,
                PicklistBinResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = picklistBinApplicationService.getCount(c);

            PicklistBinStateDto.DtoConverter dtoConverter = new PicklistBinStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<PicklistBinStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toPicklistBinStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            statePage.setTotalElements(count);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 PicklistBin
     */
    @GetMapping("{picklistBinId}")
    public PicklistBinStateDto get(@PathVariable("picklistBinId") String picklistBinId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = picklistBinId;
            PicklistBinState state = picklistBinApplicationService.get(idObj);
            if (state == null) { return null; }

            PicklistBinStateDto.DtoConverter dtoConverter = new PicklistBinStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPicklistBinStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSONObject.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap());
            }
            count = picklistBinApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (PicklistBinMetadata.aliasMap.containsKey(n) ? PicklistBinMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 新建.
     * 新建 PicklistBin
     */
    @PostMapping
    public String post(@RequestBody CreateOrMergePatchPicklistBinDto.CreatePicklistBinDto value,  HttpServletResponse response) {
        try {
            PicklistBinCommand.CreatePicklistBin cmd = value.toCreatePicklistBin();
            if (cmd.getPicklistBinId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "PicklistBin");
            }
            picklistBinApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getPicklistBinId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 PicklistBin
     */
    @PutMapping("{picklistBinId}")
    public void put(@PathVariable("picklistBinId") String picklistBinId, @RequestBody CreateOrMergePatchPicklistBinDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                PicklistBinCommand.MergePatchPicklistBin cmd = (PicklistBinCommand.MergePatchPicklistBin) value.toCommand();
                PicklistBinResourceUtils.setNullIdOrThrowOnInconsistentIds(picklistBinId, cmd);
                picklistBinApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            PicklistBinCommand.CreatePicklistBin cmd = (PicklistBinCommand.CreatePicklistBin) value.toCommand();
            PicklistBinResourceUtils.setNullIdOrThrowOnInconsistentIds(picklistBinId, cmd);
            picklistBinApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 修改.
     * 修改 PicklistBin
     */
    @PatchMapping("{picklistBinId}")
    public void patch(@PathVariable("picklistBinId") String picklistBinId, @RequestBody CreateOrMergePatchPicklistBinDto.MergePatchPicklistBinDto value) {
        try {

            PicklistBinCommand.MergePatchPicklistBin cmd = value.toMergePatchPicklistBin();
            PicklistBinResourceUtils.setNullIdOrThrowOnInconsistentIds(picklistBinId, cmd);
            picklistBinApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 删除.
     * 删除 PicklistBin
     */
    @DeleteMapping("{picklistBinId}")
    public void delete(@PathVariable("picklistBinId") String picklistBinId,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            PicklistBinCommand.DeletePicklistBin deleteCmd = new AbstractPicklistBinCommand.SimpleDeletePicklistBin();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            PicklistBinResourceUtils.setNullIdOrThrowOnInconsistentIds(picklistBinId, deleteCmd);
            picklistBinApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            PicklistBinMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{picklistBinId}/_events/{version}")
    public PicklistBinEvent getStateEvent(@PathVariable("picklistBinId") String picklistBinId, @PathVariable("version") long version) {
        try {

            String idObj = picklistBinId;
            //PicklistBinStateEventDtoConverter dtoConverter = getPicklistBinStateEventDtoConverter();
            return picklistBinApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{picklistBinId}/_historyStates/{version}")
    public PicklistBinStateDto getHistoryState(@PathVariable("picklistBinId") String picklistBinId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = picklistBinId;
            PicklistBinStateDto.DtoConverter dtoConverter = new PicklistBinStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPicklistBinStateDto(picklistBinApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 获取指定 PicklistItemOrderShipGrpInvId 的 PicklistItem
     */
    @GetMapping("{picklistBinId}/PicklistItems/{picklistItemOrderShipGrpInvId}")
    public PicklistItemStateDto getPicklistItem(@PathVariable("picklistBinId") String picklistBinId, @PathVariable("picklistItemOrderShipGrpInvId") String picklistItemOrderShipGrpInvId) {
        try {

            PicklistItemState state = picklistBinApplicationService.getPicklistItem(picklistBinId, (new AbstractValueObjectTextFormatter<PicklistItemOrderShipGrpInvId>(PicklistItemOrderShipGrpInvId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(picklistItemOrderShipGrpInvId)));
            if (state == null) { return null; }
            PicklistItemStateDto.DtoConverter dtoConverter = new PicklistItemStateDto.DtoConverter();
            PicklistItemStateDto stateDto = dtoConverter.toPicklistItemStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 创建 or 修改.
     * 创建 or 修改 PicklistItem
     */
    @PutMapping("{picklistBinId}/PicklistItems/{picklistItemOrderShipGrpInvId}")
    public void putPicklistItem(@PathVariable("picklistBinId") String picklistBinId, @PathVariable("picklistItemOrderShipGrpInvId") String picklistItemOrderShipGrpInvId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchPicklistItemDto.MergePatchPicklistItemDto body) {
        try {
            PicklistBinCommand.MergePatchPicklistBin mergePatchPicklistBin = new AbstractPicklistBinCommand.SimpleMergePatchPicklistBin();
            mergePatchPicklistBin.setPicklistBinId(picklistBinId);
            mergePatchPicklistBin.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchPicklistBin.setVersion(version); }
            mergePatchPicklistBin.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            PicklistItemCommand.MergePatchPicklistItem mergePatchPicklistItem = body.toMergePatchPicklistItem();
            mergePatchPicklistItem.setPicklistItemOrderShipGrpInvId((new AbstractValueObjectTextFormatter<PicklistItemOrderShipGrpInvId>(PicklistItemOrderShipGrpInvId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(picklistItemOrderShipGrpInvId)));
            mergePatchPicklistBin.getPicklistItemCommands().add(mergePatchPicklistItem);
            picklistBinApplicationService.when(mergePatchPicklistBin);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 移除.
     * 移除 PicklistItem
     */
    @DeleteMapping("{picklistBinId}/PicklistItems/{picklistItemOrderShipGrpInvId}")
    public void deletePicklistItem(@PathVariable("picklistBinId") String picklistBinId, @PathVariable("picklistItemOrderShipGrpInvId") String picklistItemOrderShipGrpInvId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            PicklistBinCommand.MergePatchPicklistBin mergePatchPicklistBin = new AbstractPicklistBinCommand.SimpleMergePatchPicklistBin();
            mergePatchPicklistBin.setPicklistBinId(picklistBinId);
            mergePatchPicklistBin.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchPicklistBin.setVersion(version); }
            mergePatchPicklistBin.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            PicklistItemCommand.RemovePicklistItem removePicklistItem = new AbstractPicklistItemCommand.SimpleRemovePicklistItem();
            removePicklistItem.setPicklistItemOrderShipGrpInvId((new AbstractValueObjectTextFormatter<PicklistItemOrderShipGrpInvId>(PicklistItemOrderShipGrpInvId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(picklistItemOrderShipGrpInvId)));
            mergePatchPicklistBin.getPicklistItemCommands().add(removePicklistItem);
            picklistBinApplicationService.when(mergePatchPicklistBin);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * PicklistItem List
     */
    @GetMapping("{picklistBinId}/PicklistItems/")
    public PicklistItemStateDto[] getPicklistItems(@PathVariable("picklistBinId") String picklistBinId) {
        try {
            Iterable<PicklistItemState> states = picklistBinApplicationService.getPicklistItems(picklistBinId);
            if (states == null) { return null; }
            PicklistItemStateDto.DtoConverter dtoConverter = new PicklistItemStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toPicklistItemStateDtoArray(states);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 新建.
     * 新建 PicklistItem
     */
    @PostMapping("{picklistBinId}/PicklistItems/")
    public void postPicklistItems(@PathVariable("picklistBinId") String picklistBinId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchPicklistItemDto.CreatePicklistItemDto body) {
        try {
            PicklistBinCommand.MergePatchPicklistBin mergePatchPicklistBin = new AbstractPicklistBinCommand.SimpleMergePatchPicklistBin();
            mergePatchPicklistBin.setPicklistBinId(picklistBinId);
            mergePatchPicklistBin.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchPicklistBin.setVersion(version); }
            mergePatchPicklistBin.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            PicklistItemCommand.CreatePicklistItem createPicklistItem = body.toCreatePicklistItem();
            mergePatchPicklistBin.getPicklistItemCommands().add(createPicklistItem);
            picklistBinApplicationService.when(mergePatchPicklistBin);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  PicklistBinStateEventDtoConverter getPicklistBinStateEventDtoConverter() {
    //    return new PicklistBinStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PicklistBinPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class PicklistBinPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return PicklistBinResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class PicklistBinResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String picklistBinId, PicklistBinCommand value) {
            String idObj = picklistBinId;
            if (value.getPicklistBinId() == null) {
                value.setPicklistBinId(idObj);
            } else if (!value.getPicklistBinId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", picklistBinId, value.getPicklistBinId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, PicklistBinMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, PicklistBinMetadata.aliasMap);
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (PicklistBinMetadata.aliasMap.containsKey(fieldName)) {
                return PicklistBinMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (PicklistBinMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = PicklistBinMetadata.propertyTypeMap.get(propertyName);
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

        public static PicklistBinStateDto[] toPicklistBinStateDtoArray(Iterable<String> ids) {
            List<PicklistBinStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                PicklistBinStateDto dto = new PicklistBinStateDto();
                dto.setPicklistBinId(i);
                states.add(dto);
            });
            return states.toArray(new PicklistBinStateDto[0]);
        }

    }

}

