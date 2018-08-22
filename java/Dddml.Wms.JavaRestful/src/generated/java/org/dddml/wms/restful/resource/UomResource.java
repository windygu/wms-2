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
import org.dddml.wms.domain.uom.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "Uoms", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class UomResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private UomApplicationService uomApplicationService;


    /**
     * 查询.
     * 查询 Uoms
     */
    @GetMapping
    public UomStateDto[] getAll( HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<UomState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> UomResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (UomMetadata.aliasMap.containsKey(n) ? UomMetadata.aliasMap.get(n) : n));
            states = uomApplicationService.get(
                c,
                UomResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            UomStateDto.DtoConverter dtoConverter = new UomStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toUomStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查询.
     * 分页查询 Uoms
     */
    @GetMapping("_page")
    public Page<UomStateDto> getPage( HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<UomState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> UomResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (UomMetadata.aliasMap.containsKey(n) ? UomMetadata.aliasMap.get(n) : n));
            states = uomApplicationService.get(
                c,
                UomResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = uomApplicationService.getCount(c);

            UomStateDto.DtoConverter dtoConverter = new UomStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<UomStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toUomStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 Uom
     */
    @GetMapping("{uomId}")
    public UomStateDto get(@PathVariable("uomId") String uomId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = uomId;
            UomState state = uomApplicationService.get(idObj);
            if (state == null) { return null; }

            UomStateDto.DtoConverter dtoConverter = new UomStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toUomStateDto(state);

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
            count = uomApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (UomMetadata.aliasMap.containsKey(n) ? UomMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 新建.
     * 新建 Uom
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody CreateOrMergePatchUomDto.CreateUomDto value,  HttpServletResponse response) {
        try {
            UomCommand.CreateUom cmd = value.toCreateUom();
            if (cmd.getUomId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "Uom");
            }
            String idObj = cmd.getUomId();
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            uomApplicationService.when(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 Uom
     */
    @PutMapping("{uomId}")
    public void put(@PathVariable("uomId") String uomId, @RequestBody CreateOrMergePatchUomDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                UomCommand.MergePatchUom cmd = (UomCommand.MergePatchUom) value.toCommand();
                UomResourceUtils.setNullIdOrThrowOnInconsistentIds(uomId, cmd);
                cmd.setRequesterId(SecurityContextUtil.getRequesterId());
                uomApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            UomCommand.CreateUom cmd = (UomCommand.CreateUom) value.toCommand();
            UomResourceUtils.setNullIdOrThrowOnInconsistentIds(uomId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            uomApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 修改.
     * 修改 Uom
     */
    @PatchMapping("{uomId}")
    public void patch(@PathVariable("uomId") String uomId, @RequestBody CreateOrMergePatchUomDto.MergePatchUomDto value) {
        try {

            UomCommand.MergePatchUom cmd = value.toMergePatchUom();
            UomResourceUtils.setNullIdOrThrowOnInconsistentIds(uomId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            uomApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 删除.
     * 删除 Uom
     */
    @DeleteMapping("{uomId}")
    public void delete(@PathVariable("uomId") String uomId,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            UomCommand.DeleteUom deleteCmd = new AbstractUomCommand.SimpleDeleteUom();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            UomResourceUtils.setNullIdOrThrowOnInconsistentIds(uomId, deleteCmd);
            deleteCmd.setRequesterId(SecurityContextUtil.getRequesterId());
            uomApplicationService.when(deleteCmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            UomMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{uomId}/_events/{version}")
    public UomEvent getStateEvent(@PathVariable("uomId") String uomId, @PathVariable("version") long version) {
        try {

            String idObj = uomId;
            //UomStateEventDtoConverter dtoConverter = getUomStateEventDtoConverter();
            return uomApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{uomId}/_historyStates/{version}")
    public UomStateDto getHistoryState(@PathVariable("uomId") String uomId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = uomId;
            UomStateDto.DtoConverter dtoConverter = new UomStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toUomStateDto(uomApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  UomStateEventDtoConverter getUomStateEventDtoConverter() {
    //    return new UomStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new UomPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class UomPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return UomResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class UomResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String uomId, UomCommand value) {
            String idObj = uomId;
            if (value.getUomId() == null) {
                value.setUomId(idObj);
            } else if (!value.getUomId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", uomId, value.getUomId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, UomMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, UomMetadata.aliasMap);
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (UomMetadata.aliasMap.containsKey(fieldName)) {
                return UomMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (UomMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = UomMetadata.propertyTypeMap.get(propertyName);
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

        public static UomStateDto[] toUomStateDtoArray(Iterable<String> ids) {
            List<UomStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                UomStateDto dto = new UomStateDto();
                dto.setUomId(i);
                states.add(dto);
            });
            return states.toArray(new UomStateDto[0]);
        }

    }

}

