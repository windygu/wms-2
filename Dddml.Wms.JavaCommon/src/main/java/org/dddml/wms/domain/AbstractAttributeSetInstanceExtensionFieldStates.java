package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;

public abstract class AbstractAttributeSetInstanceExtensionFieldStates implements AttributeSetInstanceExtensionFieldStates
{
    protected AttributeSetInstanceExtensionFieldStateDao getAttributeSetInstanceExtensionFieldStateDao()
    {
        return (AttributeSetInstanceExtensionFieldStateDao)ApplicationContext.current.get("AttributeSetInstanceExtensionFieldStateDao");
    }

    private AttributeSetInstanceExtensionFieldGroupState attributeSetInstanceExtensionFieldGroupState;

    private Map<AttributeSetInstanceExtensionFieldId, AttributeSetInstanceExtensionFieldState> loadedAttributeSetInstanceExtensionFieldStates = new HashMap<AttributeSetInstanceExtensionFieldId, AttributeSetInstanceExtensionFieldState>();

    private Map<AttributeSetInstanceExtensionFieldId, AttributeSetInstanceExtensionFieldState> removedAttributeSetInstanceExtensionFieldStates = new HashMap<AttributeSetInstanceExtensionFieldId, AttributeSetInstanceExtensionFieldState>();

    protected Iterable<AttributeSetInstanceExtensionFieldState> getLoadedAttributeSetInstanceExtensionFieldStates() {
        return this.loadedAttributeSetInstanceExtensionFieldStates.values();
    }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    protected Iterable<AttributeSetInstanceExtensionFieldState> getInnerIterable() {
        if (!getForReapplying()) {
            return getAttributeSetInstanceExtensionFieldStateDao().findByGroupId(attributeSetInstanceExtensionFieldGroupState.getId());
        } else {
            List<AttributeSetInstanceExtensionFieldState> ss = new ArrayList<AttributeSetInstanceExtensionFieldState>();
            for (AttributeSetInstanceExtensionFieldState s : loadedAttributeSetInstanceExtensionFieldStates.values()) {
                if (!(removedAttributeSetInstanceExtensionFieldStates.containsKey(s.getAttributeSetInstanceExtensionFieldId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractAttributeSetInstanceExtensionFieldStates(AttributeSetInstanceExtensionFieldGroupState outerState) {
        this.attributeSetInstanceExtensionFieldGroupState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<AttributeSetInstanceExtensionFieldState> iterator() {
        return getInnerIterable().iterator();
    }

    public AttributeSetInstanceExtensionFieldState get(String index) {
        return get(index, false, false);
    }

    public AttributeSetInstanceExtensionFieldState get(String index, boolean forCreation) {
        return get(index, forCreation, false);
    }

    public AttributeSetInstanceExtensionFieldState get(String index, boolean forCreation, boolean nullAllowed) {
        AttributeSetInstanceExtensionFieldId globalId = new AttributeSetInstanceExtensionFieldId(attributeSetInstanceExtensionFieldGroupState.getId(), index);
        if (loadedAttributeSetInstanceExtensionFieldStates.containsKey(globalId)) {
            return loadedAttributeSetInstanceExtensionFieldStates.get(globalId);
        }
        if (forCreation || getForReapplying()) {
            AttributeSetInstanceExtensionFieldState state = new AbstractAttributeSetInstanceExtensionFieldState.SimpleAttributeSetInstanceExtensionFieldState(getForReapplying());
            state.setAttributeSetInstanceExtensionFieldId(globalId);
            loadedAttributeSetInstanceExtensionFieldStates.put(globalId, state);
            return state;
        } else {
            AttributeSetInstanceExtensionFieldState state = getAttributeSetInstanceExtensionFieldStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedAttributeSetInstanceExtensionFieldStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(AttributeSetInstanceExtensionFieldState state)
    {
        this.removedAttributeSetInstanceExtensionFieldStates.put(state.getAttributeSetInstanceExtensionFieldId(), state);
    }

    public void addToSave(AttributeSetInstanceExtensionFieldState state)
    {
        this.loadedAttributeSetInstanceExtensionFieldStates.put(state.getAttributeSetInstanceExtensionFieldId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (AttributeSetInstanceExtensionFieldState s : this.getLoadedAttributeSetInstanceExtensionFieldStates()) {
            getAttributeSetInstanceExtensionFieldStateDao().save(s);
        }
        for (AttributeSetInstanceExtensionFieldState s : this.removedAttributeSetInstanceExtensionFieldStates.values()) {
            getAttributeSetInstanceExtensionFieldStateDao().delete(s);
        }
    }

    //endregion

}


