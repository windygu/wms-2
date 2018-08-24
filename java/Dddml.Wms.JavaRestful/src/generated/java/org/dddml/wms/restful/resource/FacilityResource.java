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
import org.dddml.wms.domain.facility.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "Facilities", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class FacilityResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private FacilityApplicationService facilityApplicationService;


    /**
     * 查询.
     * 查询 Facilities
     */
    @GetMapping
    public FacilityStateDto[] getAll(@Specification(value = FacilityStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<FacilityState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> FacilityResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (FacilityMetadata.aliasMap.containsKey(n) ? FacilityMetadata.aliasMap.get(n) : n));
            states = facilityApplicationService.get(
                c,
                FacilityResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            FacilityStateDto.DtoConverter dtoConverter = new FacilityStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toFacilityStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查询.
     * 分页查询 Facilities
     */
    @GetMapping("_page")
    public Page<FacilityStateDto> getPage(@Specification(value = FacilityStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<FacilityState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> FacilityResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (FacilityMetadata.aliasMap.containsKey(n) ? FacilityMetadata.aliasMap.get(n) : n));
            states = facilityApplicationService.get(
                c,
                FacilityResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = facilityApplicationService.getCount(c);

            FacilityStateDto.DtoConverter dtoConverter = new FacilityStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<FacilityStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toFacilityStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 Facility
     */
    @GetMapping("{facilityId}")
    public FacilityStateDto get(@PathVariable("facilityId") String facilityId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = facilityId;
            FacilityState state = facilityApplicationService.get(idObj);
            if (state == null) { return null; }

            FacilityStateDto.DtoConverter dtoConverter = new FacilityStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toFacilityStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount(@Specification(value = FacilityStateDto.class) HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSONObject.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap());
            }
            count = facilityApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (FacilityMetadata.aliasMap.containsKey(n) ? FacilityMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 新建.
     * 新建 Facility
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody CreateOrMergePatchFacilityDto.CreateFacilityDto value,  HttpServletResponse response) {
        try {
            FacilityCommand.CreateFacility cmd = value.toCreateFacility();
            if (cmd.getFacilityId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "Facility");
            }
            String idObj = cmd.getFacilityId();
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            facilityApplicationService.when(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 Facility
     */
    @PutMapping("{facilityId}")
    public void put(@PathVariable("facilityId") String facilityId, @RequestBody CreateOrMergePatchFacilityDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                FacilityCommand.MergePatchFacility cmd = (FacilityCommand.MergePatchFacility) value.toCommand();
                FacilityResourceUtils.setNullIdOrThrowOnInconsistentIds(facilityId, cmd);
                cmd.setRequesterId(SecurityContextUtil.getRequesterId());
                facilityApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            FacilityCommand.CreateFacility cmd = (FacilityCommand.CreateFacility) value.toCommand();
            FacilityResourceUtils.setNullIdOrThrowOnInconsistentIds(facilityId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            facilityApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 修改.
     * 修改 Facility
     */
    @PatchMapping("{facilityId}")
    public void patch(@PathVariable("facilityId") String facilityId, @RequestBody CreateOrMergePatchFacilityDto.MergePatchFacilityDto value) {
        try {

            FacilityCommand.MergePatchFacility cmd = value.toMergePatchFacility();
            FacilityResourceUtils.setNullIdOrThrowOnInconsistentIds(facilityId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            facilityApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 删除.
     * 删除 Facility
     */
    @DeleteMapping("{facilityId}")
    public void delete(@PathVariable("facilityId") String facilityId,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            FacilityCommand.DeleteFacility deleteCmd = new AbstractFacilityCommand.SimpleDeleteFacility();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            FacilityResourceUtils.setNullIdOrThrowOnInconsistentIds(facilityId, deleteCmd);
            deleteCmd.setRequesterId(SecurityContextUtil.getRequesterId());
            facilityApplicationService.when(deleteCmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            FacilityMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{facilityId}/_events/{version}")
    public FacilityEvent getStateEvent(@PathVariable("facilityId") String facilityId, @PathVariable("version") long version) {
        try {

            String idObj = facilityId;
            //FacilityStateEventDtoConverter dtoConverter = getFacilityStateEventDtoConverter();
            return facilityApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{facilityId}/_historyStates/{version}")
    public FacilityStateDto getHistoryState(@PathVariable("facilityId") String facilityId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = facilityId;
            FacilityStateDto.DtoConverter dtoConverter = new FacilityStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toFacilityStateDto(facilityApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  FacilityStateEventDtoConverter getFacilityStateEventDtoConverter() {
    //    return new FacilityStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return FacilityResourceUtils.getFilterPropertyType(propertyName);
            }
        };
    }

    // ////////////////////////////////
 
    public static class FacilityResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String facilityId, FacilityCommand value) {
            String idObj = facilityId;
            if (value.getFacilityId() == null) {
                value.setFacilityId(idObj);
            } else if (!value.getFacilityId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", facilityId, value.getFacilityId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, FacilityMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, FacilityMetadata.aliasMap);
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (FacilityMetadata.aliasMap.containsKey(fieldName)) {
                return FacilityMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (FacilityMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = FacilityMetadata.propertyTypeMap.get(propertyName);
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

        public static FacilityStateDto[] toFacilityStateDtoArray(Iterable<String> ids) {
            List<FacilityStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                FacilityStateDto dto = new FacilityStateDto();
                dto.setFacilityId(i);
                states.add(dto);
            });
            return states.toArray(new FacilityStateDto[0]);
        }

    }

}

