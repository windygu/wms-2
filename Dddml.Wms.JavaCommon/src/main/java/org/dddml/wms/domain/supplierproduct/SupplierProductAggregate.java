package org.dddml.wms.domain.supplierproduct;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface SupplierProductAggregate
{
    SupplierProductState getState();

    List<Event> getChanges();

    void create(SupplierProductCommand.CreateSupplierProduct c);

    void mergePatch(SupplierProductCommand.MergePatchSupplierProduct c);

    void throwOnInvalidStateTransition(Command c);
}

