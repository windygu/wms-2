package org.dddml.wms.domain.inout;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;

public interface InOutStateRepository
{
    InOutState get(String id, boolean nullAllowed);

    void save(InOutState state);

}

