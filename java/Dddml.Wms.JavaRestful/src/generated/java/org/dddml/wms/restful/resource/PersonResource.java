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
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.annotation.*;
import org.dddml.wms.domain.party.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "People", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class PersonResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private PartyApplicationService partyApplicationService;


    /**
     * 查询.
     * 查询 People
     */
    @GetMapping
    public PartyStateDto[] getAll(@Specification(value = PartyStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }

            Iterable<PartyState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> PersonResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (PartyMetadata.aliasMap.containsKey(n) ? PartyMetadata.aliasMap.get(n) : n));
            states = partyApplicationService.get(PersonState.class, 
                c,
                PersonResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            PartyStateDto.DtoConverter dtoConverter = new PartyStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPartyStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查询.
     * 分页查询 People
     */
    @GetMapping("_page")
    public Page<PartyStateDto> getPage(@Specification(value = PartyStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<PartyState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> PersonResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (PartyMetadata.aliasMap.containsKey(n) ? PartyMetadata.aliasMap.get(n) : n));
            states = partyApplicationService.get(PersonState.class, 
                c,
                PersonResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = partyApplicationService.getCount(c);

            PartyStateDto.DtoConverter dtoConverter = new PartyStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<PartyStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toPartyStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 Party
     */
    @GetMapping("{partyId}")
    public PartyStateDto get(@PathVariable("partyId") String partyId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = partyId;
            PartyState state = partyApplicationService.get(idObj);
            if (state == null) { return null; }

            if (state != null && !PersonState.class.isAssignableFrom(state.getClass())) {
                return null;
            }
            if (state != null && !(PartyTypeIds.PERSON.equals(state.getPartyTypeId()))) {
                return null;
            }
            PartyStateDto.DtoConverter dtoConverter = new PartyStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPartyStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_count")
    public long getCount(@Specification(value = PartyStateDto.class) HttpServletRequest request,
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
                n -> (PartyMetadata.aliasMap.containsKey(n) ? PartyMetadata.aliasMap.get(n) : n));
            count = partyApplicationService.getCount(PersonState.class, c);
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 新建.
     * 新建 Party
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody CreateOrMergePatchPartyDto.CreatePartyDto value,  HttpServletResponse response) {
        try {
            value.setPartyTypeId(PartyTypeIds.PERSON);
            PartyCommand.CreateParty cmd = value.toCreateParty();
            if (cmd.getPartyId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "Party");
            }
            String idObj = cmd.getPartyId();
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            partyApplicationService.when(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 Party
     */
    @PutMapping("{partyId}")
    public void put(@PathVariable("partyId") String partyId, @RequestBody CreateOrMergePatchPartyDto value) {
        try {
            value.setPartyTypeId(PartyTypeIds.PERSON);
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                PartyCommand.MergePatchParty cmd = (PartyCommand.MergePatchParty) value.toCommand();
                PersonResourceUtils.setNullIdOrThrowOnInconsistentIds(partyId, cmd);
                cmd.setRequesterId(SecurityContextUtil.getRequesterId());
                partyApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            PartyCommand.CreateParty cmd = (PartyCommand.CreateParty) value.toCommand();
            PersonResourceUtils.setNullIdOrThrowOnInconsistentIds(partyId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            partyApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 修改.
     * 修改 Party
     */
    @PatchMapping("{partyId}")
    public void patch(@PathVariable("partyId") String partyId, @RequestBody CreateOrMergePatchPartyDto.MergePatchPartyDto value) {
        try {

            value.setPartyTypeId(PartyTypeIds.PERSON);
            PartyCommand.MergePatchParty cmd = value.toMergePatchParty();
            PersonResourceUtils.setNullIdOrThrowOnInconsistentIds(partyId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            partyApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 删除.
     * 删除 Party
     */
    @DeleteMapping("{partyId}")
    public void delete(@PathVariable("partyId") String partyId,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            PartyCommand.DeleteParty deleteCmd = new AbstractPartyCommand.SimpleDeleteParty();
            deleteCmd.setPartyTypeId(PartyTypeIds.PERSON);

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            PersonResourceUtils.setNullIdOrThrowOnInconsistentIds(partyId, deleteCmd);
            deleteCmd.setRequesterId(SecurityContextUtil.getRequesterId());
            partyApplicationService.when(deleteCmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            PartyMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{partyId}/_events/{version}")
    public PartyEvent getStateEvent(@PathVariable("partyId") String partyId, @PathVariable("version") long version) {
        try {

            String idObj = partyId;
            //PartyStateEventDtoConverter dtoConverter = getPartyStateEventDtoConverter();
            return partyApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{partyId}/_historyStates/{version}")
    public PartyStateDto getHistoryState(@PathVariable("partyId") String partyId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = partyId;
            PartyStateDto.DtoConverter dtoConverter = new PartyStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPartyStateDto(partyApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    //protected  PartyStateEventDtoConverter getPartyStateEventDtoConverter() {
    //    return new PartyStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return PersonResourceUtils.getFilterPropertyType(propertyName);
            }
        };
    }

    // ////////////////////////////////
 
    public static class PersonResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String partyId, PartyCommand value) {
            String idObj = partyId;
            if (value.getPartyId() == null) {
                value.setPartyId(idObj);
            } else if (!value.getPartyId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", partyId, value.getPartyId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, PartyMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, PartyMetadata.aliasMap);
        }

        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (PartyMetadata.aliasMap.containsKey(fieldName)) {
                return PartyMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (PartyMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = PartyMetadata.propertyTypeMap.get(propertyName);
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

        public static PersonStateDto[] toPersonStateDtoArray(Iterable<String> ids) {
            List<PersonStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                PersonStateDto dto = new PersonStateDto();
                dto.setPartyId(i);
                states.add(dto);
            });
            return states.toArray(new PersonStateDto[0]);
        }

    }

}

