package org.dddml.wms.domain.attribute;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface AttributeValueEventDao
{
    void save(AttributeValueEvent e);

    Iterable<AttributeValueEvent> findByAttributeEventId(AttributeEventId attributeEventId);

}

