package org.dddml.wms.domain.supplierproduct;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface SupplierProductStateRepository
{
    SupplierProductState get(SupplierProductId id, boolean nullAllowed);

    void save(SupplierProductState state);

}

