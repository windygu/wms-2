package org.dddml.wms.domain.uom;

public interface UomStateRepository {
    UomState get(String id, boolean nullAllowed);

    void save(UomState state);

}

