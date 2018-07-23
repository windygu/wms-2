package org.dddml.wms.domain.inout;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Saveable;

public interface InOutLineImageStates extends Iterable<InOutLineImageState>, Saveable
{
    InOutLineImageState get(String sequenceId);

    InOutLineImageState get(String sequenceId, boolean forCreation);

    InOutLineImageState get(String sequenceId, boolean forCreation, boolean nullAllowed);

    void remove(InOutLineImageState state);

    void addToSave(InOutLineImageState state);

}


