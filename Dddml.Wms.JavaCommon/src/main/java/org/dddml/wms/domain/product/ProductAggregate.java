package org.dddml.wms.domain.product;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ProductAggregate
{
    ProductState getState();

    List<Event> getChanges();

    void create(ProductCommand.CreateProduct c);

    void mergePatch(ProductCommand.MergePatchProduct c);

    void throwOnInvalidStateTransition(Command c);
}

