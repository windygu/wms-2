package org.dddml.wms.domain.inventoryitementrymvo;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface InventoryItemEntryMvoStateEvent extends Event
{
    InventoryItemEntryMvoEventId getInventoryItemEntryMvoEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    BigDecimal getOnHandQuantity();

    void setOnHandQuantity(BigDecimal onHandQuantity);

    BigDecimal getInTransitQuantity();

    void setInTransitQuantity(BigDecimal inTransitQuantity);

    BigDecimal getReservedQuantity();

    void setReservedQuantity(BigDecimal reservedQuantity);

    BigDecimal getOccupiedQuantity();

    void setOccupiedQuantity(BigDecimal occupiedQuantity);

    BigDecimal getVirtualQuantity();

    void setVirtualQuantity(BigDecimal virtualQuantity);

    InventoryItemSourceInfo getSource();

    void setSource(InventoryItemSourceInfo source);

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    BigDecimal getInventoryItemOnHandQuantity();

    void setInventoryItemOnHandQuantity(BigDecimal inventoryItemOnHandQuantity);

    BigDecimal getInventoryItemInTransitQuantity();

    void setInventoryItemInTransitQuantity(BigDecimal inventoryItemInTransitQuantity);

    BigDecimal getInventoryItemReservedQuantity();

    void setInventoryItemReservedQuantity(BigDecimal inventoryItemReservedQuantity);

    BigDecimal getInventoryItemOccupiedQuantity();

    void setInventoryItemOccupiedQuantity(BigDecimal inventoryItemOccupiedQuantity);

    BigDecimal getInventoryItemVirtualQuantity();

    void setInventoryItemVirtualQuantity(BigDecimal inventoryItemVirtualQuantity);

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
        Boolean getIsPropertyOnHandQuantityRemoved();

        void setIsPropertyOnHandQuantityRemoved(Boolean removed);

        Boolean getIsPropertyInTransitQuantityRemoved();

        void setIsPropertyInTransitQuantityRemoved(Boolean removed);

        Boolean getIsPropertyReservedQuantityRemoved();

        void setIsPropertyReservedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyOccupiedQuantityRemoved();

        void setIsPropertyOccupiedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyVirtualQuantityRemoved();

        void setIsPropertyVirtualQuantityRemoved(Boolean removed);

        Boolean getIsPropertySourceRemoved();

        void setIsPropertySourceRemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemOnHandQuantityRemoved();

        void setIsPropertyInventoryItemOnHandQuantityRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemInTransitQuantityRemoved();

        void setIsPropertyInventoryItemInTransitQuantityRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemReservedQuantityRemoved();

        void setIsPropertyInventoryItemReservedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemOccupiedQuantityRemoved();

        void setIsPropertyInventoryItemOccupiedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemVirtualQuantityRemoved();

        void setIsPropertyInventoryItemVirtualQuantityRemoved(Boolean removed);

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

