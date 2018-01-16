package org.dddml.wms.domain.attributealiasmvo;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.attribute.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface AttributeAliasMvoStateRepository
{
    AttributeAliasMvoState get(AttributeAliasId id, boolean nullAllowed);

    void save(AttributeAliasMvoState state);

}

