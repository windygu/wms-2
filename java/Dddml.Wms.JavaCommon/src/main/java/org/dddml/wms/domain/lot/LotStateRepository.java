package org.dddml.wms.domain.lot;

public interface LotStateRepository {
    LotState get(String id, boolean nullAllowed);

    void save(LotState state);

}

