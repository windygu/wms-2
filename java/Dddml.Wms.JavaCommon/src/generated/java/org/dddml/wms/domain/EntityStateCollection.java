package org.dddml.wms.domain;

import java.util.Collection;

public interface EntityStateCollection<TId, TState> extends Iterable<TState> {

    TState get(TId entityId);

    TState get(TId entityId, boolean nullAllowed);

    void remove(TState state);

    void add(TState state);

    Collection<TState> getLoadedStates();

    Collection<TState> getRemovedStates();

}


