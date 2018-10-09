package org.dddml.wms.domain.attributeset;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.Saveable;

public abstract class AbstractAttributeUseStateCollection implements EntityStateCollection<String, AttributeUseState>, Saveable
{
    protected AttributeUseStateDao getAttributeUseStateDao()
    {
        return (AttributeUseStateDao)ApplicationContext.current.get("AttributeUseStateDao");
    }

    private AttributeSetState attributeSetState;

    private Map<AttributeSetAttributeUseId, AttributeUseState> loadedAttributeUseStates = new HashMap<AttributeSetAttributeUseId, AttributeUseState>();

    private Map<AttributeSetAttributeUseId, AttributeUseState> removedAttributeUseStates = new HashMap<AttributeSetAttributeUseId, AttributeUseState>();

    protected Iterable<AttributeUseState> getLoadedAttributeUseStates() {
        return this.loadedAttributeUseStates.values();
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
        //if (this.attributeSetState instanceof AbstractAttributeSetState) {
        //    if (((AbstractAttributeSetState)this.attributeSetState).getStateReadOnly()) 
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

    protected Iterable<AttributeUseState> getInnerIterable() {
        if (!getForReapplying()) {
            //if (!getStateCollectionReadOnly()) {
            //    throw new UnsupportedOperationException("State collection is NOT ReadOnly.");
            //}
            return getAttributeUseStateDao().findByAttributeSetId(attributeSetState.getAttributeSetId());
        } else {
            List<AttributeUseState> ss = new ArrayList<AttributeUseState>();
            for (AttributeUseState s : loadedAttributeUseStates.values()) {
                if (!(removedAttributeUseStates.containsKey(((AttributeUseState.SqlAttributeUseState)s).getAttributeSetAttributeUseId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractAttributeUseStateCollection(AttributeSetState outerState) {
        this.attributeSetState = outerState;
        this.setForReapplying(((AttributeSetState.SqlAttributeSetState)outerState).getForReapplying());
    }

    @Override
    public Iterator<AttributeUseState> iterator() {
        return getInnerIterable().iterator();
    }

    public AttributeUseState get(String attributeId) {
        return get(attributeId, false, false);
    }

    public AttributeUseState get(String attributeId, boolean nullAllowed) {
        return get(attributeId, nullAllowed, false);
    }

    AttributeUseState get(String attributeId, boolean nullAllowed, boolean forCreation) {
        AttributeSetAttributeUseId globalId = new AttributeSetAttributeUseId(attributeSetState.getAttributeSetId(), attributeId);
        if (loadedAttributeUseStates.containsKey(globalId)) {
            AttributeUseState state = loadedAttributeUseStates.get(globalId);
            if (state instanceof AbstractAttributeUseState) {
                ((AbstractAttributeUseState)state).setStateReadOnly(getStateCollectionReadOnly());
            }
            return state;
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            if (getStateCollectionReadOnly()) {
                throw new UnsupportedOperationException("State collection is ReadOnly.");
            }
            AttributeUseState state = new AbstractAttributeUseState.SimpleAttributeUseState(getForReapplying());
            ((AttributeUseState.SqlAttributeUseState)state).setAttributeSetAttributeUseId(globalId);
            loadedAttributeUseStates.put(globalId, state);
            return state;
        } else {
            AttributeUseState state = getAttributeUseStateDao().get(globalId, nullAllowed);
            if (state != null) {
                if (((AttributeUseState.SqlAttributeUseState)state).isStateUnsaved() && getStateCollectionReadOnly()) {
                    throw new UnsupportedOperationException("State collection is ReadOnly.");
                }
                if (state instanceof AbstractAttributeUseState) {
                    ((AbstractAttributeUseState)state).setStateReadOnly(getStateCollectionReadOnly());
                }
                loadedAttributeUseStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(AttributeUseState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.removedAttributeUseStates.put(((AttributeUseState.SqlAttributeUseState)state).getAttributeSetAttributeUseId(), state);
    }

    public void add(AttributeUseState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.loadedAttributeUseStates.put(((AttributeUseState.SqlAttributeUseState)state).getAttributeSetAttributeUseId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (AttributeUseState s : this.getLoadedAttributeUseStates()) {
            getAttributeUseStateDao().save(s);
        }
        for (AttributeUseState s : this.removedAttributeUseStates.values()) {
            getAttributeUseStateDao().delete(s);
        }
    }

    //endregion

}


