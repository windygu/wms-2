package org.dddml.wms.domain.physicalinventory;

import org.dddml.wms.domain.DocumentAction;
import org.dddml.wms.domain.DocumentStatusIds;
import org.dddml.wms.domain.EntityStateCollection;
import org.dddml.wms.domain.attributesetinstance.AttributeSetInstanceApplicationService;
import org.dddml.wms.domain.attributesetinstance.AttributeSetInstanceState;
import org.dddml.wms.domain.attributesetinstance.AttributeSetInstanceUtils;
import org.dddml.wms.domain.documenttype.DocumentTypeIds;
import org.dddml.wms.domain.inout.*;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.product.ProductApplicationService;
import org.dddml.wms.domain.product.ProductState;
import org.dddml.wms.domain.service.AttributeSetService;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.EventStore;
import org.dddml.wms.specialization.IdGenerator;
import org.dddml.wms.specialization.hibernate.TableIdGenerator;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by yangjiefeng on 2018/9/3.
 */
public class PhysicalInventoryApplicationServiceImpl extends AbstractPhysicalInventoryApplicationService.SimplePhysicalInventoryApplicationService {

    static final String ATTRIBUTE_SET_INSTANCE_ID_KEY = "attributeSetInstanceId";

    InventoryItemQueryService getInventoryItemQueryService() {
        return (InventoryItemQueryService) ApplicationContext.current.get("inventoryItemQueryService");
    }

    ProductApplicationService getProductApplicationService() {
        return (ProductApplicationService) ApplicationContext.current.get("productApplicationService");
    }

    AttributeSetInstanceApplicationService getAttributeSetInstanceApplicationService() {
        return (AttributeSetInstanceApplicationService) ApplicationContext.current.get("attributeSetInstanceApplicationService");
    }

    AttributeSetService getAttributeSetService() {
        return (AttributeSetService) ApplicationContext.current.get("attributeSetService");
    }

    InventoryItemApplicationService getInventoryItemApplicationService() {
        return (InventoryItemApplicationService) ApplicationContext.current.get("inventoryItemApplicationService");
    }

    private IdGenerator<Long, Object, Object> seqIdGenerator = new TableIdGenerator();

    public IdGenerator<Long, Object, Object> getSeqIdGenerator() {
        return seqIdGenerator;
    }

    public void setSeqIdGenerator(IdGenerator<Long, Object, Object> seqIdGenerator) {
        this.seqIdGenerator = seqIdGenerator;
    }

    public PhysicalInventoryApplicationServiceImpl(EventStore eventStore, PhysicalInventoryStateRepository stateRepository, PhysicalInventoryStateQueryRepository stateQueryRepository) {
        super(eventStore, stateRepository, stateQueryRepository);
    }

    @Override
    public void when(PhysicalInventoryCommand.CreatePhysicalInventory c) {
        if (c.getWarehouseId() == null || c.getWarehouseId().isEmpty()) {
            throw new IllegalArgumentException("warehosueId is null");
        }
        //todo 如果不是反转的盘点单，且设置了 Pattern，那么生成默认的盘点行项？
        if (c.getReversalDocumentNumber() == null
                && (c.getLocatorIdPattern() != null || c.getProductIdPattern() != null)) {
            List<InventoryItemState> inventoryItems = getInventoryItemQueryService()
                    .getInventoryItems(c.getWarehouseId(), c.getLocatorIdPattern(), c.getProductIdPattern());
            for (InventoryItemState ii : inventoryItems) {
                PhysicalInventoryLineCommand.CreatePhysicalInventoryLine createPhysicalInventoryLine = new AbstractPhysicalInventoryLineCommand.SimpleCreatePhysicalInventoryLine();
                InventoryItemId inventoryItemId = ii.getInventoryItemId();
                createPhysicalInventoryLine.setInventoryItemId(inventoryItemId);
                createPhysicalInventoryLine.setBookQuantity(ii.getOnHandQuantity());//todo ???
                createPhysicalInventoryLine.setLineNumber(getSeqIdGenerator().getNextId().toString());
                createPhysicalInventoryLine.setActive(true);
                c.getCreatePhysicalInventoryLineCommands().add(createPhysicalInventoryLine);
            }
        }
        super.when(c);
    }

