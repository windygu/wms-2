package org.dddml.wms.domain.inout;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.Saveable;

public abstract class AbstractInOutLineImageStateCollection implements EntityStateCollection<String, InOutLineImageState>, Saveable
{
    protected InOutLineImageStateDao getInOutLineImageStateDao()
    {
        return (InOutLineImageStateDao)ApplicationContext.current.get("InOutLineImageStateDao");
    }

    private InOutLineState inOutLineState;

    private Map<InOutLineImageId, InOutLineImageState> loadedInOutLineImageStates = new HashMap<InOutLineImageId, InOutLineImageState>();

    private Map<InOutLineImageId, InOutLineImageState> removedInOutLineImageStates = new HashMap<InOutLineImageId, InOutLineImageState>();

    protected Iterable<InOutLineImageState> getLoadedInOutLineImageStates() {
        return this.loadedInOutLineImageStates.values();
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
        //if (this.inOutLineState instanceof AbstractInOutLineState) {
        //    if (((AbstractInOutLineState)this.inOutLineState).getStateReadOnly()) 
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

    protected Iterable<InOutLineImageState> getInnerIterable() {
        if (!getForReapplying()) {
            //if (!getStateCollectionReadOnly()) {
            //    throw new UnsupportedOperationException("State collection is NOT ReadOnly.");
            //}
            return getInOutLineImageStateDao().findByInOutDocumentNumberAndInOutLineLineNumber(inOutLineState.getInOutLineId().getInOutDocumentNumber(), inOutLineState.getInOutLineId().getLineNumber());
        } else {
            List<InOutLineImageState> ss = new ArrayList<InOutLineImageState>();
            for (InOutLineImageState s : loadedInOutLineImageStates.values()) {
                if (!(removedInOutLineImageStates.containsKey(s.getInOutLineImageId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractInOutLineImageStateCollection(InOutLineState outerState) {
        this.inOutLineState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<InOutLineImageState> iterator() {
        return getInnerIterable().iterator();
    }

    public InOutLineImageState get(String sequenceId) {
        return get(sequenceId, false, false);
    }

    public InOutLineImageState get(String sequenceId, boolean nullAllowed) {
        return get(sequenceId, nullAllowed, false);
    }

    InOutLineImageState get(String sequenceId, boolean nullAllowed, boolean forCreation) {
        InOutLineImageId globalId = new InOutLineImageId(inOutLineState.getInOutLineId().getInOutDocumentNumber(), inOutLineState.getInOutLineId().getLineNumber(), sequenceId);
        if (loadedInOutLineImageStates.containsKey(globalId)) {
            InOutLineImageState state = loadedInOutLineImageStates.get(globalId);
            if (state instanceof AbstractInOutLineImageState) {
                ((AbstractInOutLineImageState)state).setStateReadOnly(getStateCollectionReadOnly());
            }
            return state;
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            if (getStateCollectionReadOnly()) {
                throw new UnsupportedOperationException("State collection is ReadOnly.");
            }
            InOutLineImageState state = new AbstractInOutLineImageState.SimpleInOutLineImageState(getForReapplying());
            state.setInOutLineImageId(globalId);
            loadedInOutLineImageStates.put(globalId, state);
            return state;
        } else {
            InOutLineImageState state = getInOutLineImageStateDao().get(globalId, nullAllowed);
            if (state != null) {
                if (state.isStateUnsaved() && getStateCollectionReadOnly()) {
                    throw new UnsupportedOperationException("State collection is ReadOnly.");
                }
                loadedInOutLineImageStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(InOutLineImageState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.removedInOutLineImageStates.put(state.getInOutLineImageId(), state);
    }

    public void add(InOutLineImageState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.loadedInOutLineImageStates.put(state.getInOutLineImageId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (InOutLineImageState s : this.getLoadedInOutLineImageStates()) {
            getInOutLineImageStateDao().save(s);
        }
        for (InOutLineImageState s : this.removedInOutLineImageStates.values()) {
            getInOutLineImageStateDao().delete(s);
        }
    }

    //endregion

}


