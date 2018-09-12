package org.dddml.wms.restful.resource;

import java.util.*;
import java.util.stream.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.annotation.*;
import org.dddml.wms.domain.attributesetinstance.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "AttributeSetInstances", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class AttributeSetInstanceResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AbstractDynamicObjectMapper<JSONObject,
            AttributeSetInstanceState,
            AttributeSetInstanceCommand.CreateAttributeSetInstance,
            Object> attributeSetInstanceDynamicObjectMapper;


    @Autowired
    private AttributeSetInstanceApplicationService attributeSetInstanceApplicationService;


    /**
     * 查询.
     * 查询 AttributeSetInstances
     */
    @GetMapping
    public JSONArray getAll(@Specification(value = AttributeSetInstanceStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }

            Iterable<AttributeSetInstanceState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> AttributeSetInstanceResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (AttributeSetInstanceMetadata.aliasMap.containsKey(n) ? AttributeSetInstanceMetadata.aliasMap.get(n) : n));
            states = attributeSetInstanceApplicationService.get(
                c,
                AttributeSetInstanceResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            JSONArray dynamicArray = new JSONArray();
            if (states != null) {
                states.forEach(state -> {
                    dynamicArray.add(attributeSetInstanceDynamicObjectMapper.mapState(state, fields));
                });
            }
            return dynamicArray;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查询.
     * 分页查询 AttributeSetInstances
     */
    @GetMapping("_page")
    public Page<JSONObject> getPage(@Specification(value = AttributeSetInstanceStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<AttributeSetInstanceState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> AttributeSetInstanceResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (AttributeSetInstanceMetadata.aliasMap.containsKey(n) ? AttributeSetInstanceMetadata.aliasMap.get(n) : n));
            states = attributeSetInstanceApplicationService.get(
                c,
                AttributeSetInstanceResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = attributeSetInstanceApplicationService.getCount(c);

            List<JSONObject> dynamicArray = new ArrayList<>();
            if (states != null) {
                states.forEach(state -> {
                    dynamicArray.add(attributeSetInstanceDynamicObjectMapper.mapState(state, fields));
                });
            }
            Page.PageImpl<JSONObject> statePage =  new Page.PageImpl<>(dynamicArray, count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 AttributeSetInstance
     */
    @GetMapping("{attributeSetInstanceId}")
    public JSONObject get(@PathVariable("attributeSetInstanceId") String attributeSetInstanceId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = attributeSetInstanceId;
            AttributeSetInstanceState state = attributeSetInstanceApplicationService.get(idObj);
            if (state == null) { return null; }

            return attributeSetInstanceDynamicObjectMapper.mapState(state, fields);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_count")
    public long getCount(@Specification(value = AttributeSetInstanceStateDto.class) HttpServletRequest request,
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
                n -> (AttributeSetInstanceMetadata.aliasMap.containsKey(n) ? AttributeSetInstanceMetadata.aliasMap.get(n) : n));
            count = attributeSetInstanceApplicationService.getCount(c);
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 新建.
     * 新建 AttributeSetInstance
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody JSONObject dynamicObject,  HttpServletResponse response) {
        try {
            AttributeSetInstanceCommand.CreateAttributeSetInstance cmd = attributeSetInstanceDynamicObjectMapper.toCommandCreate(dynamicObject);
            String idObj = attributeSetInstanceApplicationService.createWithoutId(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 AttributeSetInstance
     */
    @PutMapping("{attributeSetInstanceId}")
    public void put(@PathVariable("attributeSetInstanceId") String attributeSetInstanceId, @RequestBody JSONObject dynamicObject) {
        try {

            AttributeSetInstanceCommand.CreateAttributeSetInstance cmd = attributeSetInstanceDynamicObjectMapper.toCommandCreate(dynamicObject);
            AttributeSetInstanceResourceUtils.setNullIdOrThrowOnInconsistentIds(attributeSetInstanceId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            attributeSetInstanceApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            AttributeSetInstanceMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{attributeSetInstanceId}/_events/{version}")
    public AttributeSetInstanceEvent getStateEvent(@PathVariable("attributeSetInstanceId") String attributeSetInstanceId, @PathVariable("version") long version) {
        try {

            String idObj = attributeSetInstanceId;
            //AttributeSetInstanceStateEventDtoConverter dtoConverter = getAttributeSetInstanceStateEventDtoConverter();
            return attributeSetInstanceApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{attributeSetInstanceId}/_historyStates/{version}")
    public AttributeSetInstanceStateDto getHistoryState(@PathVariable("attributeSetInstanceId") String attributeSetInstanceId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = attributeSetInstanceId;
            AttributeSetInstanceStateDto.DtoConverter dtoConverter = new AttributeSetInstanceStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toAttributeSetInstanceStateDto(attributeSetInstanceApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    //protected  AttributeSetInstanceStateEventDtoConverter getAttributeSetInstanceStateEventDtoConverter() {
    //    return new AttributeSetInstanceStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return AttributeSetInstanceResourceUtils.getFilterPropertyType(propertyName);
            }
        };
    }

    // ////////////////////////////////
 
    public static class AttributeSetInstanceResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String attributeSetInstanceId, AttributeSetInstanceCommand value) {
            String idObj = attributeSetInstanceId;
            if (value.getAttributeSetInstanceId() == null) {
                value.setAttributeSetInstanceId(idObj);
            } else if (!value.getAttributeSetInstanceId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", attributeSetInstanceId, value.getAttributeSetInstanceId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, AttributeSetInstanceMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, AttributeSetInstanceMetadata.aliasMap);
        }

        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (AttributeSetInstanceMetadata.aliasMap.containsKey(fieldName)) {
                return AttributeSetInstanceMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (AttributeSetInstanceMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = AttributeSetInstanceMetadata.propertyTypeMap.get(propertyName);
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

        public static AttributeSetInstanceStateDto[] toAttributeSetInstanceStateDtoArray(Iterable<String> ids) {
            List<AttributeSetInstanceStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                AttributeSetInstanceStateDto dto = new AttributeSetInstanceStateDto();
                dto.setAttributeSetInstanceId(i);
                states.add(dto);
            });
            return states.toArray(new AttributeSetInstanceStateDto[0]);
        }

    }

}

