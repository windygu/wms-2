package org.dddml.wms.domain.movement;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;

public abstract class AbstractMovementLineStates implements MovementLineStates
{
    protected MovementLineStateDao getMovementLineStateDao()
    {
        return (MovementLineStateDao)ApplicationContext.current.get("MovementLineStateDao");
    }

    private MovementState movementState;

    private Map<MovementLineId, MovementLineState> loadedMovementLineStates = new HashMap<MovementLineId, MovementLineState>();

    private Map<MovementLineId, MovementLineState> removedMovementLineStates = new HashMap<MovementLineId, MovementLineState>();

    protected Iterable<MovementLineState> getLoadedMovementLineStates() {
        return this.loadedMovementLineStates.values();
    }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    protected Iterable<MovementLineState> getInnerIterable() {
        if (!getForReapplying()) {
            return getMovementLineStateDao().findByMovementDocumentNumber(movementState.getDocumentNumber());
        } else {
            List<MovementLineState> ss = new ArrayList<MovementLineState>();
            for (MovementLineState s : loadedMovementLineStates.values()) {
                if (!(removedMovementLineStates.containsKey(s.getMovementLineId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractMovementLineStates(MovementState outerState) {
        this.movementState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<MovementLineState> iterator() {
        return getInnerIterable().iterator();
    }

    public MovementLineState get(String lineNumber) {
        return get(lineNumber, false, false);
    }

    public MovementLineState get(String lineNumber, boolean forCreation) {
        return get(lineNumber, forCreation, false);
    }

    public MovementLineState get(String lineNumber, boolean forCreation, boolean nullAllowed) {
        MovementLineId globalId = new MovementLineId(movementState.getDocumentNumber(), lineNumber);
        if (loadedMovementLineStates.containsKey(globalId)) {
            return loadedMovementLineStates.get(globalId);
        }
        if (forCreation || getForReapplying()) {
            MovementLineState state = new AbstractMovementLineState.SimpleMovementLineState(getForReapplying());
            state.setMovementLineId(globalId);
            loadedMovementLineStates.put(globalId, state);
            return state;
        } else {
            MovementLineState state = getMovementLineStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedMovementLineStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(MovementLineState state)
    {
        this.removedMovementLineStates.put(state.getMovementLineId(), state);
    }

    public void addToSave(MovementLineState state)
    {
        this.loadedMovementLineStates.put(state.getMovementLineId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (MovementLineState s : this.getLoadedMovementLineStates()) {
            getMovementLineStateDao().save(s);
        }
        for (MovementLineState s : this.removedMovementLineStates.values()) {
            getMovementLineStateDao().delete(s);
        }
    }

    //endregion

}


