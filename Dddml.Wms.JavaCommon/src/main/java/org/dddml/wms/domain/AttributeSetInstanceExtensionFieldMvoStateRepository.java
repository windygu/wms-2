package org.dddml.wms.domain;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface AttributeSetInstanceExtensionFieldMvoStateRepository
{
    AttributeSetInstanceExtensionFieldMvoState get(AttributeSetInstanceExtensionFieldId id, boolean nullAllowed);
    
    void save(AttributeSetInstanceExtensionFieldMvoState state);

}

