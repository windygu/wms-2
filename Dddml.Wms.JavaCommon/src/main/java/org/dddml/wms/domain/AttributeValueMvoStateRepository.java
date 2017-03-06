package org.dddml.wms.domain;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface AttributeValueMvoStateRepository
{
    AttributeValueMvoState get(AttributeValueId id, boolean nullAllowed);
    
    void save(AttributeValueMvoState state);

}

