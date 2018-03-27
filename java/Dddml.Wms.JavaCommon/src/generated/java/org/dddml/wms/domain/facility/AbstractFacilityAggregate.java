package org.dddml.wms.domain.facility;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractFacilityAggregate extends AbstractAggregate implements FacilityAggregate
{
    private FacilityState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractFacilityAggregate(FacilityState state)
    {
        this.state = state;
    }

    public FacilityState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(FacilityCommand.CreateFacility c)
    {
        if (c.getVersion() == null) { c.setVersion(FacilityState.VERSION_NULL); }
        FacilityStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(FacilityCommand.MergePatchFacility c)
    {
        FacilityStateEvent e = map(c);
        apply(e);
    }

    public void delete(FacilityCommand.DeleteFacility c)
    {
        FacilityStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        FacilityCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected FacilityStateEvent map(FacilityCommand.CreateFacility c) {
        FacilityEventId stateEventId = new FacilityEventId(c.getFacilityId(), c.getVersion());
        FacilityStateEvent.FacilityStateCreated e = newFacilityStateCreated(stateEventId);
        e.setFacilityTypeId(c.getFacilityTypeId());
        e.setParentFacilityId(c.getParentFacilityId());
        e.setOwnerPartyId(c.getOwnerPartyId());
        e.setDefaultInventoryItemTypeId(c.getDefaultInventoryItemTypeId());
        e.setFacilityName(c.getFacilityName());
        e.setPrimaryFacilityGroupId(c.getPrimaryFacilityGroupId());
        e.setOldSquareFootage(c.getOldSquareFootage());
        e.setFacilitySize(c.getFacilitySize());
        e.setFacilitySizeUomId(c.getFacilitySizeUomId());
        e.setProductStoreId(c.getProductStoreId());
        e.setDefaultDaysToShip(c.getDefaultDaysToShip());
        e.setOpenedDate(c.getOpenedDate());
        e.setClosedDate(c.getClosedDate());
        e.setDescription(c.getDescription());
        e.setDefaultDimensionUomId(c.getDefaultDimensionUomId());
        e.setDefaultWeightUomId(c.getDefaultWeightUomId());
        e.setGeoPointId(c.getGeoPointId());
        e.setActive(c.getActive());
        ((AbstractFacilityStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected FacilityStateEvent map(FacilityCommand.MergePatchFacility c) {
        FacilityEventId stateEventId = new FacilityEventId(c.getFacilityId(), c.getVersion());
        FacilityStateEvent.FacilityStateMergePatched e = newFacilityStateMergePatched(stateEventId);
        e.setFacilityTypeId(c.getFacilityTypeId());
        e.setParentFacilityId(c.getParentFacilityId());
        e.setOwnerPartyId(c.getOwnerPartyId());
        e.setDefaultInventoryItemTypeId(c.getDefaultInventoryItemTypeId());
        e.setFacilityName(c.getFacilityName());
        e.setPrimaryFacilityGroupId(c.getPrimaryFacilityGroupId());
        e.setOldSquareFootage(c.getOldSquareFootage());
        e.setFacilitySize(c.getFacilitySize());
        e.setFacilitySizeUomId(c.getFacilitySizeUomId());
        e.setProductStoreId(c.getProductStoreId());
        e.setDefaultDaysToShip(c.getDefaultDaysToShip());
        e.setOpenedDate(c.getOpenedDate());
        e.setClosedDate(c.getClosedDate());
        e.setDescription(c.getDescription());
        e.setDefaultDimensionUomId(c.getDefaultDimensionUomId());
        e.setDefaultWeightUomId(c.getDefaultWeightUomId());
        e.setGeoPointId(c.getGeoPointId());
        e.setActive(c.getActive());
        e.setIsPropertyFacilityTypeIdRemoved(c.getIsPropertyFacilityTypeIdRemoved());
        e.setIsPropertyParentFacilityIdRemoved(c.getIsPropertyParentFacilityIdRemoved());
        e.setIsPropertyOwnerPartyIdRemoved(c.getIsPropertyOwnerPartyIdRemoved());
        e.setIsPropertyDefaultInventoryItemTypeIdRemoved(c.getIsPropertyDefaultInventoryItemTypeIdRemoved());
        e.setIsPropertyFacilityNameRemoved(c.getIsPropertyFacilityNameRemoved());
        e.setIsPropertyPrimaryFacilityGroupIdRemoved(c.getIsPropertyPrimaryFacilityGroupIdRemoved());
        e.setIsPropertyOldSquareFootageRemoved(c.getIsPropertyOldSquareFootageRemoved());
        e.setIsPropertyFacilitySizeRemoved(c.getIsPropertyFacilitySizeRemoved());
        e.setIsPropertyFacilitySizeUomIdRemoved(c.getIsPropertyFacilitySizeUomIdRemoved());
        e.setIsPropertyProductStoreIdRemoved(c.getIsPropertyProductStoreIdRemoved());
        e.setIsPropertyDefaultDaysToShipRemoved(c.getIsPropertyDefaultDaysToShipRemoved());
        e.setIsPropertyOpenedDateRemoved(c.getIsPropertyOpenedDateRemoved());
        e.setIsPropertyClosedDateRemoved(c.getIsPropertyClosedDateRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyDefaultDimensionUomIdRemoved(c.getIsPropertyDefaultDimensionUomIdRemoved());
        e.setIsPropertyDefaultWeightUomIdRemoved(c.getIsPropertyDefaultWeightUomIdRemoved());
        e.setIsPropertyGeoPointIdRemoved(c.getIsPropertyGeoPointIdRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractFacilityStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected FacilityStateEvent map(FacilityCommand.DeleteFacility c) {
        FacilityEventId stateEventId = new FacilityEventId(c.getFacilityId(), c.getVersion());
        FacilityStateEvent.FacilityStateDeleted e = newFacilityStateDeleted(stateEventId);
        ((AbstractFacilityStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected FacilityStateEvent.FacilityStateCreated newFacilityStateCreated(Long version, String commandId, String requesterId) {
        FacilityEventId stateEventId = new FacilityEventId(this.state.getFacilityId(), version);
        FacilityStateEvent.FacilityStateCreated e = newFacilityStateCreated(stateEventId);
        ((AbstractFacilityStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected FacilityStateEvent.FacilityStateMergePatched newFacilityStateMergePatched(Long version, String commandId, String requesterId) {
        FacilityEventId stateEventId = new FacilityEventId(this.state.getFacilityId(), version);
        FacilityStateEvent.FacilityStateMergePatched e = newFacilityStateMergePatched(stateEventId);
        ((AbstractFacilityStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected FacilityStateEvent.FacilityStateDeleted newFacilityStateDeleted(Long version, String commandId, String requesterId) {
        FacilityEventId stateEventId = new FacilityEventId(this.state.getFacilityId(), version);
        FacilityStateEvent.FacilityStateDeleted e = newFacilityStateDeleted(stateEventId);
        ((AbstractFacilityStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected FacilityStateEvent.FacilityStateCreated newFacilityStateCreated(FacilityEventId stateEventId) {
        return new AbstractFacilityStateEvent.SimpleFacilityStateCreated(stateEventId);
    }

    protected FacilityStateEvent.FacilityStateMergePatched newFacilityStateMergePatched(FacilityEventId stateEventId) {
        return new AbstractFacilityStateEvent.SimpleFacilityStateMergePatched(stateEventId);
    }

    protected FacilityStateEvent.FacilityStateDeleted newFacilityStateDeleted(FacilityEventId stateEventId)
    {
        return new AbstractFacilityStateEvent.SimpleFacilityStateDeleted(stateEventId);
    }

    public static class SimpleFacilityAggregate extends AbstractFacilityAggregate
    {
        public SimpleFacilityAggregate(FacilityState state) {
            super(state);
        }

    }

}

