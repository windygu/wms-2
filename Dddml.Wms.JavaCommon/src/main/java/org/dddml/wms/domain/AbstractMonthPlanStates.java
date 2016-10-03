package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.ApplicationContext;

public abstract class AbstractMonthPlanStates implements MonthPlanStates
{
    protected MonthPlanStateDao getMonthPlanStateDao()
    {
        return (MonthPlanStateDao)ApplicationContext.current.get("MonthPlanStateDao");
    }

    private YearPlanState yearPlanState;

    private Map<MonthPlanId, MonthPlanState> loadedMonthPlanStates = new HashMap<MonthPlanId, MonthPlanState>();

    private Map<MonthPlanId, MonthPlanState> removedMonthPlanStates = new HashMap<MonthPlanId, MonthPlanState>();

    protected Iterable<MonthPlanState> getLoadedMonthPlanStates() {
        return this.loadedMonthPlanStates.values();
    }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    protected Iterable<MonthPlanState> getInnerIterable() {
        if (!getForReapplying()) {
            return getMonthPlanStateDao().findByPersonalNameAndYear(yearPlanState.getYearPlanId().getPersonalName(), yearPlanState.getYearPlanId().getYear());
        } else {
            List<MonthPlanState> ss = new ArrayList<MonthPlanState>();
            for (MonthPlanState s : loadedMonthPlanStates.values()) {
                if (!(removedMonthPlanStates.containsKey(s.getMonthPlanId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractMonthPlanStates(AbstractYearPlanState outerState) {
        this.yearPlanState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<MonthPlanState> iterator() {
        return getInnerIterable().iterator();
    }

    public MonthPlanState get(Integer month)
    {
        MonthPlanId globalId = new MonthPlanId(yearPlanState.getYearPlanId().getPersonalName(), yearPlanState.getYearPlanId().getYear(), month);
        if (loadedMonthPlanStates.containsKey(globalId)) {
            return loadedMonthPlanStates.get(globalId);
        }
        if (getForReapplying()) {
            MonthPlanState state = new AbstractMonthPlanState.SimpleMonthPlanState(true);
            state.setMonthPlanId(globalId);
            loadedMonthPlanStates.put(globalId, state);
            return state;
        } else {
            MonthPlanState state = getMonthPlanStateDao().get(globalId);
            loadedMonthPlanStates.put(globalId, state);
            return state;
        }

    }

    public void remove(MonthPlanState state)
    {
        this.removedMonthPlanStates.put(state.getMonthPlanId(), state);
    }

    public void addToSave(MonthPlanState state)
    {
        this.loadedMonthPlanStates.put(state.getMonthPlanId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (MonthPlanState s : this.getLoadedMonthPlanStates()) {
            getMonthPlanStateDao().save(s);
        }
        for (MonthPlanState s : this.removedMonthPlanStates.values()) {
            getMonthPlanStateDao().delete(s);
        }
    }

    //endregion

}


