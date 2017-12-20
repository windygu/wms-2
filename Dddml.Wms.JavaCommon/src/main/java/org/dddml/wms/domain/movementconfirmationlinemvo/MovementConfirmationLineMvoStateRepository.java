package org.dddml.wms.domain.movementconfirmationlinemvo;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.movementconfirmation.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface MovementConfirmationLineMvoStateRepository
{
    MovementConfirmationLineMvoState get(MovementConfirmationLineId id, boolean nullAllowed);

    void save(MovementConfirmationLineMvoState state);

}

