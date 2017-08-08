package org.dddml.wms.domain.inoutlinemvo;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.inout.*;
import java.math.BigDecimal;
import java.util.Date;
import org.joda.money.Money;
import org.dddml.wms.domain.*;

public interface InOutLineMvoStateRepository
{
    InOutLineMvoState get(InOutLineId id, boolean nullAllowed);

    void save(InOutLineMvoState state);

}

