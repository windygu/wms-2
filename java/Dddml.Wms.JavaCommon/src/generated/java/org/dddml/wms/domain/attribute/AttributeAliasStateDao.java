package org.dddml.wms.domain.attribute;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface AttributeAliasStateDao
{
    AttributeAliasState get(AttributeAliasId id, boolean nullAllowed);

    void save(AttributeAliasState state);

    Iterable<AttributeAliasState> findByAttributeId(String attributeId);

    void delete(AttributeAliasState state);
}


