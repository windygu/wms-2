package org.dddml.wms.domain;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface AttributeValueStateEventDao
{
    void save(AttributeValueStateEvent e);

    Iterable<AttributeValueStateEvent> findByAttributeStateEventId(AttributeStateEventId attributeStateEventId);

}

