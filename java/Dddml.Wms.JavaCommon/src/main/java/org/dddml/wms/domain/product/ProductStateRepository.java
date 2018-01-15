package org.dddml.wms.domain.product;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface ProductStateRepository
{
    ProductState get(String id, boolean nullAllowed);

    void save(ProductState state);

}

