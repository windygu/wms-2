package org.dddml.wms.domain.listener;

import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.inventoryitemrequirement.*;
import org.dddml.wms.domain.inventorypostingrule.InventoryPostingRuleApplicationService;
import org.dddml.wms.domain.inventorypostingrule.InventoryPostingRuleIds;
import org.dddml.wms.domain.inventorypostingrule.InventoryPostingRuleState;
import org.dddml.wms.domain.inventoryprtriggered.AbstractInventoryPRTriggeredCommand;
import org.dddml.wms.domain.inventoryprtriggered.InventoryPRTriggeredApplicationService;
import org.dddml.wms.domain.inventoryprtriggered.InventoryPRTriggeredCommand;
import org.dddml.wms.domain.inventoryprtriggered.InventoryPRTriggeredId;
import org.dddml.wms.domain.sellableinventoryitem.*;
import org.dddml.wms.specialization.AggregateEvent;
import org.dddml.wms.specialization.AggregateEventListener;
import org.dddml.wms.specialization.IdGenerator;
import org.dddml.wms.specialization.ReflectUtils;
import org.dddml.wms.specialization.hibernate.TableIdGenerator;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by yangjiefeng on 2018/1/12.
 */
public class InventoryItemEventListener implements AggregateEventListener<InventoryItemAggregate, InventoryItemState> {

    private IdGenerator<Long, Object, Object> seqIdGenerator = new TableIdGenerator();

    private InventoryPostingRuleApplicationService inventoryPostingRuleApplicationService;

    private InventoryPRTriggeredApplicationService inventoryPRTriggeredApplicationService;

    private SellableInventoryItemApplicationService sellableInventoryItemApplicationService;

    private InventoryItemRequirementApplicationService inventoryItemRequirementApplicationService;

    public IdGenerator<Long, Object, Object> getSeqIdGenerator() {
        return seqIdGenerator;
    }

    public void setSeqIdGenerator(IdGenerator<Long, Object, Object> seqIdGenerator) {
        this.seqIdGenerator = seqIdGenerator;
    }

    public InventoryPRTriggeredApplicationService getInventoryPRTriggeredApplicationService() {
        return inventoryPRTriggeredApplicationService;
    }

    public void setInventoryPRTriggeredApplicationService(InventoryPRTriggeredApplicationService inventoryPRTriggeredApplicationService) {
        this.inventoryPRTriggeredApplicationService = inventoryPRTriggeredApplicationService;
    }

    public InventoryPostingRuleApplicationService getInventoryPostingRuleApplicationService() {
        return inventoryPostingRuleApplicationService;
    }

    public void setInventoryPostingRuleApplicationService(InventoryPostingRuleApplicationService inventoryPostingRuleApplicationService) {
        this.inventoryPostingRuleApplicationService = inventoryPostingRuleApplicationService;
    }

    public SellableInventoryItemApplicationService getSellableInventoryItemApplicationService() {
        return sellableInventoryItemApplicationService;
    }

    public void setSellableInventoryItemApplicationService(SellableInventoryItemApplicationService sellableInventoryItemApplicationService) {
        this.sellableInventoryItemApplicationService = sellableInventoryItemApplicationService;
    }

    public InventoryItemRequirementApplicationService getInventoryItemRequirementApplicationService() {
        return inventoryItemRequirementApplicationService;
    }

    public void setInventoryItemRequirementApplicationService(InventoryItemRequirementApplicationService inventoryItemRequirementApplicationService) {
        this.inventoryItemRequirementApplicationService = inventoryItemRequirementApplicationService;
    }

