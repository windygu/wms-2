package org.dddml.wms.domain.attributesetinstanceextensionfieldgroup;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface AttributeSetInstanceExtensionFieldStates extends Iterable<AttributeSetInstanceExtensionFieldState>, Saveable
{
    AttributeSetInstanceExtensionFieldState get(String index);

    AttributeSetInstanceExtensionFieldState get(String index, boolean forCreation);

    AttributeSetInstanceExtensionFieldState get(String index, boolean forCreation, boolean nullAllowed);

    void remove(AttributeSetInstanceExtensionFieldState state);

    void addToSave(AttributeSetInstanceExtensionFieldState state);

}


