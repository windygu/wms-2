package org.dddml.wms.domain.goodidentificationtype;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface GoodIdentificationTypeAggregate
{
    GoodIdentificationTypeState getState();

    List<Event> getChanges();

    void create(GoodIdentificationTypeCommand.CreateGoodIdentificationType c);

    void mergePatch(GoodIdentificationTypeCommand.MergePatchGoodIdentificationType c);

    void delete(GoodIdentificationTypeCommand.DeleteGoodIdentificationType c);

    void throwOnInvalidStateTransition(Command c);
}

