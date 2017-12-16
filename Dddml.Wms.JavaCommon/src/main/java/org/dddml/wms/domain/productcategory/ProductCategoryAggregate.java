package org.dddml.wms.domain.productcategory;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ProductCategoryAggregate
{
    ProductCategoryState getState();

    List<Event> getChanges();

    void create(ProductCategoryCommand.CreateProductCategory c);

    void mergePatch(ProductCategoryCommand.MergePatchProductCategory c);

    void delete(ProductCategoryCommand.DeleteProductCategory c);

    void throwOnInvalidStateTransition(Command c);
}

