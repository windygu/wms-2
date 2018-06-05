package org.dddml.wms.domain.goodidentificationmvo;

import java.util.List;
import org.dddml.wms.domain.product.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface GoodIdentificationMvoAggregate
{
    GoodIdentificationMvoState getState();

    List<Event> getChanges();

    void create(GoodIdentificationMvoCommand.CreateGoodIdentificationMvo c);

    void mergePatch(GoodIdentificationMvoCommand.MergePatchGoodIdentificationMvo c);

    void delete(GoodIdentificationMvoCommand.DeleteGoodIdentificationMvo c);

    void throwOnInvalidStateTransition(Command c);
}