    @Transactional
    @Override
    public void when(PhysicalInventoryCommands.CountItem c) {
        Map<String, Object> attributeSetInstance = new HashMap<>(c.getAttributeSetInstance());
        String attributeSetInstanceId = (String) attributeSetInstance.get(ATTRIBUTE_SET_INSTANCE_ID_KEY);
        ProductState productState = getProductState(c.getProductId());
        if (attributeSetInstanceId == null || attributeSetInstanceId.trim().isEmpty()) {
            attributeSetInstance.remove(ATTRIBUTE_SET_INSTANCE_ID_KEY);
            if (attributeSetInstance.size() > 0) {
                attributeSetInstanceId = AttributeSetInstanceUtils.createAttributeSetInstance(
                        getAttributeSetService(), getAttributeSetInstanceApplicationService(),
                        productState.getAttributeSetId(), attributeSetInstance);
            }
        } else {
            AttributeSetInstanceState attrSetInstState = getAttributeSetInstanceApplicationService().get(attributeSetInstanceId);
            if (attrSetInstState == null) {
                throw new NullPointerException(
                        String.format("AttributeSetInstanceState NOT found. AttributeSetInstanceState Id.: %1$s",
                                attributeSetInstanceId));
            }
        }
        String notNullAttrSetInstId = (attributeSetInstanceId == null || attributeSetInstanceId.isEmpty())
                ? InventoryItemIds.EMPTY_ATTRIBUTE_SET_INSTANCE_ID : attributeSetInstanceId;
        attributeSetInstance.put(ATTRIBUTE_SET_INSTANCE_ID_KEY, notNullAttrSetInstId);
        c.setAttributeSetInstance(attributeSetInstance);
        super.when(c);
    }

    @Override
    @Transactional
    public void when(PhysicalInventoryCommands.DocumentAction c) {
        //
        // 注意：这里通过覆写父类方法，加上事务注解，其实没有遵循“聚合外最终一致”的处理原则。
        //
        if (Objects.equals(c.getValue(), DocumentAction.COMPLETE)) {
            PhysicalInventoryState physicalInventoryState = assertDocumentStatus(c.getDocumentNumber(), DocumentStatusIds.DRAFTED);
            // 操作库存（InventoryItem）
            List<InventoryItemEntryCommand.CreateInventoryItemEntry> inventoryItemEntries = completePhysicalInventoryCreateInventoryItemEntries(physicalInventoryState);
            InventoryItemUtils.createOrUpdateInventoryItems(getInventoryItemApplicationService(), inventoryItemEntries);
            super.when(c);
        } else if (Objects.equals(c.getValue(), DocumentAction.REVERSE)) {
            PhysicalInventoryState srcPhysicalInventory = assertDocumentStatus(c.getDocumentNumber(), DocumentStatusIds.COMPLETED);
            PhysicalInventoryCommand.CreatePhysicalInventory reversalPhysicalInventoryInfo = createReversalPhysicalInventoryAndCompleteAndClose(c, srcPhysicalInventory);
            reverseUpdateSourcePhysicalInventory(c, reversalPhysicalInventoryInfo);
        } else {
            super.when(c);
        }
    }

    private void reverseUpdateSourcePhysicalInventory(PhysicalInventoryCommands.DocumentAction c, PhysicalInventoryCommand.CreatePhysicalInventory reversalPhysicalInventoryInfo) {
        //源单据前向关联到反转单据：
        String reversalDocumentNumber = reversalPhysicalInventoryInfo.getDocumentNumber();
        String description = "(" + reversalPhysicalInventoryInfo.getDocumentNumber() + "<-)";//(1000016<-)
        update(c, ar -> ((PhysicalInventoryApplicationServiceImpl.PhysicalInventoryAggregateImpl) ar)
                .reverse(reversalDocumentNumber, description, c.getVersion(), c.getCommandId(), c.getRequesterId()));
    }

