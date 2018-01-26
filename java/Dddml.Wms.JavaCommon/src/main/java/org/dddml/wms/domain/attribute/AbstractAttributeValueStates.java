package org.dddml.wms.domain.attribute;

import org.dddml.wms.specialization.ApplicationContext;

import java.util.*;

public abstract class AbstractAttributeValueStates implements AttributeValueStates {
    private AttributeState attributeState;
    private Map<AttributeValueId, AttributeValueState> loadedAttributeValueStates = new HashMap<AttributeValueId, AttributeValueState>();
    private Map<AttributeValueId, AttributeValueState> removedAttributeValueStates = new HashMap<AttributeValueId, AttributeValueState>();
    private boolean forReapplying;

    public AbstractAttributeValueStates(AttributeState outerState) {
        this.attributeState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    protected AttributeValueStateDao getAttributeValueStateDao() {
        return (AttributeValueStateDao) ApplicationContext.current.get("AttributeValueStateDao");
    }

    protected Iterable<AttributeValueState> getLoadedAttributeValueStates() {
        return this.loadedAttributeValueStates.values();
    }

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    protected Iterable<AttributeValueState> getInnerIterable() {
        if (!getForReapplying()) {
            return getAttributeValueStateDao().findByAttributeId(attributeState.getAttributeId());
        } else {
            List<AttributeValueState> ss = new ArrayList<AttributeValueState>();
            for (AttributeValueState s : loadedAttributeValueStates.values()) {
                if (!(removedAttributeValueStates.containsKey(s.getAttributeValueId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    @Override
    public Iterator<AttributeValueState> iterator() {
        return getInnerIterable().iterator();
    }

    public AttributeValueState get(String value) {
        return get(value, false, false);
    }

    public AttributeValueState get(String value, boolean forCreation) {
        return get(value, forCreation, false);
    }

    public AttributeValueState get(String value, boolean forCreation, boolean nullAllowed) {
        AttributeValueId globalId = new AttributeValueId(attributeState.getAttributeId(), value);
        if (loadedAttributeValueStates.containsKey(globalId)) {
            return loadedAttributeValueStates.get(globalId);
        }
        if (forCreation || getForReapplying()) {
            AttributeValueState state = new AbstractAttributeValueState.SimpleAttributeValueState(getForReapplying());
            state.setAttributeValueId(globalId);
            loadedAttributeValueStates.put(globalId, state);
            return state;
        } else {
            AttributeValueState state = getAttributeValueStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedAttributeValueStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(AttributeValueState state) {
        this.removedAttributeValueStates.put(state.getAttributeValueId(), state);
    }

    public void addToSave(AttributeValueState state) {
        this.loadedAttributeValueStates.put(state.getAttributeValueId(), state);
    }

    //region Saveable Implements

    public void save() {
        for (AttributeValueState s : this.getLoadedAttributeValueStates()) {
            getAttributeValueStateDao().save(s);
        }
        for (AttributeValueState s : this.removedAttributeValueStates.values()) {
            getAttributeValueStateDao().delete(s);
        }
    }

    //endregion

}


