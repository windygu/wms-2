package org.dddml.wms.domain.attribute;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface AttributeAliasStateEventDao
{
    void save(AttributeAliasStateEvent e);

    Iterable<AttributeAliasStateEvent> findByAttributeEventId(AttributeEventId attributeEventId);

}

