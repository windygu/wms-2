package org.dddml.wms.domain.attributesetinstanceextensionfieldmvo;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.attributesetinstanceextensionfieldgroup.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface AttributeSetInstanceExtensionFieldMvoStateRepository
{
    AttributeSetInstanceExtensionFieldMvoState get(AttributeSetInstanceExtensionFieldId id, boolean nullAllowed);

    void save(AttributeSetInstanceExtensionFieldMvoState state);

}

