package org.dddml.wms.domain.locator;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.locator.LocatorEvent.*;

public interface LocatorState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getLocatorId();

    String getWarehouseId();

    String getParentLocatorId();

    String getLocatorType();

    String getPriorityNumber();

    Boolean getIsDefault();

    String getX();

    String getY();

    String getZ();

    String getDescription();

    String getLocatorTypeId();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    interface MutableLocatorState extends LocatorState {
        void setLocatorId(String locatorId);

        void setWarehouseId(String warehouseId);

        void setParentLocatorId(String parentLocatorId);

        void setLocatorType(String locatorType);

        void setPriorityNumber(String priorityNumber);

        void setIsDefault(Boolean isDefault);

        void setX(String x);

        void setY(String y);

        void setZ(String z);

        void setDescription(String description);

        void setLocatorTypeId(String locatorTypeId);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(LocatorEvent.LocatorStateCreated e);

        void when(LocatorEvent.LocatorStateMergePatched e);

        void when(LocatorEvent.LocatorStateDeleted e);
    }

    interface SqlLocatorState extends MutableLocatorState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

