package org.dddml.wms.domain.inout;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface InOutLineImageStateDao
{
    InOutLineImageState get(InOutLineImageId id, boolean nullAllowed);

    void save(InOutLineImageState state);

    Iterable<InOutLineImageState> findByInOutDocumentNumberAndInOutLineLineNumber(String inOutDocumentNumber, String inOutLineLineNumber);

    void delete(InOutLineImageState state);
}


