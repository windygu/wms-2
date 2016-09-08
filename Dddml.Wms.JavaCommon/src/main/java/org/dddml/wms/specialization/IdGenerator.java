package org.dddml.wms.specialization;

public interface IdGenerator<TId, TCommand> {

    TId generateId(TCommand command);

    TId getNextId();

    GetOrGenerateIdResult<TId> getOrGenerateId(TCommand command);

    public static class GetOrGenerateIdResult<TId> {
        TId id;

        public TId getId() {
            return id;
        }

        public void setId(TId id) {
            this.id = id;
        }

        boolean reused;

        public boolean isReused() {
            return reused;
        }

        public void setReused(boolean reused) {
            this.reused = reused;
        }

    }

}