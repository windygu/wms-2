package org.dddml.wms.domain.product;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface GoodIdentificationStates extends Iterable<GoodIdentificationState>, Saveable
{
    GoodIdentificationState get(String goodIdentificationTypeId);

    //GoodIdentificationState get(String goodIdentificationTypeId, boolean forCreation);

    //GoodIdentificationState get(String goodIdentificationTypeId, boolean forCreation, boolean nullAllowed);

    void remove(GoodIdentificationState state);

    void add(GoodIdentificationState state);

}


