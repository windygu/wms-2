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

    protected Iterable<MovementConfirmationLineState> getInnerIterable() {
        if (!getForReapplying()) {
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

    MovementConfirmationLineState get(String lineNumber, boolean forCreation) {
        return get(lineNumber, forCreation, false);
    }

    MovementConfirmationLineState get(String lineNumber, boolean forCreation, boolean nullAllowed) {
        MovementConfirmationLineId globalId = new MovementConfirmationLineId(movementConfirmationState.getDocumentNumber(), lineNumber);
        if (loadedMovementConfirmationLineStates.containsKey(globalId)) {
            return loadedMovementConfirmationLineStates.get(globalId);
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            MovementConfirmationLineState state = new AbstractMovementConfirmationLineState.SimpleMovementConfirmationLineState(getForReapplying());
            state.setMovementConfirmationLineId(globalId);
            loadedMovementConfirmationLineStates.put(globalId, state);
            return state;
        } else {
            MovementConfirmationLineState state = getMovementConfirmationLineStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedMovementConfirmationLineStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(MovementConfirmationLineState state)
    {
        this.removedMovementConfirmationLineStates.put(state.getMovementConfirmationLineId(), state);
    }

    public void add(MovementConfirmationLineState state)
    {
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


