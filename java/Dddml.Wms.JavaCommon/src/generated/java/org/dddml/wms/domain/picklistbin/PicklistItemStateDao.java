package org.dddml.wms.domain.picklistbin;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface PicklistItemStateDao
{
    PicklistItemState get(PicklistBinPicklistItemId id, boolean nullAllowed);

    void save(PicklistItemState state);

    Iterable<PicklistItemState> findByPicklistBinId(String picklistBinId);

    void delete(PicklistItemState state);
}


