package org.dddml.wms.domain.inoutnotice;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface InOutNoticeStateRepository
{
    InOutNoticeState get(String id, boolean nullAllowed);

    void save(InOutNoticeState state);

}

