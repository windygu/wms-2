package org.dddml.wms.domain.inout;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface InOutLineStates extends Iterable<InOutLineState>, Saveable
{
    InOutLineState get(String lineNumber);

    InOutLineState get(String lineNumber, boolean forCreation);

    InOutLineState get(String lineNumber, boolean forCreation, boolean nullAllowed);

    void remove(InOutLineState state);

    void addToSave(InOutLineState state);

}


