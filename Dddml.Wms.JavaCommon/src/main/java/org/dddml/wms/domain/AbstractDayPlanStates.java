package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.ApplicationContext;

public abstract class AbstractDayPlanStates implements DayPlanStates
{
    protected DayPlanStateDao getDayPlanStateDao()
    {
        return (DayPlanStateDao)ApplicationContext.current.get("DayPlanStateDao");
    }

    private MonthPlanState monthPlanState;

    private Map<DayPlanId, DayPlanState> loadedDayPlanStates = new HashMap<DayPlanId, DayPlanState>();

    private Map<DayPlanId, DayPlanState> removedDayPlanStates = new HashMap<DayPlanId, DayPlanState>();

    protected Iterable<DayPlanState> getLoadedDayPlanStates() {
        return this.loadedDayPlanStates.values();
    }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    protected Iterable<DayPlanState> getInnerIterable() {
        if (!getForReapplying()) {
            return getDayPlanStateDao().findByPersonalNameAndYearAndMonth(monthPlanState.getMonthPlanId().getPersonalName(), monthPlanState.getMonthPlanId().getYear(), monthPlanState.getMonthPlanId().getMonth());
        } else {
            List<DayPlanState> ss = new ArrayList<DayPlanState>();
            for (DayPlanState s : loadedDayPlanStates.values()) {
                if (!(removedDayPlanStates.containsKey(s.getDayPlanId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractDayPlanStates(AbstractMonthPlanState outerState) {
        this.monthPlanState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<DayPlanState> iterator() {
        return getInnerIterable().iterator();
    }

    public DayPlanState get(Integer day)
    {
        DayPlanId globalId = new DayPlanId(monthPlanState.getMonthPlanId().getPersonalName(), monthPlanState.getMonthPlanId().getYear(), monthPlanState.getMonthPlanId().getMonth(), day);
        if (loadedDayPlanStates.containsKey(globalId)) {
            return loadedDayPlanStates.get(globalId);
        }
        if (getForReapplying()) {
            DayPlanState state = new AbstractDayPlanState.SimpleDayPlanState(true);
            state.setDayPlanId(globalId);
            loadedDayPlanStates.put(globalId, state);
            return state;
        } else {
            DayPlanState state = getDayPlanStateDao().get(globalId);
            loadedDayPlanStates.put(globalId, state);
            return state;
        }

    }

    public void remove(DayPlanState state)
    {
        this.removedDayPlanStates.put(state.getDayPlanId(), state);
    }

    public void addToSave(DayPlanState state)
    {
        this.loadedDayPlanStates.put(state.getDayPlanId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (DayPlanState s : this.getLoadedDayPlanStates()) {
            getDayPlanStateDao().save(s);
        }
        for (DayPlanState s : this.removedDayPlanStates.values()) {
            getDayPlanStateDao().delete(s);
        }
    }

    //endregion

}


