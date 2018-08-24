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
import org.dddml.wms.domain.shipmenttype.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "ShipmentTypes", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ShipmentTypeResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private ShipmentTypeApplicationService shipmentTypeApplicationService;


    /**
     * 查询.
     * 查询 ShipmentTypes
     */
    @GetMapping
    public ShipmentTypeStateDto[] getAll(@Specification(value = ShipmentTypeStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<ShipmentTypeState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> ShipmentTypeResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (ShipmentTypeMetadata.aliasMap.containsKey(n) ? ShipmentTypeMetadata.aliasMap.get(n) : n));
            states = shipmentTypeApplicationService.get(
                c,
                ShipmentTypeResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            ShipmentTypeStateDto.DtoConverter dtoConverter = new ShipmentTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentTypeStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查询.
     * 分页查询 ShipmentTypes
     */
    @GetMapping("_page")
    public Page<ShipmentTypeStateDto> getPage(@Specification(value = ShipmentTypeStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<ShipmentTypeState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> ShipmentTypeResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (ShipmentTypeMetadata.aliasMap.containsKey(n) ? ShipmentTypeMetadata.aliasMap.get(n) : n));
            states = shipmentTypeApplicationService.get(
                c,
                ShipmentTypeResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = shipmentTypeApplicationService.getCount(c);

            ShipmentTypeStateDto.DtoConverter dtoConverter = new ShipmentTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<ShipmentTypeStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toShipmentTypeStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 ShipmentType
     */
    @GetMapping("{shipmentTypeId}")
    public ShipmentTypeStateDto get(@PathVariable("shipmentTypeId") String shipmentTypeId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = shipmentTypeId;
            ShipmentTypeState state = shipmentTypeApplicationService.get(idObj);
            if (state == null) { return null; }

            ShipmentTypeStateDto.DtoConverter dtoConverter = new ShipmentTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentTypeStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount(@Specification(value = ShipmentTypeStateDto.class) HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSONObject.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap());
            }
            count = shipmentTypeApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (ShipmentTypeMetadata.aliasMap.containsKey(n) ? ShipmentTypeMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 新建.
     * 新建 ShipmentType
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody CreateOrMergePatchShipmentTypeDto.CreateShipmentTypeDto value,  HttpServletResponse response) {
        try {
            ShipmentTypeCommand.CreateShipmentType cmd = value.toCreateShipmentType();
            if (cmd.getShipmentTypeId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "ShipmentType");
            }
            String idObj = cmd.getShipmentTypeId();
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentTypeApplicationService.when(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 ShipmentType
     */
    @PutMapping("{shipmentTypeId}")
    public void put(@PathVariable("shipmentTypeId") String shipmentTypeId, @RequestBody CreateOrMergePatchShipmentTypeDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                ShipmentTypeCommand.MergePatchShipmentType cmd = (ShipmentTypeCommand.MergePatchShipmentType) value.toCommand();
                ShipmentTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(shipmentTypeId, cmd);
                cmd.setRequesterId(SecurityContextUtil.getRequesterId());
                shipmentTypeApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            ShipmentTypeCommand.CreateShipmentType cmd = (ShipmentTypeCommand.CreateShipmentType) value.toCommand();
            ShipmentTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(shipmentTypeId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentTypeApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 修改.
     * 修改 ShipmentType
     */
    @PatchMapping("{shipmentTypeId}")
    public void patch(@PathVariable("shipmentTypeId") String shipmentTypeId, @RequestBody CreateOrMergePatchShipmentTypeDto.MergePatchShipmentTypeDto value) {
        try {

            ShipmentTypeCommand.MergePatchShipmentType cmd = value.toMergePatchShipmentType();
            ShipmentTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(shipmentTypeId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentTypeApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            ShipmentTypeMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { logger.error("ExceptionCaught", ex); throw new DomainError("ExceptionCaught", ex); }
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return ShipmentTypeResourceUtils.getFilterPropertyType(propertyName);
            }
        };
    }

    // ////////////////////////////////
 
    public static class ShipmentTypeResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String shipmentTypeId, ShipmentTypeCommand value) {
            String idObj = shipmentTypeId;
            if (value.getShipmentTypeId() == null) {
                value.setShipmentTypeId(idObj);
            } else if (!value.getShipmentTypeId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", shipmentTypeId, value.getShipmentTypeId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, ShipmentTypeMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, ShipmentTypeMetadata.aliasMap);
        }

        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (ShipmentTypeMetadata.aliasMap.containsKey(fieldName)) {
                return ShipmentTypeMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (ShipmentTypeMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = ShipmentTypeMetadata.propertyTypeMap.get(propertyName);
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

        public static ShipmentTypeStateDto[] toShipmentTypeStateDtoArray(Iterable<String> ids) {
            List<ShipmentTypeStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                ShipmentTypeStateDto dto = new ShipmentTypeStateDto();
                dto.setShipmentTypeId(i);
                states.add(dto);
            });
            return states.toArray(new ShipmentTypeStateDto[0]);
        }

    }

}

