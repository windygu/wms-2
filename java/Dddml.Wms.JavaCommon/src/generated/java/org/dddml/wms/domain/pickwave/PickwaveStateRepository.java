package org.dddml.wms.domain.pickwave;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface PickwaveStateRepository
{
    PickwaveState get(Long id, boolean nullAllowed);

    void save(PickwaveState state);

}

