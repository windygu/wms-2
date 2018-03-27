package org.dddml.wms.domain.itemissuancemvo;

import java.util.List;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ItemIssuanceMvoAggregate
{
    ItemIssuanceMvoState getState();

    List<Event> getChanges();

    void create(ItemIssuanceMvoCommand.CreateItemIssuanceMvo c);

    void mergePatch(ItemIssuanceMvoCommand.MergePatchItemIssuanceMvo c);

    void delete(ItemIssuanceMvoCommand.DeleteItemIssuanceMvo c);

    void throwOnInvalidStateTransition(Command c);
}

