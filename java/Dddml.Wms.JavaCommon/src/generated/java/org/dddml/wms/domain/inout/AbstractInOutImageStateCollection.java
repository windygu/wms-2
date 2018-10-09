package org.dddml.wms.domain.inout;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.Saveable;

public abstract class AbstractInOutImageStateCollection implements EntityStateCollection<String, InOutImageState>, Saveable
{
    protected InOutImageStateDao getInOutImageStateDao()
    {
        return (InOutImageStateDao)ApplicationContext.current.get("InOutImageStateDao");
    }

    private InOutState inOutState;

    private Map<InOutImageId, InOutImageState> loadedInOutImageStates = new HashMap<InOutImageId, InOutImageState>();

    private Map<InOutImageId, InOutImageState> removedInOutImageStates = new HashMap<InOutImageId, InOutImageState>();

    protected Iterable<InOutImageState> getLoadedInOutImageStates() {
        return this.loadedInOutImageStates.values();
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
        if (this.inOutState instanceof AbstractInOutState) {
            if (((AbstractInOutState)this.inOutState).getStateReadOnly()) 
            { return true; }
        }
        if (this.stateCollectionReadOnly == null) {
            return false;
        }
        return this.stateCollectionReadOnly;
    }

    public void setStateCollectionReadOnly(Boolean readOnly) {
        this.stateCollectionReadOnly = readOnly;
    }

    protected Iterable<InOutImageState> getInnerIterable() {
        if (!getForReapplying()) {
            //if (!getStateCollectionReadOnly()) {
            //    throw new UnsupportedOperationException("State collection is NOT ReadOnly.");
            //}
            return getInOutImageStateDao().findByInOutDocumentNumber(inOutState.getDocumentNumber());
        } else {
            List<InOutImageState> ss = new ArrayList<InOutImageState>();
            for (InOutImageState s : loadedInOutImageStates.values()) {
                if (!(removedInOutImageStates.containsKey(((InOutImageState.SqlInOutImageState)s).getInOutImageId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractInOutImageStateCollection(InOutState outerState) {
        this.inOutState = outerState;
        this.setForReapplying(((InOutState.SqlInOutState)outerState).getForReapplying());
    }

    @Override
    public Iterator<InOutImageState> iterator() {
        return getInnerIterable().iterator();
    }

    public InOutImageState get(String sequenceId) {
        return get(sequenceId, false, false);
    }

    public InOutImageState get(String sequenceId, boolean nullAllowed) {
        return get(sequenceId, nullAllowed, false);
    }

    InOutImageState get(String sequenceId, boolean nullAllowed, boolean forCreation) {
        InOutImageId globalId = new InOutImageId(inOutState.getDocumentNumber(), sequenceId);
        if (loadedInOutImageStates.containsKey(globalId)) {
            InOutImageState state = loadedInOutImageStates.get(globalId);
            if (state instanceof AbstractInOutImageState) {
                ((AbstractInOutImageState)state).setStateReadOnly(getStateCollectionReadOnly());
            }
            return state;
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            if (getStateCollectionReadOnly()) {
                throw new UnsupportedOperationException("State collection is ReadOnly.");
            }
            InOutImageState state = new AbstractInOutImageState.SimpleInOutImageState(getForReapplying());
            ((InOutImageState.SqlInOutImageState)state).setInOutImageId(globalId);
            loadedInOutImageStates.put(globalId, state);
            return state;
        } else {
            InOutImageState state = getInOutImageStateDao().get(globalId, nullAllowed);
            if (state != null) {
                if (state instanceof AbstractInOutImageState) {
                    ((AbstractInOutImageState)state).setStateReadOnly(getStateCollectionReadOnly());
                }
                if (((InOutImageState.SqlInOutImageState)state).isStateUnsaved() && getStateCollectionReadOnly()) {
                    return state;//throw new UnsupportedOperationException("State collection is ReadOnly.");
                }
                loadedInOutImageStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(InOutImageState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.removedInOutImageStates.put(((InOutImageState.SqlInOutImageState)state).getInOutImageId(), state);
    }

    public void add(InOutImageState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.loadedInOutImageStates.put(((InOutImageState.SqlInOutImageState)state).getInOutImageId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (InOutImageState s : this.getLoadedInOutImageStates()) {
            getInOutImageStateDao().save(s);
        }
        for (InOutImageState s : this.removedInOutImageStates.values()) {
            getInOutImageStateDao().delete(s);
        }
    }

    //endregion

}


