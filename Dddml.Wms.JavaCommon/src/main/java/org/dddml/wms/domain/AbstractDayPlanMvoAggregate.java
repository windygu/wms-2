package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.*;

public abstract class AbstractDayPlanMvoAggregate extends AbstractAggregate implements DayPlanMvoAggregate
{
    private DayPlanMvoState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractDayPlanMvoAggregate(DayPlanMvoState state)
    {
        this.state = state;
    }

    public DayPlanMvoState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(DayPlanMvoCommand.CreateDayPlanMvo c)
    {
        if (c.getPersonVersion() == null) { c.setPersonVersion(DayPlanMvoState.VERSION_NULL); }
        DayPlanMvoStateEvent.DayPlanMvoStateCreated e = map(c);
        apply(e);
    }

    public void mergePatch(DayPlanMvoCommand.MergePatchDayPlanMvo c)
    {
        DayPlanMvoStateEvent.DayPlanMvoStateMergePatched e = map(c);
        apply(e);
    }

    public void delete(DayPlanMvoCommand.DeleteDayPlanMvo c)
    {
        DayPlanMvoStateEvent.DayPlanMvoStateDeleted e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c)
    {
        if (this.state.getPersonVersion() == null)
        {
            if (isCommandCreate((DayPlanMvoCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (this.state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((DayPlanMvoCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected DayPlanMvoStateEvent.DayPlanMvoStateCreated map(DayPlanMvoCommand.CreateDayPlanMvo c)
    {
        DayPlanMvoStateEventId stateEventId = new DayPlanMvoStateEventId(c.getDayPlanId(), c.getPersonVersion());
        DayPlanMvoStateEvent.DayPlanMvoStateCreated e = newDayPlanMvoStateCreated(stateEventId);
        e.setDescription(c.getDescription());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setMonthPlanDescription(c.getMonthPlanDescription());
        e.setMonthPlanCreatedBy(c.getMonthPlanCreatedBy());
        e.setMonthPlanUpdatedBy(c.getMonthPlanUpdatedBy());
        e.setMonthPlanVersion(c.getMonthPlanVersion());
        e.setMonthPlanCreatedAt(c.getMonthPlanCreatedAt());
        e.setMonthPlanUpdatedAt(c.getMonthPlanUpdatedAt());
        e.setMonthPlanActive(c.getMonthPlanActive());
        e.setMonthPlanDeleted(c.getMonthPlanDeleted());
        e.setYearPlanDescription(c.getYearPlanDescription());
        e.setYearPlanCreatedBy(c.getYearPlanCreatedBy());
        e.setYearPlanUpdatedBy(c.getYearPlanUpdatedBy());
        e.setYearPlanVersion(c.getYearPlanVersion());
        e.setYearPlanCreatedAt(c.getYearPlanCreatedAt());
        e.setYearPlanUpdatedAt(c.getYearPlanUpdatedAt());
        e.setYearPlanActive(c.getYearPlanActive());
        e.setYearPlanDeleted(c.getYearPlanDeleted());
        e.setPersonBirthDate(c.getPersonBirthDate());
        e.setPersonLoves(c.getPersonLoves());
        e.setPersonEmergencyContact(c.getPersonEmergencyContact());
        e.setPersonEmail(c.getPersonEmail());
        e.setPersonCreatedBy(c.getPersonCreatedBy());
        e.setPersonUpdatedBy(c.getPersonUpdatedBy());
        e.setPersonCreatedAt(c.getPersonCreatedAt());
        e.setPersonUpdatedAt(c.getPersonUpdatedAt());
        e.setPersonActive(c.getPersonActive());
        e.setPersonDeleted(c.getPersonDeleted());
        ((AbstractDayPlanMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt(new Date());
        Long personVersion = c.getPersonVersion();
        return e;
    }

    protected DayPlanMvoStateEvent.DayPlanMvoStateMergePatched map(DayPlanMvoCommand.MergePatchDayPlanMvo c)
    {
        DayPlanMvoStateEventId stateEventId = new DayPlanMvoStateEventId(c.getDayPlanId(), c.getPersonVersion());
        DayPlanMvoStateEvent.DayPlanMvoStateMergePatched e = newDayPlanMvoStateMergePatched(stateEventId);
        e.setDescription(c.getDescription());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setMonthPlanDescription(c.getMonthPlanDescription());
        e.setMonthPlanCreatedBy(c.getMonthPlanCreatedBy());
        e.setMonthPlanUpdatedBy(c.getMonthPlanUpdatedBy());
        e.setMonthPlanVersion(c.getMonthPlanVersion());
        e.setMonthPlanCreatedAt(c.getMonthPlanCreatedAt());
        e.setMonthPlanUpdatedAt(c.getMonthPlanUpdatedAt());
        e.setMonthPlanActive(c.getMonthPlanActive());
        e.setMonthPlanDeleted(c.getMonthPlanDeleted());
        e.setYearPlanDescription(c.getYearPlanDescription());
        e.setYearPlanCreatedBy(c.getYearPlanCreatedBy());
        e.setYearPlanUpdatedBy(c.getYearPlanUpdatedBy());
        e.setYearPlanVersion(c.getYearPlanVersion());
        e.setYearPlanCreatedAt(c.getYearPlanCreatedAt());
        e.setYearPlanUpdatedAt(c.getYearPlanUpdatedAt());
        e.setYearPlanActive(c.getYearPlanActive());
        e.setYearPlanDeleted(c.getYearPlanDeleted());
        e.setPersonBirthDate(c.getPersonBirthDate());
        e.setPersonLoves(c.getPersonLoves());
        e.setPersonEmergencyContact(c.getPersonEmergencyContact());
        e.setPersonEmail(c.getPersonEmail());
        e.setPersonCreatedBy(c.getPersonCreatedBy());
        e.setPersonUpdatedBy(c.getPersonUpdatedBy());
        e.setPersonCreatedAt(c.getPersonCreatedAt());
        e.setPersonUpdatedAt(c.getPersonUpdatedAt());
        e.setPersonActive(c.getPersonActive());
        e.setPersonDeleted(c.getPersonDeleted());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyVersionRemoved(c.getIsPropertyVersionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setIsPropertyMonthPlanDescriptionRemoved(c.getIsPropertyMonthPlanDescriptionRemoved());
        e.setIsPropertyMonthPlanCreatedByRemoved(c.getIsPropertyMonthPlanCreatedByRemoved());
        e.setIsPropertyMonthPlanUpdatedByRemoved(c.getIsPropertyMonthPlanUpdatedByRemoved());
        e.setIsPropertyMonthPlanVersionRemoved(c.getIsPropertyMonthPlanVersionRemoved());
        e.setIsPropertyMonthPlanCreatedAtRemoved(c.getIsPropertyMonthPlanCreatedAtRemoved());
        e.setIsPropertyMonthPlanUpdatedAtRemoved(c.getIsPropertyMonthPlanUpdatedAtRemoved());
        e.setIsPropertyMonthPlanActiveRemoved(c.getIsPropertyMonthPlanActiveRemoved());
        e.setIsPropertyMonthPlanDeletedRemoved(c.getIsPropertyMonthPlanDeletedRemoved());
        e.setIsPropertyYearPlanDescriptionRemoved(c.getIsPropertyYearPlanDescriptionRemoved());
        e.setIsPropertyYearPlanCreatedByRemoved(c.getIsPropertyYearPlanCreatedByRemoved());
        e.setIsPropertyYearPlanUpdatedByRemoved(c.getIsPropertyYearPlanUpdatedByRemoved());
        e.setIsPropertyYearPlanVersionRemoved(c.getIsPropertyYearPlanVersionRemoved());
        e.setIsPropertyYearPlanCreatedAtRemoved(c.getIsPropertyYearPlanCreatedAtRemoved());
        e.setIsPropertyYearPlanUpdatedAtRemoved(c.getIsPropertyYearPlanUpdatedAtRemoved());
        e.setIsPropertyYearPlanActiveRemoved(c.getIsPropertyYearPlanActiveRemoved());
        e.setIsPropertyYearPlanDeletedRemoved(c.getIsPropertyYearPlanDeletedRemoved());
        e.setIsPropertyPersonBirthDateRemoved(c.getIsPropertyPersonBirthDateRemoved());
        e.setIsPropertyPersonLovesRemoved(c.getIsPropertyPersonLovesRemoved());
        e.setIsPropertyPersonEmergencyContactRemoved(c.getIsPropertyPersonEmergencyContactRemoved());
        e.setIsPropertyPersonEmailRemoved(c.getIsPropertyPersonEmailRemoved());
        e.setIsPropertyPersonCreatedByRemoved(c.getIsPropertyPersonCreatedByRemoved());
        e.setIsPropertyPersonUpdatedByRemoved(c.getIsPropertyPersonUpdatedByRemoved());
        e.setIsPropertyPersonCreatedAtRemoved(c.getIsPropertyPersonCreatedAtRemoved());
        e.setIsPropertyPersonUpdatedAtRemoved(c.getIsPropertyPersonUpdatedAtRemoved());
        e.setIsPropertyPersonActiveRemoved(c.getIsPropertyPersonActiveRemoved());
        e.setIsPropertyPersonDeletedRemoved(c.getIsPropertyPersonDeletedRemoved());
        ((AbstractDayPlanMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt(new Date());
        Long personVersion = c.getPersonVersion();
        return e;
    }

    protected DayPlanMvoStateEvent.DayPlanMvoStateDeleted map(DayPlanMvoCommand.DeleteDayPlanMvo c)
    {
        DayPlanMvoStateEventId stateEventId = new DayPlanMvoStateEventId(c.getDayPlanId(), c.getPersonVersion());
        DayPlanMvoStateEvent.DayPlanMvoStateDeleted e = newDayPlanMvoStateDeleted(stateEventId);
        ((AbstractDayPlanMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt(new Date());
        return e;
    }


    private static boolean isCommandCreate(DayPlanMvoCommand c)
    {
        return ((c instanceof DayPlanMvoCommand.CreateDayPlanMvo) 
            && c.getPersonVersion().equals(DayPlanMvoState.VERSION_NULL));
    }


    ////////////////////////

    protected DayPlanMvoStateEvent.DayPlanMvoStateCreated newDayPlanMvoStateCreated(String commandId, String requesterId) {
        DayPlanMvoStateEventId stateEventId = new DayPlanMvoStateEventId(this.state.getDayPlanId(), this.state.getPersonVersion());
        DayPlanMvoStateEvent.DayPlanMvoStateCreated e = newDayPlanMvoStateCreated(stateEventId);
        ((AbstractDayPlanMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt(new Date());
        return e;
    }

    protected DayPlanMvoStateEvent.DayPlanMvoStateMergePatched newDayPlanMvoStateMergePatched(String commandId, String requesterId) {
        DayPlanMvoStateEventId stateEventId = new DayPlanMvoStateEventId(this.state.getDayPlanId(), this.state.getPersonVersion());
        DayPlanMvoStateEvent.DayPlanMvoStateMergePatched e = newDayPlanMvoStateMergePatched(stateEventId);
        ((AbstractDayPlanMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt(new Date());
        return e;
    }

    protected DayPlanMvoStateEvent.DayPlanMvoStateDeleted newDayPlanMvoStateDeleted(String commandId, String requesterId) {
        DayPlanMvoStateEventId stateEventId = new DayPlanMvoStateEventId(this.state.getDayPlanId(), this.state.getPersonVersion());
        DayPlanMvoStateEvent.DayPlanMvoStateDeleted e = newDayPlanMvoStateDeleted(stateEventId);
        ((AbstractDayPlanMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt(new Date());
        return e;
    }

    protected DayPlanMvoStateEvent.DayPlanMvoStateCreated newDayPlanMvoStateCreated(DayPlanMvoStateEventId stateEventId) {
        return new AbstractDayPlanMvoStateEvent.SimpleDayPlanMvoStateCreated(stateEventId);
    }

    protected DayPlanMvoStateEvent.DayPlanMvoStateMergePatched newDayPlanMvoStateMergePatched(DayPlanMvoStateEventId stateEventId) {
        return new AbstractDayPlanMvoStateEvent.SimpleDayPlanMvoStateMergePatched(stateEventId);
    }

    protected DayPlanMvoStateEvent.DayPlanMvoStateDeleted newDayPlanMvoStateDeleted(DayPlanMvoStateEventId stateEventId)
    {
        return new AbstractDayPlanMvoStateEvent.SimpleDayPlanMvoStateDeleted(stateEventId);
    }


    public static class SimpleDayPlanMvoAggregate extends AbstractDayPlanMvoAggregate
    {
        public SimpleDayPlanMvoAggregate(DayPlanMvoState state) {
            super(state);
        }
    }

}

