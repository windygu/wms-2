package org.dddml.wms.domain.movementlinemvo;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface MovementLineMvoStateRepository
{
    MovementLineMvoState get(MovementLineId id, boolean nullAllowed);

    void save(MovementLineMvoState state);

}

