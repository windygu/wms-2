package org.dddml.wms.domain.lot;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractLotAggregate extends AbstractAggregate implements LotAggregate
{
    private LotState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractLotAggregate(LotState state)
    {
        this.state = state;
    }

    public LotState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(LotCommand.CreateLot c)
    {
        if (c.getVersion() == null) { c.setVersion(LotState.VERSION_NULL); }
        LotStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(LotCommand.MergePatchLot c)
    {
        LotStateEvent e = map(c);
        apply(e);
    }

    public void delete(LotCommand.DeleteLot c)
    {
        LotStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        LotCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected LotStateEvent map(LotCommand.CreateLot c) {
        LotStateEventId stateEventId = new LotStateEventId(c.getLotId(), c.getVersion());
        LotStateEvent.LotStateCreated e = newLotStateCreated(stateEventId);
        e.setCreationDate(c.getCreationDate());
        e.setQuantity(c.getQuantity());
        e.setExpirationDate(c.getExpirationDate());
        e.setActive(c.getActive());
        ((AbstractLotStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LotStateEvent map(LotCommand.MergePatchLot c) {
        LotStateEventId stateEventId = new LotStateEventId(c.getLotId(), c.getVersion());
        LotStateEvent.LotStateMergePatched e = newLotStateMergePatched(stateEventId);
        e.setCreationDate(c.getCreationDate());
        e.setQuantity(c.getQuantity());
        e.setExpirationDate(c.getExpirationDate());
        e.setActive(c.getActive());
        e.setIsPropertyCreationDateRemoved(c.getIsPropertyCreationDateRemoved());
        e.setIsPropertyQuantityRemoved(c.getIsPropertyQuantityRemoved());
        e.setIsPropertyExpirationDateRemoved(c.getIsPropertyExpirationDateRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractLotStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LotStateEvent map(LotCommand.DeleteLot c) {
        LotStateEventId stateEventId = new LotStateEventId(c.getLotId(), c.getVersion());
        LotStateEvent.LotStateDeleted e = newLotStateDeleted(stateEventId);
        ((AbstractLotStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected LotStateEvent.LotStateCreated newLotStateCreated(String commandId, String requesterId) {
        LotStateEventId stateEventId = new LotStateEventId(this.state.getLotId(), this.state.getVersion());
        LotStateEvent.LotStateCreated e = newLotStateCreated(stateEventId);
        ((AbstractLotStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LotStateEvent.LotStateMergePatched newLotStateMergePatched(String commandId, String requesterId) {
        LotStateEventId stateEventId = new LotStateEventId(this.state.getLotId(), this.state.getVersion());
        LotStateEvent.LotStateMergePatched e = newLotStateMergePatched(stateEventId);
        ((AbstractLotStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LotStateEvent.LotStateDeleted newLotStateDeleted(String commandId, String requesterId) {
        LotStateEventId stateEventId = new LotStateEventId(this.state.getLotId(), this.state.getVersion());
        LotStateEvent.LotStateDeleted e = newLotStateDeleted(stateEventId);
        ((AbstractLotStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LotStateEvent.LotStateCreated newLotStateCreated(LotStateEventId stateEventId) {
        return new AbstractLotStateEvent.SimpleLotStateCreated(stateEventId);
    }

    protected LotStateEvent.LotStateMergePatched newLotStateMergePatched(LotStateEventId stateEventId) {
        return new AbstractLotStateEvent.SimpleLotStateMergePatched(stateEventId);
    }

    protected LotStateEvent.LotStateDeleted newLotStateDeleted(LotStateEventId stateEventId)
    {
        return new AbstractLotStateEvent.SimpleLotStateDeleted(stateEventId);
    }


    public static class SimpleLotAggregate extends AbstractLotAggregate
    {
        public SimpleLotAggregate(LotState state) {
            super(state);
        }

    }

}

