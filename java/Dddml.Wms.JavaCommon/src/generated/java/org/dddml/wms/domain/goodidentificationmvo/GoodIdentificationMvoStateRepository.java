package org.dddml.wms.domain.goodidentificationmvo;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.product.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface GoodIdentificationMvoStateRepository
{
    GoodIdentificationMvoState get(ProductGoodIdentificationId id, boolean nullAllowed);

    void save(GoodIdentificationMvoState state);

}

