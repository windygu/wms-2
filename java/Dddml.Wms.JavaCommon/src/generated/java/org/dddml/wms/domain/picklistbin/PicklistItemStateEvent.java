package org.dddml.wms.domain.picklistbin;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface PicklistItemStateEvent extends Event
{
    PicklistItemEventId getPicklistItemEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    Long getVersion();

    void setVersion(Long version);

    String getItemStatusId();

    void setItemStatusId(String itemStatusId);

    java.math.BigDecimal getQuantity();

    void setQuantity(java.math.BigDecimal quantity);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface PicklistItemStateCreated extends PicklistItemStateEvent
    {
    
    }


    interface PicklistItemStateMergePatched extends PicklistItemStateEvent
    {
        Boolean getIsPropertyItemStatusIdRemoved();

        void setIsPropertyItemStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface PicklistItemStateRemoved extends PicklistItemStateEvent
    {
    }


}

