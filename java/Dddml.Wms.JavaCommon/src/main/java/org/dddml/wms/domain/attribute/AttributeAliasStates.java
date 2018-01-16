package org.dddml.wms.domain.attribute;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface AttributeAliasStates extends Iterable<AttributeAliasState>, Saveable
{
    AttributeAliasState get(String code);

    AttributeAliasState get(String code, boolean forCreation);

    AttributeAliasState get(String code, boolean forCreation, boolean nullAllowed);

    void remove(AttributeAliasState state);

    void addToSave(AttributeAliasState state);

}


