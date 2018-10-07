package org.dddml.wms.domain.attribute;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface AttributeValueStates extends Iterable<AttributeValueState>, Saveable
{
    AttributeValueState get(String value);

    //AttributeValueState get(String value, boolean forCreation);

    //AttributeValueState get(String value, boolean forCreation, boolean nullAllowed);

    void remove(AttributeValueState state);

    void add(AttributeValueState state);

}


