package org.dddml.wms.domain.attribute;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;

public abstract class AbstractAttributeAliasStates implements AttributeAliasStates
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

    protected Iterable<AttributeAliasState> getInnerIterable() {
        if (!getForReapplying()) {
            return getAttributeAliasStateDao().findByAttributeId(attributeState.getAttributeId());
        } else {
            List<AttributeAliasState> ss = new ArrayList<AttributeAliasState>();
            for (AttributeAliasState s : loadedAttributeAliasStates.values()) {
                if (!(removedAttributeAliasStates.containsKey(s.getAttributeAliasId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractAttributeAliasStates(AttributeState outerState) {
        this.attributeState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<AttributeAliasState> iterator() {
        return getInnerIterable().iterator();
    }

    public AttributeAliasState get(String code) {
        return get(code, false, false);
    }

    public AttributeAliasState get(String code, boolean forCreation) {
        return get(code, forCreation, false);
    }

    public AttributeAliasState get(String code, boolean forCreation, boolean nullAllowed) {
        AttributeAliasId globalId = new AttributeAliasId(attributeState.getAttributeId(), code);
        if (loadedAttributeAliasStates.containsKey(globalId)) {
            return loadedAttributeAliasStates.get(globalId);
        }
        if (forCreation || getForReapplying()) {
            AttributeAliasState state = new AbstractAttributeAliasState.SimpleAttributeAliasState(getForReapplying());
            state.setAttributeAliasId(globalId);
            loadedAttributeAliasStates.put(globalId, state);
            return state;
        } else {
            AttributeAliasState state = getAttributeAliasStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedAttributeAliasStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(AttributeAliasState state)
    {
        this.removedAttributeAliasStates.put(state.getAttributeAliasId(), state);
    }

    public void addToSave(AttributeAliasState state)
    {
        this.loadedAttributeAliasStates.put(state.getAttributeAliasId(), state);
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


