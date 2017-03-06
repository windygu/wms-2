package org.dddml.wms.domain;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface AttributeSetInstanceExtensionFieldStateDao
{
    AttributeSetInstanceExtensionFieldState get(AttributeSetInstanceExtensionFieldId id, boolean nullAllowed);

    void save(AttributeSetInstanceExtensionFieldState state);

    Iterable<AttributeSetInstanceExtensionFieldState> findByGroupId(String groupId);

    void delete(AttributeSetInstanceExtensionFieldState state);
}


