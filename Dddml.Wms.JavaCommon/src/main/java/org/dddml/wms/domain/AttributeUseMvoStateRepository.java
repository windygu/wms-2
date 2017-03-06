package org.dddml.wms.domain;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface AttributeUseMvoStateRepository
{
    AttributeUseMvoState get(AttributeSetAttributeUseId id, boolean nullAllowed);
    
    void save(AttributeUseMvoState state);

}

