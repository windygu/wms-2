package org.dddml.wms.domain.attribute;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface AttributeAliasEventDao
{
    void save(AttributeAliasEvent e);

    Iterable<AttributeAliasEvent> findByAttributeEventId(AttributeEventId attributeEventId);

}

