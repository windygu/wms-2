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

    protected Iterable<InOutImageState> getInnerIterable() {
        if (!getForReapplying()) {
            return getInOutImageStateDao().findByInOutDocumentNumber(inOutState.getDocumentNumber());
        } else {
            List<InOutImageState> ss = new ArrayList<InOutImageState>();
            for (InOutImageState s : loadedInOutImageStates.values()) {
                if (!(removedInOutImageStates.containsKey(s.getInOutImageId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractInOutImageStateCollection(InOutState outerState) {
        this.inOutState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<InOutImageState> iterator() {
        return getInnerIterable().iterator();
    }

    public InOutImageState get(String sequenceId) {
        return get(sequenceId, false, false);
    }

    InOutImageState get(String sequenceId, boolean forCreation) {
        return get(sequenceId, forCreation, false);
    }

    InOutImageState get(String sequenceId, boolean forCreation, boolean nullAllowed) {
        InOutImageId globalId = new InOutImageId(inOutState.getDocumentNumber(), sequenceId);
        if (loadedInOutImageStates.containsKey(globalId)) {
            return loadedInOutImageStates.get(globalId);
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            InOutImageState state = new AbstractInOutImageState.SimpleInOutImageState(getForReapplying());
            state.setInOutImageId(globalId);
            loadedInOutImageStates.put(globalId, state);
            return state;
        } else {
            InOutImageState state = getInOutImageStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedInOutImageStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(InOutImageState state)
    {
        this.removedInOutImageStates.put(state.getInOutImageId(), state);
    }

    public void add(InOutImageState state)
    {
        this.loadedInOutImageStates.put(state.getInOutImageId(), state);
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


