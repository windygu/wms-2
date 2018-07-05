package org.dddml.wms.domain.product;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface GoodIdentificationEventDao
{
    void save(GoodIdentificationEvent e);

    Iterable<GoodIdentificationEvent> findByProductEventId(ProductEventId productEventId);

}

