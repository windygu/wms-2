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
import org.dddml.wms.domain.shipment.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "Shipments", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ShipmentResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private ShipmentApplicationService shipmentApplicationService;


    /**
     * 查询.
     * 查询 Shipments
     */
    @GetMapping
    public ShipmentStateDto[] getAll(@Specification(value = ShipmentStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }

            Iterable<ShipmentState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> ShipmentResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (ShipmentMetadata.aliasMap.containsKey(n) ? ShipmentMetadata.aliasMap.get(n) : n));
            states = shipmentApplicationService.get(
                c,
                ShipmentResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            ShipmentStateDto.DtoConverter dtoConverter = new ShipmentStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查询.
     * 分页查询 Shipments
     */
    @GetMapping("_page")
    public Page<ShipmentStateDto> getPage(@Specification(value = ShipmentStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<ShipmentState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> ShipmentResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (ShipmentMetadata.aliasMap.containsKey(n) ? ShipmentMetadata.aliasMap.get(n) : n));
            states = shipmentApplicationService.get(
                c,
                ShipmentResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = shipmentApplicationService.getCount(c);

            ShipmentStateDto.DtoConverter dtoConverter = new ShipmentStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<ShipmentStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toShipmentStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 Shipment
     */
    @GetMapping("{shipmentId}")
    public ShipmentStateDto get(@PathVariable("shipmentId") String shipmentId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = shipmentId;
            ShipmentState state = shipmentApplicationService.get(idObj);
            if (state == null) { return null; }

            ShipmentStateDto.DtoConverter dtoConverter = new ShipmentStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_count")
    public long getCount(@Specification(value = ShipmentStateDto.class) HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSONObject.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap());
            }
            count = shipmentApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (ShipmentMetadata.aliasMap.containsKey(n) ? ShipmentMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 新建.
     * 新建 Shipment
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody CreateOrMergePatchShipmentDto.CreateShipmentDto value,  HttpServletResponse response) {
        try {
            ShipmentCommand.CreateShipment cmd = value.toCreateShipment();
            if (cmd.getShipmentId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "Shipment");
            }
            String idObj = cmd.getShipmentId();
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 Shipment
     */
    @PutMapping("{shipmentId}")
    public void put(@PathVariable("shipmentId") String shipmentId, @RequestBody CreateOrMergePatchShipmentDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                ShipmentCommand.MergePatchShipment cmd = (ShipmentCommand.MergePatchShipment) value.toCommand();
                ShipmentResourceUtils.setNullIdOrThrowOnInconsistentIds(shipmentId, cmd);
                cmd.setRequesterId(SecurityContextUtil.getRequesterId());
                shipmentApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            ShipmentCommand.CreateShipment cmd = (ShipmentCommand.CreateShipment) value.toCommand();
            ShipmentResourceUtils.setNullIdOrThrowOnInconsistentIds(shipmentId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 修改.
     * 修改 Shipment
     */
    @PatchMapping("{shipmentId}")
    public void patch(@PathVariable("shipmentId") String shipmentId, @RequestBody CreateOrMergePatchShipmentDto.MergePatchShipmentDto value) {
        try {

            ShipmentCommand.MergePatchShipment cmd = value.toMergePatchShipment();
            ShipmentResourceUtils.setNullIdOrThrowOnInconsistentIds(shipmentId, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    @PutMapping("{shipmentId}/_commands/Import")
    public void _import(@PathVariable("shipmentId") String shipmentId, @RequestBody ShipmentCommands.Import content) {
        try {

            ShipmentCommands.Import cmd = content;//.toImport();
            String idObj = shipmentId;
            if (cmd.getShipmentId() == null) {
                cmd.setShipmentId(idObj);
            } else if (!cmd.getShipmentId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", shipmentId, cmd.getShipmentId());
            }
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    @PutMapping("{shipmentId}/_commands/Ship")
    public void ship(@PathVariable("shipmentId") String shipmentId, @RequestBody ShipmentCommands.Ship content) {
        try {

            ShipmentCommands.Ship cmd = content;//.toShip();
            String idObj = shipmentId;
            if (cmd.getShipmentId() == null) {
                cmd.setShipmentId(idObj);
            } else if (!cmd.getShipmentId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", shipmentId, cmd.getShipmentId());
            }
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    @PutMapping("{shipmentId}/_commands/ReceiveItem")
    public void receiveItem(@PathVariable("shipmentId") String shipmentId, @RequestBody ShipmentCommands.ReceiveItem content) {
        try {

            ShipmentCommands.ReceiveItem cmd = content;//.toReceiveItem();
            String idObj = shipmentId;
            if (cmd.getShipmentId() == null) {
                cmd.setShipmentId(idObj);
            } else if (!cmd.getShipmentId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", shipmentId, cmd.getShipmentId());
            }
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    @PutMapping("{shipmentId}/_commands/AddItemAndReceipt")
    public void addItemAndReceipt(@PathVariable("shipmentId") String shipmentId, @RequestBody ShipmentCommands.AddItemAndReceipt content) {
        try {

            ShipmentCommands.AddItemAndReceipt cmd = content;//.toAddItemAndReceipt();
            String idObj = shipmentId;
            if (cmd.getShipmentId() == null) {
                cmd.setShipmentId(idObj);
            } else if (!cmd.getShipmentId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", shipmentId, cmd.getShipmentId());
            }
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    @PutMapping("{shipmentId}/_commands/IssueItem")
    public void issueItem(@PathVariable("shipmentId") String shipmentId, @RequestBody ShipmentCommands.IssueItem content) {
        try {

            ShipmentCommands.IssueItem cmd = content;//.toIssueItem();
            String idObj = shipmentId;
            if (cmd.getShipmentId() == null) {
                cmd.setShipmentId(idObj);
            } else if (!cmd.getShipmentId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", shipmentId, cmd.getShipmentId());
            }
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    @PutMapping("{shipmentId}/_commands/AddItemAndIssuance")
    public void addItemAndIssuance(@PathVariable("shipmentId") String shipmentId, @RequestBody ShipmentCommands.AddItemAndIssuance content) {
        try {

            ShipmentCommands.AddItemAndIssuance cmd = content;//.toAddItemAndIssuance();
            String idObj = shipmentId;
            if (cmd.getShipmentId() == null) {
                cmd.setShipmentId(idObj);
            } else if (!cmd.getShipmentId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", shipmentId, cmd.getShipmentId());
            }
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    @PutMapping("{shipmentId}/_commands/ConfirmAllItemsReceived")
    public void confirmAllItemsReceived(@PathVariable("shipmentId") String shipmentId, @RequestBody ShipmentCommands.ConfirmAllItemsReceived content) {
        try {

            ShipmentCommands.ConfirmAllItemsReceived cmd = content;//.toConfirmAllItemsReceived();
            String idObj = shipmentId;
            if (cmd.getShipmentId() == null) {
                cmd.setShipmentId(idObj);
            } else if (!cmd.getShipmentId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", shipmentId, cmd.getShipmentId());
            }
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    @PutMapping("{shipmentId}/_commands/ConfirmAllItemsIssued")
    public void confirmAllItemsIssued(@PathVariable("shipmentId") String shipmentId, @RequestBody ShipmentCommands.ConfirmAllItemsIssued content) {
        try {

            ShipmentCommands.ConfirmAllItemsIssued cmd = content;//.toConfirmAllItemsIssued();
            String idObj = shipmentId;
            if (cmd.getShipmentId() == null) {
                cmd.setShipmentId(idObj);
            } else if (!cmd.getShipmentId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", shipmentId, cmd.getShipmentId());
            }
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    @PutMapping("{shipmentId}/_commands/PurchaseShipmentAction")
    public void purchaseShipmentAction(@PathVariable("shipmentId") String shipmentId, @RequestBody ShipmentCommands.PurchaseShipmentAction content) {
        try {

            ShipmentCommands.PurchaseShipmentAction cmd = content;//.toPurchaseShipmentAction();
            String idObj = shipmentId;
            if (cmd.getShipmentId() == null) {
                cmd.setShipmentId(idObj);
            } else if (!cmd.getShipmentId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", shipmentId, cmd.getShipmentId());
            }
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    @PutMapping("{shipmentId}/_commands/SalesShipmentAction")
    public void salesShipmentAction(@PathVariable("shipmentId") String shipmentId, @RequestBody ShipmentCommands.SalesShipmentAction content) {
        try {

            ShipmentCommands.SalesShipmentAction cmd = content;//.toSalesShipmentAction();
            String idObj = shipmentId;
            if (cmd.getShipmentId() == null) {
                cmd.setShipmentId(idObj);
            } else if (!cmd.getShipmentId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", shipmentId, cmd.getShipmentId());
            }
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            ShipmentMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{shipmentId}/_events/{version}")
    public ShipmentEvent getStateEvent(@PathVariable("shipmentId") String shipmentId, @PathVariable("version") long version) {
        try {

            String idObj = shipmentId;
            //ShipmentStateEventDtoConverter dtoConverter = getShipmentStateEventDtoConverter();
            return shipmentApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{shipmentId}/_historyStates/{version}")
    public ShipmentStateDto getHistoryState(@PathVariable("shipmentId") String shipmentId, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = shipmentId;
            ShipmentStateDto.DtoConverter dtoConverter = new ShipmentStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentStateDto(shipmentApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 获取指定 SequenceId 的 ShipmentImage
     */
    @GetMapping("{shipmentId}/ShipmentImages/{sequenceId}")
    public ShipmentImageStateDto getShipmentImage(@PathVariable("shipmentId") String shipmentId, @PathVariable("sequenceId") String sequenceId) {
        try {

            ShipmentImageState state = shipmentApplicationService.getShipmentImage(shipmentId, sequenceId);
            if (state == null) { return null; }
            ShipmentImageStateDto.DtoConverter dtoConverter = new ShipmentImageStateDto.DtoConverter();
            ShipmentImageStateDto stateDto = dtoConverter.toShipmentImageStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 创建 or 修改.
     * 创建 or 修改 ShipmentImage
     */
    @PutMapping(path = "{shipmentId}/ShipmentImages/{sequenceId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putShipmentImage(@PathVariable("shipmentId") String shipmentId, @PathVariable("sequenceId") String sequenceId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchShipmentImageDto.MergePatchShipmentImageDto body) {
        try {
            ShipmentCommand.MergePatchShipment mergePatchShipment = new AbstractShipmentCommand.SimpleMergePatchShipment();
            mergePatchShipment.setShipmentId(shipmentId);
            mergePatchShipment.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchShipment.setVersion(version); }
            mergePatchShipment.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            ShipmentImageCommand.MergePatchShipmentImage mergePatchShipmentImage = body.toMergePatchShipmentImage();
            mergePatchShipmentImage.setSequenceId(sequenceId);
            mergePatchShipment.getShipmentImageCommands().add(mergePatchShipmentImage);
            mergePatchShipment.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(mergePatchShipment);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 移除.
     * 移除 ShipmentImage
     */
    @DeleteMapping("{shipmentId}/ShipmentImages/{sequenceId}")
    public void deleteShipmentImage(@PathVariable("shipmentId") String shipmentId, @PathVariable("sequenceId") String sequenceId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            ShipmentCommand.MergePatchShipment mergePatchShipment = new AbstractShipmentCommand.SimpleMergePatchShipment();
            mergePatchShipment.setShipmentId(shipmentId);
            mergePatchShipment.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { 
                mergePatchShipment.setVersion(version); 
            } else {
                mergePatchShipment.setVersion(shipmentApplicationService.get(shipmentId).getVersion());
            }
            mergePatchShipment.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            ShipmentImageCommand.RemoveShipmentImage removeShipmentImage = new AbstractShipmentImageCommand.SimpleRemoveShipmentImage();
            removeShipmentImage.setSequenceId(sequenceId);
            mergePatchShipment.getShipmentImageCommands().add(removeShipmentImage);
            mergePatchShipment.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(mergePatchShipment);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * ShipmentImage List
     */
    @GetMapping("{shipmentId}/ShipmentImages")
    public ShipmentImageStateDto[] getShipmentImages(@PathVariable("shipmentId") String shipmentId,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "filter", required = false) String filter,
                    @Specification(value = ShipmentImageStateDto.class) HttpServletRequest request) {
        try {
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> ShipmentResourceUtils.getShipmentImageFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (ShipmentImageMetadata.aliasMap.containsKey(n) ? ShipmentImageMetadata.aliasMap.get(n) : n));
            Iterable<ShipmentImageState> states = shipmentApplicationService.getShipmentImages(shipmentId, c,
                    ShipmentResourceUtils.getShipmentImageQuerySorts(request.getParameterMap()));
            if (states == null) { return null; }
            ShipmentImageStateDto.DtoConverter dtoConverter = new ShipmentImageStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentImageStateDtoArray(states);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 新建.
     * 新建 ShipmentImage
     */
    @PostMapping(path = "{shipmentId}/ShipmentImages", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postShipmentImages(@PathVariable("shipmentId") String shipmentId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchShipmentImageDto.CreateShipmentImageDto body) {
        try {
            ShipmentCommand.MergePatchShipment mergePatchShipment = new AbstractShipmentCommand.SimpleMergePatchShipment();
            mergePatchShipment.setShipmentId(shipmentId);
            mergePatchShipment.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchShipment.setVersion(version); }
            mergePatchShipment.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            ShipmentImageCommand.CreateShipmentImage createShipmentImage = body.toCreateShipmentImage();
            mergePatchShipment.getShipmentImageCommands().add(createShipmentImage);
            mergePatchShipment.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(mergePatchShipment);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 获取指定 ShipmentItemSeqId 的 ShipmentItem
     */
    @GetMapping("{shipmentId}/ShipmentItems/{shipmentItemSeqId}")
    public ShipmentItemStateDto getShipmentItem(@PathVariable("shipmentId") String shipmentId, @PathVariable("shipmentItemSeqId") String shipmentItemSeqId) {
        try {

            ShipmentItemState state = shipmentApplicationService.getShipmentItem(shipmentId, shipmentItemSeqId);
            if (state == null) { return null; }
            ShipmentItemStateDto.DtoConverter dtoConverter = new ShipmentItemStateDto.DtoConverter();
            ShipmentItemStateDto stateDto = dtoConverter.toShipmentItemStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 创建 or 修改.
     * 创建 or 修改 ShipmentItem
     */
    @PutMapping(path = "{shipmentId}/ShipmentItems/{shipmentItemSeqId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putShipmentItem(@PathVariable("shipmentId") String shipmentId, @PathVariable("shipmentItemSeqId") String shipmentItemSeqId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchShipmentItemDto.MergePatchShipmentItemDto body) {
        try {
            ShipmentCommand.MergePatchShipment mergePatchShipment = new AbstractShipmentCommand.SimpleMergePatchShipment();
            mergePatchShipment.setShipmentId(shipmentId);
            mergePatchShipment.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchShipment.setVersion(version); }
            mergePatchShipment.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            ShipmentItemCommand.MergePatchShipmentItem mergePatchShipmentItem = body.toMergePatchShipmentItem();
            mergePatchShipmentItem.setShipmentItemSeqId(shipmentItemSeqId);
            mergePatchShipment.getShipmentItemCommands().add(mergePatchShipmentItem);
            mergePatchShipment.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(mergePatchShipment);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 移除.
     * 移除 ShipmentItem
     */
    @DeleteMapping("{shipmentId}/ShipmentItems/{shipmentItemSeqId}")
    public void deleteShipmentItem(@PathVariable("shipmentId") String shipmentId, @PathVariable("shipmentItemSeqId") String shipmentItemSeqId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            ShipmentCommand.MergePatchShipment mergePatchShipment = new AbstractShipmentCommand.SimpleMergePatchShipment();
            mergePatchShipment.setShipmentId(shipmentId);
            mergePatchShipment.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { 
                mergePatchShipment.setVersion(version); 
            } else {
                mergePatchShipment.setVersion(shipmentApplicationService.get(shipmentId).getVersion());
            }
            mergePatchShipment.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            ShipmentItemCommand.RemoveShipmentItem removeShipmentItem = new AbstractShipmentItemCommand.SimpleRemoveShipmentItem();
            removeShipmentItem.setShipmentItemSeqId(shipmentItemSeqId);
            mergePatchShipment.getShipmentItemCommands().add(removeShipmentItem);
            mergePatchShipment.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(mergePatchShipment);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * ShipmentItem List
     */
    @GetMapping("{shipmentId}/ShipmentItems")
    public ShipmentItemStateDto[] getShipmentItems(@PathVariable("shipmentId") String shipmentId,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "filter", required = false) String filter,
                    @Specification(value = ShipmentItemStateDto.class) HttpServletRequest request) {
        try {
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> ShipmentResourceUtils.getShipmentItemFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (ShipmentItemMetadata.aliasMap.containsKey(n) ? ShipmentItemMetadata.aliasMap.get(n) : n));
            Iterable<ShipmentItemState> states = shipmentApplicationService.getShipmentItems(shipmentId, c,
                    ShipmentResourceUtils.getShipmentItemQuerySorts(request.getParameterMap()));
            if (states == null) { return null; }
            ShipmentItemStateDto.DtoConverter dtoConverter = new ShipmentItemStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentItemStateDtoArray(states);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 新建.
     * 新建 ShipmentItem
     */
    @PostMapping(path = "{shipmentId}/ShipmentItems", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postShipmentItems(@PathVariable("shipmentId") String shipmentId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchShipmentItemDto.CreateShipmentItemDto body) {
        try {
            ShipmentCommand.MergePatchShipment mergePatchShipment = new AbstractShipmentCommand.SimpleMergePatchShipment();
            mergePatchShipment.setShipmentId(shipmentId);
            mergePatchShipment.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchShipment.setVersion(version); }
            mergePatchShipment.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            ShipmentItemCommand.CreateShipmentItem createShipmentItem = body.toCreateShipmentItem();
            mergePatchShipment.getShipmentItemCommands().add(createShipmentItem);
            mergePatchShipment.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(mergePatchShipment);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 获取指定 ReceiptSeqId 的 ShipmentReceipt
     */
    @GetMapping("{shipmentId}/ShipmentReceipts/{receiptSeqId}")
    public ShipmentReceiptStateDto getShipmentReceipt(@PathVariable("shipmentId") String shipmentId, @PathVariable("receiptSeqId") String receiptSeqId) {
        try {

            ShipmentReceiptState state = shipmentApplicationService.getShipmentReceipt(shipmentId, receiptSeqId);
            if (state == null) { return null; }
            ShipmentReceiptStateDto.DtoConverter dtoConverter = new ShipmentReceiptStateDto.DtoConverter();
            ShipmentReceiptStateDto stateDto = dtoConverter.toShipmentReceiptStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 创建 or 修改.
     * 创建 or 修改 ShipmentReceipt
     */
    @PutMapping(path = "{shipmentId}/ShipmentReceipts/{receiptSeqId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putShipmentReceipt(@PathVariable("shipmentId") String shipmentId, @PathVariable("receiptSeqId") String receiptSeqId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchShipmentReceiptDto.MergePatchShipmentReceiptDto body) {
        try {
            ShipmentCommand.MergePatchShipment mergePatchShipment = new AbstractShipmentCommand.SimpleMergePatchShipment();
            mergePatchShipment.setShipmentId(shipmentId);
            mergePatchShipment.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchShipment.setVersion(version); }
            mergePatchShipment.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            ShipmentReceiptCommand.MergePatchShipmentReceipt mergePatchShipmentReceipt = body.toMergePatchShipmentReceipt();
            mergePatchShipmentReceipt.setReceiptSeqId(receiptSeqId);
            mergePatchShipment.getShipmentReceiptCommands().add(mergePatchShipmentReceipt);
            mergePatchShipment.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(mergePatchShipment);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 移除.
     * 移除 ShipmentReceipt
     */
    @DeleteMapping("{shipmentId}/ShipmentReceipts/{receiptSeqId}")
    public void deleteShipmentReceipt(@PathVariable("shipmentId") String shipmentId, @PathVariable("receiptSeqId") String receiptSeqId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            ShipmentCommand.MergePatchShipment mergePatchShipment = new AbstractShipmentCommand.SimpleMergePatchShipment();
            mergePatchShipment.setShipmentId(shipmentId);
            mergePatchShipment.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { 
                mergePatchShipment.setVersion(version); 
            } else {
                mergePatchShipment.setVersion(shipmentApplicationService.get(shipmentId).getVersion());
            }
            mergePatchShipment.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            ShipmentReceiptCommand.RemoveShipmentReceipt removeShipmentReceipt = new AbstractShipmentReceiptCommand.SimpleRemoveShipmentReceipt();
            removeShipmentReceipt.setReceiptSeqId(receiptSeqId);
            mergePatchShipment.getShipmentReceiptCommands().add(removeShipmentReceipt);
            mergePatchShipment.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(mergePatchShipment);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * ShipmentReceipt List
     */
    @GetMapping("{shipmentId}/ShipmentReceipts")
    public ShipmentReceiptStateDto[] getShipmentReceipts(@PathVariable("shipmentId") String shipmentId,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "filter", required = false) String filter,
                    @Specification(value = ShipmentReceiptStateDto.class) HttpServletRequest request) {
        try {
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> ShipmentResourceUtils.getShipmentReceiptFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (ShipmentReceiptMetadata.aliasMap.containsKey(n) ? ShipmentReceiptMetadata.aliasMap.get(n) : n));
            Iterable<ShipmentReceiptState> states = shipmentApplicationService.getShipmentReceipts(shipmentId, c,
                    ShipmentResourceUtils.getShipmentReceiptQuerySorts(request.getParameterMap()));
            if (states == null) { return null; }
            ShipmentReceiptStateDto.DtoConverter dtoConverter = new ShipmentReceiptStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentReceiptStateDtoArray(states);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 新建.
     * 新建 ShipmentReceipt
     */
    @PostMapping(path = "{shipmentId}/ShipmentReceipts", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postShipmentReceipts(@PathVariable("shipmentId") String shipmentId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchShipmentReceiptDto.CreateShipmentReceiptDto body) {
        try {
            ShipmentCommand.MergePatchShipment mergePatchShipment = new AbstractShipmentCommand.SimpleMergePatchShipment();
            mergePatchShipment.setShipmentId(shipmentId);
            mergePatchShipment.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchShipment.setVersion(version); }
            mergePatchShipment.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            ShipmentReceiptCommand.CreateShipmentReceipt createShipmentReceipt = body.toCreateShipmentReceipt();
            mergePatchShipment.getShipmentReceiptCommands().add(createShipmentReceipt);
            mergePatchShipment.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(mergePatchShipment);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 获取指定 SequenceId 的 ShipmentReceiptImage
     */
    @GetMapping("{shipmentId}/ShipmentReceipts/{shipmentReceiptReceiptSeqId}/ShipmentReceiptImages/{sequenceId}")
    public ShipmentReceiptImageStateDto getShipmentReceiptImage(@PathVariable("shipmentId") String shipmentId, @PathVariable("shipmentReceiptReceiptSeqId") String shipmentReceiptReceiptSeqId, @PathVariable("sequenceId") String sequenceId) {
        try {

            ShipmentReceiptImageState state = shipmentApplicationService.getShipmentReceiptImage(shipmentId, shipmentReceiptReceiptSeqId, sequenceId);
            if (state == null) { return null; }
            ShipmentReceiptImageStateDto.DtoConverter dtoConverter = new ShipmentReceiptImageStateDto.DtoConverter();
            ShipmentReceiptImageStateDto stateDto = dtoConverter.toShipmentReceiptImageStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 创建 or 修改.
     * 创建 or 修改 ShipmentReceiptImage
     */
    @PutMapping(path = "{shipmentId}/ShipmentReceipts/{shipmentReceiptReceiptSeqId}/ShipmentReceiptImages/{sequenceId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putShipmentReceiptImage(@PathVariable("shipmentId") String shipmentId, @PathVariable("shipmentReceiptReceiptSeqId") String shipmentReceiptReceiptSeqId, @PathVariable("sequenceId") String sequenceId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchShipmentReceiptImageDto.MergePatchShipmentReceiptImageDto body) {
        try {
            ShipmentCommand.MergePatchShipment mergePatchShipment = new AbstractShipmentCommand.SimpleMergePatchShipment();
            mergePatchShipment.setShipmentId(shipmentId);
            mergePatchShipment.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchShipment.setVersion(version); }
            mergePatchShipment.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            ShipmentReceiptCommand.MergePatchShipmentReceipt mergePatchShipmentReceipt = new AbstractShipmentReceiptCommand.SimpleMergePatchShipmentReceipt();
            mergePatchShipmentReceipt.setReceiptSeqId(shipmentReceiptReceiptSeqId);
            mergePatchShipment.getShipmentReceiptCommands().add(mergePatchShipmentReceipt);
            ShipmentReceiptImageCommand.MergePatchShipmentReceiptImage mergePatchShipmentReceiptImage = body.toMergePatchShipmentReceiptImage();
            mergePatchShipmentReceiptImage.setSequenceId(sequenceId);
            mergePatchShipmentReceipt.getShipmentReceiptImageCommands().add(mergePatchShipmentReceiptImage);
            mergePatchShipment.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(mergePatchShipment);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 移除.
     * 移除 ShipmentReceiptImage
     */
    @DeleteMapping("{shipmentId}/ShipmentReceipts/{shipmentReceiptReceiptSeqId}/ShipmentReceiptImages/{sequenceId}")
    public void deleteShipmentReceiptImage(@PathVariable("shipmentId") String shipmentId, @PathVariable("shipmentReceiptReceiptSeqId") String shipmentReceiptReceiptSeqId, @PathVariable("sequenceId") String sequenceId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            ShipmentCommand.MergePatchShipment mergePatchShipment = new AbstractShipmentCommand.SimpleMergePatchShipment();
            mergePatchShipment.setShipmentId(shipmentId);
            mergePatchShipment.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { 
                mergePatchShipment.setVersion(version); 
            } else {
                mergePatchShipment.setVersion(shipmentApplicationService.get(shipmentId).getVersion());
            }
            mergePatchShipment.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            ShipmentReceiptCommand.MergePatchShipmentReceipt mergePatchShipmentReceipt = new AbstractShipmentReceiptCommand.SimpleMergePatchShipmentReceipt();
            mergePatchShipmentReceipt.setReceiptSeqId(shipmentReceiptReceiptSeqId);
            mergePatchShipment.getShipmentReceiptCommands().add(mergePatchShipmentReceipt);
            ShipmentReceiptImageCommand.RemoveShipmentReceiptImage removeShipmentReceiptImage = new AbstractShipmentReceiptImageCommand.SimpleRemoveShipmentReceiptImage();
            removeShipmentReceiptImage.setSequenceId(sequenceId);
            mergePatchShipmentReceipt.getShipmentReceiptImageCommands().add(removeShipmentReceiptImage);
            mergePatchShipment.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(mergePatchShipment);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * ShipmentReceiptImage List
     */
    @GetMapping("{shipmentId}/ShipmentReceipts/{shipmentReceiptReceiptSeqId}/ShipmentReceiptImages")
    public ShipmentReceiptImageStateDto[] getShipmentReceiptImages(@PathVariable("shipmentId") String shipmentId, @PathVariable("shipmentReceiptReceiptSeqId") String shipmentReceiptReceiptSeqId,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "filter", required = false) String filter,
                    @Specification(value = ShipmentReceiptImageStateDto.class) HttpServletRequest request) {
        try {
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> ShipmentResourceUtils.getShipmentReceiptImageFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (ShipmentReceiptImageMetadata.aliasMap.containsKey(n) ? ShipmentReceiptImageMetadata.aliasMap.get(n) : n));
            Iterable<ShipmentReceiptImageState> states = shipmentApplicationService.getShipmentReceiptImages(shipmentId, shipmentReceiptReceiptSeqId, c,
                    ShipmentResourceUtils.getShipmentReceiptImageQuerySorts(request.getParameterMap()));
            if (states == null) { return null; }
            ShipmentReceiptImageStateDto.DtoConverter dtoConverter = new ShipmentReceiptImageStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentReceiptImageStateDtoArray(states);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 新建.
     * 新建 ShipmentReceiptImage
     */
    @PostMapping(path = "{shipmentId}/ShipmentReceipts/{shipmentReceiptReceiptSeqId}/ShipmentReceiptImages", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postShipmentReceiptImages(@PathVariable("shipmentId") String shipmentId, @PathVariable("shipmentReceiptReceiptSeqId") String shipmentReceiptReceiptSeqId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchShipmentReceiptImageDto.CreateShipmentReceiptImageDto body) {
        try {
            ShipmentCommand.MergePatchShipment mergePatchShipment = new AbstractShipmentCommand.SimpleMergePatchShipment();
            mergePatchShipment.setShipmentId(shipmentId);
            mergePatchShipment.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchShipment.setVersion(version); }
            mergePatchShipment.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            ShipmentReceiptCommand.MergePatchShipmentReceipt mergePatchShipmentReceipt = new AbstractShipmentReceiptCommand.SimpleMergePatchShipmentReceipt();
            mergePatchShipmentReceipt.setReceiptSeqId(shipmentReceiptReceiptSeqId);
            mergePatchShipment.getShipmentReceiptCommands().add(mergePatchShipmentReceipt);
            ShipmentReceiptImageCommand.CreateShipmentReceiptImage createShipmentReceiptImage = body.toCreateShipmentReceiptImage();
            mergePatchShipmentReceipt.getShipmentReceiptImageCommands().add(createShipmentReceiptImage);
            mergePatchShipment.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(mergePatchShipment);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 获取指定 ItemIssuanceSeqId 的 ItemIssuance
     */
    @GetMapping("{shipmentId}/ItemIssuances/{itemIssuanceSeqId}")
    public ItemIssuanceStateDto getItemIssuance(@PathVariable("shipmentId") String shipmentId, @PathVariable("itemIssuanceSeqId") String itemIssuanceSeqId) {
        try {

            ItemIssuanceState state = shipmentApplicationService.getItemIssuance(shipmentId, itemIssuanceSeqId);
            if (state == null) { return null; }
            ItemIssuanceStateDto.DtoConverter dtoConverter = new ItemIssuanceStateDto.DtoConverter();
            ItemIssuanceStateDto stateDto = dtoConverter.toItemIssuanceStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 创建 or 修改.
     * 创建 or 修改 ItemIssuance
     */
    @PutMapping(path = "{shipmentId}/ItemIssuances/{itemIssuanceSeqId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putItemIssuance(@PathVariable("shipmentId") String shipmentId, @PathVariable("itemIssuanceSeqId") String itemIssuanceSeqId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchItemIssuanceDto.MergePatchItemIssuanceDto body) {
        try {
            ShipmentCommand.MergePatchShipment mergePatchShipment = new AbstractShipmentCommand.SimpleMergePatchShipment();
            mergePatchShipment.setShipmentId(shipmentId);
            mergePatchShipment.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchShipment.setVersion(version); }
            mergePatchShipment.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            ItemIssuanceCommand.MergePatchItemIssuance mergePatchItemIssuance = body.toMergePatchItemIssuance();
            mergePatchItemIssuance.setItemIssuanceSeqId(itemIssuanceSeqId);
            mergePatchShipment.getItemIssuanceCommands().add(mergePatchItemIssuance);
            mergePatchShipment.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(mergePatchShipment);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 移除.
     * 移除 ItemIssuance
     */
    @DeleteMapping("{shipmentId}/ItemIssuances/{itemIssuanceSeqId}")
    public void deleteItemIssuance(@PathVariable("shipmentId") String shipmentId, @PathVariable("itemIssuanceSeqId") String itemIssuanceSeqId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            ShipmentCommand.MergePatchShipment mergePatchShipment = new AbstractShipmentCommand.SimpleMergePatchShipment();
            mergePatchShipment.setShipmentId(shipmentId);
            mergePatchShipment.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { 
                mergePatchShipment.setVersion(version); 
            } else {
                mergePatchShipment.setVersion(shipmentApplicationService.get(shipmentId).getVersion());
            }
            mergePatchShipment.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            ItemIssuanceCommand.RemoveItemIssuance removeItemIssuance = new AbstractItemIssuanceCommand.SimpleRemoveItemIssuance();
            removeItemIssuance.setItemIssuanceSeqId(itemIssuanceSeqId);
            mergePatchShipment.getItemIssuanceCommands().add(removeItemIssuance);
            mergePatchShipment.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(mergePatchShipment);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * ItemIssuance List
     */
    @GetMapping("{shipmentId}/ItemIssuances")
    public ItemIssuanceStateDto[] getItemIssuances(@PathVariable("shipmentId") String shipmentId,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "filter", required = false) String filter,
                    @Specification(value = ItemIssuanceStateDto.class) HttpServletRequest request) {
        try {
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> ShipmentResourceUtils.getItemIssuanceFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (ItemIssuanceMetadata.aliasMap.containsKey(n) ? ItemIssuanceMetadata.aliasMap.get(n) : n));
            Iterable<ItemIssuanceState> states = shipmentApplicationService.getItemIssuances(shipmentId, c,
                    ShipmentResourceUtils.getItemIssuanceQuerySorts(request.getParameterMap()));
            if (states == null) { return null; }
            ItemIssuanceStateDto.DtoConverter dtoConverter = new ItemIssuanceStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toItemIssuanceStateDtoArray(states);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 新建.
     * 新建 ItemIssuance
     */
    @PostMapping(path = "{shipmentId}/ItemIssuances", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postItemIssuances(@PathVariable("shipmentId") String shipmentId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchItemIssuanceDto.CreateItemIssuanceDto body) {
        try {
            ShipmentCommand.MergePatchShipment mergePatchShipment = new AbstractShipmentCommand.SimpleMergePatchShipment();
            mergePatchShipment.setShipmentId(shipmentId);
            mergePatchShipment.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchShipment.setVersion(version); }
            mergePatchShipment.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            ItemIssuanceCommand.CreateItemIssuance createItemIssuance = body.toCreateItemIssuance();
            mergePatchShipment.getItemIssuanceCommands().add(createItemIssuance);
            mergePatchShipment.setRequesterId(SecurityContextUtil.getRequesterId());
            shipmentApplicationService.when(mergePatchShipment);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    //protected  ShipmentStateEventDtoConverter getShipmentStateEventDtoConverter() {
    //    return new ShipmentStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return ShipmentResourceUtils.getFilterPropertyType(propertyName);
            }
        };
    }

    protected PropertyTypeResolver getShipmentImagePropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return ShipmentResourceUtils.getShipmentImageFilterPropertyType(propertyName);
            }
        };
    }

    protected PropertyTypeResolver getShipmentItemPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return ShipmentResourceUtils.getShipmentItemFilterPropertyType(propertyName);
            }
        };
    }

    protected PropertyTypeResolver getShipmentReceiptPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return ShipmentResourceUtils.getShipmentReceiptFilterPropertyType(propertyName);
            }
        };
    }

    protected PropertyTypeResolver getShipmentReceiptImagePropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return ShipmentResourceUtils.getShipmentReceiptImageFilterPropertyType(propertyName);
            }
        };
    }

    protected PropertyTypeResolver getItemIssuancePropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return ShipmentResourceUtils.getItemIssuanceFilterPropertyType(propertyName);
            }
        };
    }

    // ////////////////////////////////
 
    public static class ShipmentResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String shipmentId, ShipmentCommand value) {
            String idObj = shipmentId;
            if (value.getShipmentId() == null) {
                value.setShipmentId(idObj);
            } else if (!value.getShipmentId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", shipmentId, value.getShipmentId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, ShipmentMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, ShipmentMetadata.aliasMap);
        }

        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (ShipmentMetadata.aliasMap.containsKey(fieldName)) {
                return ShipmentMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (ShipmentMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = ShipmentMetadata.propertyTypeMap.get(propertyName);
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

        public static List<String> getShipmentImageQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, ShipmentImageMetadata.aliasMap);
        }

        public static List<String> getShipmentImageQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, ShipmentImageMetadata.aliasMap);
        }

        public static String getShipmentImageFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (ShipmentImageMetadata.aliasMap.containsKey(fieldName)) {
                return ShipmentImageMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getShipmentImageFilterPropertyType(String propertyName) {
            if (ShipmentImageMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = ShipmentImageMetadata.propertyTypeMap.get(propertyName);
                if (!StringHelper.isNullOrEmpty(propertyType)) {
                    if (org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.containsKey(propertyType)) {
                        return org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.get(propertyType);
                    }
                }
            }
            return String.class;
        }

        public static Iterable<Map.Entry<String, Object>> getShipmentImageQueryFilterMap(Map<String, String[]> queryNameValuePairs) {
            Map<String, Object> filter = new HashMap<>();
            queryNameValuePairs.forEach((key, values) -> {
                if (values.length > 0) {
                    String pName = getShipmentImageFilterPropertyName(key);
                    if (!StringHelper.isNullOrEmpty(pName)) {
                        Class pClass = getShipmentImageFilterPropertyType(pName);
                        filter.put(pName, ApplicationContext.current.getTypeConverter().convertFromString(pClass, values[0]));
                    }
                }
            });
            return filter.entrySet();
        }

        public static List<String> getShipmentItemQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, ShipmentItemMetadata.aliasMap);
        }

        public static List<String> getShipmentItemQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, ShipmentItemMetadata.aliasMap);
        }

        public static String getShipmentItemFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (ShipmentItemMetadata.aliasMap.containsKey(fieldName)) {
                return ShipmentItemMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getShipmentItemFilterPropertyType(String propertyName) {
            if (ShipmentItemMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = ShipmentItemMetadata.propertyTypeMap.get(propertyName);
                if (!StringHelper.isNullOrEmpty(propertyType)) {
                    if (org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.containsKey(propertyType)) {
                        return org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.get(propertyType);
                    }
                }
            }
            return String.class;
        }

        public static Iterable<Map.Entry<String, Object>> getShipmentItemQueryFilterMap(Map<String, String[]> queryNameValuePairs) {
            Map<String, Object> filter = new HashMap<>();
            queryNameValuePairs.forEach((key, values) -> {
                if (values.length > 0) {
                    String pName = getShipmentItemFilterPropertyName(key);
                    if (!StringHelper.isNullOrEmpty(pName)) {
                        Class pClass = getShipmentItemFilterPropertyType(pName);
                        filter.put(pName, ApplicationContext.current.getTypeConverter().convertFromString(pClass, values[0]));
                    }
                }
            });
            return filter.entrySet();
        }

        public static List<String> getShipmentReceiptQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, ShipmentReceiptMetadata.aliasMap);
        }

        public static List<String> getShipmentReceiptQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, ShipmentReceiptMetadata.aliasMap);
        }

        public static String getShipmentReceiptFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (ShipmentReceiptMetadata.aliasMap.containsKey(fieldName)) {
                return ShipmentReceiptMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getShipmentReceiptFilterPropertyType(String propertyName) {
            if (ShipmentReceiptMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = ShipmentReceiptMetadata.propertyTypeMap.get(propertyName);
                if (!StringHelper.isNullOrEmpty(propertyType)) {
                    if (org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.containsKey(propertyType)) {
                        return org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.get(propertyType);
                    }
                }
            }
            return String.class;
        }

        public static Iterable<Map.Entry<String, Object>> getShipmentReceiptQueryFilterMap(Map<String, String[]> queryNameValuePairs) {
            Map<String, Object> filter = new HashMap<>();
            queryNameValuePairs.forEach((key, values) -> {
                if (values.length > 0) {
                    String pName = getShipmentReceiptFilterPropertyName(key);
                    if (!StringHelper.isNullOrEmpty(pName)) {
                        Class pClass = getShipmentReceiptFilterPropertyType(pName);
                        filter.put(pName, ApplicationContext.current.getTypeConverter().convertFromString(pClass, values[0]));
                    }
                }
            });
            return filter.entrySet();
        }

        public static List<String> getShipmentReceiptImageQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, ShipmentReceiptImageMetadata.aliasMap);
        }

        public static List<String> getShipmentReceiptImageQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, ShipmentReceiptImageMetadata.aliasMap);
        }

        public static String getShipmentReceiptImageFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (ShipmentReceiptImageMetadata.aliasMap.containsKey(fieldName)) {
                return ShipmentReceiptImageMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getShipmentReceiptImageFilterPropertyType(String propertyName) {
            if (ShipmentReceiptImageMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = ShipmentReceiptImageMetadata.propertyTypeMap.get(propertyName);
                if (!StringHelper.isNullOrEmpty(propertyType)) {
                    if (org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.containsKey(propertyType)) {
                        return org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.get(propertyType);
                    }
                }
            }
            return String.class;
        }

        public static Iterable<Map.Entry<String, Object>> getShipmentReceiptImageQueryFilterMap(Map<String, String[]> queryNameValuePairs) {
            Map<String, Object> filter = new HashMap<>();
            queryNameValuePairs.forEach((key, values) -> {
                if (values.length > 0) {
                    String pName = getShipmentReceiptImageFilterPropertyName(key);
                    if (!StringHelper.isNullOrEmpty(pName)) {
                        Class pClass = getShipmentReceiptImageFilterPropertyType(pName);
                        filter.put(pName, ApplicationContext.current.getTypeConverter().convertFromString(pClass, values[0]));
                    }
                }
            });
            return filter.entrySet();
        }

        public static List<String> getItemIssuanceQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, ItemIssuanceMetadata.aliasMap);
        }

        public static List<String> getItemIssuanceQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, ItemIssuanceMetadata.aliasMap);
        }

        public static String getItemIssuanceFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (ItemIssuanceMetadata.aliasMap.containsKey(fieldName)) {
                return ItemIssuanceMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getItemIssuanceFilterPropertyType(String propertyName) {
            if (ItemIssuanceMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = ItemIssuanceMetadata.propertyTypeMap.get(propertyName);
                if (!StringHelper.isNullOrEmpty(propertyType)) {
                    if (org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.containsKey(propertyType)) {
                        return org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.get(propertyType);
                    }
                }
            }
            return String.class;
        }

        public static Iterable<Map.Entry<String, Object>> getItemIssuanceQueryFilterMap(Map<String, String[]> queryNameValuePairs) {
            Map<String, Object> filter = new HashMap<>();
            queryNameValuePairs.forEach((key, values) -> {
                if (values.length > 0) {
                    String pName = getItemIssuanceFilterPropertyName(key);
                    if (!StringHelper.isNullOrEmpty(pName)) {
                        Class pClass = getItemIssuanceFilterPropertyType(pName);
                        filter.put(pName, ApplicationContext.current.getTypeConverter().convertFromString(pClass, values[0]));
                    }
                }
            });
            return filter.entrySet();
        }

        public static ShipmentStateDto[] toShipmentStateDtoArray(Iterable<String> ids) {
            List<ShipmentStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                ShipmentStateDto dto = new ShipmentStateDto();
                dto.setShipmentId(i);
                states.add(dto);
            });
            return states.toArray(new ShipmentStateDto[0]);
        }

    }

}

