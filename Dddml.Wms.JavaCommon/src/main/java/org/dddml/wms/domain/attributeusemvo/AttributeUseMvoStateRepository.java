package org.dddml.wms.domain.attributeusemvo;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.attributeset.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface AttributeUseMvoStateRepository
{
    AttributeUseMvoState get(AttributeSetAttributeUseId id, boolean nullAllowed);
    
    void save(AttributeUseMvoState state);

}

