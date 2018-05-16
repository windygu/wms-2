package org.dddml.wms.specialization;

public interface IdGenerator<TId, TCommand, TState> {

    /* Generate Id form command info. */
    TId generateId(TCommand command);

    /* Get next (surrogate)Id. */
    TId getNextId();

    /* Would the object generated from command equals the state? */
    boolean equals(TCommand command, TState state);

    /* Is surrogate Id enabled. */
    boolean isSurrogateIdEnabled();

}