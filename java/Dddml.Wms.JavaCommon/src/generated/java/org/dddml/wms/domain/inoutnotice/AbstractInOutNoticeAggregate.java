package org.dddml.wms.domain.inoutnotice;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractInOutNoticeAggregate extends AbstractAggregate implements InOutNoticeAggregate
{
    private InOutNoticeState.MutableInOutNoticeState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractInOutNoticeAggregate(InOutNoticeState state)
    {
        this.state = (InOutNoticeState.MutableInOutNoticeState)state;
    }

    public InOutNoticeState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(InOutNoticeCommand.CreateInOutNotice c)
    {
        if (c.getVersion() == null) { c.setVersion(InOutNoticeState.VERSION_NULL); }
        InOutNoticeEvent e = map(c);
        apply(e);
    }

    public void mergePatch(InOutNoticeCommand.MergePatchInOutNotice c)
    {
        InOutNoticeEvent e = map(c);
        apply(e);
    }

    public void delete(InOutNoticeCommand.DeleteInOutNotice c)
    {
        InOutNoticeEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        InOutNoticeCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected InOutNoticeEvent map(InOutNoticeCommand.CreateInOutNotice c) {
        InOutNoticeEventId stateEventId = new InOutNoticeEventId(c.getInOutNoticeId(), c.getVersion());
        InOutNoticeEvent.InOutNoticeStateCreated e = newInOutNoticeStateCreated(stateEventId);
        e.setWarehouseId(c.getWarehouseId());
        e.setInOutNoticeType(c.getInOutNoticeType());
        e.setTelecomContactMechId(c.getTelecomContactMechId());
        e.setTrackingNumber(c.getTrackingNumber());
        e.setContactPartyId(c.getContactPartyId());
        e.setVehiclePlateNumber(c.getVehiclePlateNumber());
        e.setShippingInstructions(c.getShippingInstructions());
        e.setEstimatedShipDate(c.getEstimatedShipDate());
        e.setEstimatedDeliveryDate(c.getEstimatedDeliveryDate());
        e.setIsScheduleNeeded(c.getIsScheduleNeeded());
        newInOutNoticeInOutNoticeActionCommandAndExecute(c, state, e);
        e.setActive(c.getActive());
        ((AbstractInOutNoticeEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InOutNoticeEvent map(InOutNoticeCommand.MergePatchInOutNotice c) {
        InOutNoticeEventId stateEventId = new InOutNoticeEventId(c.getInOutNoticeId(), c.getVersion());
        InOutNoticeEvent.InOutNoticeStateMergePatched e = newInOutNoticeStateMergePatched(stateEventId);
        e.setWarehouseId(c.getWarehouseId());
        e.setInOutNoticeType(c.getInOutNoticeType());
        e.setTelecomContactMechId(c.getTelecomContactMechId());
        e.setTrackingNumber(c.getTrackingNumber());
        e.setContactPartyId(c.getContactPartyId());
        e.setVehiclePlateNumber(c.getVehiclePlateNumber());
        e.setShippingInstructions(c.getShippingInstructions());
        e.setEstimatedShipDate(c.getEstimatedShipDate());
        e.setEstimatedDeliveryDate(c.getEstimatedDeliveryDate());
        e.setIsScheduleNeeded(c.getIsScheduleNeeded());
        if (c.getInOutNoticeAction() != null)
        newInOutNoticeInOutNoticeActionCommandAndExecute(c, state, e);
        e.setActive(c.getActive());
        e.setIsPropertyWarehouseIdRemoved(c.getIsPropertyWarehouseIdRemoved());
        e.setIsPropertyInOutNoticeTypeRemoved(c.getIsPropertyInOutNoticeTypeRemoved());
        e.setIsPropertyTelecomContactMechIdRemoved(c.getIsPropertyTelecomContactMechIdRemoved());
        e.setIsPropertyTrackingNumberRemoved(c.getIsPropertyTrackingNumberRemoved());
        e.setIsPropertyContactPartyIdRemoved(c.getIsPropertyContactPartyIdRemoved());
        e.setIsPropertyVehiclePlateNumberRemoved(c.getIsPropertyVehiclePlateNumberRemoved());
        e.setIsPropertyShippingInstructionsRemoved(c.getIsPropertyShippingInstructionsRemoved());
        e.setIsPropertyEstimatedShipDateRemoved(c.getIsPropertyEstimatedShipDateRemoved());
        e.setIsPropertyEstimatedDeliveryDateRemoved(c.getIsPropertyEstimatedDeliveryDateRemoved());
        e.setIsPropertyIsScheduleNeededRemoved(c.getIsPropertyIsScheduleNeededRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractInOutNoticeEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InOutNoticeEvent map(InOutNoticeCommand.DeleteInOutNotice c) {
        InOutNoticeEventId stateEventId = new InOutNoticeEventId(c.getInOutNoticeId(), c.getVersion());
        InOutNoticeEvent.InOutNoticeStateDeleted e = newInOutNoticeStateDeleted(stateEventId);
        ((AbstractInOutNoticeEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected InOutNoticeEvent.InOutNoticeStateCreated newInOutNoticeStateCreated(Long version, String commandId, String requesterId) {
        InOutNoticeEventId stateEventId = new InOutNoticeEventId(this.state.getInOutNoticeId(), version);
        InOutNoticeEvent.InOutNoticeStateCreated e = newInOutNoticeStateCreated(stateEventId);
        ((AbstractInOutNoticeEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InOutNoticeEvent.InOutNoticeStateMergePatched newInOutNoticeStateMergePatched(Long version, String commandId, String requesterId) {
        InOutNoticeEventId stateEventId = new InOutNoticeEventId(this.state.getInOutNoticeId(), version);
        InOutNoticeEvent.InOutNoticeStateMergePatched e = newInOutNoticeStateMergePatched(stateEventId);
        ((AbstractInOutNoticeEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InOutNoticeEvent.InOutNoticeStateDeleted newInOutNoticeStateDeleted(Long version, String commandId, String requesterId) {
        InOutNoticeEventId stateEventId = new InOutNoticeEventId(this.state.getInOutNoticeId(), version);
        InOutNoticeEvent.InOutNoticeStateDeleted e = newInOutNoticeStateDeleted(stateEventId);
        ((AbstractInOutNoticeEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected InOutNoticeEvent.InOutNoticeStateCreated newInOutNoticeStateCreated(InOutNoticeEventId stateEventId) {
        return new AbstractInOutNoticeEvent.SimpleInOutNoticeStateCreated(stateEventId);
    }

    protected InOutNoticeEvent.InOutNoticeStateMergePatched newInOutNoticeStateMergePatched(InOutNoticeEventId stateEventId) {
        return new AbstractInOutNoticeEvent.SimpleInOutNoticeStateMergePatched(stateEventId);
    }

    protected InOutNoticeEvent.InOutNoticeStateDeleted newInOutNoticeStateDeleted(InOutNoticeEventId stateEventId)
    {
        return new AbstractInOutNoticeEvent.SimpleInOutNoticeStateDeleted(stateEventId);
    }

    protected void newInOutNoticeInOutNoticeActionCommandAndExecute(InOutNoticeCommand.MergePatchInOutNotice c, InOutNoticeState s, InOutNoticeEvent.InOutNoticeStateMergePatched e)
    {
        PropertyCommandHandler<String, String> pCommandHandler = this.getInOutNoticeInOutNoticeActionCommandHandler();
        String pCmdContent = c.getInOutNoticeAction();
        PropertyCommand<String, String> pCmd = new AbstractPropertyCommand.SimplePropertyCommand<String, String>();
        pCmd.setContent(pCmdContent);
        pCmd.setStateGetter(() -> s.getStatusId());
        pCmd.setStateSetter(p -> e.setStatusId(p));
        pCmd.setOuterCommandType(CommandType.MERGE_PATCH);
        pCmd.setContext(getState());
        pCommandHandler.execute(pCmd);
    }

    protected void newInOutNoticeInOutNoticeActionCommandAndExecute(InOutNoticeCommand.CreateInOutNotice c, InOutNoticeState s, InOutNoticeEvent.InOutNoticeStateCreated e)
    {
        PropertyCommandHandler<String, String> pCommandHandler = this.getInOutNoticeInOutNoticeActionCommandHandler();
        String pCmdContent = null;
        PropertyCommand<String, String> pCmd = new AbstractPropertyCommand.SimplePropertyCommand<String, String>();
        pCmd.setContent(pCmdContent);
        pCmd.setStateGetter(() -> s.getStatusId());
        pCmd.setStateSetter(p -> e.setStatusId(p));
        pCmd.setOuterCommandType(CommandType.CREATE);
        pCmd.setContext(getState());
        pCommandHandler.execute(pCmd);
    }

    public class SimpleInOutNoticeInOutNoticeActionCommandHandler implements PropertyCommandHandler<String, String> {

        public void execute(PropertyCommand<String, String> command) {
            String trigger = command.getContent();
            if (Objects.equals(null, command.getStateGetter().get()) && Objects.equals(null, trigger)) {
                command.getStateSetter().accept("NOTICE_CREATED");
                return;
            }
            if (Objects.equals("NOTICE_CREATED", command.getStateGetter().get()) && Objects.equals("Approve", trigger)) {
                command.getStateSetter().accept("NOTICE_APPROVED");
                return;
            }
            if (Objects.equals("NOTICE_APPROVED", command.getStateGetter().get()) && Objects.equals("Complete", trigger)) {
                command.getStateSetter().accept("NOTICE_COMPLETED");
                return;
            }
            if (Objects.equals("NOTICE_CREATED", command.getStateGetter().get()) && Objects.equals("Reject", trigger)) {
                command.getStateSetter().accept("NOTICE_REJECTED");
                return;
            }
            if (Objects.equals("NOTICE_CREATED", command.getStateGetter().get()) && Objects.equals("Cancel", trigger)) {
                command.getStateSetter().accept("NOTICE_CANCELLED");
                return;
            }
            throw new IllegalArgumentException(String.format("State: %1$s, command: %2$s", command.getStateGetter().get(), trigger));
        }
    }

    private PropertyCommandHandler<String, String> inOutNoticeInOutNoticeActionCommandHandler = new SimpleInOutNoticeInOutNoticeActionCommandHandler();

    public void setInOutNoticeInOutNoticeActionCommandHandler(PropertyCommandHandler<String, String> h) {
        this.inOutNoticeInOutNoticeActionCommandHandler = h;
    }

    protected PropertyCommandHandler<String, String> getInOutNoticeInOutNoticeActionCommandHandler() {
        Object h = ApplicationContext.current.get("InOutNoticeInOutNoticeActionCommandHandler");
        if (h instanceof PropertyCommandHandler) {
            return (PropertyCommandHandler<String, String>) h;
        }
        return this.inOutNoticeInOutNoticeActionCommandHandler;
    }

    public static class SimpleInOutNoticeAggregate extends AbstractInOutNoticeAggregate
    {
        public SimpleInOutNoticeAggregate(InOutNoticeState state) {
            super(state);
        }

        @Override
        public void inOutNoticeAction(String value, Long version, String commandId, String requesterId) {
            InOutNoticeEvent.InOutNoticeStateMergePatched e = newInOutNoticeStateMergePatched(version, commandId, requesterId);
            inOutNoticeAction(e, value);
            apply(e);
        }

        protected void inOutNoticeAction(InOutNoticeEvent.InOutNoticeStateMergePatched e, String value) {
            doInOutNoticeAction(value, s -> e.setStatusId(s));
        }

        protected void doInOutNoticeAction(String value, java.util.function.Consumer<String> setStatusId) {
            PropertyCommandHandler<String, String> pCommandHandler = this.getInOutNoticeInOutNoticeActionCommandHandler();
            PropertyCommand<String, String> pCmd = new AbstractPropertyCommand.SimplePropertyCommand<>();
            pCmd.setContent(value);
            pCmd.setStateGetter(() -> this.getState().getStatusId());
            pCmd.setStateSetter(setStatusId);
            pCmd.setOuterCommandType("InOutNoticeAction");
            pCmd.setContext(getState());
            pCommandHandler.execute(pCmd);
        }

    }

}

