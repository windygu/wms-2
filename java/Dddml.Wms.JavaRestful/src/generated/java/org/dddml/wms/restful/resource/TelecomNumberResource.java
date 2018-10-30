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
import org.dddml.wms.domain.contactmech.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "TelecomNumbers", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class TelecomNumberResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private ContactMechApplicationService contactMechApplicationService;


    /**
     * 查询.
     * 查询 TelecomNumbers
     */
    @GetMapping
    public ContactMechStateDto[] getAll(@Specification(value = ContactMechStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }

            Iterable<ContactMechState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> TelecomNumberResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (ContactMechMetadata.aliasMap.containsKey(n) ? ContactMechMetadata.aliasMap.get(n) : n));
            c = Restrictions.and(c, Restrictions.eq("ContactMechTypeId", ContactMechTypeId.TELECOM_NUMBER));
            states = contactMechApplicationService.get(
                c,
                TelecomNumberResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            ContactMechStateDto.DtoConverter dtoConverter = new ContactMechStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toContactMechStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查询.
     * 分页查询 TelecomNumbers
     */
    @GetMapping("_page")
    public Page<ContactMechStateDto> getPage(@Specification(value = ContactMechStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * (size == null ? 20 : size);
            Integer maxResults = (size == null ? 20 : size);
            Iterable<ContactMechState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> TelecomNumberResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (ContactMechMetadata.aliasMap.containsKey(n) ? ContactMechMetadata.aliasMap.get(n) : n));
            c = Restrictions.and(c, Restrictions.eq("ContactMechTypeId", ContactMechTypeId.TELECOM_NUMBER));
            states = contactMechApplicationService.get(
                c,
                TelecomNumberResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = contactMechApplicationService.getCount(c);

            ContactMechStateDto.DtoConverter dtoConverter = new ContactMechStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<ContactMechStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toContactMechStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 ContactMech
     */
    @GetMapping("{contactMechId}")
    public ContactMechStateDto get(@PathVariable("contactMechId") String contactMechId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = contactMechId;
            ContactMechState state = contactMechApplicationService.get(idObj);
            if (state == null) { return null; }

            if (state != null && !(ContactMechTypeId.TELECOM_NUMBER.equals(state.getContactMechTypeId()))) {
                return null;
            }
            ContactMechStateDto.DtoConverter dtoConverter = new ContactMechStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toContactMechStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_count")
    public long getCount(@Specification(value = ContactMechStateDto.class) HttpServletRequest request,
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
                n -> (ContactMechMetadata.aliasMap.containsKey(n) ? ContactMechMetadata.aliasMap.get(n) : n));
            c = Restrictions.and(c, Restrictions.eq("ContactMechTypeId", ContactMechTypeId.TELECOM_NUMBER));
            count = contactMechApplicationService.getCount(c);
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 新建.
     * 新建 ContactMech
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody CreateOrMergePatchContactMechDto.CreateContactMechDto value,  HttpServletResponse response) {
        try {
            value.setContactMechTypeId(ContactMechTypeId.TELECOM_NUMBER);
            ContactMechCommand.CreateContactMech cmd = value.toCreateContactMech();
            if (cmd.getContactMechId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "ContactMech");
            }
            String idObj = cmd.getContactMechId();
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            contactMechApplicationService.when(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 ContactMech
     */
    @PutMapping("{contactMechId}")
    public void put(@PathVariable("contactMechId") String contactMechId, @RequestBody CreateOrMergePatchContactMechDto value) {
        try {
            value.setContactMechTypeId(ContactMechTypeId.TELECOM_NUMBER);
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                ContactMechCommand.MergePatchContactMech cmd = (ContactMechCommand.MergePatchContactMech) value.toCommand();
                TelecomNumberResourceUtils.setNullIdOrThrowOnInconsistentIds(contactMechId, cmd);
                cmd.setRequesterId(SecurityContextUtil.getRequesterId());
                contactMechApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            ContactMechCommand.CreateContactMech cmd = (ContactMechCommand.CreateContactMech) value.toCommand();
            TelecomNumberResourceUtils.setNullIdOrThrowOnInconsistentIds(contactMechId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            contactMechApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 修改.
     * 修改 ContactMech
     */
    @PatchMapping("{contactMechId}")
    public void patch(@PathVariable("contactMechId") String contactMechId, @RequestBody CreateOrMergePatchContactMechDto.MergePatchContactMechDto value) {
        try {

            value.setContactMechTypeId(ContactMechTypeId.TELECOM_NUMBER);
            ContactMechCommand.MergePatchContactMech cmd = value.toMergePatchContactMech();
            TelecomNumberResourceUtils.setNullIdOrThrowOnInconsistentIds(contactMechId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            contactMechApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 删除.
     * 删除 ContactMech
     */
    @DeleteMapping("{contactMechId}")
    public void delete(@PathVariable("contactMechId") String contactMechId,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            ContactMechCommand.DeleteContactMech deleteCmd = new AbstractContactMechCommand.SimpleDeleteContactMech();
            deleteCmd.setContactMechTypeId(ContactMechTypeId.TELECOM_NUMBER);

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            TelecomNumberResourceUtils.setNullIdOrThrowOnInconsistentIds(contactMechId, deleteCmd);
            deleteCmd.setRequesterId(SecurityContextUtil.getRequesterId());
            contactMechApplicationService.when(deleteCmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            ContactMechMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{contactMechId}/_events/{version}")
    public ContactMechEvent getStateEvent(@PathVariable("contactMechId") String contactMechId, @PathVariable("version") long version) {
        try {

            String idObj = contactMechId;
            //ContactMechStateEventDtoConverter dtoConverter = getContactMechStateEventDtoConverter();
            return contactMechApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{contactMechId}/_historyStates/{version}")
    public ContactMechStateDto getHistoryState(@PathVariable("contactMechId") String contactMechId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = contactMechId;
            ContactMechStateDto.DtoConverter dtoConverter = new ContactMechStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toContactMechStateDto(contactMechApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    //protected  ContactMechStateEventDtoConverter getContactMechStateEventDtoConverter() {
    //    return new ContactMechStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return TelecomNumberResourceUtils.getFilterPropertyType(propertyName);
            }
        };
    }

    // ////////////////////////////////
 
    public static class TelecomNumberResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String contactMechId, ContactMechCommand value) {
            String idObj = contactMechId;
            if (value.getContactMechId() == null) {
                value.setContactMechId(idObj);
            } else if (!value.getContactMechId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", contactMechId, value.getContactMechId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, ContactMechMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, ContactMechMetadata.aliasMap);
        }

        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (ContactMechMetadata.aliasMap.containsKey(fieldName)) {
                return ContactMechMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (ContactMechMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = ContactMechMetadata.propertyTypeMap.get(propertyName);
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

    }

}

