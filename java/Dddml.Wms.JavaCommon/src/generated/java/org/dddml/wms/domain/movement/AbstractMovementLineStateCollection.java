package org.dddml.wms.domain.movement;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.Saveable;

public abstract class AbstractMovementLineStateCollection implements EntityStateCollection<String, MovementLineState>, Saveable
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

    private Boolean stateCollectionReadOnly;

    public Boolean getStateCollectionReadOnly() {
        //if (this.movementState instanceof AbstractMovementState) {
        //    if (((AbstractMovementState)this.movementState).getStateReadOnly()) 
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

    protected Iterable<MovementLineState> getInnerIterable() {
        if (!getForReapplying()) {
            //if (!getStateCollectionReadOnly()) {
            //    throw new UnsupportedOperationException("State collection is NOT ReadOnly.");
            //}
            return getMovementLineStateDao().findByMovementDocumentNumber(movementState.getDocumentNumber());
        } else {
            List<MovementLineState> ss = new ArrayList<MovementLineState>();
            for (MovementLineState s : loadedMovementLineStates.values()) {
                if (!(removedMovementLineStates.containsKey(((MovementLineState.SqlMovementLineState)s).getMovementLineId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractMovementLineStateCollection(MovementState outerState) {
        this.movementState = outerState;
        this.setForReapplying(((MovementState.SqlMovementState)outerState).getForReapplying());
    }

    @Override
    public Iterator<MovementLineState> iterator() {
        return getInnerIterable().iterator();
    }

    public MovementLineState get(String lineNumber) {
        return get(lineNumber, false, false);
    }

    public MovementLineState get(String lineNumber, boolean nullAllowed) {
        return get(lineNumber, nullAllowed, false);
    }

    MovementLineState get(String lineNumber, boolean nullAllowed, boolean forCreation) {
        MovementLineId globalId = new MovementLineId(movementState.getDocumentNumber(), lineNumber);
        if (loadedMovementLineStates.containsKey(globalId)) {
            MovementLineState state = loadedMovementLineStates.get(globalId);
            if (state instanceof AbstractMovementLineState) {
                ((AbstractMovementLineState)state).setStateReadOnly(getStateCollectionReadOnly());
            }
            return state;
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            if (getStateCollectionReadOnly()) {
                throw new UnsupportedOperationException("State collection is ReadOnly.");
            }
            MovementLineState state = new AbstractMovementLineState.SimpleMovementLineState(getForReapplying());
            ((MovementLineState.SqlMovementLineState)state).setMovementLineId(globalId);
            loadedMovementLineStates.put(globalId, state);
            return state;
        } else {
            MovementLineState state = getMovementLineStateDao().get(globalId, nullAllowed);
            if (state != null) {
                if (((MovementLineState.SqlMovementLineState)state).isStateUnsaved() && getStateCollectionReadOnly()) {
                    throw new UnsupportedOperationException("State collection is ReadOnly.");
                }
                if (state instanceof AbstractMovementLineState) {
                    ((AbstractMovementLineState)state).setStateReadOnly(getStateCollectionReadOnly());
                }
                loadedMovementLineStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(MovementLineState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.removedMovementLineStates.put(((MovementLineState.SqlMovementLineState)state).getMovementLineId(), state);
    }

    public void add(MovementLineState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.loadedMovementLineStates.put(((MovementLineState.SqlMovementLineState)state).getMovementLineId(), state);
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


