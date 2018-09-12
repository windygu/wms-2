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
import org.dddml.wms.domain.shipmentpackage.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "ShipmentPackages", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ShipmentPackageResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private ShipmentPackageApplicationService shipmentPackageApplicationService;


    /**
     * 查询.
     * 查询 ShipmentPackages
     */
    @GetMapping
    public ShipmentPackageStateDto[] getAll(@Specification(value = ShipmentPackageStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }

            Iterable<ShipmentPackageState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> ShipmentPackageResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (ShipmentPackageMetadata.aliasMap.containsKey(n) ? ShipmentPackageMetadata.aliasMap.get(n) : n));
            states = shipmentPackageApplicationService.get(
                c,
                ShipmentPackageResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            ShipmentPackageStateDto.DtoConverter dtoConverter = new ShipmentPackageStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentPackageStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查询.
     * 分页查询 ShipmentPackages
     */
    @GetMapping("_page")
    public Page<ShipmentPackageStateDto> getPage(@Specification(value = ShipmentPackageStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<ShipmentPackageState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> ShipmentPackageResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (ShipmentPackageMetadata.aliasMap.containsKey(n) ? ShipmentPackageMetadata.aliasMap.get(n) : n));
            states = shipmentPackageApplicationService.get(
                c,
                ShipmentPackageResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = shipmentPackageApplicationService.getCount(c);

            ShipmentPackageStateDto.DtoConverter dtoConverter = new ShipmentPackageStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<ShipmentPackageStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toShipmentPackageStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 ShipmentPackage
     */
    @GetMapping("{shipmentPackageId}")
    public ShipmentPackageStateDto get(@PathVariable("shipmentPackageId") String shipmentPackageId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            ShipmentPackageId idObj = ShipmentPackageResourceUtils.parseIdString(shipmentPackageId);
            ShipmentPackageState state = shipmentPackageApplicationService.get(idObj);
            if (state == null) { return null; }

            ShipmentPackageStateDto.DtoConverter dtoConverter = new ShipmentPackageStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentPackageStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_count")
    public long getCount(@Specification(value = ShipmentPackageStateDto.class) HttpServletRequest request,
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
                n -> (ShipmentPackageMetadata.aliasMap.containsKey(n) ? ShipmentPackageMetadata.aliasMap.get(n) : n));
            count = shipmentPackageApplicationService.getCount(c);
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 新建.
     * 新建 ShipmentPackage
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public ShipmentPackageId post(@RequestBody CreateOrMergePatchShipmentPackageDto.CreateShipmentPackageDto value,  HttpServletResponse response) {
        try {
            ShipmentPackageCommand.CreateShipmentPackage cmd = value.toCreateShipmentPackage();
            if (cmd.getShipmentPackageId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "ShipmentPackage");
            }
            ShipmentPackageId idObj = cmd.getShipmentPackageId();
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentPackageApplicationService.when(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 ShipmentPackage
     */
    @PutMapping("{shipmentPackageId}")
    public void put(@PathVariable("shipmentPackageId") String shipmentPackageId, @RequestBody CreateOrMergePatchShipmentPackageDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                ShipmentPackageCommand.MergePatchShipmentPackage cmd = (ShipmentPackageCommand.MergePatchShipmentPackage) value.toCommand();
                ShipmentPackageResourceUtils.setNullIdOrThrowOnInconsistentIds(shipmentPackageId, cmd);
                cmd.setRequesterId(SecurityContextUtil.getRequesterId());
                shipmentPackageApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            ShipmentPackageCommand.CreateShipmentPackage cmd = (ShipmentPackageCommand.CreateShipmentPackage) value.toCommand();
            ShipmentPackageResourceUtils.setNullIdOrThrowOnInconsistentIds(shipmentPackageId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentPackageApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 修改.
     * 修改 ShipmentPackage
     */
    @PatchMapping("{shipmentPackageId}")
    public void patch(@PathVariable("shipmentPackageId") String shipmentPackageId, @RequestBody CreateOrMergePatchShipmentPackageDto.MergePatchShipmentPackageDto value) {
        try {

            ShipmentPackageCommand.MergePatchShipmentPackage cmd = value.toMergePatchShipmentPackage();
            ShipmentPackageResourceUtils.setNullIdOrThrowOnInconsistentIds(shipmentPackageId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentPackageApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 删除.
     * 删除 ShipmentPackage
     */
    @DeleteMapping("{shipmentPackageId}")
    public void delete(@PathVariable("shipmentPackageId") String shipmentPackageId,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            ShipmentPackageCommand.DeleteShipmentPackage deleteCmd = new AbstractShipmentPackageCommand.SimpleDeleteShipmentPackage();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            ShipmentPackageResourceUtils.setNullIdOrThrowOnInconsistentIds(shipmentPackageId, deleteCmd);
            deleteCmd.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentPackageApplicationService.when(deleteCmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            ShipmentPackageMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{shipmentPackageId}/_events/{version}")
    public ShipmentPackageEvent getStateEvent(@PathVariable("shipmentPackageId") String shipmentPackageId, @PathVariable("version") long version) {
        try {

            ShipmentPackageId idObj = ShipmentPackageResourceUtils.parseIdString(shipmentPackageId);
            //ShipmentPackageStateEventDtoConverter dtoConverter = getShipmentPackageStateEventDtoConverter();
            return shipmentPackageApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{shipmentPackageId}/_historyStates/{version}")
    public ShipmentPackageStateDto getHistoryState(@PathVariable("shipmentPackageId") String shipmentPackageId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            ShipmentPackageId idObj = ShipmentPackageResourceUtils.parseIdString(shipmentPackageId);
            ShipmentPackageStateDto.DtoConverter dtoConverter = new ShipmentPackageStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentPackageStateDto(shipmentPackageApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 获取指定 ShipmentItemSeqId 的 ShipmentPackageContent
     */
    @GetMapping("{shipmentPackageId}/ShipmentPackageContents/{shipmentItemSeqId}")
    public ShipmentPackageContentStateDto getShipmentPackageContent(@PathVariable("shipmentPackageId") String shipmentPackageId, @PathVariable("shipmentItemSeqId") String shipmentItemSeqId) {
        try {

            ShipmentPackageContentState state = shipmentPackageApplicationService.getShipmentPackageContent((new AbstractValueObjectTextFormatter<ShipmentPackageId>(ShipmentPackageId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(shipmentPackageId)), shipmentItemSeqId);
            if (state == null) { return null; }
            ShipmentPackageContentStateDto.DtoConverter dtoConverter = new ShipmentPackageContentStateDto.DtoConverter();
            ShipmentPackageContentStateDto stateDto = dtoConverter.toShipmentPackageContentStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 创建 or 修改.
     * 创建 or 修改 ShipmentPackageContent
     */
    @PutMapping(path = "{shipmentPackageId}/ShipmentPackageContents/{shipmentItemSeqId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putShipmentPackageContent(@PathVariable("shipmentPackageId") String shipmentPackageId, @PathVariable("shipmentItemSeqId") String shipmentItemSeqId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchShipmentPackageContentDto.MergePatchShipmentPackageContentDto body) {
        try {
            ShipmentPackageCommand.MergePatchShipmentPackage mergePatchShipmentPackage = new AbstractShipmentPackageCommand.SimpleMergePatchShipmentPackage();
            mergePatchShipmentPackage.setShipmentPackageId((new AbstractValueObjectTextFormatter<ShipmentPackageId>(ShipmentPackageId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(shipmentPackageId)));
            mergePatchShipmentPackage.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchShipmentPackage.setVersion(version); }
            mergePatchShipmentPackage.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            ShipmentPackageContentCommand.MergePatchShipmentPackageContent mergePatchShipmentPackageContent = body.toMergePatchShipmentPackageContent();
            mergePatchShipmentPackageContent.setShipmentItemSeqId(shipmentItemSeqId);
            mergePatchShipmentPackage.getShipmentPackageContentCommands().add(mergePatchShipmentPackageContent);
            mergePatchShipmentPackage.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentPackageApplicationService.when(mergePatchShipmentPackage);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 移除.
     * 移除 ShipmentPackageContent
     */
    @DeleteMapping("{shipmentPackageId}/ShipmentPackageContents/{shipmentItemSeqId}")
    public void deleteShipmentPackageContent(@PathVariable("shipmentPackageId") String shipmentPackageId, @PathVariable("shipmentItemSeqId") String shipmentItemSeqId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            ShipmentPackageCommand.MergePatchShipmentPackage mergePatchShipmentPackage = new AbstractShipmentPackageCommand.SimpleMergePatchShipmentPackage();
            mergePatchShipmentPackage.setShipmentPackageId((new AbstractValueObjectTextFormatter<ShipmentPackageId>(ShipmentPackageId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(shipmentPackageId)));
            mergePatchShipmentPackage.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { 
                mergePatchShipmentPackage.setVersion(version); 
            } else {
                mergePatchShipmentPackage.setVersion(shipmentPackageApplicationService.get((new AbstractValueObjectTextFormatter<ShipmentPackageId>(ShipmentPackageId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(shipmentPackageId))).getVersion());
            }
            mergePatchShipmentPackage.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            ShipmentPackageContentCommand.RemoveShipmentPackageContent removeShipmentPackageContent = new AbstractShipmentPackageContentCommand.SimpleRemoveShipmentPackageContent();
            removeShipmentPackageContent.setShipmentItemSeqId(shipmentItemSeqId);
            mergePatchShipmentPackage.getShipmentPackageContentCommands().add(removeShipmentPackageContent);
            mergePatchShipmentPackage.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentPackageApplicationService.when(mergePatchShipmentPackage);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * ShipmentPackageContent List
     */
    @GetMapping("{shipmentPackageId}/ShipmentPackageContents")
    public ShipmentPackageContentStateDto[] getShipmentPackageContents(@PathVariable("shipmentPackageId") String shipmentPackageId,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "filter", required = false) String filter,
                    @Specification(value = ShipmentPackageContentStateDto.class) HttpServletRequest request) {
        try {
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> ShipmentPackageResourceUtils.getShipmentPackageContentFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (ShipmentPackageContentMetadata.aliasMap.containsKey(n) ? ShipmentPackageContentMetadata.aliasMap.get(n) : n));
            Iterable<ShipmentPackageContentState> states = shipmentPackageApplicationService.getShipmentPackageContents((new AbstractValueObjectTextFormatter<ShipmentPackageId>(ShipmentPackageId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(shipmentPackageId)), c,
                    ShipmentPackageResourceUtils.getShipmentPackageContentQuerySorts(request.getParameterMap()));
            if (states == null) { return null; }
            ShipmentPackageContentStateDto.DtoConverter dtoConverter = new ShipmentPackageContentStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentPackageContentStateDtoArray(states);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 新建.
     * 新建 ShipmentPackageContent
     */
    @PostMapping(path = "{shipmentPackageId}/ShipmentPackageContents", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postShipmentPackageContents(@PathVariable("shipmentPackageId") String shipmentPackageId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchShipmentPackageContentDto.CreateShipmentPackageContentDto body) {
        try {
            ShipmentPackageCommand.MergePatchShipmentPackage mergePatchShipmentPackage = new AbstractShipmentPackageCommand.SimpleMergePatchShipmentPackage();
            mergePatchShipmentPackage.setShipmentPackageId((new AbstractValueObjectTextFormatter<ShipmentPackageId>(ShipmentPackageId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(shipmentPackageId)));
            mergePatchShipmentPackage.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchShipmentPackage.setVersion(version); }
            mergePatchShipmentPackage.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            ShipmentPackageContentCommand.CreateShipmentPackageContent createShipmentPackageContent = body.toCreateShipmentPackageContent();
            mergePatchShipmentPackage.getShipmentPackageContentCommands().add(createShipmentPackageContent);
            mergePatchShipmentPackage.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentPackageApplicationService.when(mergePatchShipmentPackage);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    //protected  ShipmentPackageStateEventDtoConverter getShipmentPackageStateEventDtoConverter() {
    //    return new ShipmentPackageStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return ShipmentPackageResourceUtils.getFilterPropertyType(propertyName);
            }
        };
    }

    protected PropertyTypeResolver getShipmentPackageContentPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return ShipmentPackageResourceUtils.getShipmentPackageContentFilterPropertyType(propertyName);
            }
        };
    }

    // ////////////////////////////////
 
    public static class ShipmentPackageResourceUtils {

        public static ShipmentPackageId parseIdString(String idString) {
            TextFormatter<ShipmentPackageId> formatter =
                    new AbstractValueObjectTextFormatter<ShipmentPackageId>(ShipmentPackageId.class) {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    };
            return formatter.parse(idString);
        }

        public static void setNullIdOrThrowOnInconsistentIds(String shipmentPackageId, ShipmentPackageCommand value) {
            ShipmentPackageId idObj = parseIdString(shipmentPackageId);
            if (value.getShipmentPackageId() == null) {
                value.setShipmentPackageId(idObj);
            } else if (!value.getShipmentPackageId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", shipmentPackageId, value.getShipmentPackageId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, ShipmentPackageMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, ShipmentPackageMetadata.aliasMap);
        }

        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (ShipmentPackageMetadata.aliasMap.containsKey(fieldName)) {
                return ShipmentPackageMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (ShipmentPackageMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = ShipmentPackageMetadata.propertyTypeMap.get(propertyName);
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

        public static List<String> getShipmentPackageContentQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, ShipmentPackageContentMetadata.aliasMap);
        }

        public static List<String> getShipmentPackageContentQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, ShipmentPackageContentMetadata.aliasMap);
        }

        public static String getShipmentPackageContentFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (ShipmentPackageContentMetadata.aliasMap.containsKey(fieldName)) {
                return ShipmentPackageContentMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getShipmentPackageContentFilterPropertyType(String propertyName) {
            if (ShipmentPackageContentMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = ShipmentPackageContentMetadata.propertyTypeMap.get(propertyName);
                if (!StringHelper.isNullOrEmpty(propertyType)) {
                    if (org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.containsKey(propertyType)) {
                        return org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.get(propertyType);
                    }
                }
            }
            return String.class;
        }

        public static Iterable<Map.Entry<String, Object>> getShipmentPackageContentQueryFilterMap(Map<String, String[]> queryNameValuePairs) {
            Map<String, Object> filter = new HashMap<>();
            queryNameValuePairs.forEach((key, values) -> {
                if (values.length > 0) {
                    String pName = getShipmentPackageContentFilterPropertyName(key);
                    if (!StringHelper.isNullOrEmpty(pName)) {
                        Class pClass = getShipmentPackageContentFilterPropertyType(pName);
                        filter.put(pName, ApplicationContext.current.getTypeConverter().convertFromString(pClass, values[0]));
                    }
                }
            });
            return filter.entrySet();
        }

        public static ShipmentPackageStateDto[] toShipmentPackageStateDtoArray(Iterable<ShipmentPackageId> ids) {
            List<ShipmentPackageStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                ShipmentPackageStateDto dto = new ShipmentPackageStateDto();
                dto.setShipmentPackageId(i);
                states.add(dto);
            });
            return states.toArray(new ShipmentPackageStateDto[0]);
        }

    }

}

