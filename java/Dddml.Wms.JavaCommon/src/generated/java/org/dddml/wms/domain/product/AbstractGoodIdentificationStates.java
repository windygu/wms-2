package org.dddml.wms.domain.product;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.ApplicationContext;

public abstract class AbstractGoodIdentificationStates implements GoodIdentificationStates
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

    protected Iterable<GoodIdentificationState> getInnerIterable() {
        if (!getForReapplying()) {
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

    public AbstractGoodIdentificationStates(ProductState outerState) {
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

    public GoodIdentificationState get(String goodIdentificationTypeId, boolean forCreation) {
        return get(goodIdentificationTypeId, forCreation, false);
    }

    public GoodIdentificationState get(String goodIdentificationTypeId, boolean forCreation, boolean nullAllowed) {
        ProductGoodIdentificationId globalId = new ProductGoodIdentificationId(productState.getProductId(), goodIdentificationTypeId);
        if (loadedGoodIdentificationStates.containsKey(globalId)) {
            return loadedGoodIdentificationStates.get(globalId);
        }
        if (forCreation || getForReapplying()) {
            GoodIdentificationState state = new AbstractGoodIdentificationState.SimpleGoodIdentificationState(getForReapplying());
            state.setProductGoodIdentificationId(globalId);
            loadedGoodIdentificationStates.put(globalId, state);
            return state;
        } else {
            GoodIdentificationState state = getGoodIdentificationStateDao().get(globalId, nullAllowed);
            if (state != null) {
                loadedGoodIdentificationStates.put(globalId, state);
            }
            return state;
        }

    }

    public void remove(GoodIdentificationState state)
    {
        this.removedGoodIdentificationStates.put(state.getProductGoodIdentificationId(), state);
    }

    public void addToSave(GoodIdentificationState state)
    {
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


