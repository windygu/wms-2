package org.dddml.wms.domain;

public interface EntityStateCollection<TId, TState> extends Iterable<TState> {

    TState get(TId entityId);

    TState get(TId entityId, boolean nullAllowed);

    void remove(TState state);

    void add(TState state);

}