    @Override
    public void eventAppended(AggregateEvent<InventoryItemAggregate, InventoryItemState> e) {
        if (!(e.getEvent() != null && e.getEvent() instanceof InventoryItemStateEvent)) {
            return;
        }
        InventoryItemStateEvent inventoryItemEvent = (InventoryItemStateEvent) e.getEvent();
        Iterable<InventoryItemEntryStateEvent.InventoryItemEntryStateCreated> itemEntriesCreated = null;
        if (inventoryItemEvent instanceof InventoryItemStateEvent.InventoryItemStateCreated) {
            itemEntriesCreated = ((InventoryItemStateEvent.InventoryItemStateCreated) inventoryItemEvent).getInventoryItemEntryEvents();
        } else if (inventoryItemEvent instanceof InventoryItemStateEvent.InventoryItemStateMergePatched) {
            itemEntriesCreated =
                    StreamSupport.stream(
                            ((InventoryItemStateEvent.InventoryItemStateMergePatched) inventoryItemEvent)
                                    .getInventoryItemEntryEvents().spliterator(), false
                    ).filter(ie -> ie instanceof InventoryItemEntryStateEvent.InventoryItemEntryStateCreated)
                            .map(ie -> (InventoryItemEntryStateEvent.InventoryItemEntryStateCreated) ie)
                            .collect(Collectors.toList());
        }
        if (itemEntriesCreated == null) {
            return;
        }
        for (InventoryItemEntryStateEvent.InventoryItemEntryStateCreated iie : itemEntriesCreated) {
            for (InventoryPostingRuleState pr : getPostingRules(iie.getInventoryItemEntryEventId().getInventoryItemId())) {
                BigDecimal outputQuantity = getOutputQuantity(pr, iie);
                if (outputQuantity == null || outputQuantity.equals(0)) {
                    continue;
                }
                InventoryPRTriggeredId tid = getOrCreateInventoryPRTriggered(pr, iie);

                InventoryItemId outputItemId = getOutputInventoryItemId(pr, iie.getInventoryItemEntryEventId().getInventoryItemId());
                //_log.Debug(outputItemId.ProductId + ", " + outputItemId.LocatorId + ", " + outputItemId.AttributeSetInstanceId);
                createOrUpdateOutputAccount(pr.getOutputAccountName(), outputQuantity, tid, outputItemId);
            }
        }
    }

    private void createOrUpdateOutputAccount(String outputAccountName, BigDecimal outputQuantity, InventoryPRTriggeredId tid, InventoryItemId outputItemId) {
        if (InventoryPostingRuleIds.OUTPUT_ACCOUNT_NAME_SELLABLE_QUANTITY.equals(outputAccountName)) {
            createOrUpdateSellableInventoryItem(outputQuantity, tid, outputItemId);
        } else if (InventoryPostingRuleIds.OUTPUT_ACCOUNT_NAME_REQUIRED_QUANTITY.equals(outputAccountName)) {
            createOrUpdateInventoryItemRequirement(outputQuantity, tid, outputItemId);
        } else {
            throw new UnsupportedOperationException(String.format("outputAccountName = %1$s", outputAccountName));
        }
    }

    // ///////////////////////////////////


    private void createOrUpdateSellableInventoryItem(BigDecimal outputQuantity, InventoryPRTriggeredId tid, InventoryItemId outputItemId) {
        SellableInventoryItemState itemState = getSellableInventoryItemApplicationService().get(outputItemId);
        if (itemState != null) {
            SellableInventoryItemCommand.MergePatchSellableInventoryItem updateItem = new AbstractSellableInventoryItemCommand.SimpleMergePatchSellableInventoryItem();
            updateItem.setSellableInventoryItemId(outputItemId);
            updateItem.setVersion(itemState.getVersion());
            updateItem.setCommandId(UUID.randomUUID().toString());

            SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry createEntry = updateItem.newCreateSellableInventoryItemEntry();
            setCreateSellableInventoryItemEntry(outputQuantity, tid, createEntry);
            updateItem.getSellableInventoryItemEntryCommands().add(createEntry);
            getSellableInventoryItemApplicationService().when(updateItem);
        } else // is null
        {
            SellableInventoryItemCommand.CreateSellableInventoryItem createItem = new AbstractSellableInventoryItemCommand.SimpleCreateSellableInventoryItem();
            createItem.setSellableInventoryItemId(outputItemId);
            createItem.setCommandId(UUID.randomUUID().toString());

            SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry createEntry = createItem.newCreateSellableInventoryItemEntry();
            setCreateSellableInventoryItemEntry(outputQuantity, tid, createEntry);
            createItem.getEntries().add(createEntry);
            getSellableInventoryItemApplicationService().when(createItem);
            //return SellableInventoryItemApplicationService.Get(outputItemId);
        }
    }

