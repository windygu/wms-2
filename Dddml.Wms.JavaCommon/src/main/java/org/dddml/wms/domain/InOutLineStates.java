package org.dddml.wms.domain;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface InOutLineStates extends Iterable<InOutLineState>, Saveable
{
    InOutLineState get(Long lineNumber);

    InOutLineState get(Long lineNumber, boolean forCreation);

    InOutLineState get(Long lineNumber, boolean forCreation, boolean nullAllowed);

    void remove(InOutLineState state);

    void addToSave(InOutLineState state);

}


