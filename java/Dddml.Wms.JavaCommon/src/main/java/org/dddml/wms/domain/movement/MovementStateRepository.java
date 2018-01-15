package org.dddml.wms.domain.movement;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;

public interface MovementStateRepository
{
    MovementState get(String id, boolean nullAllowed);

    void save(MovementState state);

}

