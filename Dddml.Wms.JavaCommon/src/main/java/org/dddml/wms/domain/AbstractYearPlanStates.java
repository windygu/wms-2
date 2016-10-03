package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.ApplicationContext;

public abstract class AbstractYearPlanStates implements YearPlanStates
{
    protected YearPlanStateDao getYearPlanStateDao()
    {
        return (YearPlanStateDao)ApplicationContext.current.get("YearPlanStateDao");
    }

    private PersonState personState;

    private Map<YearPlanId, YearPlanState> loadedYearPlanStates = new HashMap<YearPlanId, YearPlanState>();

    private Map<YearPlanId, YearPlanState> removedYearPlanStates = new HashMap<YearPlanId, YearPlanState>();

    protected Iterable<YearPlanState> getLoadedYearPlanStates() {
        return this.loadedYearPlanStates.values();
    }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    protected Iterable<YearPlanState> getInnerIterable() {
        if (!getForReapplying()) {
            return getYearPlanStateDao().findByPersonalName(personState.getPersonalName());
        } else {
            List<YearPlanState> ss = new ArrayList<YearPlanState>();
            for (YearPlanState s : loadedYearPlanStates.values()) {
                if (!(removedYearPlanStates.containsKey(s.getYearPlanId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractYearPlanStates(AbstractPersonState outerState) {
        this.personState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<YearPlanState> iterator() {
        return getInnerIterable().iterator();
    }

    public YearPlanState get(Integer year)
    {
        YearPlanId globalId = new YearPlanId(personState.getPersonalName(), year);
        if (loadedYearPlanStates.containsKey(globalId)) {
            return loadedYearPlanStates.get(globalId);
        }
        if (getForReapplying()) {
            YearPlanState state = new AbstractYearPlanState.SimpleYearPlanState(true);
            state.setYearPlanId(globalId);
            loadedYearPlanStates.put(globalId, state);
            return state;
        } else {
            YearPlanState state = getYearPlanStateDao().get(globalId);
            loadedYearPlanStates.put(globalId, state);
            return state;
        }

    }

    public void remove(YearPlanState state)
    {
        this.removedYearPlanStates.put(state.getYearPlanId(), state);
    }

    public void addToSave(YearPlanState state)
    {
        this.loadedYearPlanStates.put(state.getYearPlanId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (YearPlanState s : this.getLoadedYearPlanStates()) {
            getYearPlanStateDao().save(s);
        }
        for (YearPlanState s : this.removedYearPlanStates.values()) {
            getYearPlanStateDao().delete(s);
        }
    }

    //endregion

}


