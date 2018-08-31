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
import org.dddml.wms.domain.goodidentificationtype.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "GoodIdentificationTypes", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class GoodIdentificationTypeResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private GoodIdentificationTypeApplicationService goodIdentificationTypeApplicationService;


    /**
     * 查询.
     * 查询 GoodIdentificationTypes
     */
    @GetMapping
    public GoodIdentificationTypeStateDto[] getAll(@Specification(value = GoodIdentificationTypeStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }

            Iterable<GoodIdentificationTypeState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> GoodIdentificationTypeResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (GoodIdentificationTypeMetadata.aliasMap.containsKey(n) ? GoodIdentificationTypeMetadata.aliasMap.get(n) : n));
            states = goodIdentificationTypeApplicationService.get(
                c,
                GoodIdentificationTypeResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            GoodIdentificationTypeStateDto.DtoConverter dtoConverter = new GoodIdentificationTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toGoodIdentificationTypeStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查询.
     * 分页查询 GoodIdentificationTypes
     */
    @GetMapping("_page")
    public Page<GoodIdentificationTypeStateDto> getPage(@Specification(value = GoodIdentificationTypeStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<GoodIdentificationTypeState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> GoodIdentificationTypeResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (GoodIdentificationTypeMetadata.aliasMap.containsKey(n) ? GoodIdentificationTypeMetadata.aliasMap.get(n) : n));
            states = goodIdentificationTypeApplicationService.get(
                c,
                GoodIdentificationTypeResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = goodIdentificationTypeApplicationService.getCount(c);

            GoodIdentificationTypeStateDto.DtoConverter dtoConverter = new GoodIdentificationTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<GoodIdentificationTypeStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toGoodIdentificationTypeStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 GoodIdentificationType
     */
    @GetMapping("{goodIdentificationTypeId}")
    public GoodIdentificationTypeStateDto get(@PathVariable("goodIdentificationTypeId") String goodIdentificationTypeId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = goodIdentificationTypeId;
            GoodIdentificationTypeState state = goodIdentificationTypeApplicationService.get(idObj);
            if (state == null) { return null; }

            GoodIdentificationTypeStateDto.DtoConverter dtoConverter = new GoodIdentificationTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toGoodIdentificationTypeStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_count")
    public long getCount(@Specification(value = GoodIdentificationTypeStateDto.class) HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSONObject.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap());
            }
            count = goodIdentificationTypeApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (GoodIdentificationTypeMetadata.aliasMap.containsKey(n) ? GoodIdentificationTypeMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 新建.
     * 新建 GoodIdentificationType
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody CreateOrMergePatchGoodIdentificationTypeDto.CreateGoodIdentificationTypeDto value,  HttpServletResponse response) {
        try {
            GoodIdentificationTypeCommand.CreateGoodIdentificationType cmd = value.toCreateGoodIdentificationType();
            if (cmd.getGoodIdentificationTypeId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "GoodIdentificationType");
            }
            String idObj = cmd.getGoodIdentificationTypeId();
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            goodIdentificationTypeApplicationService.when(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 GoodIdentificationType
     */
    @PutMapping("{goodIdentificationTypeId}")
    public void put(@PathVariable("goodIdentificationTypeId") String goodIdentificationTypeId, @RequestBody CreateOrMergePatchGoodIdentificationTypeDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                GoodIdentificationTypeCommand.MergePatchGoodIdentificationType cmd = (GoodIdentificationTypeCommand.MergePatchGoodIdentificationType) value.toCommand();
                GoodIdentificationTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(goodIdentificationTypeId, cmd);
                cmd.setRequesterId(SecurityContextUtil.getRequesterId());
                goodIdentificationTypeApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            GoodIdentificationTypeCommand.CreateGoodIdentificationType cmd = (GoodIdentificationTypeCommand.CreateGoodIdentificationType) value.toCommand();
            GoodIdentificationTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(goodIdentificationTypeId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            goodIdentificationTypeApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 修改.
     * 修改 GoodIdentificationType
     */
    @PatchMapping("{goodIdentificationTypeId}")
    public void patch(@PathVariable("goodIdentificationTypeId") String goodIdentificationTypeId, @RequestBody CreateOrMergePatchGoodIdentificationTypeDto.MergePatchGoodIdentificationTypeDto value) {
        try {

            GoodIdentificationTypeCommand.MergePatchGoodIdentificationType cmd = value.toMergePatchGoodIdentificationType();
            GoodIdentificationTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(goodIdentificationTypeId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            goodIdentificationTypeApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 删除.
     * 删除 GoodIdentificationType
     */
    @DeleteMapping("{goodIdentificationTypeId}")
    public void delete(@PathVariable("goodIdentificationTypeId") String goodIdentificationTypeId,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            GoodIdentificationTypeCommand.DeleteGoodIdentificationType deleteCmd = new AbstractGoodIdentificationTypeCommand.SimpleDeleteGoodIdentificationType();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            GoodIdentificationTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(goodIdentificationTypeId, deleteCmd);
            deleteCmd.setRequesterId(SecurityContextUtil.getRequesterId());
            goodIdentificationTypeApplicationService.when(deleteCmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            GoodIdentificationTypeMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{goodIdentificationTypeId}/_events/{version}")
    public GoodIdentificationTypeEvent getStateEvent(@PathVariable("goodIdentificationTypeId") String goodIdentificationTypeId, @PathVariable("version") long version) {
        try {

            String idObj = goodIdentificationTypeId;
            //GoodIdentificationTypeStateEventDtoConverter dtoConverter = getGoodIdentificationTypeStateEventDtoConverter();
            return goodIdentificationTypeApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{goodIdentificationTypeId}/_historyStates/{version}")
    public GoodIdentificationTypeStateDto getHistoryState(@PathVariable("goodIdentificationTypeId") String goodIdentificationTypeId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = goodIdentificationTypeId;
            GoodIdentificationTypeStateDto.DtoConverter dtoConverter = new GoodIdentificationTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toGoodIdentificationTypeStateDto(goodIdentificationTypeApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    //protected  GoodIdentificationTypeStateEventDtoConverter getGoodIdentificationTypeStateEventDtoConverter() {
    //    return new GoodIdentificationTypeStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return GoodIdentificationTypeResourceUtils.getFilterPropertyType(propertyName);
            }
        };
    }

    // ////////////////////////////////
 
    public static class GoodIdentificationTypeResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String goodIdentificationTypeId, GoodIdentificationTypeCommand value) {
            String idObj = goodIdentificationTypeId;
            if (value.getGoodIdentificationTypeId() == null) {
                value.setGoodIdentificationTypeId(idObj);
            } else if (!value.getGoodIdentificationTypeId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", goodIdentificationTypeId, value.getGoodIdentificationTypeId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, GoodIdentificationTypeMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, GoodIdentificationTypeMetadata.aliasMap);
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
            ids.forEach(i -> {
                GoodIdentificationTypeStateDto dto = new GoodIdentificationTypeStateDto();
                dto.setGoodIdentificationTypeId(i);
                states.add(dto);
            });
            return states.toArray(new GoodIdentificationTypeStateDto[0]);
        }

    }

}

