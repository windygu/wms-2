package org.dddml.wms.domain.product;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface GoodIdentificationStateDao
{
    GoodIdentificationState get(ProductGoodIdentificationId id, boolean nullAllowed);

    void save(GoodIdentificationState state);

    Iterable<GoodIdentificationState> findByProductId(String productId);

    void delete(GoodIdentificationState state);
}


