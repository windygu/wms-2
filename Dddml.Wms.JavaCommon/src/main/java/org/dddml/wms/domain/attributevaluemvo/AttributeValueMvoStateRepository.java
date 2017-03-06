package org.dddml.wms.domain.attributevaluemvo;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.attribute.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface AttributeValueMvoStateRepository
{
    AttributeValueMvoState get(AttributeValueId id, boolean nullAllowed);
    
    void save(AttributeValueMvoState state);

}