    private void setCreateSellableInventoryItemEntry(BigDecimal outputQuantity, InventoryPRTriggeredId tid, SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry createEntry) {
        createEntry.setEntrySeqId(getSeqIdGenerator().getNextId());// DateTime.Now.Ticks;
        createEntry.setSellableQuantity(outputQuantity);
        createEntry.setSourceEventId(tid);
    }

    // ///////////////////////////////////

    private void createOrUpdateInventoryItemRequirement(BigDecimal outputQuantity, InventoryPRTriggeredId tid, InventoryItemId outputItemId) {
        InventoryItemRequirementState itemState = getInventoryItemRequirementApplicationService().get(outputItemId);
        if (itemState != null)
        {
            InventoryItemRequirementCommand.MergePatchInventoryItemRequirement updateItem = new AbstractInventoryItemRequirementCommand.SimpleMergePatchInventoryItemRequirement();
            updateItem.setInventoryItemRequirementId(outputItemId);
            updateItem.setVersion(itemState.getVersion());
            updateItem.setCommandId(UUID.randomUUID().toString());

            InventoryItemRequirementEntryCommand.CreateInventoryItemRequirementEntry createEntry = updateItem.newCreateInventoryItemRequirementEntry();
            setCreateInventoryItemRequirementEntry(outputQuantity, tid, createEntry);
            updateItem.getInventoryItemRequirementEntryCommands().add(createEntry);
            getInventoryItemRequirementApplicationService().when(updateItem);
        }
        else // is null
        {
            InventoryItemRequirementCommand.CreateInventoryItemRequirement createItem = new AbstractInventoryItemRequirementCommand.SimpleCreateInventoryItemRequirement();
            createItem.setInventoryItemRequirementId(outputItemId);
            createItem.setCommandId(UUID.randomUUID().toString());

            InventoryItemRequirementEntryCommand.CreateInventoryItemRequirementEntry createEntry = createItem.newCreateInventoryItemRequirementEntry();
            setCreateInventoryItemRequirementEntry(outputQuantity, tid, createEntry);
            createItem.getEntries().add(createEntry);
            getInventoryItemRequirementApplicationService().when(createItem);
            //return InventoryItemRequirementApplicationService.Get(outputItemId);
        }
    }

    private void setCreateInventoryItemRequirementEntry(BigDecimal outputQuantity, InventoryPRTriggeredId tid, InventoryItemRequirementEntryCommand.CreateInventoryItemRequirementEntry createEntry) {
        createEntry.setEntrySeqId(getSeqIdGenerator().getNextId());//DateTime.Now.Ticks;
        createEntry.setQuantity(outputQuantity);
        createEntry.setSourceEventId(tid);
    }

    // ///////////////////////////////////

    private InventoryPRTriggeredId getOrCreateInventoryPRTriggered(InventoryPostingRuleState pr, InventoryItemEntryStateEvent.InventoryItemEntryStateCreated iie) {
        InventoryPRTriggeredCommand.CreateInventoryPRTriggered createTriggered = new AbstractInventoryPRTriggeredCommand.SimpleCreateInventoryPRTriggered();
        InventoryItemEntryId sourceEntryId = new InventoryItemEntryId(iie.getInventoryItemEntryEventId().getInventoryItemId(),
                iie.getInventoryItemEntryEventId().getEntrySeqId());
        String postingRuleId = pr.getInventoryPostingRuleId();
        InventoryPRTriggeredId tid = new InventoryPRTriggeredId(sourceEntryId, postingRuleId);
        createTriggered.setInventoryPRTriggeredId(tid);
        createTriggered.setCommandId(UUID.randomUUID().toString());
        createTriggered.setIsProcessed(true);// now we use database strong consistency!
        getInventoryPRTriggeredApplicationService().when(createTriggered);
        return tid;//todo If existed??
    }

