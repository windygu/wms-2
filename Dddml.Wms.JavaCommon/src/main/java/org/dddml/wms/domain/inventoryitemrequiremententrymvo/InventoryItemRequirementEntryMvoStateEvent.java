package org.dddml.wms.domain.inventoryitemrequiremententrymvo;

import java.util.*;
import org.dddml.wms.domain.inventoryitemrequirement.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface InventoryItemRequirementEntryMvoStateEvent extends Event
{
    InventoryItemRequirementEntryMvoStateEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    BigDecimal getQuantity();

    void setQuantity(BigDecimal quantity);

    InventoryPRTriggeredId getSourceEventId();

    void setSourceEventId(InventoryPRTriggeredId sourceEventId);

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    BigDecimal getInventoryItemRequirementQuantity();

    void setInventoryItemRequirementQuantity(BigDecimal inventoryItemRequirementQuantity);

    String getInventoryItemRequirementCreatedBy();

    void setInventoryItemRequirementCreatedBy(String inventoryItemRequirementCreatedBy);

    Date getInventoryItemRequirementCreatedAt();

    void setInventoryItemRequirementCreatedAt(Date inventoryItemRequirementCreatedAt);

    String getInventoryItemRequirementUpdatedBy();

    void setInventoryItemRequirementUpdatedBy(String inventoryItemRequirementUpdatedBy);

    Date getInventoryItemRequirementUpdatedAt();

    void setInventoryItemRequirementUpdatedAt(Date inventoryItemRequirementUpdatedAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface InventoryItemRequirementEntryMvoStateCreated extends InventoryItemRequirementEntryMvoStateEvent
    {
    
    }


    interface InventoryItemRequirementEntryMvoStateMergePatched extends InventoryItemRequirementEntryMvoStateEvent
    {
        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertySourceEventIdRemoved();

        void setIsPropertySourceEventIdRemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemRequirementQuantityRemoved();

        void setIsPropertyInventoryItemRequirementQuantityRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemRequirementCreatedByRemoved();

        void setIsPropertyInventoryItemRequirementCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemRequirementCreatedAtRemoved();

        void setIsPropertyInventoryItemRequirementCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemRequirementUpdatedByRemoved();

        void setIsPropertyInventoryItemRequirementUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemRequirementUpdatedAtRemoved();

        void setIsPropertyInventoryItemRequirementUpdatedAtRemoved(Boolean removed);


    }


}

