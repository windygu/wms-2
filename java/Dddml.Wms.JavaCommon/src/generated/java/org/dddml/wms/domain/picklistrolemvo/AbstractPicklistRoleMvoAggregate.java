package org.dddml.wms.domain.picklistrolemvo;

import java.util.*;
import org.dddml.wms.domain.picklist.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractPicklistRoleMvoAggregate extends AbstractAggregate implements PicklistRoleMvoAggregate
{
    private PicklistRoleMvoState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractPicklistRoleMvoAggregate(PicklistRoleMvoState state)
    {
        this.state = state;
    }

    public PicklistRoleMvoState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(PicklistRoleMvoCommand.CreatePicklistRoleMvo c)
    {
        if (c.getPicklistVersion() == null) { c.setPicklistVersion(PicklistRoleMvoState.VERSION_NULL); }
        PicklistRoleMvoEvent e = map(c);
        apply(e);
    }

    public void mergePatch(PicklistRoleMvoCommand.MergePatchPicklistRoleMvo c)
    {
        PicklistRoleMvoEvent e = map(c);
        apply(e);
    }

    public void delete(PicklistRoleMvoCommand.DeletePicklistRoleMvo c)
    {
        PicklistRoleMvoEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        PicklistRoleMvoCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected PicklistRoleMvoEvent map(PicklistRoleMvoCommand.CreatePicklistRoleMvo c) {
        PicklistRoleMvoEventId stateEventId = new PicklistRoleMvoEventId(c.getPicklistRoleId(), c.getPicklistVersion());
        PicklistRoleMvoEvent.PicklistRoleMvoStateCreated e = newPicklistRoleMvoStateCreated(stateEventId);
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setPicklistDescription(c.getPicklistDescription());
        e.setPicklistFacilityId(c.getPicklistFacilityId());
        e.setPicklistShipmentMethodTypeId(c.getPicklistShipmentMethodTypeId());
        e.setPicklistStatusId(c.getPicklistStatusId());
        e.setPicklistPicklistDate(c.getPicklistPicklistDate());
        e.setPicklistPickwaveId(c.getPicklistPickwaveId());
        e.setPicklistCreatedBy(c.getPicklistCreatedBy());
        e.setPicklistCreatedAt(c.getPicklistCreatedAt());
        e.setPicklistUpdatedBy(c.getPicklistUpdatedBy());
        e.setPicklistUpdatedAt(c.getPicklistUpdatedAt());
        e.setPicklistActive(c.getPicklistActive());
        e.setPicklistDeleted(c.getPicklistDeleted());
        ((AbstractPicklistRoleMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedByUserLogin(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistRoleMvoEvent map(PicklistRoleMvoCommand.MergePatchPicklistRoleMvo c) {
        PicklistRoleMvoEventId stateEventId = new PicklistRoleMvoEventId(c.getPicklistRoleId(), c.getPicklistVersion());
        PicklistRoleMvoEvent.PicklistRoleMvoStateMergePatched e = newPicklistRoleMvoStateMergePatched(stateEventId);
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setPicklistDescription(c.getPicklistDescription());
        e.setPicklistFacilityId(c.getPicklistFacilityId());
        e.setPicklistShipmentMethodTypeId(c.getPicklistShipmentMethodTypeId());
        e.setPicklistStatusId(c.getPicklistStatusId());
        e.setPicklistPicklistDate(c.getPicklistPicklistDate());
        e.setPicklistPickwaveId(c.getPicklistPickwaveId());
        e.setPicklistCreatedBy(c.getPicklistCreatedBy());
        e.setPicklistCreatedAt(c.getPicklistCreatedAt());
        e.setPicklistUpdatedBy(c.getPicklistUpdatedBy());
        e.setPicklistUpdatedAt(c.getPicklistUpdatedAt());
        e.setPicklistActive(c.getPicklistActive());
        e.setPicklistDeleted(c.getPicklistDeleted());
        e.setIsPropertyVersionRemoved(c.getIsPropertyVersionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setIsPropertyPicklistDescriptionRemoved(c.getIsPropertyPicklistDescriptionRemoved());
        e.setIsPropertyPicklistFacilityIdRemoved(c.getIsPropertyPicklistFacilityIdRemoved());
        e.setIsPropertyPicklistShipmentMethodTypeIdRemoved(c.getIsPropertyPicklistShipmentMethodTypeIdRemoved());
        e.setIsPropertyPicklistStatusIdRemoved(c.getIsPropertyPicklistStatusIdRemoved());
        e.setIsPropertyPicklistPicklistDateRemoved(c.getIsPropertyPicklistPicklistDateRemoved());
        e.setIsPropertyPicklistPickwaveIdRemoved(c.getIsPropertyPicklistPickwaveIdRemoved());
        e.setIsPropertyPicklistCreatedByRemoved(c.getIsPropertyPicklistCreatedByRemoved());
        e.setIsPropertyPicklistCreatedAtRemoved(c.getIsPropertyPicklistCreatedAtRemoved());
        e.setIsPropertyPicklistUpdatedByRemoved(c.getIsPropertyPicklistUpdatedByRemoved());
        e.setIsPropertyPicklistUpdatedAtRemoved(c.getIsPropertyPicklistUpdatedAtRemoved());
        e.setIsPropertyPicklistActiveRemoved(c.getIsPropertyPicklistActiveRemoved());
        e.setIsPropertyPicklistDeletedRemoved(c.getIsPropertyPicklistDeletedRemoved());
        ((AbstractPicklistRoleMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedByUserLogin(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistRoleMvoEvent map(PicklistRoleMvoCommand.DeletePicklistRoleMvo c) {
        PicklistRoleMvoEventId stateEventId = new PicklistRoleMvoEventId(c.getPicklistRoleId(), c.getPicklistVersion());
        PicklistRoleMvoEvent.PicklistRoleMvoStateDeleted e = newPicklistRoleMvoStateDeleted(stateEventId);
        ((AbstractPicklistRoleMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedByUserLogin(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected PicklistRoleMvoEvent.PicklistRoleMvoStateCreated newPicklistRoleMvoStateCreated(Long version, String commandId, String requesterId) {
        PicklistRoleMvoEventId stateEventId = new PicklistRoleMvoEventId(this.state.getPicklistRoleId(), version);
        PicklistRoleMvoEvent.PicklistRoleMvoStateCreated e = newPicklistRoleMvoStateCreated(stateEventId);
        ((AbstractPicklistRoleMvoEvent)e).setCommandId(commandId);
        e.setCreatedByUserLogin(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistRoleMvoEvent.PicklistRoleMvoStateMergePatched newPicklistRoleMvoStateMergePatched(Long version, String commandId, String requesterId) {
        PicklistRoleMvoEventId stateEventId = new PicklistRoleMvoEventId(this.state.getPicklistRoleId(), version);
        PicklistRoleMvoEvent.PicklistRoleMvoStateMergePatched e = newPicklistRoleMvoStateMergePatched(stateEventId);
        ((AbstractPicklistRoleMvoEvent)e).setCommandId(commandId);
        e.setCreatedByUserLogin(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistRoleMvoEvent.PicklistRoleMvoStateDeleted newPicklistRoleMvoStateDeleted(Long version, String commandId, String requesterId) {
        PicklistRoleMvoEventId stateEventId = new PicklistRoleMvoEventId(this.state.getPicklistRoleId(), version);
        PicklistRoleMvoEvent.PicklistRoleMvoStateDeleted e = newPicklistRoleMvoStateDeleted(stateEventId);
        ((AbstractPicklistRoleMvoEvent)e).setCommandId(commandId);
        e.setCreatedByUserLogin(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistRoleMvoEvent.PicklistRoleMvoStateCreated newPicklistRoleMvoStateCreated(PicklistRoleMvoEventId stateEventId) {
        return new AbstractPicklistRoleMvoEvent.SimplePicklistRoleMvoStateCreated(stateEventId);
    }

    protected PicklistRoleMvoEvent.PicklistRoleMvoStateMergePatched newPicklistRoleMvoStateMergePatched(PicklistRoleMvoEventId stateEventId) {
        return new AbstractPicklistRoleMvoEvent.SimplePicklistRoleMvoStateMergePatched(stateEventId);
    }

    protected PicklistRoleMvoEvent.PicklistRoleMvoStateDeleted newPicklistRoleMvoStateDeleted(PicklistRoleMvoEventId stateEventId)
    {
        return new AbstractPicklistRoleMvoEvent.SimplePicklistRoleMvoStateDeleted(stateEventId);
    }

    public static class SimplePicklistRoleMvoAggregate extends AbstractPicklistRoleMvoAggregate
    {
        public SimplePicklistRoleMvoAggregate(PicklistRoleMvoState state) {
            super(state);
        }

    }

}

