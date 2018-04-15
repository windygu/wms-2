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

    void setWarehouseId(String warehouseId);

    String getWarehouseName();

    void setWarehouseName(String warehouseName);

    String getDescription();

    void setDescription(String description);

    Boolean getIsInTransit();

    void setIsInTransit(Boolean isInTransit);

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getUpdatedBy();

    void setUpdatedBy(String updatedBy);

    Date getUpdatedAt();

    void setUpdatedAt(Date updatedAt);

    Boolean getActive();

    void setActive(Boolean active);

    Boolean getDeleted();

    void setDeleted(Boolean deleted);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(WarehouseEvent.WarehouseStateCreated e);

    void when(WarehouseEvent.WarehouseStateMergePatched e);

    void when(WarehouseEvent.WarehouseStateDeleted e);
    
}

