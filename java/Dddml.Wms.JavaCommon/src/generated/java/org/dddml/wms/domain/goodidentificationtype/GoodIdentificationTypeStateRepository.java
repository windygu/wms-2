package org.dddml.wms.domain.goodidentificationtype;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface GoodIdentificationTypeStateRepository
{
    GoodIdentificationTypeState get(String id, boolean nullAllowed);

    void save(GoodIdentificationTypeState state);

}

