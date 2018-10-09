package org.dddml.wms.domain.partyrole;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractPartyRoleAggregate extends AbstractAggregate implements PartyRoleAggregate
{
    private PartyRoleState.MutablePartyRoleState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractPartyRoleAggregate(PartyRoleState state)
    {
        this.state = (PartyRoleState.MutablePartyRoleState)state;
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
        PartyRoleEvent e = map(c);
        apply(e);
    }

    public void mergePatch(PartyRoleCommand.MergePatchPartyRole c)
    {
        PartyRoleEvent e = map(c);
        apply(e);
    }

    public void delete(PartyRoleCommand.DeletePartyRole c)
    {
        PartyRoleEvent e = map(c);
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

    protected PartyRoleEvent map(PartyRoleCommand.CreatePartyRole c) {
        PartyRoleEventId stateEventId = new PartyRoleEventId(c.getPartyRoleId(), c.getVersion());
        PartyRoleEvent.PartyRoleStateCreated e = newPartyRoleStateCreated(stateEventId);
        e.setActive(c.getActive());
        ((AbstractPartyRoleEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PartyRoleEvent map(PartyRoleCommand.MergePatchPartyRole c) {
        PartyRoleEventId stateEventId = new PartyRoleEventId(c.getPartyRoleId(), c.getVersion());
        PartyRoleEvent.PartyRoleStateMergePatched e = newPartyRoleStateMergePatched(stateEventId);
        e.setActive(c.getActive());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractPartyRoleEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PartyRoleEvent map(PartyRoleCommand.DeletePartyRole c) {
        PartyRoleEventId stateEventId = new PartyRoleEventId(c.getPartyRoleId(), c.getVersion());
        PartyRoleEvent.PartyRoleStateDeleted e = newPartyRoleStateDeleted(stateEventId);
        ((AbstractPartyRoleEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected PartyRoleEvent.PartyRoleStateCreated newPartyRoleStateCreated(Long version, String commandId, String requesterId) {
        PartyRoleEventId stateEventId = new PartyRoleEventId(this.state.getPartyRoleId(), version);
        PartyRoleEvent.PartyRoleStateCreated e = newPartyRoleStateCreated(stateEventId);
        ((AbstractPartyRoleEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PartyRoleEvent.PartyRoleStateMergePatched newPartyRoleStateMergePatched(Long version, String commandId, String requesterId) {
        PartyRoleEventId stateEventId = new PartyRoleEventId(this.state.getPartyRoleId(), version);
        PartyRoleEvent.PartyRoleStateMergePatched e = newPartyRoleStateMergePatched(stateEventId);
        ((AbstractPartyRoleEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PartyRoleEvent.PartyRoleStateDeleted newPartyRoleStateDeleted(Long version, String commandId, String requesterId) {
        PartyRoleEventId stateEventId = new PartyRoleEventId(this.state.getPartyRoleId(), version);
        PartyRoleEvent.PartyRoleStateDeleted e = newPartyRoleStateDeleted(stateEventId);
        ((AbstractPartyRoleEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected PartyRoleEvent.PartyRoleStateCreated newPartyRoleStateCreated(PartyRoleEventId stateEventId) {
        return new AbstractPartyRoleEvent.SimplePartyRoleStateCreated(stateEventId);
    }

    protected PartyRoleEvent.PartyRoleStateMergePatched newPartyRoleStateMergePatched(PartyRoleEventId stateEventId) {
        return new AbstractPartyRoleEvent.SimplePartyRoleStateMergePatched(stateEventId);
    }

    protected PartyRoleEvent.PartyRoleStateDeleted newPartyRoleStateDeleted(PartyRoleEventId stateEventId)
    {
        return new AbstractPartyRoleEvent.SimplePartyRoleStateDeleted(stateEventId);
    }

    public static class SimplePartyRoleAggregate extends AbstractPartyRoleAggregate
    {
        public SimplePartyRoleAggregate(PartyRoleState state) {
            super(state);
        }

    }

}

