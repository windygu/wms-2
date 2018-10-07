package org.dddml.wms.domain.movementconfirmation;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.Saveable;

public abstract class AbstractMovementConfirmationLineStateCollection implements EntityStateCollection<String, MovementConfirmationLineState>, Saveable
{
    protected MovementConfirmationLineStateDao getMovementConfirmationLineStateDao()
    {
        return (MovementConfirmationLineStateDao)ApplicationContext.current.get("MovementConfirmationLineStateDao");
    }

    private MovementConfirmationState movementConfirmationState;

    private Map<MovementConfirmationLineId, MovementConfirmationLineState> loadedMovementConfirmationLineStates = new HashMap<MovementConfirmationLineId, MovementConfirmationLineState>();

    private Map<MovementConfirmationLineId, MovementConfirmationLineState> removedMovementConfirmationLineStates = new HashMap<MovementConfirmationLineId, MovementConfirmationLineState>();

    protected Iterable<MovementConfirmationLineState> getLoadedMovementConfirmationLineStates() {
        return this.loadedMovementConfirmationLineStates.values();
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
        //if (this.movementConfirmationState instanceof AbstractMovementConfirmationState) {
        //    if (((AbstractMovementConfirmationState)this.movementConfirmationState).getStateReadOnly()) 
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

    protected Iterable<MovementConfirmationLineState> getInnerIterable() {
        if (!getForReapplying()) {
            //if (!getStateCollectionReadOnly()) {
            //    throw new UnsupportedOperationException("State collection is NOT ReadOnly.");
            //}
            return getMovementConfirmationLineStateDao().findByMovementConfirmationDocumentNumber(movementConfirmationState.getDocumentNumber());
        } else {
            List<MovementConfirmationLineState> ss = new ArrayList<MovementConfirmationLineState>();
            for (MovementConfirmationLineState s : loadedMovementConfirmationLineStates.values()) {
                if (!(removedMovementConfirmationLineStates.containsKey(s.getMovementConfirmationLineId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractMovementConfirmationLineStateCollection(MovementConfirmationState outerState) {
        this.movementConfirmationState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<MovementConfirmationLineState> iterator() {
        return getInnerIterable().iterator();
    }

    public MovementConfirmationLineState get(String lineNumber) {
        return get(lineNumber, false, false);
    }

    public MovementConfirmationLineState get(String lineNumber, boolean nullAllowed) {
        return get(lineNumber, nullAllowed, false);
    }

    MovementConfirmationLineState get(String lineNumber, boolean nullAllowed, boolean forCreation) {
        MovementConfirmationLineId globalId = new MovementConfirmationLineId(movementConfirmationState.getDocumentNumber(), lineNumber);
        if (loadedMovementConfirmationLineStates.containsKey(globalId)) {
            MovementConfirmationLineState state = loadedMovementConfirmationLineStates.get(globalId);
            if (state instanceof AbstractMovementConfirmationLineState) {
                ((AbstractMovementConfirmationLineState)state).setStateReadOnly(getStateCollectionReadOnly());
            }
            return state;
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            if (getStateCollectionReadOnly()) {
                throw new UnsupportedOperationException("State collection is ReadOnly.");
            }
            MovementConfirmationLineState state = new AbstractMovementConfirmationLineState.SimpleMovementConfirmationLineState(getForReapplying());
            state.setMovementConfirmationLineId(globalId);
            loadedMovementConfirmationLineStates.put(globalId, state);
            return state;
        } else {
            MovementConfirmationLineState state = getMovementConfirmationLineStateDao().get(globalId, nullAllowed);
            if (state != null) {
                if (state.isStateUnsaved() && getStateCollectionReadOnly()) {
                    throw new UnsupportedOperationException("State collection is ReadOnly.");
                }
                loadedMovementConfirmationLineStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(MovementConfirmationLineState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.removedMovementConfirmationLineStates.put(state.getMovementConfirmationLineId(), state);
    }

    public void add(MovementConfirmationLineState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.loadedMovementConfirmationLineStates.put(state.getMovementConfirmationLineId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (MovementConfirmationLineState s : this.getLoadedMovementConfirmationLineStates()) {
            getMovementConfirmationLineStateDao().save(s);
        }
        for (MovementConfirmationLineState s : this.removedMovementConfirmationLineStates.values()) {
            getMovementConfirmationLineStateDao().delete(s);
        }
    }

    //endregion

}


