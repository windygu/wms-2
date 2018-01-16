package org.dddml.wms.domain.attribute;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface AttributeValueStateDao
{
    AttributeValueState get(AttributeValueId id, boolean nullAllowed);

    void save(AttributeValueState state);

    Iterable<AttributeValueState> findByAttributeId(String attributeId);

    void delete(AttributeValueState state);
}


