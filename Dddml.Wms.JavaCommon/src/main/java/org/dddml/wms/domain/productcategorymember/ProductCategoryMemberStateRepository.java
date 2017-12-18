package org.dddml.wms.domain.productcategorymember;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface ProductCategoryMemberStateRepository
{
    ProductCategoryMemberState get(ProductCategoryMemberId id, boolean nullAllowed);

    void save(ProductCategoryMemberState state);

}

