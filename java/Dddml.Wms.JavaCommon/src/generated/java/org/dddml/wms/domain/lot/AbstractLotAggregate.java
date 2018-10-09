package org.dddml.wms.domain.lot;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractLotAggregate extends AbstractAggregate implements LotAggregate
{
    private LotState.MutableLotState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractLotAggregate(LotState state)
    {
        this.state = (LotState.MutableLotState)state;
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
        LotEvent e = map(c);
        apply(e);
    }

    public void mergePatch(LotCommand.MergePatchLot c)
    {
        LotEvent e = map(c);
        apply(e);
    }

    public void delete(LotCommand.DeleteLot c)
    {
        LotEvent e = map(c);
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

    protected LotEvent map(LotCommand.CreateLot c) {
        LotEventId stateEventId = new LotEventId(c.getLotId(), c.getVersion());
        LotEvent.LotStateCreated e = newLotStateCreated(stateEventId);
        e.setQuantity(c.getQuantity());
        e.setExpirationDate(c.getExpirationDate());
        e.setActive(c.getActive());
        ((AbstractLotEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LotEvent map(LotCommand.MergePatchLot c) {
        LotEventId stateEventId = new LotEventId(c.getLotId(), c.getVersion());
        LotEvent.LotStateMergePatched e = newLotStateMergePatched(stateEventId);
        e.setQuantity(c.getQuantity());
        e.setExpirationDate(c.getExpirationDate());
        e.setActive(c.getActive());
        e.setIsPropertyQuantityRemoved(c.getIsPropertyQuantityRemoved());
        e.setIsPropertyExpirationDateRemoved(c.getIsPropertyExpirationDateRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractLotEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LotEvent map(LotCommand.DeleteLot c) {
        LotEventId stateEventId = new LotEventId(c.getLotId(), c.getVersion());
        LotEvent.LotStateDeleted e = newLotStateDeleted(stateEventId);
        ((AbstractLotEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected LotEvent.LotStateCreated newLotStateCreated(Long version, String commandId, String requesterId) {
        LotEventId stateEventId = new LotEventId(this.state.getLotId(), version);
        LotEvent.LotStateCreated e = newLotStateCreated(stateEventId);
        ((AbstractLotEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LotEvent.LotStateMergePatched newLotStateMergePatched(Long version, String commandId, String requesterId) {
        LotEventId stateEventId = new LotEventId(this.state.getLotId(), version);
        LotEvent.LotStateMergePatched e = newLotStateMergePatched(stateEventId);
        ((AbstractLotEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LotEvent.LotStateDeleted newLotStateDeleted(Long version, String commandId, String requesterId) {
        LotEventId stateEventId = new LotEventId(this.state.getLotId(), version);
        LotEvent.LotStateDeleted e = newLotStateDeleted(stateEventId);
        ((AbstractLotEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected LotEvent.LotStateCreated newLotStateCreated(LotEventId stateEventId) {
        return new AbstractLotEvent.SimpleLotStateCreated(stateEventId);
    }

    protected LotEvent.LotStateMergePatched newLotStateMergePatched(LotEventId stateEventId) {
        return new AbstractLotEvent.SimpleLotStateMergePatched(stateEventId);
    }

    protected LotEvent.LotStateDeleted newLotStateDeleted(LotEventId stateEventId)
    {
        return new AbstractLotEvent.SimpleLotStateDeleted(stateEventId);
    }

    public static class SimpleLotAggregate extends AbstractLotAggregate
    {
        public SimpleLotAggregate(LotState state) {
            super(state);
        }

    }

}

