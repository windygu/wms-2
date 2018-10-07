package org.dddml.wms.domain.attributeset;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface AttributeUseStates extends Iterable<AttributeUseState>, Saveable
{
    AttributeUseState get(String attributeId);

    //AttributeUseState get(String attributeId, boolean forCreation);

    //AttributeUseState get(String attributeId, boolean forCreation, boolean nullAllowed);

    void remove(AttributeUseState state);

    void add(AttributeUseState state);

}