    private PhysicalInventoryCommand.CreatePhysicalInventory createReversalPhysicalInventoryAndCompleteAndClose(PhysicalInventoryCommands.DocumentAction c, PhysicalInventoryState physicalInventory) {
        PhysicalInventoryCommand.CreatePhysicalInventory createReversalPhysicalInventory = createReversalPhysicalInventory(physicalInventory);

        when(createReversalPhysicalInventory);
        //if (true) return createReversalPhysicalInventory;
        long firstVersion = 0;//!!!

        PhysicalInventoryCommands.DocumentAction completeCmd = new PhysicalInventoryCommands.DocumentAction();
        completeCmd.setDocumentNumber(createReversalPhysicalInventory.getDocumentNumber());
        completeCmd.setVersion(firstVersion);
        completeCmd.setValue(DocumentAction.COMPLETE);
        completeCmd.setCommandId(c.getCommandId());
        completeCmd.setRequesterId(c.getRequesterId());
        when(completeCmd);

        PhysicalInventoryCommands.DocumentAction closeCmd = new PhysicalInventoryCommands.DocumentAction();
        closeCmd.setDocumentNumber(createReversalPhysicalInventory.getDocumentNumber());
        closeCmd.setVersion(firstVersion + 1);
        closeCmd.setValue(DocumentAction.CLOSE);
        closeCmd.setCommandId(c.getCommandId());
        closeCmd.setRequesterId(c.getRequesterId());
        when(closeCmd);

        return createReversalPhysicalInventory;
    }

    protected PhysicalInventoryCommand.CreatePhysicalInventory createReversalPhysicalInventory(PhysicalInventoryState physicalInventory) {
        PhysicalInventoryCommand.CreatePhysicalInventory reversalPhysicalInventory = doCreateReversalPhysicalInventory(physicalInventory);

        for (PhysicalInventoryLineState d : physicalInventory.getPhysicalInventoryLines()) {
            PhysicalInventoryLineCommand.CreatePhysicalInventoryLine reversalLine = doCreateReversalPhysicalInventoryLine(d);
            reversalPhysicalInventory.getCreatePhysicalInventoryLineCommands().add(reversalLine);
        }

        return reversalPhysicalInventory;
    }
    
    /**
     * 生成反转的单据（但不包括行）。
     */
    protected PhysicalInventoryCommand.CreatePhysicalInventory doCreateReversalPhysicalInventory(PhysicalInventoryState physicalInventory) {
        PhysicalInventoryCommand.CreatePhysicalInventory reversalPhysicalInventory = new AbstractPhysicalInventoryCommand.SimpleCreatePhysicalInventory();

        //生成新的单号:
        reversalPhysicalInventory.setDocumentNumber("RPI" + getSeqIdGenerator().getNextId()); //DocumentNumberGenerator.GetNewDocumentNumber();
        //设置反转关系:
        reversalPhysicalInventory.setReversalDocumentNumber(physicalInventory.getDocumentNumber());
        ////源单据前向关联到反转单据:
        //physicalInventory.Description = "(" + reversalPhysicalInventory.DocumentNumber + "<-)";//(1000016<-)
        //反转单据后向关联到源单据:
        reversalPhysicalInventory.setDescription("{->" + physicalInventory.getDocumentNumber() + ")"); //{->1000015)

        reversalPhysicalInventory.setDocumentTypeId(physicalInventory.getDocumentTypeId());
        reversalPhysicalInventory.setMovementDate(physicalInventory.getMovementDate());
        reversalPhysicalInventory.setWarehouseId(physicalInventory.getWarehouseId());
        reversalPhysicalInventory.setLocatorIdPattern(physicalInventory.getLocatorIdPattern());
        reversalPhysicalInventory.setProductIdPattern(physicalInventory.getProductIdPattern());

        return reversalPhysicalInventory;
    }


