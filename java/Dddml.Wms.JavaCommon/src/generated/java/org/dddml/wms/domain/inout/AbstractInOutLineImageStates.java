package org.dddml.wms.domain.inout;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;

public abstract class AbstractInOutLineImageStates implements InOutLineImageStates
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

    protected Iterable<InOutLineImageState> getInnerIterable() {
        if (!getForReapplying()) {
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

    public AbstractInOutLineImageStates(InOutLineState outerState) {
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

    public InOutLineImageState get(String sequenceId, boolean forCreation) {
        return get(sequenceId, forCreation, false);
    }

    public InOutLineImageState get(String sequenceId, boolean forCreation, boolean nullAllowed) {
        InOutLineImageId globalId = new InOutLineImageId(inOutLineState.getInOutLineId().getInOutDocumentNumber(), inOutLineState.getInOutLineId().getLineNumber(), sequenceId);
        if (loadedInOutLineImageStates.containsKey(globalId)) {
            return loadedInOutLineImageStates.get(globalId);
        }
        if (forCreation || getForReapplying()) {
            InOutLineImageState state = new AbstractInOutLineImageState.SimpleInOutLineImageState(getForReapplying());
            state.setInOutLineImageId(globalId);
            loadedInOutLineImageStates.put(globalId, state);
            return state;
        } else {
            InOutLineImageState state = getInOutLineImageStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedInOutLineImageStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(InOutLineImageState state)
    {
        this.removedInOutLineImageStates.put(state.getInOutLineImageId(), state);
    }

    public void addToSave(InOutLineImageState state)
    {
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


