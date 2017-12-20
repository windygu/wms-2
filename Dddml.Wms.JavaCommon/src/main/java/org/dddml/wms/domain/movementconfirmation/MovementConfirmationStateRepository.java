package org.dddml.wms.domain.movementconfirmation;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface MovementConfirmationStateRepository
{
    MovementConfirmationState get(String id, boolean nullAllowed);

    void save(MovementConfirmationState state);

}

