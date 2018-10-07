package org.dddml.wms.domain.product;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.Saveable;

public abstract class AbstractGoodIdentificationStateCollection implements EntityStateCollection<String, GoodIdentificationState>, Saveable
{
    protected GoodIdentificationStateDao getGoodIdentificationStateDao()
    {
        return (GoodIdentificationStateDao)ApplicationContext.current.get("GoodIdentificationStateDao");
    }

    private ProductState productState;

    private Map<ProductGoodIdentificationId, GoodIdentificationState> loadedGoodIdentificationStates = new HashMap<ProductGoodIdentificationId, GoodIdentificationState>();

    private Map<ProductGoodIdentificationId, GoodIdentificationState> removedGoodIdentificationStates = new HashMap<ProductGoodIdentificationId, GoodIdentificationState>();

    protected Iterable<GoodIdentificationState> getLoadedGoodIdentificationStates() {
        return this.loadedGoodIdentificationStates.values();
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
        //if (this.productState instanceof AbstractProductState) {
        //    if (((AbstractProductState)this.productState).getStateReadOnly()) 
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

    protected Iterable<GoodIdentificationState> getInnerIterable() {
        if (!getForReapplying()) {
            //if (!getStateCollectionReadOnly()) {
            //    throw new UnsupportedOperationException("State collection is NOT ReadOnly.");
            //}
            return getGoodIdentificationStateDao().findByProductId(productState.getProductId());
        } else {
            List<GoodIdentificationState> ss = new ArrayList<GoodIdentificationState>();
            for (GoodIdentificationState s : loadedGoodIdentificationStates.values()) {
                if (!(removedGoodIdentificationStates.containsKey(s.getProductGoodIdentificationId()) && s.getDeleted())) {
                    ss.add(s);
                }
            }
            return ss;
        }
    }

    public AbstractGoodIdentificationStateCollection(ProductState outerState) {
        this.productState = outerState;
        this.setForReapplying(outerState.getForReapplying());
    }

    @Override
    public Iterator<GoodIdentificationState> iterator() {
        return getInnerIterable().iterator();
    }

    public GoodIdentificationState get(String goodIdentificationTypeId) {
        return get(goodIdentificationTypeId, false, false);
    }

    public GoodIdentificationState get(String goodIdentificationTypeId, boolean nullAllowed) {
        return get(goodIdentificationTypeId, nullAllowed, false);
    }

    GoodIdentificationState get(String goodIdentificationTypeId, boolean nullAllowed, boolean forCreation) {
        ProductGoodIdentificationId globalId = new ProductGoodIdentificationId(productState.getProductId(), goodIdentificationTypeId);
        if (loadedGoodIdentificationStates.containsKey(globalId)) {
            GoodIdentificationState state = loadedGoodIdentificationStates.get(globalId);
            if (state instanceof AbstractGoodIdentificationState) {
                ((AbstractGoodIdentificationState)state).setStateReadOnly(getStateCollectionReadOnly());
            }
            return state;
        }
        boolean justNewIfNotLoaded = forCreation || getForReapplying();
        if (justNewIfNotLoaded) {
            if (getStateCollectionReadOnly()) {
                throw new UnsupportedOperationException("State collection is ReadOnly.");
            }
            GoodIdentificationState state = new AbstractGoodIdentificationState.SimpleGoodIdentificationState(getForReapplying());
            state.setProductGoodIdentificationId(globalId);
            loadedGoodIdentificationStates.put(globalId, state);
            return state;
        } else {
            GoodIdentificationState state = getGoodIdentificationStateDao().get(globalId, nullAllowed);
            if (state != null) {
                if (state.isStateUnsaved() && getStateCollectionReadOnly()) {
                    throw new UnsupportedOperationException("State collection is ReadOnly.");
                }
                loadedGoodIdentificationStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(GoodIdentificationState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.removedGoodIdentificationStates.put(state.getProductGoodIdentificationId(), state);
    }

    public void add(GoodIdentificationState state) {
        if (getStateCollectionReadOnly()) {
            throw new UnsupportedOperationException("State collection is ReadOnly.");
        }
        this.loadedGoodIdentificationStates.put(state.getProductGoodIdentificationId(), state);
    }

    //region Saveable Implements

    public void save ()
    {
        for (GoodIdentificationState s : this.getLoadedGoodIdentificationStates()) {
            getGoodIdentificationStateDao().save(s);
        }
        for (GoodIdentificationState s : this.removedGoodIdentificationStates.values()) {
            getGoodIdentificationStateDao().delete(s);
        }
    }

    //endregion

}