    private BigDecimal getOutputQuantity(InventoryPostingRuleState pr, InventoryItemEntryStateEvent.InventoryItemEntryStateCreated sourceEntry) {
        String accountName = pr.getTriggerAccountName();
        BigDecimal srcAmount = (BigDecimal) (ReflectUtils.getPropertyValue(accountName, sourceEntry));
        return (pr.getIsOutputNegated() != null && pr.getIsOutputNegated())
                ? srcAmount == null ? BigDecimal.valueOf(0) : srcAmount.negate()
                : srcAmount == null ? BigDecimal.valueOf(0) : srcAmount;
    }

    private InventoryItemId getOutputInventoryItemId(InventoryPostingRuleState pr, InventoryItemId triggerItemId) {
        String productId = Objects.equals(pr.getOutputInventoryItemId().getProductId(), InventoryItemIds.SAME_AS_SOURCE) ?
                triggerItemId.getProductId() : pr.getOutputInventoryItemId().getProductId();
        String locatorId = Objects.equals(pr.getOutputInventoryItemId().getLocatorId(), InventoryItemIds.SAME_AS_SOURCE) ?
                triggerItemId.getLocatorId() : pr.getOutputInventoryItemId().getLocatorId();
        String attrInstSetId = Objects.equals(pr.getOutputInventoryItemId().getAttributeSetInstanceId(), InventoryItemIds.SAME_AS_SOURCE) ?
                triggerItemId.getAttributeSetInstanceId() : pr.getOutputInventoryItemId().getAttributeSetInstanceId();
        InventoryItemId outputItemId = new InventoryItemId(productId, locatorId, attrInstSetId);
        return outputItemId;
    }

    private Iterable<InventoryPostingRuleState> getPostingRules(InventoryItemId triggerItemId) {
        //todo 这两个 getByProperty 方法的效率太低，可以考虑使用缓存
        return
                Stream.concat(
                        StreamSupport.stream(
                                getInventoryPostingRuleApplicationService()
                                        .getByProperty("outputAccountName", InventoryPostingRuleIds.OUTPUT_ACCOUNT_NAME_SELLABLE_QUANTITY, null, 0, Integer.MAX_VALUE)
                                        .spliterator(), false),
                        StreamSupport.stream(
                                getInventoryPostingRuleApplicationService()
                                        .getByProperty("outputAccountName", InventoryPostingRuleIds.OUTPUT_ACCOUNT_NAME_REQUIRED_QUANTITY, null, 0, Integer.MAX_VALUE)
                                        .spliterator(), false)
                ).filter(pr -> (
                        Objects.equals(pr.getTriggerInventoryItemId().getProductId(), InventoryItemIds.WILDCARD)
                                || Objects.equals(pr.getTriggerInventoryItemId().getProductId(), triggerItemId.getProductId()))
                        &&
                        (Objects.equals(pr.getTriggerInventoryItemId().getLocatorId(), InventoryItemIds.WILDCARD)
                                || Objects.equals(pr.getTriggerInventoryItemId().getLocatorId(), triggerItemId.getLocatorId()))
                        &&
                        (Objects.equals(pr.getTriggerInventoryItemId().getAttributeSetInstanceId(), InventoryItemIds.WILDCARD)
                                || Objects.equals(pr.getTriggerInventoryItemId().getAttributeSetInstanceId(), triggerItemId.getAttributeSetInstanceId()))
                ).collect(Collectors.toList());
    }


}
