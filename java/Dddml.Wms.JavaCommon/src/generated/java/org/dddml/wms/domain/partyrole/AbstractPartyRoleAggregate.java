package org.dddml.wms.domain.partyrole;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractPartyRoleAggregate extends AbstractAggregate implements PartyRoleAggregate
{
    private PartyRoleState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractPartyRoleAggregate(PartyRoleState state)
    {
        this.state = state;
    }

    public PartyRoleState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(PartyRoleCommand.CreatePartyRole c)
    {
        if (c.getVersion() == null) { c.setVersion(PartyRoleState.VERSION_NULL); }
        PartyRoleStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(PartyRoleCommand.MergePatchPartyRole c)
    {
        PartyRoleStateEvent e = map(c);
        apply(e);
    }

    public void delete(PartyRoleCommand.DeletePartyRole c)
    {
        PartyRoleStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        PartyRoleCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected PartyRoleStateEvent map(PartyRoleCommand.CreatePartyRole c) {
        PartyRoleEventId stateEventId = new PartyRoleEventId(c.getPartyRoleId(), c.getVersion());
        PartyRoleStateEvent.PartyRoleStateCreated e = newPartyRoleStateCreated(stateEventId);
        e.setActive(c.getActive());
        ((AbstractPartyRoleStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PartyRoleStateEvent map(PartyRoleCommand.MergePatchPartyRole c) {
        PartyRoleEventId stateEventId = new PartyRoleEventId(c.getPartyRoleId(), c.getVersion());
        PartyRoleStateEvent.PartyRoleStateMergePatched e = newPartyRoleStateMergePatched(stateEventId);
        e.setActive(c.getActive());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractPartyRoleStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PartyRoleStateEvent map(PartyRoleCommand.DeletePartyRole c) {
        PartyRoleEventId stateEventId = new PartyRoleEventId(c.getPartyRoleId(), c.getVersion());
        PartyRoleStateEvent.PartyRoleStateDeleted e = newPartyRoleStateDeleted(stateEventId);
        ((AbstractPartyRoleStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected PartyRoleStateEvent.PartyRoleStateCreated newPartyRoleStateCreated(Long version, String commandId, String requesterId) {
        PartyRoleEventId stateEventId = new PartyRoleEventId(this.state.getPartyRoleId(), version);
        PartyRoleStateEvent.PartyRoleStateCreated e = newPartyRoleStateCreated(stateEventId);
        ((AbstractPartyRoleStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PartyRoleStateEvent.PartyRoleStateMergePatched newPartyRoleStateMergePatched(Long version, String commandId, String requesterId) {
        PartyRoleEventId stateEventId = new PartyRoleEventId(this.state.getPartyRoleId(), version);
        PartyRoleStateEvent.PartyRoleStateMergePatched e = newPartyRoleStateMergePatched(stateEventId);
        ((AbstractPartyRoleStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PartyRoleStateEvent.PartyRoleStateDeleted newPartyRoleStateDeleted(Long version, String commandId, String requesterId) {
        PartyRoleEventId stateEventId = new PartyRoleEventId(this.state.getPartyRoleId(), version);
        PartyRoleStateEvent.PartyRoleStateDeleted e = newPartyRoleStateDeleted(stateEventId);
        ((AbstractPartyRoleStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PartyRoleStateEvent.PartyRoleStateCreated newPartyRoleStateCreated(PartyRoleEventId stateEventId) {
        return new AbstractPartyRoleStateEvent.SimplePartyRoleStateCreated(stateEventId);
    }

    protected PartyRoleStateEvent.PartyRoleStateMergePatched newPartyRoleStateMergePatched(PartyRoleEventId stateEventId) {
        return new AbstractPartyRoleStateEvent.SimplePartyRoleStateMergePatched(stateEventId);
    }

    protected PartyRoleStateEvent.PartyRoleStateDeleted newPartyRoleStateDeleted(PartyRoleEventId stateEventId)
    {
        return new AbstractPartyRoleStateEvent.SimplePartyRoleStateDeleted(stateEventId);
    }

    public static class SimplePartyRoleAggregate extends AbstractPartyRoleAggregate
    {
        public SimplePartyRoleAggregate(PartyRoleState state) {
            super(state);
        }

    }

}

