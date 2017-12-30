package org.dddml.wms.domain.uomconversion;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface UomConversionStateRepository
{
    UomConversionState get(UomConversionId id, boolean nullAllowed);

    void save(UomConversionState state);

}

