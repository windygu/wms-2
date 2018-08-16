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
import org.dddml.wms.domain.uomconversion.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "UomConversions", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class UomConversionResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private UomConversionApplicationService uomConversionApplicationService;


    /**
     * 查询.
     * 查询 UomConversions
     */
    @GetMapping
    public UomConversionStateDto[] getAll( HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<UomConversionState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> UomConversionResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (UomConversionMetadata.aliasMap.containsKey(n) ? UomConversionMetadata.aliasMap.get(n) : n));
            states = uomConversionApplicationService.get(
                c,
                UomConversionResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            UomConversionStateDto.DtoConverter dtoConverter = new UomConversionStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toUomConversionStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查询.
     * 分页查询 UomConversions
     */
    @GetMapping("_page")
    public Page<UomConversionStateDto> getPage( HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<UomConversionState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> UomConversionResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (UomConversionMetadata.aliasMap.containsKey(n) ? UomConversionMetadata.aliasMap.get(n) : n));
            states = uomConversionApplicationService.get(
                c,
                UomConversionResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = uomConversionApplicationService.getCount(c);

            UomConversionStateDto.DtoConverter dtoConverter = new UomConversionStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<UomConversionStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toUomConversionStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            statePage.setTotalElements(count);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 UomConversion
     */
    @GetMapping("{uomConversionId}")
    public UomConversionStateDto get(@PathVariable("uomConversionId") String uomConversionId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            UomConversionId idObj = UomConversionResourceUtils.parseIdString(uomConversionId);
            UomConversionState state = uomConversionApplicationService.get(idObj);
            if (state == null) { return null; }

            UomConversionStateDto.DtoConverter dtoConverter = new UomConversionStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toUomConversionStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
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
            count = uomConversionApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (UomConversionMetadata.aliasMap.containsKey(n) ? UomConversionMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 新建.
     * 新建 UomConversion
     */
    @PostMapping
    public UomConversionId post(@RequestBody CreateOrMergePatchUomConversionDto.CreateUomConversionDto value,  HttpServletResponse response) {
        try {
            UomConversionCommand.CreateUomConversion cmd = value.toCreateUomConversion();
            if (cmd.getUomConversionId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "UomConversion");
            }
            UomConversionId idObj = cmd.getUomConversionId();
            uomConversionApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 UomConversion
     */
    @PutMapping("{uomConversionId}")
    public void put(@PathVariable("uomConversionId") String uomConversionId, @RequestBody CreateOrMergePatchUomConversionDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                UomConversionCommand.MergePatchUomConversion cmd = (UomConversionCommand.MergePatchUomConversion) value.toCommand();
                UomConversionResourceUtils.setNullIdOrThrowOnInconsistentIds(uomConversionId, cmd);
                uomConversionApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            UomConversionCommand.CreateUomConversion cmd = (UomConversionCommand.CreateUomConversion) value.toCommand();
            UomConversionResourceUtils.setNullIdOrThrowOnInconsistentIds(uomConversionId, cmd);
            uomConversionApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 修改.
     * 修改 UomConversion
     */
    @PatchMapping("{uomConversionId}")
    public void patch(@PathVariable("uomConversionId") String uomConversionId, @RequestBody CreateOrMergePatchUomConversionDto.MergePatchUomConversionDto value) {
        try {

            UomConversionCommand.MergePatchUomConversion cmd = value.toMergePatchUomConversion();
            UomConversionResourceUtils.setNullIdOrThrowOnInconsistentIds(uomConversionId, cmd);
            uomConversionApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 删除.
     * 删除 UomConversion
     */
    @DeleteMapping("{uomConversionId}")
    public void delete(@PathVariable("uomConversionId") String uomConversionId,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            UomConversionCommand.DeleteUomConversion deleteCmd = new AbstractUomConversionCommand.SimpleDeleteUomConversion();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            UomConversionResourceUtils.setNullIdOrThrowOnInconsistentIds(uomConversionId, deleteCmd);
            uomConversionApplicationService.when(deleteCmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            UomConversionMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{uomConversionId}/_events/{version}")
    public UomConversionEvent getStateEvent(@PathVariable("uomConversionId") String uomConversionId, @PathVariable("version") long version) {
        try {

            UomConversionId idObj = UomConversionResourceUtils.parseIdString(uomConversionId);
            //UomConversionStateEventDtoConverter dtoConverter = getUomConversionStateEventDtoConverter();
            return uomConversionApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{uomConversionId}/_historyStates/{version}")
    public UomConversionStateDto getHistoryState(@PathVariable("uomConversionId") String uomConversionId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            UomConversionId idObj = UomConversionResourceUtils.parseIdString(uomConversionId);
            UomConversionStateDto.DtoConverter dtoConverter = new UomConversionStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toUomConversionStateDto(uomConversionApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  UomConversionStateEventDtoConverter getUomConversionStateEventDtoConverter() {
    //    return new UomConversionStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new UomConversionPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class UomConversionPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return UomConversionResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class UomConversionResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String uomConversionId, UomConversionCommand value) {
            UomConversionId idObj = parseIdString(uomConversionId);
            if (value.getUomConversionId() == null) {
                value.setUomConversionId(idObj);
            } else if (!value.getUomConversionId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", uomConversionId, value.getUomConversionId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, UomConversionMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, UomConversionMetadata.aliasMap);
        }

        public static UomConversionId parseIdString(String idString) {
            TextFormatter<UomConversionId> formatter =
                    new AbstractValueObjectTextFormatter<UomConversionId>(UomConversionId.class) {
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
            if (UomConversionMetadata.aliasMap.containsKey(fieldName)) {
                return UomConversionMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (UomConversionMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = UomConversionMetadata.propertyTypeMap.get(propertyName);
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

        public static UomConversionStateDto[] toUomConversionStateDtoArray(Iterable<UomConversionId> ids) {
            List<UomConversionStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                UomConversionStateDto dto = new UomConversionStateDto();
                dto.setUomConversionId(i);
                states.add(dto);
            });
            return states.toArray(new UomConversionStateDto[0]);
        }

    }

}

