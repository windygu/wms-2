package org.dddml.wms.domain.physicalinventory;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface PhysicalInventoryLineEvent extends Event
{
    PhysicalInventoryLineEventId getPhysicalInventoryLineEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface PhysicalInventoryLineStateEvent extends PhysicalInventoryLineEvent {
        Long getVersion();

        void setVersion(Long version);

        BigDecimal getBookQuantity();

        void setBookQuantity(BigDecimal bookQuantity);

        BigDecimal getCountedQuantity();

        void setCountedQuantity(BigDecimal countedQuantity);

        Boolean getProcessed();

        void setProcessed(Boolean processed);

        String getLineNumber();

        void setLineNumber(String lineNumber);

        String getReversalLineNumber();

        void setReversalLineNumber(String reversalLineNumber);

        String getDescription();

        void setDescription(String description);

    }

    interface PhysicalInventoryLineStateCreated extends PhysicalInventoryLineStateEvent
    {
    
    }


    interface PhysicalInventoryLineStateMergePatched extends PhysicalInventoryLineStateEvent
    {
        Boolean getIsPropertyBookQuantityRemoved();

        void setIsPropertyBookQuantityRemoved(Boolean removed);

        Boolean getIsPropertyCountedQuantityRemoved();

        void setIsPropertyCountedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyProcessedRemoved();

        void setIsPropertyProcessedRemoved(Boolean removed);

        Boolean getIsPropertyLineNumberRemoved();

        void setIsPropertyLineNumberRemoved(Boolean removed);

        Boolean getIsPropertyReversalLineNumberRemoved();

        void setIsPropertyReversalLineNumberRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);


    }

    interface PhysicalInventoryLineStateRemoved extends PhysicalInventoryLineStateEvent
    {
    }


}

