package org.dddml.wms.domain;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;

public abstract class AbstractInOutLineStates implements InOutLineStates
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

    protected Iterable<InOutLineState> getInnerIterable() {
        if (!getForReapplying()) {
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

    public AbstractInOutLineStates(InOutState outerState) {
        this.inOutState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<InOutLineState> iterator() {
        return getInnerIterable().iterator();
    }

    public InOutLineState get(SkuId skuId) {
        return get(skuId, false, false);
    }

    public InOutLineState get(SkuId skuId, boolean forCreation) {
        return get(skuId, forCreation, false);
    }

    public InOutLineState get(SkuId skuId, boolean forCreation, boolean nullAllowed) {
        InOutLineId globalId = new InOutLineId(inOutState.getDocumentNumber(), skuId);
        if (loadedInOutLineStates.containsKey(globalId)) {
            return loadedInOutLineStates.get(globalId);
        }
        if (forCreation || getForReapplying()) {
            InOutLineState state = new AbstractInOutLineState.SimpleInOutLineState(getForReapplying());
            state.setInOutLineId(globalId);
            loadedInOutLineStates.put(globalId, state);
            return state;
        } else {
            InOutLineState state = getInOutLineStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedInOutLineStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(InOutLineState state)
    {
        this.removedInOutLineStates.put(state.getInOutLineId(), state);
    }

    public void addToSave(InOutLineState state)
    {
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


