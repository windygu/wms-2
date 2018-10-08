package org.dddml.wms.domain.locator;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface LocatorEvent extends Event {

    interface SqlLocatorEvent extends LocatorEvent {
        LocatorEventId getLocatorEventId();
    }

    String getLocatorId();

    //void setLocatorId(String locatorId);

    Long getVersion();
    
    //void getVersion(Long version);

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface LocatorStateEvent extends LocatorEvent {
        String getWarehouseId();

        void setWarehouseId(String warehouseId);

        String getParentLocatorId();

        void setParentLocatorId(String parentLocatorId);

        String getLocatorType();

        void setLocatorType(String locatorType);

        String getPriorityNumber();

        void setPriorityNumber(String priorityNumber);

        Boolean getIsDefault();

        void setIsDefault(Boolean isDefault);

        String getX();

        void setX(String x);

        String getY();

        void setY(String y);

        String getZ();

        void setZ(String z);

        String getDescription();

        void setDescription(String description);

        String getLocatorTypeId();

        void setLocatorTypeId(String locatorTypeId);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface LocatorStateCreated extends LocatorStateEvent
    {
    
    }


    interface LocatorStateMergePatched extends LocatorStateEvent
    {
        Boolean getIsPropertyWarehouseIdRemoved();

        void setIsPropertyWarehouseIdRemoved(Boolean removed);

        Boolean getIsPropertyParentLocatorIdRemoved();

        void setIsPropertyParentLocatorIdRemoved(Boolean removed);

        Boolean getIsPropertyLocatorTypeRemoved();

        void setIsPropertyLocatorTypeRemoved(Boolean removed);

        Boolean getIsPropertyPriorityNumberRemoved();

        void setIsPropertyPriorityNumberRemoved(Boolean removed);

        Boolean getIsPropertyIsDefaultRemoved();

        void setIsPropertyIsDefaultRemoved(Boolean removed);

        Boolean getIsPropertyXRemoved();

        void setIsPropertyXRemoved(Boolean removed);

        Boolean getIsPropertyYRemoved();

        void setIsPropertyYRemoved(Boolean removed);

        Boolean getIsPropertyZRemoved();

        void setIsPropertyZRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyLocatorTypeIdRemoved();

        void setIsPropertyLocatorTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface LocatorStateDeleted extends LocatorStateEvent
    {
    }


}

