package org.dddml.wms.domain.uomconversion;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface UomConversionAggregate
{
    UomConversionState getState();

    List<Event> getChanges();

    void create(UomConversionCommand.CreateUomConversion c);

    void mergePatch(UomConversionCommand.MergePatchUomConversion c);

    void delete(UomConversionCommand.DeleteUomConversion c);

    void throwOnInvalidStateTransition(Command c);
}

