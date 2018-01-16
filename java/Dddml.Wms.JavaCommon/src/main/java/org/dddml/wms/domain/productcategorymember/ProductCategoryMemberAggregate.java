package org.dddml.wms.domain.productcategorymember;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ProductCategoryMemberAggregate
{
    ProductCategoryMemberState getState();

    List<Event> getChanges();

    void create(ProductCategoryMemberCommand.CreateProductCategoryMember c);

    void mergePatch(ProductCategoryMemberCommand.MergePatchProductCategoryMember c);

    void throwOnInvalidStateTransition(Command c);
}

