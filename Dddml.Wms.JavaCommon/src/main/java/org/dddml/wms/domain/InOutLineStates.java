package org.dddml.wms.domain;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.specialization.Saveable;

public interface InOutLineStates extends Iterable<InOutLineState>, Saveable
{
    InOutLineState get(SkuId skuId);

    InOutLineState get(SkuId skuId, boolean forCreation);

    InOutLineState get(SkuId skuId, boolean forCreation, boolean nullAllowed);

    void remove(InOutLineState state);

    void addToSave(InOutLineState state);

}


