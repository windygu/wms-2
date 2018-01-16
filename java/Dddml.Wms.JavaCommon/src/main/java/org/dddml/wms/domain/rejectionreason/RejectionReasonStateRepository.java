package org.dddml.wms.domain.rejectionreason;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface RejectionReasonStateRepository
{
    RejectionReasonState get(String id, boolean nullAllowed);

    void save(RejectionReasonState state);

}