    /**
     * 生成反转的行。
     */
    protected PhysicalInventoryLineCommand.CreatePhysicalInventoryLine doCreateReversalPhysicalInventoryLine(PhysicalInventoryLineState physicalInventoryLine) {
        PhysicalInventoryLineCommand.CreatePhysicalInventoryLine reversalLine = new AbstractPhysicalInventoryLineCommand.SimpleCreatePhysicalInventoryLine();

        reversalLine.setLineNumber(getSeqIdGenerator().getNextId().toString());//physicalInventoryLine.getLineNumber()
        reversalLine.setReversalLineNumber(physicalInventoryLine.getLineNumber()); //设置反转行的行号
        reversalLine.setInventoryItemId(physicalInventoryLine.getInventoryItemId());
        //        reversalLine.setProductId(physicalInventoryLine.getProductId());
        //        reversalLine.setLocatorId(physicalInventoryLine.getLocatorId());
        //        reversalLine.setAttributeSetInstanceId(physicalInventoryLine.getAttributeSetInstanceId());
        reversalLine.setProcessed(physicalInventoryLine.getProcessed()); // ???
        // //////////////////////////// 数量反转 //////////////////////////////////
        reversalLine.setBookQuantity(physicalInventoryLine.getCountedQuantity());
        reversalLine.setCountedQuantity(physicalInventoryLine.getBookQuantity());

        if (reversalLine.getBookQuantity() == null) {
            throw new NullPointerException("reversalLine.getBookQuantity() == null");
        }
        if (reversalLine.getCountedQuantity() == null) {
            throw new NullPointerException("reversalLine.getCountedQuantity() == null");
        }
        return reversalLine;
    }


    protected List<InventoryItemEntryCommand.CreateInventoryItemEntry> completePhysicalInventoryCreateInventoryItemEntries(PhysicalInventoryState physicalInventoryState) {
        EntityStateCollection<InventoryItemId, PhysicalInventoryLineState> physicalInventoryLines = physicalInventoryState.getPhysicalInventoryLines();
        List<InventoryItemEntryCommand.CreateInventoryItemEntry> entries = new ArrayList<>();
        for (PhysicalInventoryLineState d : physicalInventoryLines) {
            InventoryItemEntryCommand.CreateInventoryItemEntry e = createInventoryItemEntry(physicalInventoryState, d);// signum);
            entries.add(e);
        }
        return entries;
    }

    protected InventoryItemEntryCommand.CreateInventoryItemEntry createInventoryItemEntry(PhysicalInventoryState physicalInventory, PhysicalInventoryLineState line) {
        InventoryItemEntryCommand.CreateInventoryItemEntry entry = new AbstractInventoryItemEntryCommand.SimpleCreateInventoryItemEntry();
        //        String attrSetInstId = physicalInventoryLineState.getInventoryItemId().getAttributeSetInstanceId();
        //        if (attrSetInstId == null || attrSetInstId.isEmpty()) {
        //            attrSetInstId = InventoryItemIds.EMPTY_ATTRIBUTE_SET_INSTANCE_ID;
        //        }
        entry.setInventoryItemId(line.getInventoryItemId());//new InventoryItemId(physicalInventoryLineState.getProductId(), physicalInventoryLineState.getLocatorId(), attrSetInstId));
        entry.setEntrySeqId(getSeqIdGenerator().getNextId());//DateTime.Now.Ticks;
        // ///////////////////// 调整数量 = 盘点数量 - 账上数量
        entry.setOnHandQuantity(line.getCountedQuantity().subtract(line.getBookQuantity()));
        entry.setSource(new InventoryItemSourceInfo(DocumentTypeIds.PHYSICAL_INVENTORY, physicalInventory.getDocumentNumber(), line.getLineNumber(), 0));
        if (physicalInventory.getMovementDate() != null) {
            entry.setOccurredAt(new Timestamp(physicalInventory.getMovementDate().getTime()));
        } else {
            entry.setOccurredAt((Timestamp) ApplicationContext.current.getTimestampService().now(Timestamp.class));
        }
        return entry;
    }

