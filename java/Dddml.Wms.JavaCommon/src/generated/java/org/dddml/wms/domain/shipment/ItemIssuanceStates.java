package org.dddml.wms.domain.shipment;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface ItemIssuanceStates extends Iterable<ItemIssuanceState>, Saveable
{
    ItemIssuanceState get(String itemIssuanceSeqId);

    ItemIssuanceState get(String itemIssuanceSeqId, boolean forCreation);

    ItemIssuanceState get(String itemIssuanceSeqId, boolean forCreation, boolean nullAllowed);

    void remove(ItemIssuanceState state);

    void addToSave(ItemIssuanceState state);

}


