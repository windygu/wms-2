package org.dddml.wms.domain.listener;

import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.inventoryitemrequirement.InventoryItemRequirementApplicationService;
import org.dddml.wms.domain.inventorypostingrule.InventoryPostingRuleApplicationService;
import org.dddml.wms.domain.inventoryprtriggered.InventoryPRTriggeredApplicationService;
import org.dddml.wms.domain.sellableinventoryitem.SellableInventoryItemApplicationService;
import org.dddml.wms.specialization.AggregateEvent;
import org.dddml.wms.specialization.AggregateEventListener;
import org.dddml.wms.specialization.IdGenerator;
import org.dddml.wms.specialization.hibernate.TableIdGenerator;

/**
 * Created by yangjiefeng on 2018/1/12.
 */
public class InventoryItemEventListener implements AggregateEventListener<InventoryItemAggregate, InventoryItemState> {

    private IdGenerator<Long, Object, Object> seqIdGenerator = new TableIdGenerator();

    private InventoryPostingRuleApplicationService inventoryPostingRuleApplicationService;

    private InventoryPRTriggeredApplicationService invntoryPRTriggeredApplicationService;

    private SellableInventoryItemApplicationService sellableInventoryItemApplicationService;

    private InventoryItemRequirementApplicationService inventoryItemRequirementApplicationService;

    public IdGenerator<Long, Object, Object> getSeqIdGenerator() {
        return seqIdGenerator;
    }

    public void setSeqIdGenerator(IdGenerator<Long, Object, Object> seqIdGenerator) {
        this.seqIdGenerator = seqIdGenerator;
    }

    public InventoryPRTriggeredApplicationService getInvntoryPRTriggeredApplicationService() {
        return invntoryPRTriggeredApplicationService;
    }

    public void setInvntoryPRTriggeredApplicationService(InventoryPRTriggeredApplicationService invntoryPRTriggeredApplicationService) {
        this.invntoryPRTriggeredApplicationService = invntoryPRTriggeredApplicationService;
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
        //todo
    }
}
