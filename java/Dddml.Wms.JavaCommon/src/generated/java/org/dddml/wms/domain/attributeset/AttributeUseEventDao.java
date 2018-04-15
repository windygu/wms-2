package org.dddml.wms.domain.attributeset;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface AttributeUseEventDao
{
    void save(AttributeUseEvent e);

    Iterable<AttributeUseEvent> findByAttributeSetEventId(AttributeSetEventId attributeSetEventId);

}

