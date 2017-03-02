package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;

public abstract class AbstractAttributeUseStates implements AttributeUseStates
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

    protected Iterable<AttributeUseState> getInnerIterable() {
        if (!getForReapplying()) {
            return getAttributeUseStateDao().findByAttributeSetId(attributeSetState.getAttributeSetId());
        } else {
            List<AttributeUseState> ss = new ArrayList<AttributeUseState>();
            for (AttributeUseState s : loadedAttributeUseStates.values()) {
                if (!(removedAttributeUseStates.containsKey(s.getAttributeSetAttributeUseId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractAttributeUseStates(AttributeSetState outerState) {
        this.attributeSetState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<AttributeUseState> iterator() {
        return getInnerIterable().iterator();
    }

    public AttributeUseState get(String attributeId) {
        return get(attributeId, false, false);
    }

    public AttributeUseState get(String attributeId, boolean forCreation) {
        return get(attributeId, forCreation, false);
    }

    public AttributeUseState get(String attributeId, boolean forCreation, boolean nullAllowed) {
        AttributeSetAttributeUseId globalId = new AttributeSetAttributeUseId(attributeSetState.getAttributeSetId(), attributeId);
        if (loadedAttributeUseStates.containsKey(globalId)) {
            return loadedAttributeUseStates.get(globalId);
        }
        if (forCreation || getForReapplying()) {
            AttributeUseState state = new AbstractAttributeUseState.SimpleAttributeUseState(getForReapplying());
            state.setAttributeSetAttributeUseId(globalId);
            loadedAttributeUseStates.put(globalId, state);
            return state;
        } else {
            AttributeUseState state = getAttributeUseStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedAttributeUseStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(AttributeUseState state)
    {
        this.removedAttributeUseStates.put(state.getAttributeSetAttributeUseId(), state);
    }

    public void addToSave(AttributeUseState state)
    {
        this.loadedAttributeUseStates.put(state.getAttributeSetAttributeUseId(), state);
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