    private PhysicalInventoryState assertDocumentStatus(String docNumber, String docStatus) {
        PhysicalInventoryState physicalInventoryState = getStateRepository().get(docNumber, true);
        if (physicalInventoryState == null) {
            throw new IllegalArgumentException(String.format("Error document number: %1$s", docNumber));
        } else {
            if (!Objects.equals(docStatus.toLowerCase(), physicalInventoryState.getDocumentStatusId().toLowerCase())) {
                throw new IllegalArgumentException(String.format("Error document status: %1$s", physicalInventoryState.getDocumentStatusId()));
            }
        }
        return physicalInventoryState;
    }

    private ProductState getProductState(String productId) {
        ProductState prdState = getProductApplicationService().get(productId);
        if (prdState == null) {
            throw new IllegalArgumentException(String.format("Product NOT found. Product Id.: %1$s", productId));
        }
        return prdState;
    }

    public PhysicalInventoryAggregate getPhysicalInventoryAggregate(PhysicalInventoryState state)
    {
        return new PhysicalInventoryAggregateImpl(state);
    }

    public class PhysicalInventoryAggregateImpl extends AbstractPhysicalInventoryAggregate.SimplePhysicalInventoryAggregate {

        public PhysicalInventoryAggregateImpl(PhysicalInventoryState state) {
            super(state);
        }

        @Override
        public void countItem(String locatorId, String productId, java.util.Map<String, Object> attributeSetInstance, BigDecimal countedQuantity, Long version, String commandId, String requesterId) {
            String attributeSetInstanceId = (String) attributeSetInstance.get(ATTRIBUTE_SET_INSTANCE_ID_KEY);
            if (attributeSetInstanceId == null || attributeSetInstanceId.trim().isEmpty()) {
                throw new NullPointerException("The value of 'attributeSetInstanceId' is null.");
            }
            String notNullAttrSetInstId = attributeSetInstanceId;
            InventoryItemId inventoryItemId = new InventoryItemId(productId, locatorId, notNullAttrSetInstId);
            PhysicalInventoryLineState lineState = getState().getPhysicalInventoryLines().get(inventoryItemId, true);

            PhysicalInventoryEvent.PhysicalInventoryStateMergePatched e = newPhysicalInventoryStateMergePatched(version, commandId, requesterId);
            if (lineState != null) {
                PhysicalInventoryLineEvent.PhysicalInventoryLineStateMergePatched lineE = e.newPhysicalInventoryLineStateMergePatched(inventoryItemId);
                lineE.setCountedQuantity(countedQuantity);
                e.addPhysicalInventoryLineEvent(lineE);
                apply(e);
            } else {
                PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated lineE = e.newPhysicalInventoryLineStateCreated(inventoryItemId);
                lineE.setLineNumber(getSeqIdGenerator().getNextId().toString());
                lineE.setCountedQuantity(countedQuantity);
                lineE.setBookQuantity(BigDecimal.valueOf(0));
                e.addPhysicalInventoryLineEvent(lineE);
                apply(e);
            }
        }

        public void reverse(String reversalDocumentNumber, String desc, long version, String commandId, String requesterId) {
            PhysicalInventoryEvent.PhysicalInventoryStateMergePatched e = newPhysicalInventoryStateMergePatched(version, commandId, requesterId);
            e.setReversalDocumentNumber(reversalDocumentNumber);
            e.setDescription(desc);
            doDocumentAction(DocumentAction.REVERSE, ts -> e.setDocumentStatusId(ts));
            apply(e);
        }

    }

}
