package org.dddml.wms.domain.shipmentpackagecontentmvo;

import java.util.*;
import org.dddml.wms.domain.shipmentpackage.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractShipmentPackageContentMvoAggregate extends AbstractAggregate implements ShipmentPackageContentMvoAggregate
{
    private ShipmentPackageContentMvoState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractShipmentPackageContentMvoAggregate(ShipmentPackageContentMvoState state)
    {
        this.state = state;
    }

    public ShipmentPackageContentMvoState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(ShipmentPackageContentMvoCommand.CreateShipmentPackageContentMvo c)
    {
        if (c.getShipmentPackageVersion() == null) { c.setShipmentPackageVersion(ShipmentPackageContentMvoState.VERSION_NULL); }
        ShipmentPackageContentMvoEvent e = map(c);
        apply(e);
    }

    public void mergePatch(ShipmentPackageContentMvoCommand.MergePatchShipmentPackageContentMvo c)
    {
        ShipmentPackageContentMvoEvent e = map(c);
        apply(e);
    }

    public void delete(ShipmentPackageContentMvoCommand.DeleteShipmentPackageContentMvo c)
    {
        ShipmentPackageContentMvoEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        ShipmentPackageContentMvoCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected ShipmentPackageContentMvoEvent map(ShipmentPackageContentMvoCommand.CreateShipmentPackageContentMvo c) {
        ShipmentPackageContentMvoEventId stateEventId = new ShipmentPackageContentMvoEventId(c.getShipmentPackageContentId(), c.getShipmentPackageVersion());
        ShipmentPackageContentMvoEvent.ShipmentPackageContentMvoStateCreated e = newShipmentPackageContentMvoStateCreated(stateEventId);
        e.setQuantity(c.getQuantity());
        e.setSubProductId(c.getSubProductId());
        e.setSubProductQuantity(c.getSubProductQuantity());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setShipmentPackageShipmentBoxTypeId(c.getShipmentPackageShipmentBoxTypeId());
        e.setShipmentPackageDateCreated(c.getShipmentPackageDateCreated());
        e.setShipmentPackageBoxLength(c.getShipmentPackageBoxLength());
        e.setShipmentPackageBoxHeight(c.getShipmentPackageBoxHeight());
        e.setShipmentPackageBoxWidth(c.getShipmentPackageBoxWidth());
        e.setShipmentPackageDimensionUomId(c.getShipmentPackageDimensionUomId());
        e.setShipmentPackageWeight(c.getShipmentPackageWeight());
        e.setShipmentPackageWeightUomId(c.getShipmentPackageWeightUomId());
        e.setShipmentPackageInsuredValue(c.getShipmentPackageInsuredValue());
        e.setShipmentPackageCreatedBy(c.getShipmentPackageCreatedBy());
        e.setShipmentPackageCreatedAt(c.getShipmentPackageCreatedAt());
        e.setShipmentPackageUpdatedBy(c.getShipmentPackageUpdatedBy());
        e.setShipmentPackageUpdatedAt(c.getShipmentPackageUpdatedAt());
        e.setShipmentPackageActive(c.getShipmentPackageActive());
        e.setShipmentPackageDeleted(c.getShipmentPackageDeleted());
        ((AbstractShipmentPackageContentMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentPackageContentMvoEvent map(ShipmentPackageContentMvoCommand.MergePatchShipmentPackageContentMvo c) {
        ShipmentPackageContentMvoEventId stateEventId = new ShipmentPackageContentMvoEventId(c.getShipmentPackageContentId(), c.getShipmentPackageVersion());
        ShipmentPackageContentMvoEvent.ShipmentPackageContentMvoStateMergePatched e = newShipmentPackageContentMvoStateMergePatched(stateEventId);
        e.setQuantity(c.getQuantity());
        e.setSubProductId(c.getSubProductId());
        e.setSubProductQuantity(c.getSubProductQuantity());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setShipmentPackageShipmentBoxTypeId(c.getShipmentPackageShipmentBoxTypeId());
        e.setShipmentPackageDateCreated(c.getShipmentPackageDateCreated());
        e.setShipmentPackageBoxLength(c.getShipmentPackageBoxLength());
        e.setShipmentPackageBoxHeight(c.getShipmentPackageBoxHeight());
        e.setShipmentPackageBoxWidth(c.getShipmentPackageBoxWidth());
        e.setShipmentPackageDimensionUomId(c.getShipmentPackageDimensionUomId());
        e.setShipmentPackageWeight(c.getShipmentPackageWeight());
        e.setShipmentPackageWeightUomId(c.getShipmentPackageWeightUomId());
        e.setShipmentPackageInsuredValue(c.getShipmentPackageInsuredValue());
        e.setShipmentPackageCreatedBy(c.getShipmentPackageCreatedBy());
        e.setShipmentPackageCreatedAt(c.getShipmentPackageCreatedAt());
        e.setShipmentPackageUpdatedBy(c.getShipmentPackageUpdatedBy());
        e.setShipmentPackageUpdatedAt(c.getShipmentPackageUpdatedAt());
        e.setShipmentPackageActive(c.getShipmentPackageActive());
        e.setShipmentPackageDeleted(c.getShipmentPackageDeleted());
        e.setIsPropertyQuantityRemoved(c.getIsPropertyQuantityRemoved());
        e.setIsPropertySubProductIdRemoved(c.getIsPropertySubProductIdRemoved());
        e.setIsPropertySubProductQuantityRemoved(c.getIsPropertySubProductQuantityRemoved());
        e.setIsPropertyVersionRemoved(c.getIsPropertyVersionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setIsPropertyShipmentPackageShipmentBoxTypeIdRemoved(c.getIsPropertyShipmentPackageShipmentBoxTypeIdRemoved());
        e.setIsPropertyShipmentPackageDateCreatedRemoved(c.getIsPropertyShipmentPackageDateCreatedRemoved());
        e.setIsPropertyShipmentPackageBoxLengthRemoved(c.getIsPropertyShipmentPackageBoxLengthRemoved());
        e.setIsPropertyShipmentPackageBoxHeightRemoved(c.getIsPropertyShipmentPackageBoxHeightRemoved());
        e.setIsPropertyShipmentPackageBoxWidthRemoved(c.getIsPropertyShipmentPackageBoxWidthRemoved());
        e.setIsPropertyShipmentPackageDimensionUomIdRemoved(c.getIsPropertyShipmentPackageDimensionUomIdRemoved());
        e.setIsPropertyShipmentPackageWeightRemoved(c.getIsPropertyShipmentPackageWeightRemoved());
        e.setIsPropertyShipmentPackageWeightUomIdRemoved(c.getIsPropertyShipmentPackageWeightUomIdRemoved());
        e.setIsPropertyShipmentPackageInsuredValueRemoved(c.getIsPropertyShipmentPackageInsuredValueRemoved());
        e.setIsPropertyShipmentPackageCreatedByRemoved(c.getIsPropertyShipmentPackageCreatedByRemoved());
        e.setIsPropertyShipmentPackageCreatedAtRemoved(c.getIsPropertyShipmentPackageCreatedAtRemoved());
        e.setIsPropertyShipmentPackageUpdatedByRemoved(c.getIsPropertyShipmentPackageUpdatedByRemoved());
        e.setIsPropertyShipmentPackageUpdatedAtRemoved(c.getIsPropertyShipmentPackageUpdatedAtRemoved());
        e.setIsPropertyShipmentPackageActiveRemoved(c.getIsPropertyShipmentPackageActiveRemoved());
        e.setIsPropertyShipmentPackageDeletedRemoved(c.getIsPropertyShipmentPackageDeletedRemoved());
        ((AbstractShipmentPackageContentMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentPackageContentMvoEvent map(ShipmentPackageContentMvoCommand.DeleteShipmentPackageContentMvo c) {
        ShipmentPackageContentMvoEventId stateEventId = new ShipmentPackageContentMvoEventId(c.getShipmentPackageContentId(), c.getShipmentPackageVersion());
        ShipmentPackageContentMvoEvent.ShipmentPackageContentMvoStateDeleted e = newShipmentPackageContentMvoStateDeleted(stateEventId);
        ((AbstractShipmentPackageContentMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected ShipmentPackageContentMvoEvent.ShipmentPackageContentMvoStateCreated newShipmentPackageContentMvoStateCreated(Long version, String commandId, String requesterId) {
        ShipmentPackageContentMvoEventId stateEventId = new ShipmentPackageContentMvoEventId(this.state.getShipmentPackageContentId(), version);
        ShipmentPackageContentMvoEvent.ShipmentPackageContentMvoStateCreated e = newShipmentPackageContentMvoStateCreated(stateEventId);
        ((AbstractShipmentPackageContentMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentPackageContentMvoEvent.ShipmentPackageContentMvoStateMergePatched newShipmentPackageContentMvoStateMergePatched(Long version, String commandId, String requesterId) {
        ShipmentPackageContentMvoEventId stateEventId = new ShipmentPackageContentMvoEventId(this.state.getShipmentPackageContentId(), version);
        ShipmentPackageContentMvoEvent.ShipmentPackageContentMvoStateMergePatched e = newShipmentPackageContentMvoStateMergePatched(stateEventId);
        ((AbstractShipmentPackageContentMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentPackageContentMvoEvent.ShipmentPackageContentMvoStateDeleted newShipmentPackageContentMvoStateDeleted(Long version, String commandId, String requesterId) {
        ShipmentPackageContentMvoEventId stateEventId = new ShipmentPackageContentMvoEventId(this.state.getShipmentPackageContentId(), version);
        ShipmentPackageContentMvoEvent.ShipmentPackageContentMvoStateDeleted e = newShipmentPackageContentMvoStateDeleted(stateEventId);
        ((AbstractShipmentPackageContentMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentPackageContentMvoEvent.ShipmentPackageContentMvoStateCreated newShipmentPackageContentMvoStateCreated(ShipmentPackageContentMvoEventId stateEventId) {
        return new AbstractShipmentPackageContentMvoEvent.SimpleShipmentPackageContentMvoStateCreated(stateEventId);
    }

    protected ShipmentPackageContentMvoEvent.ShipmentPackageContentMvoStateMergePatched newShipmentPackageContentMvoStateMergePatched(ShipmentPackageContentMvoEventId stateEventId) {
        return new AbstractShipmentPackageContentMvoEvent.SimpleShipmentPackageContentMvoStateMergePatched(stateEventId);
    }

    protected ShipmentPackageContentMvoEvent.ShipmentPackageContentMvoStateDeleted newShipmentPackageContentMvoStateDeleted(ShipmentPackageContentMvoEventId stateEventId)
    {
        return new AbstractShipmentPackageContentMvoEvent.SimpleShipmentPackageContentMvoStateDeleted(stateEventId);
    }

    public static class SimpleShipmentPackageContentMvoAggregate extends AbstractShipmentPackageContentMvoAggregate
    {
        public SimpleShipmentPackageContentMvoAggregate(ShipmentPackageContentMvoState state) {
            super(state);
        }

    }

}

