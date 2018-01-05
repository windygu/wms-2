package org.dddml.wms.domain.physicalinventorylinemvo;

import java.util.*;
import org.dddml.wms.domain.physicalinventory.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractPhysicalInventoryLineMvoAggregate extends AbstractAggregate implements PhysicalInventoryLineMvoAggregate
{
    private PhysicalInventoryLineMvoState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractPhysicalInventoryLineMvoAggregate(PhysicalInventoryLineMvoState state)
    {
        this.state = state;
    }

    public PhysicalInventoryLineMvoState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(PhysicalInventoryLineMvoCommand.CreatePhysicalInventoryLineMvo c)
    {
        if (c.getPhysicalInventoryVersion() == null) { c.setPhysicalInventoryVersion(PhysicalInventoryLineMvoState.VERSION_NULL); }
        PhysicalInventoryLineMvoStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(PhysicalInventoryLineMvoCommand.MergePatchPhysicalInventoryLineMvo c)
    {
        PhysicalInventoryLineMvoStateEvent e = map(c);
        apply(e);
    }

    public void delete(PhysicalInventoryLineMvoCommand.DeletePhysicalInventoryLineMvo c)
    {
        PhysicalInventoryLineMvoStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        PhysicalInventoryLineMvoCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected PhysicalInventoryLineMvoStateEvent map(PhysicalInventoryLineMvoCommand.CreatePhysicalInventoryLineMvo c) {
        PhysicalInventoryLineMvoStateEventId stateEventId = new PhysicalInventoryLineMvoStateEventId(c.getPhysicalInventoryLineId(), c.getPhysicalInventoryVersion());
        PhysicalInventoryLineMvoStateEvent.PhysicalInventoryLineMvoStateCreated e = newPhysicalInventoryLineMvoStateCreated(stateEventId);
        e.setLocatorId(c.getLocatorId());
        e.setProductId(c.getProductId());
        e.setAttributeSetInstanceId(c.getAttributeSetInstanceId());
        e.setBookQuantity(c.getBookQuantity());
        e.setCountedQuantity(c.getCountedQuantity());
        e.setProcessed(c.getProcessed());
        e.setReversalLineNumber(c.getReversalLineNumber());
        e.setDescription(c.getDescription());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setPhysicalInventoryDocumentStatusId(c.getPhysicalInventoryDocumentStatusId());
        e.setPhysicalInventoryWarehouseId(c.getPhysicalInventoryWarehouseId());
        e.setPhysicalInventoryPosted(c.getPhysicalInventoryPosted());
        e.setPhysicalInventoryProcessed(c.getPhysicalInventoryProcessed());
        e.setPhysicalInventoryProcessing(c.getPhysicalInventoryProcessing());
        e.setPhysicalInventoryDocumentTypeId(c.getPhysicalInventoryDocumentTypeId());
        e.setPhysicalInventoryMovementDate(c.getPhysicalInventoryMovementDate());
        e.setPhysicalInventoryDescription(c.getPhysicalInventoryDescription());
        e.setPhysicalInventoryIsApproved(c.getPhysicalInventoryIsApproved());
        e.setPhysicalInventoryApprovalAmount(c.getPhysicalInventoryApprovalAmount());
        e.setPhysicalInventoryIsQuantityUpdated(c.getPhysicalInventoryIsQuantityUpdated());
        e.setPhysicalInventoryReversalDocumentNumber(c.getPhysicalInventoryReversalDocumentNumber());
        e.setPhysicalInventoryCreatedBy(c.getPhysicalInventoryCreatedBy());
        e.setPhysicalInventoryCreatedAt(c.getPhysicalInventoryCreatedAt());
        e.setPhysicalInventoryUpdatedBy(c.getPhysicalInventoryUpdatedBy());
        e.setPhysicalInventoryUpdatedAt(c.getPhysicalInventoryUpdatedAt());
        e.setPhysicalInventoryActive(c.getPhysicalInventoryActive());
        e.setPhysicalInventoryDeleted(c.getPhysicalInventoryDeleted());
        ((AbstractPhysicalInventoryLineMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PhysicalInventoryLineMvoStateEvent map(PhysicalInventoryLineMvoCommand.MergePatchPhysicalInventoryLineMvo c) {
        PhysicalInventoryLineMvoStateEventId stateEventId = new PhysicalInventoryLineMvoStateEventId(c.getPhysicalInventoryLineId(), c.getPhysicalInventoryVersion());
        PhysicalInventoryLineMvoStateEvent.PhysicalInventoryLineMvoStateMergePatched e = newPhysicalInventoryLineMvoStateMergePatched(stateEventId);
        e.setLocatorId(c.getLocatorId());
        e.setProductId(c.getProductId());
        e.setAttributeSetInstanceId(c.getAttributeSetInstanceId());
        e.setBookQuantity(c.getBookQuantity());
        e.setCountedQuantity(c.getCountedQuantity());
        e.setProcessed(c.getProcessed());
        e.setReversalLineNumber(c.getReversalLineNumber());
        e.setDescription(c.getDescription());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setPhysicalInventoryDocumentStatusId(c.getPhysicalInventoryDocumentStatusId());
        e.setPhysicalInventoryWarehouseId(c.getPhysicalInventoryWarehouseId());
        e.setPhysicalInventoryPosted(c.getPhysicalInventoryPosted());
        e.setPhysicalInventoryProcessed(c.getPhysicalInventoryProcessed());
        e.setPhysicalInventoryProcessing(c.getPhysicalInventoryProcessing());
        e.setPhysicalInventoryDocumentTypeId(c.getPhysicalInventoryDocumentTypeId());
        e.setPhysicalInventoryMovementDate(c.getPhysicalInventoryMovementDate());
        e.setPhysicalInventoryDescription(c.getPhysicalInventoryDescription());
        e.setPhysicalInventoryIsApproved(c.getPhysicalInventoryIsApproved());
        e.setPhysicalInventoryApprovalAmount(c.getPhysicalInventoryApprovalAmount());
        e.setPhysicalInventoryIsQuantityUpdated(c.getPhysicalInventoryIsQuantityUpdated());
        e.setPhysicalInventoryReversalDocumentNumber(c.getPhysicalInventoryReversalDocumentNumber());
        e.setPhysicalInventoryCreatedBy(c.getPhysicalInventoryCreatedBy());
        e.setPhysicalInventoryCreatedAt(c.getPhysicalInventoryCreatedAt());
        e.setPhysicalInventoryUpdatedBy(c.getPhysicalInventoryUpdatedBy());
        e.setPhysicalInventoryUpdatedAt(c.getPhysicalInventoryUpdatedAt());
        e.setPhysicalInventoryActive(c.getPhysicalInventoryActive());
        e.setPhysicalInventoryDeleted(c.getPhysicalInventoryDeleted());
        e.setIsPropertyLocatorIdRemoved(c.getIsPropertyLocatorIdRemoved());
        e.setIsPropertyProductIdRemoved(c.getIsPropertyProductIdRemoved());
        e.setIsPropertyAttributeSetInstanceIdRemoved(c.getIsPropertyAttributeSetInstanceIdRemoved());
        e.setIsPropertyBookQuantityRemoved(c.getIsPropertyBookQuantityRemoved());
        e.setIsPropertyCountedQuantityRemoved(c.getIsPropertyCountedQuantityRemoved());
        e.setIsPropertyProcessedRemoved(c.getIsPropertyProcessedRemoved());
        e.setIsPropertyReversalLineNumberRemoved(c.getIsPropertyReversalLineNumberRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyVersionRemoved(c.getIsPropertyVersionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setIsPropertyPhysicalInventoryDocumentStatusIdRemoved(c.getIsPropertyPhysicalInventoryDocumentStatusIdRemoved());
        e.setIsPropertyPhysicalInventoryWarehouseIdRemoved(c.getIsPropertyPhysicalInventoryWarehouseIdRemoved());
        e.setIsPropertyPhysicalInventoryPostedRemoved(c.getIsPropertyPhysicalInventoryPostedRemoved());
        e.setIsPropertyPhysicalInventoryProcessedRemoved(c.getIsPropertyPhysicalInventoryProcessedRemoved());
        e.setIsPropertyPhysicalInventoryProcessingRemoved(c.getIsPropertyPhysicalInventoryProcessingRemoved());
        e.setIsPropertyPhysicalInventoryDocumentTypeIdRemoved(c.getIsPropertyPhysicalInventoryDocumentTypeIdRemoved());
        e.setIsPropertyPhysicalInventoryMovementDateRemoved(c.getIsPropertyPhysicalInventoryMovementDateRemoved());
        e.setIsPropertyPhysicalInventoryDescriptionRemoved(c.getIsPropertyPhysicalInventoryDescriptionRemoved());
        e.setIsPropertyPhysicalInventoryIsApprovedRemoved(c.getIsPropertyPhysicalInventoryIsApprovedRemoved());
        e.setIsPropertyPhysicalInventoryApprovalAmountRemoved(c.getIsPropertyPhysicalInventoryApprovalAmountRemoved());
        e.setIsPropertyPhysicalInventoryIsQuantityUpdatedRemoved(c.getIsPropertyPhysicalInventoryIsQuantityUpdatedRemoved());
        e.setIsPropertyPhysicalInventoryReversalDocumentNumberRemoved(c.getIsPropertyPhysicalInventoryReversalDocumentNumberRemoved());
        e.setIsPropertyPhysicalInventoryCreatedByRemoved(c.getIsPropertyPhysicalInventoryCreatedByRemoved());
        e.setIsPropertyPhysicalInventoryCreatedAtRemoved(c.getIsPropertyPhysicalInventoryCreatedAtRemoved());
        e.setIsPropertyPhysicalInventoryUpdatedByRemoved(c.getIsPropertyPhysicalInventoryUpdatedByRemoved());
        e.setIsPropertyPhysicalInventoryUpdatedAtRemoved(c.getIsPropertyPhysicalInventoryUpdatedAtRemoved());
        e.setIsPropertyPhysicalInventoryActiveRemoved(c.getIsPropertyPhysicalInventoryActiveRemoved());
        e.setIsPropertyPhysicalInventoryDeletedRemoved(c.getIsPropertyPhysicalInventoryDeletedRemoved());
        ((AbstractPhysicalInventoryLineMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PhysicalInventoryLineMvoStateEvent map(PhysicalInventoryLineMvoCommand.DeletePhysicalInventoryLineMvo c) {
        PhysicalInventoryLineMvoStateEventId stateEventId = new PhysicalInventoryLineMvoStateEventId(c.getPhysicalInventoryLineId(), c.getPhysicalInventoryVersion());
        PhysicalInventoryLineMvoStateEvent.PhysicalInventoryLineMvoStateDeleted e = newPhysicalInventoryLineMvoStateDeleted(stateEventId);
        ((AbstractPhysicalInventoryLineMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected PhysicalInventoryLineMvoStateEvent.PhysicalInventoryLineMvoStateCreated newPhysicalInventoryLineMvoStateCreated(String commandId, String requesterId) {
        PhysicalInventoryLineMvoStateEventId stateEventId = new PhysicalInventoryLineMvoStateEventId(this.state.getPhysicalInventoryLineId(), this.state.getPhysicalInventoryVersion());
        PhysicalInventoryLineMvoStateEvent.PhysicalInventoryLineMvoStateCreated e = newPhysicalInventoryLineMvoStateCreated(stateEventId);
        ((AbstractPhysicalInventoryLineMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PhysicalInventoryLineMvoStateEvent.PhysicalInventoryLineMvoStateMergePatched newPhysicalInventoryLineMvoStateMergePatched(String commandId, String requesterId) {
        PhysicalInventoryLineMvoStateEventId stateEventId = new PhysicalInventoryLineMvoStateEventId(this.state.getPhysicalInventoryLineId(), this.state.getPhysicalInventoryVersion());
        PhysicalInventoryLineMvoStateEvent.PhysicalInventoryLineMvoStateMergePatched e = newPhysicalInventoryLineMvoStateMergePatched(stateEventId);
        ((AbstractPhysicalInventoryLineMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PhysicalInventoryLineMvoStateEvent.PhysicalInventoryLineMvoStateDeleted newPhysicalInventoryLineMvoStateDeleted(String commandId, String requesterId) {
        PhysicalInventoryLineMvoStateEventId stateEventId = new PhysicalInventoryLineMvoStateEventId(this.state.getPhysicalInventoryLineId(), this.state.getPhysicalInventoryVersion());
        PhysicalInventoryLineMvoStateEvent.PhysicalInventoryLineMvoStateDeleted e = newPhysicalInventoryLineMvoStateDeleted(stateEventId);
        ((AbstractPhysicalInventoryLineMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PhysicalInventoryLineMvoStateEvent.PhysicalInventoryLineMvoStateCreated newPhysicalInventoryLineMvoStateCreated(PhysicalInventoryLineMvoStateEventId stateEventId) {
        return new AbstractPhysicalInventoryLineMvoStateEvent.SimplePhysicalInventoryLineMvoStateCreated(stateEventId);
    }

    protected PhysicalInventoryLineMvoStateEvent.PhysicalInventoryLineMvoStateMergePatched newPhysicalInventoryLineMvoStateMergePatched(PhysicalInventoryLineMvoStateEventId stateEventId) {
        return new AbstractPhysicalInventoryLineMvoStateEvent.SimplePhysicalInventoryLineMvoStateMergePatched(stateEventId);
    }

    protected PhysicalInventoryLineMvoStateEvent.PhysicalInventoryLineMvoStateDeleted newPhysicalInventoryLineMvoStateDeleted(PhysicalInventoryLineMvoStateEventId stateEventId)
    {
        return new AbstractPhysicalInventoryLineMvoStateEvent.SimplePhysicalInventoryLineMvoStateDeleted(stateEventId);
    }


    public static class SimplePhysicalInventoryLineMvoAggregate extends AbstractPhysicalInventoryLineMvoAggregate
    {
        public SimplePhysicalInventoryLineMvoAggregate(PhysicalInventoryLineMvoState state) {
            super(state);
        }

    }

}

