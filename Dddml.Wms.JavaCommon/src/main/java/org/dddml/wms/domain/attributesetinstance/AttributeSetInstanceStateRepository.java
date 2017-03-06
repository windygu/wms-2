package org.dddml.wms.domain.attributesetinstance;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface AttributeSetInstanceStateRepository
{
    AttributeSetInstanceState get(String id, boolean nullAllowed);
    
    void save(AttributeSetInstanceState state);

}

