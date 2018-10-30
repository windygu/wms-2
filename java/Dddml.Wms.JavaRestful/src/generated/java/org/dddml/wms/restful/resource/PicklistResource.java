package org.dddml.wms.restful.resource;

import java.util.*;
import java.util.stream.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.annotation.*;
import org.dddml.wms.domain.picklist.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "Picklists", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class PicklistResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private PicklistApplicationService picklistApplicationService;


    /**
     * 查询.
     * 查询 Picklists
     */
    @GetMapping
    public PicklistStateDto[] getAll(@Specification(value = PicklistStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }

            Iterable<PicklistState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> PicklistResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (PicklistMetadata.aliasMap.containsKey(n) ? PicklistMetadata.aliasMap.get(n) : n));
            states = picklistApplicationService.get(
                c,
                PicklistResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            PicklistStateDto.DtoConverter dtoConverter = new PicklistStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPicklistStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查询.
     * 分页查询 Picklists
     */
    @GetMapping("_page")
    public Page<PicklistStateDto> getPage(@Specification(value = PicklistStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * (size == null ? 20 : size);
            Integer maxResults = (size == null ? 20 : size);
            Iterable<PicklistState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> PicklistResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (PicklistMetadata.aliasMap.containsKey(n) ? PicklistMetadata.aliasMap.get(n) : n));
            states = picklistApplicationService.get(
                c,
                PicklistResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = picklistApplicationService.getCount(c);

            PicklistStateDto.DtoConverter dtoConverter = new PicklistStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<PicklistStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toPicklistStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 Picklist
     */
    @GetMapping("{picklistId}")
    public PicklistStateDto get(@PathVariable("picklistId") String picklistId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = picklistId;
            PicklistState state = picklistApplicationService.get(idObj);
            if (state == null) { return null; }

            PicklistStateDto.DtoConverter dtoConverter = new PicklistStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPicklistStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_count")
    public long getCount(@Specification(value = PicklistStateDto.class) HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSONObject.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap());
            }
            Criterion c = CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (PicklistMetadata.aliasMap.containsKey(n) ? PicklistMetadata.aliasMap.get(n) : n));
            count = picklistApplicationService.getCount(c);
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 新建.
     * 新建 Picklist
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody CreateOrMergePatchPicklistDto.CreatePicklistDto value,  HttpServletResponse response) {
        try {
            PicklistCommand.CreatePicklist cmd = value.toCreatePicklist();
            if (cmd.getPicklistId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "Picklist");
            }
            String idObj = cmd.getPicklistId();
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            picklistApplicationService.when(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 Picklist
     */
    @PutMapping("{picklistId}")
    public void put(@PathVariable("picklistId") String picklistId, @RequestBody CreateOrMergePatchPicklistDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                PicklistCommand.MergePatchPicklist cmd = (PicklistCommand.MergePatchPicklist) value.toCommand();
                PicklistResourceUtils.setNullIdOrThrowOnInconsistentIds(picklistId, cmd);
                cmd.setRequesterId(SecurityContextUtil.getRequesterId());
                picklistApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            PicklistCommand.CreatePicklist cmd = (PicklistCommand.CreatePicklist) value.toCommand();
            PicklistResourceUtils.setNullIdOrThrowOnInconsistentIds(picklistId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            picklistApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 修改.
     * 修改 Picklist
     */
    @PatchMapping("{picklistId}")
    public void patch(@PathVariable("picklistId") String picklistId, @RequestBody CreateOrMergePatchPicklistDto.MergePatchPicklistDto value) {
        try {

            PicklistCommand.MergePatchPicklist cmd = value.toMergePatchPicklist();
            PicklistResourceUtils.setNullIdOrThrowOnInconsistentIds(picklistId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            picklistApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 删除.
     * 删除 Picklist
     */
    @DeleteMapping("{picklistId}")
    public void delete(@PathVariable("picklistId") String picklistId,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            PicklistCommand.DeletePicklist deleteCmd = new AbstractPicklistCommand.SimpleDeletePicklist();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            PicklistResourceUtils.setNullIdOrThrowOnInconsistentIds(picklistId, deleteCmd);
            deleteCmd.setRequesterId(SecurityContextUtil.getRequesterId());
            picklistApplicationService.when(deleteCmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            PicklistMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{picklistId}/_events/{version}")
    public PicklistEvent getStateEvent(@PathVariable("picklistId") String picklistId, @PathVariable("version") long version) {
        try {

            String idObj = picklistId;
            //PicklistStateEventDtoConverter dtoConverter = getPicklistStateEventDtoConverter();
            return picklistApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{picklistId}/_historyStates/{version}")
    public PicklistStateDto getHistoryState(@PathVariable("picklistId") String picklistId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = picklistId;
            PicklistStateDto.DtoConverter dtoConverter = new PicklistStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPicklistStateDto(picklistApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 获取指定 PartyRoleId 的 PicklistRole
     */
    @GetMapping("{picklistId}/PicklistRoles/{partyRoleId}")
    public PicklistRoleStateDto getPicklistRole(@PathVariable("picklistId") String picklistId, @PathVariable("partyRoleId") String partyRoleId) {
        try {

            PicklistRoleState state = picklistApplicationService.getPicklistRole(picklistId, (new AbstractValueObjectTextFormatter<PartyRoleId>(PartyRoleId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(partyRoleId)));
            if (state == null) { return null; }
            PicklistRoleStateDto.DtoConverter dtoConverter = new PicklistRoleStateDto.DtoConverter();
            PicklistRoleStateDto stateDto = dtoConverter.toPicklistRoleStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 创建 or 修改.
     * 创建 or 修改 PicklistRole
     */
    @PutMapping(path = "{picklistId}/PicklistRoles/{partyRoleId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putPicklistRole(@PathVariable("picklistId") String picklistId, @PathVariable("partyRoleId") String partyRoleId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchPicklistRoleDto.MergePatchPicklistRoleDto body) {
        try {
            PicklistCommand.MergePatchPicklist mergePatchPicklist = new AbstractPicklistCommand.SimpleMergePatchPicklist();
            mergePatchPicklist.setPicklistId(picklistId);
            mergePatchPicklist.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchPicklist.setVersion(version); }
            mergePatchPicklist.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            PicklistRoleCommand.MergePatchPicklistRole mergePatchPicklistRole = body.toMergePatchPicklistRole();
            mergePatchPicklistRole.setPartyRoleId((new AbstractValueObjectTextFormatter<PartyRoleId>(PartyRoleId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(partyRoleId)));
            mergePatchPicklist.getPicklistRoleCommands().add(mergePatchPicklistRole);
            mergePatchPicklist.setRequesterId(SecurityContextUtil.getRequesterId());
            picklistApplicationService.when(mergePatchPicklist);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 移除.
     * 移除 PicklistRole
     */
    @DeleteMapping("{picklistId}/PicklistRoles/{partyRoleId}")
    public void deletePicklistRole(@PathVariable("picklistId") String picklistId, @PathVariable("partyRoleId") String partyRoleId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            PicklistCommand.MergePatchPicklist mergePatchPicklist = new AbstractPicklistCommand.SimpleMergePatchPicklist();
            mergePatchPicklist.setPicklistId(picklistId);
            mergePatchPicklist.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { 
                mergePatchPicklist.setVersion(version); 
            } else {
                mergePatchPicklist.setVersion(picklistApplicationService.get(picklistId).getVersion());
            }
            mergePatchPicklist.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            PicklistRoleCommand.RemovePicklistRole removePicklistRole = new AbstractPicklistRoleCommand.SimpleRemovePicklistRole();
            removePicklistRole.setPartyRoleId((new AbstractValueObjectTextFormatter<PartyRoleId>(PartyRoleId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(partyRoleId)));
            mergePatchPicklist.getPicklistRoleCommands().add(removePicklistRole);
            mergePatchPicklist.setRequesterId(SecurityContextUtil.getRequesterId());
            picklistApplicationService.when(mergePatchPicklist);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * PicklistRole List
     */
    @GetMapping("{picklistId}/PicklistRoles")
    public PicklistRoleStateDto[] getPicklistRoles(@PathVariable("picklistId") String picklistId,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "filter", required = false) String filter,
                    @Specification(value = PicklistRoleStateDto.class) HttpServletRequest request) {
        try {
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> PicklistResourceUtils.getPicklistRoleFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (PicklistRoleMetadata.aliasMap.containsKey(n) ? PicklistRoleMetadata.aliasMap.get(n) : n));
            Iterable<PicklistRoleState> states = picklistApplicationService.getPicklistRoles(picklistId, c,
                    PicklistResourceUtils.getPicklistRoleQuerySorts(request.getParameterMap()));
            if (states == null) { return null; }
            PicklistRoleStateDto.DtoConverter dtoConverter = new PicklistRoleStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPicklistRoleStateDtoArray(states);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 新建.
     * 新建 PicklistRole
     */
    @PostMapping(path = "{picklistId}/PicklistRoles", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postPicklistRoles(@PathVariable("picklistId") String picklistId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchPicklistRoleDto.CreatePicklistRoleDto body) {
        try {
            PicklistCommand.MergePatchPicklist mergePatchPicklist = new AbstractPicklistCommand.SimpleMergePatchPicklist();
            mergePatchPicklist.setPicklistId(picklistId);
            mergePatchPicklist.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchPicklist.setVersion(version); }
            mergePatchPicklist.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            PicklistRoleCommand.CreatePicklistRole createPicklistRole = body.toCreatePicklistRole();
            mergePatchPicklist.getPicklistRoleCommands().add(createPicklistRole);
            mergePatchPicklist.setRequesterId(SecurityContextUtil.getRequesterId());
            picklistApplicationService.when(mergePatchPicklist);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    //protected  PicklistStateEventDtoConverter getPicklistStateEventDtoConverter() {
    //    return new PicklistStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return PicklistResourceUtils.getFilterPropertyType(propertyName);
            }
        };
    }

    protected PropertyTypeResolver getPicklistRolePropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return PicklistResourceUtils.getPicklistRoleFilterPropertyType(propertyName);
            }
        };
    }

    // ////////////////////////////////
 
    public static class PicklistResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String picklistId, PicklistCommand value) {
            String idObj = picklistId;
            if (value.getPicklistId() == null) {
                value.setPicklistId(idObj);
            } else if (!value.getPicklistId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", picklistId, value.getPicklistId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, PicklistMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, PicklistMetadata.aliasMap);
        }

        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (PicklistMetadata.aliasMap.containsKey(fieldName)) {
                return PicklistMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (PicklistMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = PicklistMetadata.propertyTypeMap.get(propertyName);
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

        public static List<String> getPicklistRoleQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, PicklistRoleMetadata.aliasMap);
        }

        public static List<String> getPicklistRoleQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, PicklistRoleMetadata.aliasMap);
        }

        public static String getPicklistRoleFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (PicklistRoleMetadata.aliasMap.containsKey(fieldName)) {
                return PicklistRoleMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getPicklistRoleFilterPropertyType(String propertyName) {
            if (PicklistRoleMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = PicklistRoleMetadata.propertyTypeMap.get(propertyName);
                if (!StringHelper.isNullOrEmpty(propertyType)) {
                    if (org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.containsKey(propertyType)) {
                        return org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.get(propertyType);
                    }
                }
            }
            return String.class;
        }

        public static Iterable<Map.Entry<String, Object>> getPicklistRoleQueryFilterMap(Map<String, String[]> queryNameValuePairs) {
            Map<String, Object> filter = new HashMap<>();
            queryNameValuePairs.forEach((key, values) -> {
                if (values.length > 0) {
                    String pName = getPicklistRoleFilterPropertyName(key);
                    if (!StringHelper.isNullOrEmpty(pName)) {
                        Class pClass = getPicklistRoleFilterPropertyType(pName);
                        filter.put(pName, ApplicationContext.current.getTypeConverter().convertFromString(pClass, values[0]));
                    }
                }
            });
            return filter.entrySet();
        }

        public static PicklistStateDto[] toPicklistStateDtoArray(Iterable<String> ids) {
            List<PicklistStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                PicklistStateDto dto = new PicklistStateDto();
                dto.setPicklistId(i);
                states.add(dto);
            });
            return states.toArray(new PicklistStateDto[0]);
        }

    }

}

