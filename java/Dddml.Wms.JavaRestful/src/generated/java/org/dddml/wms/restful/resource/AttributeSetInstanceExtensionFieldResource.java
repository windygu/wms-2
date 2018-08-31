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
import org.dddml.wms.domain.attributesetinstanceextensionfield.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "AttributeSetInstanceExtensionFields", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class AttributeSetInstanceExtensionFieldResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private AttributeSetInstanceExtensionFieldApplicationService attributeSetInstanceExtensionFieldApplicationService;


    /**
     * 查询.
     * 查询 AttributeSetInstanceExtensionFields
     */
    @GetMapping
    public AttributeSetInstanceExtensionFieldStateDto[] getAll(@Specification(value = AttributeSetInstanceExtensionFieldStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }

            Iterable<AttributeSetInstanceExtensionFieldState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> AttributeSetInstanceExtensionFieldResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (AttributeSetInstanceExtensionFieldMetadata.aliasMap.containsKey(n) ? AttributeSetInstanceExtensionFieldMetadata.aliasMap.get(n) : n));
            states = attributeSetInstanceExtensionFieldApplicationService.get(
                c,
                AttributeSetInstanceExtensionFieldResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            AttributeSetInstanceExtensionFieldStateDto.DtoConverter dtoConverter = new AttributeSetInstanceExtensionFieldStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeSetInstanceExtensionFieldStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查询.
     * 分页查询 AttributeSetInstanceExtensionFields
     */
    @GetMapping("_page")
    public Page<AttributeSetInstanceExtensionFieldStateDto> getPage(@Specification(value = AttributeSetInstanceExtensionFieldStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<AttributeSetInstanceExtensionFieldState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> AttributeSetInstanceExtensionFieldResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (AttributeSetInstanceExtensionFieldMetadata.aliasMap.containsKey(n) ? AttributeSetInstanceExtensionFieldMetadata.aliasMap.get(n) : n));
            states = attributeSetInstanceExtensionFieldApplicationService.get(
                c,
                AttributeSetInstanceExtensionFieldResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = attributeSetInstanceExtensionFieldApplicationService.getCount(c);

            AttributeSetInstanceExtensionFieldStateDto.DtoConverter dtoConverter = new AttributeSetInstanceExtensionFieldStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<AttributeSetInstanceExtensionFieldStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toAttributeSetInstanceExtensionFieldStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 AttributeSetInstanceExtensionField
     */
    @GetMapping("{name}")
    public AttributeSetInstanceExtensionFieldStateDto get(@PathVariable("name") String name, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = name;
            AttributeSetInstanceExtensionFieldState state = attributeSetInstanceExtensionFieldApplicationService.get(idObj);
            if (state == null) { return null; }

            AttributeSetInstanceExtensionFieldStateDto.DtoConverter dtoConverter = new AttributeSetInstanceExtensionFieldStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeSetInstanceExtensionFieldStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_count")
    public long getCount(@Specification(value = AttributeSetInstanceExtensionFieldStateDto.class) HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSONObject.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap());
            }
            count = attributeSetInstanceExtensionFieldApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (AttributeSetInstanceExtensionFieldMetadata.aliasMap.containsKey(n) ? AttributeSetInstanceExtensionFieldMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 新建.
     * 新建 AttributeSetInstanceExtensionField
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody CreateOrMergePatchAttributeSetInstanceExtensionFieldDto.CreateAttributeSetInstanceExtensionFieldDto value,  HttpServletResponse response) {
        try {
            AttributeSetInstanceExtensionFieldCommand.CreateAttributeSetInstanceExtensionField cmd = value.toCreateAttributeSetInstanceExtensionField();
            if (cmd.getName() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "AttributeSetInstanceExtensionField");
            }
            String idObj = cmd.getName();
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            attributeSetInstanceExtensionFieldApplicationService.when(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 AttributeSetInstanceExtensionField
     */
    @PutMapping("{name}")
    public void put(@PathVariable("name") String name, @RequestBody CreateOrMergePatchAttributeSetInstanceExtensionFieldDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                AttributeSetInstanceExtensionFieldCommand.MergePatchAttributeSetInstanceExtensionField cmd = (AttributeSetInstanceExtensionFieldCommand.MergePatchAttributeSetInstanceExtensionField) value.toCommand();
                AttributeSetInstanceExtensionFieldResourceUtils.setNullIdOrThrowOnInconsistentIds(name, cmd);
                cmd.setRequesterId(SecurityContextUtil.getRequesterId());
                attributeSetInstanceExtensionFieldApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            AttributeSetInstanceExtensionFieldCommand.CreateAttributeSetInstanceExtensionField cmd = (AttributeSetInstanceExtensionFieldCommand.CreateAttributeSetInstanceExtensionField) value.toCommand();
            AttributeSetInstanceExtensionFieldResourceUtils.setNullIdOrThrowOnInconsistentIds(name, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            attributeSetInstanceExtensionFieldApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 修改.
     * 修改 AttributeSetInstanceExtensionField
     */
    @PatchMapping("{name}")
    public void patch(@PathVariable("name") String name, @RequestBody CreateOrMergePatchAttributeSetInstanceExtensionFieldDto.MergePatchAttributeSetInstanceExtensionFieldDto value) {
        try {

            AttributeSetInstanceExtensionFieldCommand.MergePatchAttributeSetInstanceExtensionField cmd = value.toMergePatchAttributeSetInstanceExtensionField();
            AttributeSetInstanceExtensionFieldResourceUtils.setNullIdOrThrowOnInconsistentIds(name, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            attributeSetInstanceExtensionFieldApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 删除.
     * 删除 AttributeSetInstanceExtensionField
     */
    @DeleteMapping("{name}")
    public void delete(@PathVariable("name") String name,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            AttributeSetInstanceExtensionFieldCommand.DeleteAttributeSetInstanceExtensionField deleteCmd = new AbstractAttributeSetInstanceExtensionFieldCommand.SimpleDeleteAttributeSetInstanceExtensionField();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            AttributeSetInstanceExtensionFieldResourceUtils.setNullIdOrThrowOnInconsistentIds(name, deleteCmd);
            deleteCmd.setRequesterId(SecurityContextUtil.getRequesterId());
            attributeSetInstanceExtensionFieldApplicationService.when(deleteCmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            AttributeSetInstanceExtensionFieldMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{name}/_events/{version}")
    public AttributeSetInstanceExtensionFieldEvent getStateEvent(@PathVariable("name") String name, @PathVariable("version") long version) {
        try {

            String idObj = name;
            //AttributeSetInstanceExtensionFieldStateEventDtoConverter dtoConverter = getAttributeSetInstanceExtensionFieldStateEventDtoConverter();
            return attributeSetInstanceExtensionFieldApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{name}/_historyStates/{version}")
    public AttributeSetInstanceExtensionFieldStateDto getHistoryState(@PathVariable("name") String name, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = name;
            AttributeSetInstanceExtensionFieldStateDto.DtoConverter dtoConverter = new AttributeSetInstanceExtensionFieldStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeSetInstanceExtensionFieldStateDto(attributeSetInstanceExtensionFieldApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    //protected  AttributeSetInstanceExtensionFieldStateEventDtoConverter getAttributeSetInstanceExtensionFieldStateEventDtoConverter() {
    //    return new AttributeSetInstanceExtensionFieldStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return AttributeSetInstanceExtensionFieldResourceUtils.getFilterPropertyType(propertyName);
            }
        };
    }

    // ////////////////////////////////
 
    public static class AttributeSetInstanceExtensionFieldResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String name, AttributeSetInstanceExtensionFieldCommand value) {
            String idObj = name;
            if (value.getName() == null) {
                value.setName(idObj);
            } else if (!value.getName().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", name, value.getName());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, AttributeSetInstanceExtensionFieldMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, AttributeSetInstanceExtensionFieldMetadata.aliasMap);
        }

        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (AttributeSetInstanceExtensionFieldMetadata.aliasMap.containsKey(fieldName)) {
                return AttributeSetInstanceExtensionFieldMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (AttributeSetInstanceExtensionFieldMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = AttributeSetInstanceExtensionFieldMetadata.propertyTypeMap.get(propertyName);
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

        public static AttributeSetInstanceExtensionFieldStateDto[] toAttributeSetInstanceExtensionFieldStateDtoArray(Iterable<String> ids) {
            List<AttributeSetInstanceExtensionFieldStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                AttributeSetInstanceExtensionFieldStateDto dto = new AttributeSetInstanceExtensionFieldStateDto();
                dto.setName(i);
                states.add(dto);
            });
            return states.toArray(new AttributeSetInstanceExtensionFieldStateDto[0]);
        }

    }

}

