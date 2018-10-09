package org.dddml.wms.domain.warehouse;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.warehouse.WarehouseEvent.*;

public interface WarehouseState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getWarehouseId();

    String getWarehouseName();

    String getDescription();

    Boolean getIsInTransit();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    interface MutableWarehouseState extends WarehouseState {
        void setWarehouseId(String warehouseId);

        void setWarehouseName(String warehouseName);

        void setDescription(String description);

        void setIsInTransit(Boolean isInTransit);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(WarehouseEvent.WarehouseStateCreated e);

        void when(WarehouseEvent.WarehouseStateMergePatched e);

        void when(WarehouseEvent.WarehouseStateDeleted e);
    }

    interface SqlWarehouseState extends MutableWarehouseState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

