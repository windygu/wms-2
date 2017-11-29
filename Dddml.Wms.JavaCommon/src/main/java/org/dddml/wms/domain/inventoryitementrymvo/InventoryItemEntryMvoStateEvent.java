package org.dddml.wms.domain.inventoryitementrymvo;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface InventoryItemEntryMvoStateEvent extends Event
{
    InventoryItemEntryMvoStateEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    BigDecimal getQuantityOnHand();

    void setQuantityOnHand(BigDecimal quantityOnHand);

    BigDecimal getQuantityReserved();

    void setQuantityReserved(BigDecimal quantityReserved);

    BigDecimal getQuantityOccupied();

    void setQuantityOccupied(BigDecimal quantityOccupied);

    BigDecimal getQuantityVirtual();

    void setQuantityVirtual(BigDecimal quantityVirtual);

    InventoryItemSourceVO getSource();

    void setSource(InventoryItemSourceVO source);

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    BigDecimal getInventoryItemQuantityOnHand();

    void setInventoryItemQuantityOnHand(BigDecimal inventoryItemQuantityOnHand);

    BigDecimal getInventoryItemQuantityReserved();

    void setInventoryItemQuantityReserved(BigDecimal inventoryItemQuantityReserved);

    BigDecimal getInventoryItemQuantityOccupied();

    void setInventoryItemQuantityOccupied(BigDecimal inventoryItemQuantityOccupied);

    BigDecimal getInventoryItemQuantityVirtual();

    void setInventoryItemQuantityVirtual(BigDecimal inventoryItemQuantityVirtual);

    String getInventoryItemCreatedBy();

    void setInventoryItemCreatedBy(String inventoryItemCreatedBy);

    Date getInventoryItemCreatedAt();

    void setInventoryItemCreatedAt(Date inventoryItemCreatedAt);

    String getInventoryItemUpdatedBy();

    void setInventoryItemUpdatedBy(String inventoryItemUpdatedBy);

    Date getInventoryItemUpdatedAt();

    void setInventoryItemUpdatedAt(Date inventoryItemUpdatedAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface InventoryItemEntryMvoStateCreated extends InventoryItemEntryMvoStateEvent
    {
    
    }


    interface InventoryItemEntryMvoStateMergePatched extends InventoryItemEntryMvoStateEvent
    {
        Boolean getIsPropertyQuantityOnHandRemoved();

        void setIsPropertyQuantityOnHandRemoved(Boolean removed);

        Boolean getIsPropertyQuantityReservedRemoved();

        void setIsPropertyQuantityReservedRemoved(Boolean removed);

        Boolean getIsPropertyQuantityOccupiedRemoved();

        void setIsPropertyQuantityOccupiedRemoved(Boolean removed);

        Boolean getIsPropertyQuantityVirtualRemoved();

        void setIsPropertyQuantityVirtualRemoved(Boolean removed);

        Boolean getIsPropertySourceRemoved();

        void setIsPropertySourceRemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemQuantityOnHandRemoved();

        void setIsPropertyInventoryItemQuantityOnHandRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemQuantityReservedRemoved();

        void setIsPropertyInventoryItemQuantityReservedRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemQuantityOccupiedRemoved();

        void setIsPropertyInventoryItemQuantityOccupiedRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemQuantityVirtualRemoved();

        void setIsPropertyInventoryItemQuantityVirtualRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemCreatedByRemoved();

        void setIsPropertyInventoryItemCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemCreatedAtRemoved();

        void setIsPropertyInventoryItemCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemUpdatedByRemoved();

        void setIsPropertyInventoryItemUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemUpdatedAtRemoved();

        void setIsPropertyInventoryItemUpdatedAtRemoved(Boolean removed);


    }


}

