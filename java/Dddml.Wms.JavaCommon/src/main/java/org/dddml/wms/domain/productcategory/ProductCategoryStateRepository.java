package org.dddml.wms.domain.productcategory;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface ProductCategoryStateRepository
{
    ProductCategoryState get(String id, boolean nullAllowed);

    void save(ProductCategoryState state);

}

