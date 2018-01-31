package org.dddml.wms.domain.attributesetinstanceextensionfield;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface AttributeSetInstanceExtensionFieldStateRepository
{
    AttributeSetInstanceExtensionFieldState get(String id, boolean nullAllowed);

    void save(AttributeSetInstanceExtensionFieldState state);

}

