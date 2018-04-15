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
        PhysicalInventoryLineMvoEvent e = map(c);
        apply(e);
    }

    public void mergePatch(PhysicalInventoryLineMvoCommand.MergePatchPhysicalInventoryLineMvo c)
    {
        PhysicalInventoryLineMvoEvent e = map(c);
        apply(e);
    }

    public void delete(PhysicalInventoryLineMvoCommand.DeletePhysicalInventoryLineMvo c)
    {
        PhysicalInventoryLineMvoEvent e = map(c);
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

    protected PhysicalInventoryLineMvoEvent map(PhysicalInventoryLineMvoCommand.CreatePhysicalInventoryLineMvo c) {
        PhysicalInventoryLineMvoEventId stateEventId = new PhysicalInventoryLineMvoEventId(c.getPhysicalInventoryLineId(), c.getPhysicalInventoryVersion());
        PhysicalInventoryLineMvoEvent.PhysicalInventoryLineMvoStateCreated e = newPhysicalInventoryLineMvoStateCreated(stateEventId);
        e.setBookQuantity(c.getBookQuantity());
        e.setCountedQuantity(c.getCountedQuantity());
        e.setProcessed(c.getProcessed());
        e.setLineNumber(c.getLineNumber());
        e.setReversalLineNumber(c.getReversalLineNumber());
        e.setDescription(c.getDescription());
        e.setVersion(c.getVersion());
        e.setPhysicalInventoryDocumentStatusId(c.getPhysicalInventoryDocumentStatusId());
        e.setPhysicalInventoryWarehouseId(c.getPhysicalInventoryWarehouseId());
        e.setPhysicalInventoryLocatorIdPattern(c.getPhysicalInventoryLocatorIdPattern());
        e.setPhysicalInventoryProductIdPattern(c.getPhysicalInventoryProductIdPattern());
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
        ((AbstractPhysicalInventoryLineMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PhysicalInventoryLineMvoEvent map(PhysicalInventoryLineMvoCommand.MergePatchPhysicalInventoryLineMvo c) {
        PhysicalInventoryLineMvoEventId stateEventId = new PhysicalInventoryLineMvoEventId(c.getPhysicalInventoryLineId(), c.getPhysicalInventoryVersion());
        PhysicalInventoryLineMvoEvent.PhysicalInventoryLineMvoStateMergePatched e = newPhysicalInventoryLineMvoStateMergePatched(stateEventId);
        e.setBookQuantity(c.getBookQuantity());
        e.setCountedQuantity(c.getCountedQuantity());
        e.setProcessed(c.getProcessed());
        e.setLineNumber(c.getLineNumber());
        e.setReversalLineNumber(c.getReversalLineNumber());
        e.setDescription(c.getDescription());
        e.setVersion(c.getVersion());
        e.setPhysicalInventoryDocumentStatusId(c.getPhysicalInventoryDocumentStatusId());
        e.setPhysicalInventoryWarehouseId(c.getPhysicalInventoryWarehouseId());
        e.setPhysicalInventoryLocatorIdPattern(c.getPhysicalInventoryLocatorIdPattern());
        e.setPhysicalInventoryProductIdPattern(c.getPhysicalInventoryProductIdPattern());
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
        e.setIsPropertyBookQuantityRemoved(c.getIsPropertyBookQuantityRemoved());
        e.setIsPropertyCountedQuantityRemoved(c.getIsPropertyCountedQuantityRemoved());
        e.setIsPropertyProcessedRemoved(c.getIsPropertyProcessedRemoved());
        e.setIsPropertyLineNumberRemoved(c.getIsPropertyLineNumberRemoved());
        e.setIsPropertyReversalLineNumberRemoved(c.getIsPropertyReversalLineNumberRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyVersionRemoved(c.getIsPropertyVersionRemoved());
        e.setIsPropertyPhysicalInventoryDocumentStatusIdRemoved(c.getIsPropertyPhysicalInventoryDocumentStatusIdRemoved());
        e.setIsPropertyPhysicalInventoryWarehouseIdRemoved(c.getIsPropertyPhysicalInventoryWarehouseIdRemoved());
        e.setIsPropertyPhysicalInventoryLocatorIdPatternRemoved(c.getIsPropertyPhysicalInventoryLocatorIdPatternRemoved());
        e.setIsPropertyPhysicalInventoryProductIdPatternRemoved(c.getIsPropertyPhysicalInventoryProductIdPatternRemoved());
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
        ((AbstractPhysicalInventoryLineMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PhysicalInventoryLineMvoEvent map(PhysicalInventoryLineMvoCommand.DeletePhysicalInventoryLineMvo c) {
        PhysicalInventoryLineMvoEventId stateEventId = new PhysicalInventoryLineMvoEventId(c.getPhysicalInventoryLineId(), c.getPhysicalInventoryVersion());
        PhysicalInventoryLineMvoEvent.PhysicalInventoryLineMvoStateDeleted e = newPhysicalInventoryLineMvoStateDeleted(stateEventId);
        ((AbstractPhysicalInventoryLineMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected PhysicalInventoryLineMvoEvent.PhysicalInventoryLineMvoStateCreated newPhysicalInventoryLineMvoStateCreated(Long version, String commandId, String requesterId) {
        PhysicalInventoryLineMvoEventId stateEventId = new PhysicalInventoryLineMvoEventId(this.state.getPhysicalInventoryLineId(), version);
        PhysicalInventoryLineMvoEvent.PhysicalInventoryLineMvoStateCreated e = newPhysicalInventoryLineMvoStateCreated(stateEventId);
        ((AbstractPhysicalInventoryLineMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PhysicalInventoryLineMvoEvent.PhysicalInventoryLineMvoStateMergePatched newPhysicalInventoryLineMvoStateMergePatched(Long version, String commandId, String requesterId) {
        PhysicalInventoryLineMvoEventId stateEventId = new PhysicalInventoryLineMvoEventId(this.state.getPhysicalInventoryLineId(), version);
        PhysicalInventoryLineMvoEvent.PhysicalInventoryLineMvoStateMergePatched e = newPhysicalInventoryLineMvoStateMergePatched(stateEventId);
        ((AbstractPhysicalInventoryLineMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PhysicalInventoryLineMvoEvent.PhysicalInventoryLineMvoStateDeleted newPhysicalInventoryLineMvoStateDeleted(Long version, String commandId, String requesterId) {
        PhysicalInventoryLineMvoEventId stateEventId = new PhysicalInventoryLineMvoEventId(this.state.getPhysicalInventoryLineId(), version);
        PhysicalInventoryLineMvoEvent.PhysicalInventoryLineMvoStateDeleted e = newPhysicalInventoryLineMvoStateDeleted(stateEventId);
        ((AbstractPhysicalInventoryLineMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PhysicalInventoryLineMvoEvent.PhysicalInventoryLineMvoStateCreated newPhysicalInventoryLineMvoStateCreated(PhysicalInventoryLineMvoEventId stateEventId) {
        return new AbstractPhysicalInventoryLineMvoEvent.SimplePhysicalInventoryLineMvoStateCreated(stateEventId);
    }

    protected PhysicalInventoryLineMvoEvent.PhysicalInventoryLineMvoStateMergePatched newPhysicalInventoryLineMvoStateMergePatched(PhysicalInventoryLineMvoEventId stateEventId) {
        return new AbstractPhysicalInventoryLineMvoEvent.SimplePhysicalInventoryLineMvoStateMergePatched(stateEventId);
    }

    protected PhysicalInventoryLineMvoEvent.PhysicalInventoryLineMvoStateDeleted newPhysicalInventoryLineMvoStateDeleted(PhysicalInventoryLineMvoEventId stateEventId)
    {
        return new AbstractPhysicalInventoryLineMvoEvent.SimplePhysicalInventoryLineMvoStateDeleted(stateEventId);
    }

    public static class SimplePhysicalInventoryLineMvoAggregate extends AbstractPhysicalInventoryLineMvoAggregate
    {
        public SimplePhysicalInventoryLineMvoAggregate(PhysicalInventoryLineMvoState state) {
            super(state);
        }

    }

}

