package org.dddml.wms.domain.inout;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.Saveable;

public abstract class AbstractInOutLineStateCollection implements EntityStateCollection<String, InOutLineState>, Saveable
{
    protected InOutLineStateDao getInOutLineStateDao()
    {
        return (InOutLineStateDao)ApplicationContext.current.get("InOutLineStateDao");
    }

    private InOutState inOutState;

    private Map<InOutLineId, InOutLineState> loadedInOutLineStates = new HashMap<InOutLineId, InOutLineState>();

    private Map<InOutLineId, InOutLineState> removedInOutLineStates = new HashMap<InOutLineId, InOutLineState>();

    protected Iterable<InOutLineState> getLoadedInOutLineStates() {
        return this.loadedInOutLineStates.values();
    }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    private Boolean stateCollectionReadOnly;

    public Boolean getStateCollectionReadOnly() {
        //if (this.inOutState instanceof AbstractInOutState) {
        //    if (((AbstractInOutState)this.inOutState).getStateReadOnly()) 
        //    { return true; }
        //}
        if (this.stateCollectionReadOnly == null) {
            return false;
        }
        return this.stateCollectionReadOnly;
    }

    public void setStateCollectionReadOnly(Boolean readOnly) {
        this.stateCollectionReadOnly = readOnly;
    }

    protected Iterable<InOutLineState> getInnerIterable() {
        if (!getForReapplying()) {
            //if (!getStateCollectionReadOnly()) {
            //    throw new UnsupportedOperationException("State collection is NOT ReadOnly.");
            //}
            return getInOutLineStateDao().findByInOutDocumentNumber(inOutState.getDocumentNumber());
        } else {
            List<InOutLineState> ss = new ArrayList<InOutLineState>();
            for (InOutLineState s : loadedInOutLineStates.values()) {
                if (!(removedInOutLineStates.containsKey(s.getInOutLineId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractInOutLineStateCollection(InOutState outerState) {
        this.inOutState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<InOutLineState> iterator() {
        return getInnerIterable().iterator();
    }

    public InOutLineState get(String lineNumber) {
        return get(lineNumber, false, false);
    }

    public InOutLineState get(String lineNumber, boolean nullAllowed) {
        return get(lineNumber, nullAllowed, false);
    }

    InOutLineState get(String lineNumber, boolean nullAllowed, boolean forCreation) {
        InOutLineId globalId = new InOutLineId(inOutState.getDocumentNumber(), lineNumber);
        if (loadedInOutLineStates.containsKey(globalId)) {
            InOutLineState state = loadedInOutLineStates.get(globalId);
            if (state instanceof AbstractInOutLineState) {
                ((AbstractInOutLineState)state).setStateReadOnly(getStateCollectionReadOnly());
            }
            return state;
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            if (getStateCollectionReadOnly()) {
                throw new UnsupportedOperationException("State collection is ReadOnly.");
            }
            InOutLineState state = new AbstractInOutLineState.SimpleInOutLineState(getForReapplying());
            state.setInOutLineId(globalId);
            loadedInOutLineStates.put(globalId, state);
            return state;
        } else {
            InOutLineState state = getInOutLineStateDao().get(globalId, nullAllowed);
            if (state != null) {
                if (state.isStateUnsaved() && getStateCollectionReadOnly()) {
                    throw new UnsupportedOperationException("State collection is ReadOnly.");
                }
                loadedInOutLineStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(InOutLineState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.removedInOutLineStates.put(state.getInOutLineId(), state);
    }

    public void add(InOutLineState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.loadedInOutLineStates.put(state.getInOutLineId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (InOutLineState s : this.getLoadedInOutLineStates()) {
            getInOutLineStateDao().save(s);
        }
        for (InOutLineState s : this.removedInOutLineStates.values()) {
            getInOutLineStateDao().delete(s);
        }
    }

    //endregion

}


