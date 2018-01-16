package org.dddml.wms.domain.inventoryitemrequiremententrymvo;

import java.util.Set;
import org.dddml.wms.domain.inventoryitemrequirement.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.inventoryitemrequiremententrymvo.InventoryItemRequirementEntryMvoStateEvent.*;

public interface InventoryItemRequirementEntryMvoState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    InventoryItemRequirementEntryId getInventoryItemRequirementEntryId();

    void setInventoryItemRequirementEntryId(InventoryItemRequirementEntryId inventoryItemRequirementEntryId);

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

    String getUpdatedBy();

    void setUpdatedBy(String updatedBy);

    Date getUpdatedAt();

    void setUpdatedAt(Date updatedAt);

    BigDecimal getInventoryItemRequirementQuantity();

    void setInventoryItemRequirementQuantity(BigDecimal inventoryItemRequirementQuantity);

    Long getInventoryItemRequirementVersion();

    void setInventoryItemRequirementVersion(Long inventoryItemRequirementVersion);

    String getInventoryItemRequirementCreatedBy();

    void setInventoryItemRequirementCreatedBy(String inventoryItemRequirementCreatedBy);

    Date getInventoryItemRequirementCreatedAt();

    void setInventoryItemRequirementCreatedAt(Date inventoryItemRequirementCreatedAt);

    String getInventoryItemRequirementUpdatedBy();

    void setInventoryItemRequirementUpdatedBy(String inventoryItemRequirementUpdatedBy);

    Date getInventoryItemRequirementUpdatedAt();

    void setInventoryItemRequirementUpdatedAt(Date inventoryItemRequirementUpdatedAt);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(InventoryItemRequirementEntryMvoStateEvent.InventoryItemRequirementEntryMvoStateCreated e);

    void when(InventoryItemRequirementEntryMvoStateEvent.InventoryItemRequirementEntryMvoStateMergePatched e);

    
}

