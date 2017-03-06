package org.dddml.wms.domain.attributeset;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface AttributeUseStateEventDao
{
    void save(AttributeUseStateEvent e);

    Iterable<AttributeUseStateEvent> findByAttributeSetStateEventId(AttributeSetStateEventId attributeSetStateEventId);

}

