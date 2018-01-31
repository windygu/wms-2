package org.dddml.wms.domain.physicalinventory;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface PhysicalInventoryLineStateEvent extends Event
{
    PhysicalInventoryLineStateEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    Long getVersion();

    void setVersion(Long version);

    String getLocatorId();

    void setLocatorId(String locatorId);

    String getProductId();

    void setProductId(String productId);

    String getAttributeSetInstanceId();

    void setAttributeSetInstanceId(String attributeSetInstanceId);

    BigDecimal getBookQuantity();

    void setBookQuantity(BigDecimal bookQuantity);

    BigDecimal getCountedQuantity();

    void setCountedQuantity(BigDecimal countedQuantity);

    Boolean getProcessed();

    void setProcessed(Boolean processed);

    Long getReversalLineNumber();

    void setReversalLineNumber(Long reversalLineNumber);

    String getDescription();

    void setDescription(String description);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface PhysicalInventoryLineStateCreated extends PhysicalInventoryLineStateEvent
    {
    
    }


    interface PhysicalInventoryLineStateMergePatched extends PhysicalInventoryLineStateEvent
    {
        Boolean getIsPropertyLocatorIdRemoved();

        void setIsPropertyLocatorIdRemoved(Boolean removed);

        Boolean getIsPropertyProductIdRemoved();

        void setIsPropertyProductIdRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetInstanceIdRemoved();

        void setIsPropertyAttributeSetInstanceIdRemoved(Boolean removed);

        Boolean getIsPropertyBookQuantityRemoved();

        void setIsPropertyBookQuantityRemoved(Boolean removed);

        Boolean getIsPropertyCountedQuantityRemoved();

        void setIsPropertyCountedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyProcessedRemoved();

        void setIsPropertyProcessedRemoved(Boolean removed);

        Boolean getIsPropertyReversalLineNumberRemoved();

        void setIsPropertyReversalLineNumberRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface PhysicalInventoryLineStateRemoved extends PhysicalInventoryLineStateEvent
    {
    }


}

