package org.dddml.wms.domain.attributesetinstanceextensionfieldgroup;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface AttributeSetInstanceExtensionFieldGroupStateRepository
{
    AttributeSetInstanceExtensionFieldGroupState get(String id, boolean nullAllowed);
    
    void save(AttributeSetInstanceExtensionFieldGroupState state);

}

