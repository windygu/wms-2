package org.dddml.wms.domain.itemissuancemvo;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface ItemIssuanceMvoStateRepository
{
    ItemIssuanceMvoState get(ShipmentItemIssuanceId id, boolean nullAllowed);

    void save(ItemIssuanceMvoState state);

}

