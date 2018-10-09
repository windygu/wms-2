package org.dddml.wms.domain.attribute;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.Saveable;

public abstract class AbstractAttributeValueStateCollection implements EntityStateCollection<String, AttributeValueState>, Saveable
{
    protected AttributeValueStateDao getAttributeValueStateDao()
    {
        return (AttributeValueStateDao)ApplicationContext.current.get("AttributeValueStateDao");
    }

    private AttributeState attributeState;

    private Map<AttributeValueId, AttributeValueState> loadedAttributeValueStates = new HashMap<AttributeValueId, AttributeValueState>();

    private Map<AttributeValueId, AttributeValueState> removedAttributeValueStates = new HashMap<AttributeValueId, AttributeValueState>();

    protected Iterable<AttributeValueState> getLoadedAttributeValueStates() {
        return this.loadedAttributeValueStates.values();
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
        if (this.attributeState instanceof AbstractAttributeState) {
            if (((AbstractAttributeState)this.attributeState).getStateReadOnly()) 
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

    protected Iterable<AttributeValueState> getInnerIterable() {
        if (!getForReapplying()) {
            //if (!getStateCollectionReadOnly()) {
            //    throw new UnsupportedOperationException("State collection is NOT ReadOnly.");
            //}
            return getAttributeValueStateDao().findByAttributeId(attributeState.getAttributeId());
        } else {
            List<AttributeValueState> ss = new ArrayList<AttributeValueState>();
            for (AttributeValueState s : loadedAttributeValueStates.values()) {
                if (!(removedAttributeValueStates.containsKey(((AttributeValueState.SqlAttributeValueState)s).getAttributeValueId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractAttributeValueStateCollection(AttributeState outerState) {
        this.attributeState = outerState;
        this.setForReapplying(((AttributeState.SqlAttributeState)outerState).getForReapplying());
    }

    @Override
    public Iterator<AttributeValueState> iterator() {
        return getInnerIterable().iterator();
    }

    public AttributeValueState get(String value) {
        return get(value, false, false);
    }

    public AttributeValueState get(String value, boolean nullAllowed) {
        return get(value, nullAllowed, false);
    }

    AttributeValueState get(String value, boolean nullAllowed, boolean forCreation) {
        AttributeValueId globalId = new AttributeValueId(attributeState.getAttributeId(), value);
        if (loadedAttributeValueStates.containsKey(globalId)) {
            AttributeValueState state = loadedAttributeValueStates.get(globalId);
            if (state instanceof AbstractAttributeValueState) {
                ((AbstractAttributeValueState)state).setStateReadOnly(getStateCollectionReadOnly());
            }
            return state;
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            if (getStateCollectionReadOnly()) {
                throw new UnsupportedOperationException("State collection is ReadOnly.");
            }
            AttributeValueState state = new AbstractAttributeValueState.SimpleAttributeValueState(getForReapplying());
            ((AttributeValueState.SqlAttributeValueState)state).setAttributeValueId(globalId);
            loadedAttributeValueStates.put(globalId, state);
            return state;
        } else {
            AttributeValueState state = getAttributeValueStateDao().get(globalId, nullAllowed);
            if (state != null) {
                if (state instanceof AbstractAttributeValueState) {
                    ((AbstractAttributeValueState)state).setStateReadOnly(getStateCollectionReadOnly());
                }
                if (((AttributeValueState.SqlAttributeValueState)state).isStateUnsaved() && getStateCollectionReadOnly()) {
                    return state;//throw new UnsupportedOperationException("State collection is ReadOnly.");
                }
                loadedAttributeValueStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(AttributeValueState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.removedAttributeValueStates.put(((AttributeValueState.SqlAttributeValueState)state).getAttributeValueId(), state);
    }

    public void add(AttributeValueState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.loadedAttributeValueStates.put(((AttributeValueState.SqlAttributeValueState)state).getAttributeValueId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (AttributeValueState s : this.getLoadedAttributeValueStates()) {
            getAttributeValueStateDao().save(s);
        }
        for (AttributeValueState s : this.removedAttributeValueStates.values()) {
            getAttributeValueStateDao().delete(s);
        }
    }

    //endregion

}


