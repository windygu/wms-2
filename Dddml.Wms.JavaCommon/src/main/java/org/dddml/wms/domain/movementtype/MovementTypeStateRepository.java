package org.dddml.wms.domain.movementtype;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface MovementTypeStateRepository
{
    MovementTypeState get(String id, boolean nullAllowed);

    void save(MovementTypeState state);

}

