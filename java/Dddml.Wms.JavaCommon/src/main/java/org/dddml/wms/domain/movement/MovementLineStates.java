package org.dddml.wms.domain.movement;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface MovementLineStates extends Iterable<MovementLineState>, Saveable
{
    MovementLineState get(String lineNumber);

    MovementLineState get(String lineNumber, boolean forCreation);

    MovementLineState get(String lineNumber, boolean forCreation, boolean nullAllowed);

    void remove(MovementLineState state);

    void addToSave(MovementLineState state);

}


