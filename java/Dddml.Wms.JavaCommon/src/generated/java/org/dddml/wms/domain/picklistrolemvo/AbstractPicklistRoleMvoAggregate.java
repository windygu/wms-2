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
        PicklistRoleMvoStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(PicklistRoleMvoCommand.MergePatchPicklistRoleMvo c)
    {
        PicklistRoleMvoStateEvent e = map(c);
        apply(e);
    }

    public void delete(PicklistRoleMvoCommand.DeletePicklistRoleMvo c)
    {
        PicklistRoleMvoStateEvent e = map(c);
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

    protected PicklistRoleMvoStateEvent map(PicklistRoleMvoCommand.CreatePicklistRoleMvo c) {
        PicklistRoleMvoEventId stateEventId = new PicklistRoleMvoEventId(c.getPicklistRoleId(), c.getPicklistVersion());
        PicklistRoleMvoStateEvent.PicklistRoleMvoStateCreated e = newPicklistRoleMvoStateCreated(stateEventId);
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setPicklistDescription(c.getPicklistDescription());
        e.setPicklistFacilityId(c.getPicklistFacilityId());
        e.setPicklistShipmentMethodTypeId(c.getPicklistShipmentMethodTypeId());
        e.setPicklistStatusId(c.getPicklistStatusId());
        e.setPicklistPicklistDate(c.getPicklistPicklistDate());
        e.setPicklistCreatedByUserLogin(c.getPicklistCreatedByUserLogin());
        e.setPicklistLastModifiedByUserLogin(c.getPicklistLastModifiedByUserLogin());
        e.setPicklistPickwaveId(c.getPicklistPickwaveId());
        e.setPicklistCreatedAt(c.getPicklistCreatedAt());
        e.setPicklistUpdatedAt(c.getPicklistUpdatedAt());
        e.setPicklistActive(c.getPicklistActive());
        e.setPicklistDeleted(c.getPicklistDeleted());
        ((AbstractPicklistRoleMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedByUserLogin(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistRoleMvoStateEvent map(PicklistRoleMvoCommand.MergePatchPicklistRoleMvo c) {
        PicklistRoleMvoEventId stateEventId = new PicklistRoleMvoEventId(c.getPicklistRoleId(), c.getPicklistVersion());
        PicklistRoleMvoStateEvent.PicklistRoleMvoStateMergePatched e = newPicklistRoleMvoStateMergePatched(stateEventId);
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setPicklistDescription(c.getPicklistDescription());
        e.setPicklistFacilityId(c.getPicklistFacilityId());
        e.setPicklistShipmentMethodTypeId(c.getPicklistShipmentMethodTypeId());
        e.setPicklistStatusId(c.getPicklistStatusId());
        e.setPicklistPicklistDate(c.getPicklistPicklistDate());
        e.setPicklistCreatedByUserLogin(c.getPicklistCreatedByUserLogin());
        e.setPicklistLastModifiedByUserLogin(c.getPicklistLastModifiedByUserLogin());
        e.setPicklistPickwaveId(c.getPicklistPickwaveId());
        e.setPicklistCreatedAt(c.getPicklistCreatedAt());
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
        e.setIsPropertyPicklistCreatedByUserLoginRemoved(c.getIsPropertyPicklistCreatedByUserLoginRemoved());
        e.setIsPropertyPicklistLastModifiedByUserLoginRemoved(c.getIsPropertyPicklistLastModifiedByUserLoginRemoved());
        e.setIsPropertyPicklistPickwaveIdRemoved(c.getIsPropertyPicklistPickwaveIdRemoved());
        e.setIsPropertyPicklistCreatedAtRemoved(c.getIsPropertyPicklistCreatedAtRemoved());
        e.setIsPropertyPicklistUpdatedAtRemoved(c.getIsPropertyPicklistUpdatedAtRemoved());
        e.setIsPropertyPicklistActiveRemoved(c.getIsPropertyPicklistActiveRemoved());
        e.setIsPropertyPicklistDeletedRemoved(c.getIsPropertyPicklistDeletedRemoved());
        ((AbstractPicklistRoleMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedByUserLogin(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistRoleMvoStateEvent map(PicklistRoleMvoCommand.DeletePicklistRoleMvo c) {
        PicklistRoleMvoEventId stateEventId = new PicklistRoleMvoEventId(c.getPicklistRoleId(), c.getPicklistVersion());
        PicklistRoleMvoStateEvent.PicklistRoleMvoStateDeleted e = newPicklistRoleMvoStateDeleted(stateEventId);
        ((AbstractPicklistRoleMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedByUserLogin(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected PicklistRoleMvoStateEvent.PicklistRoleMvoStateCreated newPicklistRoleMvoStateCreated(Long version, String commandId, String requesterId) {
        PicklistRoleMvoEventId stateEventId = new PicklistRoleMvoEventId(this.state.getPicklistRoleId(), version);
        PicklistRoleMvoStateEvent.PicklistRoleMvoStateCreated e = newPicklistRoleMvoStateCreated(stateEventId);
        ((AbstractPicklistRoleMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedByUserLogin(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistRoleMvoStateEvent.PicklistRoleMvoStateMergePatched newPicklistRoleMvoStateMergePatched(Long version, String commandId, String requesterId) {
        PicklistRoleMvoEventId stateEventId = new PicklistRoleMvoEventId(this.state.getPicklistRoleId(), version);
        PicklistRoleMvoStateEvent.PicklistRoleMvoStateMergePatched e = newPicklistRoleMvoStateMergePatched(stateEventId);
        ((AbstractPicklistRoleMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedByUserLogin(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistRoleMvoStateEvent.PicklistRoleMvoStateDeleted newPicklistRoleMvoStateDeleted(Long version, String commandId, String requesterId) {
        PicklistRoleMvoEventId stateEventId = new PicklistRoleMvoEventId(this.state.getPicklistRoleId(), version);
        PicklistRoleMvoStateEvent.PicklistRoleMvoStateDeleted e = newPicklistRoleMvoStateDeleted(stateEventId);
        ((AbstractPicklistRoleMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedByUserLogin(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PicklistRoleMvoStateEvent.PicklistRoleMvoStateCreated newPicklistRoleMvoStateCreated(PicklistRoleMvoEventId stateEventId) {
        return new AbstractPicklistRoleMvoStateEvent.SimplePicklistRoleMvoStateCreated(stateEventId);
    }

    protected PicklistRoleMvoStateEvent.PicklistRoleMvoStateMergePatched newPicklistRoleMvoStateMergePatched(PicklistRoleMvoEventId stateEventId) {
        return new AbstractPicklistRoleMvoStateEvent.SimplePicklistRoleMvoStateMergePatched(stateEventId);
    }

    protected PicklistRoleMvoStateEvent.PicklistRoleMvoStateDeleted newPicklistRoleMvoStateDeleted(PicklistRoleMvoEventId stateEventId)
    {
        return new AbstractPicklistRoleMvoStateEvent.SimplePicklistRoleMvoStateDeleted(stateEventId);
    }

    public static class SimplePicklistRoleMvoAggregate extends AbstractPicklistRoleMvoAggregate
    {
        public SimplePicklistRoleMvoAggregate(PicklistRoleMvoState state) {
            super(state);
        }

    }

}

