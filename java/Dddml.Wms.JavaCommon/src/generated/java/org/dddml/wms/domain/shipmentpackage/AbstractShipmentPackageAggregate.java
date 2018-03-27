package org.dddml.wms.domain.shipmentpackage;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractShipmentPackageAggregate extends AbstractAggregate implements ShipmentPackageAggregate
{
    private ShipmentPackageState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractShipmentPackageAggregate(ShipmentPackageState state)
    {
        this.state = state;
    }

    public ShipmentPackageState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(ShipmentPackageCommand.CreateShipmentPackage c)
    {
        if (c.getVersion() == null) { c.setVersion(ShipmentPackageState.VERSION_NULL); }
        ShipmentPackageStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(ShipmentPackageCommand.MergePatchShipmentPackage c)
    {
        ShipmentPackageStateEvent e = map(c);
        apply(e);
    }

    public void delete(ShipmentPackageCommand.DeleteShipmentPackage c)
    {
        ShipmentPackageStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        ShipmentPackageCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected ShipmentPackageStateEvent map(ShipmentPackageCommand.CreateShipmentPackage c) {
        ShipmentPackageEventId stateEventId = new ShipmentPackageEventId(c.getShipmentPackageId(), c.getVersion());
        ShipmentPackageStateEvent.ShipmentPackageStateCreated e = newShipmentPackageStateCreated(stateEventId);
        e.setShipmentBoxTypeId(c.getShipmentBoxTypeId());
        e.setDateCreated(c.getDateCreated());
        e.setBoxLength(c.getBoxLength());
        e.setBoxHeight(c.getBoxHeight());
        e.setBoxWidth(c.getBoxWidth());
        e.setDimensionUomId(c.getDimensionUomId());
        e.setWeight(c.getWeight());
        e.setWeightUomId(c.getWeightUomId());
        e.setInsuredValue(c.getInsuredValue());
        e.setActive(c.getActive());
        ((AbstractShipmentPackageStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (ShipmentPackageContentCommand.CreateShipmentPackageContent innerCommand : c.getShipmentPackageContents())
        {
            throwOnInconsistentCommands(c, innerCommand);
            ShipmentPackageContentStateEvent.ShipmentPackageContentStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addShipmentPackageContentEvent(innerEvent);
        }

        return e;
    }

    protected ShipmentPackageStateEvent map(ShipmentPackageCommand.MergePatchShipmentPackage c) {
        ShipmentPackageEventId stateEventId = new ShipmentPackageEventId(c.getShipmentPackageId(), c.getVersion());
        ShipmentPackageStateEvent.ShipmentPackageStateMergePatched e = newShipmentPackageStateMergePatched(stateEventId);
        e.setShipmentBoxTypeId(c.getShipmentBoxTypeId());
        e.setDateCreated(c.getDateCreated());
        e.setBoxLength(c.getBoxLength());
        e.setBoxHeight(c.getBoxHeight());
        e.setBoxWidth(c.getBoxWidth());
        e.setDimensionUomId(c.getDimensionUomId());
        e.setWeight(c.getWeight());
        e.setWeightUomId(c.getWeightUomId());
        e.setInsuredValue(c.getInsuredValue());
        e.setActive(c.getActive());
        e.setIsPropertyShipmentBoxTypeIdRemoved(c.getIsPropertyShipmentBoxTypeIdRemoved());
        e.setIsPropertyDateCreatedRemoved(c.getIsPropertyDateCreatedRemoved());
        e.setIsPropertyBoxLengthRemoved(c.getIsPropertyBoxLengthRemoved());
        e.setIsPropertyBoxHeightRemoved(c.getIsPropertyBoxHeightRemoved());
        e.setIsPropertyBoxWidthRemoved(c.getIsPropertyBoxWidthRemoved());
        e.setIsPropertyDimensionUomIdRemoved(c.getIsPropertyDimensionUomIdRemoved());
        e.setIsPropertyWeightRemoved(c.getIsPropertyWeightRemoved());
        e.setIsPropertyWeightUomIdRemoved(c.getIsPropertyWeightUomIdRemoved());
        e.setIsPropertyInsuredValueRemoved(c.getIsPropertyInsuredValueRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractShipmentPackageStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (ShipmentPackageContentCommand innerCommand : c.getShipmentPackageContentCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            ShipmentPackageContentStateEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addShipmentPackageContentEvent(innerEvent);
        }

        return e;
    }

    protected ShipmentPackageStateEvent map(ShipmentPackageCommand.DeleteShipmentPackage c) {
        ShipmentPackageEventId stateEventId = new ShipmentPackageEventId(c.getShipmentPackageId(), c.getVersion());
        ShipmentPackageStateEvent.ShipmentPackageStateDeleted e = newShipmentPackageStateDeleted(stateEventId);
        ((AbstractShipmentPackageStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    protected ShipmentPackageContentStateEvent map(ShipmentPackageContentCommand c, ShipmentPackageCommand outerCommand, long version, ShipmentPackageState outerState)
    {
        ShipmentPackageContentCommand.CreateShipmentPackageContent create = (c.getCommandType().equals(CommandType.CREATE)) ? ((ShipmentPackageContentCommand.CreateShipmentPackageContent)c) : null;
        if(create != null)
        {
            return mapCreate(create, outerCommand, version, outerState);
        }

        ShipmentPackageContentCommand.MergePatchShipmentPackageContent merge = (c.getCommandType().equals(CommandType.MERGE_PATCH)) ? ((ShipmentPackageContentCommand.MergePatchShipmentPackageContent)c) : null;
        if(merge != null)
        {
            return mapMergePatch(merge, outerCommand, version, outerState);
        }

        ShipmentPackageContentCommand.RemoveShipmentPackageContent remove = (c.getCommandType().equals(CommandType.REMOVE)) ? ((ShipmentPackageContentCommand.RemoveShipmentPackageContent)c) : null;
        if (remove != null)
        {
            return mapRemove(remove, outerCommand, version);
        }
        throw new UnsupportedOperationException();
    }

    protected ShipmentPackageContentStateEvent.ShipmentPackageContentStateCreated mapCreate(ShipmentPackageContentCommand.CreateShipmentPackageContent c, ShipmentPackageCommand outerCommand, Long version, ShipmentPackageState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        ShipmentPackageContentEventId stateEventId = new ShipmentPackageContentEventId(c.getShipmentPackageId(), c.getShipmentItemSeqId(), version);
        ShipmentPackageContentStateEvent.ShipmentPackageContentStateCreated e = newShipmentPackageContentStateCreated(stateEventId);
        ShipmentPackageContentState s = outerState.getShipmentPackageContents().get(c.getShipmentItemSeqId());

        e.setQuantity(c.getQuantity());
        e.setSubProductId(c.getSubProductId());
        e.setSubProductQuantity(c.getSubProductQuantity());
        e.setActive(c.getActive());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected ShipmentPackageContentStateEvent.ShipmentPackageContentStateMergePatched mapMergePatch(ShipmentPackageContentCommand.MergePatchShipmentPackageContent c, ShipmentPackageCommand outerCommand, Long version, ShipmentPackageState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        ShipmentPackageContentEventId stateEventId = new ShipmentPackageContentEventId(c.getShipmentPackageId(), c.getShipmentItemSeqId(), version);
        ShipmentPackageContentStateEvent.ShipmentPackageContentStateMergePatched e = newShipmentPackageContentStateMergePatched(stateEventId);
        ShipmentPackageContentState s = outerState.getShipmentPackageContents().get(c.getShipmentItemSeqId());

        e.setQuantity(c.getQuantity());
        e.setSubProductId(c.getSubProductId());
        e.setSubProductQuantity(c.getSubProductQuantity());
        e.setActive(c.getActive());
        e.setIsPropertyQuantityRemoved(c.getIsPropertyQuantityRemoved());
        e.setIsPropertySubProductIdRemoved(c.getIsPropertySubProductIdRemoved());
        e.setIsPropertySubProductQuantityRemoved(c.getIsPropertySubProductQuantityRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(IMergePatch... ////////////////////////////

    protected ShipmentPackageContentStateEvent.ShipmentPackageContentStateRemoved mapRemove(ShipmentPackageContentCommand.RemoveShipmentPackageContent c, ShipmentPackageCommand outerCommand, Long version)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        ShipmentPackageContentEventId stateEventId = new ShipmentPackageContentEventId(c.getShipmentPackageId(), c.getShipmentItemSeqId(), version);
        ShipmentPackageContentStateEvent.ShipmentPackageContentStateRemoved e = newShipmentPackageContentStateRemoved(stateEventId);

        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

        return e;

    }// END map(IRemove... ////////////////////////////

    protected void throwOnInconsistentCommands(ShipmentPackageCommand command, ShipmentPackageContentCommand innerCommand)
    {
        AbstractShipmentPackageCommand properties = command instanceof AbstractShipmentPackageCommand ? (AbstractShipmentPackageCommand) command : null;
        AbstractShipmentPackageContentCommand innerProperties = innerCommand instanceof AbstractShipmentPackageContentCommand ? (AbstractShipmentPackageContentCommand) innerCommand : null;
        if (properties == null || innerProperties == null) { return; }
        String outerShipmentPackageIdName = "ShipmentPackageId";
        ShipmentPackageId outerShipmentPackageIdValue = properties.getShipmentPackageId();
        String innerShipmentPackageIdName = "ShipmentPackageId";
        ShipmentPackageId innerShipmentPackageIdValue = innerProperties.getShipmentPackageId();
        if (innerShipmentPackageIdValue == null) {
            innerProperties.setShipmentPackageId(outerShipmentPackageIdValue);
        }
        else if (innerShipmentPackageIdValue != outerShipmentPackageIdValue 
            && (innerShipmentPackageIdValue == null || innerShipmentPackageIdValue != null && !innerShipmentPackageIdValue.equals(outerShipmentPackageIdValue))) 
        {
            throw DomainError.named("inconsistentId", "Outer %1$s %2$s NOT equals inner %3$s %4$s", outerShipmentPackageIdName, outerShipmentPackageIdValue, innerShipmentPackageIdName, innerShipmentPackageIdValue);
        }
    }// END throwOnInconsistentCommands /////////////////////


    ////////////////////////

    protected ShipmentPackageStateEvent.ShipmentPackageStateCreated newShipmentPackageStateCreated(Long version, String commandId, String requesterId) {
        ShipmentPackageEventId stateEventId = new ShipmentPackageEventId(this.state.getShipmentPackageId(), version);
        ShipmentPackageStateEvent.ShipmentPackageStateCreated e = newShipmentPackageStateCreated(stateEventId);
        ((AbstractShipmentPackageStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentPackageStateEvent.ShipmentPackageStateMergePatched newShipmentPackageStateMergePatched(Long version, String commandId, String requesterId) {
        ShipmentPackageEventId stateEventId = new ShipmentPackageEventId(this.state.getShipmentPackageId(), version);
        ShipmentPackageStateEvent.ShipmentPackageStateMergePatched e = newShipmentPackageStateMergePatched(stateEventId);
        ((AbstractShipmentPackageStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentPackageStateEvent.ShipmentPackageStateDeleted newShipmentPackageStateDeleted(Long version, String commandId, String requesterId) {
        ShipmentPackageEventId stateEventId = new ShipmentPackageEventId(this.state.getShipmentPackageId(), version);
        ShipmentPackageStateEvent.ShipmentPackageStateDeleted e = newShipmentPackageStateDeleted(stateEventId);
        ((AbstractShipmentPackageStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentPackageStateEvent.ShipmentPackageStateCreated newShipmentPackageStateCreated(ShipmentPackageEventId stateEventId) {
        return new AbstractShipmentPackageStateEvent.SimpleShipmentPackageStateCreated(stateEventId);
    }

    protected ShipmentPackageStateEvent.ShipmentPackageStateMergePatched newShipmentPackageStateMergePatched(ShipmentPackageEventId stateEventId) {
        return new AbstractShipmentPackageStateEvent.SimpleShipmentPackageStateMergePatched(stateEventId);
    }

    protected ShipmentPackageStateEvent.ShipmentPackageStateDeleted newShipmentPackageStateDeleted(ShipmentPackageEventId stateEventId)
    {
        return new AbstractShipmentPackageStateEvent.SimpleShipmentPackageStateDeleted(stateEventId);
    }

    protected ShipmentPackageContentStateEvent.ShipmentPackageContentStateCreated newShipmentPackageContentStateCreated(ShipmentPackageContentEventId stateEventId) {
        return new AbstractShipmentPackageContentStateEvent.SimpleShipmentPackageContentStateCreated(stateEventId);
    }

    protected ShipmentPackageContentStateEvent.ShipmentPackageContentStateMergePatched newShipmentPackageContentStateMergePatched(ShipmentPackageContentEventId stateEventId) {
        return new AbstractShipmentPackageContentStateEvent.SimpleShipmentPackageContentStateMergePatched(stateEventId);
    }

    protected ShipmentPackageContentStateEvent.ShipmentPackageContentStateRemoved newShipmentPackageContentStateRemoved(ShipmentPackageContentEventId stateEventId)
    {
        return new AbstractShipmentPackageContentStateEvent.SimpleShipmentPackageContentStateRemoved(stateEventId);
    }

    public static class SimpleShipmentPackageAggregate extends AbstractShipmentPackageAggregate
    {
        public SimpleShipmentPackageAggregate(ShipmentPackageState state) {
            super(state);
        }

    }

}

