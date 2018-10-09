package org.dddml.wms.domain.attribute;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.Saveable;

public abstract class AbstractAttributeAliasStateCollection implements EntityStateCollection<String, AttributeAliasState>, Saveable
{
    protected AttributeAliasStateDao getAttributeAliasStateDao()
    {
        return (AttributeAliasStateDao)ApplicationContext.current.get("AttributeAliasStateDao");
    }

    private AttributeState attributeState;

    private Map<AttributeAliasId, AttributeAliasState> loadedAttributeAliasStates = new HashMap<AttributeAliasId, AttributeAliasState>();

    private Map<AttributeAliasId, AttributeAliasState> removedAttributeAliasStates = new HashMap<AttributeAliasId, AttributeAliasState>();

    protected Iterable<AttributeAliasState> getLoadedAttributeAliasStates() {
        return this.loadedAttributeAliasStates.values();
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

    protected Iterable<AttributeAliasState> getInnerIterable() {
        if (!getForReapplying()) {
            //if (!getStateCollectionReadOnly()) {
            //    throw new UnsupportedOperationException("State collection is NOT ReadOnly.");
            //}
            return getAttributeAliasStateDao().findByAttributeId(attributeState.getAttributeId());
        } else {
            List<AttributeAliasState> ss = new ArrayList<AttributeAliasState>();
            for (AttributeAliasState s : loadedAttributeAliasStates.values()) {
                if (!(removedAttributeAliasStates.containsKey(((AttributeAliasState.SqlAttributeAliasState)s).getAttributeAliasId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractAttributeAliasStateCollection(AttributeState outerState) {
        this.attributeState = outerState;
        this.setForReapplying(((AttributeState.SqlAttributeState)outerState).getForReapplying());
    }

    @Override
    public Iterator<AttributeAliasState> iterator() {
        return getInnerIterable().iterator();
    }

    public AttributeAliasState get(String code) {
        return get(code, false, false);
    }

    public AttributeAliasState get(String code, boolean nullAllowed) {
        return get(code, nullAllowed, false);
    }

    AttributeAliasState get(String code, boolean nullAllowed, boolean forCreation) {
        AttributeAliasId globalId = new AttributeAliasId(attributeState.getAttributeId(), code);
        if (loadedAttributeAliasStates.containsKey(globalId)) {
            AttributeAliasState state = loadedAttributeAliasStates.get(globalId);
            if (state instanceof AbstractAttributeAliasState) {
                ((AbstractAttributeAliasState)state).setStateReadOnly(getStateCollectionReadOnly());
            }
            return state;
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            if (getStateCollectionReadOnly()) {
                throw new UnsupportedOperationException("State collection is ReadOnly.");
            }
            AttributeAliasState state = new AbstractAttributeAliasState.SimpleAttributeAliasState(getForReapplying());
            ((AttributeAliasState.SqlAttributeAliasState)state).setAttributeAliasId(globalId);
            loadedAttributeAliasStates.put(globalId, state);
            return state;
        } else {
            AttributeAliasState state = getAttributeAliasStateDao().get(globalId, nullAllowed);
            if (state != null) {
                if (state instanceof AbstractAttributeAliasState) {
                    ((AbstractAttributeAliasState)state).setStateReadOnly(getStateCollectionReadOnly());
                }
                if (((AttributeAliasState.SqlAttributeAliasState)state).isStateUnsaved() && getStateCollectionReadOnly()) {
                    return state;//throw new UnsupportedOperationException("State collection is ReadOnly.");
                }
                loadedAttributeAliasStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(AttributeAliasState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.removedAttributeAliasStates.put(((AttributeAliasState.SqlAttributeAliasState)state).getAttributeAliasId(), state);
    }

    public void add(AttributeAliasState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.loadedAttributeAliasStates.put(((AttributeAliasState.SqlAttributeAliasState)state).getAttributeAliasId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (AttributeAliasState s : this.getLoadedAttributeAliasStates()) {
            getAttributeAliasStateDao().save(s);
        }
        for (AttributeAliasState s : this.removedAttributeAliasStates.values()) {
            getAttributeAliasStateDao().delete(s);
        }
    }

    //endregion

}


