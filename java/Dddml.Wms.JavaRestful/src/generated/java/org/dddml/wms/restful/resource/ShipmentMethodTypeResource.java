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
import org.dddml.wms.domain.shipmentmethodtype.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "ShipmentMethodTypes", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ShipmentMethodTypeResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private ShipmentMethodTypeApplicationService shipmentMethodTypeApplicationService;


    /**
     * 查询.
     * 查询 ShipmentMethodTypes
     */
    @GetMapping
    public ShipmentMethodTypeStateDto[] getAll(@Specification(value = ShipmentMethodTypeStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }

            Iterable<ShipmentMethodTypeState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> ShipmentMethodTypeResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (ShipmentMethodTypeMetadata.aliasMap.containsKey(n) ? ShipmentMethodTypeMetadata.aliasMap.get(n) : n));
            states = shipmentMethodTypeApplicationService.get(
                c,
                ShipmentMethodTypeResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            ShipmentMethodTypeStateDto.DtoConverter dtoConverter = new ShipmentMethodTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentMethodTypeStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查询.
     * 分页查询 ShipmentMethodTypes
     */
    @GetMapping("_page")
    public Page<ShipmentMethodTypeStateDto> getPage(@Specification(value = ShipmentMethodTypeStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<ShipmentMethodTypeState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> ShipmentMethodTypeResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (ShipmentMethodTypeMetadata.aliasMap.containsKey(n) ? ShipmentMethodTypeMetadata.aliasMap.get(n) : n));
            states = shipmentMethodTypeApplicationService.get(
                c,
                ShipmentMethodTypeResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = shipmentMethodTypeApplicationService.getCount(c);

            ShipmentMethodTypeStateDto.DtoConverter dtoConverter = new ShipmentMethodTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<ShipmentMethodTypeStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toShipmentMethodTypeStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 ShipmentMethodType
     */
    @GetMapping("{shipmentMethodTypeId}")
    public ShipmentMethodTypeStateDto get(@PathVariable("shipmentMethodTypeId") String shipmentMethodTypeId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = shipmentMethodTypeId;
            ShipmentMethodTypeState state = shipmentMethodTypeApplicationService.get(idObj);
            if (state == null) { return null; }

            ShipmentMethodTypeStateDto.DtoConverter dtoConverter = new ShipmentMethodTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentMethodTypeStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_count")
    public long getCount(@Specification(value = ShipmentMethodTypeStateDto.class) HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSONObject.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap());
            }
            count = shipmentMethodTypeApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (ShipmentMethodTypeMetadata.aliasMap.containsKey(n) ? ShipmentMethodTypeMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 新建.
     * 新建 ShipmentMethodType
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody CreateOrMergePatchShipmentMethodTypeDto.CreateShipmentMethodTypeDto value,  HttpServletResponse response) {
        try {
            ShipmentMethodTypeCommand.CreateShipmentMethodType cmd = value.toCreateShipmentMethodType();
            if (cmd.getShipmentMethodTypeId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "ShipmentMethodType");
            }
            String idObj = cmd.getShipmentMethodTypeId();
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentMethodTypeApplicationService.when(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 ShipmentMethodType
     */
    @PutMapping("{shipmentMethodTypeId}")
    public void put(@PathVariable("shipmentMethodTypeId") String shipmentMethodTypeId, @RequestBody CreateOrMergePatchShipmentMethodTypeDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                ShipmentMethodTypeCommand.MergePatchShipmentMethodType cmd = (ShipmentMethodTypeCommand.MergePatchShipmentMethodType) value.toCommand();
                ShipmentMethodTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(shipmentMethodTypeId, cmd);
                cmd.setRequesterId(SecurityContextUtil.getRequesterId());
                shipmentMethodTypeApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            ShipmentMethodTypeCommand.CreateShipmentMethodType cmd = (ShipmentMethodTypeCommand.CreateShipmentMethodType) value.toCommand();
            ShipmentMethodTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(shipmentMethodTypeId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentMethodTypeApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 修改.
     * 修改 ShipmentMethodType
     */
    @PatchMapping("{shipmentMethodTypeId}")
    public void patch(@PathVariable("shipmentMethodTypeId") String shipmentMethodTypeId, @RequestBody CreateOrMergePatchShipmentMethodTypeDto.MergePatchShipmentMethodTypeDto value) {
        try {

            ShipmentMethodTypeCommand.MergePatchShipmentMethodType cmd = value.toMergePatchShipmentMethodType();
            ShipmentMethodTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(shipmentMethodTypeId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentMethodTypeApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 删除.
     * 删除 ShipmentMethodType
     */
    @DeleteMapping("{shipmentMethodTypeId}")
    public void delete(@PathVariable("shipmentMethodTypeId") String shipmentMethodTypeId,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            ShipmentMethodTypeCommand.DeleteShipmentMethodType deleteCmd = new AbstractShipmentMethodTypeCommand.SimpleDeleteShipmentMethodType();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            ShipmentMethodTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(shipmentMethodTypeId, deleteCmd);
            deleteCmd.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentMethodTypeApplicationService.when(deleteCmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            ShipmentMethodTypeMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{shipmentMethodTypeId}/_events/{version}")
    public ShipmentMethodTypeEvent getStateEvent(@PathVariable("shipmentMethodTypeId") String shipmentMethodTypeId, @PathVariable("version") long version) {
        try {

            String idObj = shipmentMethodTypeId;
            //ShipmentMethodTypeStateEventDtoConverter dtoConverter = getShipmentMethodTypeStateEventDtoConverter();
            return shipmentMethodTypeApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{shipmentMethodTypeId}/_historyStates/{version}")
    public ShipmentMethodTypeStateDto getHistoryState(@PathVariable("shipmentMethodTypeId") String shipmentMethodTypeId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = shipmentMethodTypeId;
            ShipmentMethodTypeStateDto.DtoConverter dtoConverter = new ShipmentMethodTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentMethodTypeStateDto(shipmentMethodTypeApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    //protected  ShipmentMethodTypeStateEventDtoConverter getShipmentMethodTypeStateEventDtoConverter() {
    //    return new ShipmentMethodTypeStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return ShipmentMethodTypeResourceUtils.getFilterPropertyType(propertyName);
            }
        };
    }

    // ////////////////////////////////
 
    public static class ShipmentMethodTypeResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String shipmentMethodTypeId, ShipmentMethodTypeCommand value) {
            String idObj = shipmentMethodTypeId;
            if (value.getShipmentMethodTypeId() == null) {
                value.setShipmentMethodTypeId(idObj);
            } else if (!value.getShipmentMethodTypeId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", shipmentMethodTypeId, value.getShipmentMethodTypeId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, ShipmentMethodTypeMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, ShipmentMethodTypeMetadata.aliasMap);
        }

        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (ShipmentMethodTypeMetadata.aliasMap.containsKey(fieldName)) {
                return ShipmentMethodTypeMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (ShipmentMethodTypeMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = ShipmentMethodTypeMetadata.propertyTypeMap.get(propertyName);
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

        public static ShipmentMethodTypeStateDto[] toShipmentMethodTypeStateDtoArray(Iterable<String> ids) {
            List<ShipmentMethodTypeStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                ShipmentMethodTypeStateDto dto = new ShipmentMethodTypeStateDto();
                dto.setShipmentMethodTypeId(i);
                states.add(dto);
            });
            return states.toArray(new ShipmentMethodTypeStateDto[0]);
        }

    }

}

