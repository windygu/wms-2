package org.dddml.wms.domain.inout;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface InOutImageStates extends Iterable<InOutImageState>, Saveable
{
    InOutImageState get(String sequenceId);

    InOutImageState get(String sequenceId, boolean forCreation);

    InOutImageState get(String sequenceId, boolean forCreation, boolean nullAllowed);

    void remove(InOutImageState state);

    void addToSave(InOutImageState state);

}


