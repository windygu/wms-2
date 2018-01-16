package org.dddml.wms.domain.party;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface PartyStateRepository
{
    PartyState get(String id, boolean nullAllowed);

    PartyState get(Class<? extends PartyState> type, String id, boolean nullAllowed);

    void save(PartyState state);

}

