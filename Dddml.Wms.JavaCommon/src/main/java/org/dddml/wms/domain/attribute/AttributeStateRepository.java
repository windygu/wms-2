package org.dddml.wms.domain.attribute;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface AttributeStateRepository
{
    AttributeState get(String id, boolean nullAllowed);

    void save(AttributeState state);

}

