package org.dddml.wms.domain.inout;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface InOutImageStateDao
{
    InOutImageState get(InOutImageId id, boolean nullAllowed);

    void save(InOutImageState state);

    Iterable<InOutImageState> findByInOutDocumentNumber(String inOutDocumentNumber);

    void delete(InOutImageState state);
}


