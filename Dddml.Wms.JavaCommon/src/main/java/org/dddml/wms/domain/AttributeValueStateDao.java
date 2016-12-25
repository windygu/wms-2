package org.dddml.wms.domain;

import java.util.Date;

public interface AttributeValueStateDao
{
    AttributeValueState get(AttributeValueId id);

    AttributeValueState get(AttributeValueId id, boolean nullAllowed);

    void save(AttributeValueState state);

    Iterable<AttributeValueState> findByAttributeId(String attributeId);

    void delete(AttributeValueState state);
}


